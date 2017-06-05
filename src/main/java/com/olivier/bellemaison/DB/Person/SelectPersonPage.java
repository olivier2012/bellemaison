package com.olivier.bellemaison.DB.Person;

import com.olivier.bellemaison.DB.InitConnect;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectPersonPage extends HttpServlet {
     final static Logger log = (Logger) LogManager.getLogger(SelectPersonPage.class.getName());
    private String connectionURL;   //field for storage of  DB  connection string

    public void init() {          //this method is used for one-time activities , it's called when servlet is initialized 
        connectionURL = getServletContext().getInitParameter("connect_string");
        try {
            /*loading Oracle driver, usually is done automatically*/ Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            System.out.println("\t" + ex);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter pw = resp.getWriter();
        String rgq= req.getQueryString();
        /*same method : below can use the Eumeration <String> parameterNames = req.getParameterNames(); */
        try {
        String fnameVal = req.getParameter("fname");
        String lnameVal = req.getParameter("lname");
        String acourse = req.getParameter("matherlastname");
        fnameVal =  returnEmptyIfNull(fnameVal);
        lnameVal =  returnEmptyIfNull(lnameVal);
        acourse =  returnEmptyIfNull(acourse);
            int firPar = parseInt(req.getParameter("fvalue"));
            int secPar = parseInt(req.getParameter("lvalue"));
            Map <String, String[]> hm = req.getParameterMap();
            filterParameters(hm,pw);
            pw.println("<body>");
            pw.println("getQueryString() is : "+rgq +"<br/><br/>");
            pw.println("<table border='1' width='70%' >");
            pw.println("<h3> Person list :  </h3> <br/><br/>");
            pw.println("<tr><th>First Name </th><th> Last Name </th><th> Mother LastName </th><th> Age </th><th> Birth Date </th></tr>");
            readFromDBPerson(connectionURL, firPar, secPar,pw);
          //  readFromDBPerson(connectionURL, firPar, secPar,fnameVal,lnameVal,acourse,pw);

        } catch (Exception e) {
            pw.println("<body>");
            pw.print(e.getMessage()+"<p><i>An error during processing <i></p>");

        } finally {
            pw.println("</table></body>");
        }

    }

private void filterParameters(Map hm ,PrintWriter pw){
         Map <String, String[]> tmp = hm;
         for(String key:tmp.keySet()){
            String [] strArr=(String[])tmp.get(key);
            for(String val:strArr){
               if (val.equals("---")){
                   val="";
               }else{
                  val="like '"+val+"'%";
               }
          log.info("key : "+ key + "   " + "value : "+ val );
            }
         }
}

private void readFromDBPerson(String connectionURL, int firPar, int secPar,PrintWriter pw) {
        try 
        (
             Connection con = DriverManager.getConnection(connectionURL,"root","x09seokw");
            Statement stmt = con.createStatement();
        )
        { 

                ResultSet rs = null;
           
                       rs =  stmt.executeQuery("select a.firstname as fname,a.lastname as lname ,a.motherlastname as course , a.age as grade,a.birthdate as gradedt "+ "from person a where age between "+ firPar +" and "+ secPar );

                while( rs != null  &&  rs.next(  )  ){
                   pw.println("<tr><td>" + rs.getString("FNAME") + "</td><td>" + rs.getString("LNAME") + "</td><td>" + rs.getString("COURSE") 
                           + "</td><td>" +  rs.getInt("GRADE") + "</td><td>" +
                           rs.getDate("GRADEDT") + "</td></tr>");
                   log.info("" + rs.getString("FNAME") + "" + rs.getString("LNAME") + "" + rs.getString("COURSE") 
                           + "" +  rs.getInt("GRADE") + "" +
                           rs.getDate("GRADEDT") + "");
            }
        }
        catch(Exception e){
		pw.println( e.getMessage() + "during DB reading"); 
        }
    }

private void readFromDBPerson(String connectionURL, int firPar, int secPar,String fnameVal,String lnameVal,String acourse, PrintWriter pw) {
        try 
        (
             Connection con = DriverManager.getConnection(connectionURL,"root","x09seokw");
            Statement stmt = con.createStatement();
        )
        { 

                ResultSet rs = null;
           
                if (acourse.equals("---")&&lnameVal.equals("---")&&fnameVal.equals("---")){
                       fnameVal =  "";
                       lnameVal =  "";
                       acourse =   "";
                       rs =  stmt.executeQuery("select a.firstname as fname,a.lastname as lname ,a.motherlastname as course "+ "from person a a.age between "+ firPar +" and "+ secPar );
                }else if(!(fnameVal.equals("---"))){
                       lnameVal =  "";
                       acourse =   "";
                       rs =  stmt.executeQuery("select a.GRADE,a.GRADEDT ,b.FNAME,b.LNAME,c.COURSE from t_grade a ,t_stud b, t_course c where a.sid=b.sid and a.crid=c.crid and b.FNAME = '"+fnameVal+"' and a.grade between "+ firPar +" and "+ secPar );
                }else if(!(lnameVal.equals("---"))){
                       acourse =   "";
                        fnameVal =  "";
                       rs =  stmt.executeQuery("select a.GRADE,a.GRADEDT ,b.FNAME,b.LNAME,c.COURSE "+ "from t_grade a ,t_stud b, t_course c where a.sid=b.sid and a.crid=c.crid and b.LNAME = '"+lnameVal+"' and a.grade between "+ firPar +" and "+ secPar );
                }else  if (!(acourse.equals("---"))){
                       fnameVal =  "";
                       lnameVal =  "";
                       rs =  stmt.executeQuery("select a.GRADE,a.GRADEDT ,b.FNAME,b.LNAME,c.COURSE "+ "from t_grade a ,t_stud b, t_course c " + "where a.sid=b.sid and a.crid=c.crid and c.COURSE = '"+acourse+"' and a.grade between "+ firPar +" and "+ secPar );
                } 
                

                //ResultSet rs =  stmt.executeQuery("select a.GRADE,a.GRADEDT ,b.FNAME,b.LNAME,c.COURSE from t_grade a ,t_stud b, t_course c where a.sid=b.sid and a.crid=c.crid and b.FNAME "+fnameVal +" and c.COURSE "+acourse +" and b.LNAME "+lnameVal+" and (a.grade between "+ firPar +" and "+ secPar+")" );
                pw.println("<hr>"); 
                //pw.println("select a.GRADE,a.GRADEDT ,b.FNAME,b.LNAME,c.COURSE from t_grade a ,t_stud b, t_course c where a.sid=b.sid and a.crid=c.crid and b.FNAME ='"+fnameVal +"' and c.COURSE LIKE '"+acourse +"' and b.LNAME LIKE '"+lnameVal+"' and (a.grade between "+ firPar +" and "+ secPar+")" );
                pw.println("select a.GRADE,a.GRADEDT ,b.FNAME,b.LNAME,c.COURSE from t_grade a ,t_stud b, t_course c where a.sid=b.sid and a.crid=c.crid and b.FNAME "+fnameVal +" and c.COURSE "+acourse +" and b.LNAME "+lnameVal+" and (a.grade between "+ firPar +" and "+ secPar+")");
                 pw.println("<hr>");
                while( rs != null  &&  rs.next(  )  ){
                   pw.println("<tr><td>" + rs.getString("FNAME") + "</td><td>" + rs.getString("LNAME") + "</td><td>" + rs.getString("COURSE") 
                           + "</td><td>" +  rs.getInt("GRADE") + "</td><td>" +
                           rs.getDate("GRADEDT") + "</td></tr>");
            }
        }
        catch(Exception e){
		pw.println( e.getMessage() + "during DB reading"); 
        }
    }

    private String returnEmptyIfNull(String inp) { return inp == null ? "" : inp;} 	//simple  function 
}// class

