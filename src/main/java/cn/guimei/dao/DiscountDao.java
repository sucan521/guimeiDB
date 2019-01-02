package cn.guimei.dao;

import cn.guimei.pojo.Discount;
import cn.guimei.pojo.Page;

import java.util.List;


public interface DiscountDao {
    //折扣增删改查

    int add(String sql, Discount discount);

    int del(String sql, Object parameter[]);

    int update(String sql, Object parameter[]);

    List<Discount> query(String sql, Object parameter[]);

    Page<Discount> pageQuery(int pageSize, int pageNumber, Object[] parameter);
}
