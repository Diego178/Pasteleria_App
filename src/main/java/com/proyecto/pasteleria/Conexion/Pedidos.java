package com.proyecto.pasteleria.Conexion;

import com.proyecto.pasteleria.Modelos.Direccion;
import com.proyecto.pasteleria.Modelos.Pastel;
import com.proyecto.pasteleria.Modelos.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pedidos {
    private String id;
    private String nombre;
    private String telefono;
    private Date fechaPedido;
    private Date fechaEntrega;
    private Time horaEntrega;
    private Double total;
    private Double anticipo;
    private Double dineroPendiente;
    private Conexion conexion;
    private List<Pedido> listaPedidos;
    private List<Pastel> pasteles;
    private List<Direccion> direcciones;

    public Pedidos(){
        listaPedidos = new ArrayList<>();
        conexion=new Conexion();
        conexion.iniciarConexion();
    }

    public void crearLista(){
        try{
            Connection conn = conexion.getConexion();
            String instSQL= "select * from Pedido where entregado=false;";
            PreparedStatement pinst = conn.prepareStatement(instSQL);
            ResultSet rPedido= pinst.executeQuery();
            while (rPedido.next()){
                id=rPedido.getString("id");
                nombre=rPedido.getString("nombreCliente");
                telefono=rPedido.getString("telefono");
                fechaPedido=rPedido.getDate("fechaPedido");
                fechaEntrega=rPedido.getDate("fechaEntrega");
                horaEntrega=rPedido.getTime("horaEntrega");
                total=rPedido.getDouble("total");
                anticipo=rPedido.getDouble("anticipo");
                dineroPendiente=rPedido.getDouble("dineroPendiente");

                Pedido pedido = new Pedido(id, nombre, telefono, fechaPedido, fechaEntrega, horaEntrega, total, anticipo, dineroPendiente);

                listaPedidos.add(pedido);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Pedido> getListaPedidos(){
        return listaPedidos;
    }

    public void crearListaPasteles(String idPastel){
        pasteles = new ArrayList<>();
        try{
            Connection conn = conexion.getConexion();
            String instSQL= "select * from PastelPedido where idPedido='"+idPastel+"';";
            PreparedStatement pinst = conn.prepareStatement(instSQL);
            ResultSet rPastelPedido= pinst.executeQuery();
            while (rPastelPedido.next()){
                String id=rPastelPedido.getString("id");
                String tipoPan=rPastelPedido.getString("tipoPan");
                String relleno=rPastelPedido.getString("relleno");
                String color=rPastelPedido.getString("color");
                String forma=rPastelPedido.getString("forma");
                int pisos=rPastelPedido.getInt("noPisos");
                String tamano=rPastelPedido.getString("tamano");
                Double precio=rPastelPedido.getDouble("precio");
                String detalles=rPastelPedido.getString("detalles");

                Pastel pastel = new Pastel(id,tipoPan,relleno,color,forma,pisos,tamano,precio,detalles);

                pasteles.add(pastel);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List getListaPasteles(){
        return pasteles;
    }

    public List<Direccion> getDirecciones(String idPastel){
        direcciones = new ArrayList<>();
        try{
            Connection conn = conexion.getConexion();
            String instSQL= "select * from direccion where idPedido='"+idPastel+"';";
            PreparedStatement pinst = conn.prepareStatement(instSQL);
            ResultSet rDireccion= pinst.executeQuery();
            while (rDireccion.next()){
                String estado = rDireccion.getString("estado");
                String ciudad = rDireccion.getString("ciudad");
                String colonia = rDireccion.getString("colonia");
                String calle = rDireccion.getString("calle");
                int numero = rDireccion.getInt("numero");
                String tipo = rDireccion.getString("tipo");

                Direccion direccion = new Direccion(estado, ciudad, colonia, calle, numero, tipo);

                direcciones.add(direccion);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return direcciones;
    }

    public Pedido getPedido(String idPed){
        try{
            Connection conn = conexion.getConexion();
            String instSQL= "select * from Pedido where id='"+idPed+"';";
            PreparedStatement pinst = conn.prepareStatement(instSQL);
            ResultSet rPedido= pinst.executeQuery();
            while (rPedido.next()){
                id=rPedido.getString("id");
                nombre=rPedido.getString("nombreCliente");
                telefono=rPedido.getString("telefono");
                fechaPedido=rPedido.getDate("fechaPedido");
                fechaEntrega=rPedido.getDate("fechaEntrega");
                horaEntrega=rPedido.getTime("horaEntrega");
                total=rPedido.getDouble("total");
                anticipo=rPedido.getDouble("anticipo");
                dineroPendiente=rPedido.getDouble("dineroPendiente");

                Pedido pedido = new Pedido(id, nombre, telefono, fechaPedido, fechaEntrega, horaEntrega, total, anticipo, dineroPendiente);

                return pedido;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

}
