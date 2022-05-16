package com.proyecto.pasteleria;


import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class Login extends  BorderPane {
    Button iniciar;
    public Login() {
        Image login = new Image("C:\\Users\\diego\\IdeaProjects\\Pasteleria\\src\\main\\resources\\com\\proyecto\\pasteleria\\Login0.jpg");
        ImageView imagen = new ImageView(login);
        imagen.setFitHeight(700);
        imagen.setFitWidth(600);
        imagen.setX(0);

        iniciar=new Button("Iniciar sesion");
        iniciar.setVisible(true);
        GridPane formulario = new GridPane();
        formulario.add(iniciar,2,1);
        iniciar.setMaxWidth(171);
        iniciar.setMinWidth(170);
        iniciar.setMaxHeight(41);
        iniciar.setMinHeight(40);
        iniciar.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 20));
        String colorString = "rgb(0.5039, 0.9218,0.9218";
        iniciar.setStyle("-fx-background-color: #81ecec");


        this.setLeft(imagen);
        this.setCenter(formulario);

    }
}
