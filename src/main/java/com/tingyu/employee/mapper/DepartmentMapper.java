package com.tingyu.employee.mapper;


import java.util.List;

import com.tingyu.employee.pojo.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer deptId);

    int insert(Department record);

    Department selectByPrimaryKey(Integer deptId);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);
}