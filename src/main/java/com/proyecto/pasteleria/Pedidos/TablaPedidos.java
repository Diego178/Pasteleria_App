package com.proyecto.pasteleria.Pedidos;

import com.proyecto.pasteleria.Modelos.Pastel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TablaPedidos {
    private TableView tablaPasteles;
    private ObservableList<Pastel> pasteles= FXCollections.observableArrayList();
    public TablaPedidos(){
        tablaPasteles=new TableView<>();
        tablaPasteles.getStyleClass().add("table-cell");
        tablaPasteles.setPrefWidth(700);
        crearTabla();
    }

    public void crearTabla() {
        tablaPasteles.setItems(pasteles);
        TableColumn<Pastel, String> colTipoPan= new TableColumn<Pastel,String>("Tipo Pan");
        TableColumn<Pastel, String> colTamano = new TableColumn<Pastel,String>("Tamaño");
        TableColumn<Pastel, String> colRelleno = new TableColumn<Pastel,String>("Relleno");
        TableColumn<Pastel, String> colPrecio = new TableColumn<Pastel,String>("Precio");
        //TableColumn<Pastel, String> colEliminar = new TableColumn<Pastel,String>("Eliminar");
        //TableColumn<Pastel, String> colModificar = new TableColumn<Pastel,String>("Modificar");

        colTipoPan.setPrefWidth(120);
        colTamano.setPrefWidth(120);
        colRelleno.setPrefWidth(120);
        colPrecio.setPrefWidth(120);


        colTipoPan.setCellValueFactory(new PropertyValueFactory<Pastel,String>("tipoPan"));
        colTamano.setCellValueFactory(new PropertyValueFactory<Pastel, String>("tamano"));
        colRelleno.setCellValueFactory(new PropertyValueFactory<Pastel,String>("relleno"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<Pastel,String>("precio"));
        //colEliminar.setCellValueFactory(new PropertyValueFactory<Pastel,String>("eliminar"));
        //colModificar.setCellValueFactory(new PropertyValueFactory<Pastel,String>("modificar"));

        tablaPasteles.getColumns().addAll(colTipoPan,colTamano,colRelleno,
                colPrecio);
    }

    public void agregarPastel(Pastel pastel){
        pasteles.add(pastel);
    }

    public TableView getTablaPasteles(){
        return tablaPasteles;
    }

    public int total(){
        int total=0;
        for(int i=0; i<pasteles.size();i++){
            total+=pasteles.get(i).getPrecio();
        }
        return total;
    }

}
