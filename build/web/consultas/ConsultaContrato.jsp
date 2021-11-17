<%-- 
    Document   : ConsultaContrato
    Created on : 10-22-2021, 01:53:34 PM
    Author     : PBFCIS-SRC-01
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.entidades.Contrato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicios más Demandados</title>
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
                <center><h2>Servicios con más Contratos</h2></center>
                <table class="table table-responsive table-bordered navbarResponsive" 
                       width="100%" id="dataTable" cellspacing="0" >
                    <thead>
                        <tr class="table table-bordered table-responsive">
                           
                            <th>Servicio</th>
                            <th>Precio</th>
                            <th>Cantidad de Contratos</th>

                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Contrato> lsContrato = (List<Contrato>) request.getAttribute("listitaContratos");
                            for (Contrato registro : lsContrato) {
                        %>
                        <tr class="table table-bordered table-responsive">
                            <td><%= registro.getServicio().getServicio()%></td>
                            <td><%= "$   " + registro.getServicio().getPrecio()%></td>
                            <td><%="" + registro.getnContrato()%></td>
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
