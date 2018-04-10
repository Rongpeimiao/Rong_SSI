package com.rong.ssi.login.action;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class BaseAction extends ActionSupport {


	private static final long serialVersionUID = 8842233355600065107L;
    	/** 
        * 以JSON格式输出 
        * @param response 
        */  
	   
	protected   HttpServletRequest request = null;    
	protected   HttpServletResponse response = null;  
	protected   HttpSession session=null; 
	protected   String success="success"; 
	protected   String fail="fail"; 
		
		public static HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
		}
		public static HttpServletResponse getResponse() {
			return ServletActionContext.getResponse();
		}
		public static HttpSession getSession() {
			return getRequest().getSession();
		}
}
