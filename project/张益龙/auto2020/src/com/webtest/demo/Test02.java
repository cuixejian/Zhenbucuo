package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.annotation.WebListener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.utils.JavaMailTestListener;
@Listeners(JavaMailTestListener.class)
public class Test02{
	@Test
	public void test01() {
		System.out.println("这是一个测试******************HELLO11111111111111111111111************");

		Assert.assertEquals(2, 2);
	}
	
	@Test
	public void test02() {
	
		Assert.assertEquals(1,2);
	}
	
	@Test
	public void test03() {

		Assert.assertEquals(2, 2);
	}

}
