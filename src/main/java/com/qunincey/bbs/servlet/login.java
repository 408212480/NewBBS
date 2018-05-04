package com.qunincey.bbs.servlet;

import com.qunincey.bbs.Dao.AccountPersistService;
import com.qunincey.bbs.Dao.Impl.AccountPersistServiceImpl;
import com.qunincey.bbs.bean.Account;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login",urlPatterns = "/loginServlet")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String jsonError="";
        RequestDispatcher rdt=null;

        if(name.equals("")|| password.equals("")||name == null|| password == null){
            jsonError="{\"Nullerror\":\"姓名或密码为空\"}";
            rdt=req.getRequestDispatcher("/lo_gin.html");
        }else {
            AccountPersistService aps=new AccountPersistServiceImpl();
            Account account=aps.getAccountById(name);
            if (account==null){
                jsonError="{\"Usererror\":\"用户不存在，请注册\"}";
                rdt=req.getRequestDispatcher("/lo_gin.html");
            }else if (account.getPassword().equals(password)){
                rdt=req.getRequestDispatcher("/setList");
            }
        }
        resp.getWriter().write(jsonError);
        rdt.forward(req,resp);
    }
}
