package com.olivier.bellemaison.DB.Person;

import java.util.Date;

public class Person {
    public final String cre_sql= "create table person (\n" +
"  person_id int primary key auto_increment,\n" +
"  firstname varchar(30) not null,\n" +
"  lastname  varchar(30) not null, \n" +
"  age int,\n" +
"  nation varchar(30),\n" +
"  telephonenumber varchar(30),\n" +
"  mobilenumber varchar(30),\n" +
"  address varchar(60),\n" +
"  education varchar(30),\n" +
"  birthdate date,\n" +
"  picture_id int,\n" +
"  location_id int,\n" +
"  motherlastname varchar(30) not null\n" +
")";

 private int person_id;
 private String firstname;
 private String lastname ; 
 private int age ;
 private String nation ;
 private String telephonenumber;
 private String mobilenumber;
 private String address;
 private String education;
 private Date birthdate ;
 private int picture_id ;
 private int location_id;
 private int motherlastname;
 
    public Person() {
       
    }

    public Person(int person_id, String firstname, String lastname, int age, String nation, String telephonenumber, String mobilenumber, String address, String education, Date birthdate, int picture_id, int location_id, int motherlastname) {
        this.person_id = person_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.nation = nation;
        this.telephonenumber = telephonenumber;
        this.mobilenumber = mobilenumber;
        this.address = address;
        this.education = education;
        this.birthdate = birthdate;
        this.picture_id = picture_id;
        this.location_id = location_id;
        this.motherlastname = motherlastname;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getTelephonenumber() {
        return telephonenumber;
    }

    public void setTelephonenumber(String telephonenumber) {
        this.telephonenumber = telephonenumber;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(int picture_id) {
        this.picture_id = picture_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public int getMotherlastname() {
        return motherlastname;
    }

    public void setMotherlastname(int motherlastname) {
        this.motherlastname = motherlastname;
    }
     
    
}
