package com.proyecto.pasteleria.PedidosPendientes;

import com.proyecto.pasteleria.Conexion.Pasteles;
import com.proyecto.pasteleria.Conexion.Pedidos;
import com.proyecto.pasteleria.Modelos.Pastel;
import com.proyecto.pasteleria.Modelos.Pedido;
import com.proyecto.pasteleria.Venta.TablaAgregados;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Timer;

public class TablaPendientes {
    private TableView<Pedido> tablaPedidos = new TableView<>();
    private ObservableList<Pedido> pedidosPendientes = FXCollections.observableArrayList();
    public TablaPendientes(){
        Pedidos listaHelper = new Pedidos();
        listaHelper.crearLista();
        pedidosPendientes.addAll(listaHelper.getListaPedidos());
        tablaPedidos = new TableView<>();
        tablaPedidos.getStyleClass().add("table-cell");
        tablaPedidos.setPrefWidth(700);
        crearTabla();
    }

    private void crearTabla() {
        tablaPedidos.setItems(pedidosPendientes);
        TableColumn<Pedido, String> colId= new TableColumn<Pedido,String>("ID");
        TableColumn<Pedido, String> colNomCliente= new TableColumn<Pedido,String>("Nombre del cliente");
        TableColumn<Pedido, Date> colFechaPed = new TableColumn<Pedido, Date>("Fecha de pedido");
        TableColumn<Pedido, Date> colFechaEntr = new TableColumn<Pedido, Date>("Fecha de entrega");
        TableColumn<Pedido, Time> colHoraEntr = new TableColumn<Pedido, Time>("Hora de entrega");
        TableColumn<Pedido, Double> colTotal = new TableColumn<Pedido, Double>("Total");

        colId.setPrefWidth(120);
        colNomCliente.setPrefWidth(220);
        colFechaPed.setPrefWidth(200);
        colFechaEntr.setPrefWidth(200);
        colHoraEntr.setPrefWidth(200);
        colTotal.setPrefWidth(100);

        colId.setCellValueFactory(new PropertyValueFactory<Pedido,String>("id"));
        colNomCliente.setCellValueFactory(new PropertyValueFactory<Pedido,String>("nombre"));
        colFechaPed.setCellValueFactory(new PropertyValueFactory<Pedido,Date>("fechaPedido"));
        colFechaEntr.setCellValueFactory(new PropertyValueFactory<Pedido,Date>("fechaEntrega"));
        colHoraEntr.setCellValueFactory(new PropertyValueFactory<Pedido,Time>("horaEntrega"));
        colTotal.setCellValueFactory(new PropertyValueFactory<Pedido,Double>("total"));

        /*Callback<TableColumn<Pastel,Void>, TableCell<Pastel,Void>> cellFactory1 = new Callback<TableColumn<Pastel, Void>, TableCell<Pastel, Void>>() {
            @Override
            public TableCell<Pastel,Void>  call(final TableColumn<Pastel,Void> param) {
                final TableCell<Pastel,Void> cell1 = new TableCell<Pastel,Void>(){
                    final Button boton =new Button("Agregar");
                    {
                        boton.setOnAction(evt->{
                            tablaAgregados.setPastel(getTableView().getItems().get(getIndex()));
                            getTableView().getItems().remove(getIndex());
                            //lTotal.setText("Total: $"+tablaAgregados.getTotal());
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
        };*/

        tablaPedidos.getColumns().addAll(colId,colNomCliente, colFechaPed, colFechaEntr, colHoraEntr, colTotal);
    }
    public void agregarPedidos(List<Pedido> listaPedidos){
        for(int i = 0; i<listaPedidos.size(); i++){
            pedidosPendientes.add(listaPedidos.get(i));
        }

    }

    public TableView<Pedido> getTablaPendientes(){
        return tablaPedidos;
    }

    public Pedido getPastel(int index){
        return tablaPedidos.getItems().get(index);
    }

    public void setPedido(Pedido pedido){
        pedidosPendientes.add(pedido);
    }
}
