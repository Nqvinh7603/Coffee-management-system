CREATE DATABASE  IF NOT EXISTS `coffee` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `coffee`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: coffee
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `idproduct` varchar(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`idproduct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('001','Cà Phê Đen Nóng',29000,'Ly',1),('002','Cà Phê Sữa Nóng',39000,'Ly',1),('003','Espresso Nóng',49000,'Ly',1),('004','Latte Nóng',49000,'Ly',1),('005','Bạc sỉu',29000,'Ly',1),('006','Cappucino Đá',59000,'Ly',1),('007','Đường Đen Marble Latte',59000,'Ly',1),('008','Trà Đào Cam Sả - Nóng',39000,'Ly',1),('009','Trà Hạt Sen - Đá',49000,'Ly',1),('010','Trà sữa Olong Blao',39000,'Ly',1),('011','Trà Sữa Mắc Ca Trân Châu',49000,'Ly',1),('012','Chocolate Nóng',49000,'Ly',1),('013','Trà Xanh Latte',39000,'Ly',1),('014','Frosty Trà Xanh',59000,'Ly',1),('015','Trà Xanh Đường Đen',59000,'Ly',1),('016','Croissant trứng muối',33000,'bánh',2),('017','Chà Bông Phô Mai',35000,'bánh',2),('018','Bánh Mì Cá Ngừ Mayo',45000,'bánh',2),('019','Mochi Kem Việt Quất',25000,'bánh',2),('020','Mochi Kem Dừa',25000,'bánh',2),('021','Mousse Gấu Chocolate',35000,'bánh',2),('022','Mít sấy',30000,'dĩa',2),('023','Mousse Passion Cheese',36000,'bánh',2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt`
--

DROP TABLE IF EXISTS `receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receipt` (
  `idreceipt` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `costwater` int(11) DEFAULT NULL,
  `costfood` int(11) DEFAULT NULL,
  PRIMARY KEY (`idreceipt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt`
--

LOCK TABLES `receipt` WRITE;
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
INSERT INTO `receipt` VALUES (1,'Phạm Thị B','2023-12-04 14:05:57',800,0),(2,'Phạm Thị B','2023-12-05 00:00:00',1300,0),(3,'Phạm Thị B','2023-12-05 08:44:52',100,0),(4,'Nhân viên - B','2023-12-05 11:10:33',216000,55000),(5,'Nhân viên - B','2023-12-05 11:10:43',49000,93000);
/*!40000 ALTER TABLE `receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temporary`
--

DROP TABLE IF EXISTS `temporary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temporary` (
  `tablenumber` int(11) DEFAULT NULL,
  `id_product` varchar(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  KEY `fk_idproduct_idx` (`id_product`),
  CONSTRAINT `fk_idproduct` FOREIGN KEY (`id_product`) REFERENCES `product` (`idproduct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temporary`
--

LOCK TABLES `temporary` WRITE;
/*!40000 ALTER TABLE `temporary` DISABLE KEYS */;
INSERT INTO `temporary` VALUES (2,'021','Mousse Gấu Chocolate',35000,'bánh',2,2),(2,'015','Trà Xanh Đường Đen',59000,'Ly',1,1),(2,'014','Frosty Trà Xanh',59000,'Ly',1,1);
/*!40000 ALTER TABLE `temporary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `account` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `birthday` int(11) DEFAULT NULL,
  `male` bit(1) DEFAULT NULL,
  `accounttype` int(11) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('nguyenthib','12345678','Nhân viên - B',2003,_binary '\0',1,20000),('nguyenvana','123','Quản lý - A',2003,_binary '',0,30000);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'coffee'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-05 11:18:09
