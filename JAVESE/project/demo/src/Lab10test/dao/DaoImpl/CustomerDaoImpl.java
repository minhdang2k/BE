package Lab10test.dao.DaoImpl;

import Lab10test.dao.CustomerDao;
import Lab10test.model.Customer;
import Lab10test.utils.DataBaseUltils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao<Customer> {
    public CustomerDaoImpl() {
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers= new ArrayList<>();
        try(
                Connection connection= DataBaseUltils.getConnection();
                Statement statement=connection.createStatement();
                ResultSet resultSet= statement.executeQuery("SELECT * from customer")
                ){
            while (resultSet.next()){
                Customer customer=new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setPhoneNumber(resultSet.getString("phone"));
                customer.setAddress(resultSet.getString("address"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public int insert(Customer customer) {
        String sql="INSERT INTO customer(name,phone,address) VALUES (?,?,?)";
        int rowCount= 0;
        try (
                Connection connection=DataBaseUltils.getConnection();
                PreparedStatement preparedStatement=connection.prepareStatement(sql);
                ){
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getPhoneNumber());
            preparedStatement.setString(3,customer.getAddress());
        }catch (Exception e){
            e.printStackTrace();
        }
        return rowCount;
    }
}
