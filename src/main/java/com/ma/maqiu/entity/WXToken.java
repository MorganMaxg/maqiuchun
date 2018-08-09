package com.ma.maqiu.entity;

import lombok.Data;

@Data
public class WXToken {

  private String signature;

  private String timestamp;

  private String nonce;

  private String echostr;

}
