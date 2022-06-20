package com.proyecto.pasteleria.Venta;

import com.proyecto.pasteleria.Conexion.Pasteles;
import com.proyecto.pasteleria.Modelos.Pastel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

public class TablaInventario {
    private TableView<Pastel> tablaInventario = new TableView<>();
    private ObservableList<Pastel> pastelesInventario = FXCollections.observableArrayList();
    private TablaAgregados tablaAgregados;
    private Label lTotal;
    public TablaInventario(Label lTotal){
        this.lTotal=lTotal;
        Pasteles listaHelper = new Pasteles();
        listaHelper.crearLista();
        pastelesInventario.addAll(listaHelper.getListaPasteles());
        tablaInventario = new TableView<>();
        tablaInventario.getStyleClass().add("table-cell");
        tablaInventario.setPrefWidth(700);
        crearTabla();
    }

    private void crearTabla() {
        tablaInventario.setItems(pastelesInventario);
        TableColumn<Pastel, String> colId= new TableColumn<Pastel,String>("ID");
        TableColumn<Pastel, String> colTipoPan= new TableColumn<Pastel,String>("Tipo Pan");
        TableColumn<Pastel, String> colRelleno = new TableColumn<Pastel,String>("Relleno");
        TableColumn<Pastel, Double> colPrecio = new TableColumn<Pastel,Double>("Precio");
        TableColumn<Pastel, Void> colColor = new TableColumn<Pastel,Void>("Color");
        TableColumn<Pastel, Void> colAgregar = new TableColumn<Pastel,Void>("Agregar");

        colAgregar.setPrefWidth(130);
        colTipoPan.setPrefWidth(120);
        colRelleno.setPrefWidth(120);
        colPrecio.setPrefWidth(120);
        colColor.setPrefWidth(100);

        colId.setCellValueFactory(new PropertyValueFactory<Pastel,String>("id"));
        colTipoPan.setCellValueFactory(new PropertyValueFactory<Pastel,String>("tipoPan"));
        colRelleno.setCellValueFactory(new PropertyValueFactory<Pastel,String>("relleno"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<Pastel,Double>("precio"));

        Callback<TableColumn<Pastel,Void>, TableCell<Pastel,Void>> cellFactory1 = new Callback<TableColumn<Pastel, Void>, TableCell<Pastel, Void>>() {
            @Override
            public TableCell<Pastel,Void>  call(final TableColumn<Pastel,Void> param) {
                final TableCell<Pastel,Void> cell1 = new TableCell<Pastel,Void>(){
                    final Button boton =new Button("Agregar");
                    {
                        boton.setOnAction(evt->{
                            tablaAgregados.setPastel(getTableView().getItems().get(getIndex()));
                            getTableView().getItems().remove(getIndex());
                            lTotal.setText("Total: $"+tablaAgregados.getTotal());
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
                return  cell1;
            }
        };

        Callback<TableColumn<Pastel,Void>, TableCell<Pastel,Void>> cellFactory2 = new Callback<TableColumn<Pastel, Void>, TableCell<Pastel, Void>>() {
            @Override
            public TableCell<Pastel,Void>  call(final TableColumn<Pastel,Void> param) {
                final TableCell<Pastel,Void> cell2 = new TableCell<Pastel,Void>(){
                    final Rectangle color = new Rectangle();
                    {

                        color.setWidth(80);
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

        colAgregar.setCellFactory(cellFactory1);
        colColor.setCellFactory(cellFactory2);
        tablaInventario.getColumns().addAll(colId,colTipoPan, colColor, colRelleno, colPrecio);
        tablaInventario.getColumns().add(colAgregar);
    }

    public TableView<Pastel> getTablaInventario(){
        return tablaInventario;
    }

    public Pastel getPastel(int index){
        return tablaInventario.getItems().get(index);
    }

    public void setTablaAgregados(TablaAgregados tablaAgregados) {
        this.tablaAgregados=tablaAgregados;
    }

    public void setPastel(Pastel pastel){
        pastelesInventario.add(pastel);
    }
}
