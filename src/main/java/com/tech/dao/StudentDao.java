package com.tech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.dto.Student;

@Repository
public class StudentDao {

	public StudentDao() {
		System.out.println("StudentDao constructor");
	}

	@Autowired
	SessionFactory sessionFactory;

	public int createStudent(Student student) {
		System.out.println("inside StudentDao createStudent");
		System.out.println(student);
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		int record = (int) session.save(student);
		txn.commit();
		return record;

	}

	public List<Student> getAllStudent() {
		System.out.println(" Inside StudentDao getAllStudent");

		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Student.class);

		List<Student> stdlist = cr.list();
		System.out.println(stdlist);
		return stdlist;
	}

	public void deleteStudent(int id) {
		System.out.println("inside StudentDao deleteStudent");

		Session session = sessionFactory.openSession();
		Student student = new Student();
		student.setId(id);
		session.delete(student);

		session.beginTransaction().commit();
	}

	public Student getStudentByid(int id) {
		System.out.println("inside StudentDao getStudentByid method");

		Session session = sessionFactory.openSession();

		Student student = session.get(Student.class, id);
		return student;
	}
	
	public void updateStudent(Student student) {
		System.out.println("inside StudentDao updateStudent method");
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(student);
		session.beginTransaction().commit();
		
	}
}
