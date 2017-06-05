package cn.tutu.service.impl;

import cn.tutu.dao.LinkManDao;
import cn.tutu.domain.LinkMan;
import cn.tutu.service.LinkManService;
import cn.tutu.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * Created by 曹贵生 on 2017/6/3.
 * Email: 1595143088@qq.com
 */
public class LinkManServiceImpl implements LinkManService {

    private LinkManDao linkManDao;

    public void setLinkManDao(LinkManDao linkManDao) {
        this.linkManDao = linkManDao;
    }

    @Override
    public void save(LinkMan linkMan) {
        linkManDao.save(linkMan);
    }

    @Override
    public Integer getTotalCount(DetachedCriteria criteria) {
        return linkManDao.getTotalCount(criteria);
    }

    @Override
    public PageBean getPageBean(DetachedCriteria criteria, Integer currentPage, Integer pageSize) {
        Integer totalCount = linkManDao.getTotalCount(criteria);
        PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
        List<LinkMan> linkManList = linkManDao.getPageList(criteria, pageBean.getStart(), pageBean.getPageSize());
        pageBean.setList(linkManList);
        return pageBean;
    }

    /**
     * 通过id查询联系人
     * @param lkm_id
     * @return
     */
    @Override
    public LinkMan getById(Long lkm_id) {
        return linkManDao.getById(lkm_id);
    }

    /**
     * 保存或修改用户
     * @param linkMan
     */
    @Override
    public void saveOrUpdate(LinkMan linkMan) {
        linkManDao.saveOrUpdate(linkMan);
    }
}
