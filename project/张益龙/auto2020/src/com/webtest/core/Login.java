package com.webtest.core;

import java.io.IOException;

import com.webtest.utils.ReadProperties;

public class Login extends BaseTest{
	//前端登录
	public void loginFront() throws IOException, InterruptedException {
		String openFront=ReadProperties.getPropertyValue("frontUrl");
		//打开页面
		webtest.open(openFront);
		//文本框输入
		webtest.click("link=登录");
		webtest.type("name=username","13800138006");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "123");
		Thread.sleep(2000);

	}
	//后端登录
	public void loginBehind() {
		
	}
}
