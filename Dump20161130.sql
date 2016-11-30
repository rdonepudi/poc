CREATE DATABASE  IF NOT EXISTS `osi_fw` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `osi_fw`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: osi_fw
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `databasechangelog`
--

DROP TABLE IF EXISTS `databasechangelog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) default NULL,
  `DESCRIPTION` varchar(255) default NULL,
  `COMMENTS` varchar(255) default NULL,
  `TAG` varchar(255) default NULL,
  `LIQUIBASE` varchar(20) default NULL,
  `CONTEXTS` varchar(255) default NULL,
  `LABELS` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databasechangelog`
--

LOCK TABLES `databasechangelog` WRITE;
/*!40000 ALTER TABLE `databasechangelog` DISABLE KEYS */;
INSERT INTO `databasechangelog` VALUES ('00000000000001','jhipster','classpath:config/liquibase/changelog/00000000000000_initial_schema.xml','2016-11-29 00:26:43',1,'EXECUTED','7:c962f621df488c2419ca7d991c18f12c','createTable, createIndex (x2), createTable (x2), addPrimaryKey, createTable, addForeignKeyConstraint (x3), loadData, dropDefaultValue, loadData (x2), createTable (x2), addPrimaryKey, createIndex (x2), addForeignKeyConstraint','',NULL,'3.4.2',NULL,NULL);
/*!40000 ALTER TABLE `databasechangelog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `databasechangeloglock`
--

DROP TABLE IF EXISTS `databasechangeloglock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime default NULL,
  `LOCKEDBY` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databasechangeloglock`
--

LOCK TABLES `databasechangeloglock` WRITE;
/*!40000 ALTER TABLE `databasechangeloglock` DISABLE KEYS */;
INSERT INTO `databasechangeloglock` VALUES (1,'\0',NULL,NULL);
/*!40000 ALTER TABLE `databasechangeloglock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_authority`
--

DROP TABLE IF EXISTS `jhi_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_authority` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY  (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_authority`
--

LOCK TABLES `jhi_authority` WRITE;
/*!40000 ALTER TABLE `jhi_authority` DISABLE KEYS */;
INSERT INTO `jhi_authority` VALUES ('ROLE_ADMIN'),('ROLE_USER');
/*!40000 ALTER TABLE `jhi_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_persistent_audit_event`
--

DROP TABLE IF EXISTS `jhi_persistent_audit_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_persistent_audit_event` (
  `event_id` bigint(20) NOT NULL auto_increment,
  `principal` varchar(50) NOT NULL,
  `event_date` timestamp NULL default NULL,
  `event_type` varchar(255) default NULL,
  PRIMARY KEY  (`event_id`),
  KEY `idx_persistent_audit_event` (`principal`,`event_date`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_persistent_audit_event`
--

LOCK TABLES `jhi_persistent_audit_event` WRITE;
/*!40000 ALTER TABLE `jhi_persistent_audit_event` DISABLE KEYS */;
INSERT INTO `jhi_persistent_audit_event` VALUES (1,'admin','2016-11-28 18:57:47','AUTHENTICATION_SUCCESS');
/*!40000 ALTER TABLE `jhi_persistent_audit_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_persistent_audit_evt_data`
--

DROP TABLE IF EXISTS `jhi_persistent_audit_evt_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_persistent_audit_evt_data` (
  `event_id` bigint(20) NOT NULL,
  `name` varchar(150) NOT NULL,
  `value` varchar(255) default NULL,
  PRIMARY KEY  (`event_id`,`name`),
  KEY `idx_persistent_audit_evt_data` (`event_id`),
  CONSTRAINT `fk_evt_pers_audit_evt_data` FOREIGN KEY (`event_id`) REFERENCES `jhi_persistent_audit_event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_persistent_audit_evt_data`
--

LOCK TABLES `jhi_persistent_audit_evt_data` WRITE;
/*!40000 ALTER TABLE `jhi_persistent_audit_evt_data` DISABLE KEYS */;
INSERT INTO `jhi_persistent_audit_evt_data` VALUES (1,'remoteAddress','0:0:0:0:0:0:0:1');
/*!40000 ALTER TABLE `jhi_persistent_audit_evt_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_persistent_token`
--

DROP TABLE IF EXISTS `jhi_persistent_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_persistent_token` (
  `series` varchar(76) NOT NULL,
  `user_id` bigint(20) default NULL,
  `token_value` varchar(76) NOT NULL,
  `token_date` date default NULL,
  `ip_address` varchar(39) default NULL,
  `user_agent` varchar(255) default NULL,
  PRIMARY KEY  (`series`),
  KEY `fk_user_persistent_token` (`user_id`),
  CONSTRAINT `fk_user_persistent_token` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_persistent_token`
--

LOCK TABLES `jhi_persistent_token` WRITE;
/*!40000 ALTER TABLE `jhi_persistent_token` DISABLE KEYS */;
INSERT INTO `jhi_persistent_token` VALUES ('n0R0xF9wgjXx3gNuRDlALQ==',3,'gQG4c8Sj9btKUVxQgMRAbA==','2016-11-29','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36');
/*!40000 ALTER TABLE `jhi_persistent_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_user`
--

DROP TABLE IF EXISTS `jhi_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_user` (
  `id` bigint(20) NOT NULL auto_increment,
  `login` varchar(50) NOT NULL,
  `password_hash` varchar(60) default NULL,
  `first_name` varchar(50) default NULL,
  `last_name` varchar(50) default NULL,
  `email` varchar(100) default NULL,
  `activated` bit(1) NOT NULL,
  `lang_key` varchar(5) default NULL,
  `activation_key` varchar(20) default NULL,
  `reset_key` varchar(20) default NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` timestamp NOT NULL,
  `reset_date` timestamp NULL default NULL,
  `last_modified_by` varchar(50) default NULL,
  `last_modified_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `idx_user_login` (`login`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `idx_user_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_user`
--

LOCK TABLES `jhi_user` WRITE;
/*!40000 ALTER TABLE `jhi_user` DISABLE KEYS */;
INSERT INTO `jhi_user` VALUES (1,'system','$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG','System','System','system@localhost','','en',NULL,NULL,'system','2016-11-28 18:56:43',NULL,'system',NULL),(2,'anonymoususer','$2a$10$j8S5d7Sr7.8VTOYNviDPOeWX8KcYILUVJBsYV83Y5NtECayypx9lO','Anonymous','User','anonymous@localhost','','en',NULL,NULL,'system','2016-11-28 18:56:43',NULL,'system',NULL),(3,'admin','$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC','Administrator','Administrator','admin@localhost','','en',NULL,NULL,'system','2016-11-28 18:56:43',NULL,'system',NULL),(4,'user','$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K','User','User','user@localhost','','en',NULL,NULL,'system','2016-11-28 18:56:43',NULL,'system',NULL);
/*!40000 ALTER TABLE `jhi_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_user_authority`
--

DROP TABLE IF EXISTS `jhi_user_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_user_authority` (
  `user_id` bigint(20) NOT NULL,
  `authority_name` varchar(50) NOT NULL,
  PRIMARY KEY  (`user_id`,`authority_name`),
  KEY `fk_authority_name` (`authority_name`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`),
  CONSTRAINT `fk_authority_name` FOREIGN KEY (`authority_name`) REFERENCES `jhi_authority` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_user_authority`
--

LOCK TABLES `jhi_user_authority` WRITE;
/*!40000 ALTER TABLE `jhi_user_authority` DISABLE KEYS */;
INSERT INTO `jhi_user_authority` VALUES (1,'ROLE_ADMIN'),(3,'ROLE_ADMIN'),(1,'ROLE_USER'),(3,'ROLE_USER'),(4,'ROLE_USER');
/*!40000 ALTER TABLE `jhi_user_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osi_attachments`
--

DROP TABLE IF EXISTS `osi_attachments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osi_attachments` (
  `id` int(11) NOT NULL auto_increment,
  `attachment` blob NOT NULL,
  `attachment_type` varchar(100) NOT NULL,
  `user_id` int(11) NOT NULL,
  `created_by` int(11) default NULL,
  `created_date` timestamp NULL default NULL,
  `updated_by` int(11) default NULL,
  `updated_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`),
  KEY `osi_attachments_osi_user` (`user_id`),
  CONSTRAINT `osi_attachments_osi_user` FOREIGN KEY (`user_id`) REFERENCES `osi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osi_attachments`
--

LOCK TABLES `osi_attachments` WRITE;
/*!40000 ALTER TABLE `osi_attachments` DISABLE KEYS */;
/*!40000 ALTER TABLE `osi_attachments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osi_functions`
--

DROP TABLE IF EXISTS `osi_functions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osi_functions` (
  `id` int(11) NOT NULL auto_increment,
  `func_type` varchar(1000) NOT NULL,
  `func_value` text NOT NULL,
  `parameters` text,
  `created_by` int(11) default NULL,
  `created_date` timestamp NULL default NULL,
  `updated_by` int(11) default NULL,
  `updated_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osi_functions`
--

LOCK TABLES `osi_functions` WRITE;
/*!40000 ALTER TABLE `osi_functions` DISABLE KEYS */;
/*!40000 ALTER TABLE `osi_functions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osi_lookup_types`
--

DROP TABLE IF EXISTS `osi_lookup_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osi_lookup_types` (
  `id` int(11) NOT NULL auto_increment,
  `lookup_name` varchar(50) NOT NULL,
  `lookup_code` varchar(100) NOT NULL,
  `created_by` int(11) default NULL,
  `created_date` timestamp NULL default NULL,
  `updated_by` int(11) default NULL,
  `updated_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osi_lookup_types`
--

LOCK TABLES `osi_lookup_types` WRITE;
/*!40000 ALTER TABLE `osi_lookup_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `osi_lookup_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osi_lookup_values`
--

DROP TABLE IF EXISTS `osi_lookup_values`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osi_lookup_values` (
  `id` int(11) NOT NULL auto_increment,
  `lookup_value` varchar(50) NOT NULL,
  `lookup_desc` varchar(100) NOT NULL,
  `lookup_type_id` int(11) NOT NULL,
  `created_by` int(11) default NULL,
  `created_date` timestamp NULL default NULL,
  `updated_by` int(11) default NULL,
  `updated_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`),
  KEY `osi_lookup_values_osi_lookup_types` (`lookup_type_id`),
  CONSTRAINT `osi_lookup_values_osi_lookup_types` FOREIGN KEY (`lookup_type_id`) REFERENCES `osi_lookup_types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osi_lookup_values`
--

LOCK TABLES `osi_lookup_values` WRITE;
/*!40000 ALTER TABLE `osi_lookup_values` DISABLE KEYS */;
/*!40000 ALTER TABLE `osi_lookup_values` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osi_menu_entries`
--

DROP TABLE IF EXISTS `osi_menu_entries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osi_menu_entries` (
  `id` int(11) NOT NULL auto_increment,
  `seq` int(11) NOT NULL,
  `menu_prompt` varchar(100) NOT NULL,
  `menu_id` int(11) NOT NULL,
  `sub_menu_id` int(11) default NULL,
  `func_id` int(11) default NULL,
  `created_by` int(11) default NULL,
  `created_date` timestamp NULL default NULL,
  `updated_by` int(11) default NULL,
  `updated_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`),
  KEY `osi_menu_entries_osi_functions` (`func_id`),
  KEY `osi_menu_entries_osi_menus` (`menu_id`),
  KEY `osi_menu_entries_osi_menus1` (`sub_menu_id`),
  CONSTRAINT `osi_menu_entries_osi_functions` FOREIGN KEY (`func_id`) REFERENCES `osi_functions` (`id`),
  CONSTRAINT `osi_menu_entries_osi_menus` FOREIGN KEY (`menu_id`) REFERENCES `osi_menus` (`id`),
  CONSTRAINT `osi_menu_entries_osi_menus1` FOREIGN KEY (`sub_menu_id`) REFERENCES `osi_menus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osi_menu_entries`
--

LOCK TABLES `osi_menu_entries` WRITE;
/*!40000 ALTER TABLE `osi_menu_entries` DISABLE KEYS */;
/*!40000 ALTER TABLE `osi_menu_entries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osi_menus`
--

DROP TABLE IF EXISTS `osi_menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osi_menus` (
  `id` int(11) NOT NULL auto_increment,
  `menu_name` varchar(1000) NOT NULL,
  `description` varchar(1000) default NULL,
  `created_by` int(11) default NULL,
  `created_date` timestamp NULL default NULL,
  `updated_by` int(11) default NULL,
  `updated_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osi_menus`
--

LOCK TABLES `osi_menus` WRITE;
/*!40000 ALTER TABLE `osi_menus` DISABLE KEYS */;
INSERT INTO `osi_menus` VALUES (2,'Administration11','Administration11',NULL,NULL,1,'2016-11-29 09:05:55'),(3,'Administration111','Administration111',1,'2016-11-29 07:27:37',1,'2016-11-29 11:15:18'),(4,'sadfsasfdaasfd','Administration121',1,'2016-11-29 11:23:16',1,'2016-11-29 16:09:41');
/*!40000 ALTER TABLE `osi_menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osi_operations`
--

DROP TABLE IF EXISTS `osi_operations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osi_operations` (
  `id` int(11) NOT NULL auto_increment,
  `op_type` varchar(100) NOT NULL,
  `op_value` text,
  `parameters` varchar(1000) default NULL,
  `func_id` int(11) default NULL,
  `created_by` int(11) default NULL,
  `created_date` timestamp NULL default NULL,
  `updated_by` int(11) default NULL,
  `updated_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`),
  KEY `osi_func_operations_idx` (`func_id`),
  CONSTRAINT `osi_func_operations` FOREIGN KEY (`func_id`) REFERENCES `osi_functions` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osi_operations`
--

LOCK TABLES `osi_operations` WRITE;
/*!40000 ALTER TABLE `osi_operations` DISABLE KEYS */;
/*!40000 ALTER TABLE `osi_operations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osi_resp_user`
--

DROP TABLE IF EXISTS `osi_resp_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osi_resp_user` (
  `id` int(11) NOT NULL auto_increment,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `default_resp` tinyint(1) default NULL,
  `resp_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `created_by` int(11) default NULL,
  `created_date` timestamp NULL default NULL,
  `updated_by` int(11) default NULL,
  `updated_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`),
  KEY `osi_resp_usr_osi_responsibilities` (`resp_id`),
  KEY `osi_resp_usr_osi_user` (`user_id`),
  CONSTRAINT `osi_resp_usr_osi_responsibilities` FOREIGN KEY (`resp_id`) REFERENCES `osi_responsibilities` (`id`),
  CONSTRAINT `osi_resp_usr_osi_user` FOREIGN KEY (`user_id`) REFERENCES `osi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osi_resp_user`
--

LOCK TABLES `osi_resp_user` WRITE;
/*!40000 ALTER TABLE `osi_resp_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `osi_resp_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osi_responsibilities`
--

DROP TABLE IF EXISTS `osi_responsibilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osi_responsibilities` (
  `id` int(11) NOT NULL auto_increment,
  `resp_name` varchar(1000) NOT NULL,
  `description` varchar(1000) default NULL,
  `menu_id` int(11) NOT NULL,
  `created_by` int(11) default NULL,
  `created_date` timestamp NULL default NULL,
  `updated_by` int(11) default NULL,
  `updated_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`),
  KEY `osi_responsibilities_osi_menus` (`menu_id`),
  CONSTRAINT `osi_responsibilities_osi_menus` FOREIGN KEY (`menu_id`) REFERENCES `osi_menus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osi_responsibilities`
--

LOCK TABLES `osi_responsibilities` WRITE;
/*!40000 ALTER TABLE `osi_responsibilities` DISABLE KEYS */;
/*!40000 ALTER TABLE `osi_responsibilities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osi_user`
--

DROP TABLE IF EXISTS `osi_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osi_user` (
  `id` int(11) NOT NULL auto_increment,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `first_name` varchar(100) default NULL,
  `last_name` varchar(100) default NULL,
  `email_id` varchar(50) NOT NULL,
  `mobile_number` varchar(11) NOT NULL,
  `start_date` date NOT NULL,
  `full_name` varchar(100) default NULL,
  `end_date` date NOT NULL,
  `created_by` int(11) default NULL,
  `created_date` timestamp NULL default NULL,
  `updated_by` int(11) default NULL,
  `updated_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osi_user`
--

LOCK TABLES `osi_user` WRITE;
/*!40000 ALTER TABLE `osi_user` DISABLE KEYS */;
INSERT INTO `osi_user` VALUES (1,'rdonepudi','osicpl@1','Raju','D','rdonepudi@osius.com','90909099090','2016-11-29',NULL,'2016-11-29',1,'2016-11-27 18:30:00',NULL,NULL);
/*!40000 ALTER TABLE `osi_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osi_user_func_excl`
--

DROP TABLE IF EXISTS `osi_user_func_excl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osi_user_func_excl` (
  `id` int(11) NOT NULL auto_increment,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `func_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `created_by` int(11) default NULL,
  `created_date` timestamp NULL default NULL,
  `updated_by` int(11) default NULL,
  `updated_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`),
  KEY `osi_usr_functions_osi_functions` (`func_id`),
  KEY `osi_usr_functions_osi_user` (`user_id`),
  CONSTRAINT `osi_usr_functions_osi_functions` FOREIGN KEY (`func_id`) REFERENCES `osi_functions` (`id`),
  CONSTRAINT `osi_usr_functions_osi_user` FOREIGN KEY (`user_id`) REFERENCES `osi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osi_user_func_excl`
--

LOCK TABLES `osi_user_func_excl` WRITE;
/*!40000 ALTER TABLE `osi_user_func_excl` DISABLE KEYS */;
/*!40000 ALTER TABLE `osi_user_func_excl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osi_user_logins`
--

DROP TABLE IF EXISTS `osi_user_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osi_user_logins` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` int(11) NOT NULL,
  `start_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `end_time` timestamp NULL default NULL,
  `pid` int(11) default NULL,
  `login_type` varchar(50) default NULL,
  `token` varchar(1000) default NULL,
  `token_exp_time` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `osi_user_login_osi_user` (`user_id`),
  CONSTRAINT `osi_user_login_osi_user` FOREIGN KEY (`user_id`) REFERENCES `osi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osi_user_logins`
--

LOCK TABLES `osi_user_logins` WRITE;
/*!40000 ALTER TABLE `osi_user_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `osi_user_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osi_user_operation_excl`
--

DROP TABLE IF EXISTS `osi_user_operation_excl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osi_user_operation_excl` (
  `id` int(11) NOT NULL auto_increment,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `user_id` int(11) NOT NULL,
  `func_id` int(11) NOT NULL,
  `operation` varchar(50) NOT NULL,
  `created_by` int(11) default NULL,
  `created_date` timestamp NULL default NULL,
  `updated_by` int(11) default NULL,
  `updated_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`),
  KEY `osi_user_operation_excl_osi_functions` (`func_id`),
  KEY `osi_usr_operations_osi_user` (`user_id`),
  CONSTRAINT `osi_user_operation_excl_osi_functions` FOREIGN KEY (`func_id`) REFERENCES `osi_functions` (`id`),
  CONSTRAINT `osi_usr_operations_osi_user` FOREIGN KEY (`user_id`) REFERENCES `osi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osi_user_operation_excl`
--

LOCK TABLES `osi_user_operation_excl` WRITE;
/*!40000 ALTER TABLE `osi_user_operation_excl` DISABLE KEYS */;
/*!40000 ALTER TABLE `osi_user_operation_excl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-30 20:41:06
