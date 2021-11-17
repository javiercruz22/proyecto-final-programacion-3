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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.entidades.Empleado;
import modelo.entidades.Empresa;
import modelo.entidades.Puesto;

/**
 *
 * @author PBFCIS-SRC-01
 */
public class DAO_EmpleadoCero {
    private static Conexion conexion;
    private Empleado empleado;
    private Puesto puesto;
    
    
    private Empresa empresa;
    private ArrayList<Empleado> empleadoList;
    private ArrayList<Empleado> contratoList;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private String sql;

    public DAO_EmpleadoCero() {
        this.conexion = new Conexion();
    }
    
    public ArrayList<Empleado> getCeroContrato() throws SQLException{
        this.contratoList = new ArrayList<>();
        
        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT (e.\"nombreempleado\" || ' ' || e.apellidoempleado) AS nombre , p.\"nombrepuesto\"\n" +
"                        FROM empleado as e\n" +
"                        INNER JOIN  puestos AS p ON e.puesto = p.idpuesto\n" +
"                        WHERE NOT EXISTS\n" +
"                        (SELECT *FROM contrato as c\n" +
"                        WHERE NOT e.puesto < 3\n" +
"                        );";

            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                this.empleado = new Empleado();
              this.puesto = new Puesto();
//                contrato = new Contrato();
                
                this.empleado.setNombre(this.rs.getString("nombre"));
                this.puesto.setNombrePuesto(this.rs.getString("nombrepuesto"));
//                contrato.setPuesto(puesto);
//                contrato.setEmpleado(empleado);
                this.empleado.setPuesto(this.puesto);
                this.contratoList.add(this.empleado);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return contratoList;
    }
   
    
}
