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
import modelo.dao.DAO_NuevoServicio;
import modelo.entidades.Cliente;
import modelo.entidades.Servicio;

/**
 *
 * @author PBFCIS-SRC-01
 */
@WebServlet(name = "ControlNuevoServicio", urlPatterns = {"/ControlNuevoServicio"})
public class ControlNuevoServicio extends HttpServlet {

    private DAO_NuevoServicio da;
    private Servicio servicio;
    private ArrayList<Servicio> servicioList;
//    private boolean insert;
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
            this.da = new DAO_NuevoServicio();
            this.servicioList = new ArrayList<>();
            this.servicioList = this.da.getListServicios();
            request.setAttribute("listaServicio", this.servicioList);
            request.getRequestDispatcher("NuevoServicio.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControlNuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
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

        this.servicio = new Servicio();
        //REGISTRO DE SERVICIO
        if (request.getParameter("btn_agregar") != null 
                || (request.getParameter("btn_modificar") != null)) {
            try {
                this.servicio.setIdServicio(Integer.parseInt(request.getParameter("id")));
                this.servicio.setServicio(request.getParameter("servicio"));
                this.servicio.setPrecio(Double.parseDouble(request.getParameter("precio")));
                this.servicio.setPeriodo(request.getParameter("periodo"));
                
                if (this.servicio != null) {
                    this.da = new DAO_NuevoServicio(this.servicio);
                    if (request.getParameter("btn_agregar") != null) {
                        this.filasAfectadas = this.da.registrar();
                    }
                    else{
                        this.filasAfectadas = this.da.modificar();
                    }
                    ///OTRO
                    if (filasAfectadas == true) {
                        try {
                            this.da = new DAO_NuevoServicio();
                            this.servicioList = new ArrayList<>();
                            this.servicioList = da.getListServicios();
                            request.setAttribute("listaServicio", this.servicioList);
                            request.getRequestDispatcher("NuevoServicio.jsp").forward(request, response);
                        } catch (SQLException e) {
                            Logger.getLogger(ControlNuevoServicio.class.getName()).log(Level.SEVERE, null, e);
                        }
                    }
                    
                }  
//                insert = this.da.registrar();
                System.out.println("INSERTADO " + filasAfectadas);
                
            } catch (SQLException e) {
                Logger.getLogger(ControlNuevoServicio.class.getName()).log(Level.SEVERE, null, e);
            }
            request.getRequestDispatcher("NuevoServicio.jsp").forward(request, response);
        }
        
        //eliminar
        if (request.getParameter("botonBorrarServicio") != null) {
            String dui = request.getParameter("botonBorrarServicio");
            try {
                this.servicio.setIdServicio(Integer.parseInt(request.getParameter("botonBorrarServicio")));
                this.da = new DAO_NuevoServicio(this.servicio);
                this.filasAfectadas = this.da.eliminar();
                if (filasAfectadas == true) {
                    try {
                        this.da = new DAO_NuevoServicio();
                        this.servicioList = new ArrayList<>();
                        this.servicioList = da.getListServicios();
                        request.setAttribute("listaServicio", this.servicioList); 
                        request.getRequestDispatcher("NuevoServicio.jsp").forward(request, response);
                    } catch (SQLException e) {
                        Logger.getLogger(ControlNuevoServicio.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
            } catch (SQLException e) {
                Logger.getLogger(ControlNuevoServicio.class.getName()).log(Level.SEVERE, null, e);
            }
            request.getRequestDispatcher("NuevoServicio.jsp").forward(request, response);
        }
        
        //boton cancelar
        if (request.getParameter("botonCancelar") != null) {
            request.getRequestDispatcher("NuevoServicio.jsp").forward(request, response);
        }
        
        //editar
        if (request.getParameter("botonEditarServicio") != null) {
            try {
                String id = request.getParameter("botonEditarServicio");
                this.servicio.setIdServicio(Integer.parseInt(request.getParameter("botonEditarServicio")));
                this.da = new DAO_NuevoServicio(this.servicio);
                this.servicio = this.da.getServicio(); //REGISTRO RECUPERADO
                request.setAttribute("servicioModificar", this.servicio);
                request.getRequestDispatcher("NuevoServicio.jsp").forward(request, response);
            } catch (SQLException e) {
                Logger.getLogger(ControlNuevoServicio.class.getName()).log(Level.SEVERE, null, e);
            }
            request.getRequestDispatcher("NuevoServicio.jsp").forward(request, response);
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
