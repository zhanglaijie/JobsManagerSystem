package foooot.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import foooot.connectDB.mysql.ConnectToMysql;
import foooot.job.bean.JobBean;
import foooot.login.bean.Login;

public class LoginDaoUseMysql implements LoginDao {

	@Override
	public ArrayList<Login> queryAll() {
		ArrayList<Login> al =new ArrayList<Login>();
		Connection con = new ConnectToMysql().ConnectToMysqlDB();
		String sql="select * from login";
		try {
			PreparedStatement pst =con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Login lg = new Login();
				lg.setLoginid(rs.getString(1));
				lg.setPasswd(rs.getString(2));
				lg.setBirth(rs.getString(3));
				lg.setSex(rs.getInt(4));
				lg.setMail(rs.getString(5));
				lg.setTel(rs.getString(6));
				lg.setSalary(rs.getDouble(7));
				lg.setJobid(rs.getInt(8));
				al.add(lg);	
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public Login queryById(String loginid) {
		// TODO Auto-generated method stub
		Connection con = new ConnectToMysql().ConnectToMysqlDB();
		String sql="select * from login where loginid=?";
		Login lg =new Login();
		try {
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, loginid);
			ResultSet rs =pst.executeQuery();
			while(rs.next())
			{
				
				lg.setLoginid(rs.getString(1));
				lg.setPasswd(rs.getString(2));
				lg.setBirth(rs.getString(3));
				lg.setSex(rs.getInt(4));
				lg.setMail(rs.getString(5));
				lg.setTel(rs.getString(6));
				lg.setSalary(rs.getDouble(7));
				lg.setJobid(rs.getInt(8));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lg;
	}

	@Override
	public boolean insert(Login use) {
		// TODO Auto-generated method stub
		Connection con = new ConnectToMysql().ConnectToMysqlDB();
		boolean flag=false;
		String sql="insert into login values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, use.getLoginid());
			pst.setString(2, use.getPasswd());
			pst.setString(3, use.getBirth());
			pst.setInt(4, use.getSex());
			pst.setString(5, use.getMail());
			pst.setString(6, use.getTel());
			pst.setDouble(7, use.getSalary());
			pst.setInt(8, 0);
			pst.setInt(9, 1);
			if(pst.executeUpdate()==1) //executeUpdate(sql)的返回值是更新的条数
				flag=true;
			con.close();//
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean update(Login use) {
		Connection con = new ConnectToMysql().ConnectToMysqlDB();
		boolean flag=false;
		String sql="update login set passwd=?,birth=?,sex=?,mail=?,tel=? where loginid=?";
		try {
			PreparedStatement pst =con.prepareStatement(sql);
			
			pst.setString(1, use.getPasswd());
			pst.setString(2, use.getBirth());
			pst.setInt(3, use.getSex());
			pst.setString(4, use.getMail());
			pst.setString(5, use.getTel());
			pst.setString(6, use.getLoginid());
			if(pst.executeUpdate()==1) //executeUpdate(sql)的返回值是更新的条数
				flag=true;
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean delete(String loginid) {
		Connection con = new ConnectToMysql().ConnectToMysqlDB();
		boolean flag=false;
		String sql="delete from login where loginid=?";
		try {
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, loginid);
			if(pst.executeUpdate()==1) //executeUpdate(sql)的返回值是更新的条数
				flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean checkById(String loginid) {
		Connection con = new ConnectToMysql().ConnectToMysqlDB();
		boolean flag=false;
		String sql="select * from login where loginid=?";
		try {
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, loginid);
			ResultSet rs =pst.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean checkLogin(String loginid,String passwd)
	{
		Connection con = new ConnectToMysql().ConnectToMysqlDB();
		String sql="select * from login where loginid=? and passwd=?";
		boolean flag=false;
		try {
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, loginid);
			pst.setString(2, passwd);
			ResultSet rs =pst.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean checkLevel(String loginid)
	{
		Connection con = new ConnectToMysql().ConnectToMysqlDB();
		String sql="select level from login where loginid=?";
		try {
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, loginid);
			ResultSet rs =pst.executeQuery();
			if(rs.next())
			{
				if(rs.getInt(1)==1)
					return false;
				else return true;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean giveSalary(String loginid,double salary)
	{
		boolean flag = false;
		Connection con = new ConnectToMysql().ConnectToMysqlDB();
		String sql="update login set salary=? where loginid=?";
		try {
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setDouble(1, salary);
			pst.setString(2, loginid);
			if(pst.executeUpdate()==1) //executeUpdate(sql)的返回值是更新的条数
				flag=true;
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean assign(String loginid,int jobid)
	{
		boolean flag = false;
		Connection con = new ConnectToMysql().ConnectToMysqlDB();
		String sql="update login set jobId=? where loginid=?";
		try {
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setDouble(1, jobid);
			pst.setString(2, loginid);
			if(pst.executeUpdate()==1) //executeUpdate(sql)的返回值是更新的条数
				flag=true;
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	

	
	public static void main(String[] args) {
		LoginDao dao = new LoginDaoUseMysql();
//		//测试查找全部
//		ArrayList<Login> lg = new ArrayList<Login>();
//		lg = dao.queryAll();
//		Iterator<Login> lt =lg.iterator();
//		while(lt.hasNext()){
//			System.out.print(lt.next().getLoginid());
//		}
//		//测试id查找
//		Login lg = new Login();
//		lg = dao.queryById("admin");
//		System.out.println(lg.getLoginid());
//		System.out.println(lg.getPasswd());
//		System.out.println(lg.getBirth());
//		System.out.println(lg.getMail());
//		System.out.println(lg.getTel());
		
		//测试插入
//		Login lg = new Login();
//		lg.setLoginid("root4");
//		lg.setPasswd("789456");
//		lg.setBirth("19941212");
//		lg.setMail("hk@qq.com");
//		lg.setTel("110");
//		System.out.println(dao.insert(lg));
//		
		
		
		//测试更新
//		Login lg = new Login();
//		lg.setLoginid("laijie");
//		lg.setPasswd("123456789");
//		lg.setBirth("19941212");
//		lg.setMail("hk@qq.com");
//		lg.setTel("110");
//		System.out.println(dao.update(lg));
		
		//测试删除
//		System.out.println(dao.delete("admin"));
//		
//		//测试验证密码
//		System.out.println(dao.checkById("root"));
		
//		System.out.println(dao.checkLogin("root2", "laijie"));
		
//		boolean flag = dao.checkLevel("laijie");
//		System.out.println(flag);
	}

}
