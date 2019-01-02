package cn.guimei.service.impl;

import cn.guimei.dao.impl.SuperuserImplDao;
import cn.guimei.pojo.Page;
import cn.guimei.pojo.Superuser;
import cn.guimei.service.SuperuserServiceDao;

import java.util.List;



public class SuperuserServiceImplDao implements SuperuserServiceDao {
    private static SuperuserServiceImplDao ourInstance = new SuperuserServiceImplDao();

    public static SuperuserServiceImplDao getInstance() {
        return ourInstance;
    }

    private SuperuserServiceImplDao() {
    }

    //获取SuperuserImplDao对象
    private SuperuserImplDao superuserImplDao = SuperuserImplDao.getInstance();


    @Override
    public Superuser suLogin(String userLoginName, String userPassword) {
        String sql = "select * from superuser where userLoginName = ? and userPassword = ?";
        Object []parameter = {userLoginName,userPassword};
        List<Superuser> suList = superuserImplDao.query(sql,parameter);
        if(suList!=null && suList.size()>0){
            return  suList.get(0);
        }
        return null;
    }

    @Override
    public Page<Superuser> suPageQueryAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public List<Superuser> suUnionQuery(String id, String userName, String userSex) {
        return null;
    }

    @Override
    public Superuser suQueryById(String id) {
        return null;
    }

    @Override
    public int suAdd(Superuser superuser) {
        return 0;
    }

    @Override
    public int suDelById(String id) {
        return 0;
    }

    @Override
    public int suUpdateById(Superuser superuser) {
        return 0;
    }
}
