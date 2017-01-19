<%-- 
    Document   : sucessoLogin
    Created on : Jan 18, 2017, 4:55:07 PM
    Author     : juliano.lopes
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login bem sucedido</title>
    </head>
    <body>
        <%
        //allow access only if session exists
            String user = (String) session.getAttribute("email");
            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("email")) {
                        userName = cookie.getValue();
                    }
                    if (cookie.getName().equals("JSESSIONID")) {
                        sessionID = cookie.getValue();
                    }
                }
            }
        %>
        <h3>Bem vindo(a) <%=userName%>, login realizado.></h3>
        <br>
        User=<%=user%>
        <br>
        <a href="checkout.jsp">Checkout Page</a>
        <form action="LogoutServlet" method="post">
            <input type="submit" value="Logout" >
        </form>
        <br>
        <a href="index.html">Ir para principal</a>
    </body>
</html>
