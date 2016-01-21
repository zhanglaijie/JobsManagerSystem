package foooot.login.dao;

import java.util.ArrayList;

import foooot.login.bean.Login;

public interface LoginDao {
	public ArrayList<Login> queryAll();  //查找所有用户
	public Login queryById(String loginid);	//用户名查找
	public boolean insert(Login use);   //插入用户
	public boolean update(Login use);	//修改用户
	public boolean delete(String loginid);  //删除用户
	public boolean checkById(String loginid);  //检查用户名
	public boolean checkLogin(String loginid, String passwd);  //登陆检查
	public boolean checkLevel(String loginid); //权限检测
	public boolean giveSalary(String loginid,double salary);  //分发工资
	public boolean assign(String loginid,int jobid);  //职务分发
}
