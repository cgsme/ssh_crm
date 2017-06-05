package cn.tutu.service.impl;

import cn.tutu.dao.SaleVisitDao;
import cn.tutu.domain.SaleVisit;
import cn.tutu.service.SaleVisitService;
import cn.tutu.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * Created by 曹贵生 on 2017/6/5.
 * Email: 1595143088@qq.com
 */
public class SaleVisitServiceImpl implements SaleVisitService {

    private SaleVisitDao saleVisitDao;

    public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
        this.saleVisitDao = saleVisitDao;
    }

    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        Integer totalCount = saleVisitDao.getTotalCount(dc);
        PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
        List pageList = saleVisitDao.getPageList(dc, pageBean.getStart(), pageBean.getPageSize());
        pageBean.setList(pageList);
        return pageBean;
    }

    /**
     * 保存访问记录
     * @param saleVisit
     */
    @Override
    public void save(SaleVisit saleVisit) {
        saleVisitDao.saveOrUpdate(saleVisit);
    }

    /**
     * 根据id查询访问记录
     * @param visit_id
     * @return
     */
    @Override
    public SaleVisit findById(String visit_id) {
        return saleVisitDao.getById(visit_id);
    }
}
