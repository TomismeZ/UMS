package com.qingshixun.project.service;

import java.util.List;

import com.qingshixun.project.model.Jurisdiction;

public interface IJurisdictionService extends IBaseService<Jurisdiction, Integer>{

    public List<Jurisdiction> findByName(String name);
}
