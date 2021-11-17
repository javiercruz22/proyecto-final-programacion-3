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
public class Empresa implements Serializable{
    private String nitEmpresa;
    private String nombre;
    private String telefono;
    private String direccion;
    

    public Empresa() {
    }

    public Empresa(String nitEmpresa, String nombre, String telefono, String direccion) {
        this.nitEmpresa = nitEmpresa;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
