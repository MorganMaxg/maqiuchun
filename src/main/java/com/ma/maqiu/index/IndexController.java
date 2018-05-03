package com.ma.maqiu.index;

import com.ma.maqiu.service.VisitorService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class IndexController {

  @Resource
  private VisitorService visitorService;

  /**
   * 首页
   *
   * @return home page
   */
  @RequestMapping("/")
  public String index(HttpServletRequest request){
    String num;
    synchronized(visitorService) {
      num = visitorService.getVisitorCount();
      visitorService.addVisitor(request.getRemoteAddr(), String.valueOf(Long.valueOf(num) + 1l));
    }
    return "hello. 您是第" + num + "访客.";
  }

}
