package com.ma.maqiu.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ResultCode {

  /**
   * 返回成功结果
   */
  SUCCESS("200", "SUCCESS"),

  CREATE_FILE_ERROR("E00001", "创建文件失败."),
  READ_FILE_ERROR("E00002", "读取文件失败."),
  WRITE_FILE_ERROR("E00003", "写入文件失败."),
  ;

  @Getter
  private String code;

  @Getter
  private String message;

}
