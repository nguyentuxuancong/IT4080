CREATE DATABASE  IF NOT EXISTS `classmanagement` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `classmanagement`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: classmanagement
-- ------------------------------------------------------
-- Server version	8.0.12

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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `StudentId` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Telephone` varchar(20) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Pass` varchar(255) NOT NULL,
  PRIMARY KEY (`StudentId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Tuấn Anh','Nguyễn Đình','ĐHBKHN','0123456789','example@gmail.com','123456789'),(2,'Chung','Nguyễn Thành','ĐHBKHN','0123456789','example@gmail.com','123456789'),(3,'Xuân Công ','Nguyễn Tử','ĐHBKHN','0123456789','example@gmail.com','123456789'),(4,'Cường','Nguyễn Hùng','ĐHBKHN','0123456789','example@gmail.com','123456789'),(5,'Cường ','Hoàng Việt','ĐHBKHN','0123456789','example@gmail.com','123456789'),(6,'Đức ','Lê Anh','ĐHBKHN','0123456789','example@gmail.com','123456789'),(7,'Dũng','Đậu Trung','ĐHBKHN','0123456789','example@gmail.com','123456789'),(8,'Dũng ','Lê Đức','ĐHBKHN','0123456789','example@gmail.com','123456789'),(9,'Trường Giang','Lê Bá','ĐHBKHN','0123456789','example@gmail.com','123456789'),(10,'Hải ','Lê Khả','ĐHBKHN','0123456789','example@gmail.com','123456789'),(11,'Hưng','Nguyễn Tuấn','ĐHBKHN','0123456789','example@gmail.com','123456789'),(12,'Huy ','Trần Quang','ĐHBKHN','0123456789','example@gmail.com','123456789'),(13,'Lịch ','Nguyễn Đình','ĐHBKHN','0123456789','example@gmail.com','123456789'),(14,'Lợi ','Nguyễn Đại','ĐHBKHN','0123456789','example@gmail.com','123456789'),(15,'Mạnh','Trần Đức','ĐHBKHN','0123456789','example@gmail.com','123456789'),(16,'Nhân','Chu Trọng','ĐHBKHN','0123456789','example@gmail.com','123456789'),(17,'Phụng','Nguyễn Hữu','ĐHBKHN','0123456789','example@gmail.com','123456789'),(18,'Quang','Lê Minh','ĐHBKHN','0123456789','example@gmail.com','123456789'),(19,'Tài','Nguyễn Tiến','ĐHBKHN','0123456789','example@gmail.com','123456789'),(20,'Thành ','Lê Công','ĐHBKHN','0123456789','example@gmail.com','123456789'),(21,'Thiện','Võ Hải','ĐHBKHN','0123456789','example@gmail.com','123456789'),(22,'Tiến ','Hồ Anh','ĐHBKHN','0123456789','example@gmail.com','123456789'),(23,'Tráng','Nguyễn Hữu','ĐHBKHN','0123456789','example@gmail.com','123456789'),(24,'Tú','Nguyễn Anh','ĐHBKHN','0123456789','example@gmail.com','123456789'),(25,'Tùng','Trần Thanh','ĐHBKHN','0123456789','example@gmail.com','123456789');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-07 20:55:03
