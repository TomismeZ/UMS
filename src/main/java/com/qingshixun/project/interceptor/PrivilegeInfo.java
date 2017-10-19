package com.qingshixun.project.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义一个注解，用来标识给方法来标识访问此方法应该具有什么权限
 * @author Administrator
 *
 */
@Target(ElementType.METHOD) //注解作用的位置，方法
@Retention(RetentionPolicy.RUNTIME) //注解的生命周期
public @interface PrivilegeInfo {
	String name() default "";
}
