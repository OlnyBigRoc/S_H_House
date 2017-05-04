package cn.house.interceptor;

import java.util.Map;

import cn.house.entity.Users;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class interceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String,Object>session=invocation.getInvocationContext().getSession();
		Users users=(Users)session.get("user");
		if(users==null){
			   //终止执行，返回登录界面
			   return Action.LOGIN;
		   	}else{
			   //继续执行剩余的拦截器和Action
			return invocation.invoke();
			}
	}
}
