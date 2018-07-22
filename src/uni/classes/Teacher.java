package uni.classes;

public class Teacher extends Person {
    private String dept;

    public Teacher(int id, String firstname, String lastname, String dept) {
        super(id, firstname, lastname);
        this.dept = dept;
    }


    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "dept='" + dept + '\'' +
                '}' + super.toString();
    }
}
