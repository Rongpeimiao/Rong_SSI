<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include   page="/styles/dwz/common/common.jsp"></jsp:include>      
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> </title>
<script type="text/javascript">
$(function(){
	DWZ.init("styles/dwz/dwz.frag.xml", {
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<ul class="nav">
					<li><a href="login.jsp">退出</a></li>
				</ul>
			</div>
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>
				<div class="accordion" fillSpace="sidebar">
					<div class="accordionContent">
					<ul class="tree treeFolder">
						<li><a>模板</a>
						<ul >
<!-- 							<li><a target="navTab" rel="" href="sitequeryUpdateapp.action?imei=867330028426016">BMS数据</a></li>
 -->							<li><a target="navTab" rel="" href="./jsp/demo/w_textInput.html">表格模板</a></li>
						</ul>
						</li>
					</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
					<div style="height: 1555px;">
				     <%--  <jsp:include page="jsp/siteTable.jsp"></jsp:include> --%>
					</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<div id="footer">Copyright &copy;  atis团队  香港城市大学研究中心</div>
</body>


</html>