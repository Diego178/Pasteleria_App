package com.proyecto.pasteleria.AgregarPastel;

import com.proyecto.pasteleria.Modelos.Pastel;
import com.proyecto.pasteleria.PantallaAgregarPastel.TablaPastelesEditar;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AgregarPastel extends GridPane {
    private Double precioPastel=0.0;
    private Double precioTamano=0.0;
    private Double precioTipoPan=0.0;
    private Double precioForma=0.0;
    private Double precioRelleno=0.0;
    private Double precioRNoPisos=0.0;
    private ComboBox<String> cbTamano;
    private ComboBox<String>  cbRelleno;
    private ComboBox<String> cbTipoPan;
    private ComboBox<String> cbForma;
    private ComboBox<Integer> cbNoPisos;
    private ColorPicker color;
    private TextArea tDetalles;
    private Label Precio;
    private Label lAgregar;
    private Label lTamano;
    private Label lRelleno;
    private Label lTipo;
    private Label lColor;
    private Label lForma;
    private Label lDetalles;
    private Label lNoPisos;
    private ImageView imagenesPastel;
    private Stage stage1;
    private Button bAgregar;
    private Pastel pastel;
    public AgregarPastel(Stage stage, TablaPastelesEditar tablaPasteles){
        this.stage1=stage;
        bAgregar=new Button("Agregar");
        bAgregar.setOnAction(evtm->{
            Pastel pastel=crearPastel();
            tablaPasteles.agregarPastel(pastel);
            stage.close();
        });
        inicializarComponentes(bAgregar);
    }

    public AgregarPastel(Stage stage, TablaPasteles tablaPasteles, Label total){
        this.stage1=stage;
        bAgregar=new Button("Agregar");
        bAgregar.setOnAction(evtm->{
            Pastel pastel=crearPastel();
            tablaPasteles.agregarPastel(pastel);
            total.setText("Total: $"+tablaPasteles.total());
            stage.close();
        });
        inicializarComponentes(bAgregar);



    }

    private void inicializarComponentes(Button bAgregar) {
        this.setStyle("-fx-background-color: #dfe6e9");
        lTipo=new Label("Tipo de Pan: ");
        cbTipoPan=new ComboBox();
        crearListaTipoPan(cbTipoPan);
        cbTipoPan.setPrefHeight(30);
        cbTipoPan.setPrefWidth(200);
        cbTipoPan.getStyleClass().add("combo-box-base");
        cbTipoPan.setOnAction(evt->{
            accionCBTipoPan();
        });

        lColor=new Label("Color del pastel:");
        color=new ColorPicker();
        color.setPrefHeight(39);
        color.setPrefWidth(200);

        lRelleno=new Label("Relleno del partel: ");
        cbRelleno=new ComboBox();
        cbRelleno.setPrefHeight(35);
        cbRelleno.setPrefWidth(200);
        crearListaRelleno(cbRelleno);
        cbRelleno.setOnAction(evt->{
            accionCBRelleno();
        });

        lNoPisos=new Label("Numero de pisos: ");
        cbNoPisos=new ComboBox();
        cbNoPisos.setPrefHeight(35);
        cbNoPisos.setPrefWidth(200);
        crearListaNoPisos(cbNoPisos);
        cbNoPisos.setOnAction(evt->{
            accionCBNoPisos();
        });



        lForma = new Label("Forma del pastel: ");
        cbForma=new ComboBox();
        cbForma.setPrefHeight(35);
        cbForma.setPrefWidth(200);
        crearListaFromas(cbForma);

        lTamano=new Label("Selecciona el tama??o: ");
        cbTamano=new ComboBox();
        cbTamano.setPrefWidth(200);
        crearListaTamanos(cbTamano);

        lDetalles=new Label("Detalles del pastel: ");
        tDetalles=new TextArea();
        tDetalles.setMaxSize(300,70);
        tDetalles.setPromptText("Ingresa los detalles del pastel");
        tDetalles.getStyleClass().add("ios-field");

        Precio=new Label("Precio del pastel: $"+precioPastel);

        //setPromptText
        this.add(lTipo,3,0);
        this.add(cbTipoPan,4,0);
        this.add(lColor,3,2);
        this.add(color,4,2);
        this.add(lRelleno,3,4);
        this.add(cbRelleno,4,4);
        this.add(lTamano,3,6);
        this.add(cbTamano,4,6);
        this.add(lForma,3,8);
        this.add(cbForma,4,8);
        this.add(lNoPisos,3,10);
        this.add(cbNoPisos,4,10);
        this.add(lDetalles,3,12);
        this.add(tDetalles,4,12);
        this.add(Precio,3,15);
        this.add(bAgregar,4,15);
        bAgregar.getStyleClass().add("cssBoton");
        bAgregar.setAlignment(Pos.BOTTOM_LEFT);


        setHgap(7);
        setVgap(7);
        setAlignment(Pos.CENTER);
    }

    private void accionCBTipoPan() {
        int seleccion=cbTipoPan.getSelectionModel().getSelectedIndex();
        if(seleccion==0){
            precioTipoPan=100.0;
        }
        if(seleccion==1){
            precioTipoPan=120.0;
        }
        if(seleccion==2){
            precioTipoPan=150.0;
        }
        precioPastel=precioTipoPan+precioForma+precioRelleno+precioRNoPisos;
        Precio.setText("Precio del pastel: $"+precioPastel);
    }

    private void accionCBRelleno() {
        int seleccion=cbRelleno.getSelectionModel().getSelectedIndex();
        if(seleccion==0){
            precioRelleno=80.0;
        }
        if(seleccion==1){
            precioRelleno=50.0;
        }
        if(seleccion==2){
            precioRelleno=30.0;
        }
        precioPastel=precioTipoPan+precioForma+precioRelleno+precioRNoPisos;
        Precio.setText("Precio del pastel: $"+precioPastel);
    }

    private void accionCBNoPisos() {
        int seleccion=cbNoPisos.getSelectionModel().getSelectedIndex();
        if(seleccion==0){
            precioRNoPisos=100.0;
        }
        if(seleccion==1){
            precioRNoPisos=150.0;
        }
        if(seleccion==2){
            precioRNoPisos=310.0;
        }
        if(seleccion==3){
            precioRNoPisos=450.0;
        }
        if(seleccion==4){
            precioRNoPisos=600.0;
        }
        precioPastel=precioTipoPan+precioForma+precioRelleno+precioRNoPisos;
        Precio.setText("Precio del pastel: $"+precioPastel);
    }

    private void crearListaNoPisos(ComboBox<Integer> cbNoPisos) {
        cbNoPisos.getItems().addAll(1,2,3,4,5);
    }

    private void crearListaRelleno(ComboBox cbRelleno) {
        cbRelleno.getItems().addAll("Queso Crema","Frutas","Fresa");
    }

    private void crearListaFromas(ComboBox imagenesForma) {
        String []nombreTamanos = {"circulo.png","cuadrado.png"};
        ImageView []imagenes = new ImageView[nombreTamanos.length];

        int i=0;
        for(String nombreTamano : nombreTamanos) {
            Image inombreTamano = new Image(getClass().getResourceAsStream(nombreTamano));
            imagenes[i] = new ImageView(inombreTamano);
            imagenes[i].setFitHeight(25);
            imagenes[i].setFitWidth(25);
            i++;
        }
        imagenesForma.getItems().addAll(imagenes);
        imagenesForma.setCellFactory(new Callback<ListView<ImageView>, ListCell<ImageView>>() {
            public ListCell<ImageView> call(ListView<ImageView> p) {
                return new ListCell<ImageView>() {
                    private Rectangle rectangulo; {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        rectangulo = new Rectangle(25, 25);
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


    private void crearListaTipoPan(ComboBox cbTipoPan) {
        cbTipoPan.getItems().addAll("Chocolate","3 Leches","Moka");
    }

    private void crearListaTamanos(ComboBox<String> cbTamano) {
        cbTamano.getItems().addAll("Chico","Mediano","Grande");
    }
    public Pastel crearPastel(){
        String forma;
        if(cbForma.getSelectionModel().getSelectedIndex()==0)
            forma="cuadrado";
        else
            forma="circulo";
        return new Pastel("1", cbTipoPan.getValue(), cbRelleno.getValue(), color.getValue().toString(), forma, cbNoPisos.getValue(), cbTamano.getValue(), precioPastel, tDetalles.getText());

    }
}
