package com.manage.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import foooot.login.bean.Login;
import foooot.login.dao.LoginDao;
import foooot.login.dao.LoginDaoFactory;

public class LoginAction extends ActionSupport{

	private String loginid;
	private String passwd;
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String execute() throws Exception {
				//调用Mysql数据库
				LoginDao dao =LoginDaoFactory.getLoginDaoUseDB(LoginDaoFactory.MYSQL);
				
				if (true)
				{
					boolean flag=false;
					Map request = (Map) ActionContext.getContext().get("request");
			
					flag = dao.checkLogin(loginid, passwd);
					
					request.put("flag", flag);
					if (flag) {
						
						Login login = dao.queryById(loginid);
						
						request.put("persion", login);
						if(dao.checkLevel(loginid))
						return "admin";
						else return "user";
					} else {
						return "input";
					}
				}
		return "success";
	}
}