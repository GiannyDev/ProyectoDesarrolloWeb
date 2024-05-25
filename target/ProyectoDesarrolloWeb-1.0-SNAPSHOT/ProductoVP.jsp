<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dao.Negocio, Modelo.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            Negocio obj = new Negocio();
            String id_produ = "";
            if (request.getParameter("id_produ") != null && !request.getParameter("id_produ").equals("--Elegir--") && !request.getParameter("id_produ").equals("")) {
                id_produ = request.getParameter("id_produ");
                Producto p = obj.getProducto(id_produ);
                out.print(p.mostrarPagina());
            }
            
        %>
    </body>
</html>
