package cn.tutu.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.tutu.domain.Customer;
import cn.tutu.service.CustomerService;
import cn.tutu.utils.PageBean;

import java.util.List;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();
	private CustomerService cs;
	private Integer currentPage;
	private Integer pageSize;

	// 查询所有客户
	public String list() {

			//封装离线查询对象
			DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
			//判断筛选条件中的客户名称是否为空，并封装参数
			if(StringUtils.isNotBlank(customer.getCust_name())){   // 搜索条件不为空

				// 往离线查询对象中添加查询条件（模糊查询）
				dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
			}
			//1 调用Service查询分页数据(PageBean)
			PageBean pb = cs.getPageBean(dc, currentPage, pageSize);
			System.out.println("currentPage:" + currentPage + ",pageSize:" +pageSize);
			//2 将PageBean放入request域,转发到列表页面显示
			ActionContext.getContext().put("pageBean", pb);
			return "list";
	}

	/*
		添加客户
	 */
	public String saveOrUpdate() throws Exception {
		cs.saveOrUpdate(customer);
		return "toList";
	}

	/**
	 * 修改用户页面
	 * @return
	 * @throws Exception
	 */
	public String toEdit() throws Exception {
		Customer cust = cs.findByCustId(customer.getCust_id());
		ActionContext.getContext().put("customer", cust);
		return "toEdit";
	}

	// 模型驱动的set方法
	@Override
	public Customer getModel() {
		return customer;
	}

	public void setCs(CustomerService cs) {
		this.cs = cs;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	
	
}
