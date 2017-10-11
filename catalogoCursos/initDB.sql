
drop table if exists courses;
drop table if exists teachers;
create table teachers (
	id int not null auto_increment,
    t_name varchar(50) not null,
    primary key (id)
 ) engine = innodb;


create table courses(
  id int not null auto_increment,
  title varchar(50) not null,
  lvl enum('basic', 'intermediate', 'advanced'),
  hours int not null,
  teacher int not null,
  is_active tinyint not null,
  file_name varchar(255),
  primary key (id),
  foreign key (teacher) references teachers(id)
) engine=innodb;

insert into teachers (t_name) values ('juan');
insert into teachers (t_name) values ('maria');
insert into teachers (t_name) values ('luisa');
insert into teachers (t_name) values ('laura');

insert into courses (title, lvl, hours, teacher, is_active, file_name) values ('course1', 'basic', 20, 2, 1, '');
insert into courses (title, lvl, hours, teacher, is_active, file_name) values ('course2', 'advanced', 30, 4, 1, '');
insert into courses (title, lvl, hours, teacher, is_active, file_name) values ('course3', 'intermediate', 40, 2, 0, '');
insert into courses (title, lvl, hours, teacher, is_active, file_name) values ('course4', 'basic', 230, 1, 0, '');
insert into courses (title, lvl, hours, teacher, is_active, file_name) values ('course5', 'intermediate', 20, 3, 1, '');