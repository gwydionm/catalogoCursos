/*
drop table if exists teachers;
create table teachers (
	id int not null auto_increment,
    t_name varchar(50) not null,
    primary key (id)
 ) engine = innodb;
*/

drop table if exists courses;
create table courses(
  id int not null auto_increment,
  title varchar(50) not null,
  lvl enum('basic', 'intermediate', 'advanced'),
  hours int not null,
  teacher int not null,
  is_active boolean not null,
  primary key (id),
  foreign key (teacher) references teachers(id)
) engine=innodb;

insert into teachers (t_name) values ('juan');
insert into teachers (t_name) values ('maria');
insert into teachers (t_name) values ('luisa');
insert into teachers (t_name) values ('laura');

insert into courses (title, lvl, hours, teacher, is_active) values ('course1', 'basic', 20, 2, true);
insert into courses (title, lvl, hours, teacher, is_active) values ('course2', 'advanced', 30, 4, true);
insert into courses (title, lvl, hours, teacher, is_active) values ('course3', 'intermediate', 40, 2, false);
insert into courses (title, lvl, hours, teacher, is_active) values ('course4', 'basic', 230, 1, false);
insert into courses (title, lvl, hours, teacher, is_active) values ('course5', 'intermediate', 20, 3, true);