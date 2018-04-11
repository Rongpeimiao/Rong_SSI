package com.rong.ssi.quartz.serviceImpl;


import java.util.Map;

import com.rong.ssi.quartz.dto.Pager;
import com.rong.ssi.quartz.service.CommonJobServiceInter;
import com.rong.ssi.quartz.service.CommonServiceInter;

/**      
 * @author 容培淼      
 * quartz公共服务类   
 */ 
public class CommonJobServiceImpl implements CommonJobServiceInter {

	public CommonJobServiceImpl() {
	}
	private  Pager pager;
	private Integer numPerPage;
	private Integer pageNum;
	private  CommonServiceInter commonServiceInter;
	


	public CommonServiceInter getCommonServiceInter() {
		return commonServiceInter;
	}


	public void setCommonServiceInter(CommonServiceInter commonServiceInter) {
		this.commonServiceInter = commonServiceInter;
	}


	public Pager getPager() {
		return pager;
	}

	public Integer getNumPerPage() {
		return numPerPage;
	}

	public Integer getPageNum() {
		return pageNum;
	}




	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public void setNumPerPage(Integer numPerPage) {
		this.numPerPage = numPerPage;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}



	@Override
	public void quartzJob() {
		System.out.println("this is quartzJob");
	}
	 
	  public static void main(String[] args) {
		  System.out.println("this is quartzJob");
	  }
}
