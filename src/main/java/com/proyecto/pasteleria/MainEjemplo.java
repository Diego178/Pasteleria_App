package com.proyecto.pasteleria;

import com.proyecto.pasteleria.Graficas.PantallaGraficas;
import com.proyecto.pasteleria.Login.Login;
import com.proyecto.pasteleria.PantallaAgregarPastel.PantallaAgregarPastel;
import com.proyecto.pasteleria.Pedidos.PantallaPedidos;
import com.proyecto.pasteleria.PedidosPendientes.PantallaPedidosPendientes;
import com.proyecto.pasteleria.Venta.PantallaVenta;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainEjemplo extends Application {
    @Override
    public void start(Stage stage){
        //Pane root = new Login(stage);
        //Scene scene = new Scene(root, 900, 500);
        Stage stage1 = new Stage();
        Pane menu = new PantallaGraficas();
        Scene scene = new Scene(menu, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Graficas");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}