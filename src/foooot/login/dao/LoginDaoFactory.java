package foooot.login.dao;

public class LoginDaoFactory {
	public static final int MYSQL=0;
	public LoginDaoFactory() {}
	public static LoginDao getLoginDaoUseDB(int type)
	{
		if(type==MYSQL)
		{
			return new LoginDaoUseMysql();
		}
		else return null;
	}	
}
