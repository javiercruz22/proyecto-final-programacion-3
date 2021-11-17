/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;

/**
 *
 * @author PBFCIS-SRC-01
 */
public class Servicio implements Serializable{
    private int idServicio;
    private String servicio;
    private double precio;
    private String periodo;
    private Cliente cliente;
    private Empresa empresa;

    public Servicio() {
    }

    public Servicio(int idServicio, String servicio, double precio, String periodo, Cliente cliente, Empresa empresa) {
        this.idServicio = idServicio;
        this.servicio = servicio;
        this.precio = precio;
        this.periodo = periodo;
        this.cliente = cliente;
        this.empresa = empresa;
    }

    public Servicio(int idServicio, String servicio, double precio, String periodo) {
        this.idServicio = idServicio;
        this.servicio = servicio;
        this.precio = precio;
        this.periodo = periodo;
    }
    
    
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
     
    @Override
    public String toString() {
        return servicio;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
    
}
