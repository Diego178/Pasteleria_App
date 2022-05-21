package com.proyecto.pasteleria;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;


public class Login extends  BorderPane {
    GridPane formulario;
    TextField tUsuario;
    PasswordField password;
    Button iniciar;
    Label lUsuario;
    Label lContra;
    Circle user;

    public Login() {
        formulario = new GridPane();
        iniciar=new Button("Iniciar sesion");

        Image login = new Image("C:\\Users\\diego\\IdeaProjects\\Pasteleria\\src\\main\\resources\\com\\proyecto\\pasteleria\\LogoP.png");
        ImageView imagen = new ImageView(login);
        imagen.setFitWidth(450);
        imagen.setFitHeight(500);
        imagen.setX(0);

        iniciar.getStyleClass().add("cssBoton");
        iniciar.setMaxWidth(171);
        iniciar.setMinWidth(170);
        iniciar.setMaxHeight(41);
        iniciar.setMinHeight(40);

        tUsuario = new TextField();
        tUsuario.getStyleClass().add("text-field");

        password = new PasswordField();
        password.getStyleClass().add("text-field");

        lUsuario = new Label("Usuario: ");
        lUsuario.getStyleClass().add("label");

        lContra = new Label("Contraseña: ");
        lContra.getStyleClass().add("label");

        Image iUser = new Image("C:\\Users\\diego\\IdeaProjects\\Pasteleria\\src\\main\\resources\\com\\proyecto\\pasteleria\\User.png");
        Paint iuser = new ImagePattern(iUser);
         user= new Circle(70);
         user.setFill(iuser);


        formulario.setVgap(5);
        formulario.setHgap(5);
        formulario.getStyleClass().add("root");

        formulario.add(user,4,10);
        formulario.add(lUsuario,3,20);
        formulario.add(tUsuario,4,20);
        formulario.add(lContra,3,30);
        formulario.add(password,4,30);
        formulario.add(iniciar,4,40);

        iniciar.setOnMouseClicked(evtm->{
            comprobar();
        });


        this.setLeft(imagen);
        this.setCenter(formulario);

    }

    public void comprobar(){
        String user = tUsuario.getText();
        String pass = password.getText();
        if(user.equals("admin") && pass.equals("password")){
            System.out.println("Exito");
        }
    }
}
