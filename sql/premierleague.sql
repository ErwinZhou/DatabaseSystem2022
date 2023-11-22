/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : premierleague

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 31/05/2023 14:19:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for club
-- ----------------------------
DROP TABLE IF EXISTS `club`;
CREATE TABLE `club`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `coach` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'Update to 2023.5.22',
  `rank` int(0) NULL DEFAULT NULL COMMENT 'Update to 2023.5.22',
  `area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `points` int(0) NULL DEFAULT NULL COMMENT 'Update to 2023.5.22',
  `home_stadium` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE,
  INDEX `coach_name`(`coach`) USING BTREE,
  INDEX `sta`(`home_stadium`) USING BTREE,
  CONSTRAINT `sta` FOREIGN KEY (`home_stadium`) REFERENCES `pitch` (`name`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of club
-- ----------------------------
INSERT INTO `club` VALUES ('Arsenal', 'Mikel Arteta', 2, 'London', 81, 'Emirates Stadium');
INSERT INTO `club` VALUES ('Aston Villa', 'Unai Emery', 7, 'Birmingham', 58, 'Villa Park');
INSERT INTO `club` VALUES ('Brighton & Hove Albion', 'Roberto De Zerbi', 6, 'Brighton', 61, 'Amex Stadium');
INSERT INTO `club` VALUES ('Chelsea', 'Frank Lampard', 12, 'London', 43, 'Stamford Bridge');
INSERT INTO `club` VALUES ('Liverpool', 'Jürgen Klopp', 5, 'Liverpool', 66, 'Anfield');
INSERT INTO `club` VALUES ('Manchester City', 'Pep Guardiola', 1, 'Manchester', 88, 'Etihad Stadium');
INSERT INTO `club` VALUES ('Manchester United', 'Eric ten Hag', 4, 'Manchester', 69, 'Old Trafford');
INSERT INTO `club` VALUES ('Newcastle United', 'Edward Howe', 3, 'Newcastle', 69, 'St.Jame\'s Park');
INSERT INTO `club` VALUES ('Tottenham Hotspur', 'Ryan Mason', 8, 'London', 57, 'Tottenham Hotspur Stadium');

-- ----------------------------
-- Table structure for coach
-- ----------------------------
DROP TABLE IF EXISTS `coach`;
CREATE TABLE `coach`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `club` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '这个coach指的是所有教练（主教练+助理教练），但助理教练暂时默认不属于任何一家club，可为空',
  `nationality` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE,
  INDEX `club`(`club`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach
-- ----------------------------
INSERT INTO `coach` VALUES ('Edward Howe', 'Newcastle United', 'England', 45);
INSERT INTO `coach` VALUES ('Eric ten Hag', 'Manchester United', 'Netherland', 53);
INSERT INTO `coach` VALUES ('Frank Lampard', 'Chelsea', 'England', 44);
INSERT INTO `coach` VALUES ('Jürgen Klopp', 'Liverpool', 'Germany', 55);
INSERT INTO `coach` VALUES ('Mikel Arteta', 'Arsenal', 'Spain', 41);
INSERT INTO `coach` VALUES ('Pep Guardiola', 'Manchester City', 'Spain', 52);
INSERT INTO `coach` VALUES ('Roberto De Zerbi', 'Brighton & Hove Albion', 'Italy', 43);
INSERT INTO `coach` VALUES ('Ryan Mason', 'Tottenham Hotspur', 'England', 31);
INSERT INTO `coach` VALUES ('Unai Emery', 'Aston Villa', 'Spain', 51);

-- ----------------------------
-- Table structure for defender
-- ----------------------------
DROP TABLE IF EXISTS `defender`;
CREATE TABLE `defender`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `club` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `assist` int(0) NULL DEFAULT NULL,
  `intercept` int(0) NULL DEFAULT NULL,
  `clearence` int(0) NULL DEFAULT NULL,
  `tackle` int(0) NULL DEFAULT NULL,
  `foul` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE,
  INDEX `cubwidhawi`(`club`) USING BTREE,
  CONSTRAINT `cubwidhawi` FOREIGN KEY (`club`) REFERENCES `club` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `player_1` FOREIGN KEY (`name`) REFERENCES `player` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of defender
-- ----------------------------
INSERT INTO `defender` VALUES ('Aaron Wan-Bissaka', 'Manchester United', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Andrew Robertson', 'Liverpool', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Ben Davies', 'Tottenham Hotspur', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('César Azpilicueta', 'Chelsea', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Clément Lenglet', 'Tottenham Hotspur', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Cristian Romero', 'Tottenham Hotspur', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Eric Dier', 'Tottenham Hotspur', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Gabriel Magalhães', 'Arsenal', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Harry Maguire', 'Manchester United', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Ibrahima Konaté', 'Liverpool', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('John Stones', 'Manchester City', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Kalidou Koulibaly', 'Chelsea', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Kyle Walker', 'Manchester City', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Lisandro Martínez', 'Manchester United', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Luke Shaw', 'Manchester United', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Manuel Akanji', 'Manchester City', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Nathan Aké', 'Manchester City', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Oleksandr Zinchenko', 'Arsenal', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Reece James', 'Chelsea', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Takehiro Tomiyasu', 'Arsenal', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Thiago Silva', 'Chelsea', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Trent Alexander-Arnold', 'Liverpool', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('Virgil van Dijk', 'Liverpool', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `defender` VALUES ('William Saliba', 'Arsenal', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for forward
-- ----------------------------
DROP TABLE IF EXISTS `forward`;
CREATE TABLE `forward`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `club` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `shoot` int(0) NULL DEFAULT NULL,
  `goal` int(0) NULL DEFAULT NULL,
  `assist` int(0) NULL DEFAULT NULL,
  `penalty_kick` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE,
  INDEX `club`(`club`) USING BTREE,
  CONSTRAINT `club` FOREIGN KEY (`club`) REFERENCES `club` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `player_3` FOREIGN KEY (`name`) REFERENCES `player` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forward
-- ----------------------------
INSERT INTO `forward` VALUES ('Alexander Isak', 'Newcastle United', 48, 10, 1, 2);
INSERT INTO `forward` VALUES ('Antony Santos', 'Manchester United', 72, 4, 2, 0);
INSERT INTO `forward` VALUES ('Bukayo Saka', 'Arsenal', 86, 13, 11, 2);
INSERT INTO `forward` VALUES ('Cody Gakpo', 'Liverpool', 36, 6, 2, 0);
INSERT INTO `forward` VALUES ('Darwin Núñez', 'Liverpool', 84, 9, 3, 0);
INSERT INTO `forward` VALUES ('Erling Haaland', 'Manchester City', 123, 36, 8, 7);
INSERT INTO `forward` VALUES ('Gabriel Jesus', 'Arsenal', 76, 10, 5, 1);
INSERT INTO `forward` VALUES ('Gabriel Martinelli', 'Arsenal', 79, 15, 5, 0);
INSERT INTO `forward` VALUES ('Harry Kane', 'Tottenham Hotspur', 127, 28, 3, 5);
INSERT INTO `forward` VALUES ('Jack Grealish', 'Manchester City', 41, 5, 7, 0);
INSERT INTO `forward` VALUES ('Julián Álvarez', 'Manchester City', 42, 9, 0, 1);
INSERT INTO `forward` VALUES ('Kai Havertz', 'Chelsea', 71, 7, 1, 1);
INSERT INTO `forward` VALUES ('Kaoru Mitoma', 'Brighton & Hove Albion', 52, 7, 7, 0);
INSERT INTO `forward` VALUES ('Marcus Rashford', 'Manchester United', 102, 17, 5, 0);
INSERT INTO `forward` VALUES ('Mohamed Salah', 'Liverpool', 117, 19, 11, 2);
INSERT INTO `forward` VALUES ('Pierre-Emerick Aubameyang', 'Chelsea', 16, 1, 0, 0);
INSERT INTO `forward` VALUES ('Raheem Sterling', 'Chelsea', 37, 6, 3, 0);
INSERT INTO `forward` VALUES ('Richarlison', 'Tottenham Hotspur', 25, 1, 3, 0);
INSERT INTO `forward` VALUES ('Son Heung-Min', 'Tottenham Hotspur', 80, 10, 5, 0);
INSERT INTO `forward` VALUES ('Wout Weghorst', 'Manchester United', 13, 0, 1, 0);

-- ----------------------------
-- Table structure for goalkeeper
-- ----------------------------
DROP TABLE IF EXISTS `goalkeeper`;
CREATE TABLE `goalkeeper`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `club` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `save` int(0) NULL DEFAULT NULL,
  `clean_sheets` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE,
  INDEX `clunwdijaji`(`club`) USING BTREE,
  CONSTRAINT `clunwdijaji` FOREIGN KEY (`club`) REFERENCES `club` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `player_4` FOREIGN KEY (`name`) REFERENCES `player` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goalkeeper
-- ----------------------------
INSERT INTO `goalkeeper` VALUES ('Aaron Ramsdale', 'Chelsea', 95, 13);
INSERT INTO `goalkeeper` VALUES ('Alisson Becker', 'Liverpool', 108, 14);
INSERT INTO `goalkeeper` VALUES ('David de Gea', 'Manchester United', 99, 17);
INSERT INTO `goalkeeper` VALUES ('Ederson Moraes', 'Manchester City', 43, 11);
INSERT INTO `goalkeeper` VALUES ('Emiliano Martínez', 'Aston Villa', 95, 11);
INSERT INTO `goalkeeper` VALUES ('Hugo Lloris', 'Tottenham Hotspur', 79, 7);
INSERT INTO `goalkeeper` VALUES ('Kepa Arrizabalaga', 'Chelsea', 88, 9);
INSERT INTO `goalkeeper` VALUES ('小元', 'Arsenal', NULL, NULL);

-- ----------------------------
-- Table structure for match
-- ----------------------------
DROP TABLE IF EXISTS `match`;
CREATE TABLE `match`  (
  `kick_off_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `pitch` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `referee` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `home_team` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `visting_team` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`kick_off_time`, `pitch`) USING BTREE,
  INDEX `pitch_name`(`pitch`) USING BTREE,
  INDEX `home team`(`home_team`) USING BTREE,
  INDEX `visiting team`(`visting_team`) USING BTREE,
  INDEX `referee_name`(`referee`) USING BTREE,
  CONSTRAINT `home team` FOREIGN KEY (`home_team`) REFERENCES `club` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pitch_name` FOREIGN KEY (`pitch`) REFERENCES `pitch` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `referee_name` FOREIGN KEY (`referee`) REFERENCES `referee` (`name`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `visiting team` FOREIGN KEY (`visting_team`) REFERENCES `club` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of match
-- ----------------------------
INSERT INTO `match` VALUES ('2023-01-04 13:30:30', 'Old Trafford', 'Stuart Attwell', 'Manchester United', 'Manchester City');
INSERT INTO `match` VALUES ('2023-03-05 17:30:00', 'Anfield', 'Andy Madley', 'Liverpool', 'Manchester United');
INSERT INTO `match` VALUES ('2023-04-23 14:00:00', 'St.Jame\'s Park', 'David Coote', 'Newcastle United', 'Tottenham Hotspur');
INSERT INTO `match` VALUES ('2023-04-26 20:00:00', 'Etihad Stadium', 'Michael Oliver', 'Manchester City', 'Arsenal');

-- ----------------------------
-- Table structure for midfielder
-- ----------------------------
DROP TABLE IF EXISTS `midfielder`;
CREATE TABLE `midfielder`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `club` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pass` int(0) NULL DEFAULT NULL,
  `successful_pass` int(0) NULL DEFAULT NULL,
  `assist` int(0) NULL DEFAULT NULL,
  `intercept` int(0) NULL DEFAULT NULL,
  `tackle` int(0) NULL DEFAULT NULL,
  `goal` int(0) NULL DEFAULT NULL,
  `foul` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE,
  INDEX `clubsdad`(`club`) USING BTREE,
  CONSTRAINT `clubsdad` FOREIGN KEY (`club`) REFERENCES `club` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `player_2` FOREIGN KEY (`name`) REFERENCES `player` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of midfielder
