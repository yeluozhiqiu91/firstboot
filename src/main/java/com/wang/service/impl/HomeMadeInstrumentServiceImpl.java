package com.wang.service.impl;

import com.wang.mapper.HomeMadeInstrumentMapper;
import com.wang.model.HomeMadeHealthyDrug;
import com.wang.model.HomeMadeInstrument;
import com.wang.service.HomeMadeHealthService;
import com.wang.service.HomeMadeInstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wang on 2018/1/9.
 */
@Service
public class HomeMadeInstrumentServiceImpl implements HomeMadeInstrumentService {
    @Autowired
    HomeMadeInstrumentMapper mapper;//注解形式


    @Override
    public void addItem(HomeMadeInstrument item) {
        mapper.insert(item);//注解形式

    }
}
