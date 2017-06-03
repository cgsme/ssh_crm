package cn.tutu.service.impl;

import cn.tutu.dao.LinkManDao;
import cn.tutu.domain.LinkMan;
import cn.tutu.service.LinkManService;

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
}
