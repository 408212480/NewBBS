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

//获取回复
@WebServlet(name = "setList",urlPatterns = "/setList",loadOnStartup = 1)
public class setList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> AddList=new ArrayList<Article>();
        article articleimpl=new ArticleImpl();
        int count=articleimpl.findCountByID(0);
        String  currentPageStr=req.getParameter("currentPage");
        int currentPage=0;
        if (currentPageStr==null||"".equals(currentPageStr)){
            currentPage=1;
        }else {
            currentPage=Integer.valueOf(currentPageStr);
        }
        Page page=PageUtil.createPage(3,count,currentPage);
        AddList=articleimpl.getPArticle(AddList,0,page);
        req.setAttribute("AddList",AddList);
        req.setAttribute("page",page);
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/article.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
}
}
