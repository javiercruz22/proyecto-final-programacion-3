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
import modelo.entidades.Empleado;
import modelo.entidades.Empresa;
import modelo.entidades.Puesto;

/**
 *
 * @author PBFCIS-SRC-01
 */
public class DAO_Puestos {
    private static Conexion conexion;
    private Empresa empresa;
    private Empleado empleado;
    private Puesto puesto;
    private ArrayList<Puesto> puestoList;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private String sql;
    
    public DAO_Puestos(){
        this.conexion = new Conexion();
    }
    
    public ArrayList<Puesto> getPuesto() throws SQLException {
        this.puestoList = new ArrayList<>();
        
        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT empresa.\"nombreempresa\", puestos.\"nombrepuesto\"\n" +
                    "FROM empresa\n" +
                    "INNER JOIN empleado ON empresa.id_nitempresa = empleado.id_nitempresa\n" +
                    "INNER JOIN puestos ON empleado.puesto = puestos.idpuesto";
            
            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                Puesto puesto = new Puesto();
                Empresa empresa = new Empresa();

                empresa.setNombre(rs.getString("nombreempresa"));
                puesto.setNombrePuesto(rs.getString("nombrepuesto"));
                
                puesto.setEmpresa(empresa);
                this.puestoList.add(puesto);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return puestoList;
    }
    
}
