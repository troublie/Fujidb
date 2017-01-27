<%-- 
    Document   : atualizaProduto
    Created on : Jan 23, 2017, 4:15:10 PM
    Author     : juliano.lopes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<form method="POST" action="FrontControllerServlet?control=AtualizaProduto">
            ID:<br>
            <input type="text" name="id" value="<%=request.getParameter("id") %>" readonly="readonly">
            <br>
            Part number:<br>
            <input type="text" name="pn" value="<%=request.getParameter("pn") %>" readonly="readonly">
            <br>
            Part Name:<br>
            <input type="text" name="pname" value="<%=request.getParameter("pname") %>">
            <br>
            Tradução:<br>
            <input type="text" name="pntrad" value="<%=request.getParameter("pntrad") %>">
            <br>
            NCM:<br>
            <input type="text" name="ncm" value="<%=request.getParameter("ncm") %>">
            <br>
            Remarks:<br>
            <input type="text" name="details" value="<%=request.getParameter("details") %>">
            <br>
            <button type="submit" value="Submit">Atualizar</button>
    </body>
</html>
