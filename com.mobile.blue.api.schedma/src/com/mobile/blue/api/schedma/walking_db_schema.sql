-- ----------------------------
-- before set all tables,set fk_checks
-- ----------------------------
SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Table structure for `APP_USER  `
-- ----------------------------
DROP TABLE IF EXISTS `APP_USER`;
CREATE TABLE `APP_USER` (
  `ID` VARCHAR(100) CHARACTER SET utf8 NOT NULL,
  `NICK_NAME` VARCHAR(30) CHARACTER SET utf8 DEFAULT '',
  `ICON` VARCHAR(100) CHARACTER SET utf8 DEFAULT '',
  `PWD` VARCHAR(150) CHARACTER SET utf8 DEFAULT NULL,
  `TEL` VARCHAR(20) CHARACTER SET utf8 DEFAULT NULL,
  `COUNTRY_CODE` VARCHAR(5) DEFAULT '',
  `TEL_APPROVE_KEY` VARCHAR(10) CHARACTER SET utf8 DEFAULT NULL,
  `COUNTRY` VARCHAR(10) CHARACTER SET utf8 DEFAULT '',
  `TEL_VALUE_FLAG` INT(1) DEFAULT '0',
  `BIRTHDAY` LONG DEFAULT NULL,
  `SEX` INT(2)  DEFAULT '1',
  `PUSH_STATUS` INT(1),
  `LOG` DOUBLE DEFAULT NULL,
  `LAT` DOUBLE DEFAULT NULL,
  `FLOW_COINS` FLOAT DEFAULT '0',
  `MAKE_FLOW` FLOAT DEFAULT '0',
  `USER_FLOW` FLOAT DEFAULT '0',
   `POINT` INT DEFAULT '0',
   `CREDIT` INT DEFAULT '0',
  `CREATED_BY` VARCHAR(45) CHARACTER SET utf8 DEFAULT NULL,
  `CREATED_TIME` DATETIME DEFAULT NULL,
  `UPDATED_BY` VARCHAR(45) CHARACTER SET utf8 DEFAULT NULL,
  `UPDATED_TIME` DATETIME DEFAULT NULL,
  `IS_DELETED` INT(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `APP_USER_SESSION  `
-- ----------------------------
DROP TABLE IF EXISTS `APP_USER_SESSION`;
CREATE TABLE `APP_USER_SESSION` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` VARCHAR(100) DEFAULT NULL,
  `TOKEN` VARCHAR(100) DEFAULT NULL,
  `LOGIN_TYPE` INT(1) DEFAULT NULL,
  `LOGIN_TIME` DATETIME DEFAULT NULL,
  `LOGOUT_TIME` DATETIME DEFAULT NULL,
  `LANG` VARCHAR(10) DEFAULT NULL,
  `DEVICE` VARCHAR(1) DEFAULT NULL,
  `DEVICE_VER_NUM` VARCHAR(10) DEFAULT NULL,
  `IMEI` VARCHAR(20) DEFAULT NULL,
  `MAC` VARCHAR(20) DEFAULT NULL,
   `IMSI` VARCHAR(20) DEFAULT NULL,
  `STATUS` INT(1) DEFAULT NULL,
  `CREATED_BY` VARCHAR(45) DEFAULT NULL,
  `CREATED_TIME` DATETIME DEFAULT NULL,
  `UPDATED_BY` VARCHAR(45) DEFAULT NULL,
  `UPDATED_TIME` DATETIME DEFAULT NULL,
  `IS_DELETED` INT(1) DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `KEY_USER_SESSION` (`USER_ID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- ----------------------------

-- ----------------------------
-- Table structure for `APP_FEED_BACK  `
-- ----------------------------
DRDROP TABLE IF EXISTS `APP_FEED_BACK`;
CREATE TABLE `APP_FEED_BACK` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` VARCHAR(100) DEFAULT NULL,
  `CONTENT` VARCHAR(100) DEFAULT NULL,
  `CREATED_BY` VARCHAR(45) DEFAULT NULL,
  `CREATED_TIME` DATETIME DEFAULT NULL,
  `UPDATED_BY` VARCHAR(45) DEFAULT NULL,
  `UPDATED_TIME` DATETIME DEFAULT NULL,
  `IS_DELETED` INT(1) DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `KEY_USER_SESSION` (`USER_ID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `APP_VERSION_UPDATE `
-- ----------------------------
DROP TABLE IF EXISTS `APP_VERSION_UPDATE`;
CREATE TABLE `APP_VERSION_UPDATE` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `STORE` VARCHAR(50) DEFAULT NULL,
  `CHANNEL` VARCHAR(200) DEFAULT NULL,
  `DEVICE` TINYINT(1) DEFAULT NULL,
  `TYPE` TINYINT(1) DEFAULT NULL,
  `FILE_PATH` VARCHAR(200) DEFAULT NULL,
  `FILE_SIZE` DOUBLE DEFAULT NULL,
  `VERSION_NUM` VARCHAR(20) DEFAULT NULL,
  `DESCRIPTION` VARCHAR(250) DEFAULT NULL,
  `CREATED_BY` VARCHAR(45) DEFAULT NULL,
  `CREATED_TIME` DATETIME DEFAULT NULL,
  `UPDATED_BY` VARCHAR(45) DEFAULT NULL,
  `UPDATED_TIME` DATETIME DEFAULT NULL,
  `IS_DELETED` INT(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `APP_USER_BILL `
-- ----------------------------
DROP TABLE IF EXISTS `APP_USER_BILL`;
CREATE TABLE `APP_USER_BILL` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` VARCHAR(100) DEFAULT NULL,
  `SOURCE_ID` BIGINT(20) DEFAULT NULL,
  `TYPE` TINYINT(1) DEFAULT NULL,
  `DESCRIPTION` VARCHAR(100) DEFAULT '',
  `EXPIRE_TIME`  DATETIME DEFAULT NULL,
  `FLOW_COINS` float DEFAULT '0',
  `REWARD_COINS` float DEFAULT '0',
  `STATUS`  INT(0) DEFAULT '0',
  `CREATED_BY` VARCHAR(45) DEFAULT NULL,
  `CREATED_TIME` DATETIME DEFAULT NULL,
  `UPDATED_BY` VARCHAR(45) DEFAULT NULL,
  `UPDATED_TIME` DATETIME DEFAULT NULL,
  `IS_DELETED` INT(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `APP_USER_SIGN `
-- ----------------------------
DROP TABLE IF EXISTS `APP_USER_SIGN`;
CREATE TABLE `APP_USER_SIGN` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(100) DEFAULT NULL,
  `CREDIT` int(20) DEFAULT '0',
  `EXPIRE_TIME` datetime DEFAULT NULL,
  `CREATED_BY` VARCHAR(45) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(45) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `IS_DELETED` int(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8

-- ----------------------------
-- Table structure for `APP_USER_BILL_LOG `
-- ----------------------------
DROP TABLE IF EXISTS `APP_USER_BILL_LOG`;
CREATE TABLE `APP_USER_BILL_LOG` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `BILL_ID` BIGINT(20) DEFAULT NULL,
  `FLOW_COINS` INT(20) DEFAULT NULL,
  `USER_COIN` INT(20) DEFAULT NULL,
  `DESCRIPTION` VARCHAR(100) DEFAULT '',
  `USER_ID` VARCHAR(100) DEFAULT NULL,
  `CREATED_BY` VARCHAR(45) DEFAULT NULL,
  `CREATED_TIME` DATETIME DEFAULT NULL,
  `UPDATED_BY` VARCHAR(45) DEFAULT NULL,
  `UPDATED_TIME` DATETIME DEFAULT NULL,
  `IS_DELETED` INT(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `APP_SCRATCH`
-- ----------------------------
DROP TABLE IF EXISTS `APP_SCRATCH`;
CREATE TABLE `APP_SCRATCH` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `IMG` BIGINT(20) DEFAULT NULL,
  `FLOW_COINS` FLOAT(10) DEFAULT NULL,
  `DESCRIPTION` VARCHAR(150) DEFAULT NULL,
  `CREATED_BY` VARCHAR(45) DEFAULT NULL,
  `CREATED_TIME` DATETIME DEFAULT NULL,
  `UPDATED_BY` VARCHAR(45) DEFAULT NULL,
  `UPDATED_TIME` DATETIME DEFAULT NULL,
  `IS_DELETED` INT(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `APP_BILL_RECORD`
-- ----------------------------
DROP TABLE IF EXISTS `APP_BILL_RECORD`;
CREATE TABLE `APP_BILL_RECORD` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `TYPE` INT(2) DEFAULT '0',
  `STATUS` INT(1) DEFAULT '0',
  `MAKE_FLOWS` FLOAT(10) DEFAULT '0',
  `DESCRIPTION` VARCHAR(200) DEFAULT NULL,
  `USER_ID` VARCHAR(100) DEFAULT NULL,
  `CREATED_BY` VARCHAR(45) DEFAULT NULL,
  `CREATED_TIME` DATETIME DEFAULT NULL,
  `UPDATED_BY` VARCHAR(45) DEFAULT NULL,
  `UPDATED_TIME` DATETIME DEFAULT NULL,
  `IS_DELETED` INT(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `APP_USER_SCRATCH`
-- ----------------------------
DROP TABLE IF EXISTS `APP_USER_SCRATCH`;
CREATE TABLE `APP_USER_SCRATCH` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `TYPE` INT(2) DEFAULT '0',
  `MAKE_FLOWS` FLOAT(10) DEFAULT '0',
  `DESCRIPTION` VARCHAR(200) DEFAULT NULL,
  `USER_ID` VARCHAR(100) DEFAULT NULL,
  `APP_SCRATCH_ID` BIGINT(20) DEFAULT NULL,
  
  `CREATED_TIME` DATETIME DEFAULT NULL,
  `UPDATED_BY` VARCHAR(45) DEFAULT NULL,
  `UPDATED_TIME` DATETIME DEFAULT NULL,
  `IS_DELETED` INT(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- TABLE STRUCTURE FOR TABLE APP_ACCOUNT_TYPE
-- ----------------------------
DROP TABLE IF EXISTS APP_ACCOUNT_TYPE;
CREATE TABLE APP_ACCOUNT_TYPE(
  ID INT(11) NOT NULL AUTO_INCREMENT,
  CREATED_BY VARCHAR(45) DEFAULT NULL,
  CREATED_TIME DATETIME DEFAULT NULL,
  UPDATED_BY VARCHAR(45) DEFAULT NULL,
  UPDATED_TIME DATETIME DEFAULT NULL,
  IS_DELETED BIT(1) DEFAULT 0,
  
  NAME VARCHAR(100) NOT NULL,
  STATUS BIT(1) DEFAULT 1,
  
  PRIMARY KEY (ID)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

INSERT INTO APP_ACCOUNT_TYPE(ID, NAME, CREATED_BY, CREATED_TIME) VALUES(1, 'FACE_BOOK','system', now());
INSERT INTO APP_ACCOUNT_TYPE(ID, NAME, CREATED_BY, CREATED_TIME) VALUES(2, 'LINE', 'system', now());

-- ----------------------------
-- TABLE STRUCTURE FOR TABLE APP_SNS_ACCOUNT
-- ----------------------------

DROP TABLE IF EXISTS APP_SNS_ACCOUNT;
CREATE TABLE APP_SNS_ACCOUNT(
  ID BIGINT(20) NOT NULL AUTO_INCREMENT,
  CREATED_BY VARCHAR(45) DEFAULT NULL,
  CREATED_TIME DATETIME DEFAULT NULL,
  UPDATED_BY VARCHAR(45) DEFAULT NULL,
  UPDATED_TIME DATETIME DEFAULT NULL,
  IS_DELETED BIT(1) DEFAULT 0,
  
  USER_ID VARCHAR(100) NOT NULL,
  ACCOUNT_TYPE_ID INT(11) NOT NULL,
  SNS_ID VARCHAR(100) NOT NULL,
  STATUS BIT(1) DEFAULT 1,
  
  PRIMARY KEY (ID),
  KEY FK_USER_ID (USER_ID)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS APP_FLOW_PACKAGE;
CREATE TABLE APP_FLOW_PACKAGE(
  ID BIGINT(20) NOT NULL AUTO_INCREMENT,
  CREATED_BY VARCHAR(45) DEFAULT NULL,
  CREATED_TIME DATETIME DEFAULT NULL,
  UPDATED_BY VARCHAR(45) DEFAULT NULL,
  UPDATED_TIME DATETIME DEFAULT NULL,
  IS_DELETED BIT(1) DEFAULT 0,
  
  FLOW_COINS INT(10) DEFAULT '0', 
  EXPIRE_DATE INT(5) DEFAULT '0', 
  
  PRIMARY KEY (ID)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

INSERT INTO APP_FLOW_PACKAGE(ID, FLOW_COINS,EXPIRE_DATE, CREATED_BY, CREATED_TIME) VALUES(1, 10,4,'system', NOW());
INSERT INTO APP_FLOW_PACKAGE(ID, FLOW_COINS,EXPIRE_DATE, CREATED_BY, CREATED_TIME) VALUES(2, 15,4, 'system', NOW());
INSERT INTO APP_FLOW_PACKAGE(ID, FLOW_COINS,EXPIRE_DATE, CREATED_BY, CREATED_TIME) VALUES(3, 20,7,'system', NOW());
INSERT INTO APP_FLOW_PACKAGE(ID, FLOW_COINS,EXPIRE_DATE, CREATED_BY, CREATED_TIME) VALUES(4, 50,10, 'system', NOW());


DROP TABLE IF EXISTS `APP_VISTOR_USER`;
CREATE TABLE `APP_VISTOR_USER` (
  `ID` VARCHAR(100) CHARACTER SET utf8 NOT NULL,
  `NICK_NAME` VARCHAR(30) CHARACTER SET utf8 DEFAULT '',
  `ICON` VARCHAR(100) CHARACTER SET utf8 DEFAULT '',
  `PWD` VARCHAR(150) CHARACTER SET utf8 DEFAULT NULL,
  `TEL` VARCHAR(20) CHARACTER SET utf8 DEFAULT NULL,
  `COUNTRY_CODE` VARCHAR(5) DEFAULT '',
  `TEL_APPROVE_KEY` VARCHAR(10) CHARACTER SET utf8 DEFAULT NULL,
  `COUNTRY` VARCHAR(10) CHARACTER SET utf8 DEFAULT '',
  `TEL_VALUE_FLAG` INT(1) DEFAULT '0',
  `BIRTHDAY` LONG DEFAULT NULL,
  `SEX` INT(2)  DEFAULT '1',
  `PUSH_STATUS` INT(1),
  `LOG` DOUBLE DEFAULT NULL,
  `LAT` DOUBLE DEFAULT NULL,
  `FLOW_COINS` FLOAT DEFAULT '0',
  `MAKE_FLOW` FLOAT DEFAULT '0',
  `USER_FLOW` FLOAT DEFAULT '0',
   `POINT` INT DEFAULT '0',
   `CREDIT` INT DEFAULT '0',
  `CREATED_BY` VARCHAR(45) CHARACTER SET utf8 DEFAULT NULL,
  `CREATED_TIME` DATETIME DEFAULT NULL,
  `UPDATED_BY` VARCHAR(45) CHARACTER SET utf8 DEFAULT NULL,
  `UPDATED_TIME` DATETIME DEFAULT NULL,
  `IS_DELETED` INT(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

insert into `APP_USER` (`ID`, `NICK_NAME`, `ICON`, `PWD`, `TEL`, `COUNTRY_CODE`, `TEL_APPROVE_KEY`, `COUNTRY`, `TEL_VALUE_FLAG`, `BIRTHDAY`, `SEX`, `PUSH_STATUS`, `LOG`, `LAT`, `FLOW_COINS`, `MAKE_FLOW`, `USER_FLOW`, `POINT`, `CREDIT`, `CREATED_BY`, `CREATED_TIME`, `UPDATED_BY`, `UPDATED_TIME`, `IS_DELETED`) values('ae2cb74785ad42758a7187871d27c4a8','','','1234','99999999999','86',NULL,'','2','-28800000','1','1','0','0','0','0','0','0','0','API_CREATE','2015-08-04 14:46:11',NULL,NULL,'0');
insert into `APP_USER_SESSION` (`USER_ID`, `TOKEN`, `LOGIN_TYPE`, `LOGIN_TIME`, `LOGOUT_TIME`, `LANG`, `DEVICE`, `DEVICE_VER_NUM`, `IMEI`, `MAC`, `IMSI`, `STATUS`, `CREATED_BY`, `CREATED_TIME`, `UPDATED_BY`, `UPDATED_TIME`, `IS_DELETED`) values('ae2cb74785ad42758a7187871d27c4a8','6a6dde3e-e927-4ea4-bc54-4676b2de2c57',NULL,'2015-08-04 14:46:11',NULL,'zh_CN',NULL,NULL,'dsaf','adsf','ads','1','API_CREATE','2015-08-04 14:46:11','API_UPDATE','2015-08-12 17:33:37','0');


-- after set all tables,set fk_checks
-- ----------------------------
SET FOREIGN_KEY_CHECKS = 1;
