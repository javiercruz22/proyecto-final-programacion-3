<%-- 
    Document   : consultaCliente_Servicio
    Created on : 09-28-2021, 01:17:17 PM
    Author     : PBFCIS-SRC-01
--%>

<%@page import="modelo.entidades.Servicio"%>
<%@page import="java.util.List"%>
<%@page import="modelo.entidades.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente y Servicio</title>
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
        <form>
            
            <div class="container-fluid">
                <center><h2>Clientes y Servicio</h2></center>
                <table class="table table-responsive table-bordered navbarResponsive" 
                       width="100%" id="dataTable" cellspacing="0" >
                    <thead>
                        <tr class="table table-bordered table-responsive">
                           
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Servicio</th>
                            <th>Precio</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Servicio> lsClienteServicio = (List<Servicio>) request.getAttribute("listitaClientes");
                            for (Servicio registro : lsClienteServicio) {
                        %>
                        <tr class="table table-bordered table-responsive">
                            <td><%= registro.getCliente().getNombre()%></td>
                            <td><%= registro.getCliente().getApellido()%></td>
                            <td><%= registro.getServicio()%></td>  
                            <td><%= "$   " + registro.getPrecio()%></td> 
                            
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
    </body>
</html>
