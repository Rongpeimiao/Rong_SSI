package com.rong.ssi.quartz.serviceImpl;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rong.ssi.quartz.dto.Pager;
import com.rong.ssi.quartz.service.CommonJobServiceInter;
import com.rong.ssi.quartz.service.CommonServiceInter;


public class CommonJobServiceImpl implements CommonJobServiceInter {

	public CommonJobServiceImpl() {
	}
	private  Pager pager;
	private Integer numPerPage;
	private Integer pageNum;
	private String motorcoachNumber;
	private Integer allWaybill=1;
	private String	vehicleCode;
	private  CommonServiceInter commonServiceInter;
	

	public String getVehicleCode() {
		return vehicleCode;
	}

	public void setVehicleCode(String vehicleCode) {
		this.vehicleCode = vehicleCode;
	}

	public Integer getAllWaybill() {
		return allWaybill;
	}

	public void setAllWaybill(Integer allWaybill) {
		this.allWaybill = allWaybill;
	}

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


	public String getMotorcoachNumber() {
		return motorcoachNumber;
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


	public void setMotorcoachNumber(String motorcoachNumber) {
		this.motorcoachNumber = motorcoachNumber;
	}


	@Override
	public void quartzJob() {
		System.out.println("this is quartzJob");
	}
	 
	  public static void main(String[] args) {
		  System.out.println("this is quartzJob");
	  }
}
