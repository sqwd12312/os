/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50556
 Source Host           : localhost:3306
 Source Schema         : homeworksubmit

 Target Server Type    : MySQL
 Target Server Version : 50556
 File Encoding         : 65001

 Date: 02/07/2019 10:22:47
*/

SET NAMES utf-8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('1', '1');

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course`  (
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `requirement` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ptime` date NULL DEFAULT NULL,
  `etime` date NULL DEFAULT NULL,
  `identifier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_course
-- ----------------------------
INSERT INTO `tb_course` VALUES ('个人简介', '卡卡西', '测试', '2019-07-01', '2019-07-30', '001');
INSERT INTO `tb_course` VALUES ('作业测试', '卡卡西', '测试', '2019-07-02', '2019-07-01', '测试');
INSERT INTO `tb_course` VALUES ('第一次作业', '卡卡西', '测试', '2019-07-01', '2019-07-30', '002');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `specialty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `classnum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES ('覃南雁', '666666', '666666@qq.com', '软件工程', '1班');
INSERT INTO `tb_student` VALUES ('3', NULL, NULL, NULL, NULL);
INSERT INTO `tb_student` VALUES ('4', NULL, NULL, NULL, NULL);
INSERT INTO `tb_student` VALUES ('5', NULL, NULL, NULL, NULL);
INSERT INTO `tb_student` VALUES ('6', NULL, NULL, NULL, NULL);
INSERT INTO `tb_student` VALUES ('7', NULL, NULL, NULL, NULL);
INSERT INTO `tb_student` VALUES ('8', NULL, NULL, NULL, NULL);
INSERT INTO `tb_student` VALUES ('9', NULL, NULL, NULL, NULL);
INSERT INTO `tb_student` VALUES ('10', NULL, NULL, NULL, NULL);
INSERT INTO `tb_student` VALUES ('肖扬', '88888888', '00', NULL, NULL);
INSERT INTO `tb_student` VALUES ('注册用户名', '666666', '666666', NULL, NULL);

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher`  (
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `specialty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT ''
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES ('666666', '卡卡西', '88888888@qq.com', '软件工程');
INSERT INTO `tb_teacher` VALUES ('', '4', '', '');
INSERT INTO `tb_teacher` VALUES ('', '5', '', '');
INSERT INTO `tb_teacher` VALUES ('', '6', '', '');
INSERT INTO `tb_teacher` VALUES ('', '7', '', '');
INSERT INTO `tb_teacher` VALUES ('', '8', '', '');
INSERT INTO `tb_teacher` VALUES ('666666', '老师注册666', '666666', '');

-- ----------------------------
-- Table structure for tb_work_completed
-- ----------------------------
DROP TABLE IF EXISTS `tb_work_completed`;
CREATE TABLE `tb_work_completed`  (
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `identifier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_work_completed
-- ----------------------------
INSERT INTO `tb_work_completed` VALUES ('覃南雁的个人简历.docx', '覃南雁', '', '001');
INSERT INTO `tb_work_completed` VALUES ('肖扬的个人简历.docx', '肖扬', '', '001');
INSERT INTO `tb_work_completed` VALUES ('覃南雁的第一次作业.txt', '覃南雁', '100', '002');

SET FOREIGN_KEY_CHECKS = 1;
