package com.wang.mapper;

import com.wang.model.BaseModel;
import com.wang.model.HomeMadeHealthyDrug;
import com.wang.model.HomeMadeInstrument;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeMadeHealthDrugMapper {
    public void insert(@Param("item") HomeMadeHealthyDrug item);

    public List<Long> queryPageIds();
}
