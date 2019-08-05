package com.tingyu.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tingyu.employee.mapper.EmployeeMapper;
import com.tingyu.employee.pojo.Employee;
import com.tingyu.employee.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper empMapper;

	@Override
	public List<Employee> listAllEmps() {
		return empMapper.selectAllWithDept();
	}

	@Override
	public Employee getEmpById(Long id) {
		return empMapper.selectByPrimaryKeyWithDept(id);
	}

	@Override
	public int saveEmp(Employee employee) {
		System.out.println("请求调用服务层添加员工信息"+empMapper.insert(employee));
		return empMapper.insert(employee);
	}

	@Override
	public int deleteEmpById(Long id) {
		return empMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateEmp(Employee employee) {
		return empMapper.updateByPrimaryKey(employee);
	}

	@Override
	public int deleteEmpsByBatch(List<Long> ids) {
		return empMapper.deleteByIds(ids);
	}
	

}
