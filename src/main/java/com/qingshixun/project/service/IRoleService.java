package com.qingshixun.project.service;

import java.util.List;

import com.qingshixun.project.model.PageBean;
import com.qingshixun.project.model.Role;

public interface IRoleService extends IBaseService<Role, Integer>{
	
    /**
     * 通过姓名进行查询
     * @param name
     * @return
     */
    public Role findByName(String name);
    
}
