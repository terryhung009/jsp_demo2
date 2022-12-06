/*
 Navicat Premium Data Transfer

 Source Server         : danny_mySQL
 Source Server Type    : MySQL
 Source Server Version : 100703 (10.7.3-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : userdb

 Target Server Type    : MySQL
 Target Server Version : 100703 (10.7.3-MariaDB)
 File Encoding         : 65001

 Date: 06/12/2022 13:10:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menuinfo
-- ----------------------------
DROP TABLE IF EXISTS `menuinfo`;
CREATE TABLE `menuinfo`  (
  `menuId` int NOT NULL AUTO_INCREMENT,
  `menuName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '0',
  `nemuPath` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`menuId`) USING BTREE,
  INDEX `menuid`(`menuId` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menuinfo
-- ----------------------------

-- ----------------------------
-- Table structure for roleinfo
-- ----------------------------
DROP TABLE IF EXISTS `roleinfo`;
CREATE TABLE `roleinfo`  (
  `roleId` int NOT NULL DEFAULT 1,
  `roleName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`roleId`) USING BTREE,
  INDEX `roleId`(`roleId` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roleinfo
-- ----------------------------
INSERT INTO `roleinfo` VALUES (1, '管理員');
INSERT INTO `roleinfo` VALUES (2, '使用者');

-- ----------------------------
-- Table structure for rolemenuinfo
-- ----------------------------
DROP TABLE IF EXISTS `rolemenuinfo`;
CREATE TABLE `rolemenuinfo`  (
  `roleId` int NOT NULL,
  `menuId` int NOT NULL,
  INDEX `roleId`(`roleId` ASC) USING BTREE,
  INDEX `menuId`(`menuId` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rolemenuinfo
-- ----------------------------

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `userId` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '',
  `userName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `gender` int NULL DEFAULT NULL,
  `roleId` int NOT NULL DEFAULT 1,
  `userPassword` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '',
  PRIMARY KEY (`userId`) USING BTREE,
  INDEX `FK_userinfo_roleinfo`(`roleId` ASC) USING BTREE,
  CONSTRAINT `FK_userinfo_roleinfo` FOREIGN KEY (`roleId`) REFERENCES `roleinfo` (`roleId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (' admin2 ', ' admin2 ', 1, 1, ' password ');
INSERT INTO `userinfo` VALUES (' admin3 ', ' æå ', 1, 1, ' password ');
INSERT INTO `userinfo` VALUES (' admin5 ', ' çäº ', 1, 1, ' password ');
INSERT INTO `userinfo` VALUES (' user ', ' user ', 1, 1, ' password ');
INSERT INTO `userinfo` VALUES (' user1 ', ' user1 ', 1, 2, ' password ');
INSERT INTO `userinfo` VALUES (' user2 ', ' user2 ', 1, 2, ' password ');
INSERT INTO `userinfo` VALUES ('admin', '張三', 1, 1, 'password');

SET FOREIGN_KEY_CHECKS = 1;
