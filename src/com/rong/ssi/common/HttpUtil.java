package com.rong.ssi.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

public class HttpUtil {

	public HttpUtil() {
		// TODO Auto-generated constructor stub
	}
	public static final void responseOutWithJson(String str)
	  {
	    HttpServletResponse response = ServletActionContext.getResponse();
	    String str2 = "操作成功";
	    if ("300".equals(str)) {
	      str2 = "操作成功";
	    }
	    String responseObject = "{\"statusCode\":\"" + str + "\",\"message\":\"" + str2 + 
	      "\", \"navTabId\":\"\", \"rel\":\"\",\"callbackType\":\"closeCurrent\",\"forwardUrl\":\"\"}";
	    response = ServletActionContext.getResponse();
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("application/octet-stream; charset=utf-8");
	    PrintWriter out = null;
	    try
	    {
	      out = response.getWriter();
	    }
	    catch (IOException e)
	    {
	      Log4jUtil.Log4jUtilThrowable(new java.lang.Throwable().getStackTrace()[1].getClassName(), e);
	    }
	    out.append(responseObject.toString());
	  }
	  
	  public static final void responseOutWithJsonAjax(String str)
	  {
	    HttpServletResponse response = ServletActionContext.getResponse();
	    String responseObject = str;
	    response = ServletActionContext.getResponse();
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json-default; charset=utf-8");
	    PrintWriter out = null;
	    try
	    {
	      out = response.getWriter();
	    }
	    catch (IOException e)
	    {
	      Log4jUtil.Log4jUtilThrowable(new java.lang.Throwable().getStackTrace()[1].getClassName(), e);
	    }
	    out.append(responseObject.toString());
	  }
	  
	  public static final void responseOutWithApp(Object responseObject)
	  {
	    HttpServletResponse response = ServletActionContext.getResponse();
	    JSONObject responseJSONObject = JSONObject.fromObject(responseObject);
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json; charset=utf-8");
	    PrintWriter out = null;
	    try
	    {
	      out = response.getWriter();
	      out.append(responseJSONObject.toString());
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	    finally
	    {
	      if (out != null) {
	        out.close();
	      }
	    }
	  }
}
