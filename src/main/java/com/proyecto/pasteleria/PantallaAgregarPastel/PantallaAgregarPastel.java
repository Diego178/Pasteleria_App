package com.proyecto.pasteleria.PantallaAgregarPastel;

import com.proyecto.pasteleria.AgregarPastel.AgregarPastel;
import com.proyecto.pasteleria.AgregarPastel.TablaPasteles;
import com.proyecto.pasteleria.Conexion.Pasteles;
import com.proyecto.pasteleria.Modelos.Pastel;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PantallaAgregarPastel extends BorderPane {
    private Label lTitulo;
    private Label label;
    private Stage stage;
    private Button bAgregarPastel;
    private HBox barra;
    private TablaPastelesEditar tablaPasteles;
    private ObservableList<Pastel> pasteles;
    public PantallaAgregarPastel(Stage stage){
        this.stage=stage;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        lTitulo = new Label("Agregar Pastel");
        lTitulo.getStyleClass().add("label-titulo");
        lTitulo.setPrefHeight(70);

        Pasteles listaHelper = new Pasteles();
        listaHelper.crearLista();
        //tablaPasteles.agregarPasteles(listaHelper.getListaPasteles());

        tablaPasteles=new TablaPastelesEditar(listaHelper.getListaPasteles());
        tablaPasteles.agregarPastel(new Pastel("1","sss","sfv","Red","awfcs",2,"ferc",200.0,"fw"));


        TableView tablaPasteles1=tablaPasteles.getTablaPasteles();
        tablaPasteles1.setPrefWidth(1000);
        tablaPasteles1.setOnMouseClicked(evtm->{
            Pastel pastelSeleccionado= (Pastel) tablaPasteles1.getSelectionModel().getSelectedItem();
            if(evtm.getClickCount()==2){
                int seleccion=tablaPasteles1.getSelectionModel().getSelectedIndex();
                editarPastel(pastelSeleccionado,seleccion);
            }
        });

        label= new Label();
        bAgregarPastel= new Button("Agregar pastel");
        bAgregarPastel.getStyleClass().add("cssBoton");
        bAgregarPastel.setOnAction(evtm->{
            crearPastel();
        });

        barra=new HBox();
        barra.setSpacing(200);
        barra.setAlignment(Pos.CENTER);
        barra.getChildren().addAll(lTitulo,bAgregarPastel);

        setTop(barra);
        setLeft(tablaPasteles1);
    }

    private void editarPastel(Pastel pastel, int seleccion) {
        Stage stage=new Stage();
        EditarPastel menu = new EditarPastel(stage,pastel,tablaPasteles,seleccion);
        Scene scene = new Scene(menu, 700, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Editar pastel");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void crearPastel() {
        Stage stage=new Stage();
        AgregarPastel menu = new AgregarPastel(stage,tablaPasteles);
        Scene scene = new Scene(menu, 700, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Nuevo pastel");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
