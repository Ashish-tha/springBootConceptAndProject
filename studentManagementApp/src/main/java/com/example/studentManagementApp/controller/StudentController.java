package com.example.studentManagementApp.controller;

import com.example.studentManagementApp.exception.StudentExistException;
import com.example.studentManagementApp.exception.StudentNotFoundException;
import com.example.studentManagementApp.model.Student;
import com.example.studentManagementApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.SimpleTimeZone;

@RestController
@RequestMapping("/api/v1/student")

public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("/welcome")
    public String getWelcome() {
        return "Welcome Aashish Gaur";
    }

//    @GetMapping("/accio")
//    public String Accio (){
//        return "Accio";
//    }

    @GetMapping
    public ResponseEntity getStudentById(@RequestParam("id") int id){
       try{
           return new ResponseEntity(studentService.getStudentById(id),HttpStatus.OK);
       }
       catch (StudentNotFoundException e){
           return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
       }
    }


    @PostMapping
    public ResponseEntity addStudent(@RequestBody Student student){
       try{
           String response=studentService.addStudent(student);
           return new ResponseEntity(response,HttpStatus.CREATED);
       }
       catch (StudentExistException e){
           return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }
//
    @GetMapping("/{id}")
    public Student getStudentByIdPath(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }
//// Multiple Variable in the input using PathVariable........
    @PutMapping("/id/{id}/age/{age}")
    public ResponseEntity updateAge(@PathVariable("id")int id,
                            @PathVariable("age") int age){
       try{
           String response =studentService.updateAge(id,age);
           return new ResponseEntity<>(response,HttpStatus.CREATED);
       } catch (StudentNotFoundException e) {
           return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
       }


    }
//// Multiple Variable in the input using Request Param........
    @PutMapping
    public String updateAgeByReqParam(@RequestParam("id")int id,
                            @RequestParam("age") int age){
       return studentService.updateAge(id,age);
    }
// Get All List of Student
    @GetMapping("/all")
    public List<Student> getListOfStudents(){
        return studentService.getListOfStudents();
    }

//    Delete Student
    @DeleteMapping
    public ResponseEntity deleteStudent(@RequestParam("id") int id){
        try{
            String response= studentService.deleteStudent(id);
            return new ResponseEntity(response,HttpStatus.CREATED);
        }
        catch (StudentNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
