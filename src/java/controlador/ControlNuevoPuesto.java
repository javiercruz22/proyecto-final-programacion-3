/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
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
import modelo.dao.DAO_NuevoPuesto;
import modelo.entidades.Puesto;

/**
 *
 * @author PBFCIS-SRC-01
 */
@WebServlet(name = "ControlNuevoPuesto", urlPatterns = {"/ControlNuevoPuesto"})
public class ControlNuevoPuesto extends HttpServlet {

    private DAO_NuevoPuesto da;
    private Puesto puesto;
    private ArrayList<Puesto> puestoList;
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
            this.da = new DAO_NuevoPuesto();
            this.puestoList = new ArrayList<>();
            this.puestoList = this.da.getListPuestos();
            request.setAttribute("listaPuesto", this.puestoList);
            request.getRequestDispatcher("NuevoPuesto.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControlNuevoPuesto.class.getName()).log(Level.SEVERE, null, ex);
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
    
        this.puesto = new Puesto();
        if (request.getParameter("btn_agregar") != null 
                || (request.getParameter("btn_modificar") != null)) {
            try {
                this.puesto.setIdpuesto(Integer.parseInt(request.getParameter("id")));
                this.puesto.setNombrePuesto(request.getParameter("nombre"));
                this.puesto.setSueldo(Float.parseFloat(request.getParameter("sueldo")));
//                int c = dao.id();
//                this.puesto.setIdpuesto(c);
                if (this.puesto != null) {
                    this.da = new DAO_NuevoPuesto(this.puesto);
                    if (request.getParameter("btn_agregar") != null) {
                        this.filasAfectadas = this.da.registrar();
                    }
                    else{
                        this.filasAfectadas = this.da.modificar();
                    }
                    ///OTRO
                    if (this.filasAfectadas == true) {
                        try {
                            this.da = new DAO_NuevoPuesto();
                            this.puestoList = new ArrayList<>();
                            this.puestoList = this.da.getListPuestos();
                            request.setAttribute("listaPuesto", this.puestoList);
                            request.getRequestDispatcher("NuevoPuesto.jsp").forward(request, response);
                        } catch (SQLException e) {
                            Logger.getLogger(ControlNuevoPuesto.class.getName()).log(Level.SEVERE, null, e);
                        }
                    }
                    
                }  
//                insert = this.da.registrar();
                System.out.println("INSERTADO " + this.filasAfectadas);
                
            } catch (SQLException e) {
                Logger.getLogger(ControlNuevoPuesto.class.getName()).log(Level.SEVERE, null, e);
            }
            request.getRequestDispatcher("NuevoPuesto.jsp").forward(request, response);
        }
        
        //eliminar
        if (request.getParameter("botonBorrarPuesto") != null) {
            String puesto = request.getParameter("botonBorrarPuesto");
            try {
                this.puesto.setIdpuesto(Integer.parseInt(request.getParameter("botonBorrarPuesto")));
                this.da = new DAO_NuevoPuesto(this.puesto);
                this.filasAfectadas = this.da.eliminar();
                if (this.filasAfectadas == true) {
                    try {
                        this.da = new DAO_NuevoPuesto();
                        this.puestoList = new ArrayList<>();
                        this.puestoList = da.getListPuestos();
                        request.setAttribute("listaPuesto", this.puestoList); 
                        request.getRequestDispatcher("NuevoPuesto.jsp").forward(request, response);
                    } catch (SQLException e) {
                        Logger.getLogger(ControlNuevoPuesto.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
            } catch (SQLException e) {
                Logger.getLogger(ControlNuevoPuesto.class.getName()).log(Level.SEVERE, null, e);
            }
            request.getRequestDispatcher("NuevoPuesto.jsp").forward(request, response);
        }
        
        //boton cancelar
        if (request.getParameter("botonCancelar") != null) {
            request.getRequestDispatcher("NuevoPuesto.jsp").forward(request, response);
        }
        
        //editar
        if (request.getParameter("botonEditarPuesto") != null) {
            try {
                String puesto = request.getParameter("botonEditarPuesto");
                this.puesto.setIdpuesto(Integer.parseInt(request.getParameter("botonEditarPuesto")));
                this.da = new DAO_NuevoPuesto(this.puesto);
                this.puesto = this.da.getPuesto(); //REGISTRO RECUPERADO
                request.setAttribute("puestoModificar", this.puesto);
                request.getRequestDispatcher("NuevoPuesto.jsp").forward(request, response);
            } catch (SQLException e) {
                Logger.getLogger(ControlNuevoPuesto.class.getName()).log(Level.SEVERE, null, e);
            }
            request.getRequestDispatcher("NuevoPuesto.jsp").forward(request, response);
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
