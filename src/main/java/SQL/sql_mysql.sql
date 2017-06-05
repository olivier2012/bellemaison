/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  olivier-h
 * Created: Jun 4, 2017
 */
create database bellemaison;
create user 'bellemaison'@'%' identified by 'goodlucky';
grant create,drop,delete,insert,select,update,grant option on bellemaison.* to 'bellemaison'@'%';
flush privileges;
drop table person;
create table person (
  person_id int primary key auto_increment,
  firstname varchar(30) not null,
  lastname  varchar(30) not null, 
  age int,
  nation varchar(30),
  telephonenumber varchar(30),
  mobilenumber varchar(30),
  address varchar(60),
  education varchar(30),
  birthdate date,
  picture_id int,
  location_id int,
  motherlastname varchar(30) not null
);

insert into person (   person_id ,firstname ,lastname  , age ,nation ,telephonenumber,mobilenumber ,address ,education ,birthdate ,picture_id,location_id ,
  motherlastname) values(last_insert_id(person_id),'Tomas','Bell',25,'USA','553-453-4567','3456677990','address first street','MBA','1992-03-06',null,null,'Jerry');
  
 
insert into person (   person_id ,firstname ,lastname  , age ,nation ,telephonenumber,mobilenumber ,address ,education ,birthdate ,picture_id,location_id ,
  motherlastname) values(last_insert_id(person_id),'Jerry','Make',29,'USA','553-453-5567','3458677990','address second street','MBA','1989-03-06',null,null,'Jery');
 
insert into person (   person_id ,firstname ,lastname  , age ,nation ,telephonenumber,mobilenumber ,address ,education ,birthdate ,picture_id,location_id ,
  motherlastname) values(last_insert_id(person_id),'peter','Napon',59,'USA','553-456-5567','3458987790','address Third street','College','1969-03-06',null,null,'FA');
    
create table location (
  location_id int primary key  auto_increment,
  region_id  int ,
  street varchar(60),
  postalcode varchar(8), 
  country_id int,
  stateprovince varchar(30),
  photo_id int
);
insert into location (   location_id ,region_id,street  , postalcode ,country_id ,stateprovince,photo_id ) values(last_insert_id(location_id),null,'','H4E2R7',null,'QC',null);
 
insert into location (   location_id ,region_id,street  , postalcode ,country_id ,stateprovince,photo_id ) values(last_insert_id(location_id),null,'','H5E2R7',null,'AB',null); 

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
);
create table customer (
  customer_id int primary key  auto_increment,
  person_id  int ,
  owner  boolean,
  buydate date, 
  saler  boolean,
  saledate date,
  house_id int
);
create table country (
  country_id int primary key  auto_increment,
  region_id  int ,
  countryname varchar(60),
  location_id int
);

create table region (
  region_id int primary key  auto_increment,
  country_id  int ,
  regionname varchar(60),
  cityname varchar(60),
  location_id int
);

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
);

insert into house ( house_id ,location_id, customer_id ,employee_id ,registerdate,picture_id,adprice,layer,type,proportion,memories ) values(last_insert_id(house_id),null,null,null,'2010-01-01',null,530000.98,'second foor','house',8300,'sale');

insert into house ( house_id ,location_id, customer_id ,employee_id ,registerdate,picture_id,adprice,layer,type,proportion,memories ) values(last_insert_id(house_id),null,null,null,'2010-03-01',null,5306600.98,'second foor','house',88900 ,'sale');

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
);

