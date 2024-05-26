<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dao.Negocio, Modelo.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <style>
            .par-botones{
                display: flex;
                flex-wrap: wrap;
                flex-direction: row;
                align-items: center;
                justify-content: center;
                align-content: space-around;
            }
        </style>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <%
            Negocio obj = new Negocio();
            String tipo_produ = "", id_produ = "";
            boolean se_selecciono = false;
            if (request.getParameter("tipo_produ") != null) {
                tipo_produ = request.getParameter("tipo_produ");
            }
            if (request.getParameter("id_produ") != null) {
                id_produ = request.getParameter("id_produ");
            }
        %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-4">
                    <form>
                        <div class="form-group">
                            <label class="direccion_subtitulo">Seleccione la categoria</label>
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
                        <div class="form-group">
                            <label class="direccion_subtitulo">Seleccione el producto</label>
                            <select name="id_produ" class="form-control" onchange="submit()">
                                <option>--Elegir--</option>
                                <%
                                    for (Producto x : obj.listProducto(tipo_produ)) {
                                        if (id_produ.equals(x.getId_producto())) {
                                            out.print("<option value=" + x.getId_producto() + " selected>" + x.getNom_producto());
                                            se_selecciono = true;
                                        } else {
                                            out.print("<option value=" + x.getId_producto() + ">" + x.getNom_producto());
                                        }
                                    }
                                %>
                            </select>
                        </div>
                    </form>
                </div>
                <div class="col-sm-2 par-botones">
                    <%
                        if (se_selecciono) {
                            out.print("<a href='PagProducto.jsp' class='btn btn-success'>Ingresar Producto</a>");
                            out.print("<a href='#' class='btn btn-success'>Ver Descuentos</a>");
                        }
                    %>
                </div>
                <div class="col-sm-2 par-botones">
                    <%
                        if (se_selecciono) {
                            out.print("<a href='PagProducto.jsp?id_produ=" + id_produ + "' class='btn btn-success'>Editar Producto</a>");
                            out.print("<a href='Control?opc=1&id_produ=" + id_produ + "' class='btn btn-success'>Borrar Producto</a>");
                        }
                    %>
                </div>
            </div>
        </div>
        <iframe src="ProductoVP.jsp?id_produ=<%if(se_selecciono)out.print(id_produ);%>" width="100%" frameborder="0" scrolling="no" height="600px"></iframe>
    </body>
</html>