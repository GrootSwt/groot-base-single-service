/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 39.106.49.0:3306
 Source Schema         : single_blog

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 20/01/2022 16:35:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `location` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '路径',
  `icon` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `sort` int NULL DEFAULT NULL COMMENT '排序',
  `enabled` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否启用（0：未启用，1：启用）',
  `parent_id` bigint NOT NULL COMMENT '父菜单ID',
  `type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型（1：菜单；2：权限）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '主页', '/home', 'el-icon-s-home', 1, '1', 0, '1');
INSERT INTO `menu` VALUES (2, '系统管理', '/system', 'el-icon-s-tools', 2, '1', 0, '1');
INSERT INTO `menu` VALUES (3, '权限管理', '/system/menu', 'el-icon-menu', 1, '1', 2, '1');
INSERT INTO `menu` VALUES (11, '角色管理', '/system/role', 'fa fa-chain', 2, '1', 2, '1');
INSERT INTO `menu` VALUES (12, '用户管理', '/system/user', 'el-icon-user-solid', 3, '1', 2, '1');
INSERT INTO `menu` VALUES (18, '日志管理', '/system/log', 'fa fa-bug', 4, '1', 2, '1');
INSERT INTO `menu` VALUES (19, '数据字典管理', '/system/dict', 'fa fa-stack-overflow', 5, '1', 2, '1');
INSERT INTO `menu` VALUES (20, 'JAVA', '/java', 'el-icon-hot-water', 3, '1', 0, '1');
INSERT INTO `menu` VALUES (21, '新增同级节点', 'addSameNode', NULL, 1, '1', 3, '2');
INSERT INTO `menu` VALUES (22, '新增子节点', 'addSubNode', NULL, 2, '1', 3, '2');
INSERT INTO `menu` VALUES (23, '删除该节点', 'deleteNode', NULL, 3, '1', 3, '2');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `enabled` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (13, '管理员', '具有系统管理权限', '1');

-- ----------------------------
-- Table structure for role_relation_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_relation_menu`;
CREATE TABLE `role_relation_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 168 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role_relation_menu
-- ----------------------------
INSERT INTO `role_relation_menu` VALUES (168, 13, 1);
INSERT INTO `role_relation_menu` VALUES (169, 13, 2);
INSERT INTO `role_relation_menu` VALUES (170, 13, 3);
INSERT INTO `role_relation_menu` VALUES (171, 13, 21);
INSERT INTO `role_relation_menu` VALUES (172, 13, 22);
INSERT INTO `role_relation_menu` VALUES (173, 13, 23);
INSERT INTO `role_relation_menu` VALUES (174, 13, 11);
INSERT INTO `role_relation_menu` VALUES (175, 13, 12);
INSERT INTO `role_relation_menu` VALUES (176, 13, 18);
INSERT INTO `role_relation_menu` VALUES (177, 13, 19);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名',
  `phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `enabled` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '启用状态（0：未启用；1：启用）',
  `avatar` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', 'admin', '18888888888', '18888888888@micro.com', 13, '1', 55);

SET FOREIGN_KEY_CHECKS = 1;
