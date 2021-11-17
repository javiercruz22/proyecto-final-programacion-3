<%-- 
    Document   : NuevoCliente
    Created on : 10-05-2021, 01:42:10 PM
    Author     : PBFCIS-SRC-01
--%>

<%@page import="modelo.entidades.Puesto"%>
<%@page import="modelo.dao.DAO_NuevoPuesto"%>
<%-- Declaraciones --%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" %>
<%-- pageEncoding="UTF-8"--%>
<!DOCTYPE html>
            
<html>
    <%
        modelo.dao.DAO_NuevoPuesto puesto = new DAO_NuevoPuesto();
        Puesto puestoModi = (Puesto) request.getAttribute("puestoModificar");
    %>
    <head>
        <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
        <title>PUESTOS</title>
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
                <%=(puestoModi == null) ? "Registro" : "Modificacion"%> de Puesto
            </span>
        </div>
        <div class="container">
            <div class="col-lg-12">
                <div align="center">
                    <h1><%=(puestoModi == null) ? "Nuevo" : "Editar"%> Puesto </h1>
                </div>
                
                <form  action="ControlNuevoPuesto" method="post" name="frmPuesto">
                    
                    <div class="inputform"> 
                        <label>Número de Puesto</label>
                        <input type="text" class="input" name="id" 
                               value="<%=(puestoModi == null) ? puesto.id() : puestoModi.getIdpuesto()%>" 
                               placeholder="" required  disabled/>
                        <span class="form_hint"></span>
                    </div>
                    
                    <div class="inputform"> 
                        <label>Nombre</label>
                        <input type="text" class="input" name="nombre" 
                               value="<%=(puestoModi == null) ? "" : puestoModi.getNombrePuesto()%>" 
                               placeholder="Ingrese Nombre Puesto" required />
                        <span class="form_hint"></span>
                    </div>
                    <div class="inputform ">
                        <label>Sueldo</label>
                        <input type="text" class="input"
                               value="<%=(puestoModi == null) ? "" : puestoModi.getSueldo()%>"
                               name="sueldo" placeholder="Ingrese Sueldo Puesto" required />
                        <span class="form_hint"></span>
                    </div>
                    <table>
                        <tr>
                            <td width="48%"></td>
                            <td><input type="submit" class="submit btn btn-primary readMore roundBtn" 
                                       value="<%=(puestoModi == null) ? "Registrar" : "Modificar"%>"
                                       name="<%=(puestoModi == null) ? "btn_agregar" : "btn_modificar"%>"
                                       onclick="validar()"></td>
                            <td><div><input type="submit" 
                                            class="submit btn btn-primary readMore roundBtn" 
                                            name="botonCancelar"  value="Cancelar"></div></td>
                            <td width="48%"></td>
                        </tr>
                    </table>
                </form>
                                       
                <h1><center>PUESTOS</center></h1>
                
                <form action="ControlNuevoPuesto" method="post" name="frmPuesto">
                    <div style="<%=(puesto.getListPuestos().isEmpty()) 
                            ? "display:none" : "display:block"%>;
                         overflow: auto; max-height: 300px;">
                        <table class="table table-responsive table-bordered navbarResponsive" 
                               width="100%" id="dataTable" cellspacing="0" >
                            <thead>
                                <tr>
                                    <th>Número de Puesto</th>
                                    <th>Nombre</th>
                                    <th>Sueldo</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <%for (Puesto registro : puesto.getListPuestos()) {%>
                                <tr>
                                    <td><%= registro.getIdpuesto()%></td>
                                    <td><%= registro.getNombrePuesto()%></td>
                                    <td><%= "$  " + registro.getSueldo()%></td>
                                    <td>
                                        <div align="center">
                                            <button class="btn btn-primary readMore roundBtn"
                                                    name="botonEditarPuesto" 
                                                    value="<%=registro.getIdpuesto()%>">Editar
                                            </button>
                                            <button class="btn btn-primary readMore roundBtn" 
                                                    name="botonBorrarPuesto" 
                                                    value="<%=registro.getIdpuesto()%>">Eliminar
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
