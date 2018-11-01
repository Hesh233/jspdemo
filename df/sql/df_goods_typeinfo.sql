/*
Navicat MySQL Data Transfer

Source Server         : 5.0user
Source Server Version : 50090
Source Host           : localhost:3306
Source Database       : dailyfresh

Target Server Type    : MYSQL
Target Server Version : 50090
File Encoding         : 65001

Date: 2018-10-31 19:08:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for df_goods_typeinfo
-- ----------------------------
DROP TABLE IF EXISTS `df_goods_typeinfo`;
CREATE TABLE `df_goods_typeinfo` (
  `id` int(11) NOT NULL auto_increment,
  `ttitle` varchar(20) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of df_goods_typeinfo
-- ----------------------------
INSERT INTO `df_goods_typeinfo` VALUES ('1', '新鲜水果', '0');
INSERT INTO `df_goods_typeinfo` VALUES ('2', '海鲜产品', '0');
INSERT INTO `df_goods_typeinfo` VALUES ('3', '猪羊牛肉', '0');
INSERT INTO `df_goods_typeinfo` VALUES ('4', '禽类蛋品', '0');
INSERT INTO `df_goods_typeinfo` VALUES ('5', '新鲜蔬菜', '0');
INSERT INTO `df_goods_typeinfo` VALUES ('6', '速冻食品', '0');
