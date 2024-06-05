package org.spring_crud_1.controller;

import org.spring_crud_1.bean.Employee;
import org.spring_crud_1.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/")
    public String saveRecord(){
        Employee e = new Employee("Ajay","Finance","Mumbai");
        employeeDao.save(e);
        return "record inserted successfully id is:"+e.getEmpId();
    }

}
