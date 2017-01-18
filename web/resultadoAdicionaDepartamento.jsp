<%-- 
    Document   : resultadoAdiciona
    Created on : Jan 9, 2017, 5:07:43 PM
    Author     : juliano.lopes
--%>

<%@page import="fujidb.entities.Departamento"%>
<%@page import="fujidb.entities.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado da criação de novo departamento</title>
    </head>
    <body>
        <h1>Resultado da criação de novo departamento</h1>
        <% Departamento departamento = (Departamento) request.getAttribute("departamento"); %>
        <% if (departamento == null) { %>
        <p>Erro na criação do departamento!<p>
            <% } %>
        </p>
        <% if (departamento != null) {%>
        <p> Departamento <%=departamento.getNome()%> adicionado com sucesso </p>
        <%}%>
    </body>
</html>
