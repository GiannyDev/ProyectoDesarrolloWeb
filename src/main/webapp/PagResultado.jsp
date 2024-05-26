<%-- 
    Document   : Resultado
    Created on : 26 may 2024, 15:34:53
    Author     : piero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <%
            boolean eliminado = (boolean) request.getAttribute("eliminado");
            String volver = (String) request.getAttribute("volver");
            if (eliminado) {
                out.print("<div class='direccion_titulo2'>Eliminado correctamente</div>");
            } else {
                out.print("<div class='direccion_titulo2 error'>Hubo un error al eliminar</div>");
            }
            out.print("<center><a href='" + volver + "' class='btn btn-success'>Volver</a></center>");
        %>
    </body>
</html>
