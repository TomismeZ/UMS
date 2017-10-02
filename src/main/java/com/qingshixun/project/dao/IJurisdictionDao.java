package com.qingshixun.project.dao;

import java.util.List;

import com.qingshixun.project.model.Jurisdiction;

public interface IJurisdictionDao extends BaseDao<Jurisdiction, Integer> {
	public List<Jurisdiction> findByName(String name);
    
}
