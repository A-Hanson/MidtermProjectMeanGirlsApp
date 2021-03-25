-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema meangirlsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `meangirlsdb` ;

-- -----------------------------------------------------
-- Schema meangirlsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `meangirlsdb` DEFAULT CHARACTER SET utf8 ;
USE `meangirlsdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(200) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `enabled` TINYINT NULL,
  `role` VARCHAR(45) NULL,
  `username` VARCHAR(50) NOT NULL,
  `first_name` VARCHAR(100) NULL,
  `last_name` VARCHAR(100) NULL,
  `birthday_date` DATE NULL,
  `created_date` DATETIME NULL,
  `gender` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `student` ;

CREATE TABLE IF NOT EXISTS `student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `first_name` VARCHAR(60) NULL,
  `last_name` VARCHAR(60) NULL,
  `gender` VARCHAR(45) NULL,
  `grade_level` INT NULL,
  `created_date` DATETIME NULL,
  `birthday_date` DATE NULL,
  `image_url` VARCHAR(10000) NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_character_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_character_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `character_property_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `character_property_details` ;

CREATE TABLE IF NOT EXISTS `character_property_details` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `character_properties`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `character_properties` ;

CREATE TABLE IF NOT EXISTS `character_properties` (
  `character_id` INT NOT NULL,
  `character_property_details_id` INT NOT NULL,
  INDEX `fk_character_properties_character1_idx` (`character_id` ASC),
  INDEX `fk_character_properties_character_property_details1_idx` (`character_property_details_id` ASC),
  CONSTRAINT `fk_character_properties_character1`
    FOREIGN KEY (`character_id`)
    REFERENCES `student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_character_properties_character_property_details1`
    FOREIGN KEY (`character_property_details_id`)
    REFERENCES `character_property_details` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clique`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clique` ;

CREATE TABLE IF NOT EXISTS `clique` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `min_fetch_level` INT NULL,
  `image_url` VARCHAR(10000) NULL,
  `description` VARCHAR(100) NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comment` ;

CREATE TABLE IF NOT EXISTS `comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` TEXT(1000) NULL,
  `student_id` INT NOT NULL,
  `created_date` DATETIME NULL,
  `last_edited` DATETIME NULL,
  `enabled` TINYINT NULL,
  `replying_to` INT NULL,
  `flagged` TINYINT NULL,
  `clique_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_character1_idx` (`student_id` ASC),
  INDEX `fk_comment_comment1_idx` (`replying_to` ASC),
  INDEX `fk_comment_clique1_idx` (`clique_id` ASC),
  CONSTRAINT `fk_comment_character1`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_comment1`
    FOREIGN KEY (`replying_to`)
    REFERENCES `comment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_clique1`
    FOREIGN KEY (`clique_id`)
    REFERENCES `clique` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_clique`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `student_clique` ;

