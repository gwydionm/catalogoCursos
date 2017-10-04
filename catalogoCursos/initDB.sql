
DROP TABLE IF EXISTS `autentia`.`cursos`;
CREATE TABLE  `autentia`.`cursos` (
  `id_curso` int(10) NOT NULL AUTO_INCREMENT,
  `titulo_curso` varchar(255) NOT NULL,
  `nivel_curso` varchar(255) NOT NULL,
  `horas_curso` int(10) NOT NULL,
  `id_profesor` int(10) NOT NULL,
  `curso_activo` varchar(255) NOT NULL,
  PRIMARY KEY (`id_curso`)
) 
ENGINE=InnoDB;

insert into cursos (titulo_curso, nivel_curso, horas_curso, id_profesor, curso_activo) values ('curso1', 'Básico', 25, 1, 'si');
insert into cursos (titulo_curso, nivel_curso, horas_curso, id_profesor, curso_activo) values ('curso2', 'Intermedio', 50, 2, 'no');
insert into cursos (titulo_curso, nivel_curso, horas_curso, id_profesor, curso_activo) values ('curso3', 'Avanzado', 80, 3, 'si');


DROP TABLE IF EXISTS `autentia`.`profesores`;
CREATE TABLE  `autentia`.`profesores` (
  `id_profesor` int(10) NOT NULL AUTO_INCREMENT,
  `nombre_profesor` varchar(255) NOT NULL,
  PRIMARY KEY (`id_profesor`)
) 
ENGINE=InnoDB;

insert into profesores (nombre_profesor) values ('José Miguel Fernández');
insert into profesores (nombre_profesor) values ('Antonio López');
insert into profesores (nombre_profesor) values ('Pedro Gómez');
insert into profesores (nombre_profesor) values ('Laura Rodríguez');