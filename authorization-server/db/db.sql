DROP DATABASE IF EXISTS sso_oauth;
CREATE DATABASE sso_oauth DEFAULT CHARSET utf8mb4;
USE sso_oauth;

DROP TABLE  IF EXISTS client_detail;
CREATE TABLE client_detail
(
    id  INT COMMENT '主键',
    client_id VARCHAR(255) COMMENT '客户端id',
    client_secret VARCHAR(255) COMMENT '客户端密钥',
    resource_ids VARCHAR(255) COMMENT '资源id集合',
    scope VARCHAR(255) COMMENT '范围',
    authorized_grant_types VARCHAR(255) COMMENT 'oauth2验证权限类型',
    redirect_uri VARCHAR(255) COMMENT '重定向url',
    auto_approve VARCHAR(255) COMMENT '是否自动确认',
    access_token_validity_seconds BIGINT COMMENT '访问权限时间',
    refresh_token_validity_seconds BIGINT COMMENT '刷新权限时间'
    created_by VARCHAR(255) COMMENT '',
    created_time DATETIME COMMENT '' ,
    updated_by DATETIME COMMENT '' ,
    updated_time DATETIME COMMENT '' ,

) COMMENT 'Oauth2的客户端信息表';

DROP TABLE  IF EXISTS oauth_user;
CREATE TABLE oauth_user
(
    id  INT COMMENT '主键',
    username VARCHAR(255) COMMENT '账号',
    password VARCHAR(255) COMMENT '密码',
    name VARCHAR(255) COMMENT '昵称',
    email VARCHAR(255) COMMENT '邮箱',
    phone VARCHAR(255) COMMENT '手机号',
    is_enable VARCHAR(255) COMMENT '是否启用',
    is_expired VARCHAR(255) COMMENT '是否过期',
    is_locked VARCHAR(255) COMMENT '是否锁定',
    created_time DATETIME COMMENT '' ,
    created_by VARCHAR(255) COMMENT '',
    updated_by VARCHAR(255) COMMENT '' ,
    updated_time DATETIME COMMENT '' ,

) COMMENT 'Oauth2登录的用户信息表';


