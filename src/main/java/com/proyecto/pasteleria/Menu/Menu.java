package com.proyecto.pasteleria.Menu;

import com.proyecto.pasteleria.AgregarPastel.AgregarPastel;
import com.proyecto.pasteleria.Graficas.PantallaGraficas;
import com.proyecto.pasteleria.Login.Login;
import com.proyecto.pasteleria.PantallaAgregarPastel.PantallaAgregarPastel;
import com.proyecto.pasteleria.Pedidos.PantallaPedidos;
import com.proyecto.pasteleria.PedidosPendientes.PantallaPedidosPendientes;
import com.proyecto.pasteleria.Venta.PantallaVenta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu extends BorderPane {
    Label titulo,lb1,lb2,lb3,lb4,lb5,lb6;
    GridPane menu;

    public Menu(Stage stage){
        titulo = new Label("Bienvenido");
        titulo.getStyleClass().add("label-titulo-Grande");
        titulo.setLayoutX(430);
        titulo.setLayoutY(40);

        menu = new GridPane();


//1
        Button butGrafica = new Button();
        butGrafica.setOnAction(evtm -> {
            crearVentanaGrafica();
        });
        Image igrafica = new Image(getClass().getResourceAsStream("Grafica.jpeg"));
        butGrafica.setGraphic(new ImageView(igrafica));
        butGrafica.setLayoutX(50);
        butGrafica.setLayoutY(100);
        butGrafica.getStyleClass().add("cssBoton");
        lb1 = new Label("Graficas");
//2

        Button butVenta = new Button();
        butVenta.setOnAction(evtm -> {
            crearVentanaVenta();
        });
        Image inuevaVenta = new Image(getClass().getResourceAsStream("Venta.jpeg"));
        butVenta.setGraphic(new ImageView(inuevaVenta));
        butVenta.setMaxSize(2,2);
        butVenta.setLayoutX(300);
        butVenta.setLayoutY(100);
        butVenta.getStyleClass().add("cssBoton");
        lb2 = new Label("Generar venta");
//3
        Button butPedido = new Button();
        butPedido.setOnAction(evtm -> {
            crearVentanaPedido();
        });
        Image iagregarPedido = new Image(getClass().getResourceAsStream("AgregarPedido.jpeg"));
       butPedido.setGraphic(new ImageView(iagregarPedido));
        butPedido.setMaxSize(2,2);
        butPedido.setLayoutX(620);
        butPedido.setLayoutY(100);
        butPedido.getStyleClass().add("cssBoton");
        lb3 = new Label("Agregar pedido");
//4

        Button butAgregar = new Button();
        Image iagregarPastel = new Image(getClass().getResourceAsStream("AgregarPastel.jpeg"));
        butAgregar.setGraphic(new ImageView(iagregarPastel));
        butAgregar.setMaxSize(2,2);
        butAgregar.setLayoutX(50);
        butAgregar.setLayoutY(300);
        butAgregar.getStyleClass().add("cssBoton");
        lb4 = new Label("Agregar pasteles");
        butAgregar.setOnAction(evtm->{
            crearVentanaAgregarPastel();
        });
//5
        Button butPendiente = new Button();
        butPendiente.setOnAction(evtm -> {
            System.out.println("OK clicked5.");
        });
        Image ipedidoPendiente = new Image(getClass().getResourceAsStream("PedidoPendiente.jpeg"));
        butPendiente.setGraphic(new ImageView(ipedidoPendiente));
        butPendiente.setMaxSize(2,2);
        //button1.setMinSize(5,5);
        butPendiente.setLayoutX(300);
        butPendiente.setLayoutY(300);
        butPendiente.getStyleClass().add("cssBoton");
        lb5 = new Label("Pedidos pendientes");

        butPendiente.setOnAction(evtm->{
            crearVentanaPedidosPendientes();
        });
//6
        Button butSalir = new Button();
        butSalir.setOnAction(evt -> {
            stage.close();
        });
        Image isalir = new Image(getClass().getResourceAsStream("Salir.jpeg"));
        butSalir.setGraphic(new ImageView(isalir));
        butSalir.setMaxSize(5,5);
        //button6.setMinSize(5,5);
        butSalir.setLayoutX(620);
        butSalir.setLayoutY(300);
        butSalir.getStyleClass().add("cssBoton");
        lb6 = new Label("Salir");

        menu.add(butGrafica,  1, 1);
        menu.add(lb1, 1, 2);
        menu.add(butVenta, 2, 1);
        menu.add(lb2, 2, 2);
        menu.add(butPedido, 3,1);
        menu.add(lb3, 3, 2);
        menu.add(butAgregar, 1,  3);
        menu.add(lb4, 1,  4);
        menu.add(butPendiente, 2,  3);
        menu.add(lb5, 2,  4);
        menu.add(butSalir, 3,  3);
        menu.add(lb6, 3,  4);

        titulo.setPrefHeight(70);
        titulo.setAlignment(Pos.CENTER);
        this.setTop(titulo);
        menu.setAlignment(Pos.CENTER);
        this.setCenter(menu);

        titulo.setPadding(new Insets(20,20,20,650));

        menu.setVgap(20);
        menu.setHgap(20);



    }

    private void crearVentanaGrafica() {
        Stage stage = new Stage();
        Pane menu = new PantallaGraficas();
        Scene scene = new Scene(menu, 1050, 700);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Pedidos pendientes");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void crearVentanaPedidosPendientes() {
        Stage stage = new Stage();
        Pane menu = new PantallaPedidosPendientes();
        Scene scene = new Scene(menu, 1050, 700);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Pedidos pendientes");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void crearVentanaAgregarPastel() {
        Stage stage = new Stage();
        Pane menu = new PantallaAgregarPastel(stage);
        Scene scene = new Scene(menu, 1000, 700);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Agregar Pastel");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void crearVentanaPedido() {
        Stage stage = new Stage();
        Pane menu = new PantallaPedidos();
        Scene scene = new Scene(menu, 1200, 700);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Pedido");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void crearVentanaVenta() {
        Stage stage = new Stage();
        Pane menu = new PantallaVenta(stage);
        Scene scene = new Scene(menu, 1250, 700);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
