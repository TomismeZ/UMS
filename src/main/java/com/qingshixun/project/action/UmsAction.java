package com.qingshixun.project.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class UmsAction extends ActionSupport {
	/**
	 * 加载左边菜单按钮
	 * @return
	 * @throws Exception
	 */
	@Action(value = "toLeft", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/left.jsp") })
	public String toLeft() throws Exception {
		return SUCCESS;
	}
}
