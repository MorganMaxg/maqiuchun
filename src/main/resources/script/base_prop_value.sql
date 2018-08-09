--基本属性值表
create table base_prop_value(
  prop_value_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '属性值ID',
  prop_value_name VARCHAR(40) NOT NULL DEFAULT '' COMMENT '属性值名称',
  prop_name_id BIGINT NOT NULL COMMENT '属性名ID',
  class_id BIGINT NOT NULL DEFAULT 0 COMMENT '所属类目ID',
  status int default 0 COMMENT '状态',
  sort_no int COMMENT '排序',
  update_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  create_at TIMESTAMP NOT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;