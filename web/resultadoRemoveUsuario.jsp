<%-- 
    Document   : resultadoRemove
    Created on : Jan 9, 2017, 5:35:58 PM
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
        <h1>Resultado da remoção de usuário</h1>
        <% boolean res = (boolean) request.getAttribute("idRem"); %>

        <% if (res) {%>
        <p> Usuário removido com sucesso! </p>
        <%}%>

        <%if (!res) {%>
        <p> Erro ao remover Usuário! </p>
        <%}%>
    </body>
</html>
