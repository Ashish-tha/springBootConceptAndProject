package com.example.studentManagementApp.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher {
    int id;
    String name;
    String course;
    int salary;

    public Integer getId() {
        return id;
    }

//    @Override
//    public String toString() {
//        return "Teacher{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", course='" + course + '\'' +
//                ", salary=" + salary +
//                '}';
//    }
}
