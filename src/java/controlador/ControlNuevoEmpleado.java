/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.DAO_NuevoCliente;
import modelo.dao.DAO_NuevoEmpleado;
import modelo.entidades.Empleado;
import modelo.entidades.Empresa;
import modelo.entidades.Puesto;
import modelo.entidades.Servicio;

/**
 *
 * @author PBFCIS-SRC-01
 */
@WebServlet(name = "ControlNuevoEmpleado", urlPatterns = {"/ControlNuevoEmpleado"})
public class ControlNuevoEmpleado extends HttpServlet {
    private DAO_NuevoEmpleado da;
    private Empleado empleado;
    private Puesto puesto;
    private Empresa empresa;
    private ArrayList<Empleado> empleadoList;
    
    private boolean filasAfectadas;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            this.da = new DAO_NuevoEmpleado();
            this.empleadoList = new ArrayList<>();
            this.empleadoList = this.da.getListEmpleados();
            request.setAttribute("listaEmpleado", this.empleadoList);
            request.getRequestDispatcher("NuevoEmpleado.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControlNuevoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        
        this.da = new DAO_NuevoEmpleado();
        this.empleado = new Empleado();
        this.empresa = new Empresa();
        this.puesto = new Puesto();
        
        if (request.getParameter("btn_agregar") != null ||
                request.getParameter("btn_modificar") != null) {
            try {
                this.empleado.setIdempleado(request.getParameter("dui"));
                this.empleado.setNombre(request.getParameter("nombre"));
                this.empleado.setApellido(request.getParameter("apellido"));
                this.empleado.setTelefono(request.getParameter("telefono"));
                this.empleado.setDireccion(request.getParameter("direccion"));
                this.puesto.setIdpuesto(Integer.parseInt(request.getParameter("idpuesto")));
                this.empresa.setNitEmpresa(request.getParameter("idempresa"));
                this.empleado.setPuesto(this.puesto);
                this.empleado.setEmpresa(this.empresa);
                
                if (this.empleado != null) {
                    this.da = new DAO_NuevoEmpleado(this.empleado);
                     if (request.getParameter("btn_agregar") != null) {
                        this.filasAfectadas = this.da.registrar();
                    }
                    else{
                        this.filasAfectadas = this.da.modificar();
                    }
                     
                    ///OTRO
                    if (filasAfectadas == true) {
                        try {
                            this.da = new DAO_NuevoEmpleado();
                            this.empleadoList = new ArrayList<>();
                            this.empleadoList = da.getListEmpleados();
                            request.setAttribute("listaEmpleado", this.empleadoList);
                            request.getRequestDispatcher("NuevoEmpleado.jsp").forward(request, response);
                        } catch (SQLException e) {
                            Logger.getLogger(ControlNuevoEmpleado.class.getName()).log(Level.SEVERE, null, e);
                        }
                    }
                }
                System.out.println("INSERTADO " + filasAfectadas);
//                this.da = new DAO_NuevoEmpleado(this.empleado);
//                
//                if (request.getParameter("btn_agregar") != null) {
//                    this.da.registrar();
//                }else{
//                    this.da.modificar();
//                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ControlNuevoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("NuevoEmpleado.jsp").forward(request, response);
        }
        
        //boton cancelar
        if (request.getParameter("botonCancelar") != null) {
            request.getRequestDispatcher("NuevoEmpleado.jsp").forward(request, response);
        }
        
        
        //editar
        if (request.getParameter("botonEditarEmpleado") != null) {
            try {
                String dui = request.getParameter("botonEditarEmpleado");
                this.empleado.setIdempleado(request.getParameter("botonEditarEmpleado"));
                this.da = new DAO_NuevoEmpleado(this.empleado);
                this.empleado = this.da.getEmpleado(); //REGISTRO RECUPERADO
                request.setAttribute("empleadoModificar", this.empleado);
                request.getRequestDispatcher("NuevoEmpleado.jsp").forward(request, response);
            } catch (SQLException e) {
                Logger.getLogger(ControlNuevoEmpleado.class.getName()).log(Level.SEVERE, null, e);
            }
            request.getRequestDispatcher("NuevoEmpleado.jsp").forward(request, response);
        } 
        
        ///ELIMINAR
        
        if (request.getParameter("botonBorrarEmpleado") != null) {
            try {
                this.empleado.setIdempleado(request.getParameter("botonBorrarEmpleado"));
                this.da = new DAO_NuevoEmpleado(this.empleado);
                this.da.eliminar();
            } catch (SQLException ex) {
                Logger.getLogger(ControlNuevoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("NuevoEmpleado.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
