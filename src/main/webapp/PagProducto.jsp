<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dao.Negocio, Modelo.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <%
            Negocio obj = new Negocio();
            String tipo_produ = "";
            if (request.getParameter("tipo_produ") != null) {
                tipo_produ = request.getParameter("tipo_produ");
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
                                out.print("<option value=" + x.getId_cate()+ " selected>" + x.getNom_cate());
                            } else {
                                out.print("<option value=" + x.getId_cate()+ ">" + x.getNom_cate());
                            }
                        }
                    %>
                </select>

            </div>
        </form>
        
    </body>
</html>
