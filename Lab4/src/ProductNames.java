
import java.util.stream.Collectors;
import java.util.*;

public class ProductNames {
    public static List<String> getUppercaseProductNames(Map<Integer, Optional<String>> products) {
        return products.values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}