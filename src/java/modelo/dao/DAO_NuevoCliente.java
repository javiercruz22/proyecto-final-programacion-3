/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import interfaz.InterfazCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.entidades.Cliente;

/**
 *
 * @author PBFCIS-SRC-01
 */
public class DAO_NuevoCliente implements InterfazCliente{
    private static Conexion conexion;
    private Cliente cliente;
    private PreparedStatement ps;
    private Connection accesoDB;
    private String sql;
    private boolean filasAfectadas;
    
    private ResultSet rs = null;
    private ArrayList<Cliente> clienteList;
    
    public DAO_NuevoCliente() {
        this.conexion = new Conexion();
    }
    
    public DAO_NuevoCliente(Cliente clienteNuevo) {
        this.cliente = clienteNuevo;
    }

    @Override
    public boolean registrar() throws SQLException {
        try {
            Conexion con = new Conexion();
            Connection accesoDB = con.getConexion();
            this.sql = "insert into cliente(id_duicliente, nombrecliente, apellidocliente, telefonocliente, direccioncliente) values(?,?,?,?,?)";
            this.ps = accesoDB.prepareStatement(this.sql);
            this.ps.setString(1, this.cliente.getIdCliente());
            this.ps.setString(2, this.cliente.getNombre());
            this.ps.setString(3, this.cliente.getApellido());
            this.ps.setString(4, this.cliente.getTelefono());
            this.ps.setString(5, this.cliente.getDireccion());
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

            this.sql = ("UPDATE cliente SET id_duicliente = '" + this.cliente.getIdCliente() + "',"
            + "nombrecliente = '" + this.cliente.getNombre() + "',"
            + "apellidocliente = '" + this.cliente.getApellido() + "',"
            + "telefonocliente = '" + this.cliente.getTelefono()+ "'," 
            + "direccioncliente = '" + this.cliente.getDireccion()+ "' "
            + "WHERE id_duicliente = '" + this.cliente.getIdCliente() + "';");
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
            this.sql = ("DELETE FROM cliente WHERE id_duicliente = '" + cliente.getIdCliente() + "'");
            this.ps = accesoDB.prepareStatement(sql);
            this.filasAfectadas = this.ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.filasAfectadas;
    }

    @Override
    public ArrayList<Cliente> getListClientes() throws SQLException {
        this.clienteList = new ArrayList<>();
        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT * FROM cliente";

            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                this.cliente = new Cliente();
                this.cliente.setIdCliente(rs.getString("id_duicliente"));
                this.cliente.setNombre(rs.getString("nombrecliente"));
                this.cliente.setApellido(rs.getString("apellidocliente"));
                this.cliente.setTelefono(rs.getString("telefonocliente"));
                this.cliente.setDireccion(rs.getString("direccioncliente"));
                
                this.clienteList.add(cliente);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return clienteList;
    }

    @Override
    public Cliente getCliente() throws SQLException {
        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT * FROM cliente WHERE id_duicliente = '" + this.cliente.getIdCliente() + "'";
            this.ps = this.accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                this.cliente = new Cliente();
                this.cliente.setIdCliente(rs.getString("id_duicliente"));
                this.cliente.setNombre(rs.getString("nombrecliente"));
                this.cliente.setApellido(rs.getString("apellidocliente"));
                this.cliente.setTelefono(rs.getString("telefonocliente"));
                this.cliente.setDireccion(rs.getString("direccioncliente"));
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.cliente;
    }
    
    @Override
    public boolean validarCliente() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
