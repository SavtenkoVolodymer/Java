package Task7;
import java.util.ArrayList;
import java.util.List;

public class WildcardExample {
    public static <T extends Number> void addToList(List<? super T> list) {
        for (int i = 1; i <= 10; i++) {
            list.add((T) Integer.valueOf(i));
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();

        addToList(intList);
        addToList(numberList);

        System.out.println("intList: " + intList);
        System.out.println("numberList: " + numberList);
    }
}
