package com.olivier.bellemaison.DB;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class StudentDaoImp implements DAO {
  final static Logger log = LogManager.getLogger(StudentDaoImp.class.getName());
           
	/**
	 * 
	 */
	private String DBname=null;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
        private Connection con;
	public StudentDaoImp() {

	}

	public StudentDaoImp(String DBname) {
          this.DBname=DBname;
	}
	
        public StudentDaoImp(Connection con,String DBname) {
          this.DBname=DBname;
          this.con=con;
	}
	public void create() throws SQLException, Exception {
          	    
	String create_sql ;
               create_sql ="create table student ("
                       + "register_date date, "
                       + " First_name varchar(40),Last_name varchar(40),"
                       +"Email varchar(60),phone_number varchar(20),"  
                       +"Course_id varchar(20),Mark_id varchar(20) )";
               System.out.println(create_sql);
               try (Statement statement = con.createStatement()) {
                   log.info(statement.toString());
                   statement.executeUpdate(create_sql);
                   log.info("Create student table successful !");
                   System.out.println("Create student table successful !");
               }
	    }


	public void insert(Student st) throws SQLException, Exception {
		String insert_sql="insert into student (First_name,Last_name,Course_id) values(?,?,?) " ;
               try (PreparedStatement preparedStatement = (PreparedStatement) InitConnect.Connect(DBname).prepareStatement(insert_sql)) {
                   preparedStatement.setString(1,st.getFirst_name());
                   preparedStatement.setString(2, st.getLast_name());
                   preparedStatement.setString(3, st.getCourse_id());
                   System.out.println("insert the values to student table : "+preparedStatement.toString());
                   preparedStatement.executeUpdate();
                   log.trace("Insert student table successful !");
               }
	}

	public void deleteByID(String ID) throws SQLException, Exception {
		String delete_sql="delete from  student where udentst_id = '"+ID+"';" ;
               try (PreparedStatement preparedStatement = (PreparedStatement) InitConnect.Connect(DBname).prepareStatement(delete_sql)) {
                   log.trace(preparedStatement.toString());
                   int num = preparedStatement.executeUpdate();
                   log.trace("Delete  student table "+num+ " Records successful !");
               }
		
	}

	public void select() throws SQLException {
			String select_sql="select * from  student ";
			Statement statement = null;
			try {
				statement = (Statement) InitConnect.Connect(DBname).createStatement();
			} catch (Exception e) {
                            // TODO Auto-generated catch block

			}
			log.trace(statement.toString());
			ResultSet rs = statement.executeQuery(select_sql);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			/* note :  meta data access from 1  ........... not from 0 */
			log.trace("select  student table successful !");
            log.trace("-1-  rs value  " +"is afterlast  : "+ rs.isAfterLast()+"rs cursor position "+rs.isFirst());
            List<String> cname= new ArrayList<>();
            for(int i=1,y=0; i<=rsmd.getColumnCount();i++,y++){
                log.trace(i+ "rsmd  column count : " +rsmd.getColumnCount()+"  is afterlast  : "+ rs.isLast()+"rs cursor position "+rs.isFirst());
                cname.add(rsmd.getColumnName(i));
            	int size = rsmd.getColumnDisplaySize(i);
            	int typecode = rsmd.getColumnType(i);
                System.out.println("   ");
            	System.out.print("column name "+ cname.indexOf(y) + "  size  "+size +" type " + typecode +"\n\r");
            	System.out.println(" " + rsmd.getColumnName(i));
            	}
            log.trace("-2-  rs value  " +"  is afterlast  : "+ rs.isAfterLast()+" rs cursor position "+rs.isFirst());
			 Iterator iterator = cname.iterator(); 
            while(iterator.hasNext()){
             System.out.print("     " +iterator.next() );
             }
			 
            System.out.println(" ");
            while(rs.next()){
				System.out.print("          " + rs.getString(1)+"        "+rs.getString(2)+"          "+rs.getInt(3) +"\r\n");
			}
			
			statement.close();
	}
 

	public void selectByID(String ID) throws SQLException {
		String select_sql="select * from  student where student_id ='"+ID+"';";
		Statement statement = null;
		try {
			statement = (Statement) InitConnect.Connect(DBname).createStatement();
		} catch (Exception e) {
                    // TODO Auto-generated catch block

		}
		log.trace(statement.toString());
		ResultSet rs = statement.executeQuery(select_sql);
		ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
		/* note :  meta data access from 1  ........... not from 0 */
		log.trace("select  student table successful !");
        log.trace("-1-  rs value  " +"is afterlast  : "+ rs.isAfterLast()+"rs cursor position "+rs.isFirst());
        List <String> cname;
               cname = new ArrayList<>();
        for(int i=1,y=0; i<=rsmd.getColumnCount();i++,y++){
            log.trace(i+ "rsmd  column count : " +rsmd.getColumnCount()+"  is afterlast  : "+ rs.isLast()+"rs cursor position "+rs.isFirst());
            cname.add(rsmd.getColumnName(i));
        	int size = rsmd.getColumnDisplaySize(i);
        	int typecode = rsmd.getColumnType(i);
            System.out.println("   ");
        	System.out.print("column name "+ cname.indexOf(y) + "  size  "+size +" type " + typecode +"\n\r");
        	System.out.println(" " + rsmd.getColumnName(i));
        	}
        log.trace("-2-  rs value  " +"  is afterlast  : "+ rs.isAfterLast()+" rs cursor position "+rs.isFirst());
		 Iterator iterator = cname.iterator(); 
        while(iterator.hasNext()){
         System.out.print("     " +iterator.next() );
         }
		 
        System.out.println(" ");
        while(rs.next()){
			System.out.print("          " + rs.getString(1)+"        "+rs.getString(2)+"          "+rs.getInt(3) +"\r\n");
		}
		
		statement.close();
		
		
	}

	public void update(String ID) {
	      
		
	}
	  

}
