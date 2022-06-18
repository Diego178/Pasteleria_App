package com.proyecto.pasteleria.Venta;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PantallaVenta extends BorderPane {
    private final TableView<Data> table = new TableView<>();
    private final ObservableList<Data> tvObservableList = FXCollections.observableArrayList();
    Label titulo, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8;
    Button b1, b3;
    ScrollPane root2;
    GridPane ven1, vent2, vent3;


    public PantallaVenta(Stage stage){
        titulo = new Label("Venta");
        titulo.getStyleClass().add("label-titulo-Grande");

        lb3 = new Label("Agregados");
        lb3.setPrefHeight(50);
        lb3.setPrefWidth(350);

        lb3.setStyle("-fx-border-color: black;");
        lb3.getStyleClass().add("label-titulo-Grande");

        lb4 = new Label("1200");
        lb4.setPrefHeight(50);
        lb4.setPrefWidth(50);
        lb4.setStyle("-fx-border-color: black;");
        lb4.getStyleClass().add("label-titulo-Grande");


        b3 = new Button("Pagar");
        b3.setPrefHeight(50);
        b3.setPrefWidth(300);
        b3.setStyle("-fx-background-color: lightgreen;");
        b3.setOnAction(e -> {
            //System.out.println("pagado");
            Stage stage1 = new Stage();
            Pane menu = new VentanaPagar(stage1);
            Scene scene = new Scene(menu, 300, 200);
            //scene.getStylesheets().add(getClass().getResource("boton.css").toExternalForm());
            stage1.setTitle("Pagar");
            stage1.setScene(scene);
            //stage.setResizable(false);
            stage1.show();

        });

        lb5 = new Label("Relleno");
        lb5.setStyle("-fx-border-color: black;");
        lb6 = new Label("Precio");
        lb6.setStyle("-fx-border-color: black;");
        lb7 = new Label("tamaño");
        lb7.setStyle("-fx-border-color: black;");
        lb8 = new Label("Tipo pan");
        lb8.setStyle("-fx-border-color: black;");


        ven1 = new GridPane();
        vent2 = new GridPane();
        vent3 = new GridPane();

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

        lb1 =new Label(dtf1.format(LocalDateTime.now()));
        lb2 =new Label(dtf.format(LocalDateTime.now()));
        BorderPane pane = new BorderPane();
        root2 = new ScrollPane();


        //Image image = new Image(getClass().getResourceAsStream("Salir.jpeg"));
        //ImageView imagen = new ImageView(image);
        /*MediaView imageView = new MediaView(new Image("resources/image.png",64,64,true,true,true))

        Circle clipShape = new Circle();
        clipShape.setCenterX(32);
        clipShape.setCenterY(32);
        clipShape.setRadius(32);
        imageView.setClip(clipShape);*/
        //Label myLabel = new Label();
        //myLabel.setGraphic(new ImageView(image));
        //pane
        //for (int i = 0; i <= 8; i++) {
        pane.setBottom(lb7);
        pane.setLeft(lb6);
        pane.setRight(lb5);
        //pane.setRight(lb8);
       // pane.setCenter(myLabel);

        pane.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                if(mouseEvent.getClickCount()==2){
                    Stage stage1 = new Stage();
                    //Pane menu = new InfoPastel(stage1);
                    //Scene scene = new Scene(menu, 300, 200);
                    //scene.getStylesheets().add(getClass().getResource("boton.css").toExternalForm());
                   // stage1.setTitle("Informacion");
                    //stage1.setScene(scene);
                    //stage.setResizable(false);
                    //stage1.show();
                }

            }
        });

       /* leaderListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    if (mouseEvent.getClickCount() == 2) {
                        Person item = leaderListView.getSelectionModel()
                                .getSelectedItem();
                        if (item != null) {
                            StackPane pane = new StackPane();
                            Scene scene = new Scene(pane);
                            Stage stage = new Stage();
                            stage.setScene(scene);

                            pane.getChildren().add(
                                    new TextField(item.getAliasName()));

                            stage.show();
                        }

                    }
                }
            }
        });

        */



        //lista
        setTableappearance();

        fillTableObservableListWithSampleData();
        table.setItems(tvObservableList);

        TableColumn<Data, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Data, String> colName = new TableColumn<>("Name");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        table.getColumns().addAll(colId, colName);

        addButtonToTable();
        root2.setContent(pane);
        root2.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        root2.setPrefWidth(380);

        ven1.add(lb1,1,1);
        ven1.add(titulo, 2 , 1);
        ven1.add(lb2, 3,1);
        ven1.setHgap(160);
        ven1.setVgap(20);
        vent2.add(lb3,0,0);
        vent2.add(lb4,1,10);
        vent2.add(b3,0,10);
        vent2.add(table,0,1);

        vent3.add(root2,1,1);

        this.setTop(ven1);
        this.setLeft(vent2);
        this.setRight(vent3);





    }

    private void setTableappearance() {
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPrefWidth(350);
        table.setPrefHeight(500);
    }

    private void fillTableObservableListWithSampleData() {

        tvObservableList.addAll(new Data(1, "fresa", 100),
                new Data(2, "chocolate", 100),
                new Data(3, "durazno", 100),
                new Data(4, "moka", 100),
                new Data(5, "vainilla", 100));
    }

    private void addButtonToTable() {
        TableColumn<Data, Void> colBtn = new TableColumn("");

        Callback<TableColumn<Data, Void>, TableCell<Data, Void>> cellFactory = new Callback<TableColumn<Data, Void>, TableCell<Data, Void>>() {
            @Override
            public TableCell<Data, Void> call(final TableColumn<Data, Void> param) {
                final TableCell<Data, Void> cell = new TableCell<Data, Void>() {

                    private final Button btn = new Button("-");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Data data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        table.getColumns().add(colBtn);

    }

    public class Data {

        private int id;
        private String sabor;
        private int precio;

        private Data(int id, String sabor, int precio) {
            this.id = id;
            this.sabor = sabor;
            this.precio = precio;
        }

        public int getId() {
            return id;
        }

        public void setId(int ID) {
            this.id = ID;
        }

        public String getSabor() {
            return sabor;
        }

        public void setSabor(String Sabor) {
            this.sabor = Sabor;
        }
        public int getPrecio() {
            return precio;
        }

        public void setPrecio(int Precio) {
            this.precio = Precio;
        }

        @Override
        public String toString() {
            return "Id: " + id + " - " + "Sabor: " + sabor + " - " +"precio: "+precio;
        }

    }

}