package com.wang.service.impl;

import com.wang.mapper.StudentMapper;
import com.wang.mapper.StudentMapperNew;
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
    StudentMapper studentMapper;//xml形式
    @Autowired
    StudentMapperNew studentMapperNew;//注解形式
    @Override
    public void addStudent(Student student) {
        //studentMapper.insert(student);//xml形式
        studentMapperNew.insert(student);//注解形式
    }
}
