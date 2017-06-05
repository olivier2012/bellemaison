package com.olivier.bellemaison.DB.Person;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FlexibleFormPage extends HttpServlet  {
    final static Logger log = (Logger) LogManager.getLogger(FlexibleFormPage.class.getName());
    private String connectionURL ;   //field for storage of  DB  connection string
    
    public void init( )   {          //this method is used for one-time activities , it's called when servlet is initialized 
        connectionURL = getServletContext().getInitParameter("connect_string");
        try {  /*loading Oracle driver, usually is done automatically*/ Class.forName("com.mysql.jdbc.Driver");   } 
        catch (Exception ex)    {       System.out.println("\t" + ex);      }
    }	

   @Override
   public void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException 
    {
        
        
        resp.setContentType("text/html");
        
        /*get connection from database then get data from here */
        String connectionURL = getServletContext().getInitParameter("connect_string");
       // Connection conn = DriverManager.getConnection(connectionURL,"root","x09seokw");
        String fnameVal = req.getParameter("fname");
        String lnameVal = req.getParameter("lname");
        String acourse = req.getParameter("course");
        fnameVal =  returnEmptyIfNull(fnameVal);
        lnameVal =  returnEmptyIfNull(lnameVal);
        acourse =  returnEmptyIfNull(acourse);
        PrintWriter pw = resp.getWriter();
        /*add the html header to resp , pay attention to the add position */
        RequestDispatcher rd =req.getRequestDispatcher("/index_header.html");
        rd.include(req,resp);
        try{
        pw.println("<form action='"+req.getContextPath()+ "/selectPersons' method='post'>");
        /* if the post method , next get parameter name or values , how to do  ? 
        pw.println("<form action='"+req.getContextPath()+"/selectPersons' method='post'>"); */
        pw.println("<table border='1' width='70%' >");
        pw.println("<h3> Selection parameters  :  </h3>");
        pw.println("<tr><th>First name </th><th>Last name </th><th>MotherlastName</th></tr>");
        
          pw.println("<tr><td> <select name='fname' ><option> --- </option> ");
        readFromDBFname(connectionURL,  pw);        
         pw.println("</select></td>   ");
        
        pw.println("<td> <select name='lname'> <option>--- </option>");
        readFromDBLname(connectionURL,  pw);        
         pw.println("</select></td>  ");
         
        pw.println("<td> <select name='motherlastname'> <option>--- </option>");
        readFromDBCourse(connectionURL,  pw);        
         pw.println("</select></td> </tr>  ");
          pw.println("</table>");
           pw.println("<br/><hr>");
        pw.println("Input two ages values : <br/><br/>");
        pw.print("<label>The ages from  </label><input type='text' name='fvalue' value='15' />");
        pw.println("<label>  To  </label><input type='text' name='lvalue' value='70' /><br/><br/>");
        pw.println("<input type='submit'  value='send'>"); 
         
        pw.println("</form >"); 
        pw.println("<hr>");
        pw.println("<li>ContextPath=<b style='color:red'>" + req.getContextPath() + "</b></li>");
        pw.println("<li>ServletPath=<b style='color:blue'>" + req.getServletPath() + "</b></li>");
        pw.println("<li>PathInfo=<b style='color:orange'>" + req.getPathInfo() + "</b></li>");
        pw.println("<li>QueryString=<b style='color:green'>" + req.getQueryString() + "</b></li>");
        pw.println("<li>ServletContext=<b style='color:green'>" + req.getServletContext().getServletRegistration("SelectPersonPage") + "</b></li>");
        
        }
         catch(Exception e){
        /*add the html header to resp , pay attention to the add position */
        rd =req.getRequestDispatcher("/index_header.html");
        rd.include(req,resp);
         pw.print("<p><i>An error during calculations <i></p>");
        rd =req.getRequestDispatcher("/index_footer.html");
        rd.include(req,resp);
    } finally{
        /*add the html header to resp , pay attention to the add position */
        rd =req.getRequestDispatcher("/index_footer.html");
        rd.include(req,resp);
        }
        
    }

    private void readFromDBLname(String connectionURL, PrintWriter pw) {
        try 
        (
            Connection con = DriverManager.getConnection(connectionURL,"bellemaison","goodlucky");
            Statement stmt = con.createStatement();
        )
        {  ResultSet rs =  stmt.executeQuery("SELECT  DISTINCT lastname FROM person ");
            while( rs != null  &&  rs.next(  )  ){
                   pw.println("<option>" + rs.getString("lastname") + "</option>");
            }
        }
        catch(Exception e){
		pw.println("<tr><td colspan='2'>An error \"" +  e.getMessage() +  "\" during DB reading</td></tr>"); 
        }
    }
    
    private void readFromDBFname(String connectionURL, PrintWriter pw) {
        try 
        (
             Connection con = DriverManager.getConnection(connectionURL,"bellemaison","goodlucky");
            Statement stmt = con.createStatement();
        )
        {  ResultSet rs =  stmt.executeQuery("SELECT  DISTINCT firstname FROM person ");
            while( rs != null  &&  rs.next(  )  ){
                   pw.println("<option>" + rs.getString("firstname") + "</option>");
            }
        }
        catch(Exception e){
		pw.println("<tr><td colspan='2'>An error \"" +  e.getMessage() +  "\" during DB reading</td></tr>"); 
        }
    }
    
        private void readFromDBCourse(String connectionURL, PrintWriter pw) {
        try 
        (
            Connection con = DriverManager.getConnection(connectionURL,"bellemaison","goodlucky");
            Statement stmt = con.createStatement();
        )
        {  ResultSet rs =  stmt.executeQuery("SELECT  DISTINCT motherlastname FROM person ");
            while( rs != null  &&  rs.next(  )  ){
                   pw.println("<option>" + rs.getString("motherlastname") + "</option>");
            }
        }
        catch(Exception e){
		pw.println("<tr><td colspan='2'>An error \"" +  e.getMessage() +  "\" during DB reading</td></tr>"); 
        }
    }
    private String returnEmptyIfNull(String inp) { return inp == null ? "" : inp;} 	//simple  function 
}// class

/*

  <!-- exercise 2   -->
   <servlet>
        <servlet-name>SelectGradesPage</servlet-name>
        <servlet-class>test.SelectGradesPage</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>SelectGradesPage</servlet-name>
        <url-pattern>/selectGrades</url-pattern>
    </servlet-mapping>
*/