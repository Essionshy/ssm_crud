package com.tingyu.employee.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tingyu.employee.mapper.EmployeeMapper;
import com.tingyu.employee.pojo.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class EmployeeTest {
	@Autowired
	EmployeeMapper empMapper;
	@Autowired
	SqlSession sqlSession;

	@Test
	public void testAddEmpByOne() {
		System.out.print(empMapper);
		String eid = UUID.randomUUID().toString().substring(0, 6);
		int count = empMapper.insert(new Employee(null, eid, "M", eid + "@tingyu.com", 1));
		System.out.println(count);

	}

	@Test
	public void testAddEmp() {

		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 1000; i++) {
			String eid = UUID.randomUUID().toString().substring(0, 6);
			mapper.insert(new Employee(null, eid, "M", eid + "@tingyu.com", 1));
		}
	}

	@Test
	public void testGetEmp() {

		Employee emp = empMapper.selectByPrimaryKeyWithDept(1L);
		// Employee emp=empMapper.selectByPrimaryKey(1L);
		System.out.println("返回员工信息" + emp);
	}
}
