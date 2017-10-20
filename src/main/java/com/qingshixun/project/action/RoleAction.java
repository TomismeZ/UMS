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
import com.qingshixun.project.model.Jurisdiction;
import com.qingshixun.project.model.PageBean;
import com.qingshixun.project.model.Role;
import com.qingshixun.project.service.IJurisdictionService;
import com.qingshixun.project.service.IRoleService;

@ParentPackage("web-default")
@Scope("prototype")
@Results({ @Result(name = "login", location = "/WEB-INF/views/login.jsp"),
	@Result(name = "jurisdiction", location = "/WEB-INF/views/jurisdiction/jurisdiction_interceptor.jsp"),
})
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

	private List<Jurisdiction> jurisdictions;
	// 用户显示在页面上集合
	private PageBean<Role> pageBean;
	// 分页的页数
	private int page;
	//从页面上传入的值
	private Integer id;
	
	//用于显示在页面上的提示信息
	private String message;

	private List<Integer> arrayId;
	/**
	 * 跳转到添加或者编辑角色页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "toRole",  interceptorRefs = { @InterceptorRef("myInterceptorStack") },
			results = { @Result(name = SUCCESS, location = "/WEB-INF/views/add_role.jsp") })
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
	@Action(value = "saveRole", interceptorRefs = { @InterceptorRef("myInterceptorStack"),@InterceptorRef("jurisdictionInterceptor") },
			results = { @Result(name = SUCCESS,type="json") })
	@PrivilegeInfo(name="保存")
	public String saveRole() throws Exception {	
			roleService.saveOrUpdate(role);
			message="success";						
		return SUCCESS;
	}

	/**
	 * 编辑角色信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "editRole", interceptorRefs = { @InterceptorRef("myInterceptorStack"),@InterceptorRef("jurisdictionInterceptor") },
			results = { @Result(name = SUCCESS,type="json") })
	@PrivilegeInfo(name="编辑")
	public String editRole() throws Exception {
		roleService.saveOrUpdate(role);	
		message="success";
		return SUCCESS;
	}
	/**
	 * 显示角色列表信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "findAllRole", interceptorRefs = { @InterceptorRef("myInterceptorStack"),@InterceptorRef("jurisdictionInterceptor")  },
			results = {@Result(name = SUCCESS, location = "/WEB-INF/views/roleManage.jsp") })
	@PrivilegeInfo(name="查找")
	public String findAllRole() throws Exception {
		pageBean = roleService.getPageBean(5, page);
		return SUCCESS;
	}


	
	/**
	 * 删除角色
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "deleteRole", interceptorRefs = { @InterceptorRef("myInterceptorStack"),@InterceptorRef("jurisdictionInterceptor")  }, 
			results = {@Result(name = SUCCESS,type="json") })
	@PrivilegeInfo(name="删除")
	public String deleteRole() throws Exception {
		System.out.println("执行了删除----"+id);
		if (id != null) {
			roleService.delete(id);
			message="success";
		}else if(arrayId.size()>0){
			roleService.delete(arrayId);
			message="success";
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setArrayId(List<Integer> arrayId) {
		this.arrayId = arrayId;
	}

	

}
