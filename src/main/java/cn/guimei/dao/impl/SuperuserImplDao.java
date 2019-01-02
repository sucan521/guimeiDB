package cn.guimei.dao.impl;

import cn.guimei.core.util.PageUtil;
import cn.guimei.dao.BaseDao;
import cn.guimei.dao.SuperuserDao;
import cn.guimei.pojo.Page;
import cn.guimei.pojo.Superuser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SuperuserImplDao extends BaseDao implements SuperuserDao {
    private static SuperuserImplDao ourInstance = new SuperuserImplDao();

    public static SuperuserImplDao getInstance() {
        return ourInstance;
    }

    private SuperuserImplDao() {
    }

    @Override
    public int add(String sql, Superuser superuser) {
        return 0;
    }

    @Override
    public int del(String sql, Object[] parameter) {
        return 0;
    }

    @Override
    public int update(String sql, Object[] parameter) {
        return 0;
    }

    @Override
    public List<Superuser> query(String sql, Object[] parameter) {
        ResultSet rs = getQuery(sql,parameter);
        List<Superuser> suList = new ArrayList<Superuser>();
        try{
            while(rs.next()){
                Superuser superuser = new Superuser();
                superuser.setId(rs.getLong("id"));
                superuser.setUserName(rs.getString("userName"));
                superuser.setUserLoginName(rs.getString("userLoginName"));
                superuser.setUserPassword(rs.getString("userPassword"));
                superuser.setUserSex(rs.getString("userSex"));
                superuser.setUserId(rs.getString("userId"));
                superuser.setUserImage(rs.getString("userImage"));
                superuser.setUserStatus(rs.getLong("userStatus"));
                suList.add(superuser);
            }
            return  suList;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return null;
    }

    @Override
    public Page<Superuser> pageQuery(int pageSize, int pageNumber, Object[] parameter) {
        Page<Superuser> page = new Page<Superuser>();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        String sql1 = "select count(1) from superuser";
        String sql2 = "select * from superuser";
        page.setTotalRecode(PageUtil.getTotalRecode(sql1,null));
        List<Superuser> suList = new ArrayList<Superuser>();
        ResultSet rs = PageUtil.getPageDate(sql2,pageSize,pageNumber,null);
        try{
            while(rs.next()){
                Superuser superuser = new Superuser();
                superuser.setId(rs.getLong("id"));
                superuser.setUserName(rs.getString("userName"));
                superuser.setUserLoginName(rs.getString("userLoginName"));
                superuser.setUserPassword(rs.getString("userPassword"));
                superuser.setUserSex(rs.getString("userSex"));
                superuser.setUserId(rs.getString("userId"));
                superuser.setUserImage(rs.getString("userImage"));
                superuser.setUserStatus(rs.getLong("userStatus"));
                suList.add(superuser);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        page.setPageData(suList);
        return page;
    }
}
