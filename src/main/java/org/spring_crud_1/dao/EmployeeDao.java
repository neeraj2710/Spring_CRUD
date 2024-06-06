package org.spring_crud_1.dao;

import org.spring_crud_1.bean.Employee;

import java.util.List;

public interface EmployeeDao {
    void save(Employee e);
    Employee findById(Integer id);
    void update(Employee e);
    void delete(Employee e);
    List<Employee> getAllRecords();
}
