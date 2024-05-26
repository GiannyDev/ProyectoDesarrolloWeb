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
        <%@include file="header.jsp"%>
        <%
            Negocio obj = new Negocio();
            String tipo_produ = "", id_produ = "";
            if (request.getParameter("tipo_produ") != null) {
                tipo_produ = request.getParameter("tipo_produ");
            }
            if (request.getParameter("id_produ") != null) {
                id_produ = request.getParameter("id_produ");
            }
        %>
        <form>
            <div class="form-group">
                <label>Seleccione la categoria del producto</label>
                <select name="tipo_produ" class="form-control" onchange="submit()">
                    <option>--Elegir--</option>
                    <%
                        for (CategoriaProdu x : obj.listCategoria()) {
                            if (tipo_produ.equals(x.getId_cate())) {
                                out.print("<option value=" + x.getId_cate() + " selected>" + x.getNom_cate());
                            } else {
                                out.print("<option value=" + x.getId_cate() + ">" + x.getNom_cate());
                            }
                        }
                    %>
                </select>
            </div>
        </form>
        <form action="ProductoVP.jsp" target="zona">
            <div class="form-group">    
                <label>Seleccione el producto</label>
                <select name="id_produ" class="form-control" onchange="submit()">
                    <option>--Elegir--</option>
                    <%
                        for (Producto x : obj.listProducto(tipo_produ)) {
                            if (id_produ.equals(x.getId_producto())) {
                                out.print("<option value=" + x.getId_producto() + " selected>" + x.getNom_producto());
                            } else {
                                out.print("<option value=" + x.getId_producto() + ">" + x.getNom_producto());
                            }
                        }
                    %>
                </select>
            </div>
        </form>
        <iframe name="zona" width="100%" height="500"></iframe>
    </body>
</html>