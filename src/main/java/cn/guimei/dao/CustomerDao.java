package cn.guimei.dao;

import cn.guimei.pojo.Customer;
import cn.guimei.pojo.Page;

import java.util.List;


public interface CustomerDao {
    //顾客增删改查

    int add(String sql, Customer customer);

    int del(String sql, Object parameter[]);

    int update(String sql, Object parameter[]);

    List<Customer> query(String sql, Object parameter[]);

    Page<Customer> pageQuery(int pageSize, int pageNumber, Object[] parameter);

}
