package cn.tutu.service;

import cn.tutu.domain.SaleVisit;
import cn.tutu.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

/**
 * Created by 曹贵生 on 2017/6/5.
 * Email: 1595143088@qq.com
 */
public interface SaleVisitService {
    // 获得PageBean
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    // 保存访问记录
    void save(SaleVisit saleVisit);

    SaleVisit findById(String visit_id);
}
