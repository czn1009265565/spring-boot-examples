CREATE TABLE `user_operation`(
    `id` BIGINT(64) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    `username` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '用户名',
    `description` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '描述',
    `method` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '方法名',
    `params` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '请求参数',
    `log_type` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '日志类型',
    `request_ip` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '请求IP',
    `address` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '地址',
    `browser` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '浏览器',
    `exception` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '异常信息',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间'
)COMMENT='用户操作记录表';

