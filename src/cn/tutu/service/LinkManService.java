package cn.tutu.service;

import cn.tutu.domain.LinkMan;
import cn.tutu.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

/**
 * 联系人service
 *
 * Created by 曹贵生 on 2017/6/3.
 * Email: 1595143088@qq.com
 */
public interface LinkManService {
    /**
     * 保存联系人
     */
    void save(LinkMan linkMan);

    /**
     * 查询总记录数
     * @return
     * @param criteria
     */
    Integer getTotalCount(DetachedCriteria criteria);

    /**
     * 查询所有
     * @return
     * @param
     * @param criteria
     * @param pageSize
     */
    PageBean getPageBean(DetachedCriteria criteria, Integer currentPage, Integer pageSize);
}
