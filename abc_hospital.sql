-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: icbt_batch22
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admit`
--

DROP TABLE IF EXISTS `admit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `admit` (
  `admit_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `admit_reason` varchar(45) NOT NULL,
  `ward_id` int(11) NOT NULL,
  `admit_date` varchar(45) NOT NULL,
  `admit_time` varchar(45) NOT NULL,
  `admit_branch` varchar(45) NOT NULL,
  PRIMARY KEY (`admit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admit`
--

LOCK TABLES `admit` WRITE;
/*!40000 ALTER TABLE `admit` DISABLE KEYS */;
INSERT INTO `admit` VALUES (1,1,'Accident',1,'2021-10-13','08:20','Galle'),(2,1,'Emergency',1,'2021-10-13','03:20','Colombo'),(3,1,'Emergency',1,'2021-10-13','14:21','Colombo'),(4,4,'dead',1,'2021-10-27','07:24','Jaffna'),(5,6,'Covid-19',9,'2021-10-27','07:24','Jaffna');
/*!40000 ALTER TABLE `admit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `appointment` (
  `appointment_id` int(11) NOT NULL AUTO_INCREMENT,
  `appointment_name` varchar(45) DEFAULT NULL,
  `appointment_age` int(11) DEFAULT NULL,
  `appointment_gender` varchar(45) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `appointment_date` varchar(45) DEFAULT NULL,
  `appointment_time` varchar(45) DEFAULT NULL,
  `appointment_tel` int(11) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `appointment_charge` decimal(10,2) DEFAULT NULL,
  `appointment_no` varchar(45) DEFAULT NULL,
  `appointment_branch` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`appointment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (3,'Junty',12,'Male',8,'2021-10-13','16:26',778845147,1,2500.00,'47','Colombo'),(4,'ben',23,'Male',1,'2021-10-13','16:25',778845147,0,500.00,'10','Colombo'),(5,'tissa',23,'Male',9,'2021-10-13','20:27',778845147,0,500.00,'10','Colombo'),(6,'f',34,'Male',2,'2021-10-16','04:47',343433,3,32.00,'23','Colombo'),(7,'ss',2,'Male',1,'2021-10-06','09:17',3333,0,5000.00,'23','Jaffna'),(8,'manodh dayaatne',43,'Male',1,'2021-12-05','11:50',775436870,20098,1000.00,'7669B','Colombo'),(9,'JOHN AMARATUNGA',67,'Male',1,'2021-11-04','08:50',46677777,0,5000.00,'012','Galle');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bill` (
  `bill_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `medical_charge` double NOT NULL,
  `appointment_charge` double NOT NULL,
  `hospital_charge` double NOT NULL,
  `discount` double NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`bill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,1,'2021-10-24 14:02:40',2,5,45,4,48),(2,5,'2021-10-24 12:55:22',2,4,6,2,13),(3,4,'2021-10-24 14:16:48',2,4,6,6,18),(4,2,'2021-10-24 13:44:37',1,2,1,1,26),(5,1,'2021-10-24 13:45:33',2,2,2,2,8),(6,1,'2021-10-24 13:48:32',2,2,2,2,4),(7,3,'2021-10-24 13:59:12',2,2,6,2,3333),(8,1,'2021-10-24 14:03:11',23,3,3,3,26),(9,2,'2021-10-24 14:12:34',223,32,2,2,255);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discharge`
--

DROP TABLE IF EXISTS `discharge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `discharge` (
  `discharge_id` int(11) NOT NULL AUTO_INCREMENT,
  `admit_id` int(11) DEFAULT NULL,
  `discharge_reason` varchar(45) DEFAULT NULL,
  `ward_id` int(11) DEFAULT NULL,
  `discharge_date` varchar(45) DEFAULT NULL,
  `discharge_time` varchar(45) DEFAULT NULL,
  `discharge_branch` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`discharge_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discharge`
--

LOCK TABLES `discharge` WRITE;
/*!40000 ALTER TABLE `discharge` DISABLE KEYS */;
INSERT INTO `discharge` VALUES (1,1,'Death',1,'2021-10-13','03:56','Galle'),(2,3,'broken leg',3,'2021-10-21','00:11','Colombo'),(3,3,'d',3,'2021-10-29','08:22','Jaffna'),(4,4,'qwerty',1,'2021-10-11','02:56','Colombo');
/*!40000 ALTER TABLE `discharge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `doctor` (
  `doc_id` int(11) NOT NULL AUTO_INCREMENT,
  `doc_fname` varchar(45) NOT NULL,
  `doc_lname` varchar(45) NOT NULL,
  `doc_dob` varchar(45) NOT NULL,
  `doc_nic_no` varchar(45) NOT NULL,
  `doc_sex` varchar(45) NOT NULL,
  `doc_phone_no` int(11) NOT NULL,
  `doc_address` varchar(45) NOT NULL,
  `specilization` varchar(45) NOT NULL,
  `doc_department` varchar(45) NOT NULL,
  `branch` varchar(45) NOT NULL,
  PRIMARY KEY (`doc_id`),
  UNIQUE KEY `doc_id_UNIQUE` (`doc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'james','harry','1921-10-13','55554rf5','male',778182477,'sesnc455','Surgent','surgery','Jaffna'),(2,'AJWAN ','FEROZE','1987-10-15','198765574468','Male',715432345,'N0.18/A DE AVENUE MAWATHA DEHIWALA','DENTAL SURGEON','MEDICS','Colombo'),(4,'VIMAL','ASANTHA','1970-10-15','dsdsdssds','Male',55545,'1212','PHYSIOTHERAPIST','PHYSIO','Galle'),(5,'MARIETA','GEETHANJALI','1975-10-15','4545','Female',7524454,'fgdd','DERMATOLAGISTS','sdsd','Colombo'),(6,'BINTHI','MARIAM','1966-10-15','57754rf5','Male',788184477,'sesnc455','UNANI DOCTOR','doc','Jaffna'),(7,'RAHEEM','SHAZRAN','2021-10-15','2323','Male',2323,'we','WESTERN MEDICINE/AYURVEDA','we','Jaffna'),(8,'SHIMON','CHRISTENSEN','1960-10-06','hhdhdh7744v','Male',75444,'ee','NEUROSURGEON','ed','Colombo'),(9,'BIN','WASEEM','1975-10-23','sss','Male',22222,'sssq2','CARDIOLOGIST','sss','Colombo'),(11,'YENURA','MUNASINGHE','1976-10-27','8986656580','Male',775643219,'1234 Main Street','ALLERGY  AND IMMUNOLOGIST','ALLERGY HOPITAL UNIT','Galle');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `medicine` (
  `medicine_id` int(11) NOT NULL AUTO_INCREMENT,
  `medicine_name` varchar(45) DEFAULT NULL,
  `medicine_code` varchar(45) DEFAULT NULL,
  `medicine_price` decimal(10,2) DEFAULT NULL,
  `medicine_qty` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`medicine_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (1,'Zaart','MCZA01',750.50,'50'),(2,'Neodine Ointment','NOxx6892',420.00,'70'),(3,'Omega cap','OM##1',2500.00,'20'),(4,'Panadol','DFSD',34.00,'34'),(5,'DDF','DFFF',43.00,'4'),(6,'Bandage Roll','BFF12',80.00,'1000');
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `patient` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_fname` varchar(45) NOT NULL,
  `patient_lname` varchar(45) NOT NULL,
  `patient_dob` varchar(45) NOT NULL,
  `patient_nic` varchar(45) NOT NULL,
  `patient_phone_no` int(11) DEFAULT NULL,
  `patient_email` varchar(45) DEFAULT NULL,
  `patient_address` varchar(45) NOT NULL,
  `patient_gender` varchar(45) NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `patient_id_UNIQUE` (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'Gary','Hard','1987-10-15','100061155v',778455666,'gary@gmail.com','123,mount lavinia','male'),(2,'kan','jers','2021-10-10','57676V',774444155,'inbhj','hyh7h','Male'),(3,'zz','xx','2021-10-08','xxz',3434,'aaas','asas','Male'),(4,'fdsdf','fsdf','2021-10-14','',443434343,'','ewe','Male'),(5,'e','e','2021-10-06','e',12300000,'atarceylon@gmail.com','1234 Main Street','Female'),(6,'James','Bond','1944-08-11','194461155v',778489123,'James@gmail.com','172,Bambalapity','male'),(9,'Casim','Khan','1984-08-11','198461155v',778489123,'Casimkhan@gmail.com','172,Bambalapity','male');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transfer`
--

DROP TABLE IF EXISTS `transfer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transfer` (
  `transfer_id` int(11) NOT NULL AUTO_INCREMENT,
  `admit_id` int(11) DEFAULT NULL,
  `transfer_reason` varchar(45) DEFAULT NULL,
  `transfer_from` varchar(45) DEFAULT NULL,
  `transfer_to` varchar(45) DEFAULT NULL,
  `transfer_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`transfer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfer`
--

LOCK TABLES `transfer` WRITE;
/*!40000 ALTER TABLE `transfer` DISABLE KEYS */;
INSERT INTO `transfer` VALUES (1,1,'operation','Galle','Colombo','2021-02-04'),(2,1,'icu treatment','Galle','Colombo','2021-02-04'),(3,2,'just','Galle','Colombo','2021-10-29');
/*!40000 ALTER TABLE `transfer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'james12','abc','Admin'),(2,'Bill','abc123','Admin');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ward`
--

DROP TABLE IF EXISTS `ward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ward` (
  `ward_id` int(11) NOT NULL AUTO_INCREMENT,
  `ward_no` varchar(45) DEFAULT NULL,
  `ward_type` varchar(45) DEFAULT NULL,
  `ward_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ward_id`),
  UNIQUE KEY `ward_id_UNIQUE` (`ward_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ward`
--

LOCK TABLES `ward` WRITE;
/*!40000 ALTER TABLE `ward` DISABLE KEYS */;
INSERT INTO `ward` VALUES (1,'01','Emergency','Avaliable'),(2,'024','ICU','Taken'),(4,'45','w','Taken'),(6,'02','Emergency','Avaliable'),(7,'03','Emergency','Taken'),(8,'34','Accident','Avaliable'),(9,'34','Accident','Avaliable'),(10,'39','Accident','Avaliable'),(11,'10','Emergency','Taken'),(12,'11','Emergency','Avaliable'),(13,'13','Accident','Taken'),(14,'71','Accident','Avaliable'),(15,'0222','Accident','Avaliable'),(16,'gg','ee','Avaliable'),(17,'71','Accident','Avaliable'),(18,'71','Accident','Avaliable'),(19,'71','Accident','Avaliable'),(20,'71','Accident','Avaliable'),(21,'72','Accident','Avaliable');
/*!40000 ALTER TABLE `ward` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-29 20:49:59
