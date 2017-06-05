package cn.tutu.web.action;

import cn.tutu.domain.SaleVisit;
import cn.tutu.domain.User;
import cn.tutu.service.SaleVisitService;
import cn.tutu.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created by 曹贵生 on 2017/6/5.
 * Email: 1595143088@qq.com
 */
public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {

    private SaleVisit saleVisit = new SaleVisit();
    private SaleVisitService saleVisitService;
    private Integer currentPage;
    private Integer pageSize;

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

    public void setSaleVisitService(SaleVisitService saleVisitService) {
        this.saleVisitService = saleVisitService;
    }

    /**
     * 添加访问
     *
     * @return
     * @throws Exception
     */
    public String add() throws Exception {
        if ("".equals(saleVisit.getVisit_id())) {
            saleVisit.setVisit_id(null);
            System.out.println("id为空串");
        }
        try {
            User user = (User) ActionContext.getContext().getSession().get("user");
            saleVisit.setUser(user);
            saleVisitService.save(saleVisit);
            return "toList";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 所有访问记录
     * @return
     * @throws Exception
     */
    public String list() throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
        // 添加查询条件
        if (saleVisit.getCustomer() != null && saleVisit.getCustomer().getCust_id() != null) {
            dc.add(Restrictions.eq("customer.cust_id", saleVisit.getCustomer().getCust_id()));
        }
        // 调用service
        PageBean pageBean = saleVisitService.getPageBean(dc, currentPage, pageSize);
        ActionContext.getContext().put("pageBean", pageBean);
        return "list";
    }

    /**
     * 修改访问记录
     * @return
     * @throws Exception
     */
    public String toEdit() throws Exception {
        saleVisit = saleVisitService.findById(saleVisit.getVisit_id());
        ActionContext.getContext().put("saleVisit", saleVisit);
        return "add";
    }

    @Override
    public SaleVisit getModel() {
        return saleVisit;
    }
}
