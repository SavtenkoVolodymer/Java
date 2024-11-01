package Task5;
import java.util.Objects;

public class Pair<T, V> {
    private T first;
    private V second;

    public Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }
    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    // Метод для порівняння двох пар
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    public int hashCode() {
        return Objects.hash(first, second);
    }


    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}