package com.proyecto.pasteleria;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class Login extends AnchorPane {
    public Login() {
        Image login = new Image("C:\\Users\\diego\\IdeaProjects\\Pasteleria\\src\\main\\resources\\com\\proyecto\\pasteleria");
        ImageView imagen = new ImageView(login);
        imagen.setFitWidth(100);
        imagen.setFitWidth(100);
        getChildren().addAll(imagen);
    }
}
