package com.proyecto.pasteleria.AgregarDireccion;

import com.proyecto.pasteleria.Conexion.ConexionDireccion;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AgregarDireccion extends GridPane {
    private Stage stage;
    private Label lEstado;
    private Label lCiudad;
    private Label lColonia;
    private Label lCalle;
    private Label lNoCasa;
    private Label lDescripcion;
    private ComboBox<String> cbEstado;
    private ComboBox<String> cbCiudad;
    private ComboBox<String> cbColonia;
    private TextField tCalle;
    private TextField tNoCasa;
    private TextArea tDetalles;
    private ConexionDireccion conexion;
    private  int IDEstado;
    private  int IDCiudad;
    private  int IDColonia;
    private Button agregar;
    public AgregarDireccion(Stage stage){
        this.stage=stage;
        setStyle("-fx-background-color: #dfe6e9");
        conexion=new ConexionDireccion();
        conexion.iniciarConexion();
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        lEstado = new Label("Selecciona el estado: ");
        cbEstado=new ComboBox<>();
        cbEstado.setPrefWidth(200);

        lCiudad=new Label("Selecciona la ciudad: ");
        cbCiudad=new ComboBox<>();
        cbCiudad.setPrefWidth(200);

        lColonia=new Label("Selecciona la colonia: ");
        cbColonia=new ComboBox<>();
        cbColonia.setPrefWidth(200);

        lCalle=new Label("Ingresa la calle: ");
        tCalle=new TextField();
        tCalle.setPromptText("Calle");
        tCalle.setMaxWidth(280);

        lNoCasa=new Label("Ingresa el No. de la casa: ");
        tNoCasa=new TextField();
        tNoCasa.setPromptText("No. de la casa");
        tNoCasa.setMaxWidth(200);

        lDescripcion=new Label("Descripcion/detalles de la casa: ");
        tDetalles=new TextArea();
        tDetalles.setPromptText("Ingresa detalles de la casa");
        tDetalles.getStyleClass().add("ios-field");
        tDetalles.setMaxWidth(280);
        tDetalles.setMaxHeight(100);

        cbCiudad.setDisable(true);
        cbColonia.setDisable(true);
        tCalle.setDisable(true);
        tNoCasa.setDisable(true);
        tDetalles.setDisable(true);

        crearListaCBEstado();

        cbEstado.setOnAction(evt->{
            accionCBEstado();
        });

        cbCiudad.setOnAction(evt->{
            accionCBCiudad();
        });

        cbColonia.setOnAction(evt->{
            tCalle.setDisable(false);
        });

        tCalle.setOnMouseClicked(evt->{
            tNoCasa.setDisable(false);
        });

        tNoCasa.setOnMouseClicked(evt->{
            tDetalles.setDisable(false);
        });

        agregar=new Button("Agregar");
        agregar.setOnAction(evt->{

        });

        setHgap(7);
        setVgap(7);
        setAlignment(Pos.CENTER);
        add(lEstado,2,0);
        add(cbEstado,3,0);
        add(lCiudad,2,2);
        add(cbCiudad,3,2);
        add(lColonia,2,4);
        add(cbColonia,3,4);
        add(lCalle,2,6);
        add(tCalle,3,6);
        add(lNoCasa,2,8);
        add(tNoCasa,3,8);
        add(lDescripcion,2,10);
        add(tDetalles,3,10);
    }

    private void accionCBCiudad() {
        cbColonia.setDisable(false);
        try{
            Connection conn = conexion.getConexion();
            String instSQL= "select id from ciudad where ciudad='"+cbCiudad.getValue()+"';";
            PreparedStatement pinst = conn.prepareStatement(instSQL);
            ResultSet rCiudad= pinst.executeQuery();
            while (rCiudad.next()){
                IDCiudad=rCiudad.getInt("id");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        crearListaCBColonia();
    }

    private void crearListaCBColonia() {
        cbColonia.getItems().clear();

        try{
            Connection conn = conexion.getConexion();
            String instSQL= "select * from colonia where idCiudad="+IDCiudad;
            PreparedStatement pinst = conn.prepareStatement(instSQL);
            ResultSet rColonias= pinst.executeQuery();

            while (rColonias.next()){
                String colonia = rColonias.getString("colonia");
                IDColonia=rColonias.getInt("id");
                cbColonia.getItems().add(colonia);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void accionCBEstado() {
        cbCiudad.setDisable(false);
        try{
            Connection conn = conexion.getConexion();
            String instSQL= "select id from estado where estado='"+cbEstado.getValue()+"';";
            PreparedStatement pinst = conn.prepareStatement(instSQL);
            ResultSet rEstado= pinst.executeQuery();
            while (rEstado.next()){
                IDEstado=rEstado.getInt("id");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        crearListaCBCiudad();
    }

    private void crearListaCBCiudad() {
        cbCiudad.getItems().clear();
        cbColonia.getItems().clear();
        try{
            Connection conn = conexion.getConexion();
            String instSQL= "select * from ciudad where idEstado="+IDEstado;
            PreparedStatement pinst = conn.prepareStatement(instSQL);
            ResultSet rCiudades= pinst.executeQuery();

            while (rCiudades.next()){
                String ciudad = rCiudades.getString("ciudad");
                IDCiudad=rCiudades.getInt("id");
                cbCiudad.getItems().add(ciudad);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }


    private void crearListaCBEstado() {
        try{
            Connection conn = conexion.getConexion();
            String instSQL= "select * from estado";
            PreparedStatement pinst = conn.prepareStatement(instSQL);
            ResultSet rEstados= pinst.executeQuery();

            while (rEstados.next()){
                String estado = rEstados.getString("estado");
                cbEstado.getItems().add(estado);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }


}
//String selec=cbEstado.getValue();
//        cbCiudad.getItems().clear();
//        if(selec.equals("Veracruz")){
//            cbCiudad.getItems().addAll("Perote","Xalapa","Molinos","Sierra de agua","Las Vigas",
//                    "Pescados","Libertad");
//        }
//        if(selec.equals("Puebla")){
//            cbCiudad.getItems().addAll("Alchichica","Libres");
//        }
//        return selec;