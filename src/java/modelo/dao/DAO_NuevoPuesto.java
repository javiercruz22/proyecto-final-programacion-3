/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import interfaz.InterfazPuesto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.entidades.Puesto;

/**
 *
 * @author PBFCIS-SRC-01
 */
public class DAO_NuevoPuesto implements InterfazPuesto {

    private static Conexion conexion;
    private Puesto puesto;
    private PreparedStatement ps;
    private Connection accesoDB;
    private String sql;
    private boolean filasAfectadas;
    
    private ResultSet rs = null;
    private ArrayList<Puesto> puestoList;
    private int codigo;
    
    public DAO_NuevoPuesto(){
        this.conexion = new Conexion();
    }
    
    public DAO_NuevoPuesto(Puesto puestoNuevo){
        this.puesto = puestoNuevo;
    }
    
    @Override
    public boolean registrar() throws SQLException {
        try {
            Conexion con = new Conexion();
            Connection accesoDB = con.getConexion();
            this.sql = "insert into puestos(idpuesto, \"nombrePuesto\", sueldo) values(?,?,?)";
            this.ps = accesoDB.prepareStatement(this.sql);
            this.ps.setInt(1, this.puesto.getIdpuesto());
            this.ps.setString(2, this.puesto.getNombrePuesto());
            this.ps.setDouble(3, this.puesto.getSueldo());
            
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

            this.sql = ("UPDATE puestos SET idpuesto = '" + this.puesto.getIdpuesto() + "'," 
            +"\"nombrePuesto\" = '" + this.puesto.getNombrePuesto()+ "'," 
            + "sueldo = '" + this.puesto.getSueldo()+ "' "
            + "WHERE idpuesto = '" + this.puesto.getIdpuesto()+ "';");
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
            this.sql = ("DELETE FROM puestos WHERE idpuesto = '" + puesto.getIdpuesto()+ "'");
            this.ps = accesoDB.prepareStatement(sql);
            this.filasAfectadas = this.ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.filasAfectadas;
    }

    @Override
    public ArrayList<Puesto> getListPuestos() throws SQLException {
        this.puestoList = new ArrayList<>();
        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT * FROM puestos";

            this.ps = this.accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                this.puesto = new Puesto();
                this.puesto.setIdpuesto(this.rs.getInt("idpuesto"));
                this.puesto.setNombrePuesto(this.rs.getString("nombrePuesto"));
                this.puesto.setSueldo(this.rs.getFloat("sueldo"));
                                
                this.puestoList.add(this.puesto);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return puestoList;
    }

    @Override
    public Puesto getPuesto() throws SQLException {
        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT * FROM puestos WHERE idpuesto = '" + this.puesto.getIdpuesto()+ "'";
            this.ps = this.accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                this.puesto = new Puesto();
                this.puesto.setIdpuesto(this.rs.getInt("idpuesto"));
                this.puesto.setNombrePuesto(this.rs.getString("nombrePuesto"));
                this.puesto.setSueldo(this.rs.getFloat("sueldo"));
                
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.puesto;
    }

    @Override
    public boolean validarPuesto() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int id() throws SQLException{
        
        try {
            
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT  MAX(p.idpuesto)+1 as id FROM puestos p ";
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
