package com.proyecto.pasteleria.Venta;


import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class PagarVenta extends GridPane {
    private Label lTotal;
    private Label lDineroDado;
    private Label lCambio;
    private TextField dineroDado;
    private Button bCancelar;
    private Button bAceptar;
    public PagarVenta(Stage stage, double total){
        setStyle("-fx-background-color: #ecf0f1");

        bAceptar = new Button("Aceptar");
        bAceptar.getStyleClass().addAll("BotonAceptar");
        bAceptar.setOnAction(e -> {
            System.out.println("Aceptar");
            //btnGraficos.setOnAction(evt -> {mostrarVenataGraficos();});
            stage.close();

        });

        bCancelar = new Button("Cancelar");
        bCancelar.getStyleClass().add("BotonCancelar");
        bCancelar.setOnAction(e -> {
            System.out.println("Cancelar");
            stage.close();
        });

        lTotal = new Label("Total: $"+total);
        lDineroDado = new Label("Dinero dado: ");
        lCambio = new Label("Cambio: $");

        dineroDado=new TextField();
        dineroDado.setPromptText("Dinero dado");
        dineroDado.getStyleClass().add("ios-field");
        dineroDado.setPrefWidth(150);

        bAceptar.setOnAction(evt->{
            if(comprobarDinero(dineroDado.getText())){
                stage.close();
            }
        });
        dineroDado.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case ENTER -> {
                        if(comprobarDinero(dineroDado.getText())) {
                            double cambio = getDineroDato() - total;
                            lCambio.setText("Cambio: $" + cambio);
                        }
                    }
                }

            }

            private int getDineroDato() {
                return Integer.parseInt(dineroDado.getText());
            }
        });
        add(lTotal, 1, 1, 2, 1);
        add(lDineroDado,1,3);
        add(dineroDado,2,3);
        add(lCambio, 1,4,2,1);
        add(bCancelar,1,5);
        add(bAceptar,2,5);
        setHgap(20);
        setVgap(20);
    }

    private boolean comprobarDinero(String dinero) {
        if(!dinero.isEmpty()) {
            char[] array = dinero.toCharArray();
            for (char letra : array) {
                if (!Character.isDigit(letra)) {
                    Alert alertasalir = new Alert(Alert.AlertType.ERROR);
                    alertasalir.setTitle("Error");
                    alertasalir.setContentText("Valor no valido, solo se aceptan numeros");
                    alertasalir.show();
                    alertasalir.setHeight(300);
                    alertasalir.setWidth(300);
                    return false;
                }
            }
        }else {
            Alert alertasalir = new Alert(Alert.AlertType.ERROR);
            alertasalir.setTitle("Error");
            alertasalir.setContentText("Campo vacio, ingresa un valor");
            alertasalir.show();
            alertasalir.setHeight(300);
            alertasalir.setWidth(300);
            return false;
        }
        return true;
    }
}