-- ----------------------------
INSERT INTO `midfielder` VALUES ('Alexis Mac Allister', 'Brighton & Hove Albion', NULL, NULL, 2, NULL, NULL, 10, NULL);
INSERT INTO `midfielder` VALUES ('Bernardo Silva', 'Manchester City', NULL, NULL, 5, NULL, NULL, 4, NULL);
INSERT INTO `midfielder` VALUES ('Bruno Fernandes', 'Manchester United', NULL, NULL, 8, NULL, NULL, 7, NULL);
INSERT INTO `midfielder` VALUES ('Bruno Guimarães', 'Newcastle United', NULL, NULL, 5, NULL, NULL, 4, NULL);
INSERT INTO `midfielder` VALUES ('Carlos Casimiro', 'Manchester United', NULL, NULL, 3, NULL, NULL, 4, NULL);
INSERT INTO `midfielder` VALUES ('Christian Erikson', 'Manchester United', NULL, NULL, 8, NULL, NULL, 1, NULL);
INSERT INTO `midfielder` VALUES ('Enzo Fernández', 'Chelsea', NULL, NULL, 2, NULL, NULL, 0, NULL);
INSERT INTO `midfielder` VALUES ('Fabio Tavares(Fabinho)', 'Liverpool', NULL, NULL, 1, NULL, NULL, 0, NULL);
INSERT INTO `midfielder` VALUES ('Granit Xhaka', 'Arsenal', NULL, NULL, 7, NULL, NULL, 5, NULL);
INSERT INTO `midfielder` VALUES ('Harvey Elliott', 'Liverpool', NULL, NULL, 2, NULL, NULL, 1, NULL);
INSERT INTO `midfielder` VALUES ('İlkay Gündoğan', 'Manchester City', NULL, NULL, 4, NULL, NULL, 8, NULL);
INSERT INTO `midfielder` VALUES ('Ivan Perišić', 'Tottenham Hotspur', NULL, NULL, 8, NULL, NULL, 1, NULL);
INSERT INTO `midfielder` VALUES ('Jordan Henderson', 'Liverpool', NULL, NULL, 2, NULL, NULL, 0, NULL);
INSERT INTO `midfielder` VALUES ('Jorge Filho(Jorginho)', 'Arsenal', NULL, NULL, 1, NULL, NULL, 0, NULL);
INSERT INTO `midfielder` VALUES ('Kevin De Bruyne', 'Manchester City', NULL, NULL, 16, NULL, NULL, 7, NULL);
INSERT INTO `midfielder` VALUES ('Martin Ødegaard', 'Arsenal', NULL, NULL, 7, NULL, NULL, 15, NULL);
INSERT INTO `midfielder` VALUES ('Mason Mount', 'Chelsea', NULL, NULL, 2, NULL, NULL, 3, NULL);
INSERT INTO `midfielder` VALUES ('N\'Golo Kanté', 'Chelsea', NULL, NULL, 1, NULL, NULL, 0, NULL);
INSERT INTO `midfielder` VALUES ('Pierre-Emile Højbjerg', 'Tottenham Hotspur', NULL, NULL, 5, NULL, NULL, 4, NULL);
INSERT INTO `midfielder` VALUES ('Rodrigo Bentancur', 'Tottenham Hotspur', NULL, NULL, 2, NULL, NULL, 5, NULL);

