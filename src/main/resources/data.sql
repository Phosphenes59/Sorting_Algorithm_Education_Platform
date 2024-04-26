-- 创建用户表
CREATE TABLE if NOT EXISTS `user` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `user_name` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `phone` VARCHAR(20) NOT NULL,
    `is_admin` TINYINT NOT NULL
);

-- 插入用户数据
INSERT INTO `user`(`id`,`user_name`,`password`,`email`,`phone`,`is_admin`)
VALUES (NULL, 'Admin', '00000000', 'admin@gmail.com', '11111111', '1');
INSERT INTO `user`(`id`,`user_name`,`password`,`email`,`phone`,`is_admin`)
VALUES (NULL, 'Alice', '88888888', 'alice@gmail.com', '65646564', '0');

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
       FOREIGN KEY (`userid`) REFERENCES `user`(`id`)
);

-- 插入冒泡排序数据
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 0, '1,6,5,3', 1, 0, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 1, '1,6,5,3', 1, 1, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 1, 2, 1, '1,5,6,3', 1, 2, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 2, 3, 1, '1,5,3,6', 1, 3, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 2, '1,5,3,6', 1, 4, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 1, 2, 2, '1,3,5,6', 1, 5, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 3, '1,3,5,6', 1, 6, 1);

INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 0, '4,2,8,6,5', 2, 0, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 0, 1, 1, '2,4,8,6,5', 2, 1, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 1, '2,4,8,6,5', 2, 2, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 2, 3, 1, '2,4,6,8,5', 2, 3, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 3, 4, 1, '2,4,6,5,8', 2, 4, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 2, '2,4,6,5,8', 2, 5, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 2, '2,4,6,5,8', 2, 6, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 2, 3, 2, '2,4,5,6,8', 2, 7, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 3, '2,4,5,6,8', 2, 8, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 3, '2,4,5,6,8', 2, 9, 1);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 4, '2,4,5,6,8', 2, 10, 1);

INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 0, '5,1,3', 3, 0, 2);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 0, 1, 1, '1,5,3', 3, 1, 2);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 1, 1, 2, 1, '1,3,5', 3, 2, 2);
INSERT INTO `bubble_sort`(`bubble_id`,`exchange`,`pre_pos`,`post_pos`,`turn`,`curr_list`,`practice_id`,`process_num`,`user_id`)
VALUES (NULL, 0, 0, 0, 2, '1,3,5', 3, 3, 2);
