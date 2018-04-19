package com.qunincey.bbs.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class PageUtil extends SimpleTagSupport{

    private int everyPage;
    private int totalCount;
    private int currentPage;

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        createPage(everyPage,totalCount,currentPage);

    }

    public int getEveryPage() {
        return everyPage;
    }

    public void setEveryPage(int everyPage) {
        this.everyPage = everyPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public static Page createPage(int everyPage, int totalCount, int currentPage){//每页显示记录数，总记录数，当前页
//        设置每页显示页数  如果=0默认十页
             everyPage=getEveryPage(everyPage);
             currentPage=getCurrentPage(currentPage);
             int totalPage=getTotalPage(everyPage,totalCount);
             int beginIndex=getBeginIndex(everyPage,currentPage);
        boolean hasPrePage=getHasPrePage(currentPage);
        boolean hasNextPage=getHasNextPage(totalPage,currentPage);

        return new Page(everyPage,totalCount,totalPage,currentPage,beginIndex,hasPrePage,hasNextPage);


    }

    private static boolean getHasNextPage(int totalPage,int currentPage) {
        return currentPage==totalPage||totalPage==0?false:true;
    }
    private static boolean getHasPrePage(int currentPage) {
        return currentPage==1?false:true;
    }

    private static  int getBeginIndex(int everyPage,int currentPage){
        return (currentPage-1)*everyPage;

    }

    private static int getTotalPage(int everyPage, int totalCount) {
        int totalPage=0;
        if (totalCount!=0&&totalCount%everyPage==0){
            totalPage=totalCount/everyPage;
        }
        else {
            totalPage=totalCount/everyPage+1;
        }
        return totalPage;
    }

    /*当前页数*/
    private static int getCurrentPage(int currentPage) {
        return currentPage==0?1:currentPage;
    }

    /*每页显示记录数*/
    private static int getEveryPage(int everyPage) {

        return everyPage==0?10:everyPage;
    }
}
