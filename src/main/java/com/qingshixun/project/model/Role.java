package com.qingshixun.project.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "t_role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id递增
	private Integer id;
	
	@Column(name="name",unique=true)
	private String name; // 角色名称

	private String description; // 角色描述

	// 创建时间(updateable=false表示编辑后，不更新此字段)
	@Column(nullable = true, length = 19,updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = ISO.DATE)
	private Date createTime = new Date(System.currentTimeMillis());
	// fetch类型如何改为lazy的话，可能会出现异常(对于编辑那一部分，如
	// org.hibernate.LazyInitializationException: failed to lazily initialize a
	// collection of role: com.qingshixun.project.model.Role.jurisdictions,
	// could not initialize proxy - no Session
	// )，也不知道是缓存的原因还是什么的,所以最好改为
	@ManyToMany(targetEntity = Jurisdiction.class, fetch = FetchType.EAGER)
	@JoinTable(name = "t_role_jurisd", joinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "jurisdiction_id", referencedColumnName = "id") })
	// 设置级联，当这个实体类与另一个实体之间存在着外键关系时，需要设置一个delete级联，把与这个记录关联的表也删除掉，如果是关联两张表以上就会出现错误
	private Set<Jurisdiction> jurisdictions = new HashSet<>();

	// 如果要删除角色的话，需要设置注解级联，把跟角色Id对应的账户删除掉（这里级联删除最好只设置在一的一方），这里使用的双向的
	@OneToMany(targetEntity = Account.class, mappedBy = "role")
	@Cascade(value = { CascadeType.ALL})
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

	public Set<Jurisdiction> getJurisdictions() {
		return jurisdictions;
	}

	public void setJurisdictions(Set<Jurisdiction> jurisdictions) {
		this.jurisdictions = jurisdictions;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	

}
