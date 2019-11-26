package com.mark.springboot.domain;

import java.util.List;

/**
 * desc
 *
 * @author Lixf
 * @since 2019/2/21 17:42
 **/
public class Data {


    private List<List<TableFileds>> filedsList;
    private List<Tables> tables;

    public List<List<TableFileds>> getFiledsList() {
        return filedsList;
    }

    public void setFiledsList(List<List<TableFileds>> filedsList) {
        this.filedsList = filedsList;
    }

    public List<Tables> getTables() {
        return tables;
    }

    public void setTables(List<Tables> tables) {
        this.tables = tables;
    }
}
