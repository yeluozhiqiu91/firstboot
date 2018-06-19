package com.wang.service.impl;

import com.wang.mapper.HomeMadeHealthDrugMapper;
import com.wang.model.HomeMadeHealthyDrug;
import com.wang.service.HomeMadeHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class HomeMadeHealthDrugServiceImpl implements HomeMadeHealthService {
    @Autowired
    HomeMadeHealthDrugMapper mapper;//注解形式

    @Override
    public void addItem(HomeMadeHealthyDrug item) {
        mapper.insert(item);//注解形式
    }
}
