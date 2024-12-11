package com.neoteric.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "sonar", name = "employee")
public class EmployeeEntity {

    @Id
    @Column(name = "empId")
    private int empId;

    @Column(name = "empName")
    private String empName;

    @Column(name = "salary")
    private String salary;

    @Column(name = "dept")
    private String dept;

    @ManyToOne
    @JoinColumn(name = "projectId", referencedColumnName = "projectId")
    private ProjectEntity projectEntity;

    @Column(name = "mid")
    private String mid;

    // Default constructor
    public EmployeeEntity() {
    }

    // Getters and Setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public ProjectEntity getProjectEntity() {
        return projectEntity;
    }

    public void setProjectEntity(ProjectEntity projectEntity) {
        this.projectEntity = projectEntity;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", salary='" + salary + '\'' +
                ", dept='" + dept + '\'' +
                ", mid='" + mid + '\'' +
                '}';
    }
}
