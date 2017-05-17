/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olivier.bellemaison.DB;

import static com.olivier.bellemaison.DB.StudentDaoImp.log;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author olivier-h
 */
public class InitTable {
 final static Logger log = (Logger) LogManager.getLogger(InitTable.class.getName());
    private  Connection Conn;
    private  String Tabl;
    private String Crea_sql;
   
    public Connection getConn() {
        return Conn;
    }

    public void setConn(Connection Conn) {
        this.Conn = Conn;
    }

    public String getTabl() {
        return Tabl;
    }

    public void setTabl(String Tabl) {
        this.Tabl = Tabl;
    }

    public String getCrea_sql() {
        return Crea_sql;
    }

    public void setCrea_sql(String Crea_sql) {
        this.Crea_sql = Crea_sql;
    }

   public  void create() throws SQLException, Exception {
          	    
               System.out.println("got the connect and new table,create through crea_sql  " + Conn +" "+ Tabl+" "+ Crea_sql);
               try (Statement statement = Conn.createStatement()) {
                   log.info("Conn and create table ");
    
                   // create table 
                   //statement.executeUpdate(this.Crea_sql);
                   
                   statement.execute(getCrea_sql());
                   log.info("Create student table successful !");
       
               }
	    } 
}
