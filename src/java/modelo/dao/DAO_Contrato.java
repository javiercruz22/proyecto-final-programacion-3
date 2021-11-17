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
import modelo.entidades.Servicio;

/**
 *
 * @author PBFCIS-SRC-01
 */
public class DAO_Contrato {
    private static Conexion conexion;
    private Servicio servicio;
    private Contrato contrato;
    private Puesto puesto;
    private Empleado empleado;
    
    private ArrayList<Contrato> contratoList;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private String sql;

    public DAO_Contrato() {
        this.conexion = new Conexion();
    }
    
    public ArrayList<Contrato> getContrato() throws SQLException{
        this.contratoList =new ArrayList<>();
        
        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT serv.servicio, serv.precioservicio,  COUNT(con.idservicio) AS totalContratoServicio\n" +
                        "FROM servicio serv\n" +
                        "INNER JOIN contrato con ON con.idservicio = serv.idservicio\n" +
                        "GROUP BY serv.servicio, serv.precioservicio\n" +
                        "ORDER BY totalContratoServicio DESC";
            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                this.servicio = new Servicio();
                
                this.contrato = new Contrato();
                
                this.servicio.setServicio(rs.getString("servicio"));
                this.servicio.setPrecio(rs.getDouble("precioservicio"));
                this.contrato.setnContrato(rs.getInt("totalContratoServicio"));
                this.contrato.setServicio(this.servicio);
                this.contratoList.add(contrato);
            }
            this.conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return contratoList;
    }
    
    public ArrayList<Contrato> getCeroContrato() throws SQLException{
        this.contratoList = new ArrayList<>();
        
        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT (e.\"nombreempleado\" || ' ' || e.apellidoempleado) AS nombre , p.\"nombrepuesto\"\n" +
                        "FROM empleado as e\n" +
                        "INNER JOIN  puestos AS p ON e.puesto = p.idpuesto\n" +
                        "WHERE NOT EXISTS\n" +
                        "(SELECT *FROM contrato as c\n" +
                        "	WHERE NOT e.puesto < 3\n" +
                        ");\n" +
                        "GROUP BY p.\"nombrepuesto\"";

            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                empleado = new Empleado();
                puesto = new Puesto();
                contrato = new Contrato();
                
                contrato.getEmpleado().setNombre(rs.getString("nombre"));
                contrato.getEmpleado().getPuesto().setNombrePuesto(rs.getString("nombrepuesto"));
//                contrato.setPuesto(puesto);
//                contrato.setEmpleado(empleado);
                
                this.contratoList.add(contrato);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return contratoList;
    }
   
    
}
