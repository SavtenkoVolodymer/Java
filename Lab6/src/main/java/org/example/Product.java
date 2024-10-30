package org.example;

import lombok.Getter;
import java.util.concurrent.atomic.AtomicInteger;
@Getter
public class Product {

    private final String name;
    private final AtomicInteger quantity; // Атомарне значення для кількості товару

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = new AtomicInteger(quantity);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public boolean decreaseQuantity(int amount) {
        while (true) {
            int currentQty = quantity.get();
            if (currentQty >= amount) {
                if (quantity.compareAndSet(currentQty, currentQty - amount)) {
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    public void increaseQuantity(int amount) {
        quantity.getAndAdd(amount);
    }

    @Override
    public String toString() {
        return name + " (Quantity: " + quantity + ")";
    }
}
