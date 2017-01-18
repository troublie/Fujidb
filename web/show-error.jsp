<%-- 
    Document   : show-error
    Created on : Jan 13, 2017, 2:52:34 PM
    Author     : juliano.lopes
--%>

<%@ page isErrorPage="true" %>
<html>
    <head>
        <title>Show Error</title>
    </head>
    <body>
        <p>Exception stack trace:<% exception.printStackTrace(response.getWriter());%>
        </p>
    </body>
</html>
