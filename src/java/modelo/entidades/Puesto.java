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
public class Puesto implements Serializable{
    private int idpuesto;
    private String nombrePuesto;
    private Empresa empresa;
    private double sueldo;

    public Puesto() {
    }

    public Puesto(int idpuesto, String nombrePuesto, Empresa empresa, double sueldo) {
        this.idpuesto = idpuesto;
        this.nombrePuesto = nombrePuesto;
        this.empresa = empresa;
        this.sueldo = sueldo;
    }

    public Puesto(String nombrePuesto, Empresa empresa) {
        this.nombrePuesto = nombrePuesto;
        this.empresa = empresa;
    }

    public Puesto(String nombrePuesto, double sueldo) {
        this.nombrePuesto = nombrePuesto;
        this.sueldo = sueldo;
    }
    
    

    public int getIdpuesto() {
        return idpuesto;
    }

    public void setIdpuesto(int idpuesto) {
        this.idpuesto = idpuesto;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    @Override
    public String toString() {
        return nombrePuesto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
}
