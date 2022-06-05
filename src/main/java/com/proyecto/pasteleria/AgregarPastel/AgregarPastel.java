package com.proyecto.pasteleria.AgregarPastel;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AgregarPastel extends GridPane {
    Button bAgregar;
    ComboBox<String> cbTamano;
    ComboBox<String>  cbRelleno;
    ComboBox<ImageView> cbTipoPan;
    ColorPicker color;
    TextField tDetalles;
    Label lAgregar;
    Label lTamano;
    Label lRelleno;
    Label lTipo;
    Label lColor;
    Label lDetalles;
    ImageView imagenesPastel;
    Stage stage1;
    public AgregarPastel(Stage stage){
        this.stage1=stage;
        lTipo=new Label("Tipo de Pan: ");
        cbTipoPan=new ComboBox();
        crearListaImagenesTipoPan(cbTipoPan);

        lColor=new Label("Color del pastel:");

        lRelleno=new Label("Relleno del partel: ");

        lTamano=new Label("Selecciona el tamaño: ");

        lDetalles=new Label("Detalles: ");

        this.add(cbTipoPan,0,0);


    }

    private void crearListaImagenesTipoPan(ComboBox imagenesPastel) {
        String []nombrePanes = {"cajeta.jpeg","Moka.jpeg","Oreo.jpeg","quesoCrema.jpeg","Zarzamora.jpeg"};
        ImageView []imagenes = new ImageView[nombrePanes.length];

        int i=0;
        for(String nombrePan : nombrePanes) {
            Image imagenPan = new Image(getClass().getResourceAsStream(nombrePan));
            imagenes[i] = new ImageView(imagenPan);
            imagenes[i].setFitHeight(17);
            imagenes[i].setFitWidth(70);
            i++;
        }
        imagenesPastel.getItems().addAll(imagenes);
        imagenesPastel.setCellFactory(new Callback<ListView<ImageView>, ListCell<ImageView>>() {
            public ListCell<ImageView> call(ListView<ImageView> p) {
                return new ListCell<ImageView>() {
                    private Rectangle rectangulo; {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        rectangulo = new Rectangle(80, 22);
                    }
                    @Override
                    public void updateItem(ImageView item, boolean vacio) {
                        super.updateItem(item, vacio);
                        if (item == null || vacio)
                            setGraphic(null);
                        else {
                            rectangulo.setFill(new ImagePattern(item.getImage()));
                            setGraphic(rectangulo);
                        }
                    }
                };
            }
        });

    }




}
