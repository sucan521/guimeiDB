package cn.guimei.dao;

import cn.guimei.pojo.Page;
import cn.guimei.pojo.Superuser;

import java.util.List;

public interface SuperuserDao {
    //管理员增删改查

    int add(String sql, Superuser superuser);

    int del(String sql, Object parameter[]);

    int update(String sql, Object parameter[]);

    List<Superuser> query(String sql, Object parameter[]);

    Page<Superuser> pageQuery(int pageSize, int pageNumber, Object[] parameter);

}
