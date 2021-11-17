<%-- 
    Document   : NuevoServicio
    Created on : 10-15-2021, 10:13:23 PM
    Author     : PBFCIS-SRC-01
--%>

<%@page import="modelo.entidades.Servicio"%>
<%@page import="modelo.dao.DAO_NuevoServicio"%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<html>
    <%
        modelo.dao.DAO_NuevoServicio servicio = new DAO_NuevoServicio();
        Servicio servicioModi = (Servicio) request.getAttribute("servicioModificar");
    %>
    <head>
        <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
        <title>SERVICIO</title>
        <%--<meta charset="utf-8">--%>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="recursos/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="recursos/css/core.css">
        <link href="recursos/css/font-awesome.css" rel="stylesheet">
        <link href="recursos/css/table.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="recursos/css/responsive.css">
        <script type="text/javascript" src="recursos/js/jquery.js"></script>
        <script type="text/javascript" src="recursos/js/bootstrap.js"></script>
    </head>
    <body>       
        <div class="message-bar">
            <span class="pos">
                <%=(servicioModi == null) ? "Registro" : "Modificacion"%> de Servicio
            </span>
        </div>
        <div class="container">
            <div class="col-lg-12">
                <div align="center">
                    <h1><%=(servicioModi == null) ? "Nuevo" : "Editar"%> Servicio </h1>
                </div>
                
                <form  action="ControlNuevoServicio" method="post" name="frmServicio">
                    <%--
                    <input type="text" name="dui"
                           value="<%=clienteModi != null ? clienteModi.getIdCliente(): ""%>" 
                           style="display:none">                    
                    </br>
                    --%>
                    <div class="inputform"> 
                        <label>Número de Contrato</label>
                        <input type="text" class="input" name="id" 
                               value="<%=(servicioModi == null) ? servicio.id() : servicioModi.getIdServicio()%>" 
                               placeholder="Ingrese ID" required  disabled/>
                        <span class="form_hint"></span>
                    </div>
                    <div class="inputform ">
                        <label>Servicio</label>
                        <input type="text" class="input"
                               value="<%=(servicioModi == null) ? "" : servicioModi.getServicio()%>"
                               name="servicio" placeholder="Ingrese Servicio" required />
                        <span class="form_hint"></span>
                    </div>
                    <div class="inputform">
                        <label>Precio</label>
                        <input type="text" class="input"
                               value="<%=(servicioModi == null) ? "" : servicioModi.getPrecio()%>"
                               name="precio" placeholder="Ingrese Precio" required />
                        <span class="form_hint"></span>
                    </div>
                    <div class="inputform">
                        <label>Período</label>
                        <input type="text" class="input"                                                        
                               value="<%=(servicioModi == null) ? "" : servicioModi.getPeriodo()%>"                               
                               name="periodo" placeholder="Ingrese Periodo" required/>
                        <span class="form_hint"></span>
                    </div>
                    <table>
                        <tr>
                            <td width="48%"></td>
                            <td><input type="submit" class="submit btn btn-primary readMore roundBtn" 
                                       value="<%=(servicioModi == null) ? "Registrar" : "Modificar"%>"
                                       name="<%=(servicioModi == null) ? "btn_agregar" : "btn_modificar"%>"
                                       onclick="validar()"></td>
                            <td><div><input type="submit" 
                                            class="submit btn btn-primary readMore roundBtn" 
                                            name="botonCancelar"  value="Cancelar"></div></td>
                            <td width="48%"></td>
                        </tr>
                    </table>
                </form>
                                       
                <h1><center>SERVICIOS</center></h1>
                
                <form action="ControlNuevoServicio" method="post" name="frmServicio">
                    <div style="<%=(servicio.getListServicios().isEmpty()) 
                            ? "display:none" : "display:block"%>;
                         overflow: auto; max-height: 700px;">
                        <table class="table table-responsive table-bordered navbarResponsive" 
                               width="100%" id="dataTable" cellspacing="0" >
                            <thead class="align-content-center">
                                <tr>
                                    
                                    <th>Número de Servicio</th>
                                    <th>Detalle</th>
                                    <th>Precio</th>
                                    <th>Período</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <%for (Servicio registro : servicio.getListServicios()) {%>
                                <tr>
                                    <td><%= registro.getIdServicio()%></td>
                                    <td><%= registro.getServicio()%></td>
                                    <td><%= "$  " + registro.getPrecio()%></td>                             
                                    <td><%= registro.getPeriodo()%></td>
                                    <td>
                                        <div align="center">
                                            <button class="btn btn-primary readMore roundBtn"
                                                    name="botonEditarServicio" 
                                                    value="<%=registro.getIdServicio()%>">Editar
                                            </button>
                                            <button class="btn btn-primary readMore roundBtn" 
                                                    name="botonBorrarServicio" 
                                                    value="<%=registro.getIdServicio()%>">Eliminar
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div> 
                    <script src="js/bootstrap.min.js" type="text/javascript"></script>
                    <script src="vendor/datatables/jquery.dataTables.js"></script>
                    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
                    <script src="recursos/js/sb-admin-datatables.min.js"></script>
                    </form> 
            </div>
    </body>
</html>

