package com.mvtest.SpringSimple;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mvtest.annotation.HelloWorldAnnotation;
@Component
public class A implements base,BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean  {
	  @Resource(name="b1")  //@Autowired注解是按类型装配依赖对象
	  private B bbb;
	   //@Resource 注解默认是按 byName 自动注入，由J2EE提供
	  @HelloWorldAnnotation(name="C")
	  private C ccc;
	  private String beanName;
	  private BeanFactory bf;
	  public A() {
	    System.out.println("creating bean A: " + this);
	  }
	  @Autowired
	  public void setBbb(B bbb) {
	    System.out.println("setting A.bbb with " + bbb);
	    this.bbb = bbb;
	  }
	  public void cSay() {
		    ccc.say();
		}
	  public void setCcc(C ccc) {
	    System.out.println("setting A.ccc with " + ccc);
	    this.ccc = ccc;
	  }
	  /*
	   * (non-Javadoc)
	   * @see com.mvtest.SpringSimple.base#say()
	   */
	  
		public void say() {
			// TODO Auto-generated method stub
			bbb.say();
			ccc.say();
		}
		@HelloWorldAnnotation(name="小明")
		public String sayAnnotation(String name){
			System.out.println(name+" say hello world!");
			return name+" say hello world!";
		}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.springframework.beans.factory.BeanFactory)
	 */
		public void setBeanFactory(BeanFactory arg0) throws BeansException {
			this.bf = arg0;
			System.out.println("setBeanFactory:"+bf.getClass().getName());
		}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String)
	 */
		public void setBeanName(String arg0) {
			// TODO Auto-generated method stub
			this.beanName = arg0;
			System.out.println("setBeanNameA:"+beanName);
		}
		public String getBeanName(){
			return this.beanName;
		}
		/*
		 * 容器初始化Bean后的操作
		 */
		public void afterPropertiesSet() throws Exception {
			// TODO Auto-generated method stub
			System.out.println("afterPropertiesSet after A 1");
		}

		public void destroy() throws Exception {
			// TODO Auto-generated method stub
			System.out.println("A has been destory");
		}
		@PostConstruct
		public void start(){
			System.out.println("afterPropertiesSet after A 2");
		}
		@PostConstruct
		public void start2(){
			System.out.println("afterPropertiesSet after A 3");
		}


}
