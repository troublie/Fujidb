<%-- 
    Document   : resultadoBuscaID
    Created on : Jan 10, 2017, 11:08:45 AM
    Author     : juliano.lopes
--%>
<%@page import="fujidb.entities.Departamento"%>
<%@page import="fujidb.entities.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>Resultado da busca por ID</h1>
        <% Usuario u = (Usuario) request.getAttribute("usuarioID");
        Departamento depto = new Departamento();
        %>
        <table>
            <tr>
                <td><%=u.getId()%></td>
                <% depto = u.getDepto();%>
                <td>Nome depto: <%=depto.getNome()%> |</td>
                <td><%=u.getNome()%></td>
                <td><%=u.getSobreNome()%></td>
                <td><%=u.getEmail()%></td>
            </tr>
        </table>
    </body>
</html>
