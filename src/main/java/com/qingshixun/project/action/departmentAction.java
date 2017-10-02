package com.qingshixun.project.action;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.qingshixun.project.model.Department;
import com.qingshixun.project.model.PageBean;
import com.qingshixun.project.service.IDepartmentService;

@ParentPackage("web-default")
@Scope("prototype")
@Results({ @Result(name = "login", location = "/WEB-INF/views/login.jsp") })
public class departmentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IDepartmentService departmentService;

	private Department department;
	
	// 用户显示在页面上集合
	private PageBean<Department> pageBean;
	//从页面上得到page
	private int page;
	//从页面得到ID的值，用于查找，编辑以及删除
	private Integer id;
	
	/**
	 * 跳转到添加或者编辑部门界面
	 * @return
	 * @throws Exception
	 */
	@Action(value = "toDepartment",interceptorRefs = { @InterceptorRef("myInterceptorStack") }, 
			results = { @Result(name = SUCCESS, location = "/WEB-INF/views/add_department.jsp") })
	public String toDepartment() throws Exception {
		
		if(id!=null){
			department=departmentService.get(id);
			
		}
		System.out.println("id:"+id);
		return SUCCESS;
	}
	
	/**
	 * 保存或者修改部门信息
	 * @return
	 * @throws Exception
	 */
	@Action(value = "saveDepartment",interceptorRefs = { @InterceptorRef("myInterceptorStack") }, 
			results = { @Result(name = SUCCESS, location = "/WEB-INF/views/departmentManage.jsp") })
	public String saveDepartment() throws Exception {
		System.out.println("进入到saveDepartment方法");
		Department department2=new Department();
		if(id!=null){
			department2=departmentService.get(id);
			System.out.println("jurisdiction:"+department2);
		}
		department2.setCreateTime(new Date());
		department2.setName(department.getName());
		department2.setDescription(department.getDescription());
		departmentService.saveOrUpdate(department2);
					
			return SUCCESS;
		
	}
	

	/**
	 * 显示部门列表信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "findAllDepartment", interceptorRefs = { @InterceptorRef("myInterceptorStack") }, results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/departmentManage.jsp") })
	public String findAllDepartment() throws Exception {
		pageBean = departmentService.getPageBean(5, page);
		System.out.println(pageBean);
		return SUCCESS;
	}
	
	/**
	 * 根据id删除权限信息
	 * @return
	 * @throws Exception
	 */
	@Action(value = "deleteDepartment",interceptorRefs = { @InterceptorRef("myInterceptorStack") }, 
			results = { @Result(name = SUCCESS, location = "/WEB-INF/views/departmentManage.jsp") })
	public String deleteDepartment() throws Exception {
		System.out.println("执行了删除");
		if(id!=null){
			departmentService.delete(id);
		}
		System.out.println("id:"+id);
		return SUCCESS;
	}
	
	
	

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public PageBean<Department> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Department> pageBean) {
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


	

}
