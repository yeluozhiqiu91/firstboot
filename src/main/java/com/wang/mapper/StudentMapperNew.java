package com.wang.mapper;

import com.wang.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by wang on 2018/1/9.
 */
@Mapper
public interface StudentMapperNew {
    @Insert("INSERT INTO student(name,age) VALUES(#{student.name}, #{student.age})")
    public void insert(@Param("student") Student student);
}
