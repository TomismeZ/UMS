package com.qingshixun.project.dao;

import java.util.List;


import com.qingshixun.project.model.Role;

public interface IRoleDao extends BaseDao<Role, Integer> {
	
	public Role findByName(String name);
}
