package com.cts.sms.repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cts.sms.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	JdbcTemplate template;
	
	
	@Override
	public int addStudentDetails(Student s) throws ParseException {
		
		Date registerDate = Date.valueOf(s.getDob1());

		 java.sql.Date sqlDate = new java.sql.Date(registerDate.getTime());
		 String q ="insert into student(id,name,gender,email,dob,fname,mname,phno)values('"+s.getId()+"','"+s.getName()+"','"+s.getGender(
		  )+"','"+s.getEmail()+"','"+sqlDate+"','"+s.getFname()+"','"+s.getMname()+"','"+s.getPhno()+"')";
		 return template.update(q);
		 
	}


	@Override
	public int deleteStudentDetails(int id) {
		String q = "delete from student where id = '"+id+"'";
		return template.update(q);
	}


	@Override
	public Student viewStudentDetails(int id) {
		try
		{
		String q = "select * from student where id=?";
		return  template.queryForObject(q, new Object[] {id},(rs,rowNum)->
		new Student(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4),
				rs.getString(5),
				rs.getString(6),
				rs.getString(7),
				rs.getString(8)
				
				
				));
		}
		catch(EmptyResultDataAccessException e)
		{
			return null;
		}
	}


	@Override
	public int updateStudentDetails(Student s,int id) {

		String q = "update student set name = '"+s.getName()+"',gender = '" + s.getGender()+"' , email = '"+s.getEmail()+"', dob = '"+s.getDob1()+" ',fname = '"+s.getFname()+" ' ,mname = '"+s.getMname()+"',phno = '"+s.getPhno()+"' where id= '"+id+"'";
		
		return template.update(q);
				
	}


	@Override
	public List<Student> viewAllStudents() {
		String q = "select * from student order by 1";
		return template.query(q,new ResultSetExtractor<List<Student>>()
						
				{
			
			public List<Student> extractData(ResultSet rs) throws SQLException,DataAccessException,NullPointerException
			{
				List<Student> list = new ArrayList<Student>();
				
				while(rs.next())
				{
					Student s =new Student();
					s.setId(rs.getInt(1));
					s.setName(rs.getString(2));
					s.setGender(rs.getString(3));
					s.setEmail(rs.getString(4));
					s.setDob1(rs.getString(5));
					s.setFname(rs.getString(6));
					s.setMname(rs.getString(7));
					s.setPhno(rs.getString(8));
					list.add(s);
					
				}
				if(list.size()==0)
				{
					return null;
				}
				return list;
			}
			
				});
				
				
				
	}


	@Override
	public int addMarks(Student s, int id) {

		
String q = "update student set marks1 = '"+s.getMarks1()+"',marks2 = '" + s.getMarks2()+"' ,marks3 = '"+s.getMarks3()+"' where id= '"+id+"'";
		
		return template.update(q);
	}


	@Override
	public int getMarks(int id) {

		
		return 0;
	}


	@Override
	public int saveGrade(int id, String grade) {
String q = "update student set grade = '"+grade+"' where id= '"+id+"'";
		
		return template.update(q);
	}


	@Override
	public Student viewAcademicDetails(int id) {
		try {
		String q = "select id,name,marks1,marks2,marks3,grade from student where id=?";
		return  template.queryForObject(q, new Object[] {id},(rs,rowNum)->
		new Student(
				rs.getInt(1),
				rs.getString(2),
				rs.getInt(3),
				rs.getInt(4),
				rs.getInt(5),
				rs.getString(6)
				
				
				));
		}
		catch(EmptyResultDataAccessException e)
		{
			return null;
		}
		
	}


	@Override
	public List<Student> viewAllAcademicStudents() {
		String q = "select id,name,marks1,marks2,marks3,grade from student order by 1";
		return template.query(q,new ResultSetExtractor<List<Student>>()
						
				{
			
			public List<Student> extractData(ResultSet rs) throws SQLException,DataAccessException,NullPointerException
			{
				List<Student> list = new ArrayList<Student>();
				
				while(rs.next())
				{
					Student s =new Student();
					s.setId(rs.getInt(1));
					s.setName(rs.getString(2));
					s.setMarks1(rs.getInt(3));
					s.setMarks2(rs.getInt(4));
					s.setMarks3(rs.getInt(5));
					s.setGrade(rs.getString(6));
					
					list.add(s);
					
				}
				if(list.size()==0)
				{
					return null;
				}
				return list;
			}
			
				});
				
				
	}


	

}
