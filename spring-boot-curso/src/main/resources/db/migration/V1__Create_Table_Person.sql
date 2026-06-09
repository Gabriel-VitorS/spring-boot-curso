-- spring_curso.person definition

CREATE TABLE `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `firt_name` varchar(80) NOT NULL,
  `last_name` varchar(80) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
)
