package com.neoteric.preparedStatement;

import java.util.ArrayList;
import java.util.List;

    public class Employee {
        private int id;

        private int pid;
        private String name;
        private String dept;

        private  double salary;

        private  int mid;
        private List<Employee> employeeList;

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public List<Employee> getEmployeeList() {
            return employeeList;
        }

        public void setEmployeeList(List<Employee> employeeList) {
            this.employeeList = employeeList;
        }

        // Constructor
        public Employee() {
            this.employeeList = new ArrayList<>();
        }


        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "dept='" + dept + '\'' +
                    ", id=" + id +
                    ", pid=" + pid +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    ", mid=" + mid +
                    ", employeeList=" + employeeList +
                    '}';
        }
    }

