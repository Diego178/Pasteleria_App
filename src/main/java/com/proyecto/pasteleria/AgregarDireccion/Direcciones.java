package com.proyecto.pasteleria.AgregarDireccion;

import com.proyecto.pasteleria.Modelos.Direccion;

import java.util.ArrayList;
import java.util.List;

public class Direcciones {
    private List<Direccion> direcciones;
    public Direcciones(){
        direcciones = new ArrayList<>();
        Direccion dir1=new Direccion();
        Direccion dir2=new Direccion();
        direcciones.add(dir1);
        direcciones.add(dir2);
    }
    public void agregarDireccion(Direccion direccion,int select){
        direcciones.set(select,direccion);

    }
    public void mostrarDirecciones(){
        System.out.println("//////////////");
        for(int i =0;i<direcciones.size();i++)
            System.out.println(direcciones.get(i).getColonia());
    }
    public int numeroDirecciones(){
        return direcciones.size();
    }
}