-- ----------------------------
-- Table structure for pitch
-- ----------------------------
DROP TABLE IF EXISTS `pitch`;
CREATE TABLE `pitch`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `place` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `club` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`club`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  CONSTRAINT `club_nam` FOREIGN KEY (`club`) REFERENCES `club` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pitch
-- ----------------------------
INSERT INTO `pitch` VALUES ('Emirates Stadium', 'London', 'Arsenal');
INSERT INTO `pitch` VALUES ('Villa Park', 'Birmingham', 'Aston Villa');
INSERT INTO `pitch` VALUES ('Amex Stadium', 'Brighton', 'Brighton & Hove Albion');
INSERT INTO `pitch` VALUES ('Stamford Bridge', 'London', 'Chelsea');
INSERT INTO `pitch` VALUES ('Anfield', 'Liverpool', 'Liverpool');
INSERT INTO `pitch` VALUES ('Etihad Stadium', 'Manchester', 'Manchester City');
INSERT INTO `pitch` VALUES ('Old Trafford', 'Manchester', 'Manchester United');
INSERT INTO `pitch` VALUES ('St.Jame\'s Park', 'Newcastle', 'Newcastle United');
INSERT INTO `pitch` VALUES ('Tottenham Hotspur Stadium', 'London', 'Tottenham Hotspur');

