package com.wang.mapper;

import com.wang.model.BaseModel;
import com.wang.model.HomeMadeInstrument;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeMadeInstrumentMapper {
    public void insert(@Param("item") BaseModel item);

    public List<Long> queryPageIds();
}
