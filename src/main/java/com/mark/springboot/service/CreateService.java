package com.mark.springboot.service;

import com.mark.springboot.dao.QueryDao;
import com.mark.springboot.domain.Tables;
import com.mark.springboot.util.DateToWordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * desc  调用的业务
 *
 * @author Lixf
 * @since 2019/2/21 16:25
 **/
@Service
public class CreateService {

    @Autowired
    QueryDao queryDao;

    @Autowired
    DateToWordUtil dateToWordUtil;

    /**
     * 获取数据
     */
    public void getTableInfo(String dataName, String filePath) {
        List<Tables> tables = queryDao.getAllTables(dataName);//库名
        dateToWordUtil.toWord(tables, filePath);
    }
}
