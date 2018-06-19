package com.wang.service;

import com.wang.model.ImportHealthyDrug;

import java.util.List;

/**
 * Created by wang on 2018/1/9.
 */
public interface ImportHealthDrugService {
    public void addItem(ImportHealthyDrug item);
    public List<Long> queryPageIds();
}
