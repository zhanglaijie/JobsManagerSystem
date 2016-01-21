package foooot.job.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import foooot.job.bean.JobBean;
import foooot.job.dao.JobDao;
import foooot.login.bean.Login;
import foooot.login.dao.LoginDao;
import foooot.login.dao.LoginDaoFactory;

public class Jobservlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Jobservlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//对用户提交的请求用utf-8来解码，否则会出现乱码
		request.setCharacterEncoding("utf-8");
		//获取用户请求的资源路径
		String actionurl = request.getServletPath();
		System.out.println(actionurl);
		
		//调用Mysql数据库
		JobDao dao =new JobDao();
		if (actionurl.equals("/showjob.job"))
		{
			ArrayList<JobBean> al = new ArrayList<JobBean>();
			al = dao.queryAllJob();
			//System.out.println(al+"a");
			request.setAttribute("alljob", al);
			request.getRequestDispatcher("/job/showjob.jsp")
					.forward(request, response);
		}
		//update.job
		if (actionurl.equals("/update.job"))
		{
			boolean flag = false;
			JobBean bean = new JobBean();
			int jobid =Integer.parseInt(request.getParameter("jobid"));
			String jobtitle=request.getParameter("jobtitle");
			double maxsalary=Double.parseDouble(request.getParameter("maxsalary"));
			double minsalary=Double.parseDouble(request.getParameter("minsalary"));
			bean.setJobId(jobid);
			bean.setJobTitle(jobtitle);
			bean.setMaxSalary(maxsalary);
			bean.setMinSalary(minsalary);
			//System.out.println(lg.getBirth());
			flag = dao.updateJob(bean);
			System.out.println(flag);
			if (flag) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				
				out.print("<script>alert('修改成功');</script>");
				ArrayList<JobBean> bean2 = dao.queryAllJob();
				request.setAttribute("alljob", bean2);
				request.getRequestDispatcher("/job/showjob.jsp")
						.forward(request, response);
			} else if(!flag) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('修改失败，重新填写');window.location.href='update.jsp'</script>");
			}
		}
		//delete.job
		else if (actionurl.equals("/delete.job"))
		{	boolean flag = false;
			int jobid =Integer.parseInt(request.getParameter("jobid"));
			JobBean bean = new JobBean();
			bean.setJobId(jobid);
			flag = dao.deleteJob(bean);
			ArrayList<JobBean> bean2 = dao.queryAllJob();
			request.setAttribute("alljob", bean2);
			request.getRequestDispatcher("/job/showjob.jsp")
					.forward(request, response);
		}
		else if(actionurl.equals("/insert.job")) //
		{
			boolean flag = false;
			JobBean bean = new JobBean();
			int jobid =Integer.parseInt(request.getParameter("jobid"));
			String jobtitle=request.getParameter("jobtitle");
			double maxsalary=Double.parseDouble(request.getParameter("maxsalary"));
			double minsalary=Double.parseDouble(request.getParameter("minsalary"));
			bean.setJobId(jobid);
			bean.setJobTitle(jobtitle);
			bean.setMaxSalary(maxsalary);
			bean.setMinSalary(minsalary);
			System.out.println(bean.getJobId());
			flag = dao.addJob(bean);
			if (flag) {
				ArrayList<JobBean> bean2 = dao.queryAllJob();
				request.setAttribute("alljob", bean2);
				request.getRequestDispatcher("/job/showjob.jsp")
						.forward(request, response);
			}
		}
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
