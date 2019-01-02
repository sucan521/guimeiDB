package cn.guimei.dao;

import cn.guimei.pojo.Orderse;
import cn.guimei.pojo.Page;

import java.util.List;


public interface OrderseDao {
    //商品增删改查

    int add(String sql, Orderse orderse);

    int del(String sql, Object parameter[]);

    int update(String sql, Object parameter[]);

    List<Orderse> query(String sql, Object parameter[]);

    Page<Orderse> pageQuery(int pageSize, int pageNumber, Object[] parameter);
}
