/*
Navicat MySQL Data Transfer

Source Server         : 5.0user
Source Server Version : 50090
Source Host           : localhost:3306
Source Database       : dailyfresh

Target Server Type    : MYSQL
Target Server Version : 50090
File Encoding         : 65001

Date: 2018-10-31 19:08:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for df_cart_cartinfo
-- ----------------------------
DROP TABLE IF EXISTS `df_cart_cartinfo`;
CREATE TABLE `df_cart_cartinfo` (
  `id` int(11) NOT NULL auto_increment,
  `count` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `user_id` (`user_id`,`goods_id`),
  KEY `df_cart_cartinfo_6753b66e` (`goods_id`),
  KEY `df_cart_cartinfo_e8701ad4` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of df_cart_cartinfo
-- ----------------------------
INSERT INTO `df_cart_cartinfo` VALUES ('1', '4', '1', '4');
INSERT INTO `df_cart_cartinfo` VALUES ('2', '3', '3', '4');
INSERT INTO `df_cart_cartinfo` VALUES ('3', '7', '4', '4');
INSERT INTO `df_cart_cartinfo` VALUES ('7', '2', '18', '4');
INSERT INTO `df_cart_cartinfo` VALUES ('6', '2', '5', '10');
INSERT INTO `df_cart_cartinfo` VALUES ('4', '10', '21', '1');
INSERT INTO `df_cart_cartinfo` VALUES ('70', '31', '22', '4');
INSERT INTO `df_cart_cartinfo` VALUES ('71', '1', '41', '4');
INSERT INTO `df_cart_cartinfo` VALUES ('5', '1', '22', '10');
INSERT INTO `df_cart_cartinfo` VALUES ('10', '1', '24', '10');
INSERT INTO `df_cart_cartinfo` VALUES ('73', '2', '31', '10');
INSERT INTO `df_cart_cartinfo` VALUES ('74', '1', '32', '10');