CREATE TABLE IF NOT EXISTS `student_clique` (
  `student_id` INT NOT NULL,
  `clique_id` INT NOT NULL,
  INDEX `fk_character_chat_space_character1_idx` (`student_id` ASC),
  INDEX `fk_character_clique_clique1_idx` (`clique_id` ASC),
  CONSTRAINT `fk_character_chat_space_character1`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_character_clique_clique1`
    FOREIGN KEY (`clique_id`)
    REFERENCES `clique` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `badge`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `badge` ;

CREATE TABLE IF NOT EXISTS `badge` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(1000) NULL,
  `image_url` VARCHAR(1000) NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_badge`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `student_badge` ;

CREATE TABLE IF NOT EXISTS `student_badge` (
  `student_id` INT NOT NULL,
  `badge_id` INT NOT NULL,
  INDEX `fk_character_badge_character1_idx` (`student_id` ASC),
  INDEX `fk_character_badge_badge1_idx` (`badge_id` ASC),
  CONSTRAINT `fk_character_badge_character1`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_character_badge_badge1`
    FOREIGN KEY (`badge_id`)
    REFERENCES `badge` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `burn_book_page`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `burn_book_page` ;

CREATE TABLE IF NOT EXISTS `burn_book_page` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `c_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_burn_book_page_character1_idx` (`c_id` ASC),
  CONSTRAINT `fk_burn_book_page_character1`
    FOREIGN KEY (`c_id`)
    REFERENCES `student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cafeteria_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cafeteria_comment` ;

CREATE TABLE IF NOT EXISTS `cafeteria_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `student_id` INT NOT NULL,
  `content` TEXT(1000) NULL,
  `created_date` DATETIME NULL,
  `last_edited` DATETIME NULL,
  `fetch_score` INT NULL,
  `visible` TINYINT NULL,
  `replying_to` INT NULL,
  `flagged` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cafeteria_comment_character1_idx` (`student_id` ASC),
  INDEX `fk_cafeteria_comment_cafeteria_comment1_idx` (`replying_to` ASC),
  CONSTRAINT `fk_cafeteria_comment_character1`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cafeteria_comment_cafeteria_comment1`
    FOREIGN KEY (`replying_to`)
    REFERENCES `cafeteria_comment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `burn_book_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `burn_book_comment` ;

CREATE TABLE IF NOT EXISTS `burn_book_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` TEXT(500) NULL,
  `enabled` TINYINT NULL,
  `flagged` TINYINT NULL,
  `author_id` INT NOT NULL,
  `created_date` DATETIME NULL,
  `student_id` INT NOT NULL,
  `vote` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_burn_book_comment_character1_idx` (`author_id` ASC),
  INDEX `fk_burn_book_comment_student1_idx` (`student_id` ASC),
  CONSTRAINT `fk_burn_book_comment_character1`
    FOREIGN KEY (`author_id`)
    REFERENCES `student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_burn_book_comment_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comment_vote`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comment_vote` ;

CREATE TABLE IF NOT EXISTS `comment_vote` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `vote` TINYINT NULL,
  `student_id` INT NOT NULL,
  `comment_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_vote_student1_idx` (`student_id` ASC),
  INDEX `fk_comment_vote_comment1_idx` (`comment_id` ASC),
  CONSTRAINT `fk_comment_vote_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_vote_comment1`
    FOREIGN KEY (`comment_id`)
    REFERENCES `comment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `book_comment_vote`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `book_comment_vote` ;

CREATE TABLE IF NOT EXISTS `book_comment_vote` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `vote` TINYINT NULL,
  `burn_book_comment_id` INT NOT NULL,
  `student_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_book_comment_vote_burn_book_comment1_idx` (`burn_book_comment_id` ASC),
  INDEX `fk_book_comment_vote_student1_idx` (`student_id` ASC),
  CONSTRAINT `fk_book_comment_vote_burn_book_comment1`
    FOREIGN KEY (`burn_book_comment_id`)
    REFERENCES `burn_book_comment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_book_comment_vote_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS meangirlsuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'meangirlsuser'@'localhost' IDENTIFIED BY 'meangirlsuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'meangirlsuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `meangirlsdb`;
INSERT INTO `user` (`id`, `email`, `password`, `enabled`, `role`, `username`, `first_name`, `last_name`, `birthday_date`, `created_date`, `gender`) VALUES (1, 'admin@gmail.com', 'admin', 1, 'admin', 'adminuser', 'Adam', 'Mid', '1983-07-04', '2021-03-04 08:15:00', 'Male');
INSERT INTO `user` (`id`, `email`, `password`, `enabled`, `role`, `username`, `first_name`, `last_name`, `birthday_date`, `created_date`, `gender`) VALUES (2, 'user@gmail.com', 'user', 1, 'user', 'user2020', 'Eric', 'Paulson', '1952-05-25', '2021-03-05 05:33:00', 'Male');

COMMIT;


-- -----------------------------------------------------
-- Data for table `student`
-- -----------------------------------------------------
START TRANSACTION;
USE `meangirlsdb`;
INSERT INTO `student` (`id`, `user_id`, `first_name`, `last_name`, `gender`, `grade_level`, `created_date`, `birthday_date`, `image_url`, `enabled`) VALUES (1, 2, 'Regina', 'George', 'Female', 11, '2020-03-19 00:00:00', '1991-01-01', 'https://smulook.com/wp-content/uploads/2020/09/regina-on-the-phone.jpg', 1);
INSERT INTO `student` (`id`, `user_id`, `first_name`, `last_name`, `gender`, `grade_level`, `created_date`, `birthday_date`, `image_url`, `enabled`) VALUES (2, 2, 'Cady', 'Lohan', 'Female', 11, '2020-03-23 00:00:00', '1990-04-04', NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `clique`
-- -----------------------------------------------------
START TRANSACTION;
USE `meangirlsdb`;
INSERT INTO `clique` (`id`, `name`, `min_fetch_level`, `image_url`, `description`, `enabled`) VALUES (1, 'Cafeteria', -500, NULL, 'Place to eat and talk', 1);
INSERT INTO `clique` (`id`, `name`, `min_fetch_level`, `image_url`, `description`, `enabled`) VALUES (2, 'The Plastics', 10, NULL, 'The Plastics are the most popular girls of North Shore High School!', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `meangirlsdb`;
INSERT INTO `comment` (`id`, `content`, `student_id`, `created_date`, `last_edited`, `enabled`, `replying_to`, `flagged`, `clique_id`) VALUES (1, 'Hi everyone! i cant help that im so popular', 1, '2020-03-19 00:00:00', '2020-03-19 00:00:00', 1, NULL, 0, 1);
INSERT INTO `comment` (`id`, `content`, `student_id`, `created_date`, `last_edited`, `enabled`, `replying_to`, `flagged`, `clique_id`) VALUES (2, 'We are so fetch!', 2, '2020-03-23 00:00:00', '2020-03-23 00:00:00', 1, 1, 0, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `student_clique`
-- -----------------------------------------------------
START TRANSACTION;
USE `meangirlsdb`;
INSERT INTO `student_clique` (`student_id`, `clique_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `badge`
-- -----------------------------------------------------
START TRANSACTION;
USE `meangirlsdb`;
INSERT INTO `badge` (`id`, `name`, `description`, `image_url`, `enabled`) VALUES (1, 'First Day', 'First day at North Shore High School', 'resources/images/firstDay.jpeg', NULL);
INSERT INTO `badge` (`id`, `name`, `description`, `image_url`, `enabled`) VALUES (2, 'First Comment', 'Have a conversation in the cafeteria', 'resources/images/firstCafeteriaComment.png', NULL);
INSERT INTO `badge` (`id`, `name`, `description`, `image_url`, `enabled`) VALUES (3, 'Social Climber', 'Finally cool enough to sit with the plastics', 'resources/images/plasticsClique.gif', NULL);
INSERT INTO `badge` (`id`, `name`, `description`, `image_url`, `enabled`) VALUES (4, 'Gossip Queen', 'First Burn Book Comment', 'resources/images/gossip.jpeg', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `student_badge`
-- -----------------------------------------------------
START TRANSACTION;
USE `meangirlsdb`;
INSERT INTO `student_badge` (`student_id`, `badge_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `burn_book_comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `meangirlsdb`;
INSERT INTO `burn_book_comment` (`id`, `content`, `enabled`, `flagged`, `author_id`, `created_date`, `student_id`, `vote`) VALUES (1, 'Regina George is super fetch', 1, 0, 1, '2020-03-19 00:00:00', 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `comment_vote`
-- -----------------------------------------------------
START TRANSACTION;
USE `meangirlsdb`;
INSERT INTO `comment_vote` (`id`, `vote`, `student_id`, `comment_id`) VALUES (1, 1, 1, 1);
INSERT INTO `comment_vote` (`id`, `vote`, `student_id`, `comment_id`) VALUES (2, 1, 2, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `book_comment_vote`
-- -----------------------------------------------------
START TRANSACTION;
USE `meangirlsdb`;
INSERT INTO `book_comment_vote` (`id`, `vote`, `burn_book_comment_id`, `student_id`) VALUES (1, 1, 1, 1);

COMMIT;

