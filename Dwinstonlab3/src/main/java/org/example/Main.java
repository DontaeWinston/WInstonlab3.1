package org.example;

/** Project: Lab 3 - Java + MySQL + MongoDB CRUD
 * Purpose Details: Main class to run MySQL and MongoDB CRUD operations
 * Course: IST 242
 * Author: Dontae Winston
 * Date Developed: 06/10/2025
 * Last Date Changed: 06/10/2025
 * Rev: 1
 */

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer(1, "Dontae", "Winston", "123 Market St", "33", "dontaewinston1222@gmail.com", "4111111111111111");
        Customer c2 = new Customer(2, "Janay", "Smith", "456 Chestnut Ave", "30", "janaysmith@example.com", "5500000000000004");
        Customer c3 = new Customer(3, "Nova", "Winston", "789 Walnut Blvd", "19", "novawinston@example.com", "340000000000009");

        MySQLCustomerCRUD mysql = new MySQLCustomerCRUD();
        MongoCustomerCRUD mongo = new MongoCustomerCRUD();

        // MySQL operations
        System.out.println("\n--- MySQL CRUD ---");
        mysql.insertCustomer(c1);
        mysql.insertCustomer(c2);
        mysql.insertCustomer(c3);
        mysql.readCustomers().forEach(System.out::println);
        mysql.updateCustomerFirstName(2, "Janaya");
        mysql.readCustomers().forEach(System.out::println);
        mysql.deleteCustomer(3);
        mysql.readCustomers().forEach(System.out::println);

        // MongoDB operations
        System.out.println("\n--- MongoDB CRUD ---");
        mongo.insertCustomer(c1);
        mongo.insertCustomer(c2);
        mongo.insertCustomer(c3);
        mongo.readCustomers();
        mongo.updateCustomerFirstName("Janay", "Janaya");
        mongo.readCustomers();
        mongo.deleteCustomer("Nova");
        mongo.readCustomers();
    }
}
