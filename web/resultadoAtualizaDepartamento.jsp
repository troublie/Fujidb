<%-- 
    Document   : resultadoAtualiza
    Created on : Jan 9, 2017, 5:50:51 PM
    Author     : juliano.lopes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultado da atualização de departamento</h1>
        <% boolean res = (boolean) request.getAttribute("res"); %>
        <% if (res) {%>
        <p> Departamento atualizado com sucesso! </p>
        <%}%>
        <%if (!res) {%>
        <p> Departamento não encontrado! </p>
        <%}%>
    </body>
</html>
