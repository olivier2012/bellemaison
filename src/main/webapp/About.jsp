<%-- 
    Document   : About
    Created on : May 17, 2017, 2:44:18 AM
    Author     : olivier-h
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        Server Version: <%= application.getServerInfo() %><br> 
        Servlet Version: <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %> 
        JSP Version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %> <br>
    </body>
</html>
