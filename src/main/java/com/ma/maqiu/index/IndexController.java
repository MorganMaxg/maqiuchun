package com.ma.maqiu.index;

import com.ma.maqiu.entity.Visitor;
import com.ma.maqiu.service.IVisitorService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class IndexController {

  @Resource
  private IVisitorService visitorDBService;

  /**
   * 首页
   *
   * @return home page
   */
  @RequestMapping("/")
  public String index(HttpServletRequest request){
    Visitor visitor = new Visitor();
    visitor.setIp(request.getRemoteAddr());
    visitor.setUrl(request.getRequestURL().toString());
    visitorDBService.addVisitor(visitor);
    return "hello. 您的ip是:" + request.getRemoteAddr();
  }

}
