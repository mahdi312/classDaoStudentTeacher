package uni.dao;

import com.sun.javafx.scene.control.behavior.TwoLevelFocusBehavior;
import uni.classes.Person;
import uni.classes.Teacher;

import javax.swing.plaf.nimbus.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao extends AbstractPersonDao<Teacher> {

    public TeacherDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
    }

    @Override
    public void addEntity(Teacher Person) {
        Teacher teacher = (Teacher) Person;
        try {
            Statement st = connect.createStatement();
            String qr = "insert into teacher (firstname,lastname,dept) " +
                    "values ('" + teacher.getFirstname() + "','" + teacher.getLastname() + "','" + teacher.getDept() + "');";
            st.executeUpdate(qr);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEntity(Teacher Person) {
        Teacher teacher = (Teacher) Person;
        try {
            Statement st = connect.createStatement();
            String qr = "delete from teacher where id = '" + teacher.getId() + "'";
            st.executeUpdate(qr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEntity(Teacher Person) {
        Teacher teacher = (Teacher) Person;
        try {
            Statement st = connect.createStatement();
            String qr = "select * from teacher where id = '" + teacher.getId() + "'";
            ResultSet rs = st.executeQuery(qr);
            Teacher tr = new Teacher(rs.getInt("id"), rs.getString("firstname"),
                    rs.getString("lastname"), rs.getString("dept"));
            if (tr != null) {
                qr = "update teacher set firstname='" + teacher.getFirstname() + "'" +
                        ", lastname='" + teacher.getLastname() + "'" +
                        ",dept='" + teacher.getDept() + "' where id='" + teacher.getId() + "'";
                st.executeUpdate(qr);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Teacher findByIdEntity(Teacher Person) {
        Teacher teacher = (Teacher) Person;
        Teacher tr = null;
        try {
            Statement st = connect.createStatement();
            String qr = "select * from teacher where id='"+teacher.getId()+"'";
            ResultSet rs = st.executeQuery(qr);
            tr = new Teacher(rs.getInt("id"), rs.getString("firstname"),
                    rs.getString("lastname"), rs.getString("dept"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tr;
    }

    @Override
    public List<Teacher> getAllEntity() {
        List<Teacher> list = new ArrayList<>();
        try {
            Statement st = connect.createStatement();
            String qr = "select * from teacher";
            ResultSet rs = st.executeQuery(qr);
            while(rs.next()) {
                list.add(new Teacher(rs.getInt("id"), rs.getString("firstname"),
                        rs.getString("lastname"), rs.getString("dept")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
