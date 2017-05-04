package cn.house.action;

import org.apache.struts2.ServletActionContext;

import cn.house.dao.IUsersDao;
import cn.house.dao.impl.UsersDaoImpl;
import cn.house.entity.Users;

public class UsersAction {

	private String name;
	private String password;
	
	IUsersDao usersDao = new UsersDaoImpl();

	
	public String login() {
		System.out.println("login");
		Users users = new Users();
		users.setName(name);
		users.setPassword(password);
		Users user = usersDao.login(users);
		if (user != null) {
			ServletActionContext.getRequest().getSession()
					.setAttribute("user", user);
			ServletActionContext.getRequest().getSession()
			.setAttribute("loginNo", "");
			return "LoginSuccess";
		}
		ServletActionContext.getRequest().getSession()
		.setAttribute("loginNo", "用户名或密码错误");
		return "LoginError";
	}
	
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
