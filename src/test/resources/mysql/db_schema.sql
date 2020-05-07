CREATE TABLE city(
	city_id CHAR(5) NOT NULL COMMENT '城市ID',
	name VARCHAR(10) NOT NULL COMMENT '城市名',
	created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (city_id)
) ENGINE=InnoDB COMMENT='城市表';
