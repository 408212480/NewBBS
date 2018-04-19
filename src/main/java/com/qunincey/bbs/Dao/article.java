package com.qunincey.bbs.Dao;



import com.qunincey.bbs.bean.Article;
import com.qunincey.bbs.util.Page;

import java.util.List;

public interface article {

    /*通过id进行查找*/
    public Article getArticleById(int id);
//    查找所有的主题
    public List<Article> getAllArticle();
//    查找所有指定pid的帖子
    public List<Article> getPArticle(List<Article> AddList, int pid, Page page);
//    插入新的评论
    public boolean insertArticle(Article article);
//    插入新的主题,key代表生成和id相同的rootid
    public boolean publishNew(Article article);
//    查找总的记录数
    public int findCountByID(int id);
//    查找所有的根节点上的记录
    public List<Article> findRArticle(List<Article> addlist, int rootid, Page page);





}
