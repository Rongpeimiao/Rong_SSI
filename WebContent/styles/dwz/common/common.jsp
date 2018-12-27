<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=basePath%>/styles/dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=basePath%>/styles/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=basePath%>/styles/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="<%=basePath%>/styles/dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>

<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="js/speedup.js" type="text/javascript"></script>
<![endif]-->

<script src="<%=basePath%>/styles/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>


<script src="<%=basePath%>/styles/dwz/js/dwz.core.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.util.date.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.drag.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.tree.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.accordion.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.ui.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.theme.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.navTab.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.tab.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.resize.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.dialog.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.stable.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.ajax.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.pagination.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.database.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.effects.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.panel.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.history.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.combox.js" type="text/javascript"></script>
<script src="<%=basePath%>/styles/dwz/js/dwz.print.js" type="text/javascript"></script>
<!--
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="<%=basePath%>/styles/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<script type="text/javascript">
</script>
</head>
</html>