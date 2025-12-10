package com.example.studentManagementApp.repository;

import com.example.studentManagementApp.exception.StudentExistException;
import com.example.studentManagementApp.exception.StudentNotFoundException;
import com.example.studentManagementApp.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<Integer, Student> studentDb=new HashMap<>();

    public Student getStudentById(int id){
        if(!studentDb.containsKey(id)){
            return null;
        }
        return studentDb.get(id);
    }

    public String addStudent(Student student) {
        if(studentDb.containsKey(student.getId())){
            throw new StudentExistException("Id "+ student.getId()+ " Exist");
        }
        studentDb.put(student.getId(),student);
        return "Student Added Successfully";
    }

    public String updateAge(int id, int age) {
        if(!studentDb.containsKey(id)){
           throw new StudentNotFoundException("Id "+ id+ " Not Found");
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
            throw new StudentNotFoundException("Id "+ id+ " Not Found");
        }
        studentDb.remove(id);
        return "Student Deleted Successfully";
    }
}
