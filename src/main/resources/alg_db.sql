/*
 Navicat MySQL Data Transfer

 Source Server         : my
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : alg_db

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 11/06/2024 21:21:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bubble_sort
-- ----------------------------
DROP TABLE IF EXISTS `bubble_sort`;
CREATE TABLE `bubble_sort`  (
  `bubble_id` int NOT NULL AUTO_INCREMENT,
  `exchange` tinyint NOT NULL,
  `pre_pos` int NOT NULL,
  `post_pos` int NOT NULL,
  `turn` int NOT NULL,
  `curr_list` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `practice_id` int NOT NULL,
  `process_num` int NOT NULL,
  `user_id` int NOT NULL,
  `process_step` int NOT NULL,
  PRIMARY KEY (`bubble_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `bubble_sort_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bubble_sort
-- ----------------------------
INSERT INTO `bubble_sort` VALUES (1, 0, 0, 0, 0, '5, 2, 8, 1, 4', 1, 0, 1, 0);
INSERT INTO `bubble_sort` VALUES (2, 1, 0, 1, 1, '2, 5, 8, 1, 4', 1, 1, 1, 1);
INSERT INTO `bubble_sort` VALUES (3, 0, 0, 0, 1, '2, 5, 8, 1, 4', 1, 2, 1, 2);
INSERT INTO `bubble_sort` VALUES (4, 1, 2, 3, 1, '2, 5, 1, 8, 4', 1, 3, 1, 3);
INSERT INTO `bubble_sort` VALUES (5, 1, 3, 4, 1, '2, 5, 1, 4, 8', 1, 4, 1, 4);
INSERT INTO `bubble_sort` VALUES (6, 0, 0, 0, 2, '2, 5, 1, 4, 8', 1, 5, 1, 2);
INSERT INTO `bubble_sort` VALUES (7, 1, 1, 2, 2, '2, 1, 5, 4, 8', 1, 6, 1, 3);
INSERT INTO `bubble_sort` VALUES (8, 1, 2, 3, 2, '2, 1, 4, 5, 8', 1, 7, 1, 4);
INSERT INTO `bubble_sort` VALUES (9, 1, 0, 1, 3, '1, 2, 4, 5, 8', 1, 8, 1, 3);
INSERT INTO `bubble_sort` VALUES (10, 0, 0, 0, 3, '1, 2, 4, 5, 8', 1, 9, 1, 4);
INSERT INTO `bubble_sort` VALUES (11, 0, 0, 0, 4, '1, 2, 4, 5, 8', 1, 10, 1, 4);
INSERT INTO `bubble_sort` VALUES (12, 0, 0, 0, 0, '5, 1, 3', 2, 0, 1, 0);
INSERT INTO `bubble_sort` VALUES (13, 1, 0, 1, 1, '1, 5, 3', 2, 1, 1, 1);
INSERT INTO `bubble_sort` VALUES (14, 1, 1, 2, 1, '1, 3, 5', 2, 2, 1, 2);
INSERT INTO `bubble_sort` VALUES (15, 0, 0, 0, 2, '1, 3, 5', 2, 3, 1, 2);
INSERT INTO `bubble_sort` VALUES (16, 0, 0, 0, 0, '4, 2, 8, 6, 5', 3, 0, 1, 0);
INSERT INTO `bubble_sort` VALUES (17, 1, 0, 1, 1, '2, 4, 8, 6, 5', 3, 1, 1, 1);
INSERT INTO `bubble_sort` VALUES (18, 0, 0, 0, 1, '2, 4, 8, 6, 5', 3, 2, 1, 2);
INSERT INTO `bubble_sort` VALUES (19, 1, 2, 3, 1, '2, 4, 6, 8, 5', 3, 3, 1, 3);
INSERT INTO `bubble_sort` VALUES (20, 1, 3, 4, 1, '2, 4, 6, 5, 8', 3, 4, 1, 4);
INSERT INTO `bubble_sort` VALUES (21, 0, 0, 0, 2, '2, 4, 6, 5, 8', 3, 5, 1, 2);
INSERT INTO `bubble_sort` VALUES (22, 0, 0, 0, 2, '2, 4, 6, 5, 8', 3, 6, 1, 3);
INSERT INTO `bubble_sort` VALUES (23, 1, 2, 3, 2, '2, 4, 5, 6, 8', 3, 7, 1, 4);
INSERT INTO `bubble_sort` VALUES (24, 0, 0, 0, 3, '2, 4, 5, 6, 8', 3, 8, 1, 3);
INSERT INTO `bubble_sort` VALUES (25, 0, 0, 0, 3, '2, 4, 5, 6, 8', 3, 9, 1, 4);
INSERT INTO `bubble_sort` VALUES (26, 0, 0, 0, 4, '2, 4, 5, 6, 8', 3, 10, 1, 4);
INSERT INTO `bubble_sort` VALUES (27, 0, 0, 0, 0, '4, 9, 0, 3, 1, 5', 4, 0, 1, 0);
INSERT INTO `bubble_sort` VALUES (28, 0, 0, 0, 1, '4, 9, 0, 3, 1, 5', 4, 1, 1, 1);
INSERT INTO `bubble_sort` VALUES (29, 1, 1, 2, 1, '4, 0, 9, 3, 1, 5', 4, 2, 1, 2);
INSERT INTO `bubble_sort` VALUES (30, 1, 2, 3, 1, '4, 0, 3, 9, 1, 5', 4, 3, 1, 3);
INSERT INTO `bubble_sort` VALUES (31, 1, 3, 4, 1, '4, 0, 3, 1, 9, 5', 4, 4, 1, 4);
INSERT INTO `bubble_sort` VALUES (32, 1, 4, 5, 1, '4, 0, 3, 1, 5, 9', 4, 5, 1, 5);
INSERT INTO `bubble_sort` VALUES (33, 1, 0, 1, 2, '0, 4, 3, 1, 5, 9', 4, 6, 1, 2);
INSERT INTO `bubble_sort` VALUES (34, 1, 1, 2, 2, '0, 3, 4, 1, 5, 9', 4, 7, 1, 3);
INSERT INTO `bubble_sort` VALUES (35, 1, 2, 3, 2, '0, 3, 1, 4, 5, 9', 4, 8, 1, 4);
INSERT INTO `bubble_sort` VALUES (36, 0, 0, 0, 2, '0, 3, 1, 4, 5, 9', 4, 9, 1, 5);
INSERT INTO `bubble_sort` VALUES (37, 0, 0, 0, 3, '0, 3, 1, 4, 5, 9', 4, 10, 1, 3);
INSERT INTO `bubble_sort` VALUES (38, 1, 1, 2, 3, '0, 1, 3, 4, 5, 9', 4, 11, 1, 4);
INSERT INTO `bubble_sort` VALUES (39, 0, 0, 0, 3, '0, 1, 3, 4, 5, 9', 4, 12, 1, 5);
INSERT INTO `bubble_sort` VALUES (40, 0, 0, 0, 4, '0, 1, 3, 4, 5, 9', 4, 13, 1, 4);
INSERT INTO `bubble_sort` VALUES (41, 0, 0, 0, 4, '0, 1, 3, 4, 5, 9', 4, 14, 1, 5);
INSERT INTO `bubble_sort` VALUES (42, 0, 0, 0, 5, '0, 1, 3, 4, 5, 9', 4, 15, 1, 5);
INSERT INTO `bubble_sort` VALUES (43, 0, 0, 0, 0, '1, 5, 0, 4, 7', 5, 0, 1, 0);
INSERT INTO `bubble_sort` VALUES (44, 0, 0, 0, 1, '1, 5, 0, 4, 7', 5, 1, 1, 1);
INSERT INTO `bubble_sort` VALUES (45, 1, 1, 2, 1, '1, 0, 5, 4, 7', 5, 2, 1, 2);
INSERT INTO `bubble_sort` VALUES (46, 1, 2, 3, 1, '1, 0, 4, 5, 7', 5, 3, 1, 3);
INSERT INTO `bubble_sort` VALUES (47, 0, 0, 0, 1, '1, 0, 4, 5, 7', 5, 4, 1, 4);
INSERT INTO `bubble_sort` VALUES (48, 1, 0, 1, 2, '0, 1, 4, 5, 7', 5, 5, 1, 2);
INSERT INTO `bubble_sort` VALUES (49, 0, 0, 0, 2, '0, 1, 4, 5, 7', 5, 6, 1, 3);
INSERT INTO `bubble_sort` VALUES (50, 0, 0, 0, 2, '0, 1, 4, 5, 7', 5, 7, 1, 4);
INSERT INTO `bubble_sort` VALUES (51, 0, 0, 0, 3, '0, 1, 4, 5, 7', 5, 8, 1, 3);
INSERT INTO `bubble_sort` VALUES (52, 0, 0, 0, 3, '0, 1, 4, 5, 7', 5, 9, 1, 4);
INSERT INTO `bubble_sort` VALUES (53, 0, 0, 0, 4, '0, 1, 4, 5, 7', 5, 10, 1, 4);
INSERT INTO `bubble_sort` VALUES (54, 0, 0, 0, 0, '3, 4, 0, 2, 1', 6, 0, 1, 0);
INSERT INTO `bubble_sort` VALUES (55, 0, 0, 0, 1, '3, 4, 0, 2, 1', 6, 1, 1, 1);
INSERT INTO `bubble_sort` VALUES (56, 1, 1, 2, 1, '3, 0, 4, 2, 1', 6, 2, 1, 2);
INSERT INTO `bubble_sort` VALUES (57, 1, 2, 3, 1, '3, 0, 2, 4, 1', 6, 3, 1, 3);
INSERT INTO `bubble_sort` VALUES (58, 1, 3, 4, 1, '3, 0, 2, 1, 4', 6, 4, 1, 4);
INSERT INTO `bubble_sort` VALUES (59, 1, 0, 1, 2, '0, 3, 2, 1, 4', 6, 5, 1, 2);
INSERT INTO `bubble_sort` VALUES (60, 1, 1, 2, 2, '0, 2, 3, 1, 4', 6, 6, 1, 3);
INSERT INTO `bubble_sort` VALUES (61, 1, 2, 3, 2, '0, 2, 1, 3, 4', 6, 7, 1, 4);
INSERT INTO `bubble_sort` VALUES (62, 0, 0, 0, 3, '0, 2, 1, 3, 4', 6, 8, 1, 3);
INSERT INTO `bubble_sort` VALUES (63, 1, 1, 2, 3, '0, 1, 2, 3, 4', 6, 9, 1, 4);
INSERT INTO `bubble_sort` VALUES (64, 0, 0, 0, 4, '0, 1, 2, 3, 4', 6, 10, 1, 4);
INSERT INTO `bubble_sort` VALUES (65, 0, 0, 0, 0, '3, 14, 2, 7, 21, 6, 8', 7, 0, 1, 0);
INSERT INTO `bubble_sort` VALUES (66, 0, 0, 0, 1, '3, 14, 2, 7, 21, 6, 8', 7, 1, 1, 1);
INSERT INTO `bubble_sort` VALUES (67, 1, 1, 2, 1, '3, 2, 14, 7, 21, 6, 8', 7, 2, 1, 2);
INSERT INTO `bubble_sort` VALUES (68, 1, 2, 3, 1, '3, 2, 7, 14, 21, 6, 8', 7, 3, 1, 3);
INSERT INTO `bubble_sort` VALUES (69, 0, 0, 0, 1, '3, 2, 7, 14, 21, 6, 8', 7, 4, 1, 4);
INSERT INTO `bubble_sort` VALUES (70, 1, 4, 5, 1, '3, 2, 7, 14, 6, 21, 8', 7, 5, 1, 5);
INSERT INTO `bubble_sort` VALUES (71, 1, 5, 6, 1, '3, 2, 7, 14, 6, 8, 21', 7, 6, 1, 6);
INSERT INTO `bubble_sort` VALUES (72, 1, 0, 1, 2, '2, 3, 7, 14, 6, 8, 21', 7, 7, 1, 2);
INSERT INTO `bubble_sort` VALUES (73, 0, 0, 0, 2, '2, 3, 7, 14, 6, 8, 21', 7, 8, 1, 3);
INSERT INTO `bubble_sort` VALUES (74, 0, 0, 0, 2, '2, 3, 7, 14, 6, 8, 21', 7, 9, 1, 4);
INSERT INTO `bubble_sort` VALUES (75, 1, 3, 4, 2, '2, 3, 7, 6, 14, 8, 21', 7, 10, 1, 5);
INSERT INTO `bubble_sort` VALUES (76, 1, 4, 5, 2, '2, 3, 7, 6, 8, 14, 21', 7, 11, 1, 6);
INSERT INTO `bubble_sort` VALUES (77, 0, 0, 0, 3, '2, 3, 7, 6, 8, 14, 21', 7, 12, 1, 3);
INSERT INTO `bubble_sort` VALUES (78, 0, 0, 0, 3, '2, 3, 7, 6, 8, 14, 21', 7, 13, 1, 4);
INSERT INTO `bubble_sort` VALUES (79, 1, 2, 3, 3, '2, 3, 6, 7, 8, 14, 21', 7, 14, 1, 5);
INSERT INTO `bubble_sort` VALUES (80, 0, 0, 0, 3, '2, 3, 6, 7, 8, 14, 21', 7, 15, 1, 6);
INSERT INTO `bubble_sort` VALUES (81, 0, 0, 0, 4, '2, 3, 6, 7, 8, 14, 21', 7, 16, 1, 4);
INSERT INTO `bubble_sort` VALUES (82, 0, 0, 0, 4, '2, 3, 6, 7, 8, 14, 21', 7, 17, 1, 5);
INSERT INTO `bubble_sort` VALUES (83, 0, 0, 0, 4, '2, 3, 6, 7, 8, 14, 21', 7, 18, 1, 6);
INSERT INTO `bubble_sort` VALUES (84, 0, 0, 0, 5, '2, 3, 6, 7, 8, 14, 21', 7, 19, 1, 5);
INSERT INTO `bubble_sort` VALUES (85, 0, 0, 0, 5, '2, 3, 6, 7, 8, 14, 21', 7, 20, 1, 6);
INSERT INTO `bubble_sort` VALUES (86, 0, 0, 0, 6, '2, 3, 6, 7, 8, 14, 21', 7, 21, 1, 6);
INSERT INTO `bubble_sort` VALUES (87, 0, 0, 0, 0, '3, 24, 5, 23, 7, 0', 8, 0, 1, 0);
INSERT INTO `bubble_sort` VALUES (88, 0, 0, 0, 1, '3, 24, 5, 23, 7, 0', 8, 1, 1, 1);
INSERT INTO `bubble_sort` VALUES (89, 1, 1, 2, 1, '3, 5, 24, 23, 7, 0', 8, 2, 1, 2);
INSERT INTO `bubble_sort` VALUES (90, 1, 2, 3, 1, '3, 5, 23, 24, 7, 0', 8, 3, 1, 3);
INSERT INTO `bubble_sort` VALUES (91, 1, 3, 4, 1, '3, 5, 23, 7, 24, 0', 8, 4, 1, 4);
INSERT INTO `bubble_sort` VALUES (92, 1, 4, 5, 1, '3, 5, 23, 7, 0, 24', 8, 5, 1, 5);
INSERT INTO `bubble_sort` VALUES (93, 0, 0, 0, 2, '3, 5, 23, 7, 0, 24', 8, 6, 1, 2);
INSERT INTO `bubble_sort` VALUES (94, 0, 0, 0, 2, '3, 5, 23, 7, 0, 24', 8, 7, 1, 3);
INSERT INTO `bubble_sort` VALUES (95, 1, 2, 3, 2, '3, 5, 7, 23, 0, 24', 8, 8, 1, 4);
INSERT INTO `bubble_sort` VALUES (96, 1, 3, 4, 2, '3, 5, 7, 0, 23, 24', 8, 9, 1, 5);
INSERT INTO `bubble_sort` VALUES (97, 0, 0, 0, 3, '3, 5, 7, 0, 23, 24', 8, 10, 1, 3);
INSERT INTO `bubble_sort` VALUES (98, 0, 0, 0, 3, '3, 5, 7, 0, 23, 24', 8, 11, 1, 4);
INSERT INTO `bubble_sort` VALUES (99, 1, 2, 3, 3, '3, 5, 0, 7, 23, 24', 8, 12, 1, 5);
INSERT INTO `bubble_sort` VALUES (100, 0, 0, 0, 4, '3, 5, 0, 7, 23, 24', 8, 13, 1, 4);
INSERT INTO `bubble_sort` VALUES (101, 1, 1, 2, 4, '3, 0, 5, 7, 23, 24', 8, 14, 1, 5);
INSERT INTO `bubble_sort` VALUES (102, 1, 0, 1, 5, '0, 3, 5, 7, 23, 24', 8, 15, 1, 5);
INSERT INTO `bubble_sort` VALUES (103, 0, 0, 0, 0, '1, 4, 0, 6', 9, 0, 1, 0);
INSERT INTO `bubble_sort` VALUES (104, 0, 0, 0, 1, '1, 4, 0, 6', 9, 1, 1, 1);
INSERT INTO `bubble_sort` VALUES (105, 1, 1, 2, 1, '1, 0, 4, 6', 9, 2, 1, 2);
INSERT INTO `bubble_sort` VALUES (106, 0, 0, 0, 1, '1, 0, 4, 6', 9, 3, 1, 3);
INSERT INTO `bubble_sort` VALUES (107, 1, 0, 1, 2, '0, 1, 4, 6', 9, 4, 1, 2);
INSERT INTO `bubble_sort` VALUES (108, 0, 0, 0, 2, '0, 1, 4, 6', 9, 5, 1, 3);
INSERT INTO `bubble_sort` VALUES (109, 0, 0, 0, 3, '0, 1, 4, 6', 9, 6, 1, 3);
INSERT INTO `bubble_sort` VALUES (110, 0, 0, 0, 0, '13, 2, 7, 9, 42, 6, 4', 10, 0, 1, 0);
INSERT INTO `bubble_sort` VALUES (111, 1, 0, 1, 1, '2, 13, 7, 9, 42, 6, 4', 10, 1, 1, 1);
INSERT INTO `bubble_sort` VALUES (112, 1, 1, 2, 1, '2, 7, 13, 9, 42, 6, 4', 10, 2, 1, 2);
INSERT INTO `bubble_sort` VALUES (113, 1, 2, 3, 1, '2, 7, 9, 13, 42, 6, 4', 10, 3, 1, 3);
INSERT INTO `bubble_sort` VALUES (114, 0, 0, 0, 1, '2, 7, 9, 13, 42, 6, 4', 10, 4, 1, 4);
INSERT INTO `bubble_sort` VALUES (115, 1, 4, 5, 1, '2, 7, 9, 13, 6, 42, 4', 10, 5, 1, 5);
INSERT INTO `bubble_sort` VALUES (116, 1, 5, 6, 1, '2, 7, 9, 13, 6, 4, 42', 10, 6, 1, 6);
INSERT INTO `bubble_sort` VALUES (117, 0, 0, 0, 2, '2, 7, 9, 13, 6, 4, 42', 10, 7, 1, 2);
INSERT INTO `bubble_sort` VALUES (118, 0, 0, 0, 2, '2, 7, 9, 13, 6, 4, 42', 10, 8, 1, 3);
INSERT INTO `bubble_sort` VALUES (119, 0, 0, 0, 2, '2, 7, 9, 13, 6, 4, 42', 10, 9, 1, 4);
INSERT INTO `bubble_sort` VALUES (120, 1, 3, 4, 2, '2, 7, 9, 6, 13, 4, 42', 10, 10, 1, 5);
INSERT INTO `bubble_sort` VALUES (121, 1, 4, 5, 2, '2, 7, 9, 6, 4, 13, 42', 10, 11, 1, 6);
INSERT INTO `bubble_sort` VALUES (122, 0, 0, 0, 3, '2, 7, 9, 6, 4, 13, 42', 10, 12, 1, 3);
INSERT INTO `bubble_sort` VALUES (123, 0, 0, 0, 3, '2, 7, 9, 6, 4, 13, 42', 10, 13, 1, 4);
INSERT INTO `bubble_sort` VALUES (124, 1, 2, 3, 3, '2, 7, 6, 9, 4, 13, 42', 10, 14, 1, 5);
INSERT INTO `bubble_sort` VALUES (125, 1, 3, 4, 3, '2, 7, 6, 4, 9, 13, 42', 10, 15, 1, 6);
INSERT INTO `bubble_sort` VALUES (126, 0, 0, 0, 4, '2, 7, 6, 4, 9, 13, 42', 10, 16, 1, 4);
INSERT INTO `bubble_sort` VALUES (127, 1, 1, 2, 4, '2, 6, 7, 4, 9, 13, 42', 10, 17, 1, 5);
INSERT INTO `bubble_sort` VALUES (128, 1, 2, 3, 4, '2, 6, 4, 7, 9, 13, 42', 10, 18, 1, 6);
INSERT INTO `bubble_sort` VALUES (129, 0, 0, 0, 5, '2, 6, 4, 7, 9, 13, 42', 10, 19, 1, 5);
INSERT INTO `bubble_sort` VALUES (130, 1, 1, 2, 5, '2, 4, 6, 7, 9, 13, 42', 10, 20, 1, 6);
INSERT INTO `bubble_sort` VALUES (131, 0, 0, 0, 6, '2, 4, 6, 7, 9, 13, 42', 10, 21, 1, 6);
INSERT INTO `bubble_sort` VALUES (132, 0, 0, 0, 0, '1, 5, 4, 9, 8, 0, 3, 1', 11, 0, 2, 0);
INSERT INTO `bubble_sort` VALUES (133, 0, 0, 0, 1, '1, 5, 4, 9, 8, 0, 3, 1', 11, 1, 2, 1);
INSERT INTO `bubble_sort` VALUES (134, 1, 1, 2, 1, '1, 4, 5, 9, 8, 0, 3, 1', 11, 2, 2, 2);
INSERT INTO `bubble_sort` VALUES (135, 0, 0, 0, 1, '1, 4, 5, 9, 8, 0, 3, 1', 11, 3, 2, 3);
INSERT INTO `bubble_sort` VALUES (136, 1, 3, 4, 1, '1, 4, 5, 8, 9, 0, 3, 1', 11, 4, 2, 4);
INSERT INTO `bubble_sort` VALUES (137, 1, 4, 5, 1, '1, 4, 5, 8, 0, 9, 3, 1', 11, 5, 2, 5);
INSERT INTO `bubble_sort` VALUES (138, 1, 5, 6, 1, '1, 4, 5, 8, 0, 3, 9, 1', 11, 6, 2, 6);
INSERT INTO `bubble_sort` VALUES (139, 1, 6, 7, 1, '1, 4, 5, 8, 0, 3, 1, 9', 11, 7, 2, 7);
INSERT INTO `bubble_sort` VALUES (140, 0, 0, 0, 2, '1, 4, 5, 8, 0, 3, 1, 9', 11, 8, 2, 2);
INSERT INTO `bubble_sort` VALUES (141, 0, 0, 0, 2, '1, 4, 5, 8, 0, 3, 1, 9', 11, 9, 2, 3);
INSERT INTO `bubble_sort` VALUES (142, 0, 0, 0, 2, '1, 4, 5, 8, 0, 3, 1, 9', 11, 10, 2, 4);
INSERT INTO `bubble_sort` VALUES (143, 1, 3, 4, 2, '1, 4, 5, 0, 8, 3, 1, 9', 11, 11, 2, 5);
INSERT INTO `bubble_sort` VALUES (144, 1, 4, 5, 2, '1, 4, 5, 0, 3, 8, 1, 9', 11, 12, 2, 6);
INSERT INTO `bubble_sort` VALUES (145, 1, 5, 6, 2, '1, 4, 5, 0, 3, 1, 8, 9', 11, 13, 2, 7);
INSERT INTO `bubble_sort` VALUES (146, 0, 0, 0, 3, '1, 4, 5, 0, 3, 1, 8, 9', 11, 14, 2, 3);
INSERT INTO `bubble_sort` VALUES (147, 0, 0, 0, 3, '1, 4, 5, 0, 3, 1, 8, 9', 11, 15, 2, 4);
INSERT INTO `bubble_sort` VALUES (148, 1, 2, 3, 3, '1, 4, 0, 5, 3, 1, 8, 9', 11, 16, 2, 5);
INSERT INTO `bubble_sort` VALUES (149, 1, 3, 4, 3, '1, 4, 0, 3, 5, 1, 8, 9', 11, 17, 2, 6);
INSERT INTO `bubble_sort` VALUES (150, 1, 4, 5, 3, '1, 4, 0, 3, 1, 5, 8, 9', 11, 18, 2, 7);
INSERT INTO `bubble_sort` VALUES (151, 0, 0, 0, 4, '1, 4, 0, 3, 1, 5, 8, 9', 11, 19, 2, 4);
INSERT INTO `bubble_sort` VALUES (152, 1, 1, 2, 4, '1, 0, 4, 3, 1, 5, 8, 9', 11, 20, 2, 5);
INSERT INTO `bubble_sort` VALUES (153, 1, 2, 3, 4, '1, 0, 3, 4, 1, 5, 8, 9', 11, 21, 2, 6);
INSERT INTO `bubble_sort` VALUES (154, 1, 3, 4, 4, '1, 0, 3, 1, 4, 5, 8, 9', 11, 22, 2, 7);
INSERT INTO `bubble_sort` VALUES (155, 1, 0, 1, 5, '0, 1, 3, 1, 4, 5, 8, 9', 11, 23, 2, 5);
INSERT INTO `bubble_sort` VALUES (156, 0, 0, 0, 5, '0, 1, 3, 1, 4, 5, 8, 9', 11, 24, 2, 6);
INSERT INTO `bubble_sort` VALUES (157, 1, 2, 3, 5, '0, 1, 1, 3, 4, 5, 8, 9', 11, 25, 2, 7);
INSERT INTO `bubble_sort` VALUES (158, 0, 0, 0, 6, '0, 1, 1, 3, 4, 5, 8, 9', 11, 26, 2, 6);
INSERT INTO `bubble_sort` VALUES (159, 0, 0, 0, 6, '0, 1, 1, 3, 4, 5, 8, 9', 11, 27, 2, 7);
INSERT INTO `bubble_sort` VALUES (160, 0, 0, 0, 7, '0, 1, 1, 3, 4, 5, 8, 9', 11, 28, 2, 7);
INSERT INTO `bubble_sort` VALUES (161, 0, 0, 0, 0, '3, 9, 0', 12, 0, 2, 0);
INSERT INTO `bubble_sort` VALUES (162, 0, 0, 0, 1, '3, 9, 0', 12, 1, 2, 1);
INSERT INTO `bubble_sort` VALUES (163, 1, 1, 2, 1, '3, 0, 9', 12, 2, 2, 2);
INSERT INTO `bubble_sort` VALUES (164, 1, 0, 1, 2, '0, 3, 9', 12, 3, 2, 2);
INSERT INTO `bubble_sort` VALUES (247, 0, 0, 0, 0, '4, 0, 9, 1', 13, 0, 2, 0);
INSERT INTO `bubble_sort` VALUES (248, 1, 0, 1, 1, '0, 4, 9, 1', 13, 1, 2, 1);
INSERT INTO `bubble_sort` VALUES (249, 0, 0, 0, 1, '0, 4, 9, 1', 13, 2, 2, 2);
INSERT INTO `bubble_sort` VALUES (250, 1, 2, 3, 1, '0, 4, 1, 9', 13, 3, 2, 3);
INSERT INTO `bubble_sort` VALUES (251, 0, 0, 0, 2, '0, 4, 1, 9', 13, 4, 2, 2);
INSERT INTO `bubble_sort` VALUES (252, 1, 1, 2, 2, '0, 1, 4, 9', 13, 5, 2, 3);
INSERT INTO `bubble_sort` VALUES (253, 0, 0, 0, 3, '0, 1, 4, 9', 13, 6, 2, 3);
INSERT INTO `bubble_sort` VALUES (254, 0, 0, 0, 0, '11, 5, 4, 19, 8, 0, 3, 21', 14, 0, 2, 0);
INSERT INTO `bubble_sort` VALUES (255, 1, 0, 1, 1, '5, 11, 4, 19, 8, 0, 3, 21', 14, 1, 2, 1);
INSERT INTO `bubble_sort` VALUES (256, 1, 1, 2, 1, '5, 4, 11, 19, 8, 0, 3, 21', 14, 2, 2, 2);
INSERT INTO `bubble_sort` VALUES (257, 0, 0, 0, 1, '5, 4, 11, 19, 8, 0, 3, 21', 14, 3, 2, 3);
INSERT INTO `bubble_sort` VALUES (258, 1, 3, 4, 1, '5, 4, 11, 8, 19, 0, 3, 21', 14, 4, 2, 4);
INSERT INTO `bubble_sort` VALUES (259, 1, 4, 5, 1, '5, 4, 11, 8, 0, 19, 3, 21', 14, 5, 2, 5);
INSERT INTO `bubble_sort` VALUES (260, 1, 5, 6, 1, '5, 4, 11, 8, 0, 3, 19, 21', 14, 6, 2, 6);
INSERT INTO `bubble_sort` VALUES (261, 0, 0, 0, 1, '5, 4, 11, 8, 0, 3, 19, 21', 14, 7, 2, 7);
INSERT INTO `bubble_sort` VALUES (262, 1, 0, 1, 2, '4, 5, 11, 8, 0, 3, 19, 21', 14, 8, 2, 2);
INSERT INTO `bubble_sort` VALUES (263, 0, 0, 0, 2, '4, 5, 11, 8, 0, 3, 19, 21', 14, 9, 2, 3);
INSERT INTO `bubble_sort` VALUES (264, 1, 2, 3, 2, '4, 5, 8, 11, 0, 3, 19, 21', 14, 10, 2, 4);
INSERT INTO `bubble_sort` VALUES (265, 1, 3, 4, 2, '4, 5, 8, 0, 11, 3, 19, 21', 14, 11, 2, 5);
INSERT INTO `bubble_sort` VALUES (266, 1, 4, 5, 2, '4, 5, 8, 0, 3, 11, 19, 21', 14, 12, 2, 6);
INSERT INTO `bubble_sort` VALUES (267, 0, 0, 0, 2, '4, 5, 8, 0, 3, 11, 19, 21', 14, 13, 2, 7);
INSERT INTO `bubble_sort` VALUES (268, 0, 0, 0, 3, '4, 5, 8, 0, 3, 11, 19, 21', 14, 14, 2, 3);
INSERT INTO `bubble_sort` VALUES (269, 0, 0, 0, 3, '4, 5, 8, 0, 3, 11, 19, 21', 14, 15, 2, 4);
INSERT INTO `bubble_sort` VALUES (270, 1, 2, 3, 3, '4, 5, 0, 8, 3, 11, 19, 21', 14, 16, 2, 5);
INSERT INTO `bubble_sort` VALUES (271, 1, 3, 4, 3, '4, 5, 0, 3, 8, 11, 19, 21', 14, 17, 2, 6);
INSERT INTO `bubble_sort` VALUES (272, 0, 0, 0, 3, '4, 5, 0, 3, 8, 11, 19, 21', 14, 18, 2, 7);
INSERT INTO `bubble_sort` VALUES (273, 0, 0, 0, 4, '4, 5, 0, 3, 8, 11, 19, 21', 14, 19, 2, 4);
INSERT INTO `bubble_sort` VALUES (274, 1, 1, 2, 4, '4, 0, 5, 3, 8, 11, 19, 21', 14, 20, 2, 5);
INSERT INTO `bubble_sort` VALUES (275, 1, 2, 3, 4, '4, 0, 3, 5, 8, 11, 19, 21', 14, 21, 2, 6);
INSERT INTO `bubble_sort` VALUES (276, 0, 0, 0, 4, '4, 0, 3, 5, 8, 11, 19, 21', 14, 22, 2, 7);
INSERT INTO `bubble_sort` VALUES (277, 1, 0, 1, 5, '0, 4, 3, 5, 8, 11, 19, 21', 14, 23, 2, 5);
INSERT INTO `bubble_sort` VALUES (278, 1, 1, 2, 5, '0, 3, 4, 5, 8, 11, 19, 21', 14, 24, 2, 6);
INSERT INTO `bubble_sort` VALUES (279, 0, 0, 0, 5, '0, 3, 4, 5, 8, 11, 19, 21', 14, 25, 2, 7);
INSERT INTO `bubble_sort` VALUES (280, 0, 0, 0, 6, '0, 3, 4, 5, 8, 11, 19, 21', 14, 26, 2, 6);
INSERT INTO `bubble_sort` VALUES (281, 0, 0, 0, 6, '0, 3, 4, 5, 8, 11, 19, 21', 14, 27, 2, 7);
INSERT INTO `bubble_sort` VALUES (282, 0, 0, 0, 7, '0, 3, 4, 5, 8, 11, 19, 21', 14, 28, 2, 7);

-- ----------------------------
-- Table structure for insert_sort
-- ----------------------------
DROP TABLE IF EXISTS `insert_sort`;
CREATE TABLE `insert_sort`  (
  `insert_id` int NOT NULL AUTO_INCREMENT,
  `pivot` int NOT NULL,
  `order_pos` int NOT NULL,
  `sorted_list` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `unsorted_list` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `curr_list` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `practice_id` int NOT NULL,
  `process_num` int NOT NULL,
  `turn` int NOT NULL,
  `user_id` int NOT NULL,
  `process_step` int NOT NULL,
  PRIMARY KEY (`insert_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `insert_sort_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of insert_sort
-- ----------------------------
INSERT INTO `insert_sort` VALUES (1, 0, 0, '', '5, 2, 8, 1, 4', '5, 2, 8, 1, 4', 1, 0, 0, 1, 0);
INSERT INTO `insert_sort` VALUES (2, 5, 0, '5', '2, 8, 1, 4', '5, 2, 8, 1, 4', 1, 1, 1, 1, 1);
INSERT INTO `insert_sort` VALUES (3, 2, 1, '5, 2', '8, 1, 4', '5, 2, 8, 1, 4', 1, 2, 2, 1, 2);
INSERT INTO `insert_sort` VALUES (4, 2, 0, '2, 5', '8, 1, 4', '2, 5, 8, 1, 4', 1, 3, 2, 1, 1);
INSERT INTO `insert_sort` VALUES (5, 8, 2, '2, 5, 8', '1, 4', '2, 5, 8, 1, 4', 1, 4, 3, 1, 3);
INSERT INTO `insert_sort` VALUES (6, 1, 3, '2, 5, 8, 1', '4', '2, 5, 8, 1, 4', 1, 5, 4, 1, 4);
INSERT INTO `insert_sort` VALUES (7, 1, 2, '2, 5, 1, 8', '4', '2, 5, 1, 8, 4', 1, 6, 4, 1, 3);
INSERT INTO `insert_sort` VALUES (8, 1, 1, '2, 1, 5, 8', '4', '2, 1, 5, 8, 4', 1, 7, 4, 1, 2);
INSERT INTO `insert_sort` VALUES (9, 1, 0, '1, 2, 5, 8', '4', '1, 2, 5, 8, 4', 1, 8, 4, 1, 1);
INSERT INTO `insert_sort` VALUES (10, 4, 4, '1, 2, 5, 8, 4', '', '1, 2, 5, 8, 4', 1, 9, 5, 1, 5);
INSERT INTO `insert_sort` VALUES (11, 4, 3, '1, 2, 5, 4, 8', '', '1, 2, 5, 4, 8', 1, 10, 5, 1, 4);
INSERT INTO `insert_sort` VALUES (12, 4, 2, '1, 2, 4, 5, 8', '', '1, 2, 4, 5, 8', 1, 11, 5, 1, 3);
INSERT INTO `insert_sort` VALUES (13, 0, 0, '', '5, 1, 3', '5, 1, 3', 2, 0, 0, 1, 0);
INSERT INTO `insert_sort` VALUES (14, 5, 0, '5', '1, 3', '5, 1, 3', 2, 1, 1, 1, 1);
INSERT INTO `insert_sort` VALUES (15, 1, 1, '5, 1', '3', '5, 1, 3', 2, 2, 2, 1, 2);
INSERT INTO `insert_sort` VALUES (16, 1, 0, '1, 5', '3', '1, 5, 3', 2, 3, 2, 1, 1);
INSERT INTO `insert_sort` VALUES (17, 3, 2, '1, 5, 3', '', '1, 5, 3', 2, 4, 3, 1, 3);
INSERT INTO `insert_sort` VALUES (18, 3, 1, '1, 3, 5', '', '1, 3, 5', 2, 5, 3, 1, 2);
INSERT INTO `insert_sort` VALUES (19, 0, 0, '', '4, 2, 8, 6, 5', '4, 2, 8, 6, 5', 3, 0, 0, 1, 0);
INSERT INTO `insert_sort` VALUES (20, 4, 0, '4', '2, 8, 6, 5', '4, 2, 8, 6, 5', 3, 1, 1, 1, 1);
INSERT INTO `insert_sort` VALUES (21, 2, 1, '4, 2', '8, 6, 5', '4, 2, 8, 6, 5', 3, 2, 2, 1, 2);
INSERT INTO `insert_sort` VALUES (22, 2, 0, '2, 4', '8, 6, 5', '2, 4, 8, 6, 5', 3, 3, 2, 1, 1);
INSERT INTO `insert_sort` VALUES (23, 8, 2, '2, 4, 8', '6, 5', '2, 4, 8, 6, 5', 3, 4, 3, 1, 3);
INSERT INTO `insert_sort` VALUES (24, 6, 3, '2, 4, 8, 6', '5', '2, 4, 8, 6, 5', 3, 5, 4, 1, 4);
INSERT INTO `insert_sort` VALUES (25, 6, 2, '2, 4, 6, 8', '5', '2, 4, 6, 8, 5', 3, 6, 4, 1, 3);
INSERT INTO `insert_sort` VALUES (26, 5, 4, '2, 4, 6, 8, 5', '', '2, 4, 6, 8, 5', 3, 7, 5, 1, 5);
INSERT INTO `insert_sort` VALUES (27, 5, 3, '2, 4, 6, 5, 8', '', '2, 4, 6, 5, 8', 3, 8, 5, 1, 4);
INSERT INTO `insert_sort` VALUES (28, 5, 2, '2, 4, 5, 6, 8', '', '2, 4, 5, 6, 8', 3, 9, 5, 1, 3);
INSERT INTO `insert_sort` VALUES (29, 0, 0, '', '4, 9, 0, 3, 1, 5', '4, 9, 0, 3, 1, 5', 4, 0, 0, 1, 0);
INSERT INTO `insert_sort` VALUES (30, 4, 0, '4', '9, 0, 3, 1, 5', '4, 9, 0, 3, 1, 5', 4, 1, 1, 1, 1);
INSERT INTO `insert_sort` VALUES (31, 9, 1, '4, 9', '0, 3, 1, 5', '4, 9, 0, 3, 1, 5', 4, 2, 2, 1, 2);
INSERT INTO `insert_sort` VALUES (32, 0, 2, '4, 9, 0', '3, 1, 5', '4, 9, 0, 3, 1, 5', 4, 3, 3, 1, 3);
INSERT INTO `insert_sort` VALUES (33, 0, 1, '4, 0, 9', '3, 1, 5', '4, 0, 9, 3, 1, 5', 4, 4, 3, 1, 2);
INSERT INTO `insert_sort` VALUES (34, 0, 0, '0, 4, 9', '3, 1, 5', '0, 4, 9, 3, 1, 5', 4, 5, 3, 1, 1);
INSERT INTO `insert_sort` VALUES (35, 3, 3, '0, 4, 9, 3', '1, 5', '0, 4, 9, 3, 1, 5', 4, 6, 4, 1, 4);
INSERT INTO `insert_sort` VALUES (36, 3, 2, '0, 4, 3, 9', '1, 5', '0, 4, 3, 9, 1, 5', 4, 7, 4, 1, 3);
INSERT INTO `insert_sort` VALUES (37, 3, 1, '0, 3, 4, 9', '1, 5', '0, 3, 4, 9, 1, 5', 4, 8, 4, 1, 2);
INSERT INTO `insert_sort` VALUES (38, 1, 4, '0, 3, 4, 9, 1', '5', '0, 3, 4, 9, 1, 5', 4, 9, 5, 1, 5);
INSERT INTO `insert_sort` VALUES (39, 1, 3, '0, 3, 4, 1, 9', '5', '0, 3, 4, 1, 9, 5', 4, 10, 5, 1, 4);
INSERT INTO `insert_sort` VALUES (40, 1, 2, '0, 3, 1, 4, 9', '5', '0, 3, 1, 4, 9, 5', 4, 11, 5, 1, 3);
INSERT INTO `insert_sort` VALUES (41, 1, 1, '0, 1, 3, 4, 9', '5', '0, 1, 3, 4, 9, 5', 4, 12, 5, 1, 2);
INSERT INTO `insert_sort` VALUES (42, 5, 5, '0, 1, 3, 4, 9, 5', '', '0, 1, 3, 4, 9, 5', 4, 13, 6, 1, 6);
INSERT INTO `insert_sort` VALUES (43, 5, 4, '0, 1, 3, 4, 5, 9', '', '0, 1, 3, 4, 5, 9', 4, 14, 6, 1, 5);
INSERT INTO `insert_sort` VALUES (44, 0, 0, '', '1, 5, 0, 4, 7', '1, 5, 0, 4, 7', 5, 0, 0, 1, 0);
INSERT INTO `insert_sort` VALUES (45, 1, 0, '1', '5, 0, 4, 7', '1, 5, 0, 4, 7', 5, 1, 1, 1, 1);
INSERT INTO `insert_sort` VALUES (46, 5, 1, '1, 5', '0, 4, 7', '1, 5, 0, 4, 7', 5, 2, 2, 1, 2);
INSERT INTO `insert_sort` VALUES (47, 0, 2, '1, 5, 0', '4, 7', '1, 5, 0, 4, 7', 5, 3, 3, 1, 3);
INSERT INTO `insert_sort` VALUES (48, 0, 1, '1, 0, 5', '4, 7', '1, 0, 5, 4, 7', 5, 4, 3, 1, 2);
INSERT INTO `insert_sort` VALUES (49, 0, 0, '0, 1, 5', '4, 7', '0, 1, 5, 4, 7', 5, 5, 3, 1, 1);
INSERT INTO `insert_sort` VALUES (50, 4, 3, '0, 1, 5, 4', '7', '0, 1, 5, 4, 7', 5, 6, 4, 1, 4);
INSERT INTO `insert_sort` VALUES (51, 4, 2, '0, 1, 4, 5', '7', '0, 1, 4, 5, 7', 5, 7, 4, 1, 3);
INSERT INTO `insert_sort` VALUES (52, 7, 4, '0, 1, 4, 5, 7', '', '0, 1, 4, 5, 7', 5, 8, 5, 1, 5);
INSERT INTO `insert_sort` VALUES (53, 0, 0, '', '3, 4, 0, 2, 1', '3, 4, 0, 2, 1', 6, 0, 0, 1, 0);
INSERT INTO `insert_sort` VALUES (54, 3, 0, '3', '4, 0, 2, 1', '3, 4, 0, 2, 1', 6, 1, 1, 1, 1);
INSERT INTO `insert_sort` VALUES (55, 4, 1, '3, 4', '0, 2, 1', '3, 4, 0, 2, 1', 6, 2, 2, 1, 2);
INSERT INTO `insert_sort` VALUES (56, 0, 2, '3, 4, 0', '2, 1', '3, 4, 0, 2, 1', 6, 3, 3, 1, 3);
INSERT INTO `insert_sort` VALUES (57, 0, 1, '3, 0, 4', '2, 1', '3, 0, 4, 2, 1', 6, 4, 3, 1, 2);
INSERT INTO `insert_sort` VALUES (58, 0, 0, '0, 3, 4', '2, 1', '0, 3, 4, 2, 1', 6, 5, 3, 1, 1);
INSERT INTO `insert_sort` VALUES (59, 2, 3, '0, 3, 4, 2', '1', '0, 3, 4, 2, 1', 6, 6, 4, 1, 4);
INSERT INTO `insert_sort` VALUES (60, 2, 2, '0, 3, 2, 4', '1', '0, 3, 2, 4, 1', 6, 7, 4, 1, 3);
INSERT INTO `insert_sort` VALUES (61, 2, 1, '0, 2, 3, 4', '1', '0, 2, 3, 4, 1', 6, 8, 4, 1, 2);
INSERT INTO `insert_sort` VALUES (62, 1, 4, '0, 2, 3, 4, 1', '', '0, 2, 3, 4, 1', 6, 9, 5, 1, 5);
INSERT INTO `insert_sort` VALUES (63, 1, 3, '0, 2, 3, 1, 4', '', '0, 2, 3, 1, 4', 6, 10, 5, 1, 4);
INSERT INTO `insert_sort` VALUES (64, 1, 2, '0, 2, 1, 3, 4', '', '0, 2, 1, 3, 4', 6, 11, 5, 1, 3);
INSERT INTO `insert_sort` VALUES (65, 1, 1, '0, 1, 2, 3, 4', '', '0, 1, 2, 3, 4', 6, 12, 5, 1, 2);
INSERT INTO `insert_sort` VALUES (66, 0, 0, '', '3, 14, 2, 7, 21, 6, 8', '3, 14, 2, 7, 21, 6, 8', 7, 0, 0, 1, 0);
INSERT INTO `insert_sort` VALUES (67, 3, 0, '3', '14, 2, 7, 21, 6, 8', '3, 14, 2, 7, 21, 6, 8', 7, 1, 1, 1, 1);
INSERT INTO `insert_sort` VALUES (68, 14, 1, '3, 14', '2, 7, 21, 6, 8', '3, 14, 2, 7, 21, 6, 8', 7, 2, 2, 1, 2);
INSERT INTO `insert_sort` VALUES (69, 2, 2, '3, 14, 2', '7, 21, 6, 8', '3, 14, 2, 7, 21, 6, 8', 7, 3, 3, 1, 3);
INSERT INTO `insert_sort` VALUES (70, 2, 1, '3, 2, 14', '7, 21, 6, 8', '3, 2, 14, 7, 21, 6, 8', 7, 4, 3, 1, 2);
INSERT INTO `insert_sort` VALUES (71, 2, 0, '2, 3, 14', '7, 21, 6, 8', '2, 3, 14, 7, 21, 6, 8', 7, 5, 3, 1, 1);
INSERT INTO `insert_sort` VALUES (72, 7, 3, '2, 3, 14, 7', '21, 6, 8', '2, 3, 14, 7, 21, 6, 8', 7, 6, 4, 1, 4);
INSERT INTO `insert_sort` VALUES (73, 7, 2, '2, 3, 7, 14', '21, 6, 8', '2, 3, 7, 14, 21, 6, 8', 7, 7, 4, 1, 3);
INSERT INTO `insert_sort` VALUES (74, 21, 4, '2, 3, 7, 14, 21', '6, 8', '2, 3, 7, 14, 21, 6, 8', 7, 8, 5, 1, 5);
INSERT INTO `insert_sort` VALUES (75, 6, 5, '2, 3, 7, 14, 21, 6', '8', '2, 3, 7, 14, 21, 6, 8', 7, 9, 6, 1, 6);
INSERT INTO `insert_sort` VALUES (76, 6, 4, '2, 3, 7, 14, 6, 21', '8', '2, 3, 7, 14, 6, 21, 8', 7, 10, 6, 1, 5);
INSERT INTO `insert_sort` VALUES (77, 6, 3, '2, 3, 7, 6, 14, 21', '8', '2, 3, 7, 6, 14, 21, 8', 7, 11, 6, 1, 4);
INSERT INTO `insert_sort` VALUES (78, 6, 2, '2, 3, 6, 7, 14, 21', '8', '2, 3, 6, 7, 14, 21, 8', 7, 12, 6, 1, 3);
INSERT INTO `insert_sort` VALUES (79, 8, 6, '2, 3, 6, 7, 14, 21, 8', '', '2, 3, 6, 7, 14, 21, 8', 7, 13, 7, 1, 7);
INSERT INTO `insert_sort` VALUES (80, 8, 5, '2, 3, 6, 7, 14, 8, 21', '', '2, 3, 6, 7, 14, 8, 21', 7, 14, 7, 1, 6);
INSERT INTO `insert_sort` VALUES (81, 8, 4, '2, 3, 6, 7, 8, 14, 21', '', '2, 3, 6, 7, 8, 14, 21', 7, 15, 7, 1, 5);
INSERT INTO `insert_sort` VALUES (82, 0, 0, '', '3, 24, 5, 23, 7, 0', '3, 24, 5, 23, 7, 0', 8, 0, 0, 1, 0);
INSERT INTO `insert_sort` VALUES (83, 3, 0, '3', '24, 5, 23, 7, 0', '3, 24, 5, 23, 7, 0', 8, 1, 1, 1, 1);
INSERT INTO `insert_sort` VALUES (84, 24, 1, '3, 24', '5, 23, 7, 0', '3, 24, 5, 23, 7, 0', 8, 2, 2, 1, 2);
INSERT INTO `insert_sort` VALUES (85, 5, 2, '3, 24, 5', '23, 7, 0', '3, 24, 5, 23, 7, 0', 8, 3, 3, 1, 3);
INSERT INTO `insert_sort` VALUES (86, 5, 1, '3, 5, 24', '23, 7, 0', '3, 5, 24, 23, 7, 0', 8, 4, 3, 1, 2);
INSERT INTO `insert_sort` VALUES (87, 23, 3, '3, 5, 24, 23', '7, 0', '3, 5, 24, 23, 7, 0', 8, 5, 4, 1, 4);
INSERT INTO `insert_sort` VALUES (88, 23, 2, '3, 5, 23, 24', '7, 0', '3, 5, 23, 24, 7, 0', 8, 6, 4, 1, 3);
INSERT INTO `insert_sort` VALUES (89, 7, 4, '3, 5, 23, 24, 7', '0', '3, 5, 23, 24, 7, 0', 8, 7, 5, 1, 5);
INSERT INTO `insert_sort` VALUES (90, 7, 3, '3, 5, 23, 7, 24', '0', '3, 5, 23, 7, 24, 0', 8, 8, 5, 1, 4);
INSERT INTO `insert_sort` VALUES (91, 7, 2, '3, 5, 7, 23, 24', '0', '3, 5, 7, 23, 24, 0', 8, 9, 5, 1, 3);
INSERT INTO `insert_sort` VALUES (92, 0, 5, '3, 5, 7, 23, 24, 0', '', '3, 5, 7, 23, 24, 0', 8, 10, 6, 1, 6);
INSERT INTO `insert_sort` VALUES (93, 0, 4, '3, 5, 7, 23, 0, 24', '', '3, 5, 7, 23, 0, 24', 8, 11, 6, 1, 5);
INSERT INTO `insert_sort` VALUES (94, 0, 3, '3, 5, 7, 0, 23, 24', '', '3, 5, 7, 0, 23, 24', 8, 12, 6, 1, 4);
INSERT INTO `insert_sort` VALUES (95, 0, 2, '3, 5, 0, 7, 23, 24', '', '3, 5, 0, 7, 23, 24', 8, 13, 6, 1, 3);
INSERT INTO `insert_sort` VALUES (96, 0, 1, '3, 0, 5, 7, 23, 24', '', '3, 0, 5, 7, 23, 24', 8, 14, 6, 1, 2);
INSERT INTO `insert_sort` VALUES (97, 0, 0, '0, 3, 5, 7, 23, 24', '', '0, 3, 5, 7, 23, 24', 8, 15, 6, 1, 1);
INSERT INTO `insert_sort` VALUES (98, 0, 0, '', '1, 4, 0, 6', '1, 4, 0, 6', 9, 0, 0, 1, 0);
INSERT INTO `insert_sort` VALUES (99, 1, 0, '1', '4, 0, 6', '1, 4, 0, 6', 9, 1, 1, 1, 1);
INSERT INTO `insert_sort` VALUES (100, 4, 1, '1, 4', '0, 6', '1, 4, 0, 6', 9, 2, 2, 1, 2);
INSERT INTO `insert_sort` VALUES (101, 0, 2, '1, 4, 0', '6', '1, 4, 0, 6', 9, 3, 3, 1, 3);
INSERT INTO `insert_sort` VALUES (102, 0, 1, '1, 0, 4', '6', '1, 0, 4, 6', 9, 4, 3, 1, 2);
INSERT INTO `insert_sort` VALUES (103, 0, 0, '0, 1, 4', '6', '0, 1, 4, 6', 9, 5, 3, 1, 1);
INSERT INTO `insert_sort` VALUES (104, 6, 3, '0, 1, 4, 6', '', '0, 1, 4, 6', 9, 6, 4, 1, 4);
INSERT INTO `insert_sort` VALUES (105, 0, 0, '', '13, 2, 7, 9, 42, 6, 4', '13, 2, 7, 9, 42, 6, 4', 10, 0, 0, 1, 0);
INSERT INTO `insert_sort` VALUES (106, 13, 0, '13', '2, 7, 9, 42, 6, 4', '13, 2, 7, 9, 42, 6, 4', 10, 1, 1, 1, 1);
INSERT INTO `insert_sort` VALUES (107, 2, 1, '13, 2', '7, 9, 42, 6, 4', '13, 2, 7, 9, 42, 6, 4', 10, 2, 2, 1, 2);
INSERT INTO `insert_sort` VALUES (108, 2, 0, '2, 13', '7, 9, 42, 6, 4', '2, 13, 7, 9, 42, 6, 4', 10, 3, 2, 1, 1);
INSERT INTO `insert_sort` VALUES (109, 7, 2, '2, 13, 7', '9, 42, 6, 4', '2, 13, 7, 9, 42, 6, 4', 10, 4, 3, 1, 3);
INSERT INTO `insert_sort` VALUES (110, 7, 1, '2, 7, 13', '9, 42, 6, 4', '2, 7, 13, 9, 42, 6, 4', 10, 5, 3, 1, 2);
INSERT INTO `insert_sort` VALUES (111, 9, 3, '2, 7, 13, 9', '42, 6, 4', '2, 7, 13, 9, 42, 6, 4', 10, 6, 4, 1, 4);
INSERT INTO `insert_sort` VALUES (112, 9, 2, '2, 7, 9, 13', '42, 6, 4', '2, 7, 9, 13, 42, 6, 4', 10, 7, 4, 1, 3);
INSERT INTO `insert_sort` VALUES (113, 42, 4, '2, 7, 9, 13, 42', '6, 4', '2, 7, 9, 13, 42, 6, 4', 10, 8, 5, 1, 5);
INSERT INTO `insert_sort` VALUES (114, 6, 5, '2, 7, 9, 13, 42, 6', '4', '2, 7, 9, 13, 42, 6, 4', 10, 9, 6, 1, 6);
INSERT INTO `insert_sort` VALUES (115, 6, 4, '2, 7, 9, 13, 6, 42', '4', '2, 7, 9, 13, 6, 42, 4', 10, 10, 6, 1, 5);
INSERT INTO `insert_sort` VALUES (116, 6, 3, '2, 7, 9, 6, 13, 42', '4', '2, 7, 9, 6, 13, 42, 4', 10, 11, 6, 1, 4);
INSERT INTO `insert_sort` VALUES (117, 6, 2, '2, 7, 6, 9, 13, 42', '4', '2, 7, 6, 9, 13, 42, 4', 10, 12, 6, 1, 3);
INSERT INTO `insert_sort` VALUES (118, 6, 1, '2, 6, 7, 9, 13, 42', '4', '2, 6, 7, 9, 13, 42, 4', 10, 13, 6, 1, 2);
INSERT INTO `insert_sort` VALUES (119, 4, 6, '2, 6, 7, 9, 13, 42, 4', '', '2, 6, 7, 9, 13, 42, 4', 10, 14, 7, 1, 7);
INSERT INTO `insert_sort` VALUES (120, 4, 5, '2, 6, 7, 9, 13, 4, 42', '', '2, 6, 7, 9, 13, 4, 42', 10, 15, 7, 1, 6);
INSERT INTO `insert_sort` VALUES (121, 4, 4, '2, 6, 7, 9, 4, 13, 42', '', '2, 6, 7, 9, 4, 13, 42', 10, 16, 7, 1, 5);
INSERT INTO `insert_sort` VALUES (122, 4, 3, '2, 6, 7, 4, 9, 13, 42', '', '2, 6, 7, 4, 9, 13, 42', 10, 17, 7, 1, 4);
INSERT INTO `insert_sort` VALUES (123, 4, 2, '2, 6, 4, 7, 9, 13, 42', '', '2, 6, 4, 7, 9, 13, 42', 10, 18, 7, 1, 3);
INSERT INTO `insert_sort` VALUES (124, 4, 1, '2, 4, 6, 7, 9, 13, 42', '', '2, 4, 6, 7, 9, 13, 42', 10, 19, 7, 1, 2);
INSERT INTO `insert_sort` VALUES (125, 0, 0, '', '1, 5, 4, 9, 8, 0, 3, 1', '1, 5, 4, 9, 8, 0, 3, 1', 11, 0, 0, 2, 0);
INSERT INTO `insert_sort` VALUES (126, 1, 0, '1', '5, 4, 9, 8, 0, 3, 1', '1, 5, 4, 9, 8, 0, 3, 1', 11, 1, 1, 2, 1);
INSERT INTO `insert_sort` VALUES (127, 5, 1, '1, 5', '4, 9, 8, 0, 3, 1', '1, 5, 4, 9, 8, 0, 3, 1', 11, 2, 2, 2, 2);
INSERT INTO `insert_sort` VALUES (128, 4, 2, '1, 5, 4', '9, 8, 0, 3, 1', '1, 5, 4, 9, 8, 0, 3, 1', 11, 3, 3, 2, 3);
INSERT INTO `insert_sort` VALUES (129, 4, 1, '1, 4, 5', '9, 8, 0, 3, 1', '1, 4, 5, 9, 8, 0, 3, 1', 11, 4, 3, 2, 2);
INSERT INTO `insert_sort` VALUES (130, 9, 3, '1, 4, 5, 9', '8, 0, 3, 1', '1, 4, 5, 9, 8, 0, 3, 1', 11, 5, 4, 2, 4);
INSERT INTO `insert_sort` VALUES (131, 8, 4, '1, 4, 5, 9, 8', '0, 3, 1', '1, 4, 5, 9, 8, 0, 3, 1', 11, 6, 5, 2, 5);
INSERT INTO `insert_sort` VALUES (132, 8, 3, '1, 4, 5, 8, 9', '0, 3, 1', '1, 4, 5, 8, 9, 0, 3, 1', 11, 7, 5, 2, 4);
INSERT INTO `insert_sort` VALUES (133, 0, 5, '1, 4, 5, 8, 9, 0', '3, 1', '1, 4, 5, 8, 9, 0, 3, 1', 11, 8, 6, 2, 6);
INSERT INTO `insert_sort` VALUES (134, 0, 4, '1, 4, 5, 8, 0, 9', '3, 1', '1, 4, 5, 8, 0, 9, 3, 1', 11, 9, 6, 2, 5);
INSERT INTO `insert_sort` VALUES (135, 0, 3, '1, 4, 5, 0, 8, 9', '3, 1', '1, 4, 5, 0, 8, 9, 3, 1', 11, 10, 6, 2, 4);
INSERT INTO `insert_sort` VALUES (136, 0, 2, '1, 4, 0, 5, 8, 9', '3, 1', '1, 4, 0, 5, 8, 9, 3, 1', 11, 11, 6, 2, 3);
INSERT INTO `insert_sort` VALUES (137, 0, 1, '1, 0, 4, 5, 8, 9', '3, 1', '1, 0, 4, 5, 8, 9, 3, 1', 11, 12, 6, 2, 2);
INSERT INTO `insert_sort` VALUES (138, 0, 0, '0, 1, 4, 5, 8, 9', '3, 1', '0, 1, 4, 5, 8, 9, 3, 1', 11, 13, 6, 2, 1);
INSERT INTO `insert_sort` VALUES (139, 3, 6, '0, 1, 4, 5, 8, 9, 3', '1', '0, 1, 4, 5, 8, 9, 3, 1', 11, 14, 7, 2, 7);
INSERT INTO `insert_sort` VALUES (140, 3, 5, '0, 1, 4, 5, 8, 3, 9', '1', '0, 1, 4, 5, 8, 3, 9, 1', 11, 15, 7, 2, 6);
INSERT INTO `insert_sort` VALUES (141, 3, 4, '0, 1, 4, 5, 3, 8, 9', '1', '0, 1, 4, 5, 3, 8, 9, 1', 11, 16, 7, 2, 5);
INSERT INTO `insert_sort` VALUES (142, 3, 3, '0, 1, 4, 3, 5, 8, 9', '1', '0, 1, 4, 3, 5, 8, 9, 1', 11, 17, 7, 2, 4);
INSERT INTO `insert_sort` VALUES (143, 3, 2, '0, 1, 3, 4, 5, 8, 9', '1', '0, 1, 3, 4, 5, 8, 9, 1', 11, 18, 7, 2, 3);
INSERT INTO `insert_sort` VALUES (144, 1, 7, '0, 1, 3, 4, 5, 8, 9, 1', '', '0, 1, 3, 4, 5, 8, 9, 1', 11, 19, 8, 2, 8);
INSERT INTO `insert_sort` VALUES (145, 1, 6, '0, 1, 3, 4, 5, 8, 1, 9', '', '0, 1, 3, 4, 5, 8, 1, 9', 11, 20, 8, 2, 7);
INSERT INTO `insert_sort` VALUES (146, 1, 5, '0, 1, 3, 4, 5, 1, 8, 9', '', '0, 1, 3, 4, 5, 1, 8, 9', 11, 21, 8, 2, 6);
INSERT INTO `insert_sort` VALUES (147, 1, 4, '0, 1, 3, 4, 1, 5, 8, 9', '', '0, 1, 3, 4, 1, 5, 8, 9', 11, 22, 8, 2, 5);
INSERT INTO `insert_sort` VALUES (148, 1, 3, '0, 1, 3, 1, 4, 5, 8, 9', '', '0, 1, 3, 1, 4, 5, 8, 9', 11, 23, 8, 2, 4);
INSERT INTO `insert_sort` VALUES (149, 1, 2, '0, 1, 1, 3, 4, 5, 8, 9', '', '0, 1, 1, 3, 4, 5, 8, 9', 11, 24, 8, 2, 3);
INSERT INTO `insert_sort` VALUES (150, 0, 0, '', '3, 9, 0', '3, 9, 0', 12, 0, 0, 2, 0);
INSERT INTO `insert_sort` VALUES (151, 3, 0, '3', '9, 0', '3, 9, 0', 12, 1, 1, 2, 1);
INSERT INTO `insert_sort` VALUES (152, 9, 1, '3, 9', '0', '3, 9, 0', 12, 2, 2, 2, 2);
INSERT INTO `insert_sort` VALUES (153, 0, 2, '3, 9, 0', '', '3, 9, 0', 12, 3, 3, 2, 3);
INSERT INTO `insert_sort` VALUES (154, 0, 1, '3, 0, 9', '', '3, 0, 9', 12, 4, 3, 2, 2);
INSERT INTO `insert_sort` VALUES (155, 0, 0, '0, 3, 9', '', '0, 3, 9', 12, 5, 3, 2, 1);
INSERT INTO `insert_sort` VALUES (242, 0, 0, '', '4, 0, 9, 1', '4, 0, 9, 1', 13, 0, 0, 2, 0);
INSERT INTO `insert_sort` VALUES (243, 4, 0, '4', '0, 9, 1', '4, 0, 9, 1', 13, 1, 1, 2, 1);
INSERT INTO `insert_sort` VALUES (244, 0, 1, '4, 0', '9, 1', '4, 0, 9, 1', 13, 2, 2, 2, 2);
INSERT INTO `insert_sort` VALUES (245, 0, 0, '0, 4', '9, 1', '0, 4, 9, 1', 13, 3, 2, 2, 1);
INSERT INTO `insert_sort` VALUES (246, 9, 2, '0, 4, 9', '1', '0, 4, 9, 1', 13, 4, 3, 2, 3);
INSERT INTO `insert_sort` VALUES (247, 1, 3, '0, 4, 9, 1', '', '0, 4, 9, 1', 13, 5, 4, 2, 4);
INSERT INTO `insert_sort` VALUES (248, 1, 2, '0, 4, 1, 9', '', '0, 4, 1, 9', 13, 6, 4, 2, 3);
INSERT INTO `insert_sort` VALUES (249, 1, 1, '0, 1, 4, 9', '', '0, 1, 4, 9', 13, 7, 4, 2, 2);
INSERT INTO `insert_sort` VALUES (250, 0, 0, '', '11, 5, 4, 19, 8, 0, 3, 21', '11, 5, 4, 19, 8, 0, 3, 21', 14, 0, 0, 2, 0);
INSERT INTO `insert_sort` VALUES (251, 11, 0, '11', '5, 4, 19, 8, 0, 3, 21', '11, 5, 4, 19, 8, 0, 3, 21', 14, 1, 1, 2, 1);
INSERT INTO `insert_sort` VALUES (252, 5, 1, '11, 5', '4, 19, 8, 0, 3, 21', '11, 5, 4, 19, 8, 0, 3, 21', 14, 2, 2, 2, 2);
INSERT INTO `insert_sort` VALUES (253, 5, 0, '5, 11', '4, 19, 8, 0, 3, 21', '5, 11, 4, 19, 8, 0, 3, 21', 14, 3, 2, 2, 1);
INSERT INTO `insert_sort` VALUES (254, 4, 2, '5, 11, 4', '19, 8, 0, 3, 21', '5, 11, 4, 19, 8, 0, 3, 21', 14, 4, 3, 2, 3);
INSERT INTO `insert_sort` VALUES (255, 4, 1, '5, 4, 11', '19, 8, 0, 3, 21', '5, 4, 11, 19, 8, 0, 3, 21', 14, 5, 3, 2, 2);
INSERT INTO `insert_sort` VALUES (256, 4, 0, '4, 5, 11', '19, 8, 0, 3, 21', '4, 5, 11, 19, 8, 0, 3, 21', 14, 6, 3, 2, 1);
INSERT INTO `insert_sort` VALUES (257, 19, 3, '4, 5, 11, 19', '8, 0, 3, 21', '4, 5, 11, 19, 8, 0, 3, 21', 14, 7, 4, 2, 4);
INSERT INTO `insert_sort` VALUES (258, 8, 4, '4, 5, 11, 19, 8', '0, 3, 21', '4, 5, 11, 19, 8, 0, 3, 21', 14, 8, 5, 2, 5);
INSERT INTO `insert_sort` VALUES (259, 8, 3, '4, 5, 11, 8, 19', '0, 3, 21', '4, 5, 11, 8, 19, 0, 3, 21', 14, 9, 5, 2, 4);
INSERT INTO `insert_sort` VALUES (260, 8, 2, '4, 5, 8, 11, 19', '0, 3, 21', '4, 5, 8, 11, 19, 0, 3, 21', 14, 10, 5, 2, 3);
INSERT INTO `insert_sort` VALUES (261, 0, 5, '4, 5, 8, 11, 19, 0', '3, 21', '4, 5, 8, 11, 19, 0, 3, 21', 14, 11, 6, 2, 6);
INSERT INTO `insert_sort` VALUES (262, 0, 4, '4, 5, 8, 11, 0, 19', '3, 21', '4, 5, 8, 11, 0, 19, 3, 21', 14, 12, 6, 2, 5);
INSERT INTO `insert_sort` VALUES (263, 0, 3, '4, 5, 8, 0, 11, 19', '3, 21', '4, 5, 8, 0, 11, 19, 3, 21', 14, 13, 6, 2, 4);
INSERT INTO `insert_sort` VALUES (264, 0, 2, '4, 5, 0, 8, 11, 19', '3, 21', '4, 5, 0, 8, 11, 19, 3, 21', 14, 14, 6, 2, 3);
INSERT INTO `insert_sort` VALUES (265, 0, 1, '4, 0, 5, 8, 11, 19', '3, 21', '4, 0, 5, 8, 11, 19, 3, 21', 14, 15, 6, 2, 2);
INSERT INTO `insert_sort` VALUES (266, 0, 0, '0, 4, 5, 8, 11, 19', '3, 21', '0, 4, 5, 8, 11, 19, 3, 21', 14, 16, 6, 2, 1);
INSERT INTO `insert_sort` VALUES (267, 3, 6, '0, 4, 5, 8, 11, 19, 3', '21', '0, 4, 5, 8, 11, 19, 3, 21', 14, 17, 7, 2, 7);
INSERT INTO `insert_sort` VALUES (268, 3, 5, '0, 4, 5, 8, 11, 3, 19', '21', '0, 4, 5, 8, 11, 3, 19, 21', 14, 18, 7, 2, 6);
INSERT INTO `insert_sort` VALUES (269, 3, 4, '0, 4, 5, 8, 3, 11, 19', '21', '0, 4, 5, 8, 3, 11, 19, 21', 14, 19, 7, 2, 5);
INSERT INTO `insert_sort` VALUES (270, 3, 3, '0, 4, 5, 3, 8, 11, 19', '21', '0, 4, 5, 3, 8, 11, 19, 21', 14, 20, 7, 2, 4);
INSERT INTO `insert_sort` VALUES (271, 3, 2, '0, 4, 3, 5, 8, 11, 19', '21', '0, 4, 3, 5, 8, 11, 19, 21', 14, 21, 7, 2, 3);
INSERT INTO `insert_sort` VALUES (272, 3, 1, '0, 3, 4, 5, 8, 11, 19', '21', '0, 3, 4, 5, 8, 11, 19, 21', 14, 22, 7, 2, 2);
INSERT INTO `insert_sort` VALUES (273, 21, 7, '0, 3, 4, 5, 8, 11, 19, 21', '', '0, 3, 4, 5, 8, 11, 19, 21', 14, 23, 8, 2, 8);

-- ----------------------------
-- Table structure for problems
-- ----------------------------
DROP TABLE IF EXISTS `problems`;
CREATE TABLE `problems`  (
  `problem_id` int NOT NULL AUTO_INCREMENT,
  `curr_list` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `practice_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`problem_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `problems_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of problems
-- ----------------------------
INSERT INTO `problems` VALUES (1, '5,2,8,1,4', 1, 1);
INSERT INTO `problems` VALUES (2, '5,1,3', 2, 1);
INSERT INTO `problems` VALUES (3, '4,2,8,6,5', 3, 1);
INSERT INTO `problems` VALUES (4, '4,9,0,3,1,5', 4, 1);
INSERT INTO `problems` VALUES (5, '1,5,0,4,7', 5, 1);
INSERT INTO `problems` VALUES (6, '3,4,0,2,1', 6, 1);
INSERT INTO `problems` VALUES (7, '3,14,2,7,21,6,8', 7, 1);
INSERT INTO `problems` VALUES (8, '3,24,5,23,7,0', 8, 1);
INSERT INTO `problems` VALUES (9, '1,4,0,6', 9, 1);
INSERT INTO `problems` VALUES (10, '13,2,7,9,42,6,4', 10, 1);
INSERT INTO `problems` VALUES (11, '1,5,4,9,8,0,3,1', 11, 2);
INSERT INTO `problems` VALUES (12, '3,9,0', 12, 2);
INSERT INTO `problems` VALUES (21, '4,0,9,1', 13, 2);
INSERT INTO `problems` VALUES (22, '11,5,4,19,8,0,3,21', 14, 2);

-- ----------------------------
-- Table structure for select_sort
-- ----------------------------
DROP TABLE IF EXISTS `select_sort`;
CREATE TABLE `select_sort`  (
  `select_id` int NOT NULL AUTO_INCREMENT,
  `exchange` tinyint NOT NULL,
  `min_pos` int NOT NULL,
  `cur_pos` int NOT NULL,
  `turn` int NOT NULL,
  `curr_list` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `practice_id` int NOT NULL,
  `process_num` int NOT NULL,
  `user_id` int NOT NULL,
  `process_step` int NOT NULL,
  PRIMARY KEY (`select_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `select_sort_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of select_sort
-- ----------------------------
INSERT INTO `select_sort` VALUES (1, 0, 0, 0, 0, '5, 2, 8, 1, 4', 1, 0, 1, 0);
INSERT INTO `select_sort` VALUES (2, 0, 1, 0, 1, '5, 2, 8, 1, 4', 1, 2, 1, 3);
INSERT INTO `select_sort` VALUES (3, 0, 1, 0, 1, '5, 2, 8, 1, 4', 1, 4, 1, 5);
INSERT INTO `select_sort` VALUES (4, 0, 3, 0, 1, '5, 2, 8, 1, 4', 1, 6, 1, 7);
INSERT INTO `select_sort` VALUES (5, 0, 3, 0, 1, '5, 2, 8, 1, 4', 1, 8, 1, 9);
INSERT INTO `select_sort` VALUES (6, 1, 3, 0, 1, '1, 2, 8, 5, 4', 1, 9, 1, 9);
INSERT INTO `select_sort` VALUES (7, 0, 1, 1, 2, '1, 2, 8, 5, 4', 1, 11, 1, 4);
INSERT INTO `select_sort` VALUES (8, 0, 1, 1, 2, '1, 2, 8, 5, 4', 1, 13, 1, 6);
INSERT INTO `select_sort` VALUES (9, 0, 1, 1, 2, '1, 2, 8, 5, 4', 1, 15, 1, 8);
INSERT INTO `select_sort` VALUES (10, 0, 1, 1, 2, '1, 2, 8, 5, 4', 1, 16, 1, 9);
INSERT INTO `select_sort` VALUES (11, 0, 3, 2, 3, '1, 2, 8, 5, 4', 1, 18, 1, 5);
INSERT INTO `select_sort` VALUES (12, 0, 4, 2, 3, '1, 2, 8, 5, 4', 1, 20, 1, 7);
INSERT INTO `select_sort` VALUES (13, 1, 4, 2, 3, '1, 2, 4, 5, 8', 1, 21, 1, 9);
INSERT INTO `select_sort` VALUES (14, 0, 3, 3, 4, '1, 2, 4, 5, 8', 1, 23, 1, 6);
INSERT INTO `select_sort` VALUES (15, 0, 3, 3, 4, '1, 2, 4, 5, 8', 1, 24, 1, 9);
INSERT INTO `select_sort` VALUES (16, 0, 0, 0, 0, '5, 1, 3', 2, 0, 1, 0);
INSERT INTO `select_sort` VALUES (17, 0, 1, 0, 1, '5, 1, 3', 2, 2, 1, 3);
INSERT INTO `select_sort` VALUES (18, 0, 1, 0, 1, '5, 1, 3', 2, 4, 1, 5);
INSERT INTO `select_sort` VALUES (19, 1, 1, 0, 1, '1, 5, 3', 2, 5, 1, 5);
INSERT INTO `select_sort` VALUES (20, 0, 2, 1, 2, '1, 5, 3', 2, 7, 1, 4);
INSERT INTO `select_sort` VALUES (21, 1, 2, 1, 2, '1, 3, 5', 2, 8, 1, 5);
INSERT INTO `select_sort` VALUES (22, 0, 0, 0, 0, '4, 2, 8, 6, 5', 3, 0, 1, 0);
INSERT INTO `select_sort` VALUES (23, 0, 1, 0, 1, '4, 2, 8, 6, 5', 3, 2, 1, 3);
INSERT INTO `select_sort` VALUES (24, 0, 1, 0, 1, '4, 2, 8, 6, 5', 3, 4, 1, 5);
INSERT INTO `select_sort` VALUES (25, 0, 1, 0, 1, '4, 2, 8, 6, 5', 3, 6, 1, 7);
INSERT INTO `select_sort` VALUES (26, 0, 1, 0, 1, '4, 2, 8, 6, 5', 3, 8, 1, 9);
INSERT INTO `select_sort` VALUES (27, 1, 1, 0, 1, '2, 4, 8, 6, 5', 3, 9, 1, 9);
INSERT INTO `select_sort` VALUES (28, 0, 1, 1, 2, '2, 4, 8, 6, 5', 3, 11, 1, 4);
INSERT INTO `select_sort` VALUES (29, 0, 1, 1, 2, '2, 4, 8, 6, 5', 3, 13, 1, 6);
INSERT INTO `select_sort` VALUES (30, 0, 1, 1, 2, '2, 4, 8, 6, 5', 3, 15, 1, 8);
INSERT INTO `select_sort` VALUES (31, 0, 1, 1, 2, '2, 4, 8, 6, 5', 3, 16, 1, 9);
INSERT INTO `select_sort` VALUES (32, 0, 3, 2, 3, '2, 4, 8, 6, 5', 3, 18, 1, 5);
INSERT INTO `select_sort` VALUES (33, 0, 4, 2, 3, '2, 4, 8, 6, 5', 3, 20, 1, 7);
INSERT INTO `select_sort` VALUES (34, 1, 4, 2, 3, '2, 4, 5, 6, 8', 3, 21, 1, 9);
INSERT INTO `select_sort` VALUES (35, 0, 3, 3, 4, '2, 4, 5, 6, 8', 3, 23, 1, 6);
INSERT INTO `select_sort` VALUES (36, 0, 3, 3, 4, '2, 4, 5, 6, 8', 3, 24, 1, 9);
INSERT INTO `select_sort` VALUES (37, 0, 0, 0, 0, '4, 9, 0, 3, 1, 5', 4, 0, 1, 0);
INSERT INTO `select_sort` VALUES (38, 0, 0, 0, 1, '4, 9, 0, 3, 1, 5', 4, 2, 1, 3);
INSERT INTO `select_sort` VALUES (39, 0, 2, 0, 1, '4, 9, 0, 3, 1, 5', 4, 4, 1, 5);
INSERT INTO `select_sort` VALUES (40, 0, 2, 0, 1, '4, 9, 0, 3, 1, 5', 4, 6, 1, 7);
INSERT INTO `select_sort` VALUES (41, 0, 2, 0, 1, '4, 9, 0, 3, 1, 5', 4, 8, 1, 9);
INSERT INTO `select_sort` VALUES (42, 0, 2, 0, 1, '4, 9, 0, 3, 1, 5', 4, 10, 1, 11);
INSERT INTO `select_sort` VALUES (43, 1, 2, 0, 1, '0, 9, 4, 3, 1, 5', 4, 11, 1, 11);
INSERT INTO `select_sort` VALUES (44, 0, 2, 1, 2, '0, 9, 4, 3, 1, 5', 4, 13, 1, 4);
INSERT INTO `select_sort` VALUES (45, 0, 3, 1, 2, '0, 9, 4, 3, 1, 5', 4, 15, 1, 6);
INSERT INTO `select_sort` VALUES (46, 0, 4, 1, 2, '0, 9, 4, 3, 1, 5', 4, 17, 1, 8);
INSERT INTO `select_sort` VALUES (47, 0, 4, 1, 2, '0, 9, 4, 3, 1, 5', 4, 19, 1, 10);
INSERT INTO `select_sort` VALUES (48, 1, 4, 1, 2, '0, 1, 4, 3, 9, 5', 4, 20, 1, 11);
INSERT INTO `select_sort` VALUES (49, 0, 3, 2, 3, '0, 1, 4, 3, 9, 5', 4, 22, 1, 5);
INSERT INTO `select_sort` VALUES (50, 0, 3, 2, 3, '0, 1, 4, 3, 9, 5', 4, 24, 1, 7);
INSERT INTO `select_sort` VALUES (51, 0, 3, 2, 3, '0, 1, 4, 3, 9, 5', 4, 26, 1, 9);
INSERT INTO `select_sort` VALUES (52, 1, 3, 2, 3, '0, 1, 3, 4, 9, 5', 4, 27, 1, 11);
INSERT INTO `select_sort` VALUES (53, 0, 3, 3, 4, '0, 1, 3, 4, 9, 5', 4, 29, 1, 6);
INSERT INTO `select_sort` VALUES (54, 0, 3, 3, 4, '0, 1, 3, 4, 9, 5', 4, 31, 1, 8);
INSERT INTO `select_sort` VALUES (55, 0, 3, 3, 4, '0, 1, 3, 4, 9, 5', 4, 32, 1, 11);
INSERT INTO `select_sort` VALUES (56, 0, 5, 4, 5, '0, 1, 3, 4, 9, 5', 4, 34, 1, 7);
INSERT INTO `select_sort` VALUES (57, 1, 5, 4, 5, '0, 1, 3, 4, 5, 9', 4, 35, 1, 11);
INSERT INTO `select_sort` VALUES (58, 0, 0, 0, 0, '1, 5, 0, 4, 7', 5, 0, 1, 0);
INSERT INTO `select_sort` VALUES (59, 0, 0, 0, 1, '1, 5, 0, 4, 7', 5, 2, 1, 3);
INSERT INTO `select_sort` VALUES (60, 0, 2, 0, 1, '1, 5, 0, 4, 7', 5, 4, 1, 5);
INSERT INTO `select_sort` VALUES (61, 0, 2, 0, 1, '1, 5, 0, 4, 7', 5, 6, 1, 7);
INSERT INTO `select_sort` VALUES (62, 0, 2, 0, 1, '1, 5, 0, 4, 7', 5, 8, 1, 9);
INSERT INTO `select_sort` VALUES (63, 1, 2, 0, 1, '0, 5, 1, 4, 7', 5, 9, 1, 9);
INSERT INTO `select_sort` VALUES (64, 0, 2, 1, 2, '0, 5, 1, 4, 7', 5, 11, 1, 4);
INSERT INTO `select_sort` VALUES (65, 0, 2, 1, 2, '0, 5, 1, 4, 7', 5, 13, 1, 6);
INSERT INTO `select_sort` VALUES (66, 0, 2, 1, 2, '0, 5, 1, 4, 7', 5, 15, 1, 8);
INSERT INTO `select_sort` VALUES (67, 1, 2, 1, 2, '0, 1, 5, 4, 7', 5, 16, 1, 9);
INSERT INTO `select_sort` VALUES (68, 0, 3, 2, 3, '0, 1, 5, 4, 7', 5, 18, 1, 5);
INSERT INTO `select_sort` VALUES (69, 0, 3, 2, 3, '0, 1, 5, 4, 7', 5, 20, 1, 7);
INSERT INTO `select_sort` VALUES (70, 1, 3, 2, 3, '0, 1, 4, 5, 7', 5, 21, 1, 9);
INSERT INTO `select_sort` VALUES (71, 0, 3, 3, 4, '0, 1, 4, 5, 7', 5, 23, 1, 6);
INSERT INTO `select_sort` VALUES (72, 0, 3, 3, 4, '0, 1, 4, 5, 7', 5, 24, 1, 9);
INSERT INTO `select_sort` VALUES (73, 0, 0, 0, 0, '3, 4, 0, 2, 1', 6, 0, 1, 0);
INSERT INTO `select_sort` VALUES (74, 0, 0, 0, 1, '3, 4, 0, 2, 1', 6, 2, 1, 3);
INSERT INTO `select_sort` VALUES (75, 0, 2, 0, 1, '3, 4, 0, 2, 1', 6, 4, 1, 5);
INSERT INTO `select_sort` VALUES (76, 0, 2, 0, 1, '3, 4, 0, 2, 1', 6, 6, 1, 7);
INSERT INTO `select_sort` VALUES (77, 0, 2, 0, 1, '3, 4, 0, 2, 1', 6, 8, 1, 9);
INSERT INTO `select_sort` VALUES (78, 1, 2, 0, 1, '0, 4, 3, 2, 1', 6, 9, 1, 9);
INSERT INTO `select_sort` VALUES (79, 0, 2, 1, 2, '0, 4, 3, 2, 1', 6, 11, 1, 4);
INSERT INTO `select_sort` VALUES (80, 0, 3, 1, 2, '0, 4, 3, 2, 1', 6, 13, 1, 6);
INSERT INTO `select_sort` VALUES (81, 0, 4, 1, 2, '0, 4, 3, 2, 1', 6, 15, 1, 8);
INSERT INTO `select_sort` VALUES (82, 1, 4, 1, 2, '0, 1, 3, 2, 4', 6, 16, 1, 9);
INSERT INTO `select_sort` VALUES (83, 0, 3, 2, 3, '0, 1, 3, 2, 4', 6, 18, 1, 5);
INSERT INTO `select_sort` VALUES (84, 0, 3, 2, 3, '0, 1, 3, 2, 4', 6, 20, 1, 7);
INSERT INTO `select_sort` VALUES (85, 1, 3, 2, 3, '0, 1, 2, 3, 4', 6, 21, 1, 9);
INSERT INTO `select_sort` VALUES (86, 0, 3, 3, 4, '0, 1, 2, 3, 4', 6, 23, 1, 6);
INSERT INTO `select_sort` VALUES (87, 0, 3, 3, 4, '0, 1, 2, 3, 4', 6, 24, 1, 9);
INSERT INTO `select_sort` VALUES (88, 0, 0, 0, 0, '3, 14, 2, 7, 21, 6, 8', 7, 0, 1, 0);
INSERT INTO `select_sort` VALUES (89, 0, 0, 0, 1, '3, 14, 2, 7, 21, 6, 8', 7, 2, 1, 3);
INSERT INTO `select_sort` VALUES (90, 0, 2, 0, 1, '3, 14, 2, 7, 21, 6, 8', 7, 4, 1, 5);
INSERT INTO `select_sort` VALUES (91, 0, 2, 0, 1, '3, 14, 2, 7, 21, 6, 8', 7, 6, 1, 7);
INSERT INTO `select_sort` VALUES (92, 0, 2, 0, 1, '3, 14, 2, 7, 21, 6, 8', 7, 8, 1, 9);
INSERT INTO `select_sort` VALUES (93, 0, 2, 0, 1, '3, 14, 2, 7, 21, 6, 8', 7, 10, 1, 11);
INSERT INTO `select_sort` VALUES (94, 0, 2, 0, 1, '3, 14, 2, 7, 21, 6, 8', 7, 12, 1, 13);
INSERT INTO `select_sort` VALUES (95, 1, 2, 0, 1, '2, 14, 3, 7, 21, 6, 8', 7, 13, 1, 13);
INSERT INTO `select_sort` VALUES (96, 0, 2, 1, 2, '2, 14, 3, 7, 21, 6, 8', 7, 15, 1, 4);
INSERT INTO `select_sort` VALUES (97, 0, 2, 1, 2, '2, 14, 3, 7, 21, 6, 8', 7, 17, 1, 6);
INSERT INTO `select_sort` VALUES (98, 0, 2, 1, 2, '2, 14, 3, 7, 21, 6, 8', 7, 19, 1, 8);
INSERT INTO `select_sort` VALUES (99, 0, 2, 1, 2, '2, 14, 3, 7, 21, 6, 8', 7, 21, 1, 10);
INSERT INTO `select_sort` VALUES (100, 0, 2, 1, 2, '2, 14, 3, 7, 21, 6, 8', 7, 23, 1, 12);
INSERT INTO `select_sort` VALUES (101, 1, 2, 1, 2, '2, 3, 14, 7, 21, 6, 8', 7, 24, 1, 13);
INSERT INTO `select_sort` VALUES (102, 0, 3, 2, 3, '2, 3, 14, 7, 21, 6, 8', 7, 26, 1, 5);
INSERT INTO `select_sort` VALUES (103, 0, 3, 2, 3, '2, 3, 14, 7, 21, 6, 8', 7, 28, 1, 7);
INSERT INTO `select_sort` VALUES (104, 0, 5, 2, 3, '2, 3, 14, 7, 21, 6, 8', 7, 30, 1, 9);
INSERT INTO `select_sort` VALUES (105, 0, 5, 2, 3, '2, 3, 14, 7, 21, 6, 8', 7, 32, 1, 11);
INSERT INTO `select_sort` VALUES (106, 1, 5, 2, 3, '2, 3, 6, 7, 21, 14, 8', 7, 33, 1, 13);
INSERT INTO `select_sort` VALUES (107, 0, 3, 3, 4, '2, 3, 6, 7, 21, 14, 8', 7, 35, 1, 6);
INSERT INTO `select_sort` VALUES (108, 0, 3, 3, 4, '2, 3, 6, 7, 21, 14, 8', 7, 37, 1, 8);
INSERT INTO `select_sort` VALUES (109, 0, 3, 3, 4, '2, 3, 6, 7, 21, 14, 8', 7, 39, 1, 10);
INSERT INTO `select_sort` VALUES (110, 0, 3, 3, 4, '2, 3, 6, 7, 21, 14, 8', 7, 40, 1, 13);
INSERT INTO `select_sort` VALUES (111, 0, 5, 4, 5, '2, 3, 6, 7, 21, 14, 8', 7, 42, 1, 7);
INSERT INTO `select_sort` VALUES (112, 0, 6, 4, 5, '2, 3, 6, 7, 21, 14, 8', 7, 44, 1, 9);
INSERT INTO `select_sort` VALUES (113, 1, 6, 4, 5, '2, 3, 6, 7, 8, 14, 21', 7, 45, 1, 13);
INSERT INTO `select_sort` VALUES (114, 0, 5, 5, 6, '2, 3, 6, 7, 8, 14, 21', 7, 47, 1, 8);
INSERT INTO `select_sort` VALUES (115, 0, 5, 5, 6, '2, 3, 6, 7, 8, 14, 21', 7, 48, 1, 13);
INSERT INTO `select_sort` VALUES (116, 0, 0, 0, 0, '3, 24, 5, 23, 7, 0', 8, 0, 1, 0);
INSERT INTO `select_sort` VALUES (117, 0, 0, 0, 1, '3, 24, 5, 23, 7, 0', 8, 2, 1, 3);
INSERT INTO `select_sort` VALUES (118, 0, 0, 0, 1, '3, 24, 5, 23, 7, 0', 8, 4, 1, 5);
INSERT INTO `select_sort` VALUES (119, 0, 0, 0, 1, '3, 24, 5, 23, 7, 0', 8, 6, 1, 7);
INSERT INTO `select_sort` VALUES (120, 0, 0, 0, 1, '3, 24, 5, 23, 7, 0', 8, 8, 1, 9);
INSERT INTO `select_sort` VALUES (121, 0, 5, 0, 1, '3, 24, 5, 23, 7, 0', 8, 10, 1, 11);
INSERT INTO `select_sort` VALUES (122, 1, 5, 0, 1, '0, 24, 5, 23, 7, 3', 8, 11, 1, 11);
INSERT INTO `select_sort` VALUES (123, 0, 2, 1, 2, '0, 24, 5, 23, 7, 3', 8, 13, 1, 4);
INSERT INTO `select_sort` VALUES (124, 0, 2, 1, 2, '0, 24, 5, 23, 7, 3', 8, 15, 1, 6);
INSERT INTO `select_sort` VALUES (125, 0, 2, 1, 2, '0, 24, 5, 23, 7, 3', 8, 17, 1, 8);
INSERT INTO `select_sort` VALUES (126, 0, 5, 1, 2, '0, 24, 5, 23, 7, 3', 8, 19, 1, 10);
INSERT INTO `select_sort` VALUES (127, 1, 5, 1, 2, '0, 3, 5, 23, 7, 24', 8, 20, 1, 11);
INSERT INTO `select_sort` VALUES (128, 0, 2, 2, 3, '0, 3, 5, 23, 7, 24', 8, 22, 1, 5);
INSERT INTO `select_sort` VALUES (129, 0, 2, 2, 3, '0, 3, 5, 23, 7, 24', 8, 24, 1, 7);
INSERT INTO `select_sort` VALUES (130, 0, 2, 2, 3, '0, 3, 5, 23, 7, 24', 8, 26, 1, 9);
INSERT INTO `select_sort` VALUES (131, 0, 2, 2, 3, '0, 3, 5, 23, 7, 24', 8, 27, 1, 11);
INSERT INTO `select_sort` VALUES (132, 0, 4, 3, 4, '0, 3, 5, 23, 7, 24', 8, 29, 1, 6);
INSERT INTO `select_sort` VALUES (133, 0, 4, 3, 4, '0, 3, 5, 23, 7, 24', 8, 31, 1, 8);
INSERT INTO `select_sort` VALUES (134, 1, 4, 3, 4, '0, 3, 5, 7, 23, 24', 8, 32, 1, 11);
INSERT INTO `select_sort` VALUES (135, 0, 4, 4, 5, '0, 3, 5, 7, 23, 24', 8, 34, 1, 7);
INSERT INTO `select_sort` VALUES (136, 0, 4, 4, 5, '0, 3, 5, 7, 23, 24', 8, 35, 1, 11);
INSERT INTO `select_sort` VALUES (137, 0, 0, 0, 0, '1, 4, 0, 6', 9, 0, 1, 0);
INSERT INTO `select_sort` VALUES (138, 0, 0, 0, 1, '1, 4, 0, 6', 9, 2, 1, 3);
INSERT INTO `select_sort` VALUES (139, 0, 2, 0, 1, '1, 4, 0, 6', 9, 4, 1, 5);
INSERT INTO `select_sort` VALUES (140, 0, 2, 0, 1, '1, 4, 0, 6', 9, 6, 1, 7);
INSERT INTO `select_sort` VALUES (141, 1, 2, 0, 1, '0, 4, 1, 6', 9, 7, 1, 7);
INSERT INTO `select_sort` VALUES (142, 0, 2, 1, 2, '0, 4, 1, 6', 9, 9, 1, 4);
INSERT INTO `select_sort` VALUES (143, 0, 2, 1, 2, '0, 4, 1, 6', 9, 11, 1, 6);
INSERT INTO `select_sort` VALUES (144, 1, 2, 1, 2, '0, 1, 4, 6', 9, 12, 1, 7);
INSERT INTO `select_sort` VALUES (145, 0, 2, 2, 3, '0, 1, 4, 6', 9, 14, 1, 5);
INSERT INTO `select_sort` VALUES (146, 0, 2, 2, 3, '0, 1, 4, 6', 9, 15, 1, 7);
INSERT INTO `select_sort` VALUES (147, 0, 0, 0, 0, '13, 2, 7, 9, 42, 6, 4', 10, 0, 1, 0);
INSERT INTO `select_sort` VALUES (148, 0, 1, 0, 1, '13, 2, 7, 9, 42, 6, 4', 10, 2, 1, 3);
INSERT INTO `select_sort` VALUES (149, 0, 1, 0, 1, '13, 2, 7, 9, 42, 6, 4', 10, 4, 1, 5);
INSERT INTO `select_sort` VALUES (150, 0, 1, 0, 1, '13, 2, 7, 9, 42, 6, 4', 10, 6, 1, 7);
INSERT INTO `select_sort` VALUES (151, 0, 1, 0, 1, '13, 2, 7, 9, 42, 6, 4', 10, 8, 1, 9);
INSERT INTO `select_sort` VALUES (152, 0, 1, 0, 1, '13, 2, 7, 9, 42, 6, 4', 10, 10, 1, 11);
INSERT INTO `select_sort` VALUES (153, 0, 1, 0, 1, '13, 2, 7, 9, 42, 6, 4', 10, 12, 1, 13);
INSERT INTO `select_sort` VALUES (154, 1, 1, 0, 1, '2, 13, 7, 9, 42, 6, 4', 10, 13, 1, 13);
INSERT INTO `select_sort` VALUES (155, 0, 2, 1, 2, '2, 13, 7, 9, 42, 6, 4', 10, 15, 1, 4);
INSERT INTO `select_sort` VALUES (156, 0, 2, 1, 2, '2, 13, 7, 9, 42, 6, 4', 10, 17, 1, 6);
INSERT INTO `select_sort` VALUES (157, 0, 2, 1, 2, '2, 13, 7, 9, 42, 6, 4', 10, 19, 1, 8);
INSERT INTO `select_sort` VALUES (158, 0, 5, 1, 2, '2, 13, 7, 9, 42, 6, 4', 10, 21, 1, 10);
INSERT INTO `select_sort` VALUES (159, 0, 6, 1, 2, '2, 13, 7, 9, 42, 6, 4', 10, 23, 1, 12);
INSERT INTO `select_sort` VALUES (160, 1, 6, 1, 2, '2, 4, 7, 9, 42, 6, 13', 10, 24, 1, 13);
INSERT INTO `select_sort` VALUES (161, 0, 2, 2, 3, '2, 4, 7, 9, 42, 6, 13', 10, 26, 1, 5);
INSERT INTO `select_sort` VALUES (162, 0, 2, 2, 3, '2, 4, 7, 9, 42, 6, 13', 10, 28, 1, 7);
INSERT INTO `select_sort` VALUES (163, 0, 5, 2, 3, '2, 4, 7, 9, 42, 6, 13', 10, 30, 1, 9);
INSERT INTO `select_sort` VALUES (164, 0, 5, 2, 3, '2, 4, 7, 9, 42, 6, 13', 10, 32, 1, 11);
INSERT INTO `select_sort` VALUES (165, 1, 5, 2, 3, '2, 4, 6, 9, 42, 7, 13', 10, 33, 1, 13);
INSERT INTO `select_sort` VALUES (166, 0, 3, 3, 4, '2, 4, 6, 9, 42, 7, 13', 10, 35, 1, 6);
INSERT INTO `select_sort` VALUES (167, 0, 5, 3, 4, '2, 4, 6, 9, 42, 7, 13', 10, 37, 1, 8);
INSERT INTO `select_sort` VALUES (168, 0, 5, 3, 4, '2, 4, 6, 9, 42, 7, 13', 10, 39, 1, 10);
INSERT INTO `select_sort` VALUES (169, 1, 5, 3, 4, '2, 4, 6, 7, 42, 9, 13', 10, 40, 1, 13);
INSERT INTO `select_sort` VALUES (170, 0, 5, 4, 5, '2, 4, 6, 7, 42, 9, 13', 10, 42, 1, 7);
INSERT INTO `select_sort` VALUES (171, 0, 5, 4, 5, '2, 4, 6, 7, 42, 9, 13', 10, 44, 1, 9);
INSERT INTO `select_sort` VALUES (172, 1, 5, 4, 5, '2, 4, 6, 7, 9, 42, 13', 10, 45, 1, 13);
INSERT INTO `select_sort` VALUES (173, 0, 6, 5, 6, '2, 4, 6, 7, 9, 42, 13', 10, 47, 1, 8);
INSERT INTO `select_sort` VALUES (174, 1, 6, 5, 6, '2, 4, 6, 7, 9, 13, 42', 10, 48, 1, 13);
INSERT INTO `select_sort` VALUES (175, 0, 0, 0, 0, '1, 5, 4, 9, 8, 0, 3, 1', 11, 0, 2, 0);
INSERT INTO `select_sort` VALUES (176, 0, 0, 0, 1, '1, 5, 4, 9, 8, 0, 3, 1', 11, 2, 2, 3);
INSERT INTO `select_sort` VALUES (177, 0, 0, 0, 1, '1, 5, 4, 9, 8, 0, 3, 1', 11, 4, 2, 5);
INSERT INTO `select_sort` VALUES (178, 0, 0, 0, 1, '1, 5, 4, 9, 8, 0, 3, 1', 11, 6, 2, 7);
INSERT INTO `select_sort` VALUES (179, 0, 0, 0, 1, '1, 5, 4, 9, 8, 0, 3, 1', 11, 8, 2, 9);
INSERT INTO `select_sort` VALUES (180, 0, 5, 0, 1, '1, 5, 4, 9, 8, 0, 3, 1', 11, 10, 2, 11);
INSERT INTO `select_sort` VALUES (181, 0, 5, 0, 1, '1, 5, 4, 9, 8, 0, 3, 1', 11, 12, 2, 13);
INSERT INTO `select_sort` VALUES (182, 0, 5, 0, 1, '1, 5, 4, 9, 8, 0, 3, 1', 11, 14, 2, 15);
INSERT INTO `select_sort` VALUES (183, 1, 5, 0, 1, '0, 5, 4, 9, 8, 1, 3, 1', 11, 15, 2, 15);
INSERT INTO `select_sort` VALUES (184, 0, 2, 1, 2, '0, 5, 4, 9, 8, 1, 3, 1', 11, 17, 2, 4);
INSERT INTO `select_sort` VALUES (185, 0, 2, 1, 2, '0, 5, 4, 9, 8, 1, 3, 1', 11, 19, 2, 6);
INSERT INTO `select_sort` VALUES (186, 0, 2, 1, 2, '0, 5, 4, 9, 8, 1, 3, 1', 11, 21, 2, 8);
INSERT INTO `select_sort` VALUES (187, 0, 5, 1, 2, '0, 5, 4, 9, 8, 1, 3, 1', 11, 23, 2, 10);
INSERT INTO `select_sort` VALUES (188, 0, 5, 1, 2, '0, 5, 4, 9, 8, 1, 3, 1', 11, 25, 2, 12);
INSERT INTO `select_sort` VALUES (189, 0, 5, 1, 2, '0, 5, 4, 9, 8, 1, 3, 1', 11, 27, 2, 14);
INSERT INTO `select_sort` VALUES (190, 1, 5, 1, 2, '0, 1, 4, 9, 8, 5, 3, 1', 11, 28, 2, 15);
INSERT INTO `select_sort` VALUES (191, 0, 2, 2, 3, '0, 1, 4, 9, 8, 5, 3, 1', 11, 30, 2, 5);
INSERT INTO `select_sort` VALUES (192, 0, 2, 2, 3, '0, 1, 4, 9, 8, 5, 3, 1', 11, 32, 2, 7);
INSERT INTO `select_sort` VALUES (193, 0, 2, 2, 3, '0, 1, 4, 9, 8, 5, 3, 1', 11, 34, 2, 9);
INSERT INTO `select_sort` VALUES (194, 0, 6, 2, 3, '0, 1, 4, 9, 8, 5, 3, 1', 11, 36, 2, 11);
INSERT INTO `select_sort` VALUES (195, 0, 7, 2, 3, '0, 1, 4, 9, 8, 5, 3, 1', 11, 38, 2, 13);
INSERT INTO `select_sort` VALUES (196, 1, 7, 2, 3, '0, 1, 1, 9, 8, 5, 3, 4', 11, 39, 2, 15);
INSERT INTO `select_sort` VALUES (197, 0, 4, 3, 4, '0, 1, 1, 9, 8, 5, 3, 4', 11, 41, 2, 6);
INSERT INTO `select_sort` VALUES (198, 0, 5, 3, 4, '0, 1, 1, 9, 8, 5, 3, 4', 11, 43, 2, 8);
INSERT INTO `select_sort` VALUES (199, 0, 6, 3, 4, '0, 1, 1, 9, 8, 5, 3, 4', 11, 45, 2, 10);
INSERT INTO `select_sort` VALUES (200, 0, 6, 3, 4, '0, 1, 1, 9, 8, 5, 3, 4', 11, 47, 2, 12);
INSERT INTO `select_sort` VALUES (201, 1, 6, 3, 4, '0, 1, 1, 3, 8, 5, 9, 4', 11, 48, 2, 15);
INSERT INTO `select_sort` VALUES (202, 0, 5, 4, 5, '0, 1, 1, 3, 8, 5, 9, 4', 11, 50, 2, 7);
INSERT INTO `select_sort` VALUES (203, 0, 5, 4, 5, '0, 1, 1, 3, 8, 5, 9, 4', 11, 52, 2, 9);
INSERT INTO `select_sort` VALUES (204, 0, 7, 4, 5, '0, 1, 1, 3, 8, 5, 9, 4', 11, 54, 2, 11);
INSERT INTO `select_sort` VALUES (205, 1, 7, 4, 5, '0, 1, 1, 3, 4, 5, 9, 8', 11, 55, 2, 15);
INSERT INTO `select_sort` VALUES (206, 0, 5, 5, 6, '0, 1, 1, 3, 4, 5, 9, 8', 11, 57, 2, 8);
INSERT INTO `select_sort` VALUES (207, 0, 5, 5, 6, '0, 1, 1, 3, 4, 5, 9, 8', 11, 59, 2, 10);
INSERT INTO `select_sort` VALUES (208, 0, 5, 5, 6, '0, 1, 1, 3, 4, 5, 9, 8', 11, 60, 2, 15);
INSERT INTO `select_sort` VALUES (209, 0, 7, 6, 7, '0, 1, 1, 3, 4, 5, 9, 8', 11, 62, 2, 9);
INSERT INTO `select_sort` VALUES (210, 1, 7, 6, 7, '0, 1, 1, 3, 4, 5, 8, 9', 11, 63, 2, 15);
INSERT INTO `select_sort` VALUES (211, 0, 0, 0, 0, '3, 9, 0', 12, 0, 2, 0);
INSERT INTO `select_sort` VALUES (212, 0, 0, 0, 1, '3, 9, 0', 12, 2, 2, 3);
INSERT INTO `select_sort` VALUES (213, 0, 2, 0, 1, '3, 9, 0', 12, 4, 2, 5);
INSERT INTO `select_sort` VALUES (214, 1, 2, 0, 1, '0, 9, 3', 12, 5, 2, 5);
INSERT INTO `select_sort` VALUES (215, 0, 2, 1, 2, '0, 9, 3', 12, 7, 2, 4);
INSERT INTO `select_sort` VALUES (216, 1, 2, 1, 2, '0, 3, 9', 12, 8, 2, 5);
INSERT INTO `select_sort` VALUES (328, 0, 0, 0, 0, '4, 0, 9, 1', 13, 0, 2, 0);
INSERT INTO `select_sort` VALUES (329, 0, 1, 0, 1, '4, 0, 9, 1', 13, 2, 2, 3);
INSERT INTO `select_sort` VALUES (330, 0, 1, 0, 1, '4, 0, 9, 1', 13, 4, 2, 5);
INSERT INTO `select_sort` VALUES (331, 0, 1, 0, 1, '4, 0, 9, 1', 13, 6, 2, 7);
INSERT INTO `select_sort` VALUES (332, 1, 1, 0, 1, '0, 4, 9, 1', 13, 7, 2, 7);
INSERT INTO `select_sort` VALUES (333, 0, 1, 1, 2, '0, 4, 9, 1', 13, 9, 2, 4);
INSERT INTO `select_sort` VALUES (334, 0, 3, 1, 2, '0, 4, 9, 1', 13, 11, 2, 6);
INSERT INTO `select_sort` VALUES (335, 1, 3, 1, 2, '0, 1, 9, 4', 13, 12, 2, 7);
INSERT INTO `select_sort` VALUES (336, 0, 3, 2, 3, '0, 1, 9, 4', 13, 14, 2, 5);
INSERT INTO `select_sort` VALUES (337, 1, 3, 2, 3, '0, 1, 4, 9', 13, 15, 2, 7);
INSERT INTO `select_sort` VALUES (338, 0, 0, 0, 0, '11, 5, 4, 19, 8, 0, 3, 21', 14, 0, 2, 0);
INSERT INTO `select_sort` VALUES (339, 0, 1, 0, 1, '11, 5, 4, 19, 8, 0, 3, 21', 14, 2, 2, 3);
INSERT INTO `select_sort` VALUES (340, 0, 2, 0, 1, '11, 5, 4, 19, 8, 0, 3, 21', 14, 4, 2, 5);
INSERT INTO `select_sort` VALUES (341, 0, 2, 0, 1, '11, 5, 4, 19, 8, 0, 3, 21', 14, 6, 2, 7);
INSERT INTO `select_sort` VALUES (342, 0, 2, 0, 1, '11, 5, 4, 19, 8, 0, 3, 21', 14, 8, 2, 9);
INSERT INTO `select_sort` VALUES (343, 0, 5, 0, 1, '11, 5, 4, 19, 8, 0, 3, 21', 14, 10, 2, 11);
INSERT INTO `select_sort` VALUES (344, 0, 5, 0, 1, '11, 5, 4, 19, 8, 0, 3, 21', 14, 12, 2, 13);
INSERT INTO `select_sort` VALUES (345, 0, 5, 0, 1, '11, 5, 4, 19, 8, 0, 3, 21', 14, 14, 2, 15);
INSERT INTO `select_sort` VALUES (346, 1, 5, 0, 1, '0, 5, 4, 19, 8, 11, 3, 21', 14, 15, 2, 15);
INSERT INTO `select_sort` VALUES (347, 0, 2, 1, 2, '0, 5, 4, 19, 8, 11, 3, 21', 14, 17, 2, 4);
INSERT INTO `select_sort` VALUES (348, 0, 2, 1, 2, '0, 5, 4, 19, 8, 11, 3, 21', 14, 19, 2, 6);
INSERT INTO `select_sort` VALUES (349, 0, 2, 1, 2, '0, 5, 4, 19, 8, 11, 3, 21', 14, 21, 2, 8);
INSERT INTO `select_sort` VALUES (350, 0, 2, 1, 2, '0, 5, 4, 19, 8, 11, 3, 21', 14, 23, 2, 10);
INSERT INTO `select_sort` VALUES (351, 0, 6, 1, 2, '0, 5, 4, 19, 8, 11, 3, 21', 14, 25, 2, 12);
INSERT INTO `select_sort` VALUES (352, 0, 6, 1, 2, '0, 5, 4, 19, 8, 11, 3, 21', 14, 27, 2, 14);
INSERT INTO `select_sort` VALUES (353, 1, 6, 1, 2, '0, 3, 4, 19, 8, 11, 5, 21', 14, 28, 2, 15);
INSERT INTO `select_sort` VALUES (354, 0, 2, 2, 3, '0, 3, 4, 19, 8, 11, 5, 21', 14, 30, 2, 5);
INSERT INTO `select_sort` VALUES (355, 0, 2, 2, 3, '0, 3, 4, 19, 8, 11, 5, 21', 14, 32, 2, 7);
INSERT INTO `select_sort` VALUES (356, 0, 2, 2, 3, '0, 3, 4, 19, 8, 11, 5, 21', 14, 34, 2, 9);
INSERT INTO `select_sort` VALUES (357, 0, 2, 2, 3, '0, 3, 4, 19, 8, 11, 5, 21', 14, 36, 2, 11);
INSERT INTO `select_sort` VALUES (358, 0, 2, 2, 3, '0, 3, 4, 19, 8, 11, 5, 21', 14, 38, 2, 13);
INSERT INTO `select_sort` VALUES (359, 0, 2, 2, 3, '0, 3, 4, 19, 8, 11, 5, 21', 14, 39, 2, 15);
INSERT INTO `select_sort` VALUES (360, 0, 4, 3, 4, '0, 3, 4, 19, 8, 11, 5, 21', 14, 41, 2, 6);
INSERT INTO `select_sort` VALUES (361, 0, 4, 3, 4, '0, 3, 4, 19, 8, 11, 5, 21', 14, 43, 2, 8);
INSERT INTO `select_sort` VALUES (362, 0, 6, 3, 4, '0, 3, 4, 19, 8, 11, 5, 21', 14, 45, 2, 10);
INSERT INTO `select_sort` VALUES (363, 0, 6, 3, 4, '0, 3, 4, 19, 8, 11, 5, 21', 14, 47, 2, 12);
INSERT INTO `select_sort` VALUES (364, 1, 6, 3, 4, '0, 3, 4, 5, 8, 11, 19, 21', 14, 48, 2, 15);
INSERT INTO `select_sort` VALUES (365, 0, 4, 4, 5, '0, 3, 4, 5, 8, 11, 19, 21', 14, 50, 2, 7);
INSERT INTO `select_sort` VALUES (366, 0, 4, 4, 5, '0, 3, 4, 5, 8, 11, 19, 21', 14, 52, 2, 9);
INSERT INTO `select_sort` VALUES (367, 0, 4, 4, 5, '0, 3, 4, 5, 8, 11, 19, 21', 14, 54, 2, 11);
INSERT INTO `select_sort` VALUES (368, 0, 4, 4, 5, '0, 3, 4, 5, 8, 11, 19, 21', 14, 55, 2, 15);
INSERT INTO `select_sort` VALUES (369, 0, 5, 5, 6, '0, 3, 4, 5, 8, 11, 19, 21', 14, 57, 2, 8);
INSERT INTO `select_sort` VALUES (370, 0, 5, 5, 6, '0, 3, 4, 5, 8, 11, 19, 21', 14, 59, 2, 10);
INSERT INTO `select_sort` VALUES (371, 0, 5, 5, 6, '0, 3, 4, 5, 8, 11, 19, 21', 14, 60, 2, 15);
INSERT INTO `select_sort` VALUES (372, 0, 6, 6, 7, '0, 3, 4, 5, 8, 11, 19, 21', 14, 62, 2, 9);
INSERT INTO `select_sort` VALUES (373, 0, 6, 6, 7, '0, 3, 4, 5, 8, 11, 19, 21', 14, 63, 2, 15);

-- ----------------------------
-- Table structure for study_history
-- ----------------------------
DROP TABLE IF EXISTS `study_history`;
CREATE TABLE `study_history`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `sort_method` int NOT NULL,
  `problem_id` int NOT NULL,
  `last_step` int NOT NULL,
  `curr_time` datetime NOT NULL,
  `status` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `study_history_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of study_history
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `is_admin` tinyint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Admin', '00000000', 'admin@gmail.com', '11111111', 1);
INSERT INTO `user` VALUES (2, 'Alice', '88888888', 'alice@gmail.com', '65646564', 0);

SET FOREIGN_KEY_CHECKS = 1;
