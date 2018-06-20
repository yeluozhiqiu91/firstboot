package com.wang.service;

import com.wang.model.HomeMadeHealthyDrug;
import com.wang.model.HomeMadeInstrument;

import java.util.List;

/**
 * @Date: 2018/6/16 17:46
 */
public interface HomeMadeInstrumentService {
    public void addItem(HomeMadeInstrument item);
    public List<Long> queryPageIds();
}
