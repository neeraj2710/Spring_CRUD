package org.spring_crud_1.controller;

import org.spring_crud_1.bean.Employee;
import org.spring_crud_1.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/save")
    public String saveRecord(){
        Employee e = new Employee("Raju","Legal","Mumbai");
        employeeDao.save(e);
        return "record inserted successfully id is:"+e.getEmpid();
    }

    @GetMapping("/find")
    public String findEmp(){
        return employeeDao.findById(1).toString();
    }

    @GetMapping("/update")
    public String updateRecord(){
        Employee emp = employeeDao.findById(2);
        emp.setName("Payal");
        employeeDao.update(emp);
        return emp.toString();
    }

    @GetMapping("delete")
    public String deleteRecord(){
        Employee emp = employeeDao.findById(2);
        employeeDao.delete(emp);
        return "Record Deleted";
    }

    @GetMapping("/allRecords")
    public String getAllRecords(){
        List<Employee> empList = employeeDao.getAllRecords();
        return empList.toString();
    }

}
