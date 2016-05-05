package com.mvtest.SpringSimple;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mvtest.annotation.ParseAnnotationStub;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    @SuppressWarnings("resource")
	public void testSpringXMLBean(){
		ApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");
    	A  a = (A) context.getBean("a");
    	a.say();
    	a = null;
    }
    @SuppressWarnings("unchecked")
	public void testReflect(){
    	try {
			Class a1 = Class.forName("com.mvtest.SpringSimple.A");
			Class c = A.class;
			A a = new A();
			Class a3 = a.getClass();
			
			/**************获取a1所有属性*******************/
		    //获取所有的属性?
			Field[] fs = a1.getDeclaredFields();
	        //定义可变长的字符串，用来存储属性
			StringBuffer sb = new StringBuffer();
	        //通过追加的方法，将每个属性拼接到此字符串中
			//最外边的public定义
			sb.append(Modifier.toString(a1.getModifiers()) + " class " + a1.getSimpleName() +"{\n");
	        //里边的每一个属性
			for(Field field:fs){
				sb.append("\t");//空格
				sb.append(Modifier.toString(field.getModifiers())+" ");//获得属性的修饰符，例如public，static等等
				sb.append(field.getType().getSimpleName() + " ");//属性的类型的名字
				sb.append(field.getName()+";\n");//属性的名字+回车
			}
			sb.append("}");
			System.out.println(sb);
			/*******************获取特定的属性，修改类中的属性****************************/
			
			Field idF = c.getDeclaredField("beanName");  
		    //实例化这个类赋给o  
		    Object o = c.newInstance();  
		    //打破封装  
		    idF.setAccessible(true); //使用反射机制可以打破封装性，导致了java对象的属性不安全。  
		    //给o对象的id属性赋值"110"  
		    idF.set(o, "110"); //set  
		    //get  
		    System.out.println(idF.get(o)); 
			A a4 = (A) c.newInstance();
			System.out.println("a4.name:"+a4.getBeanName());
		    //A a4 = (A) a1.newInstance();
			/**********获取所有方法******************/
			Annotation ss = a1.getDeclaredAnnotation(a1);
			Method[] method = a3.getDeclaredMethods();
			for(Method m:method){
				System.out.println(m.getName());
				if(m.getName().equals("start")){
					//arg0：method 对应的对象
					//arg1:method 对应的参数
					m.invoke(a, null);
				}
			}
			
			//System.out.println(ss.annotationType().getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public void testHello() throws IllegalArgumentException,
    			IllegalAccessException, InvocationTargetException,
    			SecurityException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
    		
    		//定义操作类
    		ParseAnnotationStub parse = new ParseAnnotationStub();
    		A a = new A();
    		
    		//假设我们知道类A使用了注解，执行A中带注解的方法
    		//判断是否使用了注解的name()方法，设置name = "小明"，并返回"小明 say hello world!"
    		String returnValue = parse.parseMethod(a.getClass(),a);
    		a.cSay();
    		assertEquals("小明 say hello world!", returnValue) ;
    		
    	}
   
}
