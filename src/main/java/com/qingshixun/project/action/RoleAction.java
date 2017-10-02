package com.qingshixun.project.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.qingshixun.project.model.Jurisdiction;
import com.qingshixun.project.model.PageBean;
import com.qingshixun.project.model.Role;
import com.qingshixun.project.service.IJurisdictionService;
import com.qingshixun.project.service.IRoleService;

@ParentPackage("web-default")
@Scope("prototype")
@Results({ @Result(name = "login", location = "/WEB-INF/views/login.jsp") })
// @Controller
public class RoleAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IRoleService roleService;

	// 自动注入
	@Autowired
	private IJurisdictionService jurisdictionService;

	private Role role;

	// 权限列表集合
	private List<Jurisdiction> jurisdictions;
	// 权限列表名字
	private List<String> jurisdictionNames;
	// 用户显示在页面上集合
	private PageBean<Role> pageBean;
	// 分页的页数
	private int page;
	//从页面上传入的值
	private Integer id;

	/**
	 * 跳转到添加或者编辑角色页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "toRole",  interceptorRefs = { @InterceptorRef("myInterceptorStack") },results = { @Result(name = SUCCESS, location = "/WEB-INF/views/add_role.jsp") })
	public String toRole() throws Exception {
		
		if(id!=null){
			role = roleService.get(id);		
		}
		jurisdictions = jurisdictionService.findAll();
		return SUCCESS;
	}

	/**
	 * 保存角色信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "saveRole", interceptorRefs = { @InterceptorRef("myInterceptorStack") }, results = { @Result(name = SUCCESS, location = "/WEB-INF/views/add_role.jsp") })
	public String saveRole() throws Exception {
		System.out.println("执行了保存！"+jurisdictionNames+role);
		
			role.setCreateTime(new Date());

			for (String jurisdictionName : jurisdictionNames) {
				System.out.println(jurisdictionName);
				jurisdictions = jurisdictionService.findByName(jurisdictionName);
				Jurisdiction jurisdiction = jurisdictions.get(0);
				System.out.println(jurisdiction.getId() + "-----");
				role.getJurisdictions().add(jurisdiction);
			}
			roleService.saveOrUpdate(role);
			System.out.println(role);

		

		return SUCCESS;
	}

	/**
	 * 显示角色列表信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "findAllRole", interceptorRefs = { @InterceptorRef("myInterceptorStack") }, results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/roleManage.jsp") })
	public String findAllRole() throws Exception {
		pageBean = roleService.getPageBean(5, page);
		System.out.println(pageBean);
		return SUCCESS;
	}


	
	/**
	 * 删除角色
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "deleteRole", interceptorRefs = { @InterceptorRef("myInterceptorStack") }, results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/roleManage.jsp") })
	public String deleteRole() throws Exception {
		System.out.println("执行了删除----"+id);
		if (id != null) {
			roleService.delete(id);
		}
		
		return SUCCESS;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Jurisdiction> getJurisdictions() {
		return jurisdictions;
	}

	public List<String> getJurisdictionNames() {
		return jurisdictionNames;
	}

	public void setJurisdictionNames(List<String> jurisdictionNames) {
		this.jurisdictionNames = jurisdictionNames;
	}

	public PageBean<Role> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Role> pageBean) {
		this.pageBean = pageBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// public void setJurisdictions(List<Jurisdiction> jurisdictions) {
	// this.jurisdictions = jurisdictions;
	// }

}
