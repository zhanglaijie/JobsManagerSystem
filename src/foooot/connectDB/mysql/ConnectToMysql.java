package foooot.connectDB.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectToMysql {
	Connection con =null;
	public  Connection ConnectToMysqlDB() 
	{
		String driver = "com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/laijie";
		String user="root";
		String password="root";  
		
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url,user,password);
			if(!con.isClosed())
				System.out.println("succeeded connecting to db");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			catch(SQLException l)
			{
				l.printStackTrace();
			}
		
		return con;
	}
	public void close()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  static void main(String []args)
	{
		new ConnectToMysql().ConnectToMysqlDB();
	}
	
}
