package com.proyecto.pasteleria;

import com.proyecto.pasteleria.AgregarPastel.AgregarPastel;
import com.proyecto.pasteleria.Login.Login;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage){
        Pane root = new Login(stage);
        //Scene scene = new Scene(root, 900, 500);
        Pane menu = new AgregarPastel(stage);
        Scene scene = new Scene(menu, 700, 500);
        scene.getStylesheets().add(getClass().getResource("boton.css").toExternalForm());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}