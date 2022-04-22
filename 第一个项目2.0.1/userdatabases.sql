/*
 Navicat Premium Data Transfer

 Source Server         : userdatabases
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : userdatabases

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 18/11/2021 17:04:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `sellUid` bigint(0) NULL DEFAULT NULL COMMENT '卖家id',
  `buyUid` bigint(0) NULL DEFAULT NULL COMMENT '买家id',
  `Pid` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品id',
  `Pmurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片地址',
  `Psta` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `Ppice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品价格',
  `Pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名字',
  `cartID` bigint(0) UNSIGNED NOT NULL COMMENT '订单id',
  `SellName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卖家姓名',
  `BuyName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家姓名',
  `adress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `getOrderName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GetTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cartID`) USING BTREE,
  UNIQUE INDEX `cartID`(`cartID`) USING BTREE,
  INDEX `sellUid`(`sellUid`) USING BTREE,
  INDEX `buyUid`(`buyUid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (1234567890, 2020211402, '1234567890-2021-11-18022537', 'picture/1234567890-2021-11-18022537.jpg', 'D', '123.0', '卫衣', 20211118023203, 'root', 'rootA', '花果楼下咖啡厅', '17623500067', 'M7119', '2021-11-18T02:25');
INSERT INTO `cart` VALUES (1234567890, 1234567890, '1234567890-2021-11-17083938', 'picture/1234567890-2021-11-17083938.jpg', 'D', '85.0', '小米电动牙刷蓝色', 20211118100514, 'root', 'root', '花果楼下咖啡厅', '17623500067', 'J1676', '2021-11-17T20:39');
INSERT INTO `cart` VALUES (1234567890, 1234567890, '1234567890-2021-11-18022537', 'picture/1234567890-2021-11-18022537.jpg', 'A', '123.0', '卫衣', 20211118101007, 'root', 'root', '花果楼下咖啡厅', '17623500067', NULL, '2021-11-18T02:25');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `newsID` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '文本id',
  `userID` bigint(0) NULL DEFAULT NULL COMMENT '文本所有者id',
  `txtAre` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文本内容',
  `txtTime` varchar(266) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文本发布时间',
  `txtclass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文本种类',
  `txtTile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `phon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`newsID`) USING BTREE,
  INDEX `userID`(`userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, NULL, NULL, NULL, NULL, NULL, '17623500067', 'root');
INSERT INTO `news` VALUES (4, 1234567890, '安全防疫你我他，幸福安全靠大家，多喝热水少聚集，共同防疫度那度难关！', '2021-11-19T15:50', '其它', '防疫', '17623500067', 'root');
INSERT INTO `news` VALUES (6, 1234567890, '在s3403丢失学生证。有捡到的同学一定要联系我呀\r\nqq1234568787！', '2021-11-19T16:38', '失物招领', '找学生证', '17623500067', 'root');
INSERT INTO `news` VALUES (7, 1234567890, '食堂的大众餐特别的好吃，有空一起去吃呀！', '2021-11-25T16:40', '留言', '好吃', '17623500067', 'root');
INSERT INTO `news` VALUES (8, 2020211402, '我的好朋友的手走丢了，有不有人看见了', '2021-11-19T16:43', '失物招领', '找好朋友的手丢了', '123456', 'rootA');

-- ----------------------------
-- Table structure for productab
-- ----------------------------
DROP TABLE IF EXISTS `productab`;
CREATE TABLE `productab`  (
  `productName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productID` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productPrice` double NULL DEFAULT NULL,
  `productBelongName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productBelongID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productIMGurl` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productDescribe` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productClass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Productquantity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `getProductTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`productID`) USING BTREE,
  UNIQUE INDEX `productID`(`productID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of productab
-- ----------------------------
INSERT INTO `productab` VALUES ('小米电动牙刷蓝色', '1234567890-2021-11-17083938', 85, 'root', '1234567890', 'picture/1234567890-2021-11-17083938.jpg', '全新没用过的电动牙刷，带充电器，电池', '电子产品', NULL, '花果楼下咖啡厅', '17623500067', '2021-11-17T20:39');
INSERT INTO `productab` VALUES ('大笔', '1234567890-2021-11-17084056', 120, 'root', '1234567890', 'picture/1234567890-2021-11-17084056.jpg', '带礼品盒，双11买的笔，联系方式qq：15896347', '文具', NULL, '花果楼下咖啡厅', '17623500067', '2021-11-17T20:40');
INSERT INTO `productab` VALUES ('龙猫本子', '1234567890-2021-11-17084133', 12, 'root', '1234567890', 'picture/1234567890-2021-11-17084133.jpg', '龙猫同款灰色本子！！', '文具', NULL, '花果楼下咖啡厅', '17623500067', '2021-11-17T20:41');
INSERT INTO `productab` VALUES ('卫衣', '1234567890-2021-11-18022537', 123, 'root', '1234567890', 'picture/1234567890-2021-11-18022537.jpg', '很不错的毛衣，可以联系我qq14784531654，详谈这个毛衣！！！！', '衣服', NULL, '花果楼下咖啡厅', '17623500067', '2021-11-18T02:25');
INSERT INTO `productab` VALUES ('牛皮本子', '1234567890-2021-11-18050159', 45, 'root', '1234567890', 'picture/1234567890-2021-11-18050159.jpg', '全牛皮本子', '文具', NULL, '花果楼下咖啡厅', '17623500067', '2021-11-25T17:01');

-- ----------------------------
-- Table structure for userdatas
-- ----------------------------
DROP TABLE IF EXISTS `userdatas`;
CREATE TABLE `userdatas`  (
  `userId` bigint(0) NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userAdress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userPass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userMail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE,
  UNIQUE INDEX `userId`(`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userdatas
-- ----------------------------
INSERT INTO `userdatas` VALUES (1, '测试人', '廊桥', '123456', '2054911458@qq.com');
INSERT INTO `userdatas` VALUES (1234567890, 'root', '廊桥', '123456789', '2054911458@qq.com');
INSERT INTO `userdatas` VALUES (2020211402, 'rootA', '廊桥', '123456', '1978433128@qq.com');
INSERT INTO `userdatas` VALUES (2020211404, '小花', '花果', '123456', '2054911458@qq.com');
INSERT INTO `userdatas` VALUES (2020211409, '甲大大', '廊桥', '123456', '2054911458@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
