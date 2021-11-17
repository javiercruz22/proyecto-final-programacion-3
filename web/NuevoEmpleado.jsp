<%-- 
    Document   : NuevoEmpleado
    Created on : 10-17-2021, 06:23:15 PM
    Author     : PBFCIS-SRC-01
--%>

<%@page import="modelo.entidades.Empresa"%>
<%@page import="modelo.dao.DAO_Empresa"%>
<%@page import="modelo.dao.DAO_NuevoPuesto"%>
<%@page import="modelo.entidades.Puesto"%>
<%@page import="modelo.dao.DAO_Puestos"%>
<%@page import="modelo.entidades.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.dao.DAO_NuevoEmpleado"%>
<%@page import="modelo.dao.DAO_NuevoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% 
        
        //modelo.dao.DAO_NuevoEmpleado empleado = new DAO_NuevoEmpleado();
        //ArrayList<Empleado> ListEm = empleado.getListEmpleados();
        
        modelo.dao.DAO_NuevoPuesto daoP = new DAO_NuevoPuesto();
        ArrayList<Puesto> ListPu = daoP.getListPuestos();
        
        modelo.dao.DAO_Empresa empresa = new DAO_Empresa();
        ArrayList<Empresa> listEmpresa = empresa.getListEmpresa();
        
        modelo.dao.DAO_NuevoEmpleado Lempleado = new DAO_NuevoEmpleado();
        Empleado empleadoModi = (Empleado)request.getAttribute("empleadoModificar");
        
        
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EMPLEADOS</title>
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
                <%=(empleadoModi == null) ? "Registro" : "Modificacion"%> de Empleado
            </span>
        </div>
        <div class="container">
            <div class="col-lg-12">
                <div align="center">
                    <h1><%=(empleadoModi == null) ? "Nuevo" : "Editar"%> Empleado </h1>
                </div>
                
                <form  action="ControlNuevoEmpleado" method="post" name="frmEmpleado">
                   <%-- <input type="text" name="idempleado"
                           value="<%=empleadoModi != null ? empleadoModi.getIdempleado() : ""%>"
                           style="display: none">
                    </br>
                    --%>
                    <div class="inputform"> 
                        <label>DUI</label>
                        <input type="text" class="input" name="dui" 
                               value="<%=(empleadoModi == null) ? "" : empleadoModi.getIdempleado()%>" 
                               placeholder="Ingrese DUI Empleado" required />
                        <span class="form_hint"></span>
                    </div>
                    <div class="inputform ">
                        <label>Nombre</label>
                        <input type="text" class="input"
                               value="<%=(empleadoModi == null) ? "" : empleadoModi.getNombre()%>"
                               name="nombre" placeholder="Ingrese Nombre Empleado" required />
                        <span class="form_hint"></span>
                    </div>
                    <div class="inputform">
                        <label>Apellido</label>
                        <input type="text" class="input"
                               value="<%=(empleadoModi == null) ? "" : empleadoModi.getApellido()%>"
                               name="apellido" placeholder="Ingrese Apellido Empleado" required />
                        <span class="form_hint"></span>
                    </div>
                    <div class="inputform">
                        <label>Teléfono</label>
                        <input type="text" class="input"                                                        
                               value="<%=(empleadoModi == null) ? "" : empleadoModi.getTelefono()%>"                               
                               name="telefono" placeholder="Ingrese Teléfono Empleado" required/>
                        <span class="form_hint"></span>
                    </div>
                    <div class="inputform">
                        <label>Dirección</label>
                        <input type="text" class="input"                                                        
                               value="<%=(empleadoModi == null) ? "" : empleadoModi.getDireccion()%>"                               
                               name="direccion" placeholder="Ingrese Dirección Empleado" required/>
                        <span class="form_hint"></span>
                    </div>
                    <div class="inputform">
                        <label>Puesto</label>
                        <select name="idpuesto">
                            <option <%=(empleadoModi != null) ? ((empleadoModi.getPuesto() != null) ? "Selected" : "") : ""%>
                                value="<%=(empleadoModi != null) ? empleadoModi.getPuesto().getIdpuesto() : ""%>">
                                <%=(empleadoModi != null) ? empleadoModi.getPuesto().getNombrePuesto() : ""%>
                            </option>
                            
                            <% for (int i = 0; i < ListPu.size(); i++) {%>
                            <%if (empleadoModi != null && !empleadoModi.getPuesto().getNombrePuesto().equals(ListPu.get(i).getNombrePuesto())) {%>
                            <option value="<%=ListPu.get(i).getIdpuesto()%>"><%=ListPu.get(i).getNombrePuesto()%></option>
                            <%} else if (empleadoModi == null) {%>
                            <option value="<%=ListPu.get(i).getIdpuesto()%>"><%=ListPu.get(i).getNombrePuesto()%></option>
                            <%}%>
                            <%}%>   

                        </select>
                          
                    </div>
                            
                    <div class="inputform">
                        <label>Empresa</label>
                        <select name="idempresa">
                            <option <%=(empleadoModi != null) ? ((empleadoModi.getPuesto() != null) ? "Selected" : "") : ""%>
                                value="<%=(empleadoModi != null) ? empleadoModi.getEmpresa().getNitEmpresa(): ""%>">
                                <%=(empleadoModi != null) ? empleadoModi.getEmpresa().getNombre(): ""%>
                            </option>
                            
                            <% for (int i = 0; i < listEmpresa.size(); i++) {%>
                            <%if (empleadoModi != null && !empleadoModi.getEmpresa().getNombre().equals(listEmpresa.get(i).getNombre())) {%>
                            <option value="<%=listEmpresa.get(i).getNitEmpresa()%>"><%=listEmpresa.get(i).getNombre()%></option>
                            <%} else if (empleadoModi == null) {%>
                            <option value="<%=listEmpresa.get(i).getNitEmpresa()%>"><%=listEmpresa.get(i).getNombre()%></option>
                            <%}%>
                            <%}%>   

                        </select>
                          
                    </div>
                            
                    <table>
                        <tr>
                            <td width="48%"></td>
                            <td><input type="submit" class="submit btn btn-primary readMore roundBtn" 
                                       value="<%=(empleadoModi == null) ? "Registrar" : "Modificar"%>"
                                       name="<%=(empleadoModi == null) ? "btn_agregar" : "btn_modificar"%>"
                                       onclick="validar()"></td>
                            <td><div><input type="submit" 
                                            class="submit btn btn-primary readMore roundBtn" 
                                            name="botonCancelar"  value="Cancelar"></div></td>
                            <td width="48%"></td>
                        </tr>
                    </table>
                </form>
                                       
                <h1><center>EMPLEADOS</center></h1>
                
                <form action="ControlNuevoEmpleado" method="post" name="frmEmpleado">
                    <div style="<%=(Lempleado.getListEmpleados().isEmpty()) 
                            ? "display:none" : "display:block"%>;
                         overflow: auto; max-height: 300px;">
                        <table class="table table-responsive table-bordered navbarResponsive" 
                               width="100%" id="dataTable" cellspacing="0" >
                            <thead class="align-content-center">
                                <tr>
                                    
                                    <th>Empresa</th>
                                    <th>DUI</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Teléfono</th>
                                    <th>Dirección</th>
                                    <th>Puesto</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <%for (Empleado registro : Lempleado.getListEmpleados()) {%>
                                <tr>
                                    <td><%= registro.getEmpresa().getNombre()%></td>
                                    <td><%= registro.getIdempleado()%></td>
                                    <td><%= registro.getNombre()%></td>
                                    <td><%= registro.getApellido()%></td>
                                    <td><%= registro.getTelefono()%></td>                             
                                    <td><%= registro.getDireccion()%></td>
                                    <td><%= registro.getPuesto().getNombrePuesto()%></td>
                                    
                                    <td>
                                        <div align="center">
                                            <button class="btn btn-primary readMore roundBtn"
                                                    name="botonEditarEmpleado" 
                                                    value="<%=registro.getIdempleado()%>">Editar
                                            </button>
                                            <button class="btn btn-primary readMore roundBtn" 
                                                    name="botonBorrarEmpleado" 
                                                    value="<%=registro.getIdempleado()%>">Eliminar
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