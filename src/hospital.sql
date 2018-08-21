/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.57 : Database - pat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pat` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `pat`;

/*Table structure for table `doc` */

DROP TABLE IF EXISTS `doc`;

CREATE TABLE `doc` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` char(30) DEFAULT NULL,
  `addr` char(100) DEFAULT NULL,
  `contact` char(15) DEFAULT NULL,
  `spec` char(50) DEFAULT NULL,
  `workf` char(5) DEFAULT NULL,
  `workt` char(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `doc` */

insert  into `doc`(`id`,`name`,`addr`,`contact`,`spec`,`workf`,`workt`) values (1,'Dr. Tiwari','H-3','9899999991','Physician','10','5'),(201,'Dr. Kirti','H-27','9898898988','Dentist','12','8');

/*Table structure for table `pat` */

DROP TABLE IF EXISTS `pat`;

CREATE TABLE `pat` (
  `pno` int(11) NOT NULL DEFAULT '0',
  `name` char(30) DEFAULT NULL,
  `addr` char(100) DEFAULT NULL,
  `contact` char(15) DEFAULT NULL,
  `bg` char(10) DEFAULT NULL,
  `hist` char(100) DEFAULT NULL,
  `dob` char(20) DEFAULT NULL,
  `current` char(100) DEFAULT NULL,
  `room` char(10) DEFAULT NULL,
  `dadd` char(20) DEFAULT NULL,
  `rtype` char(20) DEFAULT NULL,
  `gender` char(10) DEFAULT NULL,
  `docname` char(30) DEFAULT NULL,
  PRIMARY KEY (`pno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pat` */

insert  into `pat`(`pno`,`name`,`addr`,`contact`,`bg`,`hist`,`dob`,`current`,`room`,`dadd`,`rtype`,`gender`,`docname`) values (1,'Gurtek','H-2/9','8826549169','B +ve','Nothing','23-10-1996','nothing','101','15-09-2017','Deluxe','male','Dr. Tiwari'),(2,'inder','hi-98','8856952365','A -ve','no','03-08-1997','no','103','23-09-2017','Deluxe','male','jha'),(3,'Harshdeep Singh','17/55A Tilak Nagar','7343141547','B +ve','Nothing','08-11-2004','Cough','102','02-10-2017','Deluxe','male','Dr. Tiwari');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
