package com.tingyu.employee.service;

import java.util.List;

import com.tingyu.employee.pojo.Department;

public interface DepartmentService {
	/**
	 * #获取所有部门信息
	 * @return
	 */
	public List<Department> listDepts();
}
