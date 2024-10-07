package Task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentRegistry {
    private Map<Integer, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void removeStudent(int id) {
        students.remove(id);
    }

    public Student findStudentById(int id) {
        return students.get(id);
    }

    public void printAllStudents() {
        Set<Integer> keys = students.keySet();
        for (int key : keys) {
            Student student = students.get(key);
            System.out.println(student);
        }
    }
}