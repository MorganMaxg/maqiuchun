package com.ma.maqiu.wx;

import com.ma.maqiu.entity.WXToken;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx")
public class WxController {

  @GetMapping("/handler")
  public String handlerWxMessage(WXToken msg){
    if (SignUtil.checkSignature(msg.getSignature(), msg.getTimestamp(), msg.getNonce()))
    return msg.getEchostr();
    else return "failed";
  }
}
