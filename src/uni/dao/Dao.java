package uni.dao;

import uni.classes.Person;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T extends Person> {
    public void addEntity(T Person);

    public void deleteEntity(T Person);

    public void updateEntity(T Person);

    public T findByIdEntity(T Person);

    public List<T> getAllEntity();


}
