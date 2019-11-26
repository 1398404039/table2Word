package com.mark.springboot.domain;

/**
 * desc
 *
 * @author Lixf
 * @since 2019/2/21 16:48
 **/
public class TableFileds {

    private String field;//字段名
    private String type;//类型
    private String Null;//是否为空
    private String key;//主键
    private String comment;//字段说明

    @Override
    public String toString() {
        return "TableFileds{" +
                "field='" + field + '\'' +
                ", type='" + type + '\'' +
                ", Null='" + Null + '\'' +
                ", key='" + key + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNull() {
        return Null;
    }

    public void setNull(String aNull) {
        Null = aNull;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
