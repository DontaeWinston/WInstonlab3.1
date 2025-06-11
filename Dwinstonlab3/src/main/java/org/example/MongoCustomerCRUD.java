/** Project: Lab 3 - Java + MySQL + MongoDB CRUD
 * Purpose Details: Handle MongoDB operations for Customer
 * Course: IST 242
 * Author: Dontae Winston
 * Date Developed: 06/10/2025
 * Last Date Changed: 06/10/2025
 * Rev: 1
 */

package org.example;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoCustomerCRUD {
    private final MongoCollection<Document> collection;

    public MongoCustomerCRUD() {
        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = client.getDatabase("store");
        this.collection = database.getCollection("customers");
    }

    public void insertCustomer(Customer c) {
        Document doc = new Document("id", c.getId())
                .append("firstname", c.getFirstname())
                .append("lastname", c.getLastname())
                .append("streetaddress", c.getStreetaddress())
                .append("age", c.getAge())
                .append("email", c.getEmail())
                .append("creditcard", c.getCreditcard());
        collection.insertOne(doc);
    }

    public List<Document> readCustomers() {
        List<Document> results = new ArrayList<>();
        FindIterable<Document> docs = collection.find();
        for (Document doc : docs) {
            System.out.println(doc.toJson());
            results.add(doc);
        }
        return results;
    }

    public void updateCustomerFirstName(String oldFirstName, String newFirstName) {
        Document filter = new Document("firstname", oldFirstName);
        Document update = new Document("$set", new Document("firstname", newFirstName));
        collection.updateOne(filter, update);
    }

    public void deleteCustomer(String firstName) {
        Document filter = new Document("firstname", firstName);
        collection.deleteOne(filter);
    }
}
