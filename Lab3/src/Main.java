import java.util.*;
import Task1.*;
import Task2.*;
import Task3.*;
import Task4.*;
import Task5.*;
import Task6.*;
import Task7.*;
import Task8.*;



public class Main {
    public static void shtrix(){
        System.out.println("----------------------------");
    }
    public static void task1() {
        StudentRegistry registry = new StudentRegistry();

        Student student1 = new Student(1, "Ivan", "Petrov", "Computer science", 3);
        Student student2 = new Student(2, "Maria", "Ivanova", "Philology", 4);
        Student student3 = new Student(3, "Anton", "Ivanov", "Philology", 2);
        registry.addStudent(student1);
        registry.addStudent(student2);
        registry.addStudent(student3);
        registry.printAllStudents();
        registry.removeStudent(3);
        registry.printAllStudents();

        Student foundStudent = registry.findStudentById(1);
        System.out.println(foundStudent);


    }

    public static void task2() {
        List<String> words = Arrays.asList("apple",
                "banana", "apple", "orange", "banana");

        Set<String> uniqueWords = UniqueElementsCounter.findUniqueElements(words);
        System.out.println("Unique words: " + uniqueWords);

        HashMap<String, Integer> wordCounts = UniqueElementsCounter.countOccurrences(words);
        System.out.println("Word counts: " + wordCounts);


    }

    public static void task3() {
        Box<String> stringBox = new Box<>();
        stringBox.add("Maria");
        stringBox.add("Ivanova");
        stringBox.add("Anton");
        String removedItem = stringBox.remove(1);

        Box<Integer> intBox = new Box<>();
        intBox.add(12);
        intBox.add(52);
        intBox.add(42);
        intBox.printAll();
        Integer removeItem = intBox.remove(0);

        System.out.println(stringBox.get(0));
        System.out.println(intBox.get(1));
        System.out.println("Deleted: " + removedItem);
        System.out.println("Deleted: " + removeItem);
    }

    public static void task4() {
        Integer[] intArray = {3, 7, 2, 9, 5};
        Double[] doubleArray = {3.14, 1.57, 2.71};
        Character[] charArray = {'c', 'a', 'z'};
        String[] stringArray = {"apple", "banana", "cherry"};
        System.out.println("Max number: " + FindMax.findMax(intArray));
        System.out.println("Max double number: " + FindMax.findMax(doubleArray));
        System.out.println("Max symbols: " + FindMax.findMax(charArray));
        System.out.println("Max words: " + FindMax.findMax(stringArray));
    }

    public static void task5() {
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<String, List<Integer>> pair2 = new Pair<>("Numbers", List.of(1, 2, 3));

        System.out.println(pair1);
        System.out.println(pair2);

        // Порівняння двох пар
        Pair<Integer, String> pair3 = new Pair<>(1, "One");
        System.out.println(pair1.equals(pair3));
    }



    public static double calculateTotalArea(List<? extends Shape> shapes) {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.getArea();
        }
        return area;
    }
    public static void task6() {
        Circle circle = new Circle(1);
        Rectangle rectangle = new  Rectangle(3, 3);
        Circle c = new Circle(10);
        System.out.println(circle.getArea()+ " " + rectangle.getArea()+ " " + c.getArea());
        List<Shape>shapes = new ArrayList<>();

        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(c);

        System.out.println(calculateTotalArea(shapes));
    }

    public static void task7() {
        WildcardExample.main(new String[0]);
    }

    public static void task8() {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Labrador labrador = new Labrador();

        AnimalShelter shelter = new AnimalShelter();
        shelter.addAnimals(dog);
        shelter.addAnimals(cat);
        shelter.addAnimals(labrador);


        shelter.printAnimalSounds();
    }


    public static void main(String[] args) {
        task1();
        shtrix();
        task2();
        shtrix();
        task3();
        shtrix();
        task4();
        shtrix();
        task5();
        shtrix();
        task6();
        shtrix();
        task7();
        shtrix();
        task8();
    }
}

