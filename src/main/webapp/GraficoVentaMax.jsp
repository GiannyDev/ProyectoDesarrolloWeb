<%-- 
    Document   : Grafico
    Created on : 13 may. 2024, 13:53:34
    Author     : LAB-USR-LCENTRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.*,Dao.Negocio" %>
 
<!DOCTYPE html>
<html>
    <head>
        <script src="Chart.min.js" type="text/javascript"></script>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <style>
            .container {
                width: 70%;
            }
            body {
                text-align: center;
                color: #608FC4;
            }
            h2 {
                text-align: center;
                font-family: "Verdana", sans-serif;
                font-size: 30px;
            }
        </style>
    </head>
    <body>
        <%
            String opc = "", a = "", b = "", c = "";

            if (request.getParameter("opc") != null) {
                opc = request.getParameter("opc");
                if (opc.equals("bar")) {
                    a = "checked";
                }
                if (opc.equals("pie")) {
                    b = "checked";
                }
                if (opc.equals("line")) {
                    c = "checked";
                }
            }
            String tipo = request.getParameter("opc");
            String label = "", data = "";
            Negocio obj = new Negocio();

            for (Producto x : obj.listMasVendidos()) {
                label = label + "'" + x.getNom_producto() + "',";
                data = data + x.getCant_producto() + ",";
            }
            if (data.length() > 0) {
                data = data.substring(0, data.length() - 1);
            }
            if (request.getParameter("opc") != null)
                tipo = request.getParameter("opc");
        %>

        <div class="container">
            <div class="container-fluid">
                <div class="col">
                    <div class="row-sm-4">
                        <div class="card">
                            <div class="card-header">
                                <h3>Elija el tipo de grafico</h3>
                                <div class="card-body">
                                    <form name="fr">
                                        <div class="form-group">
                                            <input type="radio" name="opc" value="bar" <%=a%>> Barras
                                            <input type="radio" name="opc" value="pie" <%=b%>> Circular
                                            <input type="radio" name="opc" value="line" <%=c%>> Lineal
                                        </div>
                                        <button class="btn btn-info" >Enviar</button>
                                    </form>
                                </div>
                                <br>
                                <div class="row-sm-8">
                                    <h2><b>Gráfico de los productos más vendidos</b></h2>
                                    <canvas id="myChart"></canvas>
                                </div>
                            </div>          
                        </div>
                        </body>
                        <script>
                            var ctx = document.getElementById("myChart").getContext("2d");
                            var fondo =ctx.createLinearGradient(750, 0, 100, 0);
                            fondo.addColorStop(0, '#608FC4');
                            fondo.addColorStop(1, '#5CB5C3');   
                            var myChart = new Chart(ctx, {
                                type: "<%=tipo%>",
                                data: {
                                    labels: [<%=label%>],
                                    datasets: [
                                        {
                                            label: "Monto",
                                            data: [<%=data%>,0],
                                            backgroundColor: fondo,
                                        },
                                    ],
                                },
                            });
                        </script>
                        </html>