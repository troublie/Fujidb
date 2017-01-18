<%-- 
    Document   : resultadoNome
    Created on : Jan 10, 2017, 11:18:32 AM
    Author     : juliano.lopes
--%>

<%@page import="fujidb.entities.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultado da busca de departamento pelo nome</h1>
        <%
            Collection<Departamento> departamentos = (Collection<Departamento>) request.getAttribute("nome");
        %>
        <%if (!departamentos.isEmpty()) { %>
        <table>
            <% for (Departamento d : departamentos) {%>
            <tr>
                <td><%=d.getId()%></td>
                <td><%=d.getNome()%></td>
            </tr>
            <%}%>
        </table>
        <%}%>
        <%if (departamentos.isEmpty()) { %>
        <p> Departamento não encontrado! </p>
        <% } %>
    </body>
</html>
