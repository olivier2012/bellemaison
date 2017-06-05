package com.olivier.bellemaison.DB.Person;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class SelectPersonPage extends HttpServlet {

    private String connectionURL;   //field for storage of  DB  connection string

    public void init() {          //this method is used for one-time activities , it's called when servlet is initialized 
        connectionURL = getServletContext().getInitParameter("connect_string");
        try {
            /*loading Oracle driver, usually is done automatically*/ Class.forName("oracle.jdbc.driver.OracleDriver");
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
        Map
        try {
        String fnameVal = req.getParameter("fname");
        String lnameVal = req.getParameter("lname");
        String acourse = req.getParameter("course");
        fnameVal =  returnEmptyIfNull(fnameVal);
        lnameVal =  returnEmptyIfNull(lnameVal);
        acourse =  returnEmptyIfNull(acourse);
            int firPar = parseInt(req.getParameter("fvalue"));
            int secPar = parseInt(req.getParameter("lvalue"));
            pw.println("<body>");
            pw.println("getQueryString() is : "+rgq);
            pw.println("<table border='1' width='70%' >");
            pw.println("<h3> Grade list :  </h3> <br/><br/>");
            pw.println("<tr><th>First Name </th><th> Last Name </th><th> Course </th><th> Grade </th><th> Grade Date </th></tr>");
            readFromDBGrade(connectionURL, firPar, secPar,fnameVal,lnameVal,acourse,pw);

        } catch (Exception e) {
            pw.println("<body>");
            pw.print(e.getMessage()+"<p><i>An error during processing <i></p>");

        } finally {
            pw.println("</table></body>");
        }

    }


private void readFromDBGrade(String connectionURL, int firPar, int secPar,String fnameVal,String lnameVal,String acourse, PrintWriter pw) {
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
                       rs =  stmt.executeQuery("select a.GRADE,a.GRADEDT ,b.FNAME,b.LNAME,c.COURSE "+ "from t_grade a ,t_stud b, t_course c where a.sid=b.sid and a.crid=c.crid and a.grade between "+ firPar +" and "+ secPar );
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

