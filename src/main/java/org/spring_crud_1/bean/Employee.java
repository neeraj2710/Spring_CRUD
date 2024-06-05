package org.spring_crud_1.bean;

import jakarta.persistence.*;

@Entity //
@Table(name = "employee")
public class Employee {

    @Id //to define primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //will be generated and managed by the database
    @Column
    private int empId;

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

    public int getEmpId() {
        return empId;
    }
}
