package cn.guimei.service.impl;

import cn.guimei.dao.impl.CustomerImplDao;
import cn.guimei.pojo.Customer;
import cn.guimei.pojo.Page;
import cn.guimei.service.CustomerServiceDao;

import java.util.List;



public class CustomerServiceImplDao implements CustomerServiceDao {
    private static CustomerServiceImplDao ourInstance = new CustomerServiceImplDao();

    public static CustomerServiceImplDao getInstance() {
        return ourInstance;
    }

    private CustomerServiceImplDao() {
    }

    //获取SellerImplDao对象
    private CustomerImplDao customerImplDao = CustomerImplDao.getInstance();


    /**
     * 登录
     * @param cusLoginName
     * @param cusPassword
     * @return
     */
    @Override
    public Customer login(String cusLoginName, String cusPassword) {
        String sql = "select * from customer where cusLoginName = ? and cusPassword = ?";
        Object []parameter = {cusLoginName,cusPassword};
        List<Customer> cusList = customerImplDao.query(sql,parameter);
        if(cusList!=null && cusList.size()>0){
            return  cusList.get(0);
        }
        return null;
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Page<Customer> pageQueryAll(int pageNumber, int pageSize) {
        return customerImplDao.pageQuery(pageSize,pageNumber,null);
    }

    /**
     * 级联查询
     * @param id
     * @param cusName
     * @param cusSex
     * @return
     */
    @Override
    public List<Customer> unionQuery(String id, String cusName, String cusSex) {
        if(id!=null && cusName!=null && cusSex!=null){
            int idSize = id.length();
            int nameSize = cusName.length();
            int sexSize = cusSex.length();
            if(idSize == 0 && nameSize == 0 && sexSize ==0 ){
                //查询所有
                String sql = "select * from customer";
                List<Customer> cusList = customerImplDao.query(sql,null);
                if(cusList!=null && cusList.size()>0){
                    return  cusList;
                }
            }else if(idSize > 0 && nameSize == 0 && sexSize ==0 ){
                //根据 id 具体查询
                Object []parameter = {id};
                String sql = "select * from customer where id = ?";
                List<Customer> cusList = customerImplDao.query(sql,parameter);
                if(cusList!=null && cusList.size()>0){
                    return  cusList;
                }
            }else if(idSize == 0 && nameSize > 0 && sexSize ==0){
                //根据 姓名 模糊查询
                Object []parameter = {"%"+cusName+"%"};
                String sql = "select * from customer where cusName like ?";
                List<Customer> cusList = customerImplDao.query(sql,parameter);
                if(cusList!=null && cusList.size()>0){
                    return  cusList;
                }
            }else if(idSize == 0 && nameSize == 0 && sexSize > 0){
                //根据 性别查询
                Object []parameter = {cusSex};
                String sql = "select * from customer where cusSex = ?";
                List<Customer> cusList = customerImplDao.query(sql,parameter);
                if(cusList!=null && cusList.size()>0){
                    return  cusList;
                }
            }else if(idSize > 0 && nameSize > 0 && sexSize > 0){
                //根据 id 姓名  性别 级联查询
                Object []parameter = {id,"%"+cusName+"%",cusSex};
                String sql = "select * from customer where id = ? and cusName like ? and cusSex = ?";
                List<Customer> cusList = customerImplDao.query(sql,parameter);
                if(cusList!=null && cusList.size()>0){
                    return  cusList;
                }
            }else if(idSize > 0 && nameSize > 0 && sexSize == 0){
                //根据 id 姓名 级联查询
                Object []parameter = {id,"%"+cusName+"%"};
                String sql = "select * from customer where id = ? and cusName like ?";
                List<Customer> cusList = customerImplDao.query(sql,parameter);
                if(cusList!=null && cusList.size()>0){
                    return  cusList;
                }
            }else if(idSize == 0 && nameSize > 0 && sexSize > 0){
                //根据  姓名 性别 级联查询
                Object []parameter = {"%"+cusName+"%",cusSex};
                String sql = "select * from customer where cusName like ? and cusSex = ?";
                List<Customer> cusList = customerImplDao.query(sql,parameter);
                if(cusList!=null && cusList.size()>0){
                    return  cusList;
                }
            }else if(idSize > 0 && nameSize == 0 && sexSize > 0){
                //根据  id 性别 级联查询
                Object []parameter = {id,cusSex};
                String sql = "select * from customer where id = ? and cusSex = ?";
                List<Customer> cusList = customerImplDao.query(sql,parameter);
                if(cusList!=null && cusList.size()>0){
                    return  cusList;
                }
            }
        }
        return null;
    }

    @Override
    public Customer queryById(String id) {
        String sql = "select * from customer where id = ?";
        Object []parameter = {id};
        List<Customer> list = customerImplDao.query(sql,parameter);
        if(list!=null && list.size()>0){
            return  list.get(0);
        }
        return null;
    }

    /**
     * 增加
     * @param customer
     * @return
     */
    @Override
    public int add(Customer customer) {
        String sql = "insert into customer values(?,?,?,?,?,?,?,?,?,?)";
        return customerImplDao.add(sql,customer);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int delById(String id) {
        String sql="delete from customer where id=?";
        Object[] parameter={id};
        int i=customerImplDao.del(sql,parameter);
        return i;
    }

    /**
     * 修改
     * @param customer
     * @return
     */
    @Override
    public int updateById(Customer customer) {
        String sql = "update customer set cusName = ?,cusLoginName = ?,cusPassword = ?,cusEmail = ?," +
                "cusSex = ?,cusPhoto = ?,cusHobby = ?,cusIdCard = ?,cusBirthday = ?  where id = ?";
        Object []parameter = {
                customer.getId(),
                customer.getCusName(),
                customer.getCusLoginName(),
                customer.getCusPassword(),
                customer.getCusEmail(),
                customer.getCusSex(),
                customer.getCusPhoto(),
                customer.getCusHobby(),
                customer.getCusIdCard(),
                customer.getCusBirthday()
        };
        int i = customerImplDao.update(sql,parameter);
        return i;
    }
}
