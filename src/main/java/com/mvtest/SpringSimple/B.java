package com.mvtest.SpringSimple;

import org.springframework.stereotype.Component;



public class B implements base {
	public B() {
	    System.out.println("creating bean B: " + this);
	  }
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("I'm B");
	}
	
	public void sayWhenCreating() {
		// TODO Auto-generated method stub
		System.out.println("I'm B created");
	}
	public void sayWhenDestory(){
		System.out.println("I'm B destoryed");
	}

}
