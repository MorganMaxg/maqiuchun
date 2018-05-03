package com.ma.maqiu.service;

import com.ma.maqiu.config.VisitorConfig;
import com.ma.maqiu.exception.MaQiuBaseException;
import com.ma.maqiu.exception.ResultCode;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class VisitorService {

  @Resource
  private VisitorConfig visitorConfig;

  private final static String DEFAULT_NUM = "0";

  /**
   * 获取访客数量
   *
   * @return 访客数量
   */
  public String getVisitorCount() {
    String resultNum = DEFAULT_NUM;
    String filePath = visitorConfig.getVisitorCountFilePath();
    File file = new File(filePath);
    if (file.exists()) {
      try {
        List<String> fileLines = FileUtils.readLines(file, "UTF-8");
        if (CollectionUtils.isNotEmpty(fileLines)) {
          //获取最后一行
          resultNum = fileLines.get(fileLines.size() - 1);
        }
      } catch (IOException e) {
        e.printStackTrace();
        log.error("读取文件file:失败,{}", e);
        throw new MaQiuBaseException(ResultCode.READ_FILE_ERROR);
      }
    }
    return StringUtils.isBlank(resultNum) ? DEFAULT_NUM : resultNum;
  }

  public void addVisitor(String ipAddress, String num){
    String countFilePath = visitorConfig.getVisitorCountFilePath();
    String ipsFilePath = visitorConfig.getIpsFilePath();
    File countFile = new File(countFilePath);
    File ipsFile = new File(ipsFilePath);
    try {
      if (!countFile.exists()) {
        countFile.createNewFile();
      }
      if (!ipsFile.exists()) {
        ipsFile.createNewFile();
      }
    } catch (IOException e) {
      log.error("countFile:{}, ipsFiles={} 失败.e={}", countFilePath, ipsFilePath, e);
      throw new MaQiuBaseException(ResultCode.CREATE_FILE_ERROR);
    }
    try {
      List<String> countLine = new ArrayList<>(1);
      countLine.add(num);
      FileUtils.writeLines(countFile, countLine);
      List<String> ipLine = new ArrayList<>(1);
      ipLine.add(ipAddress);
      FileUtils.writeLines(ipsFile, ipLine);
    } catch (IOException e) {
      log.error("文件countFile:{}, ipFile:{}写入失败.e={}", countFilePath, ipsFilePath, e);
      throw new MaQiuBaseException(ResultCode.WRITE_FILE_ERROR);
    }
  }



}
