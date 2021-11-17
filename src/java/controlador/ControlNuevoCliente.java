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
import modelo.entidades.Cliente;

/**
 *
 * @author PBFCIS-SRC-01
 */
@WebServlet(name = "ControlNuevoCliente", urlPatterns = {"/ControlNuevoCliente"})
public class ControlNuevoCliente extends HttpServlet {

    private DAO_NuevoCliente da;
    private Cliente cliente;
    private ArrayList<Cliente> clienteList;
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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            this.da = new DAO_NuevoCliente();
            this.clienteList = new ArrayList<>();
            this.clienteList = this.da.getListClientes();
            request.setAttribute("listaCliente", this.clienteList);
            request.getRequestDispatcher("NuevoCliente.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControlNuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControlCliente</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControlCliente at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }

        
        
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControlCliente</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControlCliente at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
        try {
            processRequest(request, response);            
        } catch (SQLException ex) {
            Logger.getLogger(ControlNuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
//        try {
//            processRequest(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(ControNuevolCliente.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        this.cliente = new Cliente();
        //REGISTRO DE CLIENTE
        if (request.getParameter("btn_agregar") != null 
                || (request.getParameter("btn_modificar") != null)) {
            try {
                this.cliente.setIdCliente(request.getParameter("dui"));
                this.cliente.setNombre(request.getParameter("nombre"));
                this.cliente.setApellido(request.getParameter("apellido"));
                this.cliente.setTelefono(request.getParameter("telefono"));
                this.cliente.setDireccion(request.getParameter("direccion"));
                if (this.cliente != null) {
                    this.da = new DAO_NuevoCliente(this.cliente);
                    if (request.getParameter("btn_agregar") != null) {
                        this.filasAfectadas = this.da.registrar();
                    }
                    else{
                        this.filasAfectadas = this.da.modificar();
                    }
                    ///OTRO
                    if (filasAfectadas == true) {
                        try {
                            this.da = new DAO_NuevoCliente();
                            this.clienteList = new ArrayList<>();
                            this.clienteList = da.getListClientes();
                            request.setAttribute("listaCliente", this.clienteList);
                            request.getRequestDispatcher("NuevoCliente.jsp").forward(request, response);
                        } catch (SQLException e) {
                            Logger.getLogger(ControlNuevoCliente.class.getName()).log(Level.SEVERE, null, e);
                        }
                    }
                    
                }  
//                insert = this.da.registrar();
                System.out.println("INSERTADO " + filasAfectadas);
                
            } catch (SQLException e) {
                Logger.getLogger(ControlNuevoCliente.class.getName()).log(Level.SEVERE, null, e);
            }
            request.getRequestDispatcher("NuevoCliente.jsp").forward(request, response);
        }
        
        //eliminar
        if (request.getParameter("botonBorrarCliente") != null) {
            String dui = request.getParameter("botonBorrarCliente");
            try {
                this.cliente.setIdCliente(request.getParameter("botonBorrarCliente"));
                this.da = new DAO_NuevoCliente(this.cliente);
                this.filasAfectadas = this.da.eliminar();
                if (filasAfectadas == true) {
                    try {
                        this.da = new DAO_NuevoCliente();
                        this.clienteList = new ArrayList<>();
                        this.clienteList = da.getListClientes();
                        request.setAttribute("listaCliente", this.clienteList); 
                        request.getRequestDispatcher("NuevoCliente.jsp").forward(request, response);
                    } catch (SQLException e) {
                        Logger.getLogger(ControlNuevoCliente.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
            } catch (SQLException e) {
                Logger.getLogger(ControlNuevoCliente.class.getName()).log(Level.SEVERE, null, e);
            }
            request.getRequestDispatcher("NuevoCliente.jsp").forward(request, response);
        }
        
        //boton cancelar
        if (request.getParameter("botonCancelar") != null) {
            request.getRequestDispatcher("NuevoCliente.jsp").forward(request, response);
        }
        
        //editar
        if (request.getParameter("botonEditarCliente") != null) {
            try {
                String dui = request.getParameter("botonEditarCliente");
                this.cliente.setIdCliente(request.getParameter("botonEditarCliente"));
                this.da = new DAO_NuevoCliente(this.cliente);
                this.cliente = this.da.getCliente(); //REGISTRO RECUPERADO
                request.setAttribute("clienteModificar", this.cliente);
                request.getRequestDispatcher("NuevoCliente.jsp").forward(request, response);
            } catch (SQLException e) {
                Logger.getLogger(ControlNuevoCliente.class.getName()).log(Level.SEVERE, null, e);
            }
            request.getRequestDispatcher("NuevoCliente.jsp").forward(request, response);
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


//             try (PrintWriter out = response.getWriter()) {
//                /* TODO output your page here. You may use following sample code. */
//                if (insert == true) {
//                    out.println("<h1><center>ERROR AL ALMACENAR REGISTRO</center></h1>"); 
//                }else{
//                    out.println("<html>");
//                    out.println("<body>");
//                    out.println("<h1><center>REGISTRO ALMACENADO</center></h1>"); 
//                    out.println("<form>");
//                    out.println("<style type = \"text/css\">");
//                    out.println("table,th, td{border: 1px solid black; border-collapse: collapse; }");
//                    out.println("</style>");
//                    out.println("<table style=\"margin: 0 auto;\">");
//                    out.println("<tr>");
//                    out.println("<th style=\"width: 150px;\">DUI</th>");
//                    out.println("<th style=\"width: 150px;\">Nombre</th>");
//                    out.println("<th style=\"width: 150px;\">Apellido</th>");
//                    out.println("<th style=\"width: 150px;\">Telefono</th>");
//                    out.println("<th style=\"width: 150px;\">Direccion</th>");
//                    out.println("</tr>");
//                    out.println("<tr>");
//                    out.println("<td>" + request.getParameter("dui").toString()+"</td>");
//                    out.println("<td>" + request.getParameter("nombre").toString()+"</td>");
//                    out.println("<td>" + request.getParameter("apellido").toString()+"</td>");
//                    out.println("<td>" + request.getParameter("telefono").toString()+"</td>");
//                    out.println("<td>" + request.getParameter("direccion").toString()+"</td>");
//                    out.println("</tr>");
//                    out.println("</table>");
//                    out.println("</form>");
//                    out.println("</body>");
//                    out.println("</html>");
//                }
//            }    
