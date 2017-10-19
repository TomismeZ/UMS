package com.qingshixun.project.service;

import com.qingshixun.project.model.Jurisdiction;

public interface IJurisdictionService extends IBaseService<Jurisdiction, Integer>{

    public Jurisdiction findByName(String name);
}
