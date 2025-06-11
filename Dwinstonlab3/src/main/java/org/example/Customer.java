package org.example;

/** Project: Lab 3 - Java + MySQL + MongoDB CRUD
 * Purpose Details: Java representation of a customer entity
 * Course: IST 242
 * Author: Dontae Winston
 * Date Developed: 06/10/2025
 * Last Date Changed: 06/10/2025
 * Rev: 1
 */

public class Customer {
    private int id;
    private String firstname;
    private String lastname;
    private String streetaddress;
    private String age;
    private String email;
    private String creditcard;

    public Customer(int id, String firstname, String lastname, String streetaddress, String age, String email, String creditcard) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.streetaddress = streetaddress;
        this.age = age;
        this.email = email;
        this.creditcard = creditcard;
    }

    public int getId() { return id; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getStreetaddress() { return streetaddress; }
    public String getAge() { return age; }
    public String getEmail() { return email; }
    public String getCreditcard() { return creditcard; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", streetaddress='" + streetaddress + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", creditcard='" + creditcard + '\'' +
                '}';
    }
}