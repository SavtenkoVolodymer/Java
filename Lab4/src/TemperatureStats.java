import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.util.Optional;

public class TemperatureStats {
    public static Optional<String> findCity(Map<String, List<Integer>> cityTemperatures) {
        return cityTemperatures.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue(
                        Comparator.comparingDouble(temps -> temps.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0))
                ))
                .map(Map.Entry::getKey);
    }
}
