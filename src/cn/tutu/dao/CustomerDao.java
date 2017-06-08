package cn.tutu.dao;

import cn.tutu.domain.Customer;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer> {


    List count();
}
