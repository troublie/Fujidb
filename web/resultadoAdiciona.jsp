<%-- 
    Document   : resultadoAdiciona
    Created on : Jan 9, 2017, 5:07:43 PM
    Author     : juliano.lopes
--%>

<%@page import="fujidb.entities.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado da criação de novo usuário</title>
    </head>
    <body>
        <h1>Resultado da criação de novo usuário</h1>
        <% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>
        <% if (usuario != null) {%>
        <p> Usuário <%=usuario.getNome()%> <%=usuario.getSobreNome()%> adicionado com sucesso </p>
        <%}%>
    </body>
</html>
