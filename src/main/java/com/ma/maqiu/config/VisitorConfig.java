package com.ma.maqiu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@PropertySource("classpath:application.properties")
@Data
public class VisitorConfig {

  @Value("${visitor.count.filepath}")
  private String visitorCountFilePath;

  @Value("${visitor.ips.filepath}")
  private String ipsFilePath;

}
