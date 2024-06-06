package org.spring_crud_1.bean;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity //
@Table(name = "employee")
public class Employee {

    @Id //to define primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //will be generated and managed by the database
    @Column
    private int empid;

    @Column
    private String name;

    @Column
    private String department;

    @Column
    private String location;

    public Employee(String name, String department, String location) {
        this.name = name;
        this.department = department;
        this.location = location;
    }

    public Employee() {

    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empId) {
        this.empid = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empid +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
