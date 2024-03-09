package com.nextstep.roshanwebapp.controller;

import com.nextstep.roshanwebapp.model.Student;
import com.nextstep.roshanwebapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping("/home")
    public ModelAndView showHomePage(){
        ModelAndView modelAndView=new ModelAndView("NavBar");
        return  modelAndView;
    }

    @RequestMapping("/signin")
    public  ModelAndView showSigninPage(){
        ModelAndView modelAndView=new ModelAndView("Signin");
        return  modelAndView;
    }
    @RequestMapping("/save")
    public ModelAndView saveStudent(@ModelAttribute Student student){
    studentService.saveStudent(student);
        ModelAndView modelAndView =new ModelAndView("StudentDetails");
        List<Student> studentList= studentService.viewStudent();
        modelAndView.addObject("student",studentList);
        return  modelAndView;
    }

    @RequestMapping("/studentDetail")
    public  ModelAndView viewStudent(){
        ModelAndView modelAndView=new ModelAndView("StudentDetails");
        List<Student> studentList= studentService.viewStudent();
        modelAndView.addObject("student",studentList);
        return  modelAndView;
}
}
