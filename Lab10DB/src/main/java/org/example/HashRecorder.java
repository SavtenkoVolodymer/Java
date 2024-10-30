package org.example;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class HashRecorder {
    private static final String host = "localhost";
    private static final int port = 6379;

    private final Jedis jedis;

    public HashRecorder() {
        jedis = new Jedis(host,port);
    }

    public void createService(String id , String creation_date , String status){
        Map<String, String> service = new HashMap<>();
        service.put("id", id);
        service.put("creation_date", creation_date);
        service.put("status", status);
        jedis.hset("service" + id, service);
    }

    public void createClient(String id , String name , String email) {
        Map<String, String> client = new HashMap<>();
        client.put("id", id);
        client.put("email", email);
        client.put("name", name);
        jedis.hset("client" +id,client);
    }

    public void createPublication(String id , String text , String topics) {
        Map<String, String> publication = new HashMap<>();
        publication.put("id", id);
        publication.put("text", text);
        publication.put("topics", topics);
        jedis.hset("publication" + id, publication);
    }

    public void createSubscription(String code, String keywords , String notofication_format,String topics ) {
        Map<String, String> subscription = new HashMap<>();
        subscription.put("keywords", keywords);
        subscription.put("notofication_forman", notofication_format);
        subscription.put("topics", topics);
        jedis.hset("subscription" + code, subscription);
    }

    public Map <String, String> read(String key) {
        return jedis.hgetAll(key);
    }

    public void updateClient(String id , String name , String email) {
        Map<String, String> client = new HashMap<>();
        client.put("email", email);
        client.put("name", name);
        jedis.hset("client" +id,client);
    }

    public void updateSubscription(String code, String keywords , String notofication_format,String topics ) {
        Map<String, String> subscription = new HashMap<>();
        subscription.put("keywords", keywords);
        subscription.put("notofication_format", notofication_format);
        subscription.put("topics", topics);
        jedis.hset("subscription" + code, subscription);
    }

    public void delete(String key) {
        jedis.del(key);
    }
}
