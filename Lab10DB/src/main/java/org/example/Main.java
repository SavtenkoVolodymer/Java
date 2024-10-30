package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Make your choice");
        Scanner scanner = new Scanner(System.in);
        HashRecorder recorder = new HashRecorder();
        int choice = 10;
        while (choice != 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\Java\\Lab10DB\\target\\classes\\Choices"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            choice = new Scanner(System.in).nextInt();


            switch (choice) {
                case 1: {
                    System.out.println("Enter the id of Service: ");
                    String id = scanner.nextLine();
                    System.out.println("Enter the creation date of Service: ");
                    String creation_date = scanner.nextLine();
                    System.out.println("Enter the status of Service: ");
                    String status = scanner.nextLine();
                    recorder.createService(id, creation_date, status);
                    break;
                }
                case 2: {
                    System.out.println("Enter the id of Client: ");
                    String id = scanner.nextLine();
                    System.out.println("Enter the name of Client: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter email of Client: ");
                    String email = scanner.nextLine();
                    recorder.createClient(id, name, email);
                    break;
                }
                case 3: {
                    System.out.println("Enter the id of Publication: ");
                    String id = scanner.nextLine();
                    System.out.println("Enter text for Publication: ");
                    String text = scanner.nextLine();
                    System.out.println("Enter topics of Publication: ");
                    String topics = scanner.nextLine();
                    recorder.createPublication(id, text, topics);
                    break;
                }
                case 4: {
                    System.out.println("Enter the code of Subscription: ");
                    String code = scanner.nextLine();
                    System.out.println("Enter keywords for Subscription: ");
                    String keywords = scanner.nextLine();
                    System.out.println("Enter the notification format for Subscription: ");
                    String notification_format = scanner.nextLine();
                    System.out.println("Enter the topics of Subscription: ");
                    String topic = scanner.nextLine();
                    recorder.createSubscription(code, keywords, notification_format, topic);
                    break;
                }
                case 5: {
                    System.out.println("Enter the key to read:");
                    String key = scanner.nextLine();
                    System.out.println(recorder.read(key));
                    break;
                }
                case 6: {
                    System.out.println("Enter the id of Client to update:");
                    String id = scanner.nextLine();
                    System.out.println("Enter the new name of Client:");
                    String name = scanner.nextLine();
                    System.out.println("Enter the new email of Client:");
                    String email = scanner.nextLine();
                    recorder.updateClient(id, name, email);
                    break;
                }
                case 7: {
                    System.out.println("Enter the code of Subscription to update:");
                    String code = scanner.nextLine();
                    System.out.println("Enter new keywords:");
                    String dateOfBirth = scanner.nextLine();
                    System.out.println("Enter new notification format:");
                    String notification_format = scanner.nextLine();
                    System.out.println("Enter new topics:");
                    String topics = scanner.nextLine();
                    recorder.updateSubscription(code, dateOfBirth, notification_format, topics);
                    break;
                }
                case 8: {
                    System.out.println("Enter the key to delete:");
                    String key = scanner.nextLine();
                    recorder.delete(key);
                    System.out.println("Deleted key: " + key);
                    break;
                }
                case 0: {
                    System.out.println("Exiting...");
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                }
            }

        }
    }
}