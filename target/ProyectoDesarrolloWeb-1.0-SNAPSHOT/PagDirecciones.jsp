<%@page import="Modelo.Direccion"%>
<%@page import="Dao.Negocio"%>
<%@page import="Modelo.Cliente"%>
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
        <%
            Negocio obj = new Negocio();
            String cli = "";
            String dire = "";
            if (request.getParameter("cli") != null) {
                cli = request.getParameter("cli");
            }
            if (request.getParameter("dire") != null) {
                dire = request.getParameter("dire");
            }
        %>
        <div class="direccion_titulo">
            <img src="Imagenes/direccion.png" alt="img_dirrecion" height="100px">
            Direcciones:
        </div>
        <form>
            <div class="form-group">
                <label class="direccion_subtitulo">Seleccionar cliente</label>
                <select name="cli" class="form-control" onchange="submit()">
                    <option>--Elegir--</option>
                    <%
                        for (Cliente x : obj.getClientes()) {
                            if (cli.equals(x.getDni_cliente())) {
                                out.print("<option value=" + x.getDni_cliente() + " selected>" + x.getNom_cliente() + " " + x.getApe_cliente());
                            } else {
                                out.print("<option value=" + x.getDni_cliente() + ">" + x.getNom_cliente() + " " + x.getApe_cliente());
                            }
                        }
                    %>
                </select>
            </div>
        </form>
        <form>
            <div class="form-group">
                <label class="direccion_subtitulo">Seleccionar dirección</label>
                <select name="dire" id="dire" class="form-control" onchange="updateDireccion()">
                    <option>--Elegir--</option>
                    <%
                        for (Direccion x : obj.getDirecciones(cli)) {
                            if (dire.equals(x.getId_direccion())) {
                                out.print("<option value=" + x.getId_direccion() + "' data-direccion='" + x.getDir_direccion()
                                        + "' data-nombre='" + x.getNom_com_direccion() + "' data-dni='" + x.getDni_direccion()
                                        + "' data-telefono='" + x.getTelf_direccion() + "' data-comentarios='" + x.getRef_direccion() + "'>" + x.getDir_direccion());
                            } else {
                                out.print("<option value=" + x.getId_direccion() + "' data-direccion='" + x.getDir_direccion()
                                        + "' data-nombre='" + x.getNom_com_direccion() + "' data-dni='" + x.getDni_direccion()
                                        + "' data-telefono='" + x.getTelf_direccion() + "' data-comentarios='" + x.getRef_direccion() + "'>" + x.getDir_direccion());
                            }
                        }
                    %>
                </select>
            </div>
        </form>

        <div class="direccion">
            <form name="direccion_form" class="direccion_form" method="POST" action="PagDirecciones.jsp">
                <div class=direccion_subtitulo>Información de encargado:</div>
                <div class="div_form_1">
                    <input type="text" id="nombre" name="nombre" placeholder="Nombre Completo" class="form_1">
                    <div id="nombreError" class="error"></div>
                </div>
                <div class="div_form_2">
                    <input type="text" id="dni" name="dni" placeholder="DNI" class="form_2">
                    <div id="dniError" class="error"></div>
                </div>
                <div class="div_form_2">
                    <input type="text" id="telefono" name="telefono" placeholder="Número de teléfono" class="form_2">
                    <div id="telefonoError" class="error"></div>
                </div>

                <div class=direccion_subtitulo>Dirección:</div>
                <div class="div_form_1">
                    <input type="text" id="direccion" name="direccion" placeholder="Direccion" class="form_1">
                    <div id="direccionError" class="error"></div>
                </div>			
                <div class=direccion_subtitulo style="color:#FB884A;">Información adicional:</div>
                <div class="div_form_1">
                    <textarea id="comentarios" name="comentarios" class="form_comentarios" rows="4" placeholder="Ingrese su comentario"></textarea>
                </div>
                <div class="direccion_enviar">
                    <input class="direccion_boton" name="btnEnviar" type="submit" value="Actualizar">
                </div>
            </form>
        </div>

        <%
            // Actualizar direccion
            if (request.getParameter("btnEnviar") != null) {
                // Obtener parametros del formulario
                String direId = request.getParameter("dire");
                String nombre = request.getParameter("nombre");
                String dni = request.getParameter("dni");
                String telefono = request.getParameter("telefono");
                String direccion = request.getParameter("direccion");
                String comentarios = request.getParameter("comentarios");

                // Crear el objeto de direccion con los nuevos valores
                Direccion direccionActualizada = new Direccion();
                direccionActualizada.setId_direccion(direId);
                direccionActualizada.setNom_com_direccion(nombre);
                direccionActualizada.setDni_direccion(dni);
                direccionActualizada.setTelf_direccion(telefono);
                direccionActualizada.setDir_direccion(direccion);
                direccionActualizada.setRef_direccion(comentarios);

                // Llamar al metodo para actualizar la dirección
                boolean resultado = obj.updateDireccion(direccionActualizada);

                // Mostrar mensaje
                if (resultado) {
                    out.println("La dirección ha sido actualizada exitosamente.");
                } else {
                    out.println(direId);
                    out.println("Ocurrió un error al actualizar la dirección.");
                }
            }
        %>

        <script>
            function updateDireccion() {

                var nombreInput = document.getElementById('nombre');
                var dniInput = document.getElementById('dni');
                var telefonoInput = document.getElementById('telefono');
                var direccionInput = document.getElementById('direccion');
                var informacionInput = document.getElementById('comentarios');

                var select = document.getElementById('dire');
                var selectedOption = select.options[select.selectedIndex];

                direccionInput.value = selectedOption.getAttribute('data-direccion') || '';
                informacionInput.value = selectedOption.getAttribute('data-comentarios') || '';
                nombreInput.value = selectedOption.getAttribute('data-nombre') || '';
                dniInput.value = selectedOption.getAttribute('data-dni') || '';
                telefonoInput.value = selectedOption.getAttribute('data-telefono') || '';
            }
        </script>
    </body>
</html>
