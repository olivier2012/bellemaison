

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.olivier.bellemaison.DB.Student" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1
        <% 
         String student= (String) request.getAttribute("student");
         if(student !=null){
         %>
         <p><i><%= student %> </i></p>
         
         <% } %>
    </body>
</html>
