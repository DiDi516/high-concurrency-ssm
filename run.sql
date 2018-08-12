/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : high_concurrency_ssm

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2018-08-12 19:39:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_red_packet`
-- ----------------------------
DROP TABLE IF EXISTS `t_red_packet`;
CREATE TABLE `t_red_packet` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '红包编号',
  `user_id` int(12) NOT NULL COMMENT '发红包用户',
  `amount` decimal(16,2) NOT NULL COMMENT '红包金额',
  `send_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '发红包时间',
  `total` int(12) NOT NULL COMMENT '小红包总数',
  `unit_amount` decimal(12,0) NOT NULL COMMENT '单个小红包金额',
  `stock` int(12) NOT NULL COMMENT '剩余小红包个数',
  `version` int(12) NOT NULL DEFAULT '0' COMMENT '版本',
  `note` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_red_packet
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_red_packet`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_red_packet`;
CREATE TABLE `t_user_red_packet` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `red_packet_id` int(12) NOT NULL COMMENT '红包编号',
  `user_id` int(12) NOT NULL COMMENT '抢红包用户编号',
  `amount` decimal(16,2) NOT NULL COMMENT '抢红包金额',
  `grab_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '抢红包时间',
  `note` varchar(256) COLLATE utf8_bin NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_user_red_packet
-- ----------------------------
