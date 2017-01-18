<%-- 
    Document   : resultadoBuscaID
    Created on : Jan 10, 2017, 11:08:45 AM
    Author     : juliano.lopes
--%>
<%@page import="fujidb.entities.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>Resultado da busca por ID</h1>
        <% Departamento d = (Departamento) request.getAttribute("departamentoID");
        %>
        <table>
            <tr>
                <td>ID: <%=d.getId()%> |</td>
                <td>Nome: <%=d.getNome()%></td>
            </tr>
        </table>
    </body>
</html>
