package Task1;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String faculty;
    private int course;

    public Student(int id, String firstName, String lastName, String faculty, int course) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        this.course = course;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                '}';
    }
}