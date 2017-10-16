package com.qingshixun.project.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.opensymphony.xwork2.ActionSupport;
import com.qingshixun.project.model.Account;
import com.qingshixun.project.model.Account.Status;
import com.qingshixun.project.model.Department;
import com.qingshixun.project.model.PageBean;
import com.qingshixun.project.model.Role;
import com.qingshixun.project.service.IAccountService;
import com.qingshixun.project.service.IDepartmentService;
import com.qingshixun.project.service.IRoleService;

//使用拦截器注解时，必须引用package包name的值
@ParentPackage("web-default")
@Scope("prototype")
@Results({ @Result(name = "login", location = "/WEB-INF/views/login.jsp") })
// @Controller("accountAction")
// @Component("accountAction")
// //当使用这个注解时，下方的setter就不需要使用了,当知道分层结构之后就用@Controller
public class AccountAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private IAccountService accountService;
	private List<Department> departments;
	@Autowired
	private IDepartmentService departmentService;

	@Autowired
	private IRoleService roleService;

	private List<Role> roles;
	private Account account;
	private String departmentName;
	private String roleName;
	private List<Account> accounts;
	private int page; // 页数
	private PageBean<Account> pageBean;
	// 从页面上传入的值
	private Integer id;

	// 页面提示信息
	private String message;
	// 账户头像信息
	private File photo;
	// 使用这个时，需要setter注入以及，@Controller注解
	// private AccountAction accountAction;

	// 跳转到登录界面
	@Action(value = "toLogin")
	public String toLogin() throws Exception {
		return "login";
	}

	/**
	 * 验证登录时是否满足，ajax异步刷新
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "validateLogin", results = { @Result(name = SUCCESS, type = "json") })
	public String validateLogin() throws Exception {
		System.out.println("进入验证登录模块");
		if (account != null) {
			if (accountService.findByName(account.getUserName()) == null) {
				message = "用户名错误";

			} else {
				Account account1 = accountService.loginAccount(account.getUserName(), account.getPassword());
				if (account1 != null) {
					if (account1.getStatus().equals(Status.enable)) {
						message = "success";
					} else {
						message = "您的账户已经被禁用了";

					}

				} else {
					message = "密码输入错误，请重新选择";

				}
				/*
				 * //可以根据用户名查找用户头像，这里就不需要设置了，可以在ajax实现这部分功能 id=1;
				 */
			}

		}
		return SUCCESS;

	}

	// 点击登录要跳转的界面
	@Action(value = "loginAccount", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/main.jsp") })
	public String loginAccount() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (account != null) {
			Account account1 = accountService.loginAccount(account.getUserName(), account.getPassword());
			if (account1 != null) {
				session.setAttribute("currentAccount", account1);
				return SUCCESS;

			} else {
				return "login";
			}

		} else if (session.getAttribute("currentAccount") != null) {
			return SUCCESS;
		} else {
			return "login";
		}

	}

	/**
	 * 跳转到添加或者编辑账户界面
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "toAccount", interceptorRefs = { @InterceptorRef("myInterceptorStack") }, results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/add_account.jsp") })
	public String toAccount() throws Exception {
		if (id != null) {
			account = accountService.get(id);
		}
		System.err.println("----id:" + id);
		departments = departmentService.findAll();
		roles = roleService.findAll();

		return SUCCESS;
	}
	/**
	 * 根据标识符跳转到当前账户基本、详细、头像设置页面
	 * @return
	 * @throws Exception
	 */
	@Action(value = "baseData", interceptorRefs = { @InterceptorRef("myInterceptorStack") }, 
			results = { @Result(name = SUCCESS, location = "/WEB-INF/views/account/basic_data.jsp") })
	public String baseData() throws Exception {
		if(id==2){
			departments = departmentService.findAll();
			roles = roleService.findAll();
		}
		return SUCCESS;
	}
	/**
	 * 添加或者修改账户
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "saveAccount", interceptorRefs = { @InterceptorRef("myInterceptorStack") }, results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/accountManage.jsp") })
	public String saveAccount() throws Exception {
		System.out.println("------------  saveAccount()");

		Department department = departmentService.findByName(departmentName);
		Role role = roleService.findByName(roleName);
		if (account.getId() != null) {

			Account account2 = accountService.get(account.getId());
			if (account.getUserName() != null) {
				account2.setUserName(account.getUserName());
			} else if (account.getName() != null) {
				account2.setName(account.getName());
			} else if (account.getPassword() != null) {
				account2.setPassword(account.getPassword());
			} else if (account.getPhoneNumber() != null) {
				account2.setPhoneNumber(account.getPhoneNumber());
			}
			account2.setDepartment(department);
			account2.setRole(role);
			if (account.getName() != null || !"".equals(account.getName())) {
				account2.setName(account.getName());
			}
			account2.setGender(account.getGender());
			account2.setStatus(account.getStatus());
			accountService.saveOrUpdate(account2);

		} else {
			account.setCreateTime(new Date());
			account.setDepartment(department);
			account.setRole(role);
			accountService.save(account);
		}

		// System.out.println(account);
		return SUCCESS;
	}

	/**
	 * 编辑当前用户资料
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "editCurrentAccount", results = {
			@Result(name = SUCCESS, type="redirectAction",params={"actionName","loginAccount"}) })
	public String editCurrentAccount() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Account currentAccount = (Account) session.getAttribute("currentAccount");
		if (photo == null) {
			Department department = departmentService.findByName(departmentName);
			Role role = roleService.findByName(roleName);
			if (account.getName() != null) {
				currentAccount.setName(account.getName());
			}
			if (account.getUserName() != null) {
				currentAccount.setUserName(account.getUserName());
			} else if (account.getPassword() != null) {
				currentAccount.setPassword(account.getPassword());
			} else if (account.getPhoneNumber() != null) {
				currentAccount.setPhoneNumber(account.getPhoneNumber());
			} else if (department != null) {
				currentAccount.setDepartment(department);
			} else if (role != null) {
				currentAccount.setRole(role);
			} else if (photo != null) {
				FileInputStream fis = new FileInputStream(this.getPhoto());
				byte[] buffer = new byte[fis.available()];
				fis.read(buffer);
				currentAccount.setPhoto(buffer);
			} else if (account.getGender() != null) {
				currentAccount.setGender(account.getGender());
			} else if (account.getStatus() != null) {
				currentAccount.setStatus(account.getStatus());
			}
		} else {
			FileInputStream fis = new FileInputStream(this.getPhoto());
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			currentAccount.setPhoto(buffer);
		}
		accountService.saveOrUpdate(currentAccount);
		session.removeAttribute("currentAccount");
		session.setAttribute("currentAccount", currentAccount);
		return SUCCESS;
	}

	/**
	 * 查找所有的账户
	 * 
	 * @return
	 */
	@Action(value = "findAllAccount", interceptorRefs = { @InterceptorRef("myInterceptorStack") }, results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/accountManage.jsp") })
	public String findAllAccount() throws Exception {
		accounts = accountService.findAll();
		System.out.println(accounts);

		pageBean = accountService.getPageBean(5, page);
		return SUCCESS;
	}
	
	
	/**
	 * 删除账户
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "deleteAccount", interceptorRefs = { @InterceptorRef("myInterceptorStack") }, results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/accountManage.jsp") })
	public String deleteAccount() throws Exception {
		System.out.println("执行了删除----");
		if (id != null) {
			accountService.delete(id);
		}

		return SUCCESS;
	}

	/**
	 * 退出登录
	 * 
	 * @return
	 */
	@Action(value = "logoutAccount", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/login.jsp") })
	public String logoutAccount() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object user = session.getAttribute("currentAccount");
		if (user != null) {
			session.removeAttribute("currentAccount");
			/* session.invalidate(); */
		}
		return SUCCESS;
	}

	/**
	 * 注册账户验证或者忘记密码验证
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "validateRegister", results = { @Result(name = SUCCESS, type = "json") })
	public String validateRegister() throws Exception {

		if (account != null) {
			Account findByName = accountService.findByName(account.getUserName());
			if (id == 1) {
				if (findByName != null) {
					message = "用户名已存在";
				}else{
					account.setCreateTime(new Date());
					accountService.save(account);
					message = "您已经成功注册！等待管理员验证方可登录";
				}
				
			} else if (id == 2) {
				if(findByName!=null){
					message = "用户名正确，您的密码为："+findByName.getPassword()+"\n该用户的状态："+findByName.getStatus();
				}else{
					message="用户名不存在，请重新输入！";
				}
				
			}
		}

		return SUCCESS;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean<Account> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Account> pageBean) {
		this.pageBean = pageBean;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

}
