package ls10.lab.dao.impl;

import ls10.lab.dao.Dao;
import ls10.lab.model.Customer;
import ls10.lab.util.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements Dao<Customer> {
    public CustomerDaoImpl() {
    }

    // CRUD: create-read-update-delete
    // Tim kiem
    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();

        // close automatic
        try (// Creat connection
             Connection connection = DatabaseUtils.getConnection();
             // create statement
             Statement statement= connection.createStatement();
             // execute query / update
             ResultSet resultSet = statement.executeQuery("SELECT * FROM customer") // SELECT
        ) {
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setPhoneNumber(resultSet.getString("phone"));
                customer.setAddress(resultSet.getString("address"));

                customers.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }

    @Override
    public int insert(Customer customer) {
        String sql = "INSERT INTO customer(name, address, phone) VALUES (?, ?, ?)";
        int rowCount = 0;

        // use try with resources
        try (
                //1&2 Regis driver class & get connection
                Connection connection = DatabaseUtils.getConnection();
                // 3. create statement
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getPhoneNumber());

            // 4 execute query
            rowCount = preparedStatement.executeUpdate(); // INSERT/ UPDATE/ DELETE
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return rowCount;
    }
}
