package cn.tutu.service;

import cn.tutu.domain.User;
import cn.tutu.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface UserService {
	//登陆方法
	User	getUserByCodePassword(User u);
	//注册用户
	void saveUser(User u);
	// 用户是否存在
    void existUser(User user);
	// 获得用户列表pageBean
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
}
