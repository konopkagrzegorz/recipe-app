CREATE TABLE `category` (`id` bigint not null auto_increment, `category_name` varchar(255), primary key (`id`)) engine=InnoDB;
CREATE TABLE `ingredient` (`id` bigint not null auto_increment, `amount` decimal(19,2), `description` varchar(255), `recipe_id` bigint, `uom_id` bigint, primary key (`id`)) engine=InnoDB;
CREATE TABLE `notes` (`id` bigint not null auto_increment, `note` longtext, `recipe_id` bigint, primary key (`id`)) engine=InnoDB;
CREATE TABLE `recipes` (`id` bigint not null auto_increment, `cook_time` integer, `description` varchar(255), `difficulty` varchar(255), `directions` longtext, `image` longblob, `prep_time` integer, `servings` integer, `source` varchar(255), `url` varchar(255), `notes_id` bigint, primary key (`id`)) engine=InnoDB;
CREATE TABLE `recipe_category` (`recipe_id` bigint not null, `category_id` bigint not null, primary key (`recipe_id`, `category_id`)) engine=InnoDB;
CREATE TABLE `unit_of_measure` (`id` bigint not null auto_increment, `uom` varchar(255), primary key (`id`)) engine=InnoDB;
ALTER TABLE `ingredient` add constraint `FKj0s4ywmqqqw4h5iommigh5yja` foreign key (`recipe_id`) references recipe (`id`);
ALTER TABLE `ingredient` add constraint `FK6iv5l89qmitedn5m2a71kta2t` foreign key (`uom_id`) references unit_of_measure (`id`);
ALTER TABLE `notes` add constraint `FKdbfsiv21ocsbt63sd6fg0t3c8` foreign key (`recipe_id`) references recipe (`id`);
ALTER TABLE `recipes` add constraint `FK37al6kcbdasgfnut9xokktie9` foreign key (`notes_id`) references notes (`id`);
ALTER TABLE `recipe_category` add constraint `FKqsi87i8d4qqdehlv2eiwvpwb` foreign key (`category_id`) references category (`id`);
ALTER TABLE `recipe_category` add constraint `FKcqlqnvfyarhieewfeayk3v25v` foreign key (`recipe_id`) references recipe (`id`);

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
);
 
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);
 
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `user_fk_idx` (`user_id`),
  KEY `role_fk_idx` (`role_id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);

INSERT INTO `role` (`role`) VALUES ('ROLE_USER');
INSERT INTO `role` (`role`) VALUES ('ROLE_ADMIN');

INSERT INTO `user` (`username`, `password`) VALUES ('admin', '$2y$12$GHVKORlotJJAJihrP7nsbO3Z1VscGEkYDjq.GcLB7rGa1086iJSVe');
INSERT INTO `user` (`username`, `password`) VALUES ('user', '$2a$12$To4.4pJNo9Y4nm6nZsWRketmsTUPjt6MbFraPNb6b84wUIzbKRBHC');

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (1, 2);
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (2, 1);