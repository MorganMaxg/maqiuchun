package com.ma.maqiu.service;

import com.ma.maqiu.dao.IVisitorDAO;
import com.ma.maqiu.entity.Visitor;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VisitorDBService implements IVisitorService{

  @Resource
  private IVisitorDAO visitorDAO;

  @Override
  public int addVisitor(Visitor visitor) {
    return visitorDAO.insert(visitor);
  }
}
