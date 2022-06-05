package com.proyecto.pasteleria;

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
    ComboBox cbTipo;
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
        lTipo=new Label("Tipo de pastel: ");
        cbTipo=new ComboBox();
        //crearListaImagenes(cbTipo);

        lColor=new Label("Color del pastel:");

        lRelleno=new Label("Relleno del partel: ");

        lTamano=new Label("Selecciona el tamaño: ");

        lDetalles=new Label("Detalles: ");

        this.add(cbTipo,0,0);


    }

    /*private void crearListaImagenes(ComboBox imagenesPastel) {
        String []nombrePasteles = {"pastel1.jpg","pastel2.jpg"};
        ImageView []imagenes = new ImageView[nombrePasteles.length];

        int i=0;
        for(String nombrePastel : nombrePasteles) {
            Image imagenC = new Image(getClass().getResourceAsStream(nombrePastel));
            imagenes[i] = new ImageView(imagenC);
            imagenes[i].setFitHeight(50);
            imagenes[i].setFitWidth((double)imagenC.getWidth()/(double)imagenC.getHeight()*50.0);
            i++;
        }
        imagenesPastel.getItems().addAll(imagenes);
        imagenesPastel.setCellFactory(new Callback<ListView<ImageView>, ListCell<ImageView>>() {
            public ListCell<ImageView> call(ListView<ImageView> p) {
                return new ListCell<ImageView>() {
                    private Rectangle rectangulo; {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        rectangulo = new Rectangle(200, 50);
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

    }*/
}
