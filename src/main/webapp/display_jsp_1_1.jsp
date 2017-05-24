<%@ page language="java" import="java.sql.*" %>
<HTML>
<HEAD> <TITLE> The JDBCQuery JSP  </TITLE> </HEAD>
<BODY BGCOLOR="white">
<% String searchCondition = request.getParameter("cond"); 
   if (searchCondition != null) { %>
      <H3> Search results for  <I> <%= searchCondition %> </I> </H3>
      <B> <%= runQuery(searchCondition) %> </B> <HR><BR>
<% }  %>
<B>Enter a search condition:</B>
<FORM METHOD="get"> 
<INPUT TYPE="text" NAME="cond" SIZE=30>
<INPUT TYPE="submit" VALUE="Ask Oracle"/>
</FORM>
<input type="button"  value="query" name="query" onclick="runQuery()" />
</BODY>
</HTML>
<%-- Declare and define the runQuery() method. --%>
<%!private String runQuery() throws SQLException {
     Connection conn = null; 
     Statement stmt = null; 
     ResultSet rset = null; 
     try {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        conn = DriverManager.getConnection("jdbc:mysql://localhost/",
                                           "jdbc", "jdbc");
        stmt = conn.createStatement();
        // dynamic query
        rset = stmt.executeQuery ("SELECT student_id,First_name,Last_name,Course_id FROM student.student ");
       return (formatResult(rset));
     } catch (SQLException e) { 
         return ("<P> SQL error:  " + e + "  </P>\n");
     } finally {
         if (rset!= null) rset.close(); 
         if (stmt!= null) stmt.close();
         if (conn!= null) conn.close();
     }
  }

   private String runQuery(String cond) throws SQLException {
     Connection conn = null; 
     Statement stmt = null; 
     ResultSet rset = null; 
     try {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        conn = DriverManager.getConnection("jdbc:mysql://localhost/",
                                           "jdbc", "jdbc");
        stmt = conn.createStatement();
        // dynamic query
        rset = stmt.executeQuery ("SELECT student_id,First_name,Last_name,Course_id FROM student.student "+ 
                           (cond.equals("") ? "" : "WHERE " + cond ));
       return (formatResult(rset));
     } catch (SQLException e) { 
         return ("<P> SQL error:  " + e + "  </P>\n");
     } finally {
         if (rset!= null) rset.close(); 
         if (stmt!= null) stmt.close();
         if (conn!= null) conn.close();
     }
  }
  private String formatResult(ResultSet rset) throws SQLException {
    StringBuffer sb = new StringBuffer();
    if (!rset.next())
      sb.append("<P> No matching rows.<P>\n");
    else {  sb.append("<UL>"); 
            do {  sb.append("<LI>" + " Student_id : "+rset.getInt(1) + 
                            " First Name:  " + rset.getString(2) + 
                    " Last Name:  " + rset.getString(3) + 
                    " Course_id :  " + rset.getString(4) + ".</LI>\n");
            } while (rset.next());
           sb.append("</UL>"); 
    }
    return sb.toString();
  }
%>