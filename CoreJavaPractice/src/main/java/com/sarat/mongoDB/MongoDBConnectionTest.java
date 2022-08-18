/*package com.sarat.mongoDB;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.client.MongoClient;

public class MongoDBConnectionTest {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        Mongo mongo = new Mongo("localhost", 27017);
        DB database = mongoClient.getDB("myMongoDb");

        mongoClient.getDatabaseNames().forEach(System.out::println);
        database.createCollection("customers", null);

        DBCollection collection = database.getCollection("customers");
        BasicDBObject document = new BasicDBObject();
        document.put("name", "Sarat");
        document.put("company", "TR");
        collection.insert(document);

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "Sarat");
        DBCursor cursor = collection.find(searchQuery);

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }

        collection.remove(searchQuery);
    }
}
*/