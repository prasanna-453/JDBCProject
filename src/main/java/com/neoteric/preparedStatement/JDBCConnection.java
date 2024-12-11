package com.neoteric.preparedStatement;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class JDBCConnection {

        public  static List<Project> getAllocationEmployees(){

            String url = "jdbc:mysql://localhost:3307/sonar";
            String user = "sonar";
            String password = "sonar";

            List<Project> projects = new ArrayList<>();
            Map<Integer, Project> projectMap = new HashMap<>();
            Map<Integer, Employee> employeeMap = new HashMap<>();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to the database!");

                String query =  "SELECT " +"e.empId AS EmployeeID,e.empName AS EmployeeName, e.projectid AS ProjectId, " + "e.salary, e.dept, " +
                        "m.empId AS ManagerID, m.empName AS ManagerName, " + "p.projectName AS ProjectName, p.startdate, p.enddate " +
                        "FROM sonar.Employee e " + "LEFT JOIN sonar.Employee m ON e.mid = m.id " +"INNER JOIN sonar.project p ON e.projectid = p.projectId";


                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {

                    System.out.println("Employee ID: " + resultSet.getInt("empId") +
                            ", Employee Name: " + resultSet.getString("empName") +
                            ",Employee Salary: " + resultSet.getString("salary")+
                            ", Project Name: " + resultSet.getString("projectName") +
                            ", Manager Name: " + resultSet.getString("managerName"));

                    int projectId = resultSet.getInt("projectId");
                    Project project = projectMap.getOrDefault(projectId, new Project());
                    if (!projectMap.containsKey(projectId)) {
                        project.setId(projectId);
                        project.setPname(resultSet.getString("projectName"));
                        project.setStartdate(resultSet.getDate("startdate").toLocalDate());
                        project.setEnddate(resultSet.getDate("enddate").toLocalDate());
                        project.setEmployeeList(new ArrayList<>());
                        projectMap.put(projectId, project);
                        projects.add(project);
                    }

                    // Fetch Employee details
//                    int employeeId = resultSet.getInt("empID");
//                    Employee employee = employeeMap.getOrDefault(employeeId, new Employee());
//                    if (!employeeMap.containsKey(employeeId)) {
//                        employee.setId(employeeId);
//                        employee.setName(resultSet.getString("empName"));
//                        employee.setSalary(resultSet.getDouble("salary"));
//                        employee.setDept(resultSet.getString("dept"));
//                        employee.setPid(projectId);
//                        employee.setEmployeeList(new ArrayList<>());
//                        employeeMap.put(employeeId, employee);
//                        project.getEmployeeList().add(employee); // Add employee to project
//                    }
//
//                    int managerId = resultSet.getInt("mid");
//                    if (managerId != 0) {
//                        Employee manager = employeeMap.getOrDefault(managerId, new Employee());
//                        if (!employeeMap.containsKey(managerId)) {
//                            manager.setId(managerId);
//                            manager.setName(resultSet.getString("managerName"));
//                            manager.setEmployeeList(new ArrayList<>());
//                            employeeMap.put(managerId, manager);
//                        }
//                        manager.getEmployeeList().add(employee);
//                        employee.setMid(managerId);
//                    }
                }
            } catch (Exception e) {
                System.out.println("Error occurred while connecting to the database or processing data.");
                e.printStackTrace();
            }
            return projects;
        }
    }

