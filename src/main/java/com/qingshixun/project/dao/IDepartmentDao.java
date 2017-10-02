package com.qingshixun.project.dao;

import java.util.List;

import com.qingshixun.project.model.Department;

public interface IDepartmentDao extends BaseDao<Department, Integer>{
	public Department findByName(String name);
}
