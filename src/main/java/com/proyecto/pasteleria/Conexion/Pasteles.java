package com.proyecto.pasteleria.Conexion;

import com.proyecto.pasteleria.Modelos.Pastel;
import javafx.scene.control.Button;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Pasteles {
    private List<Pastel> listaPasteles;
    private Conexion conexion;
    private String id;
    private String tipoPan;
    private String relleno;
    private String color;
    private String forma;
    private int pisos;
    private String tamano;
    private Double precio;
    private String detalles;
    public Pasteles(){
        listaPasteles = new ArrayList<>();
        conexion=new Conexion();
        conexion.iniciarConexion();

    }

    public void crearLista(){
        try{
            Connection conn = conexion.getConexion();
            String instSQL= "select * from Pastel where tipoPastel='Corriente';";
            PreparedStatement pinst = conn.prepareStatement(instSQL);
            ResultSet rPastel= pinst.executeQuery();
            while (rPastel.next()){
                id=rPastel.getString("id");
                tipoPan=rPastel.getString("tipoPan");
                relleno=rPastel.getString("relleno");
                color=rPastel.getString("color");
                forma=rPastel.getString("forma");
                pisos=rPastel.getInt("noPisos");
                tamano=rPastel.getString("tamano");
                precio=rPastel.getDouble("precio");
                detalles=rPastel.getString("detalles");

                Pastel pastel = new Pastel(id,tipoPan,relleno,color,forma,pisos,tamano,precio,detalles);

                listaPasteles.add(pastel);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Pastel> getListaPasteles(){
        return listaPasteles;
    }


}
