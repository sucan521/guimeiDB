package cn.guimei.dao;

import cn.guimei.pojo.Page;
import cn.guimei.pojo.SmallClass;

import java.util.List;


public interface SmallClassDao {
    //大分类增删改查

    int add(String sql, SmallClass smallClass);

    int del(String sql, Object parameter[]);

    int update(String sql, Object parameter[]);

    List<SmallClass> query(String sql, Object parameter[]);

    Page<SmallClass> pageQuery(int pageSize, int pageNumber, Object[] parameter);

}
