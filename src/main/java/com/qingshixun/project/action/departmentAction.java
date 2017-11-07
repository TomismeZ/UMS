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
import com.qingshixun.project.interceptor.PrivilegeInfo;
import com.qingshixun.project.model.Department;
import com.qingshixun.project.model.PageBean;
import com.qingshixun.project.service.IDepartmentService;

@ParentPackage("web-default")
@Scope("prototype")
@Results({ @Result(name = "login", location = "/WEB-INF/views/login.jsp"),
		@Result(name = "jurisdiction", location = "/WEB-INF/views/jurisdiction/jurisdiction_interceptor.jsp"), })
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
	// 从页面上得到page
	private int page;
	// 从页面得到ID的值，用于查找，编辑以及删除
	private Integer id;

	//用于显示在页面上的提示信息
	private String message;
	
	private List<Integer> arrayId;
	/**
	 * 跳转到添加或者编辑部门界面
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "toDepartment", interceptorRefs = { @InterceptorRef("myInterceptorStack") }, results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/add_department.jsp") })
	public String toDepartment() throws Exception {

		if (id != null) {
			department = departmentService.get(id);

		}
		System.out.println("id:" + id);
		return SUCCESS;
	}
	
	/**
	 * 保存部门信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "saveDepartment", interceptorRefs = { @InterceptorRef("myInterceptorStack")}, results = {
					@Result(name = SUCCESS, type = "json") })
	public String saveDepartment() throws Exception {
		
		if(departmentService.findByName(department.getName())!=null){
			message="error";
		}else{
			departmentService.save(department);
			message="success";
		}
		
		return SUCCESS;

	}

	/**
	 * 修改部门信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "editDepartment", interceptorRefs = { @InterceptorRef("myInterceptorStack")}, results = {
					@Result(name = SUCCESS, type = "json") })
	public String editDepartment() throws Exception {
		System.out.println("进入编辑页面！----");
		departmentService.saveOrUpdate(department);
		message="success";
		return SUCCESS;

	}

	/**
	 * 显示部门列表信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "findAllDepartment", interceptorRefs = { @InterceptorRef("myInterceptorStack")},
			results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/departmentManage.jsp") })
	public String findAllDepartment() throws Exception {
		pageBean = departmentService.getPageBean(5, page);
		System.out.println(pageBean);
		return SUCCESS;
	}

	/**
	 * 根据id删除权限信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "deleteDepartment", interceptorRefs = { @InterceptorRef("myInterceptorStack"),@InterceptorRef("jurisdictionInterceptor") },
			results = {@Result(name = SUCCESS, type = "json") })
	@PrivilegeInfo(name="删除")
	public String deleteDepartment() throws Exception {
		System.out.println("执行了删除");
		if (id != null) {
			try {
				departmentService.delete(id);
				message="success";
			} catch (Exception e) {
				message="error";
				System.out.println("删除失败");
			}
			
			
		}else if(arrayId.size()>0){
			try {
				departmentService.delete(arrayId);
				message="success";
			} catch (Exception e) {
				message="error";
				System.out.println("删除失败");
			}
			
		}
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

	public String getMessage() {
		return message;
	}


	public void setArrayId(List<Integer> arrayId) {
		this.arrayId = arrayId;
	}


}
