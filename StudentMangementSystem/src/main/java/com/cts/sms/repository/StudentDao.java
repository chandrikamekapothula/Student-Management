package com.cts.sms.repository;

import java.text.ParseException;
import java.util.List;

import com.cts.sms.model.Student;

public interface StudentDao {

	public int addStudentDetails(Student s) throws ParseException;
	
	public int deleteStudentDetails(int id);
	
	public Student viewStudentDetails(int id);
	public int updateStudentDetails(Student s,int id);
	public List<Student> viewAllStudents();
	public int addMarks(Student s,int id);
	public int getMarks(int id);
	public int saveGrade(int id, String grade);
	public Student viewAcademicDetails(int id);
	public List<Student> viewAllAcademicStudents();
}
