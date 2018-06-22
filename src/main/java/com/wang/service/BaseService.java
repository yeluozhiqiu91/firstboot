package com.wang.service;

import com.wang.model.BaseModel;

import java.util.List;

/**
 * @Date: 2018/6/16 17:46
 */
public interface BaseService {
    public void addItem(BaseModel item);

    public List<Long> queryPageIds();
}
