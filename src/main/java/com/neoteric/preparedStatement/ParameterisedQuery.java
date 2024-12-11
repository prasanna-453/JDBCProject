package com.neoteric.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

    public class ParameterisedQuery {
        public static List<Employee> getEmployeesByDeptAndSalary(String dept, double salary) {
            String url = "jdbc:mysql://localhost:3307/sonar";
            String user = "sonar";
            String password = "sonar";

            List<Employee> employees = new ArrayList<>();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(url, user, password);

                String query = "SELECT * FROM sonar.employee WHERE dept = ? AND salary >= ?";

                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, dept);
                statement.setDouble(2, salary);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int managerId = resultSet.getInt("mid");

                    int employeeId = resultSet.getInt("empId");
                    String employeeName = resultSet.getString("empName");
                    double employeeSalary = resultSet.getDouble("salary");
                    String employeeDept = resultSet.getString("dept");
                    int projectId = resultSet.getInt("projectId");

                    Employee employee = new Employee();
                    employee.setId(employeeId);
                    employee.setName(employeeName);
                    employee.setSalary(employeeSalary);
                    employee.setDept(employeeDept);
                    employee.setPid(projectId);
                    employee.setMid(managerId);

                    employees.add(employee);
                }

            } catch (Exception e) {
                System.out.println("Error occurred while connecting to the database or processing data.");
                e.printStackTrace();
            }

            return employees;
        }

        public static void main(String[] args) {
            List<Employee> employees = getEmployeesByDeptAndSalary("IT", 30000);

            System.out.println("Employees List:");
            for (Employee employee : employees) {
                System.out.println(employee.getName() + " (" + employee.getId() + ") " +
                        "Dept: " + employee.getDept() + " Salary: " + employee.getSalary());
            }
        }
    }



