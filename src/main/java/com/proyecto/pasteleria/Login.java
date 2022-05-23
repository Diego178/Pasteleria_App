package com.proyecto.pasteleria;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Login extends  BorderPane {
    GridPane formulario;
    BorderPane organizacion;
    TextField tUsuario;
    PasswordField password;
    Button iniciar;
    Label lUsuario;
    Label lContra;
    Stage stage;

    public Login(Stage stage) {
        this.stage=stage;
        organizacion = new BorderPane();
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
        ImageView iuser = new ImageView(iUser);
        iuser.setFitWidth(150);
        iuser.setFitHeight(150);


        formulario.setVgap(5);
        formulario.setHgap(5);
        formulario.getStyleClass().add("root");

        formulario.add(lUsuario,3,5);
        formulario.add(tUsuario,4,5);
        formulario.add(lContra,3,20);
        formulario.add(password,4,20);
        Label test = new Label();
        test.setGraphic(iuser);
        test.setPrefHeight(175);
        organizacion.setTop(test);
        test.setTranslateX(175);
        test.setTranslateY(10);
        iniciar.setTranslateX(155);
        iniciar.setTranslateY(-70);


        organizacion.setCenter(formulario);
        organizacion.setBottom(iniciar);

        iniciar.setOnMouseClicked(evtm->{
            comprobar();
        });


        this.setLeft(imagen);
        this.setCenter(organizacion);

    }

    public void comprobar(){
        String user = tUsuario.getText();
        String pass = password.getText();
        if(user.equals("admin") && pass.equals("password")){
            Stage stage1 = new Stage();
            Pane menu = new Menu(stage1);
            Scene scene = new Scene(menu, 900, 500);
            scene.getStylesheets().add(getClass().getResource("boton.css").toExternalForm());
            stage1.setTitle("Venta");
            stage1.setScene(scene);
            //stage.setResizable(false);
            stage1.show();

            stage.close();
            System.out.println("Exito");
        }
    }
}
