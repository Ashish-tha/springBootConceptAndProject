package com.example.studentManagementApp.exception;

public class StudentExistException extends RuntimeException {
    public StudentExistException(String message){
        super(message);
    }
}
