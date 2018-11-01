/*
Navicat MySQL Data Transfer

Source Server         : 5.0user
Source Server Version : 50090
Source Host           : localhost:3306
Source Database       : dailyfresh

Target Server Type    : MYSQL
Target Server Version : 50090
File Encoding         : 65001

Date: 2018-11-01 10:37:25
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

-- ----------------------------
-- Table structure for df_goods_goodsinfo
-- ----------------------------
DROP TABLE IF EXISTS `df_goods_goodsinfo`;
CREATE TABLE `df_goods_goodsinfo` (
  `id` int(11) NOT NULL auto_increment,
  `gtitle` varchar(20) NOT NULL,
  `gpic` varchar(100) NOT NULL,
  `gprice` decimal(5,2) NOT NULL,
  `gunit` varchar(20) NOT NULL,
  `gclick` int(11) NOT NULL,
  `gjianjie` varchar(200) NOT NULL,
  `gkucun` int(11) NOT NULL,
  `gcontent` longtext NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  `gtype_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `df_goods_goodsinfo_3204e418` (`gtype_id`)
) ENGINE=MyISAM AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of df_goods_goodsinfo
-- ----------------------------
INSERT INTO `df_goods_goodsinfo` VALUES ('1', '柠檬', '/static/images/goods/goods001.jpg', '3.90', '3.90元/500g', '1', '紫葡萄紫葡萄', '100', '紫葡萄紫葡萄紫葡萄紫葡萄', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('2', '紫葡萄', '/static/images/goods/goods002.jpg', '16.80', '16.80元/500g', '2', '葡萄葡萄', '100', '葡萄葡萄葡萄葡萄', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('3', '草莓', '/static/images/goods/goods003.jpg', '16.80', '16.80元/500g', '11', '草莓浆果柔软多汁，味美爽口，适合速冻保鲜贮藏。草莓速冻后，可以保持原有的色、香、味，既便于贮藏，又便于外销。', '100', '草莓采摘园位于北京大兴区 庞各庄镇四各庄村 ，每年1月-6月面向北京以及周围城市提供新鲜草莓采摘和精品礼盒装草莓，草莓品种多样丰富，个大香甜。所有草莓均严格按照有机标准培育，不使用任何化肥和农药。草莓在采摘期间免洗可以直接食用。欢迎喜欢草莓的市民前来采摘，也欢迎各大单位选购精品有机草莓礼盒，有机草莓礼盒是亲朋馈赠、福利送礼的最佳选择。 ', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('4', '梨光杏', '/static/images/goods/goods004.jpg', '5.50', '5.50元/500g', '4', '梨光杏梨光杏', '100', '梨光杏梨光杏梨光杏梨光杏', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('5', '黄肉桃', '/static/images/goods/goods005.jpg', '10.00', '10.00元/500g', '6', '黄肉桃黄肉桃', '100', '黄肉桃黄肉桃黄肉桃黄肉桃', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('6', '西梅', '/static/images/goods/goods006.jpg', '28.80', '28.8元/500g', '8', '西梅西梅', '100', '西梅西梅西梅西梅', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('7', '香梨', '/static/images/goods/goods007.jpg', '6.45', '6.45元/500g', '12', '香梨香梨', '100', '香梨香梨香梨香梨', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('8', '栗子', '/static/images/goods/goods008.jpg', '9.50', '9.50元/500g', '22', '栗子栗子', '100', '栗子栗子栗子栗子', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('9', '香蕉', '/static/images/goods/goods009.jpg', '3.30', '3.30元/500g', '51', '香蕉香蕉', '100', '香蕉香蕉香蕉香蕉', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('10', '青苹果', '/static/images/goods/goods010.jpg', '5.00', '5.00元/500g', '7', '青苹果青苹果', '100', '青苹果青苹果青苹果青苹果', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('11', '山莓', '/static/images/goods/goods011.jpg', '28.80', '28.8元/500g', '10', '山莓山莓', '100', '山莓山莓山莓山莓', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('12', '奇异果', '/static/images/goods/goods012.jpg', '25.80', '25.8元/500g', '19', '奇异果奇异果', '100', '奇异果奇异果奇异果奇异果', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('13', '蜜桔', '/static/images/goods/goods013.jpg', '4.80', '4.8元/500g', '10', '蜜桔蜜桔', '100', '蜜桔蜜桔蜜桔蜜桔', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('14', '脐橙', '/static/images/goods/goods014.jpg', '3.50', '3.50元/500g', '25', '脐橙脐橙', '100', '脐橙脐橙脐橙脐橙', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('15', '椰子', '/static/images/goods/goods015.jpg', '28.80', '28.80元/500g', '9', '椰子椰子', '100', '椰子椰子椰子椰子', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('16', '油桃', '/static/images/goods/goods016.jpg', '39.90', '39.90元/500g', '13', '油桃油桃', '100', '油桃油桃油桃油桃', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('17', '红提葡萄', '/static/images/goods/goods017.jpg', '26.80', '元/500g', '25', '红提葡萄红提葡萄', '100', '红提葡萄红提葡萄红提葡萄红提葡萄', '0', '1');
INSERT INTO `df_goods_goodsinfo` VALUES ('18', '青虾', '/static/images/goods/goods018.jpg', '48.00', '48.00元/500g', '3', '青虾青虾', '100', '青虾青虾青虾青虾', '0', '2');
INSERT INTO `df_goods_goodsinfo` VALUES ('19', '扇贝', '/static/images/goods/goods019.jpg', '46.00', '46.00元/500g', '10', '扇贝扇贝', '100', '扇贝扇贝扇贝扇贝', '0', '2');
INSERT INTO `df_goods_goodsinfo` VALUES ('20', '秋刀鱼', '/static/images/goods/goods020.jpg', '19.00', '19.00元/500g', '3', '秋刀鱼秋刀鱼', '100', '秋刀鱼秋刀鱼秋刀鱼秋刀鱼', '0', '2');
INSERT INTO `df_goods_goodsinfo` VALUES ('21', '基围虾', '/static/images/goods/goods021.jpg', '25.00', '25.00元/500g', '9', '基围虾基围虾', '100', '基围虾基围虾基围虾基围虾', '0', '2');
INSERT INTO `df_goods_goodsinfo` VALUES ('22', '生蚝', '/static/images/goods/goods022.jpg', '22.00', '22.00元/500g', '10', '生蚝生蚝', '100', '生蚝生蚝生蚝生蚝', '0', '2');
INSERT INTO `df_goods_goodsinfo` VALUES ('23', '猪肉', '/static/images/goods/goods023.jpg', '23.00', '23.00元/500g', '17', '猪肉猪肉', '100', '猪肉猪肉猪肉猪肉', '0', '3');
INSERT INTO `df_goods_goodsinfo` VALUES ('24', '牛肉', '/static/images/goods/goods024.jpg', '24.00', '24.00元/500g', '12', '牛肉牛肉', '100', '牛肉牛肉牛肉牛肉', '0', '3');
INSERT INTO `df_goods_goodsinfo` VALUES ('25', '羊肉', '/static/images/goods/goods025.jpg', '25.00', '25.00元/500g', '13', '羊肉羊肉', '100', '羊肉羊肉羊肉羊肉', '0', '3');
INSERT INTO `df_goods_goodsinfo` VALUES ('26', '兔肉', '/static/images/goods/goods026.jpg', '26.00', '26.00元/500g', '24', '兔肉兔肉', '100', '兔肉兔肉兔肉兔肉', '0', '3');
INSERT INTO `df_goods_goodsinfo` VALUES ('27', '鸡肉', '/static/images/goods/goods027.jpg', '27.00', '27.00元/500g', '22', '鸡肉鸡肉', '100', '鸡肉鸡肉鸡肉鸡肉', '0', '3');
INSERT INTO `df_goods_goodsinfo` VALUES ('28', '土鸡蛋', '/static/images/goods/goods028.jpg', '28.00', '28.00元/500g', '15', '土鸡蛋土鸡蛋', '100', '土鸡蛋土鸡蛋土鸡蛋土鸡蛋', '0', '4');
INSERT INTO `df_goods_goodsinfo` VALUES ('29', '鸭蛋', '/static/images/goods/goods029.jpg', '29.00', '29.00元/500g', '9', '鸭蛋鸭蛋', '100', '鸭蛋鸭蛋鸭蛋鸭蛋', '0', '4');
INSERT INTO `df_goods_goodsinfo` VALUES ('30', '鹌鹑蛋', '/static/images/goods/goods030.jpg', '30.00', '30.00元/500g', '7', '鹌鹑蛋鹌鹑蛋', '100', '鹌鹑蛋鹌鹑蛋鹌鹑蛋鹌鹑蛋', '0', '4');
INSERT INTO `df_goods_goodsinfo` VALUES ('31', '皮蛋', '/static/images/goods/goods031.jpg', '31.00', '31.00元/500g', '5', '皮蛋皮蛋', '100', '皮蛋皮蛋皮蛋皮蛋', '0', '4');
INSERT INTO `df_goods_goodsinfo` VALUES ('32', '咸蛋', '/static/images/goods/goods032.jpg', '32.00', '32.00元/500g', '8', '咸蛋咸蛋', '100', '咸蛋咸蛋咸蛋咸蛋', '0', '4');
INSERT INTO `df_goods_goodsinfo` VALUES ('33', '生菜', '/static/images/goods/goods033.jpg', '33.00', '33.00元/500g', '74', '生菜生菜', '100', '生菜生菜生菜生菜', '0', '5');
INSERT INTO `df_goods_goodsinfo` VALUES ('34', '白菜', '/static/images/goods/goods034.jpg', '34.00', '34.00元/500g', '3', '白菜白菜', '100', '白菜白菜白菜白菜', '0', '5');
INSERT INTO `df_goods_goodsinfo` VALUES ('35', '油麦菜', '/static/images/goods/goods035.jpg', '35.00', '35.00元/500g', '3', '油麦菜油麦菜', '100', '油麦菜油麦菜油麦菜油麦菜', '0', '5');
INSERT INTO `df_goods_goodsinfo` VALUES ('36', '通心菜', '/static/images/goods/goods036.jpg', '36.00', '36.00元/500g', '4', '通心菜通心菜', '100', '通心菜通心菜通心菜通心菜', '0', '5');
INSERT INTO `df_goods_goodsinfo` VALUES ('37', '芥菜', '/static/images/goods/goods037.jpg', '37.00', '37.00元/500g', '5', '芥菜芥菜', '100', '芥菜芥菜芥菜芥菜', '0', '5');
INSERT INTO `df_goods_goodsinfo` VALUES ('38', '草莓圣代', '/static/images/goods/goods038.jpg', '38.00', '38.00元/500g', '8', '草莓圣代草莓圣代', '100', '草莓圣代草莓圣代草莓圣代草莓圣代', '0', '6');
INSERT INTO `df_goods_goodsinfo` VALUES ('39', '圆筒雪糕', '/static/images/goods/goods039.jpg', '39.00', '39.00元/500g', '41', '圆筒雪糕圆筒雪糕', '100', '圆筒雪糕圆筒雪糕圆筒雪糕圆筒雪糕', '0', '6');
INSERT INTO `df_goods_goodsinfo` VALUES ('40', '麦旋风', '/static/images/goods/goods040.jpg', '40.00', '40.00元/500g', '5', '麦旋风麦旋风', '100', '麦旋风麦旋风麦旋风麦旋风', '0', '6');
INSERT INTO `df_goods_goodsinfo` VALUES ('41', '雪媚娘', '/static/images/goods/goods041.jpg', '41.00', '41.00元/500g', '15', '雪媚娘雪媚娘', '100', '雪媚娘雪媚娘雪媚娘雪媚娘', '0', '6');
INSERT INTO `df_goods_goodsinfo` VALUES ('42', '芭菲', '/static/images/goods/goods042.jpg', '42.00', '42.00元/500g', '28', '芭菲芭菲', '100', '芭菲芭菲芭菲芭菲', '0', '6');

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
