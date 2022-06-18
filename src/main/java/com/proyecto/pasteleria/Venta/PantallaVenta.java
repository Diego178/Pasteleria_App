package com.proyecto.pasteleria.Venta;

import com.proyecto.pasteleria.Modelos.Pastel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import java.time.format.DateTimeFormatter;

public class PantallaVenta extends BorderPane {
    private TablaInventario tablaInventario;
    private ObservableList<Pastel> pastelesInventario = FXCollections.observableArrayList();
    private TablaAgregados tablaAgregados;
    private ObservableList<Pastel> pastelesAgregados = FXCollections.observableArrayList();
    private Label titulo;
    private Label lTotal;
    private Button bPagar;
    private HBox barra;
    public PantallaVenta(Stage stage) {
        tablaAgregados = new TablaAgregados();
        TableView<Pastel> tablaAgregados1 = tablaAgregados.getTablaAgregados();
        tablaAgregados1.setPrefWidth(650);
        tablaInventario = new TablaInventario();
        TableView<Pastel> tablaInventario1 = tablaInventario.getTablaInventario();
        tablaInventario1.setPrefWidth(700);

        tablaAgregados.setTablaInventario(tablaInventario);
        tablaInventario.setTablaAgregados(tablaAgregados);

        tablaAgregados1.setOnMouseClicked(evtm->{
            if(evtm.getClickCount()==2){
                int index = tablaAgregados1.getSelectionModel().getSelectedIndex();
                Pastel pastel= tablaAgregados1.getItems().get(index);
                crearPantallaDetalles(tablaAgregados1.getSelectionModel().getSelectedIndex(), pastel);
            }
        });


        tablaInventario1.setOnMouseClicked(evtm->{
            if(evtm.getClickCount()==2){
                int index = tablaInventario1.getSelectionModel().getSelectedIndex();
                Pastel pastel= tablaInventario1.getItems().get(index);
                crearPantallaDetalles(tablaInventario1.getSelectionModel().getSelectedIndex(), pastel);
            }
        });

        barra = new HBox();

        lTotal = new Label("Total: $");
        lTotal.getStyleClass().add("label-titulo-Grande");

        bPagar = new Button("Pagar");
        bPagar.getStyleClass().add("botonAzul");

        titulo = new Label("Venta");
        titulo.getStyleClass().add("label-titulo-Grande");
        setAlignment(titulo, Pos.CENTER);
        titulo.setPrefHeight(90);

        //DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

        barra.getChildren().addAll(lTotal, bPagar);
        barra.setAlignment(Pos.CENTER_LEFT);
        barra.setPadding(new Insets(20,100,10,100));
        barra.setSpacing(140);
        barra.setPrefHeight(80);
        setBottom(barra);
        setTop(titulo);
        setLeft(tablaAgregados1);
        setRight(tablaInventario1);

    }

    private void crearPantallaDetalles(int selectedIndex, Pastel pastel) {
        Stage stage = new Stage();
        Pane detalles = new PantallaDetalles(stage, pastel);
        Scene scene = new Scene(detalles, 350, 450);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}