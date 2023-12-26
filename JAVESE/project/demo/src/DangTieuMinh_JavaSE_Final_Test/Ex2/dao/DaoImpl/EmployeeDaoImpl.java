package DangTieuMinh_JavaSE_Final_Test.Ex2.dao.DaoImpl;

import DangTieuMinh_JavaSE_Final_Test.Ex2.dao.Dao;
import DangTieuMinh_JavaSE_Final_Test.Ex2.model.Employee;
import DangTieuMinh_JavaSE_Final_Test.Ex2.utils.DatabaseUtils;
import Lab10test.utils.DataBaseUltils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements Dao<Employee> {
    public EmployeeDaoImpl() {
    }
    public List<Employee> findAll(){
        List<Employee> employees= new ArrayList<>();
        try(
                Connection connection= DataBaseUltils.getConnection();
                Statement statement=connection.createStatement();
                ResultSet resultSet= statement.executeQuery("SELECT * FROM employee")
                ){
            while (resultSet.next()){
                Employee employee= new Employee();
                employee.setMaNV(resultSet.getString("maNV"));
                employee.setHo_tenLot(resultSet.getString("ho_tenLot"));
                employee.setTen(resultSet.getString("ten"));
                employee.setNgaySinh(resultSet.getString("ngaysinh"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setLuong(resultSet.getInt("luong"));
                employees.add(employee);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return employees;
    }
    public int insert(Employee employee){
        String sql="INSERT INTO employee(maNv,ho_tenLot,ten,ngaysinh,email,phone,luong) VALUES (?,?,?,?,?,?,?)";
        int rowCount= 0;
        try(
                Connection connection= DatabaseUtils.getConnection();
                PreparedStatement preparedStatement= connection.prepareStatement(sql);
                ) {
            preparedStatement.setString(1,employee.getMaNV());
            preparedStatement.setString(2,employee.getHo_tenLot());
            preparedStatement.setString(3,employee.getTen());
            preparedStatement.setString(4,employee.getNgaySinh());
            preparedStatement.setString(5,employee.getEmail());
            preparedStatement.setString(6,employee.getPhone());
            preparedStatement.setInt(7,employee.getLuong());
            rowCount= preparedStatement.executeUpdate();
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return rowCount;
    }
}
