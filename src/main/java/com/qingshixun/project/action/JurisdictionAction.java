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
import com.qingshixun.project.model.Jurisdiction;
import com.qingshixun.project.model.PageBean;

import com.qingshixun.project.service.IJurisdictionService;

@ParentPackage("web-default")
@Scope("prototype")
@Results({ @Result(name = "login", location = "/WEB-INF/views/login.jsp") })
public class JurisdictionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IJurisdictionService jurisdictionService;

	private Jurisdiction jurisdiction;
	
	// 用户显示在页面上集合
	private PageBean<Jurisdiction> pageBean;
	//从页面上得到page
	private int page;
	//从页面得到ID的值，用于查找，编辑以及删除
	private Integer id;
	/**
	 * 跳转到添加或者编辑权限界面
	 * @return
	 * @throws Exception
	 */
	@Action(value = "toJurisdiction",interceptorRefs = { @InterceptorRef("myInterceptorStack") }, 
			results = { @Result(name = SUCCESS, location = "/WEB-INF/views/add_jurisdiction.jsp") })
	public String toJurisdiction() throws Exception {
		
		if(id!=null){
			jurisdiction=jurisdictionService.get(id);
			
		}
		System.out.println("id:"+id);
		return SUCCESS;
	}
	
	/**
	 * 保存或者修改权限信息
	 * @return
	 * @throws Exception
	 */
	@Action(value = "saveJurisdiction",interceptorRefs = { @InterceptorRef("myInterceptorStack") }, 
			results = { @Result(name = SUCCESS, location = "/WEB-INF/views/jurisdictionManage.jsp") })
	public String saveJurisdiction() throws Exception {
		System.out.println("进入到saveJurisdiction方法");
		Jurisdiction jurisdiction2=new Jurisdiction();
		if(id!=null){
			jurisdiction2=jurisdictionService.get(id);
			System.out.println("jurisdiction:"+jurisdiction2);
		}
		jurisdiction2.setCreateTime(new Date());
		jurisdiction2.setName(jurisdiction.getName());
		jurisdiction2.setDescription(jurisdiction.getDescription());
		jurisdictionService.saveOrUpdate(jurisdiction2);
					
			return SUCCESS;
		
	}
	

	/**
	 * 显示权限列表信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "findAllJurisdiction", interceptorRefs = { @InterceptorRef("myInterceptorStack") }, results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/jurisdictionManage.jsp") })
	public String findAllJurisdiction() throws Exception {
		pageBean = jurisdictionService.getPageBean(5, page);
		System.out.println(pageBean);
		return SUCCESS;
	}
	
	/**
	 * 根据id删除权限信息
	 * @return
	 * @throws Exception
	 */
	@Action(value = "deleteJurisdiction",interceptorRefs = { @InterceptorRef("myInterceptorStack") }, 
			results = { @Result(name = SUCCESS, location = "/WEB-INF/views/jurisdictionManage.jsp") })
	public String deleteJurisdiction() throws Exception {
		System.out.println("执行了删除");
		if(id!=null){
			jurisdictionService.delete(id);
		}
		System.out.println("id:"+id);
		return SUCCESS;
	}
	public Jurisdiction getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(Jurisdiction jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	

	public PageBean<Jurisdiction> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Jurisdiction> pageBean) {
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
