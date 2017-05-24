

<%@page import="java.util.Iterator"%>
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
         int i =0;
         if(request.getAttribute("student1")!= null){     
         Student st= new Student();   
         ArrayList<?> al_st ; 
         al_st = (ArrayList<?>)request.getAttribute("student1");
         Iterator itr = al_st.iterator();
         while(itr.hasNext()){
           i++;
           ArrayList st = itr.next();
           // st = itr.next();
           out.println(st.getStudent_id());
           out.println(st.getFirst_name()));
           out.println(st.getLast_name());
           out.println(st.getCourse_id());
           
         }
         
        /*  here only can  print the object at jsp   
           for( Object s : al_st){
                 out.println(s); 
                }
         for( Object s : al_st){
                 out.println(s); 
                 out.println(s.getClass().getEnumConstants());*/
         }
         }
              %>
       
    </body>
</html>
