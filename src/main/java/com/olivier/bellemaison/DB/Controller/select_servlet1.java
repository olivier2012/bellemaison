/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olivier.bellemaison.DB.Controller;

import com.olivier.bellemaison.DB.Student;
import com.olivier.bellemaison.DB.StudentDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author olivier-h
 */
public class select_servlet1 extends HttpServlet {

    org.apache.logging.log4j.Logger log = LogManager.getLogger(select_servlet1.class.getName());

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet selectbyid</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet selectbyid at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int studentid = Integer.parseInt(request.getParameter("studentid"));
        log.info("in the select_servlet1 doGet method ...........");
        String st = null;
        String DB = "student";
        StudentDaoImp stdi = new StudentDaoImp(DB);
        String str_exa = "example";
        try {
            st = stdi.select();
            log.info(" select_servlet1 servlet side , transfer the request to  jsp  file " + st.length()+"  records");

            if (st.isEmpty()) {
                log.info(" select_servlet1 selectById get the null return  , check  ....  ");
                st="new Student(100,str_exa,str_exa,str_exa";
            }
            request.setAttribute("student2", st);

            String url = "/display_jsp_1.jsp";
 

            request.getRequestDispatcher(url).forward(request, response);
            //   getServletContext().getRequestDispatcher(url).forward(request,response); 
        } catch (SQLException ex) {
            Logger.getLogger(select_servlet1.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
