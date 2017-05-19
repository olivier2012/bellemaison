
package com.olivier.bellemaison.DB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author olivier-h
 */
public interface DAO {
         public void create() throws SQLException, Exception;
	 public void insert(Student s) throws SQLException, Exception;
         public void deleteByID(String ID) throws SQLException, Exception;
         public void select() throws SQLException;
         public ArrayList selectByID(int ID) throws SQLException;
	 public void update(String ID); 
}
