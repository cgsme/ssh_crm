package cn.tutu.dao.impl;

import cn.tutu.dao.CustomerDao;
import cn.tutu.domain.Customer;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import java.util.List;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

    /**
     * 客户行业统计分析
     *
     * @return
     */
    @Override
    public List<Object[]> count() {

        String sql = "SELECT " +
                "bd.dict_item_name, " +
                "COUNT(bd.dict_id) total " +
                "FROM " +
                "cst_customer c, " +
                "base_dict bd " +
                "WHERE " +
                "c.cust_industry = bd.dict_id " +
                "GROUP BY " +
                "bd.dict_item_name ";
        List list = getHibernateTemplate().execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException {
                SQLQuery sqlQuery = session.createSQLQuery(sql);
                return sqlQuery.list();
            }
        });
        return list;
    }
}
