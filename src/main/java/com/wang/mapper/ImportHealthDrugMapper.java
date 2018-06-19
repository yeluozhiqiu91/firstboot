package com.wang.mapper;

import com.wang.model.ImportHealthyDrug;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImportHealthDrugMapper {
    public void insert(@Param("item") ImportHealthyDrug item);
    public List<Long> queryPageIds();
}
