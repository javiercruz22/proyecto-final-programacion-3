<%-- 
    Document   : NuevoCliente
    Created on : 10-05-2021, 01:42:10 PM
    Author     : PBFCIS-SRC-01
--%>

<%@page import="modelo.dao.DAO_NuevoCliente"%>
<%-- Declaraciones --%>
<%@page import="java.util.List"%>
<%@page import="modelo.entidades.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
            
<html>
    <%
        modelo.dao.DAO_NuevoCliente cliente = new DAO_NuevoCliente();
        Cliente clienteModi = (Cliente) request.getAttribute("clienteModificar");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CLIENTES</title>
        <meta charset="utf-8">
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
                <%=(clienteModi == null) ? "Registro" : "Modificacion"%> de Cliente
            </span>
        </div>
        <div class="container">
            <div class="col-lg-12">
                <div align="center">
                    <h1><%=(clienteModi == null) ? "Nuevo" : "Editar"%> Cliente </h1>
                </div>
                
                <form  action="ControlNuevoCliente" method="post" name="frmCliente">
                    <%--
                    <input type="text" name="dui"
                           value="<%=clienteModi != null ? clienteModi.getIdCliente(): ""%>" 
                           style="display:none">                    
                    </br>
                    --%>
                    <div class="inputform"> 
                        <label>DUI</label>
                        <input type="text" class="input" name="dui" 
                               value="<%=(clienteModi == null) ? "" : clienteModi.getIdCliente()%>" 
                               placeholder="Ingrese DUI Cliente" required />
                        <span class="form_hint"></span>
                    </div>
                    <div class="inputform ">
                        <label>Nombre</label>
                        <input type="text" class="input"
                               value="<%=(clienteModi == null) ? "" : clienteModi.getNombre()%>"
                               name="nombre" placeholder="Ingrese Nombre Cliente" required />
                        <span class="form_hint"></span>
                    </div>
                    <div class="inputform">
                        <label>Apellido</label>
                        <input type="text" class="input"
                               value="<%=(clienteModi == null) ? "" : clienteModi.getApellido()%>"
                               name="apellido" placeholder="Ingrese Apellido Cliente" required />
                        <span class="form_hint"></span>
                    </div>
                    <div class="inputform">
                        <label>Telefono</label>
                        <input type="text" class="input"                                                        
                               value="<%=(clienteModi == null) ? "" : clienteModi.getTelefono()%>"                               
                               name="telefono" placeholder="Ingrese Telefono Cliente" required/>
                        <span class="form_hint"></span>
                    </div>
                    <div class="inputform">
                        <label>Direccion</label>
                        <input type="text" class="input"                                                        
                               value="<%=(clienteModi == null) ? "" : clienteModi.getDireccion()%>"                               
                               name="direccion" placeholder="Ingrese Dirección Cliente" required/>
                        <span class="form_hint"></span>
                    </div>
                    <table>
                        <tr>
                            <td width="48%"></td>
                            <td><input type="submit" class="submit btn btn-primary readMore roundBtn" 
                                       value="<%=(clienteModi == null) ? "Registrar" : "Modificar"%>"
                                       name="<%=(clienteModi == null) ? "btn_agregar" : "btn_modificar"%>"
                                       onclick="validar()"></td>
                            <td><div><input type="submit" 
                                            class="submit btn btn-primary readMore roundBtn" 
                                            name="botonCancelar"  value="Cancelar"></div></td>
                            <td width="48%"></td>
                        </tr>
                    </table>
                </form>
                                       
                <h1><center>CLIENTES</center></h1>
                
                <form action="ControlNuevoCliente" method="post" name="frmCliente">
                    <div style="<%=(cliente.getListClientes().isEmpty()) 
                            ? "display:none" : "display:block"%>;
                         overflow: auto; max-height: 300px;">
                        <table class="table table-responsive table-bordered navbarResponsive" 
                               width="100%" id="dataTable" cellspacing="0" >
                            <thead class="align-content-center">
                                <tr>
                                    
                                    <th>DUI</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Telefono</th>
                                    <th>Direccion</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <%for (Cliente registro : cliente.getListClientes()) {%>
                                <tr>
                                    <td><%= registro.getIdCliente()%></td>
                                    <td><%= registro.getNombre()%></td>
                                    <td><%= registro.getApellido()%></td>                             
                                    <td><%= registro.getTelefono()%></td>
                                    <td><%= registro.getDireccion()%></td>
                                    <td>
                                        <div align="center">
                                            <button class="btn btn-primary readMore roundBtn"
                                                    name="botonEditarCliente" 
                                                    value="<%=registro.getIdCliente()%>">Editar
                                            </button>
                                            <button class="btn btn-primary readMore roundBtn" 
                                                    name="botonBorrarCliente" 
                                                    value="<%=registro.getIdCliente()%>">Eliminar
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
