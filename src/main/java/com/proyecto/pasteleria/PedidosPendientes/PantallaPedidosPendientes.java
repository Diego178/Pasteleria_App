package com.proyecto.pasteleria.PedidosPendientes;

import com.proyecto.pasteleria.Modelos.Pedido;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PantallaPedidosPendientes extends BorderPane {
    private Label lTitulo;
    TablaPendientes tablaPendientes;
    public PantallaPedidosPendientes(){
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        tablaPendientes = new TablaPendientes();
        TableView<Pedido> tablaPendientes1= tablaPendientes.getTablaPendientes();
        tablaPendientes1.setMaxWidth(1050);
        setAlignment(tablaPendientes1, Pos.CENTER);

        tablaPendientes1.setOnMouseClicked(evtm->{
            if(evtm.getClickCount()==2){
                String id=tablaPendientes1.getItems().get(tablaPendientes1.getSelectionModel().getSelectedIndex()).getId();
                crearPantallaDetalles(id);
            }
        });

        lTitulo = new Label("Pedidos Pendientes");
        lTitulo.getStyleClass().add("label-titulo");
        setAlignment(lTitulo, Pos.CENTER);
        setTop(lTitulo);
        setCenter(tablaPendientes1);
    }

    private void crearPantallaDetalles(String id) {
        Stage stage = new Stage();
        Pane pantalla = new PantalleDetallesPedido(id);
        Scene scene = new Scene(pantalla, 800, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Detalles pedido");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
