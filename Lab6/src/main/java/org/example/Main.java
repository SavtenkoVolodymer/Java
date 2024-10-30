package org.example;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Store store = new Store();
        Cart user1Cart = new Cart();
        Cart user2Cart = new Cart();

        Thread user1 = new Thread(() -> {
            try {
                store.simulateDelay();
                store.addToCart(user1Cart, "Product1", 3);
                store.removeFromCart(user1Cart, "Product1", 1);
                System.out.println("User1 Cart: " + user1Cart);
            } catch (InterruptedException e) {
                System.out.println("User1 was interrupted.");
            }
        }, "User1");


        Thread user2 = new Thread(() -> {
            try {
                store.simulateDelay();
                store.addToCart(user2Cart, "Product2", 5);
                System.out.println("User2 Cart: " + user2Cart.toString());
            } catch (InterruptedException e) {
                System.out.println("User2 was interrupted.");
            }
        }, "User2");


        Thread user3 = new Thread(() -> {
            try {
                store.simulateDelay();
                store.addToCart(user2Cart, "Product3", 2);
                System.out.println("User3 Cart: " + user2Cart.toString());
            } catch (InterruptedException e) {
                System.out.println("User3 was interrupted.");
            }
        }, "User3");

        user1.start();
        user2.start();
        user3.start();

        // Очікування завершення потоків
        user1.join();
        user2.join();
        user3.join();


        System.out.println("Final inventory:");
        store.printInventory();
    }
}