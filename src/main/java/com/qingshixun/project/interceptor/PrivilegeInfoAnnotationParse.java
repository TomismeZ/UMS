package com.qingshixun.project.interceptor;

import java.lang.reflect.Method;

/**
 * 自定义注解内容的工具类
 * @author Administrator
 *
 */
public class PrivilegeInfoAnnotationParse {
	public static String parse(Class<PrivilegeInfo> targetClass,String methodName) throws NoSuchMethodException,SecurityException{
		String privilegeName = "";
		Method method = targetClass.getMethod(methodName, null);
		if(method.isAnnotationPresent( PrivilegeInfo.class)){
			PrivilegeInfo privilegeInfo=method.getAnnotation(PrivilegeInfo.class);
			privilegeName=privilegeInfo.name();
		}
		return privilegeName;
	}
}
