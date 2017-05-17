package com.olivier.bellemaison.DB;

public class Student {
    public final String cre_sql= "create table student ("
                       + "student_id int , "
                       + "register_date date, "
                       + " First_name varchar(40),Last_name varchar(40),"
                       +"Email varchar(60),phone_number varchar(20),"  
                       +"Course_id varchar(20),Mark_id varchar(20) );";
    private int Student_id;
    private String First_name;
    private String Last_name;
    private String Email;
    private String Phone_number;
    private String register_date;
    private String Course_id;
    private String Mark_id;

    public Student() {
       
    }
        public Student(int studentid,String firstname, String lastname,String course) {
        this.First_name = firstname;
        this.Last_name = lastname;
        this.Course_id = course;
        this.Student_id = studentid;
    }
	/**
	 * @return the employee_id
	 */
	public int getStudent_id() {
		return Student_id;
	}
	/**
	 * @param employee_id the employee_id to set
	 */
	public void setStudent_id(int student_id) {
		Student_id = student_id;
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return First_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		First_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return Last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}
	/**
	 * @return the phone_number
	 */
	public String getPhone_number() {
		return Phone_number;
	}
	/**
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(String phone_number) {
		this.Phone_number = phone_number;
	}
	/**
	 * @return the hire_date
	 */
	public String getregister_date() {
		return register_date;
	}
	/**
	 * @param hire_date the hire_date to set
	 */
	public void setregister_date(String register_date) {
		this.register_date = register_date;
	}
	/**
	 * @return the manager_id
	 */
	public String getCourse_id() {
		return Course_id;
	}
	/**
	 * @param manager_id the manager_id to set
	 */
	public void setCourse_id(String Course_id) {
		this.Course_id = Course_id;
	}
	/**
	 * @return the department_id
	 */
	public String getMark_id() {
		return Mark_id;
	}
	/**
	 * @param department_id the department_id to set
	 */
	public void setMark_id(String Mark_id) {
		Mark_id = Mark_id;
	}
 

   
    
}
