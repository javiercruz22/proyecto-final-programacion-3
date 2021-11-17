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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.entidades.Cliente;
import modelo.entidades.Empleado;
import modelo.entidades.Empresa;
import modelo.entidades.Puesto;
import modelo.entidades.Servicio;

/**
 *
 * @author PBFCIS-SRC-01
 */
public class DAO_Cliente {
    private static Conexion conexion;
    private Cliente cliente;
    private Servicio servicio; 
    private ArrayList<Cliente> clienteList;
    private ArrayList<Servicio> servicioList;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private String sql;
    
    public DAO_Cliente() {
        this.conexion = new Conexion();
    }
    
    public ArrayList<Servicio> getServicio() throws SQLException{
        this.servicioList = new ArrayList<>();
        
        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT cliente.nombrecliente, cliente.apellidocliente, servicio.servicio, servicio.precioservicio\n" +
                        "FROM servicio\n" +
                        "INNER JOIN contrato ON servicio.idservicio = contrato.idservicio\n" +
                        "INNER JOIN cliente ON contrato.idcliente = cliente.id_duicliente";

            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                Servicio servicio = new Servicio();
                Cliente cliente = new Cliente();

                cliente.setNombre(rs.getString("nombrecliente"));
                cliente.setApellido(rs.getString("apellidocliente"));
                servicio.setServicio(rs.getString("servicio"));
                servicio.setPrecio(rs.getDouble("precioservicio"));
                servicio.setCliente(cliente);
                this.servicioList.add(servicio);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return servicioList;
    }
    
    
}
