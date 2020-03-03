/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : photo-management

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2020-03-01 18:34:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `photoid` varchar(255) NOT NULL,
  `photoname` varchar(255) DEFAULT NULL,
  `gname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `realpath` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  PRIMARY KEY (`photoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
