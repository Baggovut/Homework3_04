package jdbc.dao;

import jdbc.Employee;

import java.util.List;

public interface EmployeeDAO {
    void add(Employee employee);
    Employee findById(int id);
    List<Employee> getAllEmployee();
    void changeById(int id, Employee employee);
    void deleteById(int id);
}
