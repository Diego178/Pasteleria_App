package com.proyecto.pasteleria.AgregarPastel;

import com.proyecto.pasteleria.Modelos.Pastel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

import java.util.List;

public class TablaPasteles {
    private TableView tablaPasteles;
    private ObservableList<Pastel> pasteles= FXCollections.observableArrayList();
    private Pastel pastel;
    private Label lTotal;
    public TablaPasteles(Label lTotal){
        this.lTotal=lTotal;
        tablaPasteles = new TableView<>();
        tablaPasteles.getStyleClass().add("table-cell");
        tablaPasteles.setPrefWidth(700);
        crearTabla();
    }

    public void crearTabla() {
        tablaPasteles.setItems(pasteles);
        TableColumn<Pastel, String> colTipoPan= new TableColumn<Pastel,String>("Tipo Pan");
        TableColumn<Pastel, String> colTamano = new TableColumn<Pastel,String>("Tamaño");
        TableColumn<Pastel, String> colRelleno = new TableColumn<Pastel,String>("Relleno");
        TableColumn<Pastel, Void> colColor = new TableColumn<Pastel,Void>("Color");
        TableColumn<Pastel, Double> colPrecio = new TableColumn<Pastel,Double>("Precio");
        TableColumn<Pastel, Void> colEliminar = new TableColumn<Pastel,Void>("Eliminar");

        colEliminar.setPrefWidth(130);
        colTipoPan.setPrefWidth(120);
        colTamano.setPrefWidth(120);
        colRelleno.setPrefWidth(120);
        colColor.setPrefWidth(80);
        colPrecio.setPrefWidth(110);

        colTipoPan.setCellValueFactory(new PropertyValueFactory<Pastel,String>("tipoPan"));
        colTamano.setCellValueFactory(new PropertyValueFactory<Pastel, String>("tamano"));
        colRelleno.setCellValueFactory(new PropertyValueFactory<Pastel,String>("relleno"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<Pastel,Double>("precio"));
        Callback<TableColumn<Pastel,Void>, TableCell<Pastel,Void>> cellFactory = new Callback<TableColumn<Pastel, Void>, TableCell<Pastel, Void>>() {
            @Override
            public TableCell<Pastel,Void>  call(final TableColumn<Pastel,Void> param) {
                final TableCell<Pastel,Void> cell = new TableCell<Pastel,Void>(){
                    final Button boton =new Button("Eliminar");
                    {
                        boton.setOnAction(evt->{
                            getTableView().getItems().remove(getIndex());
                        });
                        boton.setPrefWidth(80);
                        boton.setPrefHeight(10);
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(boton);
                        }
                    }


                };
                return  cell;
            }
        };

        Callback<TableColumn<Pastel,Void>, TableCell<Pastel,Void>> cellFactory2 = new Callback<TableColumn<Pastel, Void>, TableCell<Pastel, Void>>() {
            @Override
            public TableCell<Pastel,Void>  call(final TableColumn<Pastel,Void> param) {
                final TableCell<Pastel,Void> cell2 = new TableCell<Pastel,Void>(){
                    final Rectangle color = new Rectangle();
                    {

                        color.setWidth(70);
                        color.setHeight(10);
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            String Scolor=getTableView().getItems().get(getIndex()).getColor();color.setFill(Color.web(Scolor));
                            color.setFill(Color.web(Scolor));
                            setGraphic(color);
                        }
                    }


                };
                return  cell2;
            }
        };

        colEliminar.setCellFactory(cellFactory);
        colColor.setCellFactory(cellFactory2);
        tablaPasteles.getColumns().addAll(colTipoPan,colTamano,colRelleno, colColor,
                colPrecio);
        tablaPasteles.getColumns().add(colEliminar);
    }

    public void agregarPastel(Pastel pastel){
        pasteles.add(pastel);
    }
    public void agregarPasteles(List<Pastel> listaPasteles){
        for(int i = 0; i<listaPasteles.size(); i++){
            pasteles.add(listaPasteles.get(i));
        }

    }

    public TableView getTablaPasteles(){
        return tablaPasteles;
    }

    public int total(){
        int total=0;
        for(int i=0; i<pasteles.size();i++){
            total+=pasteles.get(i).getPrecio();
        }
        return total;
    }

}
