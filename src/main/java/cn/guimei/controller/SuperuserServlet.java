package cn.guimei.controller;

import cn.guimei.pojo.Superuser;
import cn.guimei.service.impl.SuperuserServiceImplDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(name = "SuperuserServlet",urlPatterns = "/doSuperuser")
public class SuperuserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码方式统一操作
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取输入流对象
        PrintWriter out = response.getWriter();
        //获取path路径
        String path = request.getContextPath();
        //获取session对象
        HttpSession session = request.getSession();
        //获取参数action的值
        String action = request.getParameter("action");
        //获取管理员的服务对象
        SuperuserServiceImplDao serviceImplDao = SuperuserServiceImplDao.getInstance();

        /**
         * 管理员登录
         */
        if (action != null && action.equals("login")) {
            String userLoginName = request.getParameter("userLoginName");
            String userPassword = request.getParameter("userPassword");
            Superuser superuser = serviceImplDao.suLogin(userLoginName, userPassword);
            if (superuser != null) {
                session.setAttribute("Superuser", superuser);
                response.sendRedirect(path + "/pages/backPages/superuser/index.jsp");
            } else {
                response.sendRedirect(path + "/pages/backPages/superuser/index.jsp");
            }
        }
    }
}

