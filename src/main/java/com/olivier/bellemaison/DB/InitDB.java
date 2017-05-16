package com.olivier.bellemaison.DB;

import java.sql.SQLException;

import java.sql.Statement;

import com.olivier.bellemaison.DB.InitConnect;
import com.mysql.jdbc.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class InitDB {
	   final static Logger log = (Logger) LogManager.getLogger(InitDB.class.getName());
	   static Statement statement = null;
	   static String sql = null;

	   public static void Action(Connection conn,String DBname) throws SQLException, Exception{
	   log.info("Begin create database ..... ! " );
	   sql="create database " + DBname;
        statement = (Statement) conn.createStatement();
        statement.executeUpdate(sql);
 	    log.trace(sql );
        log.info("Successful create database :" );
        statement.close();
	   }
         }
