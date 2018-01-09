package com.wang.controller;

import com.wang.model.Student;
import com.wang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wang on 2018/1/9.
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/addStudent")
    @ResponseBody
    public String addStudent(){
        Student student=new Student();
        student.setName("test");
        student.setAge(20);
        studentService.addStudent(student);
        return "添加学生成功！";
    }
}
