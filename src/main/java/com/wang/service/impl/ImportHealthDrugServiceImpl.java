package com.wang.service.impl;

import com.wang.mapper.ImportHealthDrugMapper;
import com.wang.model.ImportHealthyDrug;
import com.wang.service.ImportHealthDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wang on 2018/1/9.
 */
@Service
public class ImportHealthDrugServiceImpl implements ImportHealthDrugService {
    @Autowired
    ImportHealthDrugMapper mapper;//注解形式

    @Override
    public void addItem(ImportHealthyDrug item) {
        mapper.insert(item);//注解形式
    }
}
