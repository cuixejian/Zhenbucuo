package com.webtest.demo;

public class Test1 {
	public String name;
	public String result;
	public Test1 (String name,String result) {
		super();
		this.name=name;
		this.result=result;
	}
	public  Test1() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result=result;
	}
	
}
