package cn.house.action;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.house.dao.IUsersDao;
import cn.house.dao.impl.UsersDaoImpl;
import cn.house.entity.Users;

public class UsersAction {

	private String name;
	private String password;
	
	IUsersDao usersDao = new UsersDaoImpl();

	public String outLogin(){
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return "LoginSuccess";
	}
	//检查用户名是否可用
	public String checkName() throws IOException{
		
		boolean isRight=usersDao.checkName(name);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/text;charset=utf-8");
		PrintWriter out= response.getWriter();
		System.out.println(isRight);
		out.print(isRight);
		return null;
	}
	//登录
	public String login() {
		System.out.println("login");
		Users users = new Users();
		users.setName(name);
		users.setPassword(password);
		System.out.println("login()");
		Users user = usersDao.login(users);
		if (user != null) {
			System.out.println("user != null");
			ServletActionContext.getRequest().getSession()
					.setAttribute("user", user);
			ServletActionContext.getRequest().getSession()
			.setAttribute("loginNo", "");
			System.out.println("登录成功");
			return "LoginSuccess";
		}
		System.out.println("user == null");
		ServletActionContext.getRequest().getSession()
		.setAttribute("loginNo", "用户名或密码错误");
		return "LoginError";
	}
	//注册
	public String insert(){
		System.out.println("insert");
		Users users = new Users();
		users.setName(name);
		users.setPassword(password);
		if(usersDao.insert(users)){
			return "InsertSuccess";
		}
		return "InsertError";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
