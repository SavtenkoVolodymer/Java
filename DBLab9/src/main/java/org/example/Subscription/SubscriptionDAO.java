package org.example.Subscription;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.Client.ClientDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubscriptionDAO {
    List<SubscriptionDTO> subscriptions = new ArrayList<SubscriptionDTO>();

    public void setSubscription() {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("Lab8");
            MongoCollection<Document> collection = database.getCollection("Client");


        }
    }
}
