package cn.tutu.service;

import cn.tutu.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import cn.tutu.utils.PageBean;

public interface CustomerService {
	//分页业务方法
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    void save(Customer customer);
}
