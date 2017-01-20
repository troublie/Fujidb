<%-- 
    Document   : listaProdutos
    Created on : Jan 20, 2017, 4:36:15 PM
    Author     : juliano.lopes
--%>

<%@page import="fujidb.entities.Produto"%>
<%@page import="fujidb.entities.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Produtos</h1>
        <%
            List<Produto> produtos
                    = (List<Produto>) request.getAttribute("produtos");

        %>
        <%if (produtos.size() == 0) { %>
        <h1> Nenhum produto cadastrado! </h1>
        <% } %>
        <%if (produtos.size() > 0) { %>
        <table>
            <% for (Produto p : produtos) {%>
            <tr>
                <td>ID: <%=p.getId()%> |</td>
                <td><%=p.getPartNumber()%></td>
                <td><%=p.getPartName()%> |</td>
                <td><%=p.getPartNameTrad()%> |</td>
                <td><%=p.getNcm()%> |</td>
                <td><%=p.getDetalhes()%> |</td>
            </tr>
            <%}%>
        </table>
        <%}%>
    </body>
</html>
