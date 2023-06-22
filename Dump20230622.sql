CREATE DATABASE  IF NOT EXISTS `java` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `java`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: java
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `anamnese`
--

DROP TABLE IF EXISTS `anamnese`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anamnese` (
  `id` int NOT NULL AUTO_INCREMENT,
  `loginPaciente` varchar(255) DEFAULT NULL,
  `loginMedico` varchar(255) DEFAULT NULL,
  `exameFisico` text,
  `examesComplementares` text,
  `resultadosExames` text,
  `hipotesesDiagnosticas` text,
  `tratamentoEfetuado` text,
  `diagnosticoDefinitivo` text,
  `dataCriacao` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anamnese`
--

LOCK TABLES `anamnese` WRITE;
/*!40000 ALTER TABLE `anamnese` DISABLE KEYS */;
INSERT INTO `anamnese` VALUES (1,'umss','cristovaoliberato','asdasd','asdad','asdasd','sdasda','asdasdasd','asdasdasd','2023-06-20 14:31:38'),(2,'umss','cristovaoliberato','Dores Abdominais','Raio-X','Normais','Virose','Soro na veia','Virose','2023-06-21 19:34:28'),(3,'joao','cristovaoliberato','Dor de cabeça','Tomografia','Normais','Enxaqueca','Soro na veia','Enxaqueca','2023-06-21 19:39:12'),(4,'joao','cristovaoliberato','Dores no peito','eletrocardiograma','Arritmia cardiaca','Parada Cardiaca','Transplante','Parada cardiaca','2023-06-21 19:44:19'),(5,'umss','cristovaoliberato','asdadasd','asdasdasa','asdasd','asdasd','asdasdasd','asdasdas','2023-06-21 19:48:14'),(6,'joao','edusoares','asudhasudh','ausduashd','auishduiashd','diushadushd','aujsdhagsd','uahsiudh','2023-06-21 19:52:18'),(7,'umss','cristovaoliberato','apresentacao','asdasda','asdasd','asdasd','dasdasd','asdasd','2023-06-22 12:34:57'),(8,'vinicius','cristovaoliberato','asdasdasd','dasdasd','dasdasdasaasd','asdasdasd','dasdasda','dasdasd','2023-06-22 12:39:11');
/*!40000 ALTER TABLE `anamnese` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `login` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `mae_nome` varchar(100) NOT NULL,
  `municipio` varchar(100) NOT NULL,
  `estado` varchar(2) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `data_nascimento` date NOT NULL,
  `is_medico` tinyint(1) NOT NULL,
  `crm` varchar(100) DEFAULT NULL,
  `especialidade` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('administrador','adminadmin','Administrador','adm@gmail.com','masculino','adm','Acrelândia','AC','Palmas','2000-10-25',1,'77777','Neurologista','2023-06-19 22:32:19'),('cristovaoliberato','123456','Cristovão Liberato ','cristovao.junior2@estudante.ifto.edu.br','masculino','Maria Gorete de Sousa Liberato','Palmas','TO','Avenida Tlo 5','2001-05-25',1,NULL,NULL,'2023-06-03 18:42:35'),('edusoares','123456','Eduardo Soares','edusoares@gmail.com','masculino','Cecilia Soares Oliveira','Brasília','DF','Aguas Claras','1989-04-12',1,'55487','Neurologista','2023-06-21 19:50:40'),('joao','456','João da Silva','joao@gmail.com','masculino','Maria Aparecida da Silva','Manaus','AM','906 sul, alameda 02','1995-02-14',0,NULL,NULL,'2023-06-14 20:22:49'),('maria','123456','Maria','maria@gmail.com','feminino','Dona Rosa','Acari','RN','avenida 14','1999-05-04',0,NULL,NULL,'2023-06-21 19:53:11'),('umss','saude100%','Uziel Marcos','uziel.marcos@gmail.com','masculino','Sara Soares','Palmas','TO','Aureny 3','2000-04-13',0,NULL,NULL,'2023-06-20 00:20:42'),('vinicius','123456','Vinicius','vn@gmail.com','masculino','Ivone','Itumbiara','GO','Palmas','1984-11-01',0,NULL,NULL,'2023-06-22 12:38:45');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-22 10:10:45
