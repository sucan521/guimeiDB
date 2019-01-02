package cn.guimei.service;

import cn.guimei.pojo.Page;
import cn.guimei.pojo.Superuser;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: SuperuserServiceDao
 * @Auther: machunqi
 * @Date: 2018-12-29 13:17
 * @Description: 管理员ServiceDao
 * @Version 1.0
 */

public interface SuperuserServiceDao {

    //登录

    Superuser suLogin(String userLoginName, String userPassword);

    //分页查询所有

    Page<Superuser> suPageQueryAll(int pageNumber, int pageSize);

    //级联查询

    List<Superuser> suUnionQuery(String id, String userName, String userSex);

    //根据id查询

    Superuser suQueryById(String id);


   //增删改

    int suAdd(Superuser superuser);

    int suDelById(String id);

    int suUpdateById(Superuser superuser);


}
