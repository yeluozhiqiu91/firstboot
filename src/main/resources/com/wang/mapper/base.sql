
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for homemadeinstrument
-- ----------------------------
DROP TABLE IF EXISTS `base`;
CREATE TABLE `base`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `taskName` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
   `pageId` decimal(42, 0) NULL DEFAULT NULL,
  `url` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,

  `c1` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c2` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c3` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c4` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c5` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c6` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c7` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c8` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c9` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c10` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c11` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c12` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c13` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c14` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c15` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c16` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c17` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c18` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c19`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c20`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c21` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c22` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c23` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
    `c24` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c25` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c26` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c27` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c28` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c29` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c30` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c31` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c32` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c33` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c34` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c35` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c36` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c37` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c38` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c39` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c40` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c41` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c42` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c43` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c44` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c45` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c46` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c47` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c48` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c49` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `c50` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,


  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'base' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;