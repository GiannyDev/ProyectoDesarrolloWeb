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
            double t1 = 0, t2 = 0, t3 = 0, t4 = 0, t5 = 0, t6 = 0;

            for (Boleta_Cliente x : obj.listVentaEdad()) {
                if (x.getEdad_cliente() <= 25) {
                    t1 += x.getMonto_tot();
                }
                if (x.getEdad_cliente() > 25 && x.getEdad_cliente() <= 35) {
                    t2 += x.getMonto_tot();
                }
                if (x.getEdad_cliente() > 35 && x.getEdad_cliente() <= 45) {
                    t3 += x.getMonto_tot();
                }
                if (x.getEdad_cliente() > 45 && x.getEdad_cliente() <= 55) {
                    t4 += x.getMonto_tot();
                }
                if (x.getEdad_cliente() > 55 && x.getEdad_cliente() <= 65) {
                    t5 += x.getMonto_tot();
                }
                if (x.getEdad_cliente() > 65) {
                    t6 += x.getMonto_tot();
                }
                data = t1 + "," + t2 + "," + t3 + "," + t4 + "," + t5 + "," + t6;

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
                                    <h2><b>Gráfico de los ventas por edades</b></h2>
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
                                    labels: ["18-25", "26-35", "36-45", "46-55", "56-65", "66+"],
                                            datasets: [
                                            {
                                            label: "Monto",
                                                    data: [<%=data%>, 0],
                                                   
                                            backgroundColor: fondo,
                                            },
                                            ],
                                    },
                            });
                        </script>
                        </html>