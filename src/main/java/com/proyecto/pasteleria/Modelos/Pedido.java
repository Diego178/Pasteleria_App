package com.proyecto.pasteleria.Modelos;

import java.sql.Date;
import java.sql.Time;

public class Pedido {
    private String id;
    private String nombre;
    private String telefono;
    private Date fechaPedido;
    private Date fechaEntrega;
    private Time horaEntrega;
    private Double total;
    private Double anticipo;
    private Double dineroPendiente;

    public Pedido() {
    }

    public Pedido(String id, String nombre, String telefono, Date fechaPedido, Date fechaEntrega, Time horaEntrega, Double total, Double anticipo, Double dineroPendiente) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.total = total;
        this.anticipo = anticipo;
        this.dineroPendiente = dineroPendiente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Time getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(Time horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(Double anticipo) {
        this.anticipo = anticipo;
    }

    public Double getDineroPendiente() {
        return dineroPendiente;
    }

    public void setDineroPendiente(Double dineroPendiente) {
        this.dineroPendiente = dineroPendiente;
    }
}
