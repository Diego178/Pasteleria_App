package com.proyecto.pasteleria.Venta;

import com.proyecto.pasteleria.Conexion.Pasteles;
import com.proyecto.pasteleria.Modelos.Pastel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

public class TablaAgregados {
    private TableView<Pastel> tablaAgregados = new TableView<>();
    private ObservableList<Pastel> pastelesAgregados = FXCollections.observableArrayList();
    private TablaInventario tablaInventario;
    public TablaAgregados(){
        tablaAgregados = new TableView<>();
        tablaAgregados.getStyleClass().add("table-cell");
        tablaAgregados.setPrefWidth(700);
        crearTabla();
    }

    private void crearTabla() {
        tablaAgregados.setItems(pastelesAgregados);
        TableColumn<Pastel, String> colId= new TableColumn<Pastel,String>("ID");
        TableColumn<Pastel, String> colTipoPan= new TableColumn<Pastel,String>("Tipo Pan");
        TableColumn<Pastel, Double> colPrecio = new TableColumn<Pastel,Double>("Precio");
        TableColumn<Pastel, Void> colColor = new TableColumn<Pastel,Void>("Color");
        TableColumn<Pastel, Void> colEliminar = new TableColumn<Pastel,Void>("Eliminar");

        colEliminar.setPrefWidth(130);
        colTipoPan.setPrefWidth(120);
        colPrecio.setPrefWidth(120);
        colColor.setPrefWidth(100);

        colId.setCellValueFactory(new PropertyValueFactory<Pastel,String>("id"));
        colTipoPan.setCellValueFactory(new PropertyValueFactory<Pastel,String>("tipoPan"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<Pastel,Double>("precio"));


        Callback<TableColumn<Pastel,Void>, TableCell<Pastel,Void>> cellFactory1 = new Callback<TableColumn<Pastel, Void>, TableCell<Pastel, Void>>() {
            @Override
            public TableCell<Pastel,Void>  call(final TableColumn<Pastel,Void> param) {
                final TableCell<Pastel,Void> cell1 = new TableCell<Pastel,Void>(){
                    final Button boton =new Button("Eliminar");
                    {
                        boton.setOnAction(evt->{
                            tablaInventario.setPastel(getTableView().getItems().get(getIndex()));
                            getTableView().getItems().remove(getIndex());
                            //Pastel pastel = getTableView().getItems().get(getIndex());
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

        colEliminar.setCellFactory(cellFactory1);
        colColor.setCellFactory(cellFactory2);
        tablaAgregados.getColumns().addAll(colId,colTipoPan, colColor, colPrecio);
        tablaAgregados.getColumns().add(colEliminar);
    }

    public TableView<Pastel> getTablaAgregados(){
        return tablaAgregados;
    }

    public void setTablaInventario(TablaInventario tablaInventario) {
        this.tablaInventario=tablaInventario;
    }

    public void setPastel(Pastel pastel){
        pastelesAgregados.add(pastel);
    }
}
