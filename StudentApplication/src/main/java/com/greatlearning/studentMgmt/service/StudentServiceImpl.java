package com.greatlearning.studentMgmt.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.greatlearning.studentMgmt.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService {

	private SessionFactory sessionFactory;

	private Session session;

	public StudentServiceImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		this.session = sessionFactory.openSession();
	}

	@Transactional
	public List<Student> findAll() {
		List<Student> studentList = session.createQuery("from Student", Student.class).list();
		return studentList;
	}

	@Transactional
	public Student findById(int id) {
		Student student = session.get(Student.class, id);
		return student;
	}

	//@Transactional
	public void save(Student theStudent) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(theStudent);
		tx.commit();

	}

	@Transactional
	public void deleteById(int theId) {
//		Student student = session.get(Student.class, theId);
//		// delete the record
//		session.delete(student);
		
		Transaction tx = session.beginTransaction();
		try{
			Student student = session.get(Student.class, theId);
			// delete the record
			session.delete(student);
		}finally {
			tx.commit();
		}
	}

}
