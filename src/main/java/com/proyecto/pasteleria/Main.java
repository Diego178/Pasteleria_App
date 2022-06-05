package com.proyecto.pasteleria;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage){
        Pane root = new Login(stage);
        //Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        //Scene scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());
        Scene scene = new Scene(root, 900, 500);
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