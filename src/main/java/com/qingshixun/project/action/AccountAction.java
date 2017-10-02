package com.qingshixun.project.action;

import java.util.Date;
import java.util.List;
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
	// 使用这个时，需要setter注入以及，@Controller注解
	// private AccountAction accountAction;

	// 跳转到登录界面
	@Action(value = "toLogin")
	public String toLogin() throws Exception {
		return "login";
	}

	/**
	 * 验证用户名是否存在，ajax异步刷新
	 * @return
	 * @throws Exception
	 */
	@Action(value = "findByName", results = { @Result(name = SUCCESS, type = "json") })
	public String findByName() throws Exception {

		if (account != null) {
			Account findByName = accountService.findByName(account.getUserName());
			if (findByName == null) {
				message = "用户名不存在";
				return SUCCESS;
			}
		}
		return "login";
	}


		
	// 点击登录要跳转的界面
	@Action(value = "loginAccount", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/main.jsp") })
	public String loginAccount() throws Exception {
		Account account1 = new Account();
		if (account != null) {
			account1 = accountService.loginAccount(account.getUserName(), account.getPassword());
		}

		if (account1 != null) {
			if (account1.getStatus().equals(Status.enable)) {
				ServletActionContext.getRequest().getSession().setAttribute("currentAccount", account1);
				return SUCCESS;
			} else {
				return "login";
			}

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
		System.err.println("----id:"+id);
		departments = departmentService.findAll();
		roles = roleService.findAll();

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
		Account account2 = new Account();
		
		if (account.getId() != null) {
			account2 = accountService.get(account.getId());

		}
		account2.setCreateTime(new Date());
		account2.setUserName(account.getUserName());
		account2.setPassword(account.getPassword());
		account2.setName(account.getName());
		account2.setPhoneNumber(account.getPhoneNumber());
		account2.setGender(account.getGender());
		account2.setStatus(account.getStatus());
		Department department = departmentService.findByName(departmentName);
		Role role = roleService.findByName(roleName);
		account2.setDepartment(department);
		account2.setRole(role);
		accountService.saveOrUpdate(account2);
		// System.out.println(account);
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
	// public void setDepartments(List<Department> departments) {
	// this.departments = departments;
	// }

	// public String getDepartmentName() {
	// return departmentName;
	// }

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Role> getRoles() {
		return roles;
	}

	// public String getRoleName() {
	// return roleName;
	// }

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

	// public void setRoles(List<Role> roles) {
	// this.roles = roles;
	// }

	// public AccountAction getAccountAction() {
	// return accountAction;
	// }
	//
	// public void setAccountAction(AccountAction accountAction) {
	// this.accountAction = accountAction;
	// }

}