-- ----------------------------
-- Table structure for player
-- ----------------------------
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int(0) NULL DEFAULT NULL COMMENT 'Update to 2023.5.22',
  `nationality` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `transfer_value` int(0) NULL DEFAULT NULL COMMENT 'Update to 2023.5.22 ;  Unit: Euro',
  `club` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'Update to 2023.5.22',
  PRIMARY KEY (`name`) USING BTREE,
  INDEX `club1`(`club`) USING BTREE,
  CONSTRAINT `club1` FOREIGN KEY (`club`) REFERENCES `club` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of player
-- ----------------------------
INSERT INTO `player` VALUES ('Aaron Ramsdale', 25, 'England', 'goalkeeper', 38000000, 'Chelsea');
INSERT INTO `player` VALUES ('Aaron Wan-Bissaka', 25, 'England', 'defender', 22000000, 'Manchester United');
INSERT INTO `player` VALUES ('Alexander Isak', 23, 'Sverige ', 'forward', 50000000, 'Newcastle United');
INSERT INTO `player` VALUES ('Alexis Mac Allister', 24, 'Agentina', 'midfielder', 42000000, 'Brighton & Hove Albion');
INSERT INTO `player` VALUES ('Alisson Becker', 30, 'Brazil', 'goalkeeper', 45000000, 'Liverpool');
INSERT INTO `player` VALUES ('Andrew Robertson', 29, 'Scotland', 'defender', 48000000, 'Liverpool');
INSERT INTO `player` VALUES ('Antony Santos', 23, 'Brazil', 'forward', 70000000, 'Manchester United');
INSERT INTO `player` VALUES ('Ben Davies', 30, 'Wales', 'defender', 20000000, 'Tottenham Hotspur');
INSERT INTO `player` VALUES ('Bernardo Silva', 28, 'Portugal', 'midfielder', 80000000, 'Manchester City');
INSERT INTO `player` VALUES ('Bruno Fernandes', 28, 'Portugal', 'midfielder', 75000000, 'Manchester United');
INSERT INTO `player` VALUES ('Bruno Guimarães', 25, 'Brazil', 'midfielder', 60000000, 'Newcastle United');
INSERT INTO `player` VALUES ('Bukayo Saka', 21, 'England', 'forward', 110000000, 'Arsenal');
INSERT INTO `player` VALUES ('Carlos Casimiro', 31, 'Brazil', 'midfielder', 50000000, 'Manchester United');
INSERT INTO `player` VALUES ('César Azpilicueta', 33, 'Spain', 'defender', 8000000, 'Chelsea');
INSERT INTO `player` VALUES ('Christian Erikson', 31, 'Denmark', 'midfielder', 25000000, 'Manchester United');
INSERT INTO `player` VALUES ('Clément Lenglet', 27, 'France', 'defender', 12000000, 'Tottenham Hotspur');
INSERT INTO `player` VALUES ('Cody Gakpo', 24, 'Netherlands', 'forward', 60000000, 'Liverpool');
INSERT INTO `player` VALUES ('Cristian Romero', 25, 'Agentina', 'defender', 60000000, 'Tottenham Hotspur');
INSERT INTO `player` VALUES ('Darwin Núñez', 23, 'Uruguay', 'forward', 70000000, 'Liverpool');
INSERT INTO `player` VALUES ('David de Gea', 32, 'Spain', 'goalkeeper', 15000000, 'Manchester United');
INSERT INTO `player` VALUES ('Ederson Moraes', 29, 'Brazil', 'goalkeeper', 45000000, 'Manchester City');
INSERT INTO `player` VALUES ('Emiliano Martínez', 30, 'Agentina', 'goalkeeper', 28000000, 'Aston Villa');
INSERT INTO `player` VALUES ('Enzo Fernández', 22, 'Agentina', 'midfielder', 85000000, 'Chelsea');
INSERT INTO `player` VALUES ('Eric Dier', 29, 'England', 'defender', 25000000, 'Tottenham Hotspur');
INSERT INTO `player` VALUES ('Erling Haaland', 22, 'Norway', 'forward', 170000000, 'Manchester City');
INSERT INTO `player` VALUES ('Fabio Tavares(Fabinho)', 29, 'Brazil', 'midfielder', 45000000, 'Liverpool');
INSERT INTO `player` VALUES ('Gabriel Jesus', 26, 'Brazil', 'forward', 75000000, 'Arsenal');
INSERT INTO `player` VALUES ('Gabriel Magalhães', 25, 'Brazil', 'defender', 50000000, 'Arsenal');
INSERT INTO `player` VALUES ('Gabriel Martinelli', 21, 'Brazil', 'forward', 70000000, 'Arsenal');
INSERT INTO `player` VALUES ('Granit Xhaka', 30, 'Swiss', 'midfielder', 28000000, 'Arsenal');
INSERT INTO `player` VALUES ('Harry Kane', 29, 'England', 'forward', 90000000, 'Tottenham Hotspur');
INSERT INTO `player` VALUES ('Harry Maguire', 30, 'England', 'defender', 25000000, 'Manchester United');
INSERT INTO `player` VALUES ('Harvey Elliott', 20, 'England', 'midfielder', 35000000, 'Liverpool');
INSERT INTO `player` VALUES ('Hugo Lloris', 26, 'France', 'goalkeeper', 4000000, 'Tottenham Hotspur');
INSERT INTO `player` VALUES ('Ibrahima Konaté', 24, 'France', 'defender', 35000000, 'Liverpool');
INSERT INTO `player` VALUES ('İlkay Gündoğan', 32, 'Germany', 'midfielder', 25000000, 'Manchester City');
INSERT INTO `player` VALUES ('Ivan Perišić', 34, 'Croatia', 'midfilder', 10000000, 'Tottenham Hotspur');
INSERT INTO `player` VALUES ('Jack Grealish', 27, 'England', 'forward', 70000000, 'Manchester City');
INSERT INTO `player` VALUES ('John Stones', 28, 'England', 'defender', 30000000, 'Manchester City');
INSERT INTO `player` VALUES ('Jordan Henderson', 32, 'England', 'midfielder', 10000000, 'Liverpool');
INSERT INTO `player` VALUES ('Jorge Filho(Jorginho)', 31, 'Italy+Brazil', 'midfielder', 35000000, 'Arsenal');
INSERT INTO `player` VALUES ('Julián Álvarez', 23, 'Agentina', 'forward', 50000000, 'Manchester City');
INSERT INTO `player` VALUES ('Kai Havertz', 23, 'Germany', 'forward', 60000000, 'Chelsea');
INSERT INTO `player` VALUES ('Kalidou Koulibaly', 31, 'Senegal', 'defender', 25000000, 'Chelsea');
INSERT INTO `player` VALUES ('Kaoru Mitoma', 26, 'Japan', 'forward', 22000000, 'Brighton & Hove Albion');
INSERT INTO `player` VALUES ('Kepa Arrizabalaga', 28, 'Spain', 'goalkeeper', 15000000, 'Chelsea');
INSERT INTO `player` VALUES ('Kevin De Bruyne', 31, 'Belgium', 'midfielder', 80000000, 'Manchester City');
INSERT INTO `player` VALUES ('Kyle Walker', 32, 'England', 'defender', 15000000, 'Manchester City');
INSERT INTO `player` VALUES ('Lisandro Martínez', 25, 'Agentina', 'defender', 50000000, 'Manchester United');
INSERT INTO `player` VALUES ('Luke Shaw', 27, 'England', 'defender', 35000000, 'Manchester United');
INSERT INTO `player` VALUES ('Manuel Akanji', 27, 'Swiss', 'defender', 30000000, 'Manchester City');
INSERT INTO `player` VALUES ('Marcus Rashford', 25, 'England', 'forward', 80000000, 'Manchester United');
INSERT INTO `player` VALUES ('Martin Ødegaard', 24, 'Norway', 'midfielder', 80000000, 'Arsenal');
INSERT INTO `player` VALUES ('Mason Mount', 24, 'England', 'midfielder', 65000000, 'Chelsea');
INSERT INTO `player` VALUES ('Mohamed Salah', 30, 'Egypt', 'forward', 70000000, 'Liverpool');
INSERT INTO `player` VALUES ('N\'Golo Kanté', 32, 'France', 'midfielder', 20000000, 'Chelsea');
INSERT INTO `player` VALUES ('Nathan Aké', 28, 'Netherlands', 'defender', 35000000, 'Manchester City');
INSERT INTO `player` VALUES ('Oleksandr Zinchenko', 26, 'Ukraine', 'defender', 40000000, 'Arsenal');
INSERT INTO `player` VALUES ('Pierre-Emerick Aubameyang', 33, 'Gabonese', 'forward', 7000000, 'Chelsea');
INSERT INTO `player` VALUES ('Pierre-Emile Højbjerg', 27, 'Danmark', 'midfielder', 45000000, 'Tottenham Hotspur');
INSERT INTO `player` VALUES ('Raheem Sterling', 28, 'England', 'forward', 60000000, 'Chelsea');
INSERT INTO `player` VALUES ('Reece James', 23, 'England', 'defender', 70000000, 'Chelsea');
INSERT INTO `player` VALUES ('Richarlison', 26, 'Brazil', 'forward', 55000000, 'Tottenham Hotspur');
INSERT INTO `player` VALUES ('Rodrigo Bentancur', 25, 'Uruguay', 'midfielder', 40000000, 'Tottenham Hotspur');
INSERT INTO `player` VALUES ('Son Heung-Min', 30, 'Korea', 'forward', 60000000, 'Tottenham Hotspur');
INSERT INTO `player` VALUES ('Takehiro Tomiyasu', 24, 'Japan', 'defender', 25000000, 'Arsenal');
INSERT INTO `player` VALUES ('Thiago Silva', 38, 'Brazil', 'defender', 2500000, 'Chelsea');
INSERT INTO `player` VALUES ('Trent Alexander-Arnold', 24, 'England', 'defender', 65000000, 'Liverpool');
INSERT INTO `player` VALUES ('Virgil van Dijk', 31, 'Netherlands', 'defender', 45000000, 'Liverpool');
INSERT INTO `player` VALUES ('William Saliba', 22, 'France', 'defender', 55000000, 'Arsenal');
INSERT INTO `player` VALUES ('Wout Weghorst', 30, 'Netherlands', 'forward', 14000000, 'Manchester United');
INSERT INTO `player` VALUES ('小元', 20, 'China', 'goalkeeper', 999, 'Arsenal');

