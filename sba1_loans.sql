-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: sba1
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `loans`
--

DROP TABLE IF EXISTS `loans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loans` (
  `Loan_Number` varchar(50) NOT NULL,
  `Loan_Name` varchar(45) NOT NULL,
  `Amount` varchar(20) NOT NULL,
  `Date` varchar(10) NOT NULL,
  `Business` varchar(45) NOT NULL,
  `Tax` varchar(45) NOT NULL,
  `Billing` varchar(45) NOT NULL,
  `Phone` varchar(10) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Status` varchar(45) NOT NULL,
  `LoginID` varchar(30) NOT NULL,
  PRIMARY KEY (`Loan_Number`),
  KEY `LoginID_idx` (`LoginID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loans`
--

LOCK TABLES `loans` WRITE;
/*!40000 ALTER TABLE `loans` DISABLE KEYS */;
INSERT INTO `loans` VALUES ('561dcbed-791b-4d57-a4a5-1b511120436c','Home','12111','07/11/2020','Individual','Tax Payer','Salaried','9823245676','ppa@gmail.com','Hyd','Applied','d1'),('6424e95a-0ea0-435d-b729-2181a88c668a','Par','12333','07/11/2020','Individual','Tax Payer','Salaried','9800012343','partha@gmail.com','Hyd','Applied','d1'),('76213df7-40c0-4205-9889-5f864b8df447','personal','10000','07/11/2020','Individual','Tax Payer','Salaried','9435447069','par@2020','Hyd','Applied','d1'),('b961894d-fc32-4a75-a203-6caf84564815','Home','12000','07/11/2020','Individual','Tax Payer','Salaried','9857567899','par@2020','Hyd','Applied','Cust1');
/*!40000 ALTER TABLE `loans` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-09 18:46:26
