SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT;
SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS;
SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION;
SET NAMES utf8;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE=NO_AUTO_VALUE_ON_ZERO */;


CREATE DATABASE /*!32312 IF NOT EXISTS*/ `employees`;
USE `employees`;
CREATE TABLE `employee` (
  `emp_firstname` varchar(100) NOT NULL default '',
  `emp_surname` varchar(100) NOT NULL default '',
  `emp_salary` decimal(10,0) NOT NULL default '0',
  `emp_id` int(11) NOT NULL default '0',
  `serv_id` int(11) NOT NULL default '0'
) TYPE=MyISAM;
INSERT INTO `employee` (`emp_firstname`,`emp_surname`,`emp_salary`,`emp_id`,`serv_id`) VALUES
 ('Jose','Borges','80000',2,1),
 ('William','Samuel','50000',1,1),
 ('Davi','Jose','35000',3,2),
 ('Paula','Silva','70000',4,2),
 ('Julia','Gomes','60000',5,3),
 ('Paulo','Roberto','40000',6,2),
 ('Carla','Moraes','55000',7,3),
 ('Joao','da Silva','60000',9,2),
 ('Sandra','Gomes','50000',8,2),
 ('Sofia','Ferreira','90000',10,1),
 ('Julia','Klein','30000',11,1),
 ('Roberto','Garcia','60000',12,2),
 ('Julio','Pereira','85500',13,1),
 ('Daniela','Silva','45000',14,3),
 ('Natalia','do Vale','75000',15,2);;
CREATE TABLE `employee_works_on_project` (
  `emp_id` int(10) unsigned NOT NULL default '0',
  `prj_id` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`emp_id`,`prj_id`)
) TYPE=MyISAM;
INSERT INTO `employee_works_on_project` (`emp_id`,`prj_id`) VALUES 
 (1,1),
 (2,1),
 (3,2),
 (4,1),
 (4,2),
 (5,2);
CREATE TABLE `project` (
  `prj_id` int(10) unsigned NOT NULL auto_increment,
  `prj_name` varchar(40) default NULL,
  `prj_budget` decimal(10,2) default NULL,
  PRIMARY KEY  (`prj_id`)
) TYPE=MyISAM;
INSERT INTO `project` (`prj_id`,`prj_name`,`prj_budget`) VALUES 
 (1,'APOLLO','1000000.00'),
 (2,'GEMINI','500000.00');
CREATE TABLE `service` (
  `serv_id` int(10) unsigned NOT NULL auto_increment,
  `serv_name` varchar(40) default NULL,
  PRIMARY KEY  (`serv_id`)
) TYPE=MyISAM;
INSERT INTO `service` (`serv_id`,`serv_name`) VALUES
 (1,'Tecnologia'),
 (2,'Contabilidade'),
 (3,'Producao');
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT;
SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS;
SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
