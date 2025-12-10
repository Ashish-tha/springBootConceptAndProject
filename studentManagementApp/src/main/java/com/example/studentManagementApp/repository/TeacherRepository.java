package com.example.studentManagementApp.repository;

import com.example.studentManagementApp.exception.TeacherExistException;
import com.example.studentManagementApp.model.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
@Slf4j
public class TeacherRepository {

    private static final Logger log = LoggerFactory.getLogger(TeacherRepository.class);
    HashMap<Integer,Teacher> teacherDb=new HashMap<>();

    public String addTeacher(Teacher teacher) {
        if(teacherDb.containsKey(teacher.getId())){
            throw new TeacherExistException("Id "+ teacher.getId()+ " Exist");
        }
        teacherDb.put(teacher.getId(),teacher);
        log.info("teacher with id"+teacher.getId()+ "added");
        return "Teacher added Sucessfully";
    }
}
