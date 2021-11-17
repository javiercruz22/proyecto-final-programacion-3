/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import interfaz.InterfazServicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.entidades.Cliente;
import modelo.entidades.Servicio;

/**
 *
 * @author PBFCIS-SRC-01
 */
public class DAO_NuevoServicio implements InterfazServicio {

    private static Conexion conexion;
    private Servicio servicio;
    private PreparedStatement ps;
    private Connection accesoDB;
    private String sql;
    private boolean filasAfectadas;
    
    private ResultSet rs = null;
    private ArrayList<Servicio> servicioList;
    private int codigo;
    
    public DAO_NuevoServicio() {
        this.conexion = new Conexion();
    }
    
    public DAO_NuevoServicio(Servicio servicioNuevo) {
        this.servicio = servicioNuevo;
    }
    
    @Override
    public boolean registrar() throws SQLException {
        try {
            Conexion con = new Conexion();
            Connection accesoDB = con.getConexion();
            this.sql = "insert into servicio(idservicio, servicio, precioservicio, periodo) values(?,?,?,?)";
            this.ps = accesoDB.prepareStatement(this.sql);
            this.ps.setInt(1, this.servicio.getIdServicio());
            this.ps.setString(2, this.servicio.getServicio());
            this.ps.setDouble(3, this.servicio.getPrecio());
            this.ps.setString(4, this.servicio.getPeriodo());
            this.ps.execute();
            
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            conexion.cerrarConexiones();
        }
        
    }

    @Override
    public boolean modificar() throws SQLException {
        try {
            this.accesoDB = this.conexion.getConexion();

            this.sql = ("UPDATE servicio SET idservicio = '" + this.servicio.getIdServicio()+ "',"
            + "servicio = '" + this.servicio.getServicio()+ "',"
            + "precioservicio = '" + this.servicio.getPrecio()+ "',"
            + "periodo = '" + this.servicio.getPeriodo()+ "' "
            + "WHERE idservicio = '" + this.servicio.getIdServicio()+ "';");
            this.ps = this.accesoDB.prepareStatement(this.sql);
            this.filasAfectadas = this.ps.execute();
            conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.filasAfectadas;
    }

    @Override
    public boolean eliminar() throws SQLException {
        try {
            this.accesoDB = conexion.getConexion();
            this.sql = ("DELETE FROM servicio WHERE idservicio = '" + servicio.getIdServicio()+ "'");
            this.ps = accesoDB.prepareStatement(sql);
            this.filasAfectadas = this.ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.filasAfectadas;
    }

    @Override
    public ArrayList<Servicio> getListServicios() throws SQLException {
        this.servicioList = new ArrayList<>();
        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT * FROM servicio";

            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                this.servicio = new Servicio();
                this.servicio.setIdServicio(rs.getInt("idservicio"));
                this.servicio.setServicio(rs.getString("servicio"));
                this.servicio.setPrecio(rs.getDouble("precioservicio"));
                this.servicio.setPeriodo(rs.getString("periodo"));
                
                this.servicioList.add(servicio);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return servicioList;
    }

    @Override
    public Servicio getServicio() throws SQLException {
        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT * FROM servicio WHERE idservicio = '" + this.servicio.getIdServicio()+ "'";
            this.ps = this.accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                this.servicio = new Servicio();
                this.servicio.setIdServicio(rs.getInt("idservicio"));
                this.servicio.setServicio(rs.getString("servicio"));
                this.servicio.setPrecio(rs.getDouble("precioservicio"));
                this.servicio.setPeriodo(rs.getString("periodo"));
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.servicio;
    }

    @Override
    public boolean validarServicio() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int id() throws SQLException{
        
        try {
            
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT  MAX(s.idservicio)+1 as id FROM servicio s";
            this.ps = this.accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
//                this.puesto = new Puesto();
//                this.puesto.setIdpuesto(this.rs.getInt("id"));
                codigo = this.rs.getInt("id");
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return codigo;
    }
    
}
