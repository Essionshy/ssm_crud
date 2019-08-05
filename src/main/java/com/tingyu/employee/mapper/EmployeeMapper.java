package com.tingyu.employee.mapper;

import java.util.List;

import com.tingyu.employee.pojo.Employee;

public interface EmployeeMapper {
	int deleteByPrimaryKey(Long empId);
	
	int deleteByIds(List<Long> ids);

	int insert(Employee record);

	Employee selectByPrimaryKey(Long empId);

	Employee selectByPrimaryKeyWithDept(Long empId);

	List<Employee> selectAll();

	List<Employee> selectAllWithDept();

	int updateByPrimaryKey(Employee record);

}