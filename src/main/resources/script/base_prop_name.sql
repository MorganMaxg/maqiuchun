-- 基本属性表
create table base_prop_name(
  prop_name_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '属性名ID',
  prop_chinese_name VARCHAR(40) NOT NULL DEFAULT '' COMMENT '属性值名称',
  class_id BIGINT NOT NULL DEFAULT 0 COMMENT '所属类目ID',
  is_allow_alias boolean default false COMMENT '是否允许别名',
  is_color boolean default false comment '是否颜色',
  is_enum boolean default false comment '是否枚举',
  is_input boolean default false comment '是否输入属性',
  is_key_input boolean default false comment '是否关键属性',
  is_sales boolean default false comment '是否销售属性',
  is_search boolean default false comment '是否搜索属性',
  is_required boolean default false comment '是否必须',
  is_multi_choose boolean default false comment '是否多选',
  status int default 0 comment '0表示正常',
  sort_no int comment '排序',
  update_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  create_at TIMESTAMP NOT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
