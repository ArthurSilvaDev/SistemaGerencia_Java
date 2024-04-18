CREATE DATABASE  IF NOT EXISTS `scfdata` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `scfdata`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: scfdata
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `caminhao`
--

DROP TABLE IF EXISTS `caminhao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `caminhao` (
  `codVeic` int NOT NULL AUTO_INCREMENT,
  `modVeic` varchar(200) DEFAULT NULL,
  `anoVeic` varchar(20) DEFAULT NULL,
  `placaVeic` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codVeic`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caminhao`
--

LOCK TABLES `caminhao` WRITE;
/*!40000 ALTER TABLE `caminhao` DISABLE KEYS */;
INSERT INTO `caminhao` VALUES (2,'H20B','2023','IJL8080'),(3,'Volvo FH 540','2017','JFG8064'),(4,'DAF XF105','2007','IOL8941');
/*!40000 ALTER TABLE `caminhao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `codFunc` int NOT NULL AUTO_INCREMENT,
  `nomeFunc` varchar(200) DEFAULT NULL,
  `cpfFunc` varchar(20) DEFAULT NULL,
  `cnhFunc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codFunc`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (2,'Arthur Felipe da Silva','44433322211','443322110'),(3,'Joao Antunes Ferreira','03485246508','165654789'),(4,'Maria Jose de Souza','15689735608','963852147');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionariocaminhao`
--

DROP TABLE IF EXISTS `funcionariocaminhao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionariocaminhao` (
  `atCodFunc` int DEFAULT NULL,
  `atCodVeic` int DEFAULT NULL,
  KEY `fk_funcionario` (`atCodFunc`),
  KEY `fk_veiculo` (`atCodVeic`),
  CONSTRAINT `fk_funcionario` FOREIGN KEY (`atCodFunc`) REFERENCES `funcionario` (`codFunc`),
  CONSTRAINT `fk_veiculo` FOREIGN KEY (`atCodVeic`) REFERENCES `caminhao` (`codVeic`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionariocaminhao`
--

LOCK TABLES `funcionariocaminhao` WRITE;
/*!40000 ALTER TABLE `funcionariocaminhao` DISABLE KEYS */;
INSERT INTO `funcionariocaminhao` VALUES (4,2),(2,3),(4,4);
/*!40000 ALTER TABLE `funcionariocaminhao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-07  9:38:30
