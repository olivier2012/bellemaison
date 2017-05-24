
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
          StringBuffer sb = new StringBuffer();  
         sb.append(request.getAttribute("student2"));
        /*  here only can  print the object at jsp   
           for( Object s : al_st){
                 out.println(s); 
                }*/ 
            out.println(sb.length());
              %>
              
       
    </body>
</html>
