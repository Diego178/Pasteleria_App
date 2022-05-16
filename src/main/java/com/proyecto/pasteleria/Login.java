package com.proyecto.pasteleria;


//import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class Login extends  BorderPane {
    GridPane formulario;
    TextField tUsuario;
    TextField tContra;
    Button iniciar;
    Label lUsuario;
    Label lContra;

    public Login() {
        formulario = new GridPane();
        iniciar=new Button("Iniciar sesion");

        Image login = new Image("C:\\Users\\diego\\IdeaProjects\\Pasteleria\\src\\main\\resources\\com\\proyecto\\pasteleria\\LogoP.png");
        ImageView imagen = new ImageView(login);
        imagen.setFitHeight(700);
        imagen.setFitWidth(600);
        imagen.setX(0);

        iniciar.getStyleClass().add("cssBoton");
        iniciar.setMaxWidth(171);
        iniciar.setMinWidth(170);
        iniciar.setMaxHeight(41);
        iniciar.setMinHeight(40);

        tUsuario = new TextField();
        tUsuario.getStyleClass().add("text-field");

        tContra = new TextField();
        tContra.getStyleClass().add("text-field");

        lUsuario = new Label("Usuario: ");
        lUsuario.getStyleClass().add("label");

        lContra = new Label("Contraseña: ");
        lContra.getStyleClass().add("label");



        formulario.setVgap(7);
        formulario.setHgap(7);
        formulario.getStyleClass().add("root");
        //iniciar.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 20));
        //iniciar.setStyle("-fx-background-color: #81ecec;");


        //JFXTextField texto=new JFXTextField();
        //formulario.add(texto,10,5);
        formulario.add(lUsuario,10,30);
        formulario.add(tUsuario,15,30);
        formulario.add(lContra,10,40);
        formulario.add(tContra,15,40);
        formulario.add(iniciar,15,60);


        this.setLeft(imagen);
        this.setCenter(formulario);

    }
}
