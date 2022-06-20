package com.proyecto.pasteleria.PedidosPendientes;

import com.proyecto.pasteleria.Conexion.Pedidos;
import com.proyecto.pasteleria.Modelos.Direccion;
import com.proyecto.pasteleria.Modelos.Pastel;
import com.proyecto.pasteleria.Modelos.Pedido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.util.List;

public class PantalleDetallesPedido extends GridPane {
    private Label titulo;
    private Label lDirecciones;
    private Label lCliente;
    private Label lPago;
    private Label lDatosCliente;
    private Label lDatosPago;
    private Button bEntregar;
    private List<Pastel> listaPasteles;
    public PantalleDetallesPedido(String id){

        setStyle("-fx-background-color: #dfe6e9");

        Pedidos listaHelper = new Pedidos();
        listaHelper.crearListaPasteles(id);
        listaHelper.crearListaPasteles(id);
        listaPasteles = listaHelper.getListaPasteles();
        List<Direccion> listaDirecciones = listaHelper.getDirecciones(id);

        TableView<Pastel> tablaPasteles = new TableView<>();
        tablaPasteles.setMaxWidth(663);
        tablaPasteles.setMaxHeight(200);
        TableView<Direccion> tablaDirecciones = new TableView<>();
        tablaDirecciones.setMinWidth(500);
        tablaDirecciones.setMaxHeight(80);
        titulo = new Label();
        titulo.setText("Detalles de los pasteles");

        lDirecciones = new Label("Direcciones");

        lCliente = new Label("Datos del cliente");

        lPago = new Label("Detalles del pago");

        Pedido pedido = new Pedido();
        pedido = listaHelper.getPedido(id);

        lDatosCliente = new Label("Nombre: "+pedido.getNombre()+", Telefono: "+pedido.getTelefono());

        lDatosPago = new Label("Anticipo: $"+pedido.getAnticipo()+", Restante: $"+pedido.getDineroPendiente()
        +", Total: $"+pedido.getTotal());

        bEntregar = new Button("Entregar pedido");
        bEntregar.getStyleClass().add("BotonAceptar");
        //setHgap(30);
        setVgap(10);
        crearTablaPastel(tablaPasteles, listaPasteles);
        crearTablaDireccion(tablaDirecciones, listaDirecciones);
        setAlignment(Pos.CENTER);
        add(titulo,2,0);
        add(tablaPasteles,2,1,2,1);
        add(lDirecciones,2,2);
        add(tablaDirecciones, 2,3);
        add(lCliente,2,4);
        add(lDatosCliente,2,5,2,1);
        add(lPago,2,6);
        add(lDatosPago,2,7,2,1);
        add(bEntregar,2,8,2,1);
    }

    private void crearTablaDireccion(TableView<Direccion> tablaDirecciones, List<Direccion> listaDirecciones) {
        ObservableList<Direccion> direcciones = FXCollections.observableArrayList();
        direcciones.addAll(listaDirecciones);
        tablaDirecciones.setItems(direcciones);
        TableColumn<Direccion, String> colEstado= new TableColumn<Direccion,String>("Estado");
        TableColumn<Direccion, String> colCiudad= new TableColumn<Direccion,String>("Ciudad");
        TableColumn<Direccion, String> colColonia= new TableColumn<Direccion,String>("Colonia");
        TableColumn<Direccion, String> colCalle= new TableColumn<Direccion, String>("Calle");
        TableColumn<Direccion, Integer> colNumero= new TableColumn<Direccion,Integer>("Numero");
        TableColumn<Direccion, String> colTipo = new TableColumn<Direccion, String>("Tipo");

        colEstado.setPrefWidth(120);
        colCiudad.setPrefWidth(120);
        colColonia.setPrefWidth(120);
        colCalle.setPrefWidth(100);
        colNumero.setPrefWidth(100);
        colTipo.setPrefWidth(100);
        colEstado.setCellValueFactory(new PropertyValueFactory<Direccion,String>("estado"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<Direccion,String>("ciudad"));
        colColonia.setCellValueFactory(new PropertyValueFactory<Direccion,String>("colonia"));
        colCalle.setCellValueFactory(new PropertyValueFactory<Direccion,String>("calle"));
        colNumero.setCellValueFactory(new PropertyValueFactory<Direccion,Integer>("numero"));
        colTipo.setCellValueFactory(new PropertyValueFactory<Direccion, String>("tipo"));

        tablaDirecciones.getColumns().addAll(colEstado, colCiudad, colColonia, colCalle, colNumero, colTipo);
    }

    private void crearTablaPastel(TableView<Pastel> tablaPasteles, List<Pastel> listaPasteles) {
        ObservableList<Pastel> pasteles = FXCollections.observableArrayList();
        pasteles.addAll(listaPasteles);
        tablaPasteles.setItems(pasteles);
        TableColumn<Pastel, String> colId= new TableColumn<Pastel,String>("ID");
        TableColumn<Pastel, String> colTipoPan= new TableColumn<Pastel,String>("Tipo Pan");
        TableColumn<Pastel, String> colRelleno= new TableColumn<Pastel,String>("Relleno");
        TableColumn<Pastel, Integer> colNoPisos= new TableColumn<Pastel,Integer>("No pisos");
        TableColumn<Pastel, String> colTamano= new TableColumn<Pastel,String>("Tamano");
        TableColumn<Pastel, Double> colPrecio = new TableColumn<Pastel,Double>("Precio");

        colId.setPrefWidth(100);
        colTipoPan.setPrefWidth(120);
        colRelleno.setPrefWidth(120);
        colTamano.setPrefWidth(120);
        colNoPisos.setPrefWidth(100);
        colPrecio.setPrefWidth(100);

        colId.setCellValueFactory(new PropertyValueFactory<Pastel,String>("id"));
        colTipoPan.setCellValueFactory(new PropertyValueFactory<Pastel,String>("tipoPan"));
        colRelleno.setCellValueFactory(new PropertyValueFactory<Pastel,String>("relleno"));
        colNoPisos.setCellValueFactory(new PropertyValueFactory<Pastel,Integer>("pisos"));
        colTamano.setCellValueFactory(new PropertyValueFactory<Pastel,String>("tamano"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<Pastel,Double>("precio"));

        tablaPasteles.getColumns().addAll(colId, colTipoPan, colRelleno, colNoPisos, colTamano, colPrecio);
    }


}
