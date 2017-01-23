<%-- 
    Document   : resultadoBuscaProdutoID
    Created on : Jan 23, 2017, 11:18:37 AM
    Author     : juliano.lopes
--%>

<%@page import="fujidb.entities.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>Resultado da busca por ID</h1>
        <% Produto p = (Produto) request.getAttribute("id");
        %>
        <table>
            <tr>
                <td>ID: <%=p.getId()%> |</td>
                <td><%=p.getPartNumber()%></td>
                <td><%=p.getPartName()%> |</td>
                <td><%=p.getPartNameTrad()%> |</td>
                <td><%=p.getNcm()%> |</td>
                <td><%=p.getDetalhes()%> |</td>
            </tr>
        </table>
    </body>
</html>
