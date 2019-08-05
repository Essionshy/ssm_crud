package com.tingyu.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tingyu.employee.pojo.Employee;
import com.tingyu.employee.service.EmployeeService;
import com.tingyu.employee.util.ResponseMessage;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	/**
	 * #分页查询员工信息，返回JSON数据
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/emp/query", method = RequestMethod.GET)
	public ResponseMessage listEmps(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "8") int pageSize) {
		System.out.println("ajax请求查询 员工信息");

		PageHelper.startPage(pageNum, pageSize);
		List<Employee> emps = empService.listAllEmps();
		PageInfo pageInfo = new PageInfo(emps, 5);
		return ResponseMessage.getSuccessMessage().add("pageInfo", pageInfo);
	}
	/**
	 * #通过员工id获取单个员工信息
	 * @param id
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public ResponseMessage getEmpById(@PathVariable("id") Long id) {
		Employee emp= empService.getEmpById(id);
		System.out.println(emp);
		return ResponseMessage.getSuccessMessage().add("emp", emp);
	}

	/**
	 * #分页查询员工信息跳转到显示页面
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/emp/list", method = RequestMethod.GET)
	public String list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "8") int pageSize, Model model) {
		PageHelper.startPage(pageNum, pageSize);
		List<Employee> emps = empService.listAllEmps();
		PageInfo pageInfo = new PageInfo(emps, 5);
		model.addAttribute("PageInfo", pageInfo);
		return "emp";
	}

	/**
	 * #添加用户信息
	 * @param employee
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public ResponseMessage saveEmp(Employee employee) {
		System.out.println("请求添加员工信息" + employee);
		int count = empService.saveEmp(employee);
		System.out.println("count:" + count);
		if (count > 0) {
			return ResponseMessage.getSuccessMessage();
		} else {
			return ResponseMessage.getFailureMessage();
		}
	}
	/**
	 * #更新员工信息
	 * @param employee
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
	public ResponseMessage updateEmp(Employee employee) {
		System.out.println("修改请求"+employee);
		int count = empService.updateEmp(employee);
		if (count > 0) {
			return ResponseMessage.getSuccessMessage();
		} else {
			return ResponseMessage.getFailureMessage();
		}
	}

	/**
	 * #删除单个记录与批量删除二全一	
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
	public ResponseMessage deleteEmp(@PathVariable("ids") String ids) {
		if(ids.contains("-")) {
			//批量删除记录
			List<Long> list_id=new ArrayList<>();
			String [] str_ids=ids.split("-");
			for(String id:str_ids) {
				list_id.add(Long.valueOf(id));
			}
			empService.deleteEmpsByBatch(list_id);
		}else {
			//删除单个记录
			Long id=Long.valueOf(ids);
			int count = empService.deleteEmpById(id);			
		}		
		return ResponseMessage.getSuccessMessage();
	}
}
