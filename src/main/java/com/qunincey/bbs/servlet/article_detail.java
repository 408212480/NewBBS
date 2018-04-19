package com.qunincey.bbs.servlet;

import com.qunincey.bbs.Dao.Impl.ArticleImpl;
import com.qunincey.bbs.Dao.article;
import com.qunincey.bbs.bean.Article;
import com.qunincey.bbs.util.Page;
import com.qunincey.bbs.util.PageUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "article_detail",urlPatterns = "/article_detail")
public class article_detail extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String currentPageStr=req.getParameter("currentPage");
        int currentPage=0;
        if (currentPageStr==null||"".equals(currentPageStr)){
            currentPage=1;
        }else {
            currentPage=Integer.parseInt(currentPageStr);
        }
        article ArticleImpl=new ArticleImpl();
        List<Article> list=new ArrayList<Article>();
        int count=new ArticleImpl().findCountByID(Integer.parseInt(id));
        Page page= PageUtil.createPage(3,count,currentPage);
        list=ArticleImpl.findRArticle(list,Integer.parseInt(id),page);
        req.setAttribute("detail_list",list);
        req.setAttribute("page",page);
        RequestDispatcher dispatcher= req.getRequestDispatcher("/article_detail.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
