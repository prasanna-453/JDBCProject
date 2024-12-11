package com.neoteric.preparedStatement;



import java.util.List;

    public class JDBCTest {
        public static void main(String[] args) {
            List<Employee> employees = SelfJoin.getEmployeeManagerHierarchy();
            for (Employee employee : employees){
                System.out.println(employee);
            }


        }

    }

