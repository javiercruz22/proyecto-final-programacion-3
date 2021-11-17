/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.entidades.Contrato;
import modelo.entidades.Empleado;
import modelo.entidades.Empresa;
import modelo.entidades.Puesto;

/**
 *
 * @author PBFCIS-SRC-01
 */

public class DAO_Empleado {
    private static Conexion conexion;
    private Empleado empleado;
    private Puesto puesto;
    
    
    private Empresa empresa;
    private ArrayList<Empleado> empleadoList;
    private ArrayList<Empleado> contratoList;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private String sql;
    
    public DAO_Empleado(){
        this.conexion = new Conexion();
    }
    
    public ArrayList<Empleado> getListEmpleados() throws SQLException{
        this.empleadoList = new ArrayList<>();
        
        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT empresa.\"nombreempresa\", empleado.\"nombreempleado\", empleado.apellidoempleado, puestos.sueldo, puestos.\"nombrepuesto\"\n" +
                        "FROM empresa\n" +
                        "INNER JOIN empleado ON empresa.id_nitempresa = empleado.id_nitempresa\n" +
                        "INNER JOIN puestos ON empleado.puesto = puestos.idpuesto";

            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                Empleado empleado = new Empleado();
                Puesto puesto = new Puesto();
                Empresa empresa = new Empresa();

                empresa.setNombre(rs.getString("nombreempresa"));
                empleado.setNombre(rs.getString("nombreempleado"));
                empleado.setApellido(rs.getString("apellidoempleado"));
                empleado.setSueldo(rs.getDouble("sueldo"));
                puesto.setNombrePuesto(rs.getString("nombrepuesto"));
//                empleado.setPuesto(rs.getString("nombrePuesto"));
                empleado.setPuesto(puesto);
                empleado.setEmpresa(empresa);
                this.empleadoList.add(empleado);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return empleadoList;
    }
    
    
}
