package com.neoteric.jpa.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class JpaDemo {

    public static void main(String[] args) {


        String query = "SELECT m.empid AS ManagerId, m.name AS ManagerName, e.empid AS EmployeeId, e.name AS EmployeeName, e.salary, e.dept " +
                "FROM Employee e JOIN e.manager m";

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("employee");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        List<Object[]> employeeList = entityManager.createQuery(query).getResultList();


        if (!employeeList.isEmpty()) {
            System.out.println("employeeList : ");
            for (Object[] employee : employeeList) {

                System.out.println("ManagerId: " + employee[0] + ", ManagerName: " + employee[1] +
                        ", EmployeeId: " + employee[2] + ", EmployeeName: " + employee[3] +
                        ", Salary: " + employee[4] + ", Dept: " + employee[5]);
            }
        } else {
            System.out.println("Employees not found");
        }

        entityManager.getTransaction().commit();
        entityManagerFactory.close();
        entityManager.close();


    }
}