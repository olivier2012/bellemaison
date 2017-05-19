/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olivier.bellemaison.DB;

import static com.olivier.bellemaison.DB.InitConnect.log;
import java.sql.Connection;

/**
 *
 * @author olivier-h
 */
public class IsConnect {

    static Connection isconnect() throws Exception, Throwable {
        // setting  DATABASE name
        String DB = "student";
        // inital the connection
        Connection CurConn = (Connection) InitConnect.Connect();
            log.info("2, connection the database ... ");
           // check the database is exist , if not create 
            
            boolean isexist = InitConnect.checkDBExist(DB);
           
            //create student instance , call the student DAO interface method 
            StudentDaoImp studentdi = new StudentDaoImp((com.mysql.jdbc.Connection) CurConn,DB);
            
            // create student object 
            Student sts = null;
            
            InitTable t_stu = new InitTable();
  /*          Student sts1 = new Student(studentid,firstname,lastname,course);
            request.setAttribute("setAttr", sts1);
           if(request.getAttribute("setAttr")){
               sts1.setLast_name("second");
               Iterator <String> iterator = sts1.iterator();
               while(iterator.hasNext()){ 
               }
               }*/
            log.info("3, check the database ....." + "database exist " + isexist);
            if (isexist){
                 CurConn = (Connection) InitConnect.Connect(DB);
            }
            else {
                InitDB.Action((com.mysql.jdbc.Connection) CurConn,DB);
                 CurConn = (Connection) InitConnect.Connect(DB);
            }
            boolean ex_t = InitConnect.checkTableExist("student", DB);
            log.info("4,check the table ..... " + ex_t);
            if (!ex_t) {
                log.info(" 4.5, ready to create the table ..... ");
               t_stu.setConn((com.mysql.jdbc.Connection) CurConn);
                t_stu.setTabl("student");
                t_stu.setCrea_sql(sts.cre_sql);
                t_stu.create();  
                log.info("4.8,  created the table!!");
            }
         return CurConn;
    }
    
}
