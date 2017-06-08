package cn.tutu.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.tutu.dao.CustomerDao;
import cn.tutu.domain.Customer;
import cn.tutu.service.CustomerService;
import cn.tutu.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao cd;
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {

		//1 调用Dao查询总记录数
		Integer totalCount = cd.getTotalCount(dc);
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3 调用Dao查询分页列表数据
		
		List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);
		return pb;
	}

	@Override
	public void save(Customer customer) {
		cd.save(customer);
	}

	@Override
	public void saveOrUpdate(Customer customer) {
		cd.saveOrUpdate(customer);
	}

	@Override
	public Customer findByCustId(Long cust_id) {
		return cd.getById(cust_id);
	}

	/**
	 * 客户行业统计分析
	 * @return
	 */
    @Override
    public List<Object[]> count() {
        return cd.count();
    }

    public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

}
