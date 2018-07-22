package uni.dao;

import uni.classes.Person;
import uni.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractPersonDao<T extends Person> implements Dao<T> {
    Connection connect;

    public AbstractPersonDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connect = DBConnection.Connect();

    }

}
