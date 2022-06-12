package com.proyecto.pasteleria.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDireccion {

        private Connection con;

        public ConexionDireccion(){
        }

        public void iniciarConexion(){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Direccion?serverTimezone=UTC", "root","1234");

            }catch (Exception e){
                System.out.println(e);
            }
        }

        public Connection getConexion(){
            return con;
        }
}
