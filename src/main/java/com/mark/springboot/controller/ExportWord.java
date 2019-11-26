package com.mark.springboot.controller;


import com.mark.springboot.http.R;
import com.mark.springboot.service.CreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc
 *
 * @author Lixf
 * @since 2019/2/21 14:36
 **/
@RestController
@RequestMapping("/db")
public class ExportWord {
  @Autowired
  CreateService createService;

  @Value("${dataName}")
  private String dataName;//库名


  @RequestMapping("/export")
  public R generate() {
    String filePath = "";
    String fileName = "";
    filePath = filePath + fileName + ".doc";
    createService.getTableInfo(dataName, filePath);
    return R.ok();
  }
}
