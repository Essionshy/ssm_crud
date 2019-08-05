package com.tingyu.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tingyu.employee.pojo.Department;
import com.tingyu.employee.service.DepartmentService;
import com.tingyu.employee.util.ResponseMessage;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ResponseMessage listDepts() {			
		List<Department> depts=deptService.listDepts();
		return ResponseMessage.getSuccessMessage().add("depts", depts);
	}
}
