<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>Java|Java世界_中文论坛|ChinaJavaWorld技术论坛</title>
<meta http-equiv="content-type" content="text/html">
<link rel="stylesheet" type="text/css" href="css/style.css" title="Integrated Styles">
<script language="JavaScript" type="text/javascript" src="js/global.js"></script>
  <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
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
          <p class="jive-page-title"> 回复: reply </p></td>
        <td width="1%"><div class="jive-accountbox"></div></td>
      </tr>
    </tbody>
  </table>
  <hr>
  <c:out value="${param.err}"></c:out>
  <form action="/reply" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="hidden" name="RootId" value="${param.RootId}">
    <p><span>标题</span><input name="title" type="text" size="40"><br/></p>
    内容<textarea name="content" id="content" cols="80" rows="25"></textarea>
    <script>
      CKEDITOR.replace('content');
    </script>
    <input type="submit" value="确定">
    <input type="reset" value="重置">
  </form>
</div>
</body>
</html>
