package com.qunincey.bbs.servlet;

import com.qunincey.bbs.Dao.Impl.ArticleImpl;
import com.qunincey.bbs.Dao.article;
import com.qunincey.bbs.bean.Article;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "publishNew",urlPatterns = "/publishNew")
public class publishNew extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String title=req.getParameter("title");
        String content=req.getParameter("content");
        Article articlebean=new Article();
        articlebean.setTitle(title);
        articlebean.setContent(content);
        article article1=new ArticleImpl();
        boolean b=article1.publishNew(articlebean);
        RequestDispatcher dispatcher=null;
//        true代表事务成功
        if (b){
            dispatcher=req.getRequestDispatcher("/article.jsp");
        }else {
            req.setAttribute("err","发布失败请重新发布");
            dispatcher=req.getRequestDispatcher("/publishNew.jsp");
        }
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
