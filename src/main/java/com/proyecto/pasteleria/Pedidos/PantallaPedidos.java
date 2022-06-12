package com.proyecto.pasteleria.Pedidos;

import com.proyecto.pasteleria.AgregarDireccion.AgregarDireccion;
import com.proyecto.pasteleria.AgregarPastel.AgregarPastel;
import com.proyecto.pasteleria.Login.Login;
import com.proyecto.pasteleria.Modelos.Pastel;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PantallaPedidos extends BorderPane {
    private Label titulo;
    private TableView tablaPasteles;
    private GridPane formulario;
    private Button bAgregarPastel;
    private Button bAgregarDireccion1;
    private Button bAgregarDireccion2;
    private Button bRealizarPedido;
    private Button bFormaPago;
    private Button bAgregarCliente;
    private Label lAgregarPastel;
    private Label lAgregarDireccion1;
    private Label lAgregarDireccion2;
    private Label lRealizarPedido;
    private Label lFormaPago;
    private Label lAgregarCliente;
    public PantallaPedidos(){
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        formulario=new GridPane();

        titulo=new Label("Pedido");
        titulo.getStyleClass().add("label-titulo-Grande");

        tablaPasteles=new TableView<>();
        tablaPasteles.getStyleClass().add("table-cell");
        tablaPasteles.setPrefWidth(800);

        crearTabla();

        lAgregarPastel=new Label("Agregar pastel:");
        bAgregarPastel=new Button("Agregar Pastel");
        bAgregarPastel.getStyleClass().add("cssBoton");
        bAgregarPastel.setOnAction(evt->{
            accionAgregarPastel();
        });

        lAgregarDireccion1=new Label("Direccion del cliente:");
        bAgregarDireccion1=new Button("Direccion cliente");
        bAgregarDireccion1.getStyleClass().add("cssBoton");
        bAgregarDireccion1.setOnAction(evt->{
            accionAgregarDireccion();
        });

        lAgregarDireccion2=new Label("Direccion de entrega:");
        bAgregarDireccion2=new Button("Direccion entrega");
        bAgregarDireccion2.getStyleClass().add("cssBoton");
        bAgregarDireccion2.setOnAction(evt->{
            accionAgregarDireccion();
        });


        formulario.setStyle("-fx-background-color: #dfe6e9");
        formulario.setHgap(7);
        formulario.setVgap(7);
        formulario.setPrefWidth(400);
        formulario.add(lAgregarPastel,1,1);
        formulario.add(bAgregarPastel,2,1);
        formulario.add(lAgregarDireccion1,1,2);
        formulario.add(bAgregarDireccion1,2,2);
        formulario.add(lAgregarDireccion2,1,3);
        formulario.add(bAgregarDireccion2,2,3);


        setRight(formulario);
        setLeft(tablaPasteles);
        setTop(titulo);
        setAlignment(titulo,Pos.CENTER);
    }

    private void accionAgregarDireccion() {
        Stage stage=new Stage();
        Pane menu = new AgregarDireccion(stage);
        Scene scene = new Scene(menu, 700, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Direccion");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void accionAgregarPastel() {
        Stage stage=new Stage();
        Pane menu = new AgregarPastel(stage);
        Scene scene = new Scene(menu, 700, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Nuevo pastel");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void crearTabla() {
        TableColumn<Pastel, String> colTipoPan= new TableColumn<Pastel,String>("Tipo Pan");
        TableColumn<Pastel, String> colTamano = new TableColumn<Pastel,String>("Tamaño");
        TableColumn<Pastel, String> colRelleno = new TableColumn<Pastel,String>("Relleno");
        TableColumn<Pastel, String> colPrecio = new TableColumn<Pastel,String>("Precio");
        TableColumn<Pastel, String> colEliminar = new TableColumn<Pastel,String>("Eliminar");
        TableColumn<Pastel, String> colModificar = new TableColumn<Pastel,String>("Modificar");


        colTipoPan.setCellValueFactory(new PropertyValueFactory<Pastel,String>("tipoPan"));
        colTamano.setCellValueFactory(new PropertyValueFactory<Pastel, String>("tamano"));
        colRelleno.setCellValueFactory(new PropertyValueFactory<Pastel,String>("relleno"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<Pastel,String>("precio"));
        colEliminar.setCellValueFactory(new PropertyValueFactory<Pastel,String>("eliminar"));
        colModificar.setCellValueFactory(new PropertyValueFactory<Pastel,String>("modificar"));

        tablaPasteles.getColumns().addAll(colTipoPan,colTamano,colRelleno,
                colPrecio,colEliminar,colModificar);
    }
}
