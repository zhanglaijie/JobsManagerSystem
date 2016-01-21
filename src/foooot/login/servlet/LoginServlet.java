package foooot.login.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import foooot.job.bean.JobBean;
import foooot.job.dao.JobDao;
import foooot.login.bean.Login;
import foooot.login.dao.LoginDao;
import foooot.login.dao.LoginDaoFactory;
import foooot.login.dao.LoginDaoUseMysql;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//对用户提交的请求用utf-8来解码，否则会出现乱码
		request.setCharacterEncoding("utf-8");
		//获取用户请求的资源路径
		String actionurl = request.getServletPath();
		System.out.println(actionurl);
		//调用Mysql数据库
		LoginDao dao =LoginDaoFactory.getLoginDaoUseDB(LoginDaoFactory.MYSQL);  //登陆dao
		JobDao Jdao = new JobDao();
	 if(actionurl.equals("/check.action"))
		{
			boolean flag=false;
			String loginid = request.getParameter("loginid");
			System.out.println(loginid);
			flag = dao.checkById(loginid);
			PrintWriter out = response.getWriter();
			System.out.println(flag);
			if(flag){
				out.println("This user name already exists"); 
			}
			else{
				out.println("this is ok"); 
			}
		}
		else if(actionurl.equals("/register.action"))
		{
			boolean flag = false;
			Login lg = new Login();
			String loginid =request.getParameter("loginid");
			String passwd=request.getParameter("passwd");
			String birth=request.getParameter("birth");
			int sex=Integer.parseInt(request.getParameter("sex"));
			System.out.println(sex); 
			String mail = request.getParameter("mail");
			String tel = request.getParameter("tel");
			lg.setLoginid(loginid);
			lg.setPasswd(passwd);
			lg.setBirth(birth);
			lg.setSex(sex);
			lg.setMail(mail);
			lg.setTel(tel);
			System.out.println(lg.getBirth());
			flag = dao.insert(lg);
			System.out.println(flag);
			if(loginid.equals("")||passwd.equals(""))
			{
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('请填写账号密码');window.location.href='register.jsp'</script>");	
			}
			else  if (flag) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				Login login = dao.queryById(loginid);
				request.setAttribute("persion", login);
				request.getRequestDispatcher("/perinfo.jsp")
						.forward(request, response);
			} else if(!flag) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('注册失败，请重新填写');window.location.href='register.jsp'</script>");
			}
		}
		else if(actionurl.equals("/info.action"))
		{
			ArrayList<Login> lg = new ArrayList<Login>();
			lg = dao.queryAll();
			
			request.setAttribute("all", lg);
			request.getRequestDispatcher("/info.jsp")
					.forward(request, response);
		}
		else if(actionurl.equals("/update.action")){	
			String loginid = request.getParameter("loginid");
			System.out.println(loginid);
			Login lg = dao.queryById(loginid);

			
			request.setAttribute("login", lg);
			request.getRequestDispatcher("/update.jsp")
					.forward(request, response);
		}
		else if(actionurl.equals("/updateone.action")){	
			String loginid = request.getParameter("loginid");
			System.out.println(loginid);
			Login lg = dao.queryById(loginid);
			request.setAttribute("login", lg);
			request.getRequestDispatcher("/updateone.jsp")
					.forward(request, response);
		}
		else if(actionurl.equals("/delete.action"))
		{
			boolean flag = false;
			String loginid = request.getParameter("loginid");
			flag = dao.delete(loginid);
			if(flag)
			{
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				
					request.getRequestDispatcher("/index.jsp")
						.forward(request, response);	
			}
		}
		else if(actionurl.equals("/deleteone.action"))
		{
			boolean flag = false;
			String loginid = request.getParameter("loginid");
			flag = dao.delete(loginid);
			if(flag)
			{
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				ArrayList<Login> lg2 = new ArrayList<Login>();
				lg2 = dao.queryAll();
				request.setAttribute("all", lg2);
				request.getRequestDispatcher("/info.jsp")
						.forward(request, response);	
			}
		}
		else if(actionurl.equals("/updateok.action") )  //updateok.action
		{
			boolean flag = false;
			Login lg = new Login();
			String loginid =request.getParameter("loginid");
			String passwd=request.getParameter("passwd");
			String birth=request.getParameter("birth");
			int sex=Integer.parseInt(request.getParameter("sex"));
			String mail = request.getParameter("mail");
			String tel = request.getParameter("tel");
			lg.setLoginid(loginid);
			lg.setPasswd(passwd);
			lg.setBirth(birth);
			lg.setSex(sex);
			lg.setMail(mail);
			lg.setTel(tel);
			//System.out.println(lg.getBirth());
			flag = dao.update(lg);
			System.out.println(flag);
			if(loginid.equals("")||passwd.equals(""))
			{
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('请填写账号密码');window.location.href='register.jsp'</script>");
			}
			else  if (flag) {
				
				ArrayList<Login> lg2 = new ArrayList<Login>();
				lg2 = dao.queryAll();
				request.setAttribute("all", lg2);
				request.getRequestDispatcher("/info.jsp")
						.forward(request, response);
				
			} else if(!flag) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('修改失败，重新填写');window.location.href='update.jsp'</script>");
			}
		}
		else if(actionurl.equals("/updateokone.action") )  //updateok.action
		{
			boolean flag = false;
			Login lg = new Login();
			String loginid =request.getParameter("loginid");
			String passwd=request.getParameter("passwd");
			String birth=request.getParameter("birth");
			int sex=Integer.parseInt(request.getParameter("sex"));
			String mail = request.getParameter("mail");
			String tel = request.getParameter("tel");
			lg.setLoginid(loginid);
			lg.setPasswd(passwd);
			lg.setBirth(birth);
			lg.setSex(sex);
			lg.setMail(mail);
			lg.setTel(tel);
			//System.out.println(lg.getBirth());
			flag = dao.update(lg);
			System.out.println(flag);
			if(loginid.equals("")||passwd.equals(""))
			{
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('请填写账号密码');window.location.href='register.jsp'</script>");
			}
			else  if (flag) {
					Login lg2 = new Login();
					lg2 =dao.queryById(loginid);
					request.setAttribute("persion", lg2); // 
					request.getRequestDispatcher("/perinfo.jsp")
							.forward(request, response);
				
			} else if(!flag) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('修改失败，重新填写');window.location.href='update.jsp'</script>");
			}
		}
	 
		else if(actionurl.equals("/select.action"))//select.action
		{
			String loginid = request.getParameter("loginid");
			Login lg = new Login();
			lg = dao.queryById(loginid);
			System.out.println(lg.getBirth());
			ArrayList<Login> lg2 = new ArrayList<Login>();
			lg2.add(lg);
			request.setAttribute("all", lg2);
			request.getRequestDispatcher("/info.jsp")
					.forward(request, response);
			
		}
		else if(actionurl.equals("/give.action"))
		{
			String loginid = request.getParameter("loginid");
			request.setAttribute("loginid", loginid);
			request.getRequestDispatcher("/job/give.jsp")
					.forward(request, response);
		}
		else if(actionurl.equals("/giveok.action"))
		{
			String loginid = request.getParameter("loginid");
			double salary = Double.parseDouble(request.getParameter("salary"));
			dao.giveSalary(loginid,salary);
			ArrayList<Login> lg2 = new ArrayList<Login>();
			lg2 = dao.queryAll();
			request.setAttribute("all", lg2);
			request.getRequestDispatcher("/info.jsp")
					.forward(request, response);
		}
	 //get.action
		else if(actionurl.equals("/get.action"))  //领取工资
		{
			String loginid = request.getParameter("loginid");
			dao.giveSalary(loginid,0);
			Login login = dao.queryById(loginid);
			request.setAttribute("persion", login);
			request.getRequestDispatcher("/perinfo.jsp")
					.forward(request, response);
		}
	 //assign.action 任命职务
		else if(actionurl.equals("/assign.action"))  
		{
			ArrayList<Login> lg2 = new ArrayList<Login>();
			lg2 = dao.queryAll();
			request.setAttribute("persion", lg2);
			ArrayList<JobBean> jb = new ArrayList<JobBean>();
			jb =Jdao.queryAllJob();
			request.setAttribute("job", jb);
			request.getRequestDispatcher("/job/assign.jsp")
					.forward(request, response);
		}
		else if(actionurl.equals("/assignok.action"))  
		{	
			boolean flag = false;
			String loginid = request.getParameter("loginselect"); 
			System.out.println(loginid);
			int jobid = Integer.parseInt(request.getParameter("jobselect"));
			System.out.println(jobid);
			flag = dao.assign(loginid, jobid);
			System.out.println(flag);
			if(dao.assign(loginid, jobid))
			{
				ArrayList<Login> lg2 = new ArrayList<Login>();
				lg2 = dao.queryAll();
				request.setAttribute("all", lg2);
				request.getRequestDispatcher("/info.jsp")
						.forward(request, response);
			}
			
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}
	

}
