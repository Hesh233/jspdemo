/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : springboot_jpa

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-12-16 21:12:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('2');

-- ----------------------------
-- Table structure for school_data_entity
-- ----------------------------
DROP TABLE IF EXISTS `school_data_entity`;
CREATE TABLE `school_data_entity` (
  `id` int(11) NOT NULL,
  `createtime` datetime DEFAULT NULL,
  `edu_level` varchar(255) DEFAULT NULL,
  `lbrdpm` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `qqrdpm` int(11) DEFAULT NULL,
  `s_name` varchar(255) DEFAULT NULL,
  `sch_dentity` int(11) DEFAULT NULL,
  `eeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKno3m9g6jmc0ew8y5dgn45vbes` (`eeid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_data_entity
-- ----------------------------

-- ----------------------------
-- Table structure for t_cod_school_data
-- ----------------------------
DROP TABLE IF EXISTS `t_cod_school_data`;
CREATE TABLE `t_cod_school_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL,
  `edu_level` varchar(255) DEFAULT NULL,
  `lbrdpm` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `qqrdpm` int(11) NOT NULL,
  `s_name` varchar(255) DEFAULT NULL,
  `sch_identity` int(11) NOT NULL,
  `sch_dentity` int(11) DEFAULT NULL,
  `eeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo85u1u3w1adyw9lp3qvy73hmh` (`eeid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cod_school_data
-- ----------------------------
INSERT INTO `t_cod_school_data` VALUES ('1', '2018-12-16 20:28:50', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `t_cod_school_data` VALUES ('2', '2018-12-16 20:28:59', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO `t_cod_school_data` VALUES ('3', '2018-12-16 20:35:41', '3', '3', '3', '3', '3', '3', '3', '2');

-- ----------------------------
-- Table structure for t_cod_school_level
-- ----------------------------
DROP TABLE IF EXISTS `t_cod_school_level`;
CREATE TABLE `t_cod_school_level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eeid` int(11) NOT NULL,
  `level` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `eeid` (`eeid`),
  CONSTRAINT `eeid` FOREIGN KEY (`eeid`) REFERENCES `t_cod_school_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cod_school_level
-- ----------------------------
INSERT INTO `t_cod_school_level` VALUES ('1', '1', '1', '1', '2018-12-16 20:29:10');
INSERT INTO `t_cod_school_level` VALUES ('2', '2', '2', '2', '2018-12-16 20:29:16');
INSERT INTO `t_cod_school_level` VALUES ('3', '1', '1', '1', '2018-12-16 20:58:52');
INSERT INTO `t_cod_school_level` VALUES ('41', '2', '1', '1', '2018-10-01 00:00:00');
INSERT INTO `t_cod_school_level` VALUES ('42', '2', '1', '1', '2018-10-01 00:00:00');
INSERT INTO `t_cod_school_level` VALUES ('43', '2', '1', '1', '2018-10-01 00:00:00');
INSERT INTO `t_cod_school_level` VALUES ('44', '2', '1', '1', '2018-10-01 00:00:00');
INSERT INTO `t_cod_school_level` VALUES ('45', '2', '1', '1', '2018-10-01 00:00:00');
INSERT INTO `t_cod_school_level` VALUES ('46', '2', '1', '1', '2018-10-01 00:00:00');
INSERT INTO `t_cod_school_level` VALUES ('47', '2', '1', '1', '2018-10-01 00:00:00');
INSERT INTO `t_cod_school_level` VALUES ('48', '2', '1', '1', '2018-10-01 00:00:00');
INSERT INTO `t_cod_school_level` VALUES ('49', '2', '1', '1', '2018-10-01 00:00:00');
INSERT INTO `t_cod_school_level` VALUES ('50', '2', '1', '1', '2018-10-01 00:00:00');
INSERT INTO `t_cod_school_level` VALUES ('51', '2', '1', '1', '2018-10-01 00:00:00');
INSERT INTO `t_cod_school_level` VALUES ('52', '2', '1', '1', '2018-10-01 00:00:00');
INSERT INTO `t_cod_school_level` VALUES ('53', '2', '1', '1', '2018-10-01 00:00:00');
INSERT INTO `t_cod_school_level` VALUES ('54', '2', '1', '1', '2018-10-01 00:00:00');
INSERT INTO `t_cod_school_level` VALUES ('55', '2', '1', '1', '2018-10-01 00:00:00');
INSERT INTO `t_cod_school_level` VALUES ('56', '2', '1', '1', '2018-10-01 00:00:00');

-- ----------------------------
-- Table structure for user_test
-- ----------------------------
DROP TABLE IF EXISTS `user_test`;
CREATE TABLE `user_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_test
-- ----------------------------
INSERT INTO `user_test` VALUES ('1', 'lskadjalksdsjalk');
INSERT INTO `user_test` VALUES ('2', 'asd');
INSERT INTO `user_test` VALUES ('3', '123');
INSERT INTO `user_test` VALUES ('4', 'wqwe');
