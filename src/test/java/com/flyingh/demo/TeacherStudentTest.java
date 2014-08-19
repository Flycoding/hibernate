package com.flyingh.demo;

import org.hibernate.Session;
import org.junit.Test;

import com.flyingh.util.HibernateUtils;
import com.flyingh.vo.Student;
import com.flyingh.vo.Teacher;

public class TeacherStudentTest {
	@Test
	public void testSave() {
		final Session session = HibernateUtils.getSession();
		session.beginTransaction();
		final Teacher teacher1 = new Teacher();
		teacher1.setName("T1");
		final Teacher teacher2 = new Teacher();
		teacher2.setName("T2");

		final Student student1 = new Student();
		student1.setName("S1");
		final Student student2 = new Student();
		student2.setName("S2");

		teacher1.getStudents().add(student1);
		teacher1.getStudents().add(student2);
		teacher2.getStudents().add(student1);
		teacher2.getStudents().add(student2);

		student1.getTeachers().add(teacher1);
		student1.getTeachers().add(teacher2);
		student2.getTeachers().add(teacher2);
		student2.getTeachers().add(teacher1);

		session.save(teacher1);
		session.save(teacher2);
		session.save(student1);
		session.save(student2);

		session.getTransaction().commit();
		session.close();
	}
}
