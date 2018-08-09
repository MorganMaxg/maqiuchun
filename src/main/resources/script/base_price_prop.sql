-- 计量属性表
create table base_price_prop {
  BASE_PRICE_ID bigint primary key auto_increment COMMENT '计量属性ID',
  BASE_PRICE_NAME varchar(50) NOT NULL DEFAULT '' COMMENT '计量属性名称',
  STATUS INT(5) NOT NULL DEFAULT 0 COMMENT '状态',
  SORT_NO INT(5) NOT NULL DEFAULT 0 COMMENT '排序',
  CREATE_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
}