package com.wang.service.impl;

import com.wang.mapper.ImportDrugsMapper;
import com.wang.model.ImportDrugs;
import com.wang.service.ImportDrugsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wangliujie
 * @Date: 2018/6/16 17:48
 */
@Service
public class ImportDrugsServiceImpl implements ImportDrugsService {
    @Autowired
    private ImportDrugsMapper importDrugsMapper;
    @Override
    public void addImportDrugs(ImportDrugs importDrugs) {
        importDrugsMapper.addImportDrugs(importDrugs);
    }
}
