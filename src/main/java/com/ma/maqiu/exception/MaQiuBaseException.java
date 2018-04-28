package com.ma.maqiu.exception;

import lombok.Data;

/**
 * maqiu 基础异常
 * <p>
 *   所有MaqiuChunApplication应用对外抛出的异常均应该是该类的子类.
 * </p>
 */
@Data
public class MaQiuBaseException extends RuntimeException {

  private String code;

  public MaQiuBaseException(ResultCode resultCode){
    super(resultCode.getMessage());
    this.code = resultCode.getCode();
  }

}
