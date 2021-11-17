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
public class Empleado implements Serializable{
    private String idempleado;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
//    private String puesto;
    private double sueldo;
    private Empresa empresa;
    private Puesto puesto;

    public Empleado() {
    }

    public Empleado(String idempleado, String nombre, String apellido, String telefono, String direccion, double sueldo, Empresa empresa, Puesto puesto) {
        this.idempleado = idempleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.sueldo = sueldo;
        this.empresa = empresa;
        this.puesto = puesto;
    }

    public Empleado(String nombre, String apellido, String telefono, String direccion, double sueldo, Empresa empresa, Puesto puesto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.sueldo = sueldo;
        this.empresa = empresa;
        this.puesto = puesto;
    }
    
    
    
    
    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

   
    
}
