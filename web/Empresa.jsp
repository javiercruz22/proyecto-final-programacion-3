<%-- 
    Document   : Empresa
    Created on : 10-19-2021, 02:24:20 PM
    Author     : PBFCIS-SRC-01
--%>

<%@page import="modelo.entidades.Empresa"%>
<%@page import="modelo.dao.DAO_Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        modelo.dao.DAO_Empresa empresa = new DAO_Empresa();
        Empresa empresaModi = (Empresa)request.getAttribute("empresaModi");
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
                <%=(empresaModi == null) ? "Registro" : "Modificacion"%> de Empresa
            </span>
        </div>
        <div class="container">
            <div class="col-lg-12">
                <div align="center">
                    <h1><%=(empresaModi == null) ? "Nueva" : "Editar"%> Empresa </h1>
                </div>
                
                <form  action="ControlEmpresa" method="post" name="frmEmpresa">
                   
                    <div class="inputform"> 
                        <label>NIT</label>
                        <input type="text" class="input" name="nit" 
                               value="<%=(empresaModi == null) ? "" : empresaModi.getNitEmpresa()%>" 
                               placeholder="Ingrese NIT de la Empresa" required />
                        <span class="form_hint"></span>
                    </div>
                    <div class="inputform ">
                        <label>Nombre</label>
                        <input type="text" class="input"
                               value="<%=(empresaModi == null) ? "" : empresaModi.getNombre()%>"
                               name="nombre" placeholder="Ingrese Nombre Empresa" required />
                        <span class="form_hint"></span>
                    </div>
                    <div class="inputform">
                        <label>Telefono</label>
                        <input type="text" class="input"
                               value="<%=(empresaModi == null) ? "" : empresaModi.getTelefono()%>"
                               name="telefono" placeholder="Ingrese Telefono Empresa" required />
                        <span class="form_hint"></span>
                    </div>
                    <div class="inputform">
                        <label>Dirección</label>
                        <input type="text" class="input"                                                        
                               value="<%=(empresaModi == null) ? "" : empresaModi.getDireccion()%>"                               
                               name="direccion" placeholder="Ingrese Dirección Empresa" required/>
                        <span class="form_hint"></span>
                    </div>

                    <table>
                        <tr>
                            <td width="48%"></td>
                            <td><input type="submit" class="submit btn btn-primary readMore roundBtn" 
                                       value="<%=(empresaModi == null) ? "Registrar" : "Modificar"%>"
                                       name="<%=(empresaModi == null) ? "btn_agregar" : "btn_modificar"%>"
                                       onclick="validar()"></td>
                            <td><div><input type="submit" 
                                            class="submit btn btn-primary readMore roundBtn" 
                                            name="botonCancelar"  value="Cancelar"></div></td>
                            <td width="48%"></td>
                        </tr>
                    </table>
                </form>
                                       
                <h1><center>CLIENTES</center></h1>
                
                <form action="ControlEmpresa" method="post" name="frmEmpresa">
                    <div style="<%=(empresa.getListEmpresa().isEmpty()) 
                            ? "display:none" : "display:block"%>;
                         overflow: auto; max-height: 300px;">
                        <table class="table table-responsive table-bordered navbarResponsive" 
                               width="100%" id="dataTable" cellspacing="0" >
                            <thead class="align-content-center">
                                <tr>
                                    
                                    <th>NIT</th>
                                    <th>Nombre</th>
                                    <th>Telefono</th>
                                    <th>Direccion</th>
                                    <th></th>

                                </tr>
                            </thead>
                            <tbody>
                                
                                <%for (Empresa registro : empresa.getListEmpresa()) {%>
                                <tr>
                                    <td><%= registro.getNitEmpresa()%></td>
                                    <td><%= registro.getNombre()%></td>
                                    <td><%= registro.getTelefono()%></td>                             
                                    <td><%= registro.getDireccion()%></td>
                                    <td>
                                        <div align="center">
                                            <button class="btn btn-primary readMore roundBtn"
                                                    name="botonEditarCliente" 
                                                    value="<%=registro.getNitEmpresa()%>">Editar
                                            </button>
                                            <button class="btn btn-primary readMore roundBtn" 
                                                    name="botonBorrarCliente" 
                                                    value="<%=registro.getNitEmpresa()%>">Eliminar
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