-- ----------------------------
-- Table structure for referee
-- ----------------------------
DROP TABLE IF EXISTS `referee`;
CREATE TABLE `referee`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of referee
-- ----------------------------
INSERT INTO `referee` VALUES ('Andy Madley', 'Male');
INSERT INTO `referee` VALUES ('Anthony Taylor', 'Male');
INSERT INTO `referee` VALUES ('Craig Pawson', 'Male');
INSERT INTO `referee` VALUES ('David Coote', 'Male');
INSERT INTO `referee` VALUES ('Michael Oliver', 'Male');
INSERT INTO `referee` VALUES ('Paul Tierney', 'Male');
INSERT INTO `referee` VALUES ('Peter Bankes', 'Male');
INSERT INTO `referee` VALUES ('Robert Jones', 'Male');
INSERT INTO `referee` VALUES ('Simon Hooper', 'Male');
INSERT INTO `referee` VALUES ('Stuart Attwell', 'Male');

-- ----------------------------
-- View structure for clean_sheets_table
-- ----------------------------
DROP VIEW IF EXISTS `clean_sheets_table`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `clean_sheets_table` AS select `g1`.`name` AS `name`,`g1`.`club` AS `club`,`g1`.`clean_sheets` AS `clean_sheets`,((select count(0) from `goalkeeper` `g2` where (`g2`.`clean_sheets` > `g1`.`clean_sheets`)) + 1) AS `ranking` from `goalkeeper` `g1` order by ((select count(0) from `goalkeeper` `g2` where (`g2`.`clean_sheets` > `g1`.`clean_sheets`)) + 1),`g1`.`name`;

