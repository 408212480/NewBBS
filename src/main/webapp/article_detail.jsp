<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>
  <c:if test="${not empty detail_list}">
    <c:forEach var="item" items="detail_list">
      <c:out value="item.getContent()"></c:out>
    </c:forEach>
  </c:if>
</title>
<meta http-equiv="content-type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="css/style.css" title="Integrated Styles">
<script language="JavaScript" type="text/javascript" src="js/global.js"></script>
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
<div id="jive-flatpage">
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td width="99%"><p class="jive-breadcrumbs"> <a href="http://bbs.chinajavaworld.com/index.jspa">首页</a> &#187; <a href="http://bbs.chinajavaworld.com/forumindex.jspa?categoryID=1">ChinaJavaWorld技术论坛|Java世界_中文论坛</a> &#187; <a href="http://bbs.chinajavaworld.com/category.jspa?categoryID=2">Java 2 Platform, Standard Edition (J2SE)</a> &#187; <a href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=0">Java语言*初级版</a> </p>
          <p class="jive-page-title">
            <c:if test="${not empty list }">
            <c:forEach var="item" items="detail_list">
              <c:out value="item.getContent()"></c:out>
            </c:forEach>
          </c:if></p></td>
        <td width="1%"><div class="jive-accountbox"></div></td>
      </tr>
    </tbody>
  </table>
  <div class="jive-buttons">
    <table summary="Buttons" border="0" cellpadding="0" cellspacing="0">
      <tbody>
        <tr>
          <%--拿到id属性 这个id代表的是根帖子的id--%>
          <c:set var="id" scope="request" value="${param.id}"></c:set>
          <td class="jive-icon"><a href="http://bbs.chinajavaworld.com/post%21reply.jspa?threadID=744236"><img src="images/reply-16x16.gif" alt="回复本主题" border="0" height="16" width="16"></a></td>
          <td class="jive-icon-label"><a id="jive-reply-thread" href="reply.jsp?id=${id}&RootId=${param.RootId}">回复本主题</a> </td>
        </tr>
      </tbody>
    </table>
  </div>
  <br>
  <br>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tbody>
    <tr valign="top">
      <td>
        <span class="nobreak"> 一共<span id="count">${page.getTotalPage()}</span>页</span>
        <c:forEach var="currentPage" begin="1" end="${page.getTotalPage()}">
          <a href="/article_detail?currentPage=${currentPage}&id=${param.id}">${currentPage}</a>
        </c:forEach>
        <script type="text/javascript" >
            window.onload=getPage(${page.getCurrentPage()});
        </script>
        <div id="barcon"></div>
       </span>
      </td>
    </tr>
    </tbody>
  </table>
  <%--回复--%>
  <c:if test="${not empty detail_list}">
    <c:forEach var="item" items="${detail_list}">
        <table border="0" cellpadding="0" cellspacing="0" width="100%">
          <tbody>
          <tr valign="top">
            <td width="99%"><div id="jive-message-holder">
              <div class="jive-message-list">
                <div class="jive-table">
                  <div class="jive-messagebox">
                    <table summary="Message" border="0" cellpadding="0" cellspacing="0" width="100%">
                      <tbody>
                      <tr id="jive-message-780144" class="jive-odd" valign="top">
                        <td class="jive-first" width="1%">
                          <!-- 个人信息的table -->
                          <table border="0" cellpadding="0" cellspacing="0" width="150">
                            <tbody>
                            <tr>
                              <td><table border="0" cellpadding="0" cellspacing="0" width="100%">
                                <tbody>
                                <tr valign="top">
                                  <td style="padding: 0px;" width="1%"><nobr> <a href="http://bbs.chinajavaworld.com/profile.jspa?userID=215489" title="诺曼底客">诺曼底客</a> </nobr> </td>
                                  <td style="padding: 0px;" width="99%"><img class="jive-status-level-image" src="images/level3.gif" title="世界新手" alt="" border="0"><br>
                                  </td>
                                </tr>
                                </tbody>
                              </table>
                                <img class="jive-avatar" src="images/avatar-display.png" alt="" border="0"> <br>
                                <br>
                                <span class="jive-description"> 发表:
                                  34 <br>
                                  点数: 100<br>
                                  注册:
                                  07-5-10 <br>
                                  <a href="http://blog.chinajavaworld.com/u/215489" target="_blank"><font color="red">访问我的Blog</font></a> </span> </td>
                            </tr>
                            </tbody>
                          </table>
                          <!--个人信息table结束-->
                        </td>
                        <td class="jive-last" width="99%"><table border="0" cellpadding="0" cellspacing="0" width="100%">
                          <tbody>
                          <tr valign="top">
                            <td width="1%"></td>
                            <td width="97%">
                              <span class="jive-subject">
                                   <c:forEach items="${detail_list}" var="father">
                                     <c:if test="${father.getId()==item.getpid()}">
                                       父贴:<c:out value="${father.getContent()}"></c:out>
                                     </c:if>
                                   </c:forEach>
                              </span>
                            </td>
                            <td class="jive-rating-buttons" nowrap="nowrap" width="1%"></td>
                            <td width="1%"><div class="jive-buttons">
                              <table border="0" cellpadding="0" cellspacing="0">
                                <tbody>
                                <tr>
                                  <td>&nbsp;</td>
                                  <td class="jive-icon"><a href="/reply.jsp?id=${item.getId()}&RootId=${item.getRootid()}" title="回复本主题"><img src="images/reply-16x16.gif" alt="回复本主题" border="0" height="16" width="16"></a> </td>
                                  <td class="jive-icon-label"><a href="/reply.jsp?id=${item.getId()}&RootId=${item.getRootid()} " title="回复本主题">回复</a> </td>
                                </tr>
                                </tbody>
                              </table>
                            </div></td>
                          </tr>
                          <tr>
                            <td colspan="4" style="border-top: 1px solid rgb(204, 204, 204);"><br>
                                ${item.getContent()}<br>
                              <br>
                            </td>
                          </tr>
                          <tr>
                            <td colspan="4" style="font-size: 9pt;"><img src="images/sigline.gif"><br>
                              <font color="#568ac2">学程序是枯燥的事情，愿大家在一起能从中得到快乐！</font> <br>
                            </td>
                          </tr>
                          <tr>
                            <td colspan="4" style="border-top: 1px solid rgb(204, 204, 204); font-size: 9pt; table-layout: fixed;"> ·<a href="http://www.bjsxt.com"><font color="#666666">http://www.bjsxt.com</font></a> </td>
                          </tr>
                          </tbody>
                        </table></td>
                      </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div></td>
            <td width="1%"></td>
          </tr>
          </tbody>
        </table>
    </c:forEach>
  </c:if>

  <div class="jive-message-list-footer">
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
      <tbody>
      <tr>
        <td nowrap="nowrap" width="1%"></td>
        <td align="center" width="98%"><table border="0" cellpadding="0" cellspacing="0">
          <tbody>
          <tr>
            <td><a href="/setList"><img src="images/arrow-left-16x16.gif" alt="返回到主题列表" border="0" height="16" hspace="6" width="16"></a> </td>
            <td><a href="/setList">返回到主题列表</a> </td>
          </tr>
          </tbody>
        </table></td>
        <td nowrap="nowrap" width="1%">&nbsp;</td>
      </tr>
      </tbody>
    </table>
  </div>

</div>
</body>
</html>
