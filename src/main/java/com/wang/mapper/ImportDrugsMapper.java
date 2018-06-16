package com.wang.mapper;

import com.wang.model.ImportDrugs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: wangliujie
 * @Date: 2018/6/16 17:48
 */
@Repository
public interface ImportDrugsMapper {
    void addImportDrugs(@Param("drug") ImportDrugs importDrugs);
}
