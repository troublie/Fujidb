<%-- 
    Document   : resultadoAtualizaProduto
    Created on : Jan 23, 2017, 4:36:50 PM
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
        <h1>Resultado da atualização</h1>
        <% boolean res = (boolean) request.getAttribute("res"); %>
        <% if (res) {%>
        <p> PN atualizado com sucesso! </p>
        <%}%>
        <%if (!res) {%>
        <p> PN não encontrado! </p>
        <%}%>
    </body>
</html>
