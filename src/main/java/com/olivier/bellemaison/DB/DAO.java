
package com.olivier.bellemaison.DB;

import com.olivier.bellemaison.DB.DAO.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author olivier-h
 */
public interface DAO {
         public void Create() throws SQLException, Exception;
	 public void Insert() throws SQLException, Exception;
         public void DeleteByID(String ID) throws SQLException, Exception;
         public String Selectall() throws SQLException;
         public ArrayList SelectByID(int ID) throws SQLException;
	 public void Update(String ID);
         public void droptable();
}
