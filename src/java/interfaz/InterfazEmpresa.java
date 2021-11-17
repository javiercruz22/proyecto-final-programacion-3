/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.entidades.Empresa;

/**
 *
 * @author PBFCIS-SRC-01
 */
public interface InterfazEmpresa {
    
    public boolean registrar() throws SQLException;
    
    public boolean modificar() throws SQLException;
    
    public boolean eliminar() throws SQLException;
    
    public ArrayList<Empresa> getListEmpresa() throws SQLException;
    
    public Empresa getEmpresa() throws SQLException;
    
    public boolean validarEmpresa() throws SQLException;
}
