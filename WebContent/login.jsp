<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script language="JavaScript" src="<%=basePath%>/js/jquery.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head runat="server">
  <title></title>
    <link href="style/alogin.css" rel="stylesheet" type="text/css" />
</head>
<body>
  
   <form id="loginform" action="login.action" method="post" >
   <input name="userCode" id="userNameform"  value="admin"/>
   <input name="password" id="passwordform"  value="123"/>
   <button type="submit">提交 </button>
  </form>
  
</body>


 	
</html>
