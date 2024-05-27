<%@page import="Modelo.*"%>
<%@page import="Dao.Negocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Direcciones</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <%
            Negocio obj = new Negocio();
            String id_produ = "";
            String opc = request.getParameter("opc");
            Producto p = new Producto();
            p.setId_tipo_producto("");
            if (request.getParameter("id_produ") != null) {
                id_produ = request.getParameter("id_produ");
                p = obj.getProducto(id_produ);
            }
        %>
        <div class="direccion_titulo">
            <!--<img src="Imagenes/direccion.png" alt="img_dirrecion" height="100px">-->
            Formulario de producto:
        </div>
        <form name="direccion_form" method="POST" action="Control">
            <div class="direccion">
                <div class="direccion_form">
                    <input type="hidden" name="opc" value="<%=opc%>">
                    <input type="hidden" name="id_produ" value="<%=id_produ%>">
                    <div class=direccion_subtitulo>Información del producto:</div>
                    <div class="div_form_1">
                        <input type="text" name="nom_produ" placeholder="Nombre del producto" class="form_1" value="<%if (p.getNom_producto() != null)out.print(p.getNom_producto());%>">
                    </div>
                    <div class="div_form_2">
                        <input type="text" name="monto_produ" placeholder="Precio del producto" class="form_2" value="<%if (p.getNom_producto() != null)out.print(p.getMonto_producto());%>">
                    </div>
                    <div class="div_form_2">
                        <input type="text" name="ruta_imagen"" placeholder="Nombre de la imagen" class="form_2" value="<%if (p.getNom_producto() != null)out.print(p.getRuta_imagen());%>">
                    </div>
                    <div class="div_form_1">
                        <select name="id_tipo_produ" class="lista_desplegable">
                            <option>--Elegir--</option>
                            <%
                                for (CategoriaProdu x : obj.listCategoria()) {
                                    if (p.getId_tipo_producto().equals(x.getId_cate())) {
                                        out.print("<option value=" + x.getId_cate() + " selected>" + x.getNom_cate());
                                    } else {
                                        out.print("<option value=" + x.getId_cate() + ">" + x.getNom_cate());
                                    }
                                }
                            %>
                        </select>
                    </div>
                    <div class=direccion_subtitulo>Descripción del producto:</div>
                    <div class="div_form_1">
                        <textarea name="desc_produ" class="form_comentarios" rows="4" placeholder="Ingrese la descripcion del producto"><%if (p.getNom_producto() != null)out.print(p.getDesc_producto());%></textarea>
                    </div>
                    <div class="direccion_enviar">
                        <input class="direccion_boton" name="btnEnviar" type="submit" value="<%if (opc.equals("2"))out.print("Agregar");if (opc.equals("3"))out.print("Editar");%>">
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
