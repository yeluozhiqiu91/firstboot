package com.wang.service.impl;

import com.wang.mapper.BaseMapper;
import com.wang.model.BaseModel;
import com.wang.model.FailedModel;
import com.wang.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wang on 2018/1/9.
 */
@Service
public class BaseServiceImpl implements BaseService {
    private static int MISSION_COUNT = 0;
    private static int FAILED_MISSION_COUNT = 0;

    @Autowired
    BaseMapper mapper;//注解形式


    @Override
    public void addItem(BaseModel item) {
        mapper.insert(item);//注解形式
        if (item != null) {
            System.out.println("mission count: " + (++MISSION_COUNT) + "insert model" + item.toString());
        }
    }

    @Override
    public void insertFailed(FailedModel item) {
        mapper.insertFailed(item);//注解形式
        if (item != null) {
            System.out.println("FAILED_MISSION_COUNT : " + (++FAILED_MISSION_COUNT) + "insert model" + item.toString());
        }
    }

    @Override
    public List<Long> queryPageIds(String taskname) {
        return mapper.queryPageIds(taskname);
    }
}
