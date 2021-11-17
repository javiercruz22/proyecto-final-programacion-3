package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>MENU DE SERVICIO DE INTERNET</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"recursos/css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"recursos/css/core.css\">\n");
      out.write("        <link href=\"recursos/css/font-awesome.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"recursos/css/table.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"recursos/css/responsive.css\">\n");
      out.write("        <link href=\"recursos/css/menuavanzado.css\" rel=\"stylesheet\">\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <section class=\"wrapper\">\n");
      out.write("            <nav>\n");
      out.write("                <div id=\"nav\">\n");
      out.write("                    <ul id=\"menuHorizontal\">\n");
      out.write("                        <li>Inicio</li>\n");
      out.write("                        <li>Registros \n");
      out.write("                            <ul class=\"submenu\">\n");
      out.write("                                <li><a href=\"NuevoEmpleado.jsp\">Empleado</a></li>\n");
      out.write("                                <li><a href=\"NuevoCliente.jsp\">Cliente</a></li>\n");
      out.write("                                <li><a href=\"NuevoServicio.jsp\">Servicio</a></li>\n");
      out.write("                                <li><a href=\"NuevoPuesto.jsp\">Puestos</a></li> \n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li>Procesos\n");
      out.write("                            <ul class=\"submenu\">\n");
      out.write("                                <li><a href=\"\">Facturación</a></li>                         \n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li>Consultas\n");
      out.write("                            <ul class=\"submenu\">\n");
      out.write("                                <li><a href=\"ControlClienteServicio\">Lista de Clientes y Servicios</a></li> \n");
      out.write("                                <li><a href=\"ControlServicio\">Lista de Servicios</a></li>\n");
      out.write("                                <li><a href=\"ControlPuesto\">Lista de Puestos de Trabajo</a></li>\n");
      out.write("                                <li><a href=\"ControlEmpleadoPuesto\">Lista de Empleados</a></li>\n");
      out.write("                                <li><a href=\"ControlEmpleadoCeroContrato\">Lista de Empleados sin Contratos Realizados</a></li>\n");
      out.write("                                <li><a href=\"ControlContrato\">Contratos más Demandados</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li>Informes\n");
      out.write("                            <ul class=\"submenu\">    \n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </section>\n");
      out.write("        <section class=\"contenido wrapper\">\n");
      out.write("            <h1 align=\"center\" style=\"color: #020f2e\" >\n");
      out.write("                SISTEMA SERVICIO DE INTERNET\n");
      out.write("                <img align=\"middle\" src=\"https://i.pinimg.com/originals/a0/db/c4/a0dbc489d00b38dced9bb3f8d8c7052f.jpg\" width=\"100\" />\n");
      out.write("            </h1>\n");
      out.write("            <center>\n");
      out.write("              \n");
      out.write("                <img src=\"https://ichef.bbci.co.uk/news/640/cpsprodpb/16280/production/_118125709_gettyimages-1186955933.jpg\" width=\"450\" />\n");
      out.write("                \n");
      out.write("            </center>\n");
      out.write("            <br></br>\n");
      out.write("            \n");
      out.write("           ");
      out.write("\n");
      out.write("                <div class=\"float-right d-none d-sm-inline\">\n");
      out.write("                   ");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("               <div align=\"center\"> \n");
      out.write("                    <strong>Copyright &copy; Universidad de El Salvador 2021 - Sistema Servicio de Internet - UES</strong> \n");
      out.write("               </div> \n");
      out.write("                \n");
      out.write("            ");
      out.write("\n");
      out.write("            \n");
      out.write("        </section>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
