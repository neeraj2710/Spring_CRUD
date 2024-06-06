package org.spring_crud_1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.spring_crud_1.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository // it is a specialized annotation of component annotation
            // used to encapsulate logics required to access data sources
            // also used for exception translation(converting database specific exception into Spring DataException)
public class EmployeeDaoImpl implements EmployeeDao{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //used to manage transaction in spring
                   // it helps in data consistency and integrity
    public void save(Employee e) {
        entityManager.persist(e); // persist means to save
    }

    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    @Transactional
    public void update(Employee e) {
        entityManager.merge(e);
    }

    @Override
    @Transactional
    public void delete(Employee e) {
        entityManager.remove(e);
    }

    @Override
    public List<Employee> getAllRecords() {
        TypedQuery<Employee> tq = entityManager.createQuery("FROM Employee",Employee.class);
        List<Employee> empList = tq.getResultList();
        return empList;
    }
}
