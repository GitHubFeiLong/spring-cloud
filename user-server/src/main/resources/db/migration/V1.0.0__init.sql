/*
MySQL Backup
Database: security
Backup Time: 2021-04-02 17:16:30
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `security`.`authority_menu`;
DROP TABLE IF EXISTS `security`.`authority_role`;
DROP TABLE IF EXISTS `security`.`authority_role_menu`;
DROP TABLE IF EXISTS `security`.`authority_user`;
DROP TABLE IF EXISTS `security`.`authority_user_role`;
CREATE TABLE `authority_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `url` varchar(255) DEFAULT NULL COMMENT '请求路径',
  `menu_name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父菜单id',
  `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `url_pre` varchar(255) DEFAULT NULL COMMENT '路由(前端自己匹配用)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
CREATE TABLE `authority_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称(必须以ROLE_起始命名)',
  `role_name_CN` varchar(255) DEFAULT NULL COMMENT '角色名称中文',
  `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
CREATE TABLE `authority_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=798 DEFAULT CHARSET=utf8;
CREATE TABLE `authority_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `valid_time` varchar(255) DEFAULT NULL COMMENT '有效截止时间',
  `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
  `remark` mediumtext COMMENT '备注',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
CREATE TABLE `authority_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
BEGIN;
LOCK TABLES `security`.`authority_menu` WRITE;
DELETE FROM `security`.`authority_menu`;
INSERT INTO `security`.`authority_menu` (`id`,`url`,`menu_name`,`parent_id`,`update_time`,`remark`,`url_pre`) VALUES (1, '/api/user/hello', 'hello', NULL, NULL, NULL, NULL);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `security`.`authority_role` WRITE;
DELETE FROM `security`.`authority_role`;
INSERT INTO `security`.`authority_role` (`id`,`role_name`,`role_name_CN`,`update_time`,`remark`) VALUES (1, 'ROLE_ADMIN', NULL, NULL, NULL);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `security`.`authority_role_menu` WRITE;
DELETE FROM `security`.`authority_role_menu`;
INSERT INTO `security`.`authority_role_menu` (`id`,`role_id`,`menu_id`,`update_time`) VALUES (1, 1, 1, NULL);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `security`.`authority_user` WRITE;
DELETE FROM `security`.`authority_user`;
INSERT INTO `security`.`authority_user` (`id`,`username`,`password`,`email`,`phone`,`valid_time`,`update_time`,`remark`,`nickname`) VALUES (1, 'admin', '$2a$10$VYJTJGzU/PivEhyDjU2hQuo6vwSsOKMbNv1oBbjFnqORLz0iiOY1C', NULL, NULL, NULL, NULL, NULL, NULL);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `security`.`authority_user_role` WRITE;
DELETE FROM `security`.`authority_user_role`;
INSERT INTO `security`.`authority_user_role` (`id`,`user_id`,`role_id`,`update_time`) VALUES (1, 1, 1, NULL);
UNLOCK TABLES;
COMMIT;