-- ----------------------------
-- View structure for defender_info
-- ----------------------------
DROP VIEW IF EXISTS `defender_info`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `defender_info` AS select `player`.`name` AS `name`,`player`.`club` AS `club`,`player`.`age` AS `age`,`player`.`nationality` AS `nationality`,`player`.`transfer_value` AS `transfer_value`,`defender`.`assist` AS `assist`,`defender`.`intercept` AS `intercept`,`defender`.`clearence` AS `clearence`,`defender`.`tackle` AS `tackle`,`defender`.`foul` AS `foul` from (`player` join `defender`) where (`player`.`name` = `defender`.`name`);

-- ----------------------------
-- View structure for forward_info
-- ----------------------------
DROP VIEW IF EXISTS `forward_info`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `forward_info` AS select `player`.`name` AS `name`,`player`.`club` AS `club`,`player`.`age` AS `age`,`player`.`nationality` AS `nationality`,`player`.`transfer_value` AS `transfer_value`,`forward`.`shoot` AS `shoot`,`forward`.`goal` AS `goal`,`forward`.`assist` AS `assist`,`forward`.`penalty_kick` AS `penalty_kick` from (`player` join `forward`) where (`player`.`name` = `forward`.`name`);

-- ----------------------------
-- View structure for goalkeeper_info
-- ----------------------------
DROP VIEW IF EXISTS `goalkeeper_info`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `goalkeeper_info` AS select `player`.`name` AS `name`,`player`.`club` AS `club`,`player`.`age` AS `age`,`player`.`nationality` AS `nationality`,`player`.`transfer_value` AS `transfer_value`,`goalkeeper`.`save` AS `save`,`goalkeeper`.`clean_sheets` AS `clean_sheets` from (`player` join `goalkeeper`) where (`player`.`name` = `goalkeeper`.`name`);

