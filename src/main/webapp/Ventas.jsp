<%-- 
    Document   : Ventas
    Created on : 25 may. 2024, 16:45:28
    Author     : Christina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <iframe src="GraficoVentaMax.jsp" frameborder="0" scrolling="no" width="100%" height="500"></iframe>
        <iframe src="GraficoProduCaro.jsp" frameborder="0" scrolling="no" width="100%"  height="500"></iframe>
        <iframe src="GraficoVentaEdad.jsp" frameborder="0" scrolling="no" width="100%" height="500"></iframe>
    </body>
</html>
