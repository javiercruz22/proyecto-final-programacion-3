/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.entidades.Cliente;
import modelo.entidades.Empleado;
import modelo.entidades.Empresa;
import modelo.entidades.Puesto;

/**
 *
 * @author PBFCIS-SRC-01
 */
public interface InterfazEmpleado {
    
    public boolean registrar() throws SQLException;
    
    public boolean modificar() throws SQLException;
    
    public boolean eliminar() throws SQLException;
    
    public ArrayList<Empleado> getListEmpleados() throws SQLException;
    
    public Empleado getEmpleado() throws SQLException;
    
    public ArrayList<Puesto> getListPuesto() throws SQLException;
    
    public Puesto getPuesto() throws SQLException;
    
    public Empresa getEmpresa() throws SQLException;
    
    public boolean validarEmpleado() throws SQLException;

}
