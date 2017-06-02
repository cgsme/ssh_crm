package cn.tutu.dao.impl;

import cn.tutu.dao.BaseDictDao;
import cn.tutu.domain.BaseDict;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by 曹贵生 on 2017/6/2.
 * Email: 1595143088@qq.com
 */
public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {

    @Override
    public List<BaseDict> findDictByTypeCode(String typeCode) {
        // 创建离线查询对象
        DetachedCriteria criteria = DetachedCriteria.forClass(BaseDict.class);
        // 封装条件
        criteria.add(Restrictions.eq("dict_type_code", typeCode));
        // 执行查询并放回
        return (List<BaseDict>) getHibernateTemplate().findByCriteria(criteria);
    }
}
