/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.entidades.Puesto;

/**
 *
 * @author PBFCIS-SRC-01
 */
public interface InterfazPuesto {
    
    public boolean registrar() throws SQLException;
    
    public boolean modificar() throws SQLException;
    
    public boolean eliminar() throws SQLException;
    
    public ArrayList<Puesto> getListPuestos() throws SQLException;
    
    public Puesto getPuesto() throws SQLException;
    
    public boolean validarPuesto() throws SQLException;
    
}
