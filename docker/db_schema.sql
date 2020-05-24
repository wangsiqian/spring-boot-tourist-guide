CREATE TABLE city
(
    city_id    CHAR(5)     NOT NULL COMMENT '城市ID',
    name       VARCHAR(10) NOT NULL COMMENT '城市名',
    created_at timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (city_id),
    UNIQUE KEY uk_name (name)
) ENGINE = InnoDB COMMENT ='城市表';

CREATE TABLE bookmark
(
    id         bigint       NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    user_id    varchar(28)  NOT NULL COMMENT '用户ID',
    place_id   varchar(36)  NOT NULL COMMENT '收藏的景点ID',
    place_name varchar(36)  NOT NULL COMMENT '景点名称',
    cover_url  varchar(255) NOT NULL COMMENT '封面图片',
    created_at timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY uk_bookmark_id (user_id, place_id)
) ENGINE = InnoDB COMMENT ='书签';

CREATE TABLE comment
(
    id         bigint       NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    comment_id VARCHAR(32)  NOT NULL COMMENT '评论ID',
    place_id   VARCHAR(36)  NOT NULL COMMENT '景点ID',
    user_id    VARCHAR(28) COMMENT '用户ID',
    content    VARCHAR(255) NOT NULL COMMENT '评论内容',
    created_at timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY uk_comment_id (comment_id),
    INDEX idx_place_id (place_id)
) ENGINE = InnoDB COMMENT = '评论表';
