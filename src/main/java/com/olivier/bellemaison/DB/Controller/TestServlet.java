/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olivier.bellemaison.DB.Controller;

import com.olivier.bellemaison.DB.InitConnect;
import com.olivier.bellemaison.DB.InitDB;
import com.olivier.bellemaison.DB.InitTable;
import com.olivier.bellemaison.DB.Student;
import com.olivier.bellemaison.DB.StudentDaoImp;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Iterator;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;




/**
 *
 * @author user
 */
//@WebServlet("")
public class TestServlet extends HttpServlet {

    private int globalCount=0;
    //add the log4j2 version  
  Logger log =  LogManager.getLogger(TestServlet.class.getName());
  
  // if the vm -dconfigureation file no effect , use the loggerContext add it  
  LoggerContext context =(LoggerContext) LogManager.getContext(false);
  File afile = new File("C:\\Users\\olivier-h\\Documents\\NetBeansProjects\\bellemaison\\src\\main\\java\\com\\olivier\\bellemaison\\log4j2.xml");
  //context.setConfigLocation(afile.toURI());
 
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        globalCount ++;
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String course = request.getParameter("course");
        String[] marks = request.getParameterValues("mark");

        //connect DB check database
        Connection CurConn = null;
        log.info("main begin.........! ");
        String DB;
        try {
            // setting  DATABASE name 
            DB = "student";
            // inital the connection 
            CurConn = (Connection) InitConnect.Connect();
            
           // check the database is exist , if not create 
            
            boolean isexist = InitConnect.checkDBExist(DB);
           
            //create student instance , call the student DAO interface method 
            StudentDaoImp studentdi = new StudentDaoImp((com.mysql.jdbc.Connection) CurConn,DB);
            
            // create student object 
            Student sts = new Student(firstname, lastname);
            
            InitTable t_stu = new InitTable();
            Student sts1 = new Student("first",lastname,course);
            request.setAttribute("setAttr", sts1);
           /* if(request.getAttribute("setAttr")){
               sts1.setLast_name("second");
               Iterator <String> iterator = sts1.iterator();
               while(iterator.hasNext()){ 
               }
               }*/
            System.out.println("check the database .....");
            log.info("database exist " + isexist);
            if (!isexist) {
                InitDB.Action((com.mysql.jdbc.Connection) CurConn,DB);
            }
            System.out.println("check the table ..... ");
            boolean ex_t = InitConnect.checkTableExist("student", DB);
            System.out.println("check the table ..... " + ex_t);
            if (!ex_t) {
                System.out.println("ready to create the table ..... ");
             /*   t_stu.setConn((com.mysql.jdbc.Connection) CurConn);
                t_stu.setTabl("student");
                t_stu.setCrea_sql(sts.cre_sql);
                t_stu.create();  */
                
                
                studentdi.create();
                System.out.println("created the table!!");
            }

            
            sts.setCourse_id(course);
            studentdi.insert(sts);
            log.info("got records from student ==============================");
            System.out.println("got records from student ==============================");
            studentdi.select();
        } catch (Exception ex) {
               log.info("exception : " + ex);
        } catch (Throwable ex) {
            log.info("exception : " + ex);
        }
        // build objrect student 
        // Dao dao = new
        // dao.inser(s);

        //return those value to html 
        System.out.println(firstname + lastname + " " + course);
        int i = 0;
        for (String mark : marks) {
            System.out.println("Java servlet got the parameters : "+mark);
        }
       // ServletContext sc = getServletcontext();
        //String path;
       // path = sc.getRealPath("Servlet real path :  " + "/WEB-INF/web.xml");
       // System.out.println(path);
         
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        log.info("send message to html .. ");
        out.println("<html><body>");
        out.println("<label>FirstName:</label> :" + firstname + "<br>" + "<label>LastName:</label> :" + lastname);
        out.println("<br>" + "<label>Course_id : </label>" + course + "<br>");
        out.println("<br>" + "<label>globalcount: </label>" + globalCount + "<br>");
        out.println("</body></html>");

        String url = "index.html";
        
        getServletContext().getRequestDispatcher(url).forward(request,response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
