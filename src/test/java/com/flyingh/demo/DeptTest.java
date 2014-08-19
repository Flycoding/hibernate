package com.flyingh.demo;

import org.hibernate.Session;
import org.junit.Test;

import com.flyingh.util.HibernateUtils;
import com.flyingh.vo.Department;
import com.flyingh.vo.Employee;

public class DeptTest {
	@Test
	public void testSave() {
		final Session session = HibernateUtils.getSession();
		session.beginTransaction();
		final Department department = new Department();
		department.setName("Dev");
		final Employee emp1 = new Employee();
		emp1.setName("haha");
		emp1.setDepartment(department);
		final Employee emp2 = new Employee();
		emp2.setName("hehe");
		emp2.setDepartment(department);
		department.getEmployees().add(emp1);
		department.getEmployees().add(emp2);
		session.save(department);
		session.save(emp1);
		session.save(emp2);
		session.getTransaction().commit();
		session.close();
	}
}
