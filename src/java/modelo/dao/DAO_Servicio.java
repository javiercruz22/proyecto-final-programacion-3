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
import modelo.entidades.Empresa;

import modelo.entidades.Servicio;

/**
 *
 * @author PBFCIS-SRC-01
 */

public class DAO_Servicio {
    private static Conexion conexion;
    private Servicio servicio;
    
    private Empresa empresa;
    private ArrayList<Servicio> servicioList;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private String sql;
    
    public DAO_Servicio(){
        this.conexion = new Conexion();
    }
    
    public ArrayList<Servicio> getServicio() throws SQLException{
        this.servicioList =new ArrayList<>();
        
        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT empresa.\"nombreempresa\", servicio.servicio, servicio.periodo\n" +
                        "FROM servicio \n" +
                        "INNER JOIN contrato ON servicio.idservicio = contrato.idservicio\n" +
                        "INNER JOIN empleado ON contrato.idempleado = empleado.id_duiempleado\n" +
                        "INNER JOIN empresa ON empleado.id_nitempresa = empresa.id_nitempresa";
            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                Servicio  servicio = new Servicio();
                
                Empresa empresa = new Empresa();
                
                empresa.setNombre(rs.getString("nombreempresa"));
                servicio.setServicio(rs.getString("servicio"));
                servicio.setPeriodo(rs.getString("periodo"));
                servicio.setEmpresa(empresa);
                this.servicioList.add(servicio);
            }
            this.conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return servicioList;
    }
}
