package jdbc;

import jdbc.dao.EmployeeDAOService;

import java.sql.*;

public class Application {
    public static void main(String[] args) {
        Application a1 = new Application();
        //Задание 1
        a1.getEmployeeInfoById(3);

        //Задание 2
        System.out.println("\nЗадание 2");

        EmployeeDAOService employeeDAOService1 = new EmployeeDAOService();
        System.out.println("\nСоздание (добавление) сущности Employee в таблицу.");
        Employee employee1 = new Employee("Имя1","Фамилия1",22,"муж.",2);
        employeeDAOService1.add(employee1);

        System.out.println("\nПолучение конкретного объекта Employee по id.");
        Employee employee2 = employeeDAOService1.findById(3);
        System.out.println(employee2);

        System.out.println("\nПолучение списка всех объектов Employee из базы.");
        System.out.println(employeeDAOService1.getAllEmployee());

        System.out.println("\nИзменение конкретного объекта Employee в базе по id.");
        Employee employee3 = new Employee("Имя3","Фамилия3",32,"муж.",3);
        employeeDAOService1.changeById(10, employee3);
        System.out.println(employeeDAOService1.findById(10));

        System.out.println("\nУдаление конкретного объекта Employee из базы по id.");
        employeeDAOService1.deleteById(11);

    }
    public void getEmployeeInfoById(int id){
        final String user = "postgres";
        final String password = "1234321";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        final String query = "SELECT * FROM employee WHERE id = ?";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                System.out.println("ID работника: " + resultSet.getInt("id"));
                System.out.println("Имя работника: " + resultSet.getString("first_name"));
                System.out.println("Фамилия работника: " + resultSet.getString("last_name"));
                System.out.println("Пол работника: " + resultSet.getString("gender"));
                System.out.println("Возраст работника: " + resultSet.getInt("age"));
                System.out.println("ID города работника: " + resultSet.getInt("city_id"));
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }

    }
}