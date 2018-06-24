package com.wang.service;

import com.wang.model.BaseModel;
import com.wang.model.FailedModel;

import java.util.List;

/**
 * @Date: 2018/6/16 17:46
 */
public interface BaseService {
    public void addItem(BaseModel item);
    public void insertFailed(FailedModel item);

    public List<Long> queryPageIds(String taskname);
}
