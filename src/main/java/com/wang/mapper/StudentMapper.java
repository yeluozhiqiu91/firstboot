package com.wang.mapper;

import com.wang.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by wang on 2018/1/9.
 */
@Repository
public interface StudentMapper {
    public void insert(@Param("student")Student student);
}
