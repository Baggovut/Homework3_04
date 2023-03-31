package jdbc.dao;

import jdbc.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOService implements EmployeeDAO{

    public EmployeeDAOService() {
    }

    private Connection getConnection() throws SQLException {
        final String user = "postgres";
        final String password = "1234321";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        return DriverManager.getConnection(url,user,password);
    }

    @Override
    public void add(Employee employee) {
        final String query = "INSERT INTO employee (first_name, last_name, gender, age) " +
                "VALUES (?,?,?,?);";

        try (final Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,employee.getFirst_name());
            statement.setString(2,employee.getLast_name());
            statement.setString(3,employee.getGender());
            statement.setInt(4,employee.getAge());
            statement.execute();

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }

    }

    @Override
    public Employee findById(int id) {
        final String query = "SELECT * FROM employee WHERE id = ?";
        Employee employee = null;

        try (final Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                employee = new Employee(
                            resultSet.getInt("id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getInt("age"),
                            resultSet.getString("gender"),
                            resultSet.getInt("city_id")
                );

            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        final String query = "SELECT * FROM employee";
        List<Employee> employeeList1 = new ArrayList<>();

        try (final Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                employeeList1.add(new Employee(
                            resultSet.getInt("id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getInt("age"),
                            resultSet.getString("gender"),
                            resultSet.getInt("city_id")
                            )
                );

            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
        return employeeList1;
    }

    @Override
    public void changeById(int id, Employee employee) {
        final String query =
                "UPDATE employee " +
                "SET (first_name, last_name, gender, age) = (?, ?, ?, ?) " +
                "WHERE id = ?;";

        try (final Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,employee.getFirst_name());
            statement.setString(2,employee.getLast_name());
            statement.setString(3,employee.getGender());
            statement.setInt(4,employee.getAge());
            statement.setInt(5,id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        final String query = "DELETE FROM employee WHERE id = ?;";
        try (final Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1,id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
    }
}
