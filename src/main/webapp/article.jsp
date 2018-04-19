<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>Java|Java世界_中文论坛|ChinaJavaWorld技术论坛 : Java语言*初级版</title>
<meta http-equiv="content-type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="css/style.css" title="Integrated Styles">
<script language="JavaScript" type="text/javascript" src="js/global.js"></script>
<link rel="alternate" type="application/rss+xml" title="RSS" href="http://bbs.chinajavaworld.com/rss/rssmessages.jspa?forumID=20">
<script language="JavaScript" type="text/javascript" src="js/common.js"></script>
  <script type="text/javascript" src="js/paging.js"></script>
</head>
<body>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tbody>
    <tr>
      <td width="140"><a href="http://bbs.chinajavaworld.com/index.jspa"><img src="images/header-left.gif" alt="Java|Java世界_中文论坛|ChinaJavaWorld技术论坛" border="0"></a></td>
      <td><img src="images/header-stretch.gif" alt="" border="0" height="57" width="100%"></td>
      <td width="1%"><img src="images/header-right.gif" alt="" border="0"></td>
    </tr>
  </tbody>
</table>
<br>
<div id="jive-forumpage">
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td width="98%"><p class="jive-breadcrumbs">论坛: Java语言*初级版
            (模仿)</p>
          <p class="jive-description"> 探讨Java语言基础知识,基本语法等 大家一起交流 共同提高！谢绝任何形式的广告 </p>
          </td>
      </tr>
    </tbody>
  </table>
  <div class="jive-buttons">
    <table summary="Buttons" border="0" cellpadding="0" cellspacing="0">
      <tbody>
        <tr>
          <td class="jive-icon"><a href="http://bbs.chinajavaworld.com/post%21default.jspa?forumID=20"><img src="images/post-16x16.gif" alt="发表新主题" border="0" height="16" width="16"></a></td>
          <td class="jive-icon-label"><a id="jive-post-thread" href="/publishNew.jsp">发表新主题</a></td>
        </tr>
      </tbody>
    </table>
  </div>
  <br>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td>
          <span class="nobreak"> 一共<span id="count">${page.getTotalPage()}</span>页</span>
          <c:forEach var="currentPage" begin="1" end="${page.getTotalPage()}">
            <a href="/setList?currentPage=${currentPage}">${currentPage}</a>
          </c:forEach>

          <div id="barcon"></div>
        </td>
      </tr>
    </tbody>
  </table>
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td width="99%"><div class="jive-thread-list">
            <div class="jive-table">
              <table summary="List of threads" cellpadding="0" cellspacing="0" width="100%">
                <thead>
                  <tr>
                    <th class="jive-first" colspan="3"> 主题 </th>
                    <th class="jive-author"> <nobr> 作者
                      &nbsp; </nobr> </th>
                    <th class="jive-view-count"> <nobr> 浏览
                      &nbsp; </nobr> </th>
                    <th class="jive-msg-count" nowrap="nowrap"> 回复 </th>
                    <th class="jive-last" nowrap="nowrap"> 最新帖子 </th>
                  </tr>
                </thead>
                <tbody>


<c:forEach items="${AddList}" var="itemArticle" >
<c:if test="${itemArticle.getpid()==0}">
<tr class="jive-even">
  <td class="jive-first" nowrap="nowrap" width="1%">
    <div class="jive-bullet">
      <img src="images/read-16x16.gif" alt="已读" border="0" height="16" width="16">
    </div>
  </td>
  <td nowrap="nowrap" width="1%">&nbsp;&nbsp;</td>
  <td class="jive-thread-name" width="95%">
    <a id="jive-thread-1" href="/article_detail?id=${itemArticle.getId()}&RootId=${itemArticle.getRootid()}&currentPage=1">
        ${itemArticle.getTitle()}
    </a>
  </td>
  <td class="jive-author" nowrap="nowrap" width="1%"><span class=""> <a href="http://bbs.chinajavaworld.com/profile.jspa?userID=226030">fei870407</a> </span></td>
  <td class="jive-view-count" width="1%"> 104</td>
  <td class="jive-msg-count" width="1%"> 5</td>
  <td class="jive-last" nowrap="nowrap" width="1%"><div class="jive-last-post">${itemArticle.getPdate()}<br>
    by: <a href="http://bbs.chinajavaworld.com/thread.jspa?messageID=780182#780182" title="jingjiangjun" style="">jingjiangjun &#187;</a> </div></td>
</tr>
</c:if>
</c:forEach>

                </tbody>
              </table>
            </div>
          </div>
          <div class="jive-legend"></div></td>
      </tr>
    </tbody>
  </table>
  <br>
  <br>
</div>
</body>
</html>
