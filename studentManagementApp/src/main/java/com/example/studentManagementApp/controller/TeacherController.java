package com.example.studentManagementApp.controller;


import com.example.studentManagementApp.exception.TeacherExistException;
import com.example.studentManagementApp.model.Teacher;
import com.example.studentManagementApp.service.TeacherService;
//import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/teacher")
@Slf4j
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    //Logs

    Logger logger= LoggerFactory.getLogger(TeacherController.class);

    @PostMapping
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){
        try{
            logger.info("Teacher input Received{}", teacher);

                /*
 Different level of logs
            logger.trace("trace log");
            logger.debug("debug log");
            logger.info("info log");
            logger.warn("warn log");
            logger.error("error log");
*/


            String response= teacherService.addTeacher(teacher);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (TeacherExistException e){
            logger.error("Exception while adding teacher{}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
