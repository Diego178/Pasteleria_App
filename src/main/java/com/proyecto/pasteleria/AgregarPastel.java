package com.proyecto.pasteleria;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AgregarPastel extends GridPane {
    Button bAgregar;
    ComboBox<String> cbTamano;
    ComboBox<String>  cbRelleno;
    ComboBox<ImageView>  cbTipo;
    ColorPicker color;
    TextField tDetalles;
    Label lAgregar;
    Label lTamano;
    Label lRelleno;
    Label lTipo;
    Label lColor;
    Label lDetalles;
    public AgregarPastel(Stage stage){

    }
}
