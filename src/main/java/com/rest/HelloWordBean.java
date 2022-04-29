package com.rest;

public class HelloWordBean {
	
	private String name;

	public HelloWordBean(String string) {
		this.name=string;
		
	}

	public String getName() {
		return name;
	}
	
	

	public void setName(String name) {
		this.name = name;
	}

//	@Override
//	public String toString() {
//		return "HelloWordBean [name=" + name + "]";
//	}
	
	
	

}
