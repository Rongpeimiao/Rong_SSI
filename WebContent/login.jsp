<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<html lang="en" class="login-content" data-ng-app="materialAdmin">
 <head>
  <meta charset="UTF-8"> 
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title> Atis新能源系统</title>
  <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
  <!-- Vendor CSS -->
  <link href="css/material-design-iconic-font/css/material-design-iconic-font.min.css" rel="stylesheet" type="text/css">
  <!-- CSS -->
  <link href="css/app.min.1.css" rel="stylesheet" type="text/css">
  
 </head>
 <body class="login-content" data-ng-controller="loginCtrl as lctrl">
  <form id="loginform" action="login.action" method="post">
   <input name=userName id="userNameform"/>
   <input name="password" id="passwordform"/>
  </form>
    <div class="lc-block" id="l-login" data-ng-class="{'toggled':lctrl.login === 1}">
    	<h1>Atis新能源系统</h1>

    	<div class="input-group m-b-20">
    		<span class="input-group-addon">
    			<i class="zmdi zmdi-account"></i>
    		</span>
    		<div class="fg-line">
    			<input id="name" type="text" class="form-control" placeholder="Username" regex="^\w{1,16}$"/>
    		</div>
    	</div>

        <div class="input-group m-b-20">
    		<span class="input-group-addon">
    			<i class="zmdi zmdi-male"></i>
    		</span>
    		<div class="fg-line">
    			<input id="password" type="password" class="form-control" placeholder="Password" regex="^\w+"/>
    		</div>
    	</div>
    	
       <div style="height: 20px;">
    	<div id="warn" class="clearfix" style="color: red;"></div>
       </div>
    	
    	<!-- <div class="checkbox">
    		<label>
    			<input type="checkbox" value="" />
    			<i class="input-helper">
    				保持登录状态
    			</i>
    		</label>
    	</div> -->
        
    	<a href="#" onclick="sbtform()" class="btn btn-login btn-danger btn-float">
    		<i class="zmdi zmdi-arrow-forward"></i>
    	</a>
    </div>
  
 </body>
    <script>
     function sbtform(){
    	 var n=$("#name").val()
    	 var p=$("#password").val();
    	 if(null!=n&&null!=p&&""!=n&&""!=p){
    	 $("#userNameform").val(n);
    	 $("#passwordform").val(p);
    	 $("#loginform").submit();
    	 }else if(null==n|""==n){
    		 $("#warn").html("登录名称不能为空")
    	 }else if(null==p|""==p){
    		 $("#warn").html("登陆密码不能为空")
    	 }
     }
    </script>
 	<script language="JavaScript" src="<%=basePath%>/js/jquery.min.js"></script>
 	<script src="js/bower_components/jquery/dist/jquery.min.js"></script>
	<script src="js/log.js"></script>
	<!-- Angular -->
	<script src="js/bower_components/angular/angular.min.js"></script>
	<script src="js/bower_components/angular-resource/angular-resource.min.js"></script>
	<script src="js/bower_components/angular-animate/angular-animate.min.js"></script>
	<!-- Angular Modules -->
	<script src="js/bower_components/angular-ui-router/release/angular-ui-router.min.js"></script>
	<script src="js/bower_components/angular-loading-bar/src/loading-bar.js"></script>
	<script src="js/bower_components/oclazyload/dist/ocLazyLoad.min.js"></script>
	<script src="js/bower_components/angular-bootstrap/ui-bootstrap-tpls.min.js"></script>
	<!-- Common js -->
	<script src="js/bower_components/angular-nouislider/src/nouislider.min.js"></script>
	<script src="js/bower_components/ng-table/dist/ng-table.min.js"></script>
	<script src="js/app.js"></script>
	<script src="js/controllers/main.js"></script>
	<script src="js/controllers/ui-bootstrap.js"></script>
	<!-- Template Modules -->
	<script src="js/modules/form.js"></script>
</html>