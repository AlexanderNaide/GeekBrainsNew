/*
CREATE DATABASE  IF NOT EXISTS `spring_hibernate`;
USE `spring_hibernate`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (`id` bigint NOT NULL AUTO_INCREMENT, `name` varchar(255) NOT NULL, PRIMARY KEY (`id`), UNIQUE KEY `UK_3g1j96g94xpk3lpxl2qbl985x` (`name`)) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `users` VALUES (1,'user1'),(10,'user10'),(2,'user2'),(3,'user3'),(4,'user4'),(5,'user5'),(6,'user6'),(7,'user7'),(8,'user8'),(9,'user9');

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (`id` bigint NOT NULL AUTO_INCREMENT, `price` double NOT NULL, `title` varchar(255) NOT NULL, PRIMARY KEY (`id`), UNIQUE KEY `UK_8xtpej5iy2w4cte2trlvrlayy` (`title`)) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `products` VALUES (1,65.6,'Молоко'),(2,75.8,'Кефир'),(3,88.9,'Йогурт'),(4,49.9,'Хлеб'),(5,55.6,'Батон'),(6,244.9,'Огурцы'),(7,180,'Помидоры'),(8,139.99,'Бананы');


DROP TABLE IF EXISTS `buys`;
CREATE TABLE `buys` (`id` bigint NOT NULL AUTO_INCREMENT, `create_date` datetime(6) DEFAULT NULL, `user_id` bigint DEFAULT NULL, PRIMARY KEY (`id`), KEY `FKbag8fyrc0b51cqaehmhi3837q` (`user_id`), CONSTRAINT `FKbag8fyrc0b51cqaehmhi3837q` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `buys` VALUES (1,'2022-12-20 11:26:51.221000',1),(2,'2022-12-20 11:26:51.248000',2),(3,'2022-12-20 11:26:51.266000',7),(4,'2022-12-20 11:26:51.282000',1),(5,'2022-12-20 11:26:51.296000',2),(6,'2022-12-20 11:26:51.311000',3);


DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (`buy_id` bigint NOT NULL, `product_id` bigint NOT NULL, KEY `FKsfqpk5xjv93po29vn4fmy5exq` (`product_id`), KEY `FK3vpbhjw89la1rnwnc18i7sg6` (`buy_id`), CONSTRAINT `FK3vpbhjw89la1rnwnc18i7sg6` FOREIGN KEY (`buy_id`) REFERENCES `buys` (`id`), CONSTRAINT `FKsfqpk5xjv93po29vn4fmy5exq` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `purchase` VALUES (1,1),(1,2),(1,4),(1,5),(2,3),(2,5),(2,7),(3,3),(3,5),(3,8),(3,4),(3,2),(4,1),(4,2),(4,4),(5,1),(5,2),(5,4),(6,1),(6,2),(6,4);
*/
