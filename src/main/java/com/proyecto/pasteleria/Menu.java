package com.proyecto.pasteleria;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        butGrafica.setOnAction(e -> {
            System.out.println("OK clicked1.");
        });
        butGrafica.setGraphic(new ImageView("C:\\Users\\diego\\IdeaProjects\\Pasteleria\\src\\main\\resources\\com\\proyecto\\pasteleria\\Grafica.jpeg"));
        butGrafica.setLayoutX(50);
        butGrafica.setLayoutY(100);
        butGrafica.getStyleClass().add("cssBoton");
        lb1 = new Label("Graficas");

//2
        Button butVenta = new Button();
        butVenta.setOnAction(e -> {
            System.out.println("OK clicked2.");
        });
        butVenta.setGraphic(new ImageView("C:\\Users\\diego\\IdeaProjects\\Pasteleria\\src\\main\\resources\\com\\proyecto\\pasteleria\\Venta.jpeg"));
        butVenta.setMaxSize(2,2);
        butVenta.setLayoutX(300);
        butVenta.setLayoutY(100);
        butVenta.getStyleClass().add("cssBoton");
        lb2 = new Label("Ventas");
//3
        Button butPedido = new Button();
        butPedido.setOnAction(e -> {
            System.out.println("OK clicked3.");
        });
       butPedido.setGraphic(new ImageView("C:\\Users\\diego\\IdeaProjects\\Pasteleria\\src\\main\\resources\\com\\proyecto\\pasteleria\\AgregarPedido.jpeg"));
        butPedido.setMaxSize(2,2);
        butPedido.setLayoutX(620);
        butPedido.setLayoutY(100);
        butPedido.getStyleClass().add("cssBoton");
        lb3 = new Label("Agregar pedido");
//4
        Button butAgregar = new Button();
        butAgregar.setOnAction(e -> {
            Stage stage1 = new Stage();
            Pane menu = new AgregarPastel(stage1);
            Scene scene = new Scene(menu, 700, 500);
            scene.getStylesheets().add(getClass().getResource("boton.css").toExternalForm());
            stage1.setTitle("Agregar Pastel");
            stage1.setScene(scene);
            //stage.setResizable(false);
            stage1.show();
        });
        butAgregar.setGraphic(new ImageView("C:\\Users\\diego\\IdeaProjects\\Pasteleria\\src\\main\\resources\\com\\proyecto\\pasteleria\\AgregarPastel.jpeg"));
        butAgregar.setMaxSize(2,2);
        //button1.setMinSize(5,5);
        butAgregar.setLayoutX(50);
        butAgregar.setLayoutY(300);
        butAgregar.getStyleClass().add("cssBoton");
        lb4 = new Label("Agregar pasteles");
//5
        Button butPendiente = new Button();
        butPendiente.setOnAction(e -> {
            System.out.println("OK clicked5.");
        });
        butPendiente.setGraphic(new ImageView("C:\\Users\\diego\\IdeaProjects\\Pasteleria\\src\\main\\resources\\com\\proyecto\\pasteleria\\PedidoPendiente.jpeg"));
        butPendiente.setMaxSize(2,2);
        //button1.setMinSize(5,5);
        butPendiente.setLayoutX(300);
        butPendiente.setLayoutY(300);
        butPendiente.getStyleClass().add("cssBoton");
        lb5 = new Label("Pedidos pendientes");
//6
        Button butSalir = new Button();
        butSalir.setOnAction(e -> {
            stage.close();
        });
       butSalir.setGraphic(new ImageView("C:\\Users\\diego\\IdeaProjects\\Pasteleria\\src\\main\\resources\\com\\proyecto\\pasteleria\\Salir.jpeg"));
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

}
