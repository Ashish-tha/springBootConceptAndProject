package com.example.studentManagementApp;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<Integer,Student> studentDb=new HashMap<>();

    public Student getStudentById(int id){
        if(!studentDb.containsKey(id)){
            return null;
        }
        return studentDb.get(id);
    }

    public String addStudent(Student student) {
        if(studentDb.containsKey(student.getId())){
            return "Student Already added";
        }
        studentDb.put(student.getId(),student);
        return "Student Added Successfully";
    }

    public String updateAge(int id, int age) {
        if(!studentDb.containsKey(id)){
            return "Invalid Id";
        }
        Student exixtingStudent=studentDb.get(id);
        exixtingStudent.setAge(age);
        studentDb.put(id,exixtingStudent);
        return "Age Updated Successfully";
    }

    public List<Student> getListOfStudents() {
        return new ArrayList<>(studentDb.values());
    }


    public String deleteStudent(int id) {
        if(!studentDb.containsKey(id)){
            return "Invalid Id";
        }
        studentDb.remove(id);
        return "Student Deleted Successfully";
    }
}
