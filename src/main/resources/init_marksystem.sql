create database marksystem;

use marksystem;

create table student (
id int(10) not null auto_increment,
firstname varchar(64) not null,
lastname varchar(64) not null,
birthdate date not null,
course int(10) not null,
sex char(1) not null,
primary key (id)
);

create table subject (
id int(10) not null auto_increment,
subject varchar(64) not null,
teacherfirstname varchar(64) not null,
teacherlastname varchar(64) not null,
enteryear int(4) not null,
primary key (id)
);

create table mark (
id int(10) not null auto_increment,
id_student int(10) not null,
id_subject int(10) not null,
mark int(10) not null,
date date not null,
primary key (id),
foreign key (id_student) references student(id),
foreign key (id_subject) references subject(id)
);
