package com.qunincey.bbs.Dao.Impl;


import com.qunincey.bbs.Dao.article;
import com.qunincey.bbs.bean.Article;
import com.qunincey.bbs.util.DBconn;
import com.qunincey.bbs.util.Page;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.qunincey.bbs.util.DBconn.conn;

public class ArticleImpl implements article {


    public Article getArticleById(int id) {
        String getArticleById=" select * from article where id = ? ";
        Connection conn= conn();
        Article article=null;
        ResultSet rs=null;
        PreparedStatement statement=null;
        try {
            statement=conn.prepareStatement(getArticleById);
            statement.setInt(1,id);
            rs=statement.executeQuery();
            while (rs.next()){
                article=new Article();
                article.setId(rs.getInt(1));
                article.setpid(rs.getInt(2));
                article.setRootid(rs.getInt(3));
                article.setTitle(rs.getString(4));
                article.setContent(rs.getString(5));
                article.setPdate(rs.getDate(6));
                article.setIsleaf(rs.getInt(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBconn.close(rs);
            DBconn.close(statement);
            DBconn.close(conn);
        }


        return article;
    }

    public List<Article> getAllArticle() {
        String getAllArticle=" select * from article ";
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet rs=null;
        List<Article> list=new ArrayList<Article>();
        try {
            conn= conn();
            statement=conn.prepareStatement(getAllArticle);
            rs=statement.executeQuery();
            while (rs.next()){
                Article article=new Article();
                article.setId(rs.getInt(1));
                article.setpid(rs.getInt(2));
                article.setRootid(rs.getInt(3));
                article.setTitle(rs.getString(4));
                article.setContent(rs.getString(5));
                article.setPdate(rs.getDate(6));
                article.setIsleaf(rs.getInt(7));
                list.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBconn.close(rs);
            DBconn.close(statement);
            DBconn.close(conn);
        }
        return list;
    }
//    这个方法获取一个主题下的所有的帖子


    public List<Article> getPArticle(List<Article> AddList, int pid) {
        return getPArticle(AddList,pid,null);
    }

    public List<Article> getPArticle(List<Article> Addlist, int pid, Page page){
        String getPArticle=" select * from article where pid= ? limit ?,? ";
//        page=null说明不需要分页
        if (page==null){
            getPArticle=" select * from article where pid=? ";
        }
        Connection conn=null;
        PreparedStatement statemen=null;
        ResultSet rs=null;
        try {
            conn= conn();
            statemen=conn.prepareStatement(getPArticle);
            if (page!=null){
                statemen.setInt(1,pid);
                statemen.setInt(2,page.getBeginIndex());
                statemen.setInt(3,page.getEveryPage());
            }else {
                statemen.setInt(1,pid);
            }
            rs=statemen.executeQuery();
            while (rs.next()){
                Article article=new Article();
                article.setId(rs.getInt(1));
                article.setpid(rs.getInt(2));
                article.setRootid(rs.getInt(3));
                article.setTitle(rs.getString(4));
                article.setContent(rs.getString(5));
                article.setPdate(rs.getDate(6));
                article.setIsleaf(rs.getInt(7));
                Addlist.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBconn.close(rs);
            DBconn.close(statemen);
            DBconn.close(conn);
        }
        return Addlist;
    }

    @Override
    public boolean insertArticle(Article article) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        boolean avail=false;
        int reslut=0;
        String insertArticle=" insert into article(id,pid,rootid,title,cont,pdate,isleaf) value (NULL,?,?,?,?,now(),?) ";
        conn=conn();
        try {
            pstmt=conn.prepareStatement(insertArticle);
            pstmt.setInt(1,article.getpid());
            pstmt.setInt(2,article.getRootid());
            pstmt.setString(3,article.getTitle());
            pstmt.setString(4,article.getContent());
            pstmt.setInt(5,0);
           reslut= pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBconn.close(pstmt);
            DBconn.close(conn);
        }
//        reslut>0说明插入语句起作用了
        if (reslut>0){
            avail=true;
        }
       return  avail;
    }

//    插入主题
    @Override
    public boolean publishNew(Article article) {
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        PreparedStatement prep=null;
        ResultSet reslut=null;
        boolean comm=false;
        String insertNew=" insert into article(id,pid,rootid,title,cont,pdate,isleaf) value (NULL,?,?,?,?,now(),?) ";
        String update=" update article set rootid = ? where id = ? ";
        int rootid=-1;

        try {
            conn=conn();
            boolean autoCommit=conn.getAutoCommit();
//            设置false代表关闭自动提交 ，开启事务
            conn.setAutoCommit(false);
            preparedStatement=conn.prepareStatement(insertNew,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,0);
            preparedStatement.setInt(2,rootid);
            preparedStatement.setString(3,article.getTitle());
            preparedStatement.setString(4,article.getContent());
            preparedStatement.setInt(5,0);
            preparedStatement.executeUpdate();

            reslut=preparedStatement.getGeneratedKeys();
            reslut.next();
           int rootId= reslut.getInt(1);
           prep=conn.prepareStatement(update);
           prep.setInt(1,rootId);
           prep.setInt(2,rootId);
           prep.executeUpdate();
           conn.commit();
           comm=true;
           conn.setAutoCommit(autoCommit);
        } catch (SQLException e) {
            comm=false;
            e.printStackTrace();
        }finally {
            DBconn.close(prep);
            DBconn.close(reslut);
            DBconn.close(preparedStatement);
            DBconn.close(conn);
        }

        return comm;
    }

//    查找所有的帖子的数量
    @Override
    public int findCountByID(int id) {
        Connection conn=null;
        PreparedStatement stme=null;
        ResultSet rs=null;
        int totalCount=0;
        String findCountByID=null;
//        一个查找所有主题帖子的数量一个查找主题下所有主题的帖子
        if(id==0){
            findCountByID=" select count(*) from article where pid= ? ";
        }else {
            findCountByID=" select count(*) from article where rootid=? ";
        }
        try {
            conn=conn();
            stme=conn.prepareStatement(findCountByID);
            stme.setInt(1,id);
            rs=stme.executeQuery();
            while (rs.next()){
                totalCount=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBconn.close(stme);
            DBconn.close(rs);
            DBconn.close(conn);
        }


        return totalCount;
    }

    public List<Article> findRArticle(List<Article> addlist, int rootid) {

        return findRArticle(addlist,rootid,null);
    }
    @Override
    public List<Article> findRArticle(List<Article> addlist, int rootid, Page page) {

        String getRArticle=" select * from article where rootid= ? limit ?,? ";
//        page=null说明不需要分页
        if (page==null){
            getRArticle=" select * from article where rootid= ? ";
        }
        Connection conn=null;
        PreparedStatement statemen=null;
        ResultSet rs=null;
        try {
            conn= conn();
            statemen=conn.prepareStatement(getRArticle);
            if (page!=null){
                statemen.setInt(1,rootid);
                statemen.setInt(2,page.getBeginIndex());
                statemen.setInt(3,page.getEveryPage());
            }else {
                statemen.setInt(1,rootid);
            }
            rs=statemen.executeQuery();
            while (rs.next()){
                Article article=new Article();
                article.setId(rs.getInt(1));
                article.setpid(rs.getInt(2));
                article.setRootid(rs.getInt(3));
                article.setTitle(rs.getString(4));
                article.setContent(rs.getString(5));
                article.setPdate(rs.getDate(6));
                article.setIsleaf(rs.getInt(7));
                addlist.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBconn.close(rs);
            DBconn.close(statemen);
            DBconn.close(conn);
        }
        return addlist;
    }




}

