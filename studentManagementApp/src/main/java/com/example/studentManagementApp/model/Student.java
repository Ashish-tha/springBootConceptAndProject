package com.example.studentManagementApp.model;

public class Student {
    private int id; // primary key
    private String name;
    private int marks;
    private int age;


//    Constructor...........
    public Student(){

    }

    public Student(int id,String name,int marks,int age){
        this.id=id;
        this.name=name;
        this.marks=marks;
        this.age=age;

    }


    //    Getters......
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getMarks(){
        return marks;
    }

    public int getAge(){
        return age;
    }

//    Setters......

    public void setId(int id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setMarks(int marks){
        this.marks=marks;
    }

    public void setAge(int age){
        this.age=age;
    }
}
