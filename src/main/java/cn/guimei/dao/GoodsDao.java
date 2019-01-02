package cn.guimei.dao;

import cn.guimei.pojo.Goods;
import cn.guimei.pojo.Page;

import java.util.List;


public interface GoodsDao {
    //商品增删改查

    int add(String sql, Goods goods);

    int del(String sql, Object parameter[]);

    int update(String sql, Object parameter[]);

    List<Goods> query(String sql, Object parameter[]);

    Page<Goods> pageQuery(int pageSize, int pageNumber, Object[] parameter);
}
