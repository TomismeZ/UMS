package com.qingshixun.project.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="t_department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id递增
	private Integer id;
	
	@Column(name="name",unique=true)
	private String name; // 部门名称
	private String description; // 描述

	// 创建时间(updateable=false表示编辑后，不更新此字段)
	@Column(nullable = true, length = 19,updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = ISO.DATE)
	private Date createTime = new Date(System.currentTimeMillis());
	
	//如果要删除部门的话，需要设置注解级联，把跟部门Id对应的账户删除掉（这里级联删除最好只设置在一的一方），这里使用的双向的
	@OneToMany(targetEntity=Account.class,mappedBy="department")
/*	@Cascade(value={CascadeType.ALL,CascadeType.DELETE})*/
	private Set<Account> accounts;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}




	
	
}
