package com.olivier.bellemaison.DB.DAO_bellemaison;

import com.olivier.bellemaison.DB.DAO_bellemaison.DAO_BelleMaison;
import com.olivier.bellemaison.DB.Person.Person;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author olivier-h
 */
public interface DAO_person extends DAO_BelleMaison {

    /**
     *
     * @param ID
     * @return
     * @throws SQLException
     */
    @Override
         public ArrayList<Person> SelectByID(int ID) throws SQLException;

}
