/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.entidades.Servicio;

/**
 *
 * @author PBFCIS-SRC-01
 */
public interface InterfazServicio {
    
    public boolean registrar() throws SQLException;
    
    public boolean modificar() throws SQLException;
    
    public boolean eliminar() throws SQLException;
    
    public ArrayList<Servicio> getListServicios() throws SQLException;
    
    public Servicio getServicio() throws SQLException;
    
    public boolean validarServicio() throws SQLException;
    
}
