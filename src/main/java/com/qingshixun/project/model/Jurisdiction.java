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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="t_jurisdiction")
public class Jurisdiction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id递增
	private Integer id;
	@Column(name="name",unique=true)
	private String name; // 权限名称
	private String description; // 描述

	// 创建时间(updateable=false表示编辑后，不更新此字段)
	@Column(nullable = true, length = 19,updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = ISO.DATE)
	private Date createTime = new Date(System.currentTimeMillis());

	
	@ManyToMany(targetEntity=Role.class,mappedBy="jurisdictions")
	private Set<Role> roles=new HashSet<>();
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Jurisdiction [id=" + id + ", name=" + name + ", description=" + description + ", createTime="
				+ createTime + "]";
	}


	
}
