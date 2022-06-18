package com.proyecto.pasteleria.Venta;


import com.proyecto.pasteleria.Modelos.Pastel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.List;


public class VentanaPagar extends BorderPane {

   // private List<Pastel> listaUsuarios;
    private Button btnGraficos;
    Label lb5, lb6, lb7;
    Button b1, b3;
    GridPane ven1;
    public VentanaPagar(Stage stage){
        //listaUsuarios = new ArrayList<Pastel>();

        ven1 = new GridPane();
        b3 = new Button("Aceptar");

        b3.setStyle("-fx-background-color: lightgreen;");
        b3.setOnAction(e -> {
            System.out.println("Aceptar");
            //btnGraficos.setOnAction(evt -> {mostrarVenataGraficos();});
            stage.close();

        });
        b1 = new Button("Cancelar");

        b1.setStyle("-fx-background-color: red;");
        b1.setOnAction(e -> {
            System.out.println("Cancelar");
            stage.close();

        });



        lb5 = new Label("Dinero dado= ");
        lb6 = new Label("Total= ");
        lb7 = new Label("Cambio= ");

        ven1.add(lb5,0,1);
        ven1.add(lb6, 0 , 2);
        ven1.add(lb7, 0,3);
        ven1.add(b1,0,4);
        ven1.add(b3,1,4);
        ven1.setHgap(160);
        ven1.setVgap(20);

        this.setCenter(ven1);
    }
    //private void mostrarVenataGraficos() {
        //Graficas ventana = new Graficas(getListaUsuarios());
        //ventana.show();
    //}

    //public List<Usuario> getListaUsuarios() {
        //return listaUsuarios;
    //}
}
