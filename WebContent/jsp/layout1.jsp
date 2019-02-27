
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
//j-resizeGrid  overflow: hidden;

//$("#content").load(location.href + " #content")
</script>
<div   style="padding:5px"  id="layout1" width="98%" >
	
		<div style="display: flex;width: 100%" >
			 <div   style=" border:1px dashed #d0e0e3;width: 100%">
						    <div class="panelBar">
								<h1 style="margin-top: 8px;margin-left: 8px;">调度样本列表</h1>
							</div>
							<table class="list" id="tablejbsxBox"  layoutH="270" width="100%"   rel="layout1">
								<thead>
									<tr>
										<th style="  width: 10%;" >状态</th>
										<th  style="  width: 20%;" >样本编号</th>
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
									<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value}, 'layout1')">
										<option <c:if test="${numPerPage==10}">selected="selected"</c:if>
											value="10">10</option>
										<option <c:if test="${numPerPage==20}">selected="selected"</c:if>
											value="20">20</option>
										<option <c:if test="${numPerPage==50}">selected="selected"</c:if>
											value="50">50</option>
										<option <c:if test="${numPerPage==100}">selected="selected"</c:if>
											value="100">100</option>
									</select>
									 <span>条，共${pager.total}条</span>
								</div>
								
								<div  class="pagination" rel="layout1" totalCount="${pager.total}" numPerPage="${pager.numPerPage}" pageNumShown="${pager.numPerPage}" currentPage="${pager.pageNum}"  ></div>
						
						</div>
			 </div>
			  <form  id="pagerForm" action="homeNotice.action" onsubmit="return divSearch(this, 'layout1');" >
			    <input type="hidden" name="pageNum" value="1" />                  <!--onsubmit="return divSearch(this, 'jbsxBox');" stationOrRoute.action -->
				<input type="hidden" name="numPerPage" value="${pager.numPerPage}" />
              </form>
			 
		</div>
</div>


	

