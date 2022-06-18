package com.proyecto.pasteleria;

import com.proyecto.pasteleria.Login.Login;
import com.proyecto.pasteleria.Venta.PantallaVenta;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage){
        Pane root = new Login(stage);
        //Scene scene = new Scene(root, 900, 500);
        Pane menu = new PantallaVenta(stage);
        Scene scene = new Scene(menu, 1000, 700);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}