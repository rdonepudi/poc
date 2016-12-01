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
-- Table structure for table `osi_func_operations`
--

DROP TABLE IF EXISTS `osi_func_operations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osi_func_operations` (
  `id` int(11) NOT NULL auto_increment,
  `op_id` int(11) NOT NULL,
  `op_url` text NOT NULL,
  `func_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `created_by` int(11) default NULL,
  `created_date` timestamp NULL default NULL,
  `updated_by` int(11) default NULL,
  `updated_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`),
  KEY `osi_func_operations_osi_operations` (`op_id`),
  KEY `osi_operations_osi_functions` (`func_id`),
  CONSTRAINT `osi_func_operations_osi_operations` FOREIGN KEY (`op_id`) REFERENCES `osi_operations` (`id`),
  CONSTRAINT `osi_operations_osi_functions` FOREIGN KEY (`func_id`) REFERENCES `osi_functions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osi_func_operations`
--

LOCK TABLES `osi_func_operations` WRITE;
/*!40000 ALTER TABLE `osi_func_operations` DISABLE KEYS */;
/*!40000 ALTER TABLE `osi_func_operations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osi_functions`
--

DROP TABLE IF EXISTS `osi_functions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osi_functions` (
  `id` int(11) NOT NULL auto_increment,
  `func_name` varchar(100) NOT NULL,
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
  `prompt` varchar(100) NOT NULL,
  `menu_id` int(11) NOT NULL,
  `sub_menu_id` int(11) default NULL,
  `func_id` int(11) default NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osi_menus`
--

LOCK TABLES `osi_menus` WRITE;
/*!40000 ALTER TABLE `osi_menus` DISABLE KEYS */;
INSERT INTO `osi_menus` VALUES (1,'Administration121','Administration121',1,'2016-12-01 12:44:17',NULL,NULL);
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
  `name` varchar(1000) NOT NULL,
  `description` text NOT NULL,
  `created_by` int(11) default NULL,
  `created_date` timestamp NULL default NULL,
  `updated_by` int(11) default NULL,
  `updated_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
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
  `start_date` date default NULL,
  `end_date` date default NULL,
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
  `emp_number` varchar(45) NOT NULL,
  `mobile_number` varchar(11) NOT NULL,
  `start_date` date NOT NULL,
  `full_name` varchar(100) default NULL,
  `end_date` date NOT NULL,
  `created_by` int(11) default NULL,
  `created_date` timestamp NULL default NULL,
  `updated_by` int(11) default NULL,
  `updated_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osi_user`
--

LOCK TABLES `osi_user` WRITE;
/*!40000 ALTER TABLE `osi_user` DISABLE KEYS */;
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
  `user_id` int(11) NOT NULL,
  `func_id` int(11) NOT NULL,
  `op_id` int(11) NOT NULL,
  `created_by` int(11) default NULL,
  `created_date` timestamp NULL default NULL,
  `updated_by` int(11) default NULL,
  `updated_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`),
  KEY `osi_user_operation_excl_osi_functions` (`func_id`),
  KEY `osi_user_operation_excl_osi_operations` (`op_id`),
  KEY `osi_usr_operations_osi_user` (`user_id`),
  CONSTRAINT `osi_user_operation_excl_osi_functions` FOREIGN KEY (`func_id`) REFERENCES `osi_functions` (`id`),
  CONSTRAINT `osi_user_operation_excl_osi_operations` FOREIGN KEY (`op_id`) REFERENCES `osi_operations` (`id`),
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

-- Dump completed on 2016-12-01 19:46:34
