<%-- 
    Document   : index
    Created on : Jan 9, 2017, 10:44:33 AM
    Author     : lopes.lopes
--%>

<%@page import="fujidb.entities.Departamento"%>
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
        <h1>Departamentos</h1>
        <%
            List<Departamento> departamentos
                    = (List<Departamento>) request.getAttribute("departamentos");
        %>
        <%if (departamentos.size() == 0) { %>
        <h1> Nenhum departamento cadastrado! </h1>
        <% } %>
        <%if (departamentos.size() > 0) { %>
        <table>
            <% for (Departamento d : departamentos) {%>
            <tr>
                <td>ID: <%=d.getId()%> |</td>
                <td><%=d.getNome()%></td>
            </tr>
            <%}%>
        </table>
        <%}%>
    </body>
</html>