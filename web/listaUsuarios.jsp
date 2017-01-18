<%-- 
    Document   : index
    Created on : Jan 9, 2017, 10:44:33 AM
    Author     : lopes.lopes
--%>

<%@page import="fujidb.entities.Departamento"%>
<%@page import="fujidb.entities.Usuario"%>
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
        <h1>Usuarios!</h1>
        <%
            List<Usuario> usuarios
                    = (List<Usuario>) request.getAttribute("usuarios");
            Departamento depto = new Departamento();
        %>
        <%if (usuarios.size() == 0) { %>
        <h1> Nenhum usuário cadastrado! </h1>
        <% } %>
        <%if (usuarios.size() > 0) { %>
        <table>
            <% for (Usuario u : usuarios) {%>
            <tr>
                <td>ID: <%=u.getId()%> |</td>
                <% depto = u.getDepto();%>
                <td>Nome depto: <%=depto.getNome()%> |</td>
                <td><%=u.getNome()%></td>
                <td><%=u.getSobreNome()%> |</td>
                <td><%=u.getEmail()%> |</td>
            </tr>
            <%}%>
        </table>
        <%}%>
    </body>
</html>