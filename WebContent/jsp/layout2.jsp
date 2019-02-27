
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
	ul.rightTools {float:right; display:block;}
	ul.rightTools li{float:left; display:block; margin-left:5px}
	
</style>

<script type="text/javascript">

//j-resizeGrid  overflow: hidden;
function xqing(obj){   
	$(obj).attr("content")
	$("#divxq").html($(obj).next(".divxq").html());
	//alertMsg.info($(obj).next(".divxq").html() );
	//$("#alerttextarea").html($("#divxq").html());
}  


</script>
<div   style="padding:5px;width: 98%"  id="layout2" >
	 <div  hidden="hidden"  id="divxq"> </div>
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
										<th  style=" width: 35%;" >公告标题</th>
										<th style=" width: 25%;">发布日期</th>
										<th style=" width: 20%;">发布者</th>
										<th style=" width: 10%;">详情</th>
									</tr>
								</thead>
								<tbody>
									 <c:if test="${!empty listNotice}">
									    <c:forEach items="${listNotice}" var="lists">
									    <tr>
									    <td>${lists.noticeId}</td>
										<td>${lists.title}</td>
										<td><fmt:formatDate value="${lists.createTime}" pattern="yyyy-MM-dd"/></td>
										<td>${lists.fromUserId}</td>
										<td>
										<%-- <a href="#" onclick="alert('${lists.content}')">详情</a>  --%>
										<a  href="jsp/demo_page_alert.jsp" rel="demo_page_alert" target="dialog"  onclick='xqing(this)'>
										<span>详情</span>
										</a>
                                          <div hidden="hidden" class="divxq">${lists.content} </div>
										</td><!-- ${lists.content} -->
									   </tr>
									    </c:forEach>
									  </c:if>	
									<%-- <tr  >
										<td> </td>
										<td>bj0001</td>
										<td></td>
										<td>${ listNotice}</td>
										<td>${!empty listNotice}</td>
									</tr> --%>
								</tbody>
							</table>
							 <div class="panelBar" >
								<div class="pages">
									<span>显示</span>
									<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value}, 'layout2')">
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
								
								<div class="pagination" rel="layout2" totalCount="${pager.total}" numPerPage="${pager.numPerPage}" pageNumShown="${pager.numPerPage}" currentPage="${pager.pageNum}"></div>
						
							</div>
			            <form  id="pagerForm" action="layoutNotice.action" onsubmit="return divSearch(this, 'layout2');" >
						    <input type="hidden" name="pageNum" value="1" />                  <!--onsubmit="return divSearch(this, 'jbsxBox');" stationOrRoute.action -->
							<input type="hidden" name="numPerPage" value="${pager.numPerPage}" />
			              </form>
			 </div>
 

	 
	</div>
	
	
</div>


	

