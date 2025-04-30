-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: applogin
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `applogin`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `applogin` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `applogin`;

--
-- Table structure for table `aula`
--

DROP TABLE IF EXISTS `aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aula` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `horario` varchar(255) NOT NULL,
  `matter_id` bigint DEFAULT NULL,
  `teacher_id` bigint DEFAULT NULL,
  `sala_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsdkysoriyinghdobo23qywmms` (`matter_id`),
  KEY `FK9t39ssm6xqa3kt4qm6pvlskq3` (`teacher_id`),
  KEY `FKoxwchkk4uwr1hs2q3g81o2quv` (`sala_id`),
  CONSTRAINT `FK9t39ssm6xqa3kt4qm6pvlskq3` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `FKoxwchkk4uwr1hs2q3g81o2quv` FOREIGN KEY (`sala_id`) REFERENCES `class_room` (`id`),
  CONSTRAINT `FKsdkysoriyinghdobo23qywmms` FOREIGN KEY (`matter_id`) REFERENCES `matters` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
INSERT INTO `aula` VALUES (1,'20:15',1,1,1),(2,'20:15',25,1,12),(3,'18:45',26,2,1),(4,'20:15',27,3,13),(5,'18:45',28,4,14),(6,'20:15',29,5,15),(7,'18:45',30,6,16),(8,'20:15',31,7,17),(9,'18:45',32,8,18),(10,'20:15',33,1,19),(11,'18:45',34,2,20),(12,'20:15',35,3,12),(13,'18:45',36,4,1),(14,'20:15',37,5,13),(15,'18:45',38,6,14),(16,'20:15',39,7,15),(17,'18:45',40,8,16),(18,'20:15',25,1,17),(19,'18:45',26,2,18),(20,'20:15',27,3,19),(21,'18:45',28,4,20);
/*!40000 ALTER TABLE `aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aula_student`
--

DROP TABLE IF EXISTS `aula_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aula_student` (
  `aula_id` bigint NOT NULL,
  `student_id` bigint NOT NULL,
  KEY `FK8adb4ctjwn9epmfn71r62lcr` (`student_id`),
  KEY `FKt3umwyhj7w7wukgfalawg1fe7` (`aula_id`),
  CONSTRAINT `FK8adb4ctjwn9epmfn71r62lcr` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
  CONSTRAINT `FKt3umwyhj7w7wukgfalawg1fe7` FOREIGN KEY (`aula_id`) REFERENCES `aula` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula_student`
--

LOCK TABLES `aula_student` WRITE;
/*!40000 ALTER TABLE `aula_student` DISABLE KEYS */;
INSERT INTO `aula_student` VALUES (1,1),(2,1),(18,1),(3,1),(19,1),(4,1),(20,1),(5,1),(21,1),(6,1);
/*!40000 ALTER TABLE `aula_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_matter`
--

DROP TABLE IF EXISTS `class_matter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_matter` (
  `classroom_id` bigint NOT NULL,
  `matter_id` bigint NOT NULL,
  KEY `FKkaff6ui45f45rw18iga0pqktm` (`classroom_id`),
  KEY `FK_matter_id` (`matter_id`),
  CONSTRAINT `FK_matter_id` FOREIGN KEY (`matter_id`) REFERENCES `matters` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKkaff6ui45f45rw18iga0pqktm` FOREIGN KEY (`classroom_id`) REFERENCES `class_room` (`id`),
  CONSTRAINT `FKn337wyuvgqhn510q8uosybf2s` FOREIGN KEY (`matter_id`) REFERENCES `matters` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_matter`
--

LOCK TABLES `class_matter` WRITE;
/*!40000 ALTER TABLE `class_matter` DISABLE KEYS */;
INSERT INTO `class_matter` VALUES (1,25),(12,26),(13,27),(14,28),(15,29),(16,30),(17,31),(18,32),(19,33),(20,34),(2,35),(3,36),(4,37),(5,38),(6,39),(7,40),(8,41),(9,42),(10,43),(11,44);
/*!40000 ALTER TABLE `class_matter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_room`
--

DROP TABLE IF EXISTS `class_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_room` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `area` varchar(255) NOT NULL,
  `bloco` varchar(255) NOT NULL,
  `num_da_sala` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKrpg3y2sygdfmiyp4lekndxlqn` (`num_da_sala`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_room`
--

LOCK TABLES `class_room` WRITE;
/*!40000 ALTER TABLE `class_room` DISABLE KEYS */;
INSERT INTO `class_room` VALUES (1,'2','D','102'),(12,'1','A','101'),(13,'3','B','201'),(14,'4','B','202'),(15,'5','C','301'),(16,'6','C','302'),(17,'7','D','401'),(18,'8','D','402'),(19,'9','E','501'),(20,'10','E','502');
/*!40000 ALTER TABLE `class_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_students`
--

DROP TABLE IF EXISTS `class_students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_students` (
  `classroom_id` bigint NOT NULL,
  `student_id` bigint NOT NULL,
  KEY `FK8x4jwkaf3emayhwuqidfr5w0c` (`student_id`),
  KEY `FKnjw3o8u9s1u66pr282im4xyre` (`classroom_id`),
  CONSTRAINT `FK8x4jwkaf3emayhwuqidfr5w0c` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
  CONSTRAINT `FKnjw3o8u9s1u66pr282im4xyre` FOREIGN KEY (`classroom_id`) REFERENCES `class_room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_students`
--

LOCK TABLES `class_students` WRITE;
/*!40000 ALTER TABLE `class_students` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managers`
--

DROP TABLE IF EXISTS `managers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `managers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `login_de_rede` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managers`
--

LOCK TABLES `managers` WRITE;
/*!40000 ALTER TABLE `managers` DISABLE KEYS */;
INSERT INTO `managers` VALUES (1,'pedrotalalayv6767@gmail.com','2345678','Pedro Henrique Talalayv Gomes','Pedro767621#');
/*!40000 ALTER TABLE `managers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matter_periodo`
--

DROP TABLE IF EXISTS `matter_periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matter_periodo` (
  `matter_id` bigint NOT NULL,
  `periodo_id` bigint NOT NULL,
  KEY `FKkjr0bpou9lf6u23bn3emkqa1v` (`matter_id`),
  KEY `FKm33kkef0v6e4v97j5krgglsfa` (`periodo_id`),
  CONSTRAINT `FKd2p1ioma8662j4no42sk11lq2` FOREIGN KEY (`matter_id`) REFERENCES `periodo` (`id`),
  CONSTRAINT `FKhjuj2hrhfa7oorpui6jj73cpt` FOREIGN KEY (`periodo_id`) REFERENCES `matters` (`id`),
  CONSTRAINT `FKkjr0bpou9lf6u23bn3emkqa1v` FOREIGN KEY (`matter_id`) REFERENCES `matters` (`id`),
  CONSTRAINT `FKm33kkef0v6e4v97j5krgglsfa` FOREIGN KEY (`periodo_id`) REFERENCES `periodo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matter_periodo`
--

LOCK TABLES `matter_periodo` WRITE;
/*!40000 ALTER TABLE `matter_periodo` DISABLE KEYS */;
INSERT INTO `matter_periodo` VALUES (25,1),(26,1),(27,1),(28,1),(29,1),(30,2),(31,2),(32,2),(33,2),(34,2),(35,3),(36,3),(37,3),(38,3),(39,4),(40,4),(41,4),(42,5),(43,5),(44,5),(45,5),(46,5),(47,5);
/*!40000 ALTER TABLE `matter_periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matters`
--

DROP TABLE IF EXISTS `matters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matters` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome_materia` varchar(255) DEFAULT NULL,
  `periodo_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKepw2wvhgtgp82un52spbkaw2v` (`periodo_id`),
  CONSTRAINT `FKepw2wvhgtgp82un52spbkaw2v` FOREIGN KEY (`periodo_id`) REFERENCES `periodo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matters`
--

LOCK TABLES `matters` WRITE;
/*!40000 ALTER TABLE `matters` DISABLE KEYS */;
INSERT INTO `matters` VALUES (25,'ALGORITMOS',NULL),(26,'FUNDAMENTOS DE COMPUTAÇÃO I',NULL),(27,'LABORATÓRIO DE PROGRAMAÇÃO',NULL),(28,'ENGENHARIA DE SOFTWARE',NULL),(29,'TEOLOGIA, CIÊNCIAS EXATAS E TECNOLÓGICAS',NULL),(30,'ENGENHARIA DE REQUISITOS',NULL),(31,'FUNDAMENTOS DE PROGRAMAÇÃO ORIENTADA A OBJETO',NULL),(32,'FUNDAMENTOS DE SISTEMAS DE COMPUTAÇÃO – (EaD)',NULL),(33,'INTRODUÇÃO A ESTATÍSTICA PARA INTELIGÊNCIA ARTIFICIAL',NULL),(34,'PROJETO DE BANCO DE DADOS',NULL),(35,'SEGURANÇA DA INFORMAÇÃO - (EaD)',NULL),(36,'FUNDAMENTOS DE SISTEMAS DE CONFIGURAÇÃO COM DEVOPS',NULL),(37,'ESTRUTURA DE DADOS ORIENTADA A OBJETO',NULL),(38,'INTELIGÊNCIA ARTIFICIAL APLICADA',NULL),(39,'DESENVOLVIMENTO DE SOFTWARE WEB',NULL),(40,'INTEGRAÇÕES E STREAMS EM APLICAÇÕES',NULL),(41,'DESIGN DE SOFTWARE',NULL),(42,'GERÊNCIA DE QUALIDADE DE SOFTWARE - (EaD)',NULL),(43,'MODELAGEM DE INTERFACES DE USUÁRIO',NULL),(44,'FERRAMENTAS VISUAIS DE DESENVOLVIMENTO DE SOFTWARE',NULL),(45,'DESENVOLVIMENTO DE APLICAÇÕES MÓVEIS',NULL),(46,'ORIENTAÇÃO EM TECNOLOGIA DA INFORMAÇÃO - (EaD)',NULL),(47,'PROGRAMAÇÃO ORIENTADA A OBJETOS COM BANCO DE DADOS',NULL);
/*!40000 ALTER TABLE `matters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodo`
--

DROP TABLE IF EXISTS `periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `periodo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodo`
--

LOCK TABLES `periodo` WRITE;
/*!40000 ALTER TABLE `periodo` DISABLE KEYS */;
INSERT INTO `periodo` VALUES (1,'Primeiro'),(2,'Segundo'),(3,'Terceiro'),(4,'Quarto'),(5,'Quinto'),(6,'Sexto');
/*!40000 ALTER TABLE `periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodo_matter`
--

DROP TABLE IF EXISTS `periodo_matter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodo_matter` (
  `matter_id` bigint NOT NULL,
  `periodo_id` bigint NOT NULL,
  KEY `FKfsmkmmiu4gtm5koc6n9r6n70e` (`periodo_id`),
  KEY `FKj0mx54tf4r0lmc788hx3x0aid` (`matter_id`),
  CONSTRAINT `FKfsmkmmiu4gtm5koc6n9r6n70e` FOREIGN KEY (`periodo_id`) REFERENCES `periodo` (`id`),
  CONSTRAINT `FKj0mx54tf4r0lmc788hx3x0aid` FOREIGN KEY (`matter_id`) REFERENCES `matters` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodo_matter`
--

LOCK TABLES `periodo_matter` WRITE;
/*!40000 ALTER TABLE `periodo_matter` DISABLE KEYS */;
/*!40000 ALTER TABLE `periodo_matter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presenca`
--

DROP TABLE IF EXISTS `presenca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `presenca` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `presente` bit(1) NOT NULL,
  `aluno_id` bigint DEFAULT NULL,
  `aula_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj7fappprhfx1uiluel92hw1jr` (`aluno_id`),
  KEY `FKfrv4b1uwcjm7xnhruph692kqe` (`aula_id`),
  CONSTRAINT `FKfrv4b1uwcjm7xnhruph692kqe` FOREIGN KEY (`aula_id`) REFERENCES `aula` (`id`),
  CONSTRAINT `FKj7fappprhfx1uiluel92hw1jr` FOREIGN KEY (`aluno_id`) REFERENCES `students` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presenca`
--

LOCK TABLES `presenca` WRITE;
/*!40000 ALTER TABLE `presenca` DISABLE KEYS */;
/*!40000 ALTER TABLE `presenca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_matter`
--

DROP TABLE IF EXISTS `student_matter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_matter` (
  `student_id` bigint NOT NULL,
  `matter_id` bigint NOT NULL,
  KEY `FKnd1w2pp45dx8avvbfxqooyty5` (`matter_id`),
  KEY `FK27uj2tdrla70e48vkpfk2xqi` (`student_id`),
  CONSTRAINT `FK27uj2tdrla70e48vkpfk2xqi` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
  CONSTRAINT `FKnd1w2pp45dx8avvbfxqooyty5` FOREIGN KEY (`matter_id`) REFERENCES `matters` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_matter`
--

LOCK TABLES `student_matter` WRITE;
/*!40000 ALTER TABLE `student_matter` DISABLE KEYS */;
INSERT INTO `student_matter` VALUES (1,25),(1,26),(1,27),(1,28),(1,29);
/*!40000 ALTER TABLE `student_matter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_periodo`
--

DROP TABLE IF EXISTS `student_periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_periodo` (
  `student_id` bigint NOT NULL,
  `periodo_id` bigint NOT NULL,
  KEY `FKog8iy5g1u2niddok4g47lyf2b` (`periodo_id`),
  KEY `FKm9eydxagtobqgi7wcu2piwbvr` (`student_id`),
  CONSTRAINT `FKm9eydxagtobqgi7wcu2piwbvr` FOREIGN KEY (`student_id`) REFERENCES `periodo` (`id`),
  CONSTRAINT `FKog8iy5g1u2niddok4g47lyf2b` FOREIGN KEY (`periodo_id`) REFERENCES `students` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_periodo`
--

LOCK TABLES `student_periodo` WRITE;
/*!40000 ALTER TABLE `student_periodo` DISABLE KEYS */;
INSERT INTO `student_periodo` VALUES (1,3),(2,5),(3,1),(4,6),(5,2),(6,4),(7,1),(8,5);
/*!40000 ALTER TABLE `student_periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `matricula` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `data_de_nascimento` date NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `periodo_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK7nv44yeiyso6o0rc4skaycth3` (`matricula`),
  KEY `FKpd0ab0pt7rdw65o36lmrofvul` (`periodo_id`),
  CONSTRAINT `FKpd0ab0pt7rdw65o36lmrofvul` FOREIGN KEY (`periodo_id`) REFERENCES `periodo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'pedrotalalayv6767@gmail.com','20241012000638','Pedro Henrique Talalayv Gomes','Pedro767621#','2006-07-03','(62)98226-2779',1),(2,'ana.silva@email.com','20230001','Ana Silva','Pedro767621#','2005-03-15','11987654321',1),(3,'carlos.souza@email.com','20230002','Carlos Souza','Pedro767621#','2004-11-22','11981234567',1),(4,'mariana.costa@email.com','20230003','Mariana Costa','Pedro767621#','2005-07-10','11982345678',2),(5,'fernando.lima@email.com','20230004','Fernando Lima','Pedro767621#','2003-12-05','11983456789',2),(6,'juliana.rocha@email.com','20230005','Juliana Rocha','Pedro767621#','2005-01-25','11984567890',2),(7,'ricardo.alves@email.com','20230006','Ricardo Alves','Pedro767621#','2004-04-18','11985678901',3),(8,'patricia.mendes@email.com','20230007','Patrícia Mendes','Pedro767621#','2005-09-30','11986789012',3);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `login_de_rede` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'2345678','Pedro Talalayv','Pedro767621#'),(2,'3456789','Ana Silva','Pedro767621#'),(3,'4567890','Carlos Souza','Pedro767621#'),(4,'5678901','Mariana Costa','Pedro767621#'),(5,'6789012','Fernando Lima','Pedro767621#'),(6,'7890123','Juliana Rocha','Pedro767621#'),(7,'8901234','Ricardo Alves','Pedro767621#'),(8,'9012345','Patrícia Mendes','Pedro767621#');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_matter`
--

DROP TABLE IF EXISTS `teacher_matter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_matter` (
  `teacher_id` bigint NOT NULL,
  `matter_id` bigint NOT NULL,
  KEY `FKbc3y9n1u0f9v6w1lgqxs5uls` (`matter_id`),
  KEY `FK3gi094awj9vjilsa1tcs1sjdw` (`teacher_id`),
  CONSTRAINT `FK3gi094awj9vjilsa1tcs1sjdw` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `FKbc3y9n1u0f9v6w1lgqxs5uls` FOREIGN KEY (`matter_id`) REFERENCES `matters` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_matter`
--

LOCK TABLES `teacher_matter` WRITE;
/*!40000 ALTER TABLE `teacher_matter` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_matter` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-30 13:40:26
