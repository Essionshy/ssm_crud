package com.tingyu.employee.service;

import java.util.List;

import com.tingyu.employee.pojo.Employee;

public interface EmployeeService {
	
	public List<Employee> listAllEmps() ;
	
	public Employee getEmpById(Long id);

	public int saveEmp(Employee employee);

	public int deleteEmpById(Long id);

	public int updateEmp(Employee employee);

	public int deleteEmpsByBatch(List<Long> ids);

	
	
}
