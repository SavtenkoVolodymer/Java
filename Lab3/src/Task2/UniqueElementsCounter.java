package Task2;
import java.util.*;


public class UniqueElementsCounter {

    public static <T> Set<T> findUniqueElements(List<T> list) {
        return new HashSet<>(list);
    }

    public static <T> HashMap<T, Integer> countOccurrences(List<T> list) {
        HashMap<T, Integer> map = new HashMap<>();
        for (T element : list) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        return map;
    }
}