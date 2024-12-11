package com.neoteric.jpa.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

public class EmpService {

    public List<ProjectEntity> projectEntityList() {
        // Create EntityManagerFactory and EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Start transaction
        entityManager.getTransaction().begin();

        // Query to fetch ProjectEntity and associated EmployeeEntity (join on employeeEntityList)
        Query query = entityManager.createQuery("select p from ProjectEntity p join p.employeeEntityList e where e.projectEntity.id = p.id");

        // Execute query and get result list
        List<ProjectEntity> projectEntities = query.getResultList();

        // Commit the transaction
        entityManager.getTransaction().commit();

        // Close the EntityManager and EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();

        return projectEntities;
    }
}
