

<%@page import="java.lang.System.*"%>
<%@page import="com.olivier.bellemaison.DB.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.olivier.bellemaison.DB.*" %>
<%@page import="org.apache.logging.log4j.Logger"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World---!</h1>
        <label> Student </label> 
      
          <%
              
         Student st= new Student();   
         ArrayList <Student> al_st = new ArrayList <Student>(); 
         log.inof("enter the jsp side..... ");
              al_st = request.getAttribute("student1");
              int i=0;
           for(Student st:al_st){
                 out.println(st.getStudent_id()); 
                 out.println(st.getFirst_name());
                 out.println(st.getLast_name()); 
                 out.println(st.getCourse_id()); 
                }
              %>
       
    </body>
</html>
