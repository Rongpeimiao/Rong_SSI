package com.rong.ssi.common;
/**
 * @author 容培淼
 * @data  20180410
 * 分页工具类
 */
public class Pager {

   private  Integer pageNum;
   private  Integer  numPerPage;
   private  Integer  total;
   
 public Pager(Integer pageNum,Integer  numPerPage,Integer  total) {
	 if(null==pageNum){
		 this.pageNum=1;
	 }else{
		 this.pageNum=pageNum;
	 }
	  if(null==numPerPage){
		  this.numPerPage=10;
	  }else{
		  this.numPerPage=numPerPage;
	  }
	  this.total=total;
}

public Integer getPageNum() {
	return pageNum;
}

public void setPageNum(Integer pageNum) {
	this.pageNum = pageNum;
}

public Integer getNumPerPage() {
	return numPerPage;
}

public void setNumPerPage(Integer numPerPage) {
	this.numPerPage = numPerPage;
}

public Integer getTotal() {
	return total;
}

public void setTotal(Integer total) {
	this.total = total;
}



   
}

