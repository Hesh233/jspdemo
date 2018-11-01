/*
Navicat MySQL Data Transfer

Source Server         : 5.0user
Source Server Version : 50090
Source Host           : localhost:3306
Source Database       : dailyfresh

Target Server Type    : MYSQL
Target Server Version : 50090
File Encoding         : 65001

Date: 2018-10-31 19:08:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for df_user_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `df_user_userinfo`;
CREATE TABLE `df_user_userinfo` (
  `id` int(11) NOT NULL auto_increment,
  `uname` varchar(20) NOT NULL,
  `upwd` varchar(40) NOT NULL,
  `uemail` varchar(30) NOT NULL,
  `ushou` varchar(30) default '',
  `uphone` varchar(11) default '',
  `uaddress` varchar(100) default '',
  `uyoubian` varchar(6) default '',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of df_user_userinfo
-- ----------------------------
INSERT INTO `df_user_userinfo` VALUES ('1', 'asdasdasd', '7c222fb2927d828af22f592134e8932480637c0d', '12589', '李开复', '12345678910', '快快减肥你会死的', '邮编');
INSERT INTO `df_user_userinfo` VALUES ('2', 'hesh23333', '7c222fb2927d828af22f592134e8932480637c0d', '1.1@.com', '收货地址', '12345678910', '地址', '邮编');
INSERT INTO `df_user_userinfo` VALUES ('4', 'adminadmin', '7c222fb2927d828af22f592134e8932480637c0d', '15986', '李开复', '12345678910', '阿拉山口多久爱死了大街上', '');
INSERT INTO `df_user_userinfo` VALUES ('3', 'admin', '7c222fb2927d828af22f592134e8932480637c0d', '1.1@.com', '收货地址', '12345678910', '地址', '邮编');
INSERT INTO `df_user_userinfo` VALUES ('10', 'admin1', 'd033e22ae348aeb5660fc2140aec35850c4da997', 'askdjasl', null, null, null, null);
INSERT INTO `df_user_userinfo` VALUES ('11', 'admina', 'd033e22ae348aeb5660fc2140aec35850c4da997', '123@q.c', '李开复', '12345678910', 'asdasd', 'ads');
