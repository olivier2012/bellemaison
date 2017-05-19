package com.olivier.bellemaison.DB;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;







public class InitConnect{
   static Statement stmt = null;
   final static Logger log = (Logger) LogManager.getLogger(InitConnect.class.getName());
  
   public static Connection Connect() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	String url ="jdbc:mysql://localhost?useSSL=false";
	log.info("connecting Mysql DB.........! without database name ");
	   Connection conn= DriverManager.getConnection(url,"jdbc","jdbc");
    log.info("connected Mysql DB! ");

	 return  conn;
 }
    
   public static Connection Connect(String DBname) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost/"+DBname+"?useSSL=false";
		log.trace("url :"+url);
		log.info("connecting Mysql DB with databasename.........! "+ DBname);
		   Connection conn= DriverManager.getConnection(url,"jdbc","jdbc");
	    log.info("connected Mysql DB! ");

		 return  conn;
	 }
	    
	public static <E> boolean checkDBExist(String DBname) throws Throwable{
		    Connection con1 =Connect();
		    boolean DBExist=false;
		    ResultSet resultset=con1.getMetaData().getCatalogs();
		    log.info("--------------------------------------all of databases : -----");		    
		    while(resultset.next()){
		    	String databaseName =resultset.getString(1);
		    	log.trace(databaseName );
		    	 if(databaseName.equals(DBname)){
		    		 DBExist=true;
		    	 }
		    }
		    resultset.close();
		    return DBExist;
   }
	
	public static boolean checkTableExist(String table,String DBname) throws Throwable{
	    Connection con1 =Connect(DBname);
	    boolean TableExist=false;
	    ResultSet resultset=con1.getMetaData().getTables(null,null,"%",null);
	    log.info("--------------------------------------all of tables : -----");
            System.out.println("in the checktable exist .... ");
	    while(resultset.next()){
	    	String tablename =resultset.getString(3);
	    	log.trace(tablename );
	    	 if(tablename.equals(table)){
	    		 TableExist=true;
	    	 }
	    }
	    resultset.close();
	    return TableExist;
}
        public  static boolean isDbConnected(Connection con) {
    //final String CHECK_SQL_QUERY = "SELECT 1";
        try {
        if(!con.isClosed() || con!=null){
            return true;
        }
         } catch (SQLException e) {
          return false;
         }
          return false;
}
}

