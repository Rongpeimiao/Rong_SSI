
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<style type="text/css">
	ul.rightTools {float:right; display:block;}
	ul.rightTools li{float:left; display:block; margin-left:5px}
	
</style>

<script type="text/javascript">
//j-resizeGrid  overflow: hidden;

</script>
<div   style="padding:5px;width: 98%"  id="layout2" >
	 
			 <div  style="border:1px dashed #d0e0e3;width: 100%" >
			           
						   <div class="panelBar">
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
										<th style="  width: 10%;"  >状态</th>
										<th  style=" width: 25%;" >公告标题</th>
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
									<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value}, 'layout2')">
										<option value="20">20</option>
										<option value="50">50</option>
										<option value="100">100</option>
										<option value="200">200</option>
									</select>
									<span>条，共50条</span>
								</div>
								
								<div class="pagination" rel="layout2" totalCount="200" numPerPage="20" pageNumShown="5" currentPage="1"></div>
						
							</div>
			            <form  id="pagerForm" action="homeNotice.action" onsubmit="return divSearch(this, 'layout2');" >
						    <input type="hidden" name="pageNum" value="1" />                  <!--onsubmit="return divSearch(this, 'jbsxBox');" stationOrRoute.action -->
							<input type="hidden" name="numPerPage" value="${pager.numPerPage}" />
			              </form>
			 </div>
 

	 
	</div>
	
	
</div>


	

