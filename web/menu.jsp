<%-- 
    Document   : menu
    Created on : 09-28-2021, 01:10:10 PM
    Author     : PBFCIS-SRC-01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MENU DE SERVICIO DE INTERNET</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="recursos/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="recursos/css/core.css">
        <link href="recursos/css/font-awesome.css" rel="stylesheet">
        <link href="recursos/css/table.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="recursos/css/responsive.css">
        <link href="recursos/css/menuavanzado.css" rel="stylesheet">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
    </head>
    <body>
        <section class="wrapper">
            <nav>
                <div id="nav">
                    <ul id="menuHorizontal">
                        <li>Inicio</li>
                        <li>Registros 
                            <ul class="submenu">
                                <li><a href="NuevoEmpleado.jsp">Empleado</a></li>
                                <li><a href="NuevoCliente.jsp">Cliente</a></li>
                                <li><a href="NuevoServicio.jsp">Servicio</a></li>
                                <li><a href="NuevoPuesto.jsp">Puestos</a></li> 
                            </ul>
                        </li>
                        <li>Procesos
                            <ul class="submenu">
                                <li><a href="">Facturación</a></li>                         
                            </ul>
                        </li>
                        <li>Consultas
                            <ul class="submenu">
                                <li><a href="ControlClienteServicio">Lista de Clientes y Servicios</a></li> 
                                <li><a href="ControlServicio">Lista de Servicios</a></li>
                                <li><a href="ControlPuesto">Lista de Puestos de Trabajo</a></li>
                                <li><a href="ControlEmpleadoPuesto">Lista de Empleados</a></li>
                                <li><a href="ControlEmpleadoCeroContrato">Lista de Empleados sin Contratos Realizados</a></li>
                                <li><a href="ControlContrato">Contratos más Demandados</a></li>
                            </ul>
                        </li>
                        <li>Informes
                            <ul class="submenu">    
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </section>
        <section class="contenido wrapper">
            <h1 align="center" style="color: #020f2e" >
                SISTEMA SERVICIO DE INTERNET
                <img align="middle" src="https://i.pinimg.com/originals/a0/db/c4/a0dbc489d00b38dced9bb3f8d8c7052f.jpg" width="100" />
            </h1>
            <center>
              
                <img src="https://ichef.bbci.co.uk/news/640/cpsprodpb/16280/production/_118125709_gettyimages-1186955933.jpg" width="450" />
                
            </center>
            <br></br>
            
           <%-- <footer class="main-footer"> --%>
                <div class="float-right d-none d-sm-inline">
                   <%-- UES --%>
                </div>
                
               <div align="center"> 
                    <strong>Copyright &copy; Universidad de El Salvador 2021 - Sistema Servicio de Internet - UES</strong> 
               </div> 
                
            <%--</footer> --%>
            
        </section>
    </body>
</html>
