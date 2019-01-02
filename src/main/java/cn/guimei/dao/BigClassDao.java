package cn.guimei.dao;

import cn.guimei.pojo.BigClass;
import cn.guimei.pojo.Page;

import java.util.List;



public interface BigClassDao {
    //大分类增删改查

    int add(String sql, BigClass bigClass);

    int del(String sql, Object parameter[]);

    int update(String sql, Object parameter[]);

    List<BigClass> query(String sql, Object parameter[]);

    Page<BigClass> pageQuery(int pageSize, int pageNumber, Object[] parameter);


}
