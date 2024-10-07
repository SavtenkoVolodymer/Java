import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void shtrix(){
        System.out.println("----------------------------");
    }
    //------------------------------------------------------------------
    public static Optional<String> findFirst(List<String> strings) {
        return strings.stream().filter(str -> str.startsWith("X") && str.length() > 5).findFirst();

    }
    public static void task1(){
        List<String> myList = List.of("Hello","World","Xylophone","BMW");
        Optional<String> result = findFirst(myList);
        if (result.isPresent()) {
            System.out.println("String found: " + result.get());
        } else {
            System.out.println("String not found. Return 'Default'.");
        }
    }
    //--------------------------------------------------------------------
    public static List<Integer> flattenOptionalList(List<Optional<Integer>> optionalList){
        return optionalList.stream().filter(Optional::isPresent).map(Optional::get)
                .collect(Collectors.toList());
    }
    public static void task2(){
        List<Optional<Integer>> optionalList = Arrays.asList(
                Optional.of(1),
                Optional.empty(),
                Optional.of(4),
                Optional.empty()
        );

        List<Integer> flattenedList = flattenOptionalList(optionalList);
        System.out.println(flattenedList);
    }
    //--------------------------------------------------------------------
    public static Optional<String> findLongestName(List<String> names) {
        return names.stream().max(String::compareToIgnoreCase);
    }

    public static void task3(){
        List<String> names = Arrays.asList("Vlad", "Volodymyr", "Anton", "Maria");
        Optional<String> longestName = findLongestName(names);

        if (longestName.isPresent()) {
            System.out.println("Longest name: " + longestName.get());
        } else {
            System.out.println("The list of names is empty.");
        }
    }
    //-------------------------------------------------------------------------
    public static void task4(){
        List<Employee> employees = List.of(
                new Employee("Volodymyr",3000),
                new Employee("Anton",4500),
                new Employee("Oleksandr",5000)
        );
        Map<String, Optional<Employee>> result = Employee.groupAndFindMaxSalary(employees);

        result.forEach((range, employeeOptional) -> {
            employeeOptional.ifPresent(employee -> {
                System.out.println("Range: " + range + ", The employee with the highest salary: " + employee.getName());
            });
        });
    }
    //-------------------------------------------------------------------------
    public static Optional<Integer> calculateOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 !=0)
                .reduce((product, number) -> product * number);
    }
    public static void task5(){
        List<Integer> numbers = List.of(1,3,4,5,6,7);
        Optional<Integer> product = calculateOddNumbers(numbers);
        product.ifPresent(result -> System.out.println("Product of odd numbers: " + result));
    }
    //------------------------------------------------------------------------------
    public static void task6(){
        Person person1 = new Person("Vlad");
        Person person2 = new Person("Anton");
        Person person3 = new Person("Oleksandr");
        Person person4 = new Person("Maria");

        person1.addFriend(person2);
        person1.addFriend(person3);
        person2.addFriend(person1);
        person2.addFriend(person4);
        person3.addFriend(person1);

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        Set<String> uniqueFriendsNames = Person.getUniqueFriendsNames(people);
        System.out.println(uniqueFriendsNames);
    }
    //-----------------------------------------------------------------------------------
    public static void task7(){
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(100, "Food"));
        transactions.add(new Transaction(50,  "Clothing"));
        transactions.add(new Transaction(150,  "Entertainment"));

        Map<String, Double> sumsByCategory = Transaction.sumTransactionsByCategory(transactions);
        System.out.println(sumsByCategory);
    }
    //------------------------------------------------------------------------------------
    public static void task8 (){
        List<Product> products = new ArrayList<>();
        products.add(new Product("phone", 500.0));
        products.add(new Product("book", 20.0));
        products.add(new Product("computer", 1000.0));

        Optional<String>  secondMostExpensive = Product.findSecondMostExpensive(products);

        if (secondMostExpensive.isPresent()) {
            System.out.println("The second most expensive product: " + secondMostExpensive.get());
        } else {
            System.out.println("There are not enough products.");
        }
    }
    //---------------------------------------------------------------------------------------------
    public static void task9(){
        Map<Integer, Optional<String>> products = new HashMap<>();
        products.put(1, Optional.of("apple"));
        products.put(2, Optional.empty());
        products.put(3, Optional.of("banana"));
        products.put(4, Optional.empty());
        List<String> uppercaseNames = ProductNames.getUppercaseProductNames(products);
        System.out.println(uppercaseNames);
    }
    //-----------------------------------------------------------------------------------------------
    public static void task10(){
        Map<String, List<Integer>> cities = new HashMap<>();
        cities.put("Bila Tserkva", List.of(20, 22, 18));
        cities.put("Lviv", List.of(18, 20, 21));
        cities.put("Odesa", List.of(25, 24, 26));

        Optional<String> hottestCity = TemperatureStats.findCity(cities);
        if (hottestCity.isPresent()) {
            System.out.println("The city with the highest average temperature: " + hottestCity.get());
        } else {
            System.out.println("No temperature data available");
        }
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
        shtrix();
        task9();
        shtrix();
        task10();
    }
}