/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import interfaz.InterfazEmpresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.entidades.Empresa;
import modelo.entidades.Puesto;

/**
 *
 * @author PBFCIS-SRC-01
 */
public class DAO_Empresa implements InterfazEmpresa{

     private static Conexion conexion;
    private Empresa empresa;
    private PreparedStatement ps;
    private Connection accesoDB;
    private String sql;
    private boolean filasAfectadas;
    
    private ResultSet rs = null;
    private ArrayList<Empresa> empresaList;

    public DAO_Empresa() {
        this.conexion = new Conexion();
    }
    
    public DAO_Empresa(Empresa empresaNueva){
        this.empresa = empresaNueva;
    }
    
    @Override
    public boolean registrar() throws SQLException {
        try {
            Conexion con = new Conexion();
            Connection accesoDB = con.getConexion();
            this.sql = "INSERT INTO empresa(id_nitempresa, \"nombreEmpresa\", \"telefonoEmpresa\", \"direccionEmpresa\" ) VALUES(?,?,?,?)";
            this.ps = accesoDB.prepareStatement(this.sql);
            this.ps.setString(1, this.empresa.getNitEmpresa());
            this.ps.setString(2, this.empresa.getNombre());
            this.ps.setString(3, this.empresa.getTelefono());
            this.ps.setString(4, this.empresa.getDireccion());
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Empresa> getListEmpresa() throws SQLException {
        this.empresaList = new ArrayList<>();
        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT * FROM empresa";

            this.ps = this.accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                this.empresa = new Empresa();
                this.empresa.setNitEmpresa(this.rs.getString("id_nitempresa"));
                this.empresa.setNombre(this.rs.getString("nombreEmpresa"));
                this.empresa.setTelefono(this.rs.getString("telefonoEmpresa"));
                this.empresa.setDireccion(this.rs.getString("direccionEmpresa"));
                                
                this.empresaList.add(this.empresa);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.empresaList;
    }

    @Override
    public Empresa getEmpresa() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarEmpresa() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
