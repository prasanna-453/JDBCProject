package com.neoteric.jpa.entity;

import java.util.List;

public class JPATest {

    public static void main(String[]args){

        EmpService empService=new EmpService();
        List<ProjectEntity> projectEntityList =empService.projectEntityList();

        for (int i=0;i<=projectEntityList.size();i++){

            System.out.println(projectEntityList);
        }



    }
}
