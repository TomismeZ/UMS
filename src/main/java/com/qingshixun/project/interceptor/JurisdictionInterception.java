package com.qingshixun.project.interceptor;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.qingshixun.project.model.Account;
import com.qingshixun.project.model.Jurisdiction;
import com.qingshixun.project.model.Role;

@Component(value = "jurisdictionInterceptor")
public class JurisdictionInterception implements Interceptor {
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		/**
		 * 1、获取用户能够访问到的功能权限 2、获取访问当前请求的方法中的权限 3、查看当前用户的权限是否包含当前请求方法的权限
		 * 如果包含，则继续访问 如果不包含，则跳转到错误页面
		 */
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 从session中获取user对象
		Account currentAccount = (Account) session.getAttribute("currentAccount");
		System.out.println("当前用户：" + currentAccount);

		System.out.println("访问的方法：" + invocation.getProxy().getMethod());

		// 如果有，表示已经登录，可以访问
		if (currentAccount != null) {
			Collection<Jurisdiction> jurisdictions = (Collection<Jurisdiction>) session.getAttribute("privileges");
			if (jurisdictions != null) {
				// 获取当前请求的方法
				String methodName = invocation.getProxy().getMethod();
				// 当前请求action的class形式
				Class targetClass = invocation.getAction().getClass();
				// 访问当前方法应该具有的权限
				String privilegeName = PrivilegeInfoAnnotationParse.parse(targetClass, methodName);
				// String privilegeName ="查找";
				System.out.println("privilegeName:" + privilegeName);
				// 是否通过访问
				boolean flag = false;
				if (privilegeName == null || privilegeName.equals("")) {
					flag = true; // 没有权限，获取权限为""说明任何人都可以访问
				} else if (currentAccount.getRole().getName().trim().equals("管理员")) {
					flag = true;
				} else {
					for (Jurisdiction jurisdiction : jurisdictions) {
						if (jurisdiction.getName().equalsIgnoreCase(privilegeName)) { // 用户能够访问的权限中包含有当前方法的访问权限
							flag = true;
							break;
						}
					}
				}
				if (flag) {
					return invocation.invoke();
				} else {
					ActionContext.getContext().getValueStack().push("权限不足");
					return "jurisdiction";
				}
			}
			return invocation.invoke();
		} else {
			return "login";
		}

	}

}
