package com.greatlearning.studentMgmt.driver;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.studentMgmt.entity.Student;
import com.greatlearning.studentMgmt.service.StudentService;
import com.greatlearning.studentMgmt.service.StudentServiceImpl;

public class AppMain {

	public static void main(String[] args) {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		SessionFactory sessionFactory = con.buildSessionFactory();
		StudentService studentService = new StudentServiceImpl(sessionFactory);
		List<Student> StudentList = studentService.findAll();
		for (Student student : StudentList) {
			System.out.println(student.toString());
		}
	}
}
