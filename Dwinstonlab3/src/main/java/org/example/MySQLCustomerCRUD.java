/** Project: Lab 3 - Java + MySQL + MongoDB CRUD
 * Purpose Details: Handle MySQL operations for Customer
 * Course: IST 242
 * Author: Dontae Winston
 * Date Developed: 06/10/2025
 * Last Date Changed: 06/10/2025
 * Rev: 1
 */

package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCustomerCRUD {
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/store";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "IST888IST888";

    public void insertCustomer(Customer c) {
        String sql = "INSERT INTO customers (id, firstname, lastname, streetaddress, age, email, creditcard) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, c.getId());
            stmt.setString(2, c.getFirstname());
            stmt.setString(3, c.getLastname());
            stmt.setString(4, c.getStreetaddress());
            stmt.setString(5, c.getAge());
            stmt.setString(6, c.getEmail());
            stmt.setString(7, c.getCreditcard());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> readCustomers() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Customer(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("streetaddress"),
                        rs.getString("age"),
                        rs.getString("email"),
                        rs.getString("creditcard")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateCustomerFirstName(int id, String newFirstName) {
        String sql = "UPDATE customers SET firstname = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newFirstName);
            stmt.setInt(2, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
