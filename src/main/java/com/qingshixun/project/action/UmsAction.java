package com.qingshixun.project.action;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.qingshixun.project.model.Account;

@ParentPackage("web-default")
@Scope("prototype")
@Results({ @Result(name = "login", location = "/WEB-INF/views/login.jsp") })
public class UmsAction extends ActionSupport {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	//从页面上传入的值，根据id标识要显示的界面
	private Integer id;
	/**
	 * 加载左边菜单按钮
	 * @return
	 * @throws Exception
	 */
	@Action(value = "toLeft", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/left.jsp") })
	public String toLeft() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 跳转到注册界面
	 * @return
	 * @throws Exception
	 */
	@Action(value = "toRegister", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/register.jsp") })
	public String toRegister() throws Exception {
		return SUCCESS;
	}
	/**
	 * 跳转到账户资料菜单列表页面
	 * @return
	 * @throws Exception
	 */
	@Action(value = "settingMenu", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/account/personal_settings_menu.jsp") })
	public String settingMenu() throws Exception {
		return SUCCESS;
	}
	
	
	/**
	 * 跳转到用户设置界面
	 * @return
	 * @throws Exception
	 */
	@Action(value = "personalSetting", interceptorRefs = { @InterceptorRef("myInterceptorStack") }, 
			results = { @Result(name = SUCCESS, location = "/WEB-INF/views/account/personal_setting.jsp") })
	public String personalSetting() throws Exception {
		return SUCCESS;
	}
	
	
	
	/**
	 * 从数据库中获得头像
	 * @return
	 * @throws Exception
	 */
	@Action(value = "getImage")
	public String getImage() throws Exception {
	logger.error("获取图片"+"getImage");
	HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		Account currentAccount = (Account) session.getAttribute("currentAccount");
		byte[]buffer=currentAccount.getPhoto();
		response.setContentType("image/jpeg");
		ServletOutputStream os=response.getOutputStream();
		if(buffer!=null&&buffer.length!=0){
			for (int i = 0; i < buffer.length; i++) {
				os.write(buffer[i]);
			}
			os.flush();
			
		}
		
		return NONE;
	}
	/**
	 * 跳转到帮助界面
	 * @return
	 * @throws Exception
	 */
	@Action(value = "toHelp",  interceptorRefs = { @InterceptorRef("myInterceptorStack") }, 
			results = { @Result(name = SUCCESS, location = "/WEB-INF/views/account/help.jsp") })
	public String toHelp() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 跳转到帮助界面
	 * @return
	 * @throws Exception
	 */
	@Action(value = "quickGetStart",  interceptorRefs = { @InterceptorRef("myInterceptorStack") }, 
			results = { @Result(name = SUCCESS, location = "/WEB-INF/views/help/quick_get_start.jsp") })
	public String quickGetStart() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 跳转到左侧菜单界面
	 * @return
	 * @throws Exception
	 */
	@Action(value = "leftContent",  interceptorRefs = { @InterceptorRef("myInterceptorStack") }, 
			results = { @Result(name = SUCCESS, location = "/WEB-INF/views/help/left_content.jsp") })
	public String leftContent() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 跳转到帮助页面右侧菜单界面
	 * @return
	 * @throws Exception
	 */
	@Action(value = "oneRightContent",  interceptorRefs = { @InterceptorRef("myInterceptorStack") }, 
			results = { @Result(name = SUCCESS, location = "/WEB-INF/views/help/one_right_content.jsp") })
	public String oneRightContent() throws Exception {
		return SUCCESS;
	}
	@Action(value = "twoRightContent",  interceptorRefs = { @InterceptorRef("myInterceptorStack") }, 
			results = { @Result(name = SUCCESS, location = "/WEB-INF/views/help/two_right_content.jsp") })
	public String twoRightContent() throws Exception {
		return SUCCESS;
	}
	@Action(value = "threeRightContent",  interceptorRefs = { @InterceptorRef("myInterceptorStack") }, 
			results = { @Result(name = SUCCESS, location = "/WEB-INF/views/help/three_right_content.jsp") })
	public String threeRightContent() throws Exception {
		return SUCCESS;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
