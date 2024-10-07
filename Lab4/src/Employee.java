import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public static Map<String, Optional<Employee>> groupAndFindMaxSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        employee -> {
                            if (employee.salary < 3000) {
                                return "< 3000";
                            } else if (employee.salary <= 5000) {
                                return "3000-5000";
                            } else {
                                return "> 5000";
                            }
                        },
                        Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))
                ));
    }
}
