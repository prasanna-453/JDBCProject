package com.neoteric.connection.sql;

import java.sql.*;

public class InnerJoin {

    public static void main(String[] args) throws Exception {

    try {

//        String url="jdbc:mysql://localhost:3307/sonar";
//        String username="sonar";
//        String password="sonar";
//        String query="select * from sonar";

        Class.forName("com.mysql.cj.jdbc.Driver");


        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/sonar","sonar","sonar");
        System.out.println("Connected to the database successfully!");
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from sonar.employee e inner join sonar.project p where e.projectId=p.projectid");
        while(resultSet.next()) {

            String name = resultSet.getString("empName");
            int id = resultSet.getInt("empId");
            String dept = resultSet.getString("dept");
            String salary = resultSet.getString("salary");
            System.out.println(name);
            System.out.println(id);
            System.out.println(dept);
            System.out.println(salary);
        }



        connection.close();
    } catch (ClassNotFoundException e) {
        System.err.println("MySQL Driver not found: " + e.getMessage());
    } catch (SQLException e) {
        System.err.println("SQL Exception: " + e.getMessage());
    }
}
}
