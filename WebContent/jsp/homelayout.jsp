
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<style type="text/css">
	ul.rightTools {float:right; display:block;}
	ul.rightTools li{float:left; display:block; margin-left:5px}
	
</style>

<script type="text/javascript">
//j-resizeGrid  overflow: hidden;
$.ajax({
    type: "POST",
 	url:"homeNotice.action",
	data:"",
	cache: false,
	dataType:"text",
	success: function(msg){
		// alert( "Data Saved: " + msg );
		// $("#tablejbsxBox").html('<tr target="sid_obj" rel="1"><td>'+msg+'</td><td>bj0001</td><td>xxx</td><td>2011-9-6</td><td>xxx</td><td>1</td></tr>');
		 var arr=new Array();
		 //可以用字符或字符串分割
		 arr=msg.split('/');
		 for(var i=0;i<arr.length;i++){
			 var json=JSON.parse(arr[i]);
			 //alert( "userName=" + json["userName"] );  //获取json对象里面的值的方式 
			// alert( "userName=" + json.userName);        //获取json对象里面的值的方式 
			 
		  }
	   }
});

$(function(){
	$("#layout2 #pagerForm").submit();
});
</script>
<div   style="padding:5px"  id="jbsxBox" >
		<div class="panel" defH="100" style="min-width: 700px;">
		<h1><p hidden="hidden">ss</p></h1>
		<div   >
			<table width="100%" height="100%" style="background-image:url('./images/gg/l0.png');background-size:100%;background-repeat: no-repeat;">
		   <tr align="center">
		    <td ><div style="color: white;font-size: 20px;margin-top: 5px;"> 10</div><br><div style="color: white;"> 录入样本（本月）</div></td>
		    <td ><div style="color: white;font-size: 20px;margin-top: 5px;"> 20</div><br><div style="color: white;"> 采集样本（本月）</div></td>
			<td ><div style="color: white;font-size: 20px;margin-top: 5px;"> 0</div><br><div style="color: white;"> 审核通过样本（本月）</div></td>
			<td ><div style="color: white;font-size: 20px;margin-top: 5px;"> 0</div><br><div style="color: white;"> 重测样本（本月）</div></td>
			<td ><div  style=" font-size: 20px;margin-top: 5px;"> 0</div><br><div > 退回样本（本月）</div></td>
			<td ><div style="color: white;font-size: 20px;margin-top: 5px;"> 6</div><br><div style="color: white;"> 生成报告数（本月）</div></td>
		   </tr>
		   </table>
		</div>
	</div>
	<div class="divider" style="min-width: 700px;" ></div>
	 <div class="panel"  style="min-width: 700px;" >
		<h1><p></p></h1>
		<div style="min-width: 700px; display: flex" >
			 <div   style="width:50.5%;border:1px dashed #d0e0e3;">
						  <!--   <div class="panelBar">
								<h1 style="margin-top: 8px;margin-left: 8px;">调度样本列表</h1>
							</div>
							<table class="list" id="tablejbsxBox"  layoutH="270"  width="100%"  rel="jbsxBox">
								<thead>
									<tr>
										<th style="  width: 10%;" >状态</th>
										<th  style="  width: 20%;" orderField="number" class="asc">样本编号</th>
										<th style="  width: 15%;" >发出时间</th>
										<th style="  width: 15%;">要完成时间</th>
										<th style="  width: 15%;">发出者</th>
										<th style="  width: 15%;" >完成时间</th>
									</tr>
								</thead>
								<tbody>
									<tr target="sid_obj" rel="1">
										<td>1s</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
										<td>1</td>
									</tr>
									<tr target="sid_obj" rel="2">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
										<td>1</td>
									</tr>
									<tr target="sid_obj" rel="1">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
										<td>1</td>
									</tr>
									<tr target="sid_obj" rel="2">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
										<td>1</td>
									</tr>
									<tr target="sid_obj" rel="1">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>张三</td>
										<td>xxx</td>
										<td>1</td>
									</tr>
									<tr target="sid_obj" rel="2">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
										<td>1</td>
									</tr>
									<tr target="sid_obj" rel="1">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
										<td>1</td>
									</tr>
									<tr target="sid_obj" rel="2">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
										<td>1</td>
									</tr>
									<tr target="sid_obj" rel="1">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
										<td>1</td>
									</tr>
									<tr target="sid_obj" rel="2">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
										<td>1</td>
									</tr>
									<tr target="sid_obj" rel="1">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
										<td>1</td>
									</tr>
									<tr target="sid_obj" rel="2">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
										<td>1</td>
									</tr>
								</tbody>
							</table>
							<div class="panelBar" >
								<div class="pages">
									<span>显示</span>
									<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value}, 'jbsxBox')"  >
										<option  value="20">20</option>
										<option value="50">50</option>
										<option value="100">100</option>
										<option value="200">200</option>
									</select>
									<span>条，共50条</span>
								</div>
								
								<div  class="pagination" rel="jbsxBox" totalCount="200" numPerPage="20" pageNumShown="5" currentPage="1"  ></div>
						
							
						</div> -->
						  <jsp:include page="/jsp/layout1.jsp"></jsp:include>
			 </div>
			 <%--  <form  id="pagerForm" action="homeNotice.action" onsubmit="return divSearch(this, 'jbsxBox');" >
			    <input type="hidden" name="pageNum" value="1" />                  <!--onsubmit="return divSearch(this, 'jbsxBox');" stationOrRoute.action -->
				<input type="hidden" name="numPerPage" value="${pager.numPerPage}" />
              </form> --%>
			 <div style="width: 15px;"></div>
			 <div  style="width: 49%;border:1px dashed #d0e0e3;" >
			           
						  <!--  <div class="panelBar">
								<h1 style="margin-top: 8px;margin-left: 8px;">通知公告列表</h1>  
								 <div  style="display: inline-block;width: 75%;">
									 <h1 style="margin-top: 8px;margin-left: 8px;">通知公告列表</h1> <br/>
								 </div>
								 <div  style="display: inline-block; ">
								<ul class="toolBar">
									<li><a class="add" href="#" target="dialog" mask="true"><span>发布通知公告</span></a></li>
								</ul>
								</div>
							</div>
							<table class="list"   layoutH="270"   width="100%"  rel="jbsxBox1">
								<thead>
									<tr>
										<th style="  width: 10%;" orderField="number" class="asc">状态</th>
										<th  style=" width: 25%;" orderField="name">公告标题</th>
										<th style=" width: 25%;">发布日期</th>
										<th style=" width: 20%;">发布者</th>
										<th style=" width: 20%;">详情</th>
									</tr>
								</thead>
								<tbody>
									<tr target="sid_obj" rel="1">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
									</tr>
									<tr target="sid_obj" rel="2">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
									</tr>
									<tr target="sid_obj" rel="1">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
									</tr>
									<tr target="sid_obj" rel="2">
										<td>1</td>
										<td>bj0001</td>
										<td>2011-9-6</td>
										<td>xxx</td>
										<td>1</td>
									</tr>
									<tr target="sid_obj" rel="1">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
									</tr>
									<tr target="sid_obj" rel="2">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
									</tr>
									<tr target="sid_obj" rel="1">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
									</tr>
									<tr target="sid_obj" rel="2">
										<td>1</td>
										<td>bj0001</td>
										<td>xxx</td>
										<td>2011-9-6</td>
										<td>xxx</td>
									</tr>
								</tbody>
							</table>
							<div class="panelBar" >
								<div class="pages">
									<span>显示</span>
									<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value}, 'jbsxBox')">
										<option value="20">20</option>
										<option value="50">50</option>
										<option value="100">100</option>
										<option value="200">200</option>
									</select>
									<span>条，共50条</span>
								</div>
								
								<div class="pagination" rel="jbsxBox" totalCount="200" numPerPage="20" pageNumShown="5" currentPage="1"></div>
						
							</div> -->
			            <jsp:include page="/jsp/layout2.jsp"></jsp:include> 
			 </div>
 

		</div>
	</div>
	
	
</div>


	

