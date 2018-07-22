package uni.classes;

public class Student extends Person {
    private String address;
    private int teacher_id;

    public Student(int id, String firstname, String lastname, String address, int teacher_id) {
        super(id, firstname, lastname);
        this.address = address;
        this.teacher_id = teacher_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "address='" + address + '\'' +
                ", teacher_id=" + teacher_id +
                '}' + super.toString();
    }
}
