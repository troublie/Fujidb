<%-- 
    Document   : resultadoNome
    Created on : Jan 10, 2017, 11:18:32 AM
    Author     : juliano.lopes
--%>

<%@page import="fujidb.entities.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<%@page import="fujidb.entities.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultado da busca pelo nome</h1>
        <%
            Collection<Usuario> usuarios = (Collection<Usuario>) request.getAttribute("nome");
            Departamento depto = new Departamento();
        %>
        <%if (!usuarios.isEmpty()) { %>
        <table>
            <% for (Usuario u : usuarios) {%>
            <tr>
                <td><%=u.getId()%></td>
                <% depto = u.getDepto();%>
                <td>Nome depto: <%=depto.getNome()%> |</td>
                <td><%=u.getNome()%></td>
                <td><%=u.getSobreNome()%></td>
                <td><%=u.getEmail()%></td>
            </tr>
            <%}%>
        </table>
        <%}%>
    </body>
</html>
