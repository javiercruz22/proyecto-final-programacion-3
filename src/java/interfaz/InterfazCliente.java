/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.entidades.Cliente;

/**
 *
 * @author PBFCIS-SRC-01
 */
public interface InterfazCliente {
    
    public boolean registrar() throws SQLException;
    
    public boolean modificar() throws SQLException;
    
    public boolean eliminar() throws SQLException;
    
    public ArrayList<Cliente> getListClientes() throws SQLException;
    
    public Cliente getCliente() throws SQLException;
    
    public boolean validarCliente() throws SQLException;
    
}
