package com.tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dao.StudentDao;
import com.tech.dto.Student;

@Service
public class StudentService {

	public StudentService() {
		System.out.println("StudentService constructor");
	}

	@Autowired
	StudentDao studentDao;

	public int createStudent(String fname, String lname) {
		System.out.println("inside StudentService createStudent method");
		Student student = new Student();
		student.setFname(fname);
		student.setLname(lname);

		int record = studentDao.createStudent(student);
		System.out.println(record);
		return record;
	}

	public List<Student> getAllStudent() {
		System.out.println("inside StudentService getAllStudent method");

		List<Student> stdlist = studentDao.getAllStudent();
		System.out.println(stdlist);
		return stdlist;
	}

	public void deleteStudent(int id) {
		System.out.println("inside StudentService deleteStudent");

		studentDao.deleteStudent(id);
	}

	public Student getStudentByid(int id) {
		System.out.println("inside StudentService getStudentByid method");

		Student student = studentDao.getStudentByid(id);

		return student;
	}
	
	public void updateStudent(Student student) {
		System.out.println("inside StudentService updateStudent method");
		
	  studentDao.updateStudent(student);  
	}
}
