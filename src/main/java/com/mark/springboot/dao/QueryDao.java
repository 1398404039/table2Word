package com.mark.springboot.dao;


import com.mark.springboot.domain.TableFileds;
import com.mark.springboot.domain.Tables;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * desc 查询表数据
 *
 * @author Lixf
 * @since 2019/2/21 14:42
 **/
@Component
@Mapper
public interface QueryDao {

    /**
     * @return 某个库所有表名和注释 gateway_admin_stable为库名
     */
    @Select("select table_name as name,table_comment as comment from information_schema.tables where table_schema =#{dataName} order by table_name")
    List<Tables> getAllTables(@Param("dataName") String dataName);

    @Select("SHOW FULL FIELDS FROM ${tableName}")
    List<TableFileds> getTable(@Param("tableName") String tableName);


}
