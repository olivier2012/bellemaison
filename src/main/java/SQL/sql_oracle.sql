/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  olivier-h
 * Created: Jun 4, 2017
 */
drop table person;
create table person (
  person_id int primary key ,
  firstname varchar(30) not null,
  lastname  varchar(30) not null, 
  age int,
  nation varchar(30),
  telephonenumber varchar(30),
  mobilenumber varchar(30),
  address varchar(60),
  education varchar(30),
  birthdate date,
  photo_id int,
  location_id int,
  motherlastname varchar(30) not null,
  primary key(firstname,lastname,motherlastname)
)

create table employee (
  employee_id int primary key ,
  person_id  int ,
  jobtitle varchar(30),
  company  varchar(30), 
  empldate date,
  leavedate date,
  depart_id int,
  manager_id int,
  photo_id int,
  location_id int
)



