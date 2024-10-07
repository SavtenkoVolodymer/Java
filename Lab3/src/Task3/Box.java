package Task3;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> items;

    public Box() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public T remove(int index) {
        return items.remove(index);
    }

    public T get(int index) {
        return items.get(index);
    }

    public void printAll() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}