-- ----------------------------
-- View structure for league_table
-- ----------------------------
DROP VIEW IF EXISTS `league_table`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `league_table` AS select `club`.`name` AS `name`,`club`.`points` AS `points`,`club`.`rank` AS `rank` from `club` order by `club`.`rank`;

-- ----------------------------
-- View structure for midfielder_info
-- ----------------------------
DROP VIEW IF EXISTS `midfielder_info`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `midfielder_info` AS select `player`.`name` AS `name`,`player`.`club` AS `club`,`player`.`age` AS `age`,`player`.`nationality` AS `nationality`,`player`.`transfer_value` AS `transfer_value`,`midfielder`.`goal` AS `goal`,`midfielder`.`assist` AS `assist`,`midfielder`.`pass` AS `pass`,`midfielder`.`successful_pass` AS `successful_pass`,`midfielder`.`intercept` AS `intercept`,`midfielder`.`tackle` AS `tackle`,`midfielder`.`foul` AS `foul` from (`player` join `midfielder`) where (`player`.`name` = `midfielder`.`name`);

-- ----------------------------
-- View structure for top_assist_providers
-- ----------------------------
DROP VIEW IF EXISTS `top_assist_providers`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `top_assist_providers` AS select `m1`.`name` AS `name`,`m1`.`club` AS `club`,`m1`.`assist` AS `assist`,((select count(0) from `midfielder` `m2` where (`m2`.`assist` > `m1`.`assist`)) + 1) AS `ranking` from `midfielder` `m1` order by ((select count(0) from `midfielder` `m2` where (`m2`.`assist` > `m1`.`assist`)) + 1),`m1`.`name`;

-- ----------------------------
-- View structure for top_goal_scorers
-- ----------------------------
DROP VIEW IF EXISTS `top_goal_scorers`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `top_goal_scorers` AS select `f1`.`name` AS `name`,`f1`.`club` AS `club`,`f1`.`goal` AS `goal`,((select count(0) from `forward` `f2` where (`f2`.`goal` > `f1`.`goal`)) + 1) AS `ranking` from `forward` `f1` order by ((select count(0) from `forward` `f2` where (`f2`.`goal` > `f1`.`goal`)) + 1),`f1`.`name`;

-- ----------------------------
-- Function structure for CaculateGoalRanking
-- ----------------------------
DROP FUNCTION IF EXISTS `CaculateGoalRanking`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `CaculateGoalRanking`(forward_name VARCHAR(255)) RETURNS int
    DETERMINISTIC
BEGIN
	DECLARE ranking INTEGER;
	SELECT COUNT(*) INTO ranking FROM forward WHERE goal>=(SELECT goal FROM forward WHERE `name`=forward_name);
	RETURN ranking;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for UpdatePlayerClub
-- ----------------------------
DROP PROCEDURE IF EXISTS `UpdatePlayerClub`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdatePlayerClub`(IN player_name VARCHAR(255), IN new_club VARCHAR(255), INOUT update_result VARCHAR(255))
BEGIN
DECLARE pos VARCHAR(255);
IF new_club NOT IN (SELECT `name` FROM club)  OR player_name NOT IN (SELECT `name` FROM player) THEN
SET update_result = 'Update failed!';
ELSE 
SELECT position INTO pos FROM player WHERE `name`=player_name;
UPDATE player SET club=new_club WHERE `name`=player_name;
IF pos='forward' THEN
	UPDATE forward SET club=new_club WHERE `name`=player_name;
END IF;
IF pos='midfielder' THEN
	UPDATE forward SET club=new_club WHERE `name`=player_name;
END IF;
IF pos='defender' THEN
	UPDATE defender SET club=new_club WHERE `name`=player_name;
END IF;
IF pos='goalkeeper' THEN
	UPDATE goalkeeper SET club=new_club WHERE `name`=player_name;
END IF;
SET update_result = 'Update successfully!';
END IF;  
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for UpdatePlayerClub1
-- ----------------------------
DROP PROCEDURE IF EXISTS `UpdatePlayerClub1`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdatePlayerClub1`(IN player_name VARCHAR(255), IN new_club VARCHAR(255))
BEGIN
DECLARE pos VARCHAR(255); 
SELECT position INTO pos FROM player WHERE `name`=player_name;
UPDATE player SET club=new_club WHERE `name`=player_name;
IF pos='forward' THEN
	UPDATE forward SET club=new_club WHERE `name`=player_name;
