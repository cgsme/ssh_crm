package cn.tutu.service.impl;

import cn.tutu.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.tutu.dao.UserDao;
import cn.tutu.domain.User;
import cn.tutu.service.UserService;

import java.util.List;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService{
	
	private UserDao ud;
	
	@Override
	public User getUserByCodePassword(User u) {
			//1 根据登陆名称查询登陆用户
			User existU = ud.getByUserCode(u.getUser_code());
			//2 判断用户是否存在.不存在=>抛出异常,提示用户名不存在
			if(existU==null){
				throw new RuntimeException("用户名不存在!");
			}
			//3 判断用户密码是否正确=>不正确=>抛出异常,提示密码错误
			if(!existU.getUser_password().equals(u.getUser_password())){
				throw new RuntimeException("密码错误!");
			}
			//4 返回查询到的用户对象
		
		return existU;
	}

	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(User u) {
		ud.save(u);
	}

    @Override
    public void existUser(User user) {
		User existUser = ud.getByUserCode(user.getUser_code());
		if (existUser != null) {
			throw new RuntimeException("用户名已经存在！！");
		}
	}

	/**
	 * 获得用户分页对象
	 * @param dc
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// 获得总记录数
		Integer totalCount = ud.getTotalCount(dc);
		// 创建pageBean对象
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		// 获得数据集合
		List<User> pageList = ud.getPageList(dc, pageBean.getStart(), pageBean.getPageSize());
		// 集合封装到pageBean中
		pageBean.setList(pageList);
		// 返回pageBean
		return pageBean;
    }

    public void setUd(UserDao ud) {
		this.ud = ud;
	}

}
