/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prepare_jsp;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author olivier-h
 */
public class Format {
      public static String formatResult_student(ResultSet rset) throws SQLException {
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
    
}
