package org.example;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.*;

public class Store {
    private final ConcurrentHashMap<String, Product> inventory = new ConcurrentHashMap<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmptyCondition = lock.newCondition();
    private final Semaphore cartSemaphore = new Semaphore(2); // Обмеження одночасного доступу до 2 потоків

    public Store() {
        inventory.put("Product1", new Product("Product1", 10));
        inventory.put("Product2", new Product("Product2", 20));
        inventory.put("Product3", new Product("Product3", 15));
    }

    public void addToCart(Cart cart, String productName, int amount) throws InterruptedException {
        cartSemaphore.acquire(); // Обмежуємо кількість одночасних доступів до кошиків
        lock.lock();
        try {
            Product product = inventory.get(productName);
            while (product != null && product.getQuantity() < amount) {
                System.out.println(Thread.currentThread().getName() + " is waiting for stock of " + productName);
                notEmptyCondition.wait(); // Очікування, поки товар з'явиться на складі
            }
            if (product != null && product.decreaseQuantity(amount)) {
                cart.addProduct(product, amount);
                System.out.println(Thread.currentThread().getName() + " added " + amount + " of " + productName + " to cart.");
            }
        } finally {
            lock.unlock();
            cartSemaphore.release();
        }
    }

    public void removeFromCart(Cart cart, String productName, int amount) throws InterruptedException {
        cartSemaphore.acquire();
        lock.lock();
        try {
            Product product = inventory.get(productName);
            if (product != null) {
                cart.removeProduct(product, amount);
                product.increaseQuantity(amount);
                notEmptyCondition.signalAll();
                System.out.println(Thread.currentThread().getName() + " removed " + amount + " of " + productName + " from cart.");
            }
        } finally {
            lock.unlock();
            cartSemaphore.release();
        }
    }

    public void printInventory() {
        lock.lock();
        try {
            inventory.forEach((name, product) -> System.out.println(product.toString()));
        } finally {
            lock.unlock();
        }
    }

    public void simulateDelay() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " is simulating a delay...");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " resumed.");
    }
}
