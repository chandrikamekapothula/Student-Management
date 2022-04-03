package com.cts.sms.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sms.model.Student;
import com.cts.sms.repository.StudentDao;
import com.cts.sms.repository.StudentDaoImpl;

@Service
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	StudentDao dao;

	@Override
	public int addStudentDetails(Student s) throws ParseException {
		return dao.addStudentDetails(s);
	}

	@Override
	public int deleteStudentDetails(int id) {
		return dao.deleteStudentDetails(id);
	}

	@Override
	public Student viewStudentDetails(int id) {
		return dao.viewStudentDetails(id);
	}

	@Override
	public int updateStudentDetails(Student s, int id) {
		return dao.updateStudentDetails(s, id);
	}

	@Override
	public List<Student> viewAllStudents() {

		return dao.viewAllStudents();
	}

	@Override
	public int addMarks(Student s, int id) {

		return dao.addMarks(s, id);
	}

	public int getMarks(int id) {
		return dao.getMarks(id);
	}

	public String calculateGrade(int marks) {
		int avg = (int) marks / 3;

		String grade = "";
		if (avg >= 95)
			grade = "A+";
		else if (avg >= 85 && avg < 95)
			grade = "A";
		else if (avg >= 70 && avg < 85)
			grade = "B";
		else if (avg >= 60 && avg < 70)
			grade = "C";
		else if (avg >= 50 && avg < 60)
			grade = "D";
		else if (avg >= 35 && avg < 50)
			grade = "E";
		else
			grade = "F";
		return grade;

	}

	public int saveGrade(int id, String grade) {
		return dao.saveGrade(id, grade);
	}

	@Override
	public Student viewAcademicDetails(int id) {
		return dao.viewAcademicDetails(id);
	}

	@Override
	public List<Student> viewAllAcademicStudents() {
		return dao.viewAllAcademicStudents();
	}

}
