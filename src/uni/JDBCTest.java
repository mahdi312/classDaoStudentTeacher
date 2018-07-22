package uni;

import uni.classes.Student;
import uni.classes.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest {
    static Connection conn = null;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        conn = DBConnection.Connect();

        boolean again = true ;
        while (again){
            System.out.println("1: add student");
            System.out.println("2: add teacher");
            System.out.println("3: get teacher list");
            System.out.println("4: get student list");
            System.out.println("5: delete student");
            System.out.println("6: delete teacher");
            System.out.println("7: find by ID student");
            System.out.println("8: find by ID teacher");
            System.out.println("9: list of teachers and students");
            System.out.println("0: EXIT");
            int i=sc.nextInt();
            switch(i){
                case 1 : 
                    addStudent();
                    break;
                case 2 :
                    addTeacher();
                    break;
                case 3 :
                    getTeacherList();
                    break;
                case 4 :
                    getStudentList();
                    break;
                case 5 :
                    deleteStudent();
                    break;
                case 6:
                    deleteTeacher();
                    break;
                case 7 :
                    findByIdStudent();
                    break;
                case 8 :
                    findByIdTeacher();
                    break;
                case 9:
                    listOfTeachersAndStudents();
                    break;
                case 0 :
                    again = false ;
                    conn.close();
                    break;
            }
        }
    }

    private static void listOfTeachersAndStudents() {
    }

    private static void findByIdTeacher() {
    }

    private static void findByIdStudent() {

    }

    private static void deleteTeacher() {
        getTeacherList();
        System.out.println("Enter the id you want to delete");
        int i = sc.nextInt();
        try {
            Statement st = conn.createStatement();
            String qr = "delete from teacher where id='"+i+"'";
            st.executeUpdate(qr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteStudent() {
        getStudentList();
        System.out.println("Enter the id you want to delete");
        int i = sc.nextInt();
        try {
            Statement st = conn.createStatement();
            String qr = "delete from student where id='"+i+"'";
            st.executeUpdate(qr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void getStudentList() {
        System.out.println("List of Students: ");
        try {
            Statement st = conn.createStatement();
            String qr = "select * from student";
            ResultSet rs = st.executeQuery(qr);
            while (rs.next()){
                System.out.println("Full Name is: "+rs.getInt("id")+"-"
                        +rs.getString("firstname")+" "
                        +rs.getString("lastname")+" address: "
                        +rs.getString("address")
                        +" teacher_id" + rs.getString("teacher_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void getTeacherList() {
        System.out.println("List of Teachers: ");
        try {
            Statement st = conn.createStatement();
            String qr = "select * from teacher";
            ResultSet rs = st.executeQuery(qr);
            while (rs.next()){
                System.out.println("Full Name is: "+rs.getInt("id")+"-"
                        +rs.getString("firstname")+" "
                        +rs.getString("lastname")
                        +" department" + rs.getString("dept"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addTeacher() {
        System.out.println("Enter The Name of teacher");
        System.out.println("firstname:");
        String fname = sc.next();
        System.out.println("lastname:");
        String lname = sc.next();
        System.out.println("department:");
        String dept = sc.next();
        try {
            Statement st = conn.createStatement();
            String qr = "insert into teacher (firstname,lastname,dept) " +
                    "values ('"+fname+"','"+lname+"','"+dept+"');";
            st.executeUpdate(qr);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void addStudent() {
        getTeacherList();
        System.out.println("Enter The Name of Student");
        System.out.println("firstname:");
        String fname = sc.next();
        System.out.println("lastname:");
        String lname = sc.next();
        System.out.println("address:");
        String address = sc.next();
        System.out.println("teacher_id:");
        int tr_id = sc.nextInt();
        try {
            Statement st = conn.createStatement();
            String qr = "insert into student (firstname,lastname,address,teacher_id) " +
                    "values ('"+fname+"','"+lname+"','"+address+"','"+tr_id+"');";
            st.executeUpdate(qr);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
