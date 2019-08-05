package com.tingyu.employee.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tingyu.employee.mapper.DepartmentMapper;
import com.tingyu.employee.pojo.Department;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class DepartmentTest {
	@Autowired
	private DepartmentMapper deptMapper;

	@Test
	public void testAddDept() {
		System.out.println(deptMapper);
		deptMapper.insert(new Department(null, "人事部"));
		deptMapper.insert(new Department(null, "公关部"));
	}
	@Test
	public void testQueryDept() {		
		List<Department> depts=deptMapper.selectAll();
		for(Department dept :depts) {
			System.out.println(dept);
		}
	}
}
