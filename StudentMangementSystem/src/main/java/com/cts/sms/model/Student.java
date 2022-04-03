package com.cts.sms.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Student {

	private int id;
	private String name;
	private String gender;
	private String email;
	
	private String fname;
	private String mname;
	private String phno;
   private String dob1;
   private int marks1;
   private int marks2;
   private int marks3;
   private String grade;
	public int getMarks1() {
		return marks1;
	}
	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}
	public int getMarks2() {
		return marks2;
	}
	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}
	public int getMarks3() {
		return marks3;
	}
	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public Student(int id, String name, String gender, String email, String dob1, String fname, String mname,
			String phno) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.dob1 = dob1;
		this.fname = fname;
		this.mname = mname;
		this.phno = phno;
		
	}
	public Student() {
		super();
		
	}
	public String getDob1() {
		return dob1;
	}
	public void setDob1(String dob1) {
		this.dob1 = dob1;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Student(int id, String name, int marks1, int marks2, int marks3, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
		this.grade = grade;
	}
	public Student(int id, String name, String gender, String email, String fname, String mname, String phno,
			String dob1, int marks1, int marks2, int marks3, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.fname = fname;
		this.mname = mname;
		this.phno = phno;
		this.dob1 = dob1;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
		this.grade = grade;
	}
	
	
	
}
