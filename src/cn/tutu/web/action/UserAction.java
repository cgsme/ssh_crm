package cn.tutu.web.action;

import cn.tutu.utils.MD5Utils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.tutu.domain.User;
import cn.tutu.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	
	private UserService userService ;
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception {
			//1 调用Service执行登陆逻辑
			user.setUser_password(MD5Utils.md5(user.getUser_password()));
			User u = userService.getUserByCodePassword(user);

			//2 将返回的User对象放入session域
			ActionContext.getContext().getSession().put("user", u);
			//3 重定向到项目首页
			return "toHome";
	}

	/**
	 * 用户注册
	 * @return
	 * @throws Exception
	 */
	public String register() throws Exception{

		try {
			userService.existUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "register";
		}
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		userService.saveUser(user);
		return "toLogin";
	}

    /**
     * 退出系统
     * @return
     * @throws Exception
     */
    public String logout() throws Exception{
        ActionContext.getContext().getSession().remove("user");
        return "toLogin";
    }

	@Override
	public User getModel() {
		return user;
	}

	
	
}
