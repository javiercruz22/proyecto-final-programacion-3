/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import interfaz.InterfazEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class DAO_NuevoEmpleado implements InterfazEmpleado{

    private static Conexion conexion;
    private Empleado empleado;
    private Puesto puesto;
    private Empresa empresa;
    private PreparedStatement ps;
    private Connection accesoDB;
    private String sql;
    private boolean filasAfectadas;
    
    private ResultSet rs = null;
    private ArrayList<Empleado> empleadoList;
    
    public DAO_NuevoEmpleado(){
        this.conexion = new Conexion();
    }
    
    public DAO_NuevoEmpleado(Empleado nuevoEmpleado){
        this.empleado = nuevoEmpleado;
    }
    
    @Override
    public boolean registrar() throws SQLException {
        try {
            Conexion con = new Conexion();
            accesoDB = con.getConexion();
            
            this.sql = "insert into empleado(id_duiempleado, \"nombreempleado\", apellidoempleado, telefonoempleado, direccionempleado, puesto, id_nitempresa) values(?,?,?,?,?,?,?)";
            this.ps = accesoDB.prepareStatement(this.sql);
            this.ps.setString(1, this.empleado.getIdempleado());
            this.ps.setString(2, this.empleado.getNombre());
            this.ps.setString(3, this.empleado.getApellido());
            this.ps.setString(4, this.empleado.getTelefono());
            this.ps.setString(5, this.empleado.getDireccion());
            this.ps.setInt(6, this.empleado.getPuesto().getIdpuesto());
            this.ps.setString(7, this.empleado.getEmpresa().getNitEmpresa());
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

            this.sql = ("UPDATE empleado SET id_duiempleado = '" + this.empleado.getIdempleado()+ "',"
            + "nombreempleado = '" + this.empleado.getNombre()+ "',"
            + "apellidoempleado = '" + this.empleado.getApellido()+ "',"
            + "telefonoempleado = '" + this.empleado.getTelefono()+ "', "
            + "direccionempleado = '" + this.empleado.getDireccion()+ "', "
            + "puesto = '" + this.empleado.getPuesto().getIdpuesto()+ "', "
            + "id_nitempresa = '" + this.empleado.getEmpresa().getNitEmpresa()+ "' "
            + "WHERE id_duiempleado = '" + this.empleado.getIdempleado()+ "';");
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
            this.accesoDB = this.conexion.getConexion();
            this.sql = ("DELETE FROM empleado WHERE id_duiempleado = '" + this.empleado.getIdempleado()+ "'");
            this.ps = this.accesoDB.prepareStatement(this.sql);
            this.filasAfectadas = this.ps.execute();
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e,"ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.filasAfectadas;      
    }

    @Override
    public ArrayList<Empleado> getListEmpleados() throws SQLException {
        this.empleadoList = new ArrayList<>();
        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT e.\"nombreempresa\", emp.id_duiempleado, emp.\"nombreempleado\", emp.apellidoempleado, emp.telefonoempleado, emp.direccionempleado, p.\"nombrepuesto\"\n" +
                        "FROM puestos p\n" +
                        "INNER JOIN empleado emp ON p.idpuesto = emp.puesto\n" +
                        "INNER JOIN empresa e ON emp.id_nitempresa = emp.id_nitempresa";

            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                this.empleado = new Empleado();
                this.empresa = new Empresa();
                this.puesto = new Puesto();
                
                this.empresa.setNombre(rs.getString("nombreempresa"));
                this.empleado.setIdempleado(rs.getString("id_duiempleado"));
                this.empleado.setNombre(rs.getString("nombreempleado"));
                this.empleado.setApellido(rs.getString("apellidoempleado"));
                this.empleado.setTelefono(rs.getString("telefonoempleado"));
                this.empleado.setDireccion(rs.getString("direccionempleado"));
                this.puesto.setNombrePuesto(rs.getString("nombrepuesto")); 
                this.empleado.setEmpresa(this.empresa);
                this.empleado.setPuesto(this.puesto);
                
                
                this.empleadoList.add(empleado);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return empleadoList;
    }

    @Override
    public Empleado getEmpleado() throws SQLException {
        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT e.id_duiempleado, e.nombreempleado,\n" +
"				e.apellidoempleado, e.telefonoempleado, \n" +
"				e.direccionempleado,p.idpuesto, p.nombrepuesto, em.nombreempresa, em.id_nitempresa\n" +
"FROM empresa em\n" +
"INNER JOIN empleado e ON em.id_nitempresa = e.id_nitempresa\n" +
"INNER JOIN puestos p ON e.puesto = p.idpuesto\n" +
"WHERE e.id_duiempleado = '" + this.empleado.getIdempleado()+ "'";
            
            this.ps = this.accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                this.empleado = new Empleado();
                this.puesto = new Puesto();
                this.empresa = new Empresa();
                this.empleado.setIdempleado(rs.getString("id_duiempleado"));
                this.empleado.setNombre(rs.getString("nombreempleado"));
                this.empleado.setApellido(rs.getString("apellidoempleado"));
                this.empleado.setTelefono(rs.getString("telefonoempleado"));
                this.empleado.setDireccion(rs.getString("direccionempleado"));
                this.puesto.setNombrePuesto(rs.getString("nombrepuesto"));
                this.empresa.setNombre(rs.getString("nombreempresa"));
                
                this.puesto.setIdpuesto(rs.getInt("idpuesto"));
                this.empresa.setNitEmpresa(rs.getString("id_nitempresa"));
                
                this.empleado.setPuesto(this.puesto);
                this.empleado.setEmpresa(this.empresa);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.empleado;
    }

    @Override
    public boolean validarEmpleado() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Puesto getPuesto() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Puesto> getListPuesto() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empresa getEmpresa() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
