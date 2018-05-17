package com.ma.maqiu.dao;

import com.ma.maqiu.entity.Visitor;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IVisitorDAO {

  @Insert("insert into visitor(ip,url,create_at) value (#{ip}, #{url}), NOW()")
  int insert(Visitor visitor);

}