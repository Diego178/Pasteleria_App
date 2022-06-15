package com.proyecto.pasteleria.PantallaAgregarPastel;

import com.proyecto.pasteleria.AgregarPastel.AgregarPastel;
import com.proyecto.pasteleria.AgregarPastel.TablaPasteles;
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
    private TablaPasteles tablaVentas;
    private ObservableList<Pastel> pasteles;
    public PantallaAgregarPastel(Stage stage){
        this.stage=stage;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        lTitulo = new Label("Agregar Pastel");
        lTitulo.getStyleClass().add("label-titulo");
        lTitulo.setPrefHeight(70);
        tablaVentas=new TablaPasteles();
        tablaVentas.agregarPastel(new Pastel(1,"sss","sfv","gt","awfcs",2,"ferc",200,"fw"));
        TableView tablaVentas1=tablaVentas.getTablaPasteles();
        tablaVentas1.setPrefWidth(1000);
        tablaVentas1.setOnMouseClicked(evtm->{
            Pastel pastelSeleccionado= (Pastel) tablaVentas1.getSelectionModel().getSelectedItem();
            if(evtm.getClickCount()==2){
                editarPastel(pastelSeleccionado);
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
        setLeft(tablaVentas1);
    }

    private void editarPastel(Pastel pastel) {
        Stage stage=new Stage();
        AgregarPastel menu = new AgregarPastel(stage,pastel);
        Scene scene = new Scene(menu, 700, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Nuevo pastel");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void crearPastel() {
        Stage stage=new Stage();
        AgregarPastel menu = new AgregarPastel(stage,tablaVentas);
        Scene scene = new Scene(menu, 700, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Nuevo pastel");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
