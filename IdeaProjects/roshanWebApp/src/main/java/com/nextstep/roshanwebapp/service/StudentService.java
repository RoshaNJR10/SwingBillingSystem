package com.nextstep.roshanwebapp.service;

import com.nextstep.roshanwebapp.model.Student;

import java.util.List;

public interface StudentService {
    public  void saveStudent(Student student);
    public List<Student> viewStudent();
}
