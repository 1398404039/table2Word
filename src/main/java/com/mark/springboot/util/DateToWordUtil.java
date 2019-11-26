package com.mark.springboot.util;

import java.awt.Color;
import java.io.FileOutputStream;
import java.util.List;

import com.lowagie.text.*;
import com.lowagie.text.rtf.RtfWriter2;
import com.mark.springboot.dao.QueryDao;
import com.mark.springboot.domain.TableFileds;
import com.mark.springboot.domain.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * desc * 创建word文档 步骤: 1,建立文档 2,创建一个书写器 3,打开文档 4,向文档中写入数据 5,关闭文档
 *
 * @author Lixf
 * @since 2019/2/21 19:22
 **/
@Service
public class DateToWordUtil {

    @Autowired
    QueryDao queryDao;


    public void toWord(List<Tables> tables, String fileName) {// 创建word文档,并设置纸张的大小
        Document document = new Document(PageSize.A4);
        try {
            // 创建word文档
            RtfWriter2.getInstance(document, new FileOutputStream(fileName));
            document.open();
            Paragraph ph = new Paragraph();

            Font f = new Font();
            Paragraph p = new Paragraph("word", new Font(Font.NORMAL, 24, Font.BOLDITALIC, new Color(0, 0, 0)));

            p.setAlignment(1);

            document.add(p);

            ph.setFont(f);
            for (int i = 0; i < tables.size(); i++) {
                String table_name = tables.get(i).getName();
                String table_comment = tables.get(i).getComment();

                List<TableFileds> fileds = queryDao.getTable(tables.get(i).getName());

                String all = "" + (i + 1) + " tableName:" + table_name + ":" + table_comment;//表头

                Table table = new Table(6);//6列

                document.add(new Paragraph(""));

                table.setBorderWidth(1);

// table.setBorderColor(Color.BLACK);

                table.setPadding(0);

                table.setSpacing(0);

                /*
                 * 添加表头的元素，并设置表头背景的颜色
                 */
                Color chade = new Color(176, 196, 222);

                Cell cell = new Cell("num");// 单元格

                cell.setBackgroundColor(chade);

                cell.setHeader(true);

                table.addCell(cell);

                cell = new Cell("file");// 单元格

                cell.setBackgroundColor(chade);

                table.addCell(cell);

                cell = new Cell("type");// 单元格

                cell.setBackgroundColor(chade);

                table.addCell(cell);

                cell = new Cell("isNull");// 单元格

                cell.setBackgroundColor(chade);

                table.addCell(cell);

                cell = new Cell("primary key");// 单元格

                cell.setBackgroundColor(chade);

                table.addCell(cell);

                cell = new Cell("desc");// 单元格

                cell.setBackgroundColor(chade);

                table.addCell(cell);

                table.endHeaders();// 表头结束
                // 表格的主体
                for (int k = 0; k < fileds.size(); k++) {
                    String Field = fileds.get(k).getField();

                    String Type = fileds.get(k).getType();

                    String Null = fileds.get(k).getNull();

                    String Key = fileds.get(k).getKey();

                    String Comment = fileds.get(k).getComment();
                    table.addCell((k + 1) + "");

                    table.addCell(Field);

                    table.addCell(Type);

                    table.addCell(Null);

                    table.addCell(Key);

                    table.addCell(Comment);
                }
                Paragraph pheae = new Paragraph(all);
                //写入表说明
                document.add(pheae);
                //生成表格
                document.add(table);
            }
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
