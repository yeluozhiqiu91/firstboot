package com.wang.service.impl;

import com.wang.mapper.BaseMapper;
import com.wang.mapper.HomeMadeInstrumentMapper;
import com.wang.model.BaseModel;
import com.wang.model.HomeMadeInstrument;
import com.wang.service.BaseService;
import com.wang.service.HomeMadeInstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wang on 2018/1/9.
 */
@Service
public class BaseServiceImpl implements BaseService {
    private static int MISSION_COUNT = 0;

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
    public List<Long> queryPageIds() {
        return mapper.queryPageIds();
    }
}
