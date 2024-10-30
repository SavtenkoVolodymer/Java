package org.example;
import java.util.concurrent.*;

class Cart {
    private final ConcurrentHashMap<String, Integer> cartItems = new ConcurrentHashMap<>();

    public void addProduct(Product product, int amount) {
        cartItems.merge(product.getName(), amount, Integer::sum);
    }

    public void removeProduct(Product product, int amount) {
        cartItems.merge(product.getName(), -amount, (oldValue, newValue) -> Math.max(oldValue + newValue, 0));
    }

    public ConcurrentHashMap<String, Integer> getItems() {
        return cartItems;
    }

    @Override
    public String toString() {
        return "Cart Items: " + cartItems.toString();
    }
}