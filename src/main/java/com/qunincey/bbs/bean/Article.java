package com.qunincey.bbs.bean;

import java.util.Date;

/*这里的id和pid是对应的 即pid对应的是父节点的id*/

public class Article {

    private  int id;
//   父节点
    private int pid;
//    根节点 主题话题
    private int rootid;

    private String title;
    private String content;

    private Date pdate;
//    0代表是叶子节点 1代表非叶子节点  叶子节点代表没有人回复他了
    private int isleaf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpid() {
        return pid;
    }

    public void setpid(int pid) {
        this.pid = pid;
    }

    public int getRootid() {
        return rootid;
    }

    public void setRootid(int rootid) {
        this.rootid = rootid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public int getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(int isleaf) {
        this.isleaf = isleaf;
    }
}
