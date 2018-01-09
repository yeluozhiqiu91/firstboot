package com.wang.service.impl;

import com.wang.mapper.StudentMapper;
import com.wang.model.Student;
import com.wang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wang on 2018/1/9.
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentMapper studentMapper;
    @Override
    public void addStudent(Student student) {
        studentMapper.insert(student);
    }
}
