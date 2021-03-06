package com.proyecto.pasteleria.Pedidos;


import com.proyecto.pasteleria.AgregarDireccion.AgregarDireccion;
import com.proyecto.pasteleria.AgregarDireccion.Direcciones;
import com.proyecto.pasteleria.AgregarPastel.AgregarPastel;
import com.proyecto.pasteleria.AgregarPastel.TablaPasteles;
import com.proyecto.pasteleria.Modelos.Pastel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PantallaPedidos extends BorderPane {
    private Label titulo;
    private HBox barra;
    private GridPane formulario;
    private GridPane gpDirecciones;
    private Button bAgregarPastel;
    private Button bAgregarDireccion1;
    private Button bAgregarDireccion2;
    private Button bRealizarPedido;
    private Label lAgregarPastel;
    private Label lAgregarDireccion1;
    private Label lAgregarDireccion2;
    private Label lRealizarPedido;
    private Label lTelefonoCliente;
    private Label lNombreCliente;
    private Label lTotal;
    private Label direccion1;
    private Label direccion2;
    private TextField tTelefono;
    private TextField tNombre;
    private TablaPasteles tablaPasteles;
    private ObservableList<Pastel> pasteles;
    public int total;
    private Direcciones direcciones;
    public PantallaPedidos(){
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        formulario=new GridPane();
        barra=new HBox();

        titulo=new Label("Pedido");
        titulo.getStyleClass().add("label-titulo-Grande");

        pasteles= FXCollections.observableArrayList();
        tablaPasteles=new TablaPasteles(lTotal);
        TableView tablaPasteles1=tablaPasteles.getTablaPasteles();


        direcciones=new Direcciones();

        lAgregarPastel=new Label("Agregar pastel:");
        bAgregarPastel=new Button("Agregar Pastel");
        bAgregarPastel.getStyleClass().add("cssBoton");
        bAgregarPastel.setOnAction(evt->{
            accionAgregarPastel();
        });
        direccion1=new Label("");
        lAgregarDireccion1=new Label("Direccion del cliente:");
        bAgregarDireccion1=new Button("Direccion cliente");
        bAgregarDireccion1.getStyleClass().add("cssBoton");
        bAgregarDireccion1.setOnAction(evt->{
            accionAgregarDireccion(0, direccion1);

        });

        direccion2=new Label("");
        lAgregarDireccion2=new Label("Direccion de entrega:");
        bAgregarDireccion2=new Button("Direccion entrega");
        bAgregarDireccion2.getStyleClass().add("cssBoton");
        bAgregarDireccion2.setOnAction(evt->{
            accionAgregarDireccion(1, direccion2);
        });


        lTelefonoCliente=new Label("Telefono del cliente: ");
        tTelefono=new TextField();
        tTelefono.setPromptText("Ingresa el numero");
        tTelefono.getStyleClass().add("text-field2");

        lNombreCliente=new Label("Nombre del cliente: ");
        tNombre=new TextField();
        tNombre.setPromptText("Teclea el nombre");
        tNombre.getStyleClass().add("text-field2");

        bRealizarPedido=new Button("Realizar pedido");
        bRealizarPedido.getStyleClass().add("cssBoton");
        bRealizarPedido.setOnAction(evtm->{
            if (comprobarCampos()){
                pantallaPago(tablaPasteles.total());
                enviarInformacion();
            }
        });

        lTotal=new Label("Total: $"+total);
        lTotal.getStyleClass().add("label-titulo-Grande");


        formulario.setStyle("-fx-background-color: #dfe6e9");
        formulario.setHgap(7);
        formulario.setVgap(7);
        formulario.setPrefWidth(500);
        formulario.add(lAgregarPastel,1,1);
        formulario.add(bAgregarPastel,2,1);
        formulario.add(lAgregarDireccion1,1,2);
        formulario.add(bAgregarDireccion1,2,2);
        formulario.add(lAgregarDireccion2,1,3);
        formulario.add(bAgregarDireccion2,2,3);
        formulario.add(lTelefonoCliente,1,4);
        formulario.add(tTelefono,1,5);
        formulario.add(lNombreCliente,1,6);
        formulario.add(tNombre,1,7);
        formulario.add(direccion1,1,8,2,2);
        formulario.add(direccion2,1,10,2,2);

        barra.setPrefHeight(80);
        barra.setSpacing(600);
        barra.alignmentProperty().set(Pos.CENTER);
        barra.getChildren().addAll(lTotal,bRealizarPedido);

        setRight(formulario);
        setLeft(tablaPasteles1);
        setTop(titulo);
        setBottom(barra);
        setAlignment(titulo,Pos.CENTER);
    }

    private void enviarInformacion() {

    }

    private boolean comprobarCampos() {
        String str="";
        if(tablaPasteles.total()==0)
            str+="* No existen pasteles agregados\n";
        if(direccion1.getText().isEmpty())
            str+="* No tiene direccion de cliente agregada\n";
        if(direccion2.getText().isEmpty())
            str+="* No tiene direccion de entrega agregada\n";
        if(tTelefono.getText().isEmpty())
            str+="* No se agrego un numero de telefono\n";
        if(tTelefono.getLength()>10 || tTelefono.getLength()<10) {
            str += "* Numero de telefono no valido\n";
        }else {
            char[] array= tTelefono.getText().toCharArray();
            for(char letra : array){
                if(!Character.isDigit(letra)){
                    str+="* El numero contiene letras\n";
                    break;
                }
            }
        }
        if(tNombre.getText().isEmpty())
            str+="* No se agrego nombre de cliente\n";
        if(str.isEmpty())
            return true;
        else
            ventanaAlerta(str);
        return false;
    }

    private void ventanaAlerta(String str) {
        Alert alertasalir = new Alert(Alert.AlertType.ERROR);
        alertasalir.setTitle("Error");
        alertasalir.setContentText("Hay errores en los datos favor de corregir:\n"+str);
        alertasalir.show();
        alertasalir.setHeight(300);
        alertasalir.setWidth(300);
    }

    private void pantallaPago(Integer total) {
        Stage stage=new Stage();
        Pane menu = new PagarPedido(stage, total);
        Scene scene = new Scene(menu, 400, 240);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Pagar");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void accionAgregarDireccion(int Nodireccion, Label direccion) {
        Stage stage=new Stage();
        Pane menu = new AgregarDireccion(stage, direcciones,Nodireccion, direccion);
        Scene scene = new Scene(menu, 700, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Direccion");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void accionAgregarPastel() {
        Stage stage=new Stage();
        AgregarPastel menu = new AgregarPastel(stage,tablaPasteles,lTotal);
        Scene scene = new Scene(menu, 700, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Nuevo pastel");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
