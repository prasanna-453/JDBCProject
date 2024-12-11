package com.neoteric.preparedStatement;


import java.time.LocalDate;
import java.util.List;

    public class Project {
        private  int id;
        private  String pname;
        private LocalDate startdate;

        public LocalDate getStartdate() {
            return startdate;
        }

        public void setStartdate(LocalDate startdate) {
            this.startdate = startdate;
        }

        public LocalDate getEnddate() {
            return enddate;
        }

        public void setEnddate(LocalDate enddate) {
            this.enddate = enddate;
        }

        private  LocalDate enddate;

        public List<Employee> getEmployeeList() {
            return employeeList;
        }

        public void setEmployeeList(List<Employee> employeeList) {
            this.employeeList = employeeList;
        }

        private List<Employee> employeeList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;

        }

        public String getPname() {
            return pname;


        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        @Override
        public String toString() {
            return "Project{" +
                    "employeeList=" + employeeList +
                    ", id=" + id +
                    ", pname='" + pname + '\'' +
                    ", startdate=" + startdate +
                    ", enddate=" + enddate +
                    '}';
        }
    }

