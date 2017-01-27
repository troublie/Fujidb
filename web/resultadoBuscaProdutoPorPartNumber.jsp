<%-- 
    Document   : resultadoBuscaProdutoPorPartNumber
    Created on : Jan 23, 2017, 11:18:21 AM
    Author     : juliano.lopes
--%>
<%@page import="fujidb.entities.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>Resultado</h1>
        <%
            Collection<Produto> produtos = (Collection<Produto>) request.getAttribute("pn");

        %>
        <%if (!produtos.isEmpty()) { %>
        <table>
            <% for (Produto p : produtos) {%>
            <tr>
                <td>ID: <%=p.getId()%> |</td>
                <td><a href="atualizaProduto.jsp?id=<%=p.getId()%>&pn=<%=p.getPartNumber()%>&pname=<%=p.getPartName()%>&pntrad=<%=p.getPartNameTrad()%>&ncm=<%=p.getNcm()%>&details=<%=p.getDetalhes()%>"><%=p.getPartNumber()%></a></td>
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
