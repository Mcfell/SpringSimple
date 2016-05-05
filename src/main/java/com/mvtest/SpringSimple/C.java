package com.mvtest.SpringSimple;

import org.springframework.stereotype.Component;

@Component
public class C implements base{
	public C() {
	    System.out.println("creating bean C: " + this);
	}
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("I'm C");
	}

}
