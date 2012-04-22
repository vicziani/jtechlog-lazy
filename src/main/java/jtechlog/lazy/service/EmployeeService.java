package jtechlog.lazy.service;

import java.util.List;

public interface EmployeeService {

    public List<Employee> listEmployees();

    public Employee findEmployeeById(long id);

    void mergeEmployee(Employee employee);
}
