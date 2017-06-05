package cn.tutu.web.action;

import cn.tutu.domain.LinkMan;
import cn.tutu.service.LinkManService;
import cn.tutu.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * 联系人action
 *
 * Created by 曹贵生 on 2017/6/3.
 * Email: 1595143088@qq.com
 */
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

    private LinkMan linkMan = new LinkMan();
    private LinkManService linkManService;
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

    public void setLinkManService(LinkManService linkManService) {
        this.linkManService = linkManService;
    }

    /**
     * 添加联系人
     * @return
     * @throws Exception
     */
    public String add() throws Exception {
        linkManService.saveOrUpdate(linkMan);
        return "toList";
    }

    /**
     * 查询所有联系人
     * @return
     * @throws Exception
     */
    public String list() throws Exception {

        DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
        if (linkMan.getLkm_name() != null && !"".equals(linkMan.getLkm_name())) {
            criteria.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
        }
        if (linkMan.getCustomer() != null && linkMan.getCustomer().getCust_id() != null) {
            criteria.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
        }
        PageBean pageBean = linkManService.getPageBean(criteria, currentPage, pageSize);
        ActionContext.getContext().put("pageBean", pageBean);
        return "list";
    }

    /**
     * 修改联系人
     * @return
     * @throws Exception
     */
    public String toEdit() throws Exception {
        linkMan = linkManService.getById(linkMan.getLkm_id());
        ActionContext.getContext().put("linkMan", linkMan);
        return "toEdit";
    }

    @Override
    public LinkMan getModel() {
        return linkMan;
    }
}
