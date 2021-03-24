CREATE TABLE `user`(
    `id` INT(11) NOT NULL PRIMARY KEY COMMENT 'id',
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `enabled` BOOLEAN NOT NULL COMMENT '用户是否可用',
    `roles` VARCHAR(255) COMMENT '用户角色',
    `email` VARCHAR(255) COMMENT '邮箱',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
)COMMENT='用户详情表';