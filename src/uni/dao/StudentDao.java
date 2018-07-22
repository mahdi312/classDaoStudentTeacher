package uni.dao;

import uni.classes.Student;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends AbstractPersonDao<Student> {
    public StudentDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
    }

    @Override
    public void addEntity(Student Person) {
        Student student = (Student) Person;
        try {
            Statement st = connect.createStatement();
            String qr = "INSERT INTO student(firstname,lastname,address,teacher_id)" +
                    " VALUES ('" + student.getFirstname() + "','" + student.getLastname() + "'," +
                    "'" + student.getAddress() + "','" + student.getTeacher_id() + "')";
            st.executeUpdate(qr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEntity(Student Person) {
        Student student = (Student) Person;
        try {
            Statement st = connect.createStatement();
            String qr = "DELETE FROM student WHERE id='" + student.getId() + "'";
            st.executeUpdate(qr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEntity(Student Person) {
        Student student = (Student) Person;
        try {
            Statement st = connect.createStatement();
            String qr = "select * from student where id = '" + student.getId() + "'";
            ResultSet rs = st.executeQuery(qr);
            Student stu = new Student(rs.getInt("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("address"),
                    rs.getInt("tracher_id"));
            if (stu != null) {
                qr = "update student set firstname='" + student.getFirstname() + "'" +
                        ",lastname='" + student.getLastname() + "'" +
                        ",address='" + student.getAddress() + "'" +
                        ",teacher_id='" + student.getTeacher_id() + "' where id='" + student.getId() + "'";
                st.executeUpdate(qr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Student findByIdEntity(Student Person) {
        Student student = (Student) Person;
        Student stud = null;
        try {
            Statement st = connect.createStatement();
            String qr = "select * from student where id = '" + student.getId() + "'";
            ResultSet rs = st.executeQuery(qr);
            stud = new Student(rs.getInt("id")
                    , rs.getString("firstname"), rs.getString("lastname")
                    , rs.getString("address"), rs.getInt("teacher_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stud;
    }

    @Override
    public List<Student> getAllEntity() {
        List<Student> list = new ArrayList<>();

        try {
            Statement st = connect.createStatement();
            String qr = "select * from student";
            ResultSet rs = st.executeQuery(qr);
            while (rs.next()) {
                list.add(new Student(rs.getInt("id")
                        , rs.getString("firstname"), rs.getString("lastname")
                        , rs.getString("address"), rs.getInt("teacher_id")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }
}
