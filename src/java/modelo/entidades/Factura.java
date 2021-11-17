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
public class Factura implements Serializable{
    private int idfactura;
    private Date fecha;
    private Contrato contrato;
//    private Empleado empleado;  //quitar

    public Factura() {
    }

    public Factura(int idfactura, Date fecha, Contrato contrato/*, Empleado empleado*/) {
        this.idfactura = idfactura;
        this.fecha = fecha;
        this.contrato = contrato;
        //this.empleado = empleado;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
    /*
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
*/
    
    
}
