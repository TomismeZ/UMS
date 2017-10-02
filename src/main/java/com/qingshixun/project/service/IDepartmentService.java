package com.qingshixun.project.service;

import java.util.List;

import com.qingshixun.project.model.Department;

public interface IDepartmentService extends IBaseService<Department, Integer>{

    
    /**
     * 通过姓名来查找
     * @param name
     * @return
     */
    public Department findByName(String name);
}
