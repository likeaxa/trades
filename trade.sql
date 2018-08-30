/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : trade

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-07-18 15:30:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `adminname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(30) DEFAULT NULL COMMENT '分类名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '数码3C');
INSERT INTO `category` VALUES ('2', '家居日用');
INSERT INTO `category` VALUES ('3', '鞋服配饰');
INSERT INTO `category` VALUES ('4', '珠宝收藏');
INSERT INTO `category` VALUES ('5', '图书音像');
INSERT INTO `category` VALUES ('6', '食品饮料');
INSERT INTO `category` VALUES ('7', '奢侈品');
INSERT INTO `category` VALUES ('9', 'AAAAA');

-- ----------------------------
-- Table structure for exchange
-- ----------------------------
DROP TABLE IF EXISTS `exchange`;
CREATE TABLE `exchange` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `seller_user_id` int(11) DEFAULT NULL COMMENT '卖方id',
  `buyer_user_id` int(11) DEFAULT NULL COMMENT '买方id',
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `trade_time` datetime DEFAULT NULL,
  `trade_number` int(10) unsigned DEFAULT NULL,
  `total` double unsigned DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='交易表';

-- ----------------------------
-- Records of exchange
-- ----------------------------

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL COMMENT '哪个商品的图片',
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '大图，中图，小图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='图片表';

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES ('1', '20', '/static/pictures/oneplus5T.jpg');
INSERT INTO `image` VALUES ('2', '20', null);
INSERT INTO `image` VALUES ('3', '20', null);
INSERT INTO `image` VALUES ('4', '16', null);
INSERT INTO `image` VALUES ('5', '19', '/static/pictures/cpp.jpg');
INSERT INTO `image` VALUES ('6', '19', null);
INSERT INTO `image` VALUES ('7', '1', null);
INSERT INTO `image` VALUES ('8', '22', '/static/pictures/00061976.jpg');

-- ----------------------------
-- Table structure for like
-- ----------------------------
DROP TABLE IF EXISTS `like`;
CREATE TABLE `like` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关注表';

-- ----------------------------
-- Records of like
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `cate_id` int(11) DEFAULT NULL COMMENT '属于哪个分类',
  `description` varchar(255) DEFAULT '暂无描述' COMMENT '商品描述',
  `number` double(4,0) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('16', '6', '水', '5', '2018-07-13 00:00:00', '2', '就是一瓶水', '1');
INSERT INTO `product` VALUES ('17', '1', '纸巾', '1.5', '2018-07-13 00:00:00', '1', '普通的纸巾', '1');
INSERT INTO `product` VALUES ('18', '10', 'Java Web高级编程', '30', '2018-07-14 00:00:00', '5', '一本书', '2');
INSERT INTO `product` VALUES ('19', '10', 'C ++ Primer', '35', '2018-07-14 00:00:00', '5', '一本书', '1');
INSERT INTO `product` VALUES ('20', '10', '一加5T', '2999', '2018-07-14 18:05:41', '1', '手机啊', '5');
INSERT INTO `product` VALUES ('21', '6', '电脑', '3', '2018-07-14 01:20:35', '1', '31321231', '2');
INSERT INTO `product` VALUES ('22', '1', 'JBL GO', '299', '2018-07-14 21:40:48', '1', '音乐金砖', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `phone` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `star` double DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '8888', '123', null, '5');
INSERT INTO `user` VALUES ('6', 'xiaoming', '8888', '568', null, '5');
INSERT INTO `user` VALUES ('9', 'calm', '123456', '13014142525', null, '5');
INSERT INTO `user` VALUES ('10', 'jerrysheh', '66666666', '13014142525', null, '5');
INSERT INTO `user` VALUES ('11', 'hello', '00000000', '133222666666', null, null);
INSERT INTO `user` VALUES ('12', 'colorful', '123', '13013025252', null, null);
INSERT INTO `user` VALUES ('13', 'asdasd', 'asdasd', '13333333', null, null);
INSERT INTO `user` VALUES ('14', 'aaaa', 'asdasd', '12123', null, null);
INSERT INTO `user` VALUES ('15', '666', '123123', '1234567890', null, null);
INSERT INTO `user` VALUES ('16', 'admin3333', '123', '123', null, null);
INSERT INTO `user` VALUES ('17', 'zxc', 'zxc', '13322211234', null, null);
INSERT INTO `user` VALUES ('18', '啊鬼', 'agui', '1301234567', null, null);
INSERT INTO `user` VALUES ('19', 'jjjjjjj', 'aaa', '12123', null, null);
