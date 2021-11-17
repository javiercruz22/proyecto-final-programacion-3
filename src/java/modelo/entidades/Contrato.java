/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author PBFCIS-SRC-01
 */
public class Contrato implements Serializable{
    private int idContrato;
    private Servicio  servicio;
    private Cliente cliente;
    private Empleado empleado;
    //private Puesto puesto;
    private Date fechaInicio;
    private Date fechaFinal;
    private boolean vigente;
    private int nContrato; // llevar la cuenta de los contratos 

    public Contrato() {
    }

    public Contrato(int idContrato, Servicio servicio, Cliente cliente, Empleado empleado/*, Puesto puesto*/) {
        this.idContrato = idContrato;
        this.servicio = servicio;
        this.cliente = cliente;
        this.empleado = empleado;
        //this.puesto = puesto;
    }

    
    
    public Contrato(int idContrato, Servicio servicio, Cliente cliente, Empleado empleado, Date fechaInicio, Date fechaFinal, boolean vigente) {
        this.idContrato = idContrato;
        this.servicio = servicio;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.vigente = vigente;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public int getnContrato() {
        return nContrato;
    }

    public void setnContrato(int nContrato) {
        this.nContrato = nContrato;
    }
/*
    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
    */
    
}
