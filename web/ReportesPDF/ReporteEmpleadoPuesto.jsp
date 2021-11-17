<%-- 
    Document   : ReporteEmpleadoPuesto
    Created on : 11-16-2021, 02:18:59 PM
    Author     : PBFCIS-SRC-01
--%>

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
        <h1>Hello World!</h1>
    </body>
</html>
