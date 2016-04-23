package com.mvtest.SpringSimple;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
	/*
	 * @Bean 具有以下四个属性：
		  name：         指定一个或者多个 Bean 的名字。这等价于 XML 配置中 <bean> 的 name 属性。
		  initMethod：   容器在初始化完 Bean 之后，会调用该属性指定的方法。这等价于 XML 配置中 <bean> 的 init-method 属性。
		  destroyMethod：该属性与 initMethod 功能相似，在容器销毁 Bean 之前，会调用该属性指定的方法。这等价于 XML 配置中 <bean> 的 destroy-method 属性。
		  autowire：     指定 Bean 属性的自动装配策略，取值是 Autowire 类型的三个静态属性。Autowire.BY_NAME，Autowire.BY_TYPE，Autowire.NO
	 */
	@Bean(name={"b1","b2"},initMethod="sayWhenCreating",destroyMethod="sayWhenDestory",autowire=Autowire.BY_NAME)
	public B b(){ 
		System.out.println("using config to create B");
		return new B();
	}
}
