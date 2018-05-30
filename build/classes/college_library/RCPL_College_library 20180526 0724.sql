-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.67-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema library
--

CREATE DATABASE IF NOT EXISTS library;
USE library;

--
-- Definition of table `books`
--

DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `bid` int(11) NOT NULL auto_increment,
  `title` varchar(20) default NULL,
  `subject` varchar(20) default NULL,
  `author` varchar(20) default NULL,
  `status` varchar(20) default 'available',
  PRIMARY KEY  (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` (`bid`,`title`,`subject`,`author`,`status`) VALUES 
 (101,'Java Prog','Java','Balagurusamy','issued'),
 (102,'Linux Sys','OS','Ken Berry','available'),
 (103,'SCJP Practise','Java','Kathy Sierra','available'),
 (104,'C Language','C','Balagurusamy','available'),
 (105,'Sampling','Maths','S.M Agarwal','available');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;


--
-- Definition of table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `empid` int(11) NOT NULL,
  `name` varchar(20) default NULL,
  `dept` varchar(20) default NULL,
  `doj` date default NULL,
  `salary` int(11) default NULL,
  PRIMARY KEY  (`empid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`empid`,`name`,`dept`,`doj`,`salary`) VALUES 
 (1001,'Ayaan Khan','CS','2014-11-12',29000),
 (1002,'Ram Singh','CS','2014-12-12',30000),
 (1003,'Aditya Gupta','IT','2015-07-12',30000);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


--
-- Definition of table `issue`
--

DROP TABLE IF EXISTS `issue`;
CREATE TABLE `issue` (
  `book` int(11) NOT NULL,
  `issueto` int(11) default NULL,
  `issuedby` int(11) default NULL,
  PRIMARY KEY  (`book`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issue`
--

/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
INSERT INTO `issue` (`book`,`issueto`,`issuedby`) VALUES 
 (101,837,1001);
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;


--
-- Definition of table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `lid` int(11) NOT NULL,
  `pass` varchar(20) default NULL,
  `name` varchar(20) default NULL,
  `role` int(11) default NULL,
  PRIMARY KEY  (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`lid`,`pass`,`name`,`role`) VALUES 
 (837,'kankroli','Roshan',2),
 (1001,'pass','Ayaan Khan',1),
 (1002,'pass','Ram Singh',1),
 (1003,'pass','Aditya Gupta',1),
 (123456,'jannn','jgd',2);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;


--
-- Definition of table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `roll` int(11) NOT NULL,
  `name` varchar(20) default NULL,
  `dept` varchar(20) default NULL,
  `sem` varchar(20) default NULL,
  `batch` varchar(20) default NULL,
  PRIMARY KEY  (`roll`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`roll`,`name`,`dept`,`sem`,`batch`) VALUES 
 (837,'Roshan','CSE','7','2015');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
