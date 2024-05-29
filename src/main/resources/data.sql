-- 创建用户表
USE alg_db;
CREATE TABLE if NOT EXISTS `user` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `user_name` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `phone` VARCHAR(20) NOT NULL,
    `is_admin` TINYINT NOT NULL
)ENGINE=InnoDB;

-- 插入用户数据
INSERT INTO `user`(`id`,`user_name`,`password`,`email`,`phone`,`is_admin`)
VALUES (NULL, 'Admin', '00000000', 'admin@gmail.com', '11111111', '1');
INSERT INTO `user`(`id`,`user_name`,`password`,`email`,`phone`,`is_admin`)
VALUES (NULL, 'Alice', '88888888', 'alice@gmail.com', '65646564', '0');

drop table if exists `bubble_sort`;
-- 创建冒泡排序表
CREATE TABLE if NOT EXISTS `bubble_sort` (
       `bubble_id` INT AUTO_INCREMENT PRIMARY KEY,
       `exchange` TINYINT NOT NULL,
       `pre_pos` INT NOT NULL,
       `post_pos` INT NOT NULL,
       `turn` INT NOT NULL,
       `curr_list` VARCHAR(50) NOT NULL,
       `practice_id` INT NOT NULL,
       `process_num` INT NOT NULL,
       `user_id` INT NOT NULL,
       FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
)ENGINE=InnoDB;

-- 插入冒泡排序数据
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 0, '5,2,8,1,4', 1, 0, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 0, 1, 1, '2,5,8,1,4', 1, 1, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 2, 3, 1, '2,5,1,8,4', 1, 2, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 3, 4, 1, '2,5,1,4,8', 1, 3, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 1, 2, 2, '2,1,5,4,8', 1, 4, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 2, 3, 2, '2,1,4,5,8', 1, 5, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 0, 1, 3, '1,2,4,5,8', 1, 6, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 4, '1,2,4,5,8', 1, 7, 1);

INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 0, '5,1,3', 2, 0, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 0, 1, 1, '1,5,3', 2, 1, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 1, 2, 1, '1,3,5', 2, 2, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 2, '1,3,5', 2, 3, 1);

INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 0, '4,2,8,6,5', 3, 0, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 0, 1, 1, '2,4,8,6,5', 3, 1, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 1, '2,4,8,6,5', 3, 2, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 2, 3, 1, '2,4,6,8,5', 3, 3, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 3, 4, 1, '2,4,6,5,8', 3, 4, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 2, '2,4,6,5,8', 3, 5, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 2, '2,4,6,5,8', 3, 6, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 2, 3, 2, '2,4,5,6,8', 3, 7, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 3, '2,4,5,6,8', 3, 8, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 3, '2,4,5,6,8', 3, 9, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 4, '2,4,5,6,8', 3, 10, 1);

drop table if exists `insert_sort`;
-- 创建插入排序表
CREATE TABLE if NOT EXISTS `insert_sort` (
                                             `insert_id` INT AUTO_INCREMENT PRIMARY KEY,
                                             `pivot` INT NOT NULL,
                                             `order_pos` INT NOT NULL,
                                             `sorted_list` VARCHAR(50) NOT NULL,
                                             `unsorted_list` VARCHAR(50) NOT NULL,
                                             `curr_list` VARCHAR(50) NOT NULL,
                                             `practice_id` INT NOT NULL,
                                             `process_num` INT NOT NULL,
                                             `turn` INT NOT NULL,
                                             `user_id` INT NOT NULL,
                                             FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
)ENGINE=InnoDB;

