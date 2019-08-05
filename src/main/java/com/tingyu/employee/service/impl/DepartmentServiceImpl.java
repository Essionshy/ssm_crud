package com.tingyu.employee.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tingyu.employee.mapper.DepartmentMapper;
import com.tingyu.employee.pojo.Department;
import com.tingyu.employee.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper deptMapper;
	@Override
	public List<Department> listDepts() {
		return deptMapper.selectAll();
	}

}
