package com.proyecto.pasteleria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage){
        BorderPane root = new Login();
        Scene scene = new Scene(root, 1200, 700);
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