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
  person_id int  primary key auto_increment,
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
  motherlastname varchar(30) not null
)

create table location (
  location_id int primary key  auto_increment,
  region_id  int ,
  street varchar(60),
  postalcode varchar(8), 
  country_id int,
  stateprovince varchar(30),
  photo_id int
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
create table customer (
  customer_id int primary key  auto_increment,
  person_id  int ,
  owner  boolean,
  buydate date, 
  saler  boolean,
  saledate date,
  house_id int
)
create table country (
  country_id int primary key  auto_increment,
  region_id  int ,
  countryname varchar(60),
  location_id int
)

create table region (
  region_id int primary key  auto_increment,
  country_id  int ,
  regionname varchar(60),
  cityname varchar(60),
  location_id int
)

create table house (
  house_id int primary key  auto_increment,
  location_id  int ,
  customer_id int,
  employee_id  int, 
  picture_id int,
  registerdate date,
  adprice float,
  layer varchar(20),
  type varchar(10),
  proportion varchar(30),
  memories varchar(80)
)
create table picture (
  picture_id int primary key  auto_increment,
  location_id  int ,
  customer_id int,
  employee_id  int, 
  takepicturerdate date,
  bedroom varchar(50),
  bathroom varchar(50),
  meetingroom varchar(50),
  backyard varchar(30),
  frontpicture varchar(80),
  dinnerroom varchar(50)
)





