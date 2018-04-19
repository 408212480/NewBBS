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

@WebServlet(name = "reply",urlPatterns = "/reply")
public class reply extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id=req.getParameter("id");
        String RootId=req.getParameter("RootId");
        String title=req.getParameter("title");
        String content=req.getParameter("content");
        Article articlebean=new Article();
        articlebean.setpid(Integer.parseInt(id));
        articlebean.setRootid(Integer.parseInt(RootId));
        articlebean.setTitle(title);
        articlebean.setContent(content);

        article article1=new ArticleImpl();
        boolean b=article1.insertArticle(articlebean);
        RequestDispatcher dispatcher=null;

        if (b){
//            id=0说明是根节点 是话题
            if (Integer.parseInt(id)==0){
                dispatcher=req.getRequestDispatcher("/setList");
            }else {
                dispatcher= req.getRequestDispatcher("/article_detail?id="+id+"&RootId="+RootId);
            }
        } else {
            dispatcher= req.getRequestDispatcher("/reply.jsp");
            req.setAttribute("err","评论失败");
        }
        dispatcher.forward(req,resp);
    }
}