-- 插入插入排序数据
INSERT INTO `insert_sort`(`insert_id`,`pivot`,`order_pos`,`sorted_list`,`unsorted_list`,`curr_list`,`practice_id`,`process_num`,`turn`,`user_id`)
VALUES (NULL, 0, 0, '', '5, 2, 8, 1, 4', '5, 2, 8, 1, 4', 1, 0, 0, 1);
INSERT INTO `insert_sort`(`insert_id`,`pivot`,`order_pos`,`sorted_list`,`unsorted_list`,`curr_list`,`practice_id`,`process_num`,`turn`,`user_id`)
VALUES (NULL, 5, 0, '5', '2, 8, 1, 4', '5, 2, 8, 1, 4', 1, 1, 1, 1);
INSERT INTO `insert_sort`(`insert_id`,`pivot`,`order_pos`,`sorted_list`,`unsorted_list`,`curr_list`,`practice_id`,`process_num`,`turn`,`user_id`)
VALUES (NULL, 2, 0, '2, 5', '8, 1, 4', '2, 5, 8, 1, 4', 1, 2, 2, 1);
INSERT INTO `insert_sort`(`insert_id`,`pivot`,`order_pos`,`sorted_list`,`unsorted_list`,`curr_list`,`practice_id`,`process_num`,`turn`,`user_id`)
VALUES (NULL, 8, 2, '2, 5, 8', '1, 4', '2, 5, 8, 1, 4', 1, 3, 3, 1);
INSERT INTO `insert_sort`(`insert_id`,`pivot`,`order_pos`,`sorted_list`,`unsorted_list`,`curr_list`,`practice_id`,`process_num`,`turn`,`user_id`)
VALUES (NULL, 1, 0, '1, 2, 5, 8', '4', '1, 2, 5, 8, 4', 1, 4, 4, 1);
INSERT INTO `insert_sort`(`insert_id`,`pivot`,`order_pos`,`sorted_list`,`unsorted_list`,`curr_list`,`practice_id`,`process_num`,`turn`,`user_id`)
VALUES (NULL, 4, 2, '1, 2, 4, 5, 8', '', '1, 2, 4, 5, 8', 1, 5, 5, 1);

drop table if exists `select_sort`;
-- 创建选择排序表
CREATE TABLE if NOT EXISTS `select_sort` (
                                             `select_id` INT AUTO_INCREMENT PRIMARY KEY,
                                             `exchange` TINYINT NOT NULL,
                                             `min_pos` INT NOT NULL,
                                             `cur_pos` INT NOT NULL,
                                             `turn` INT NOT NULL,
                                             `curr_list` VARCHAR(50) NOT NULL,
                                             `practice_id` INT NOT NULL,
                                             `process_num` INT NOT NULL,
                                             `user_id` INT NOT NULL,
                                             FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
)ENGINE=InnoDB;

-- 插入选择排序数据
INSERT INTO `select_sort`(`select_id`,`exchange`,`min_pos`,`cur_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 0, '5, 2, 8, 1, 4', 1, 0, 1);
INSERT INTO `select_sort`(`select_id`,`exchange`,`min_pos`,`cur_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 3, 0, 1, '1, 2, 8, 5, 4', 1, 1, 1);
INSERT INTO `select_sort`(`select_id`,`exchange`,`min_pos`,`cur_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 1, 1, 2, '1, 2, 8, 5, 4', 1, 2, 1);
INSERT INTO `select_sort`(`select_id`,`exchange`,`min_pos`,`cur_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 4, 2, 3, '1, 2, 4, 5, 8', 1, 3, 1);
INSERT INTO `select_sort`(`select_id`,`exchange`,`min_pos`,`cur_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 3, 3, 4, '1, 2, 4, 5, 8', 1, 4, 1);

CREATE TABLE if NOT EXISTS `study_history` (
                                               `id` INT AUTO_INCREMENT PRIMARY KEY,
                                               `sort_method` INT NOT NULL,
                                               `problem_id` INT NOT NULL,
                                               `last_step` INT NOT NULL,
                                               `curr_time` DATETIME NOT NULL,
                                               `status` INT NOT NULL,
                                               `user_id` INT NOT NULL,
                                               FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
)ENGINE=InnoDB;

#drop table `study_history`;