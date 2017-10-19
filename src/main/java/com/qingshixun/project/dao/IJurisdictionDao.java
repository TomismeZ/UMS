package com.qingshixun.project.dao;

import com.qingshixun.project.model.Jurisdiction;

public interface IJurisdictionDao extends BaseDao<Jurisdiction, Integer> {
	public Jurisdiction findByName(String name);
    
}