END IF;
IF pos='midfielder' THEN
	UPDATE forward SET club=new_club WHERE `name`=player_name;
END IF;
IF pos='defender' THEN
	UPDATE defender SET club=new_club WHERE `name`=player_name;
END IF;
IF pos='goalkeeper' THEN
	UPDATE goalkeeper SET club=new_club WHERE `name`=player_name;
END IF;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for UpdatePlayerPosition
-- ----------------------------
DROP PROCEDURE IF EXISTS `UpdatePlayerPosition`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdatePlayerPosition`(IN player_club VARCHAR(255),IN player_name VARCHAR(255),IN new_pos VARCHAR(255),INOUT update_result VARCHAR(255))
BEGIN
DECLARE old_pos VARCHAR(255);
DECLARE cl VARCHAR(255);# 俱乐部信息
IF new_pos IN ('forward','midfielder','defender','goalkeeper') AND player_name IN (SELECT `name` FROM player) 
AND player_club IN (SELECT club FROM player WHERE `name`=player_name) THEN
	SELECT position INTO old_pos FROM player WHERE `name`=player_name;
	SELECT club INTO cl FROM player WHERE `name`=player_name;
	UPDATE player SET position=new_pos WHERE `name`=player_name;
IF old_pos='forward' THEN
DELETE FROM forward WHERE `name`=player_name;
END IF;
IF old_pos='midfielder' THEN
DELETE FROM midfielder WHERE `name`=player_name;
END IF;
IF old_pos='defender' THEN
DELETE FROM defender WHERE `name`=player_name;
END IF;
IF old_pos='goalkeeper' THEN
DELETE FROM goalkeeper WHERE `name`=player_name;
END IF;
IF new_pos='forward' THEN 
INSERT INTO forward(`name`,club) VALUES(player_name,cl);
END IF;
IF new_pos='midfielder' THEN 
INSERT INTO midfielder(`name`,club) VALUES(player_name,cl);
END IF;
IF new_pos='defender' THEN 
INSERT INTO defender(`name`,club) VALUES(player_name,cl);
END IF;
IF new_pos='goalkeeper' THEN 
INSERT INTO goalkeeper(`name`,club) VALUES(player_name,cl);
END IF;
SET update_result='Update sucessfully!';
ELSE
	SET update_result='Update failed!';
END IF;

END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for UpdatePlayerPosition1
-- ----------------------------
DROP PROCEDURE IF EXISTS `UpdatePlayerPosition1`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdatePlayerPosition1`(IN player_club VARCHAR(255),IN player_name VARCHAR(255),IN new_pos VARCHAR(255))
BEGIN
DECLARE old_pos VARCHAR(255);
DECLARE cl VARCHAR(255);# 俱乐部信息
IF new_pos IN ('forward','midfielder','defender','goalkeeper') AND player_name IN (SELECT `name` FROM player)  
AND player_club IN (SELECT club FROM player WHERE `name`=player_name) THEN
	SELECT position INTO old_pos FROM player WHERE `name`=player_name;
	SELECT club INTO cl FROM player WHERE `name`=player_name;
	UPDATE player SET position=new_pos WHERE `name`=player_name;
IF old_pos='forward' THEN
DELETE FROM forward WHERE `name`=player_name;
END IF;
IF old_pos='midfielder' THEN
DELETE FROM midfielder WHERE `name`=player_name;
END IF;
IF old_pos='defender' THEN
DELETE FROM defender WHERE `name`=player_name;
END IF;
IF old_pos='goalkeeper' THEN
DELETE FROM goalkeeper WHERE `name`=player_name;
END IF;
IF new_pos='forward' THEN 
INSERT INTO forward(`name`,club) VALUES(player_name,cl);
END IF;
IF new_pos='midfielder' THEN 
INSERT INTO midfielder(`name`,club) VALUES(player_name,cl);
END IF;
IF new_pos='defender' THEN 
INSERT INTO defender(`name`,club) VALUES(player_name,cl);
END IF;
IF new_pos='goalkeeper' THEN 
INSERT INTO goalkeeper(`name`,club) VALUES(player_name,cl);
END IF;
ELSE
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Violated PROCEDURE:UpdatePlayerPosition1';
END IF;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
