package com.rong.ssi.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * @author 容培淼
 * http 工具类
 */
public class HttpUtil {

	public HttpUtil() {
		// TODO Auto-generated constructor stub
	}
	
	//response返回dwz请求结果
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
	//response返回ajax请求结果
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
		//response返回app的http请求结果
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
	  
	  
	  
		 public static final void responseOutMapWithjsonp(Map<String,Object> map){
				 HttpServletResponse response = ServletActionContext.getResponse();
				 HttpServletRequest request=ServletActionContext.getRequest();
				 PrintWriter out = null;       
			  try {  
			        response.setContentType("text/plain");  
			        response.setHeader("Pragma", "No-cache");  
			        response.setHeader("Cache-Control", "no-cache");  
			        response.setDateHeader("Expires", 0);  
			        out = response.getWriter();     
			        JSONObject resultJSON = JSONObject.fromObject(map); //根据需要拼装json  
			        String jsonpCallback = request.getParameter("jsonpCallback");//客户端请求参数  
			        out.println(jsonpCallback+"("+resultJSON.toString(1,1)+")");//返回jsonp格式数据  
			        out.flush();  
			      } catch (IOException e) {  
			       e.printStackTrace();  
			      }  
				 finally
				    {
				      if (out != null) {
				        out.close();
				      }
				    }
		  }
		 public static final void responseOutObjectWithjsonp(Object obj){
			 HttpServletResponse response = ServletActionContext.getResponse();
			 HttpServletRequest request=ServletActionContext.getRequest();
			 PrintWriter out = null;       
		  try {  
		        response.setContentType("text/plain");  
		        response.setHeader("Pragma", "No-cache");  
		        response.setHeader("Cache-Control", "no-cache");  
		        response.setDateHeader("Expires", 0);  
		        out = response.getWriter();     
		        JSONObject resultJSON = JSONObject.fromObject(obj); //根据需要拼装json  
		        String jsonpCallback = request.getParameter("jsonpCallback");//客户端请求参数  
		        out.println(jsonpCallback+"("+resultJSON.toString(1,1)+")");//返回jsonp格式数据  
		        out.flush();  
		      } catch (IOException e) {  
		       e.printStackTrace();  
		      }  
			 finally
			    {
			      if (out != null) {
			        out.close();
			      }
			    }
	  }
		 public static final void responseOutListWithjsonp(Object obj){
			 HttpServletResponse response = ServletActionContext.getResponse();
			 HttpServletRequest request=ServletActionContext.getRequest();
			 PrintWriter out = null;       
		  try {  
		        response.setContentType("text/plain");  
		        response.setHeader("Pragma", "No-cache");  
		        response.setHeader("Cache-Control", "no-cache");  
		        response.setDateHeader("Expires", 0);  
		        out = response.getWriter();     
		        JSONArray resultJSONArray = JSONArray.fromObject(obj);  //根据需要拼装json  
		        String jsonpCallback = request.getParameter("jsonpCallback");//客户端请求参数  
		        out.println(jsonpCallback+"("+resultJSONArray.toString(1,1)+")");//返回jsonp格式数据  
		        out.flush();  
		      } catch (IOException e) {  
		       e.printStackTrace();  
		      }  
			 finally
			    {
			      if (out != null) {
			        out.close();
			      }
			    }
	  }
		 
		 
		 	/*
		 	 // jquery 使用ajax jsonp：jsonpCallback定义的参数要与方法中的一致；
		 	 $.ajax({  
		        type : "get",  
		        async:false,  
		        url : "homeNotice.action",  
		        dataType : "jsonp",//数据类型为jsonp  
		        jsonp: "jsonpCallback",//服务端用于接收callback调用的function名的参数  
		        success : function(data){  
		        	alert("Result:"+data)  
		        	alert("Result:"+data.passeds)  
		        	
		        	 //for(var i=0;i<data.length;i++){   //obj 为list<业务对象类> list
					 //alert("Result:"+data[i].passeds );//JSONArray resultJSONArray = JSONArray.fromObject(obj);  //根据需要拼装json  
				     // }
		        },  
		        error:function(){  
		            alert('fail');  
		        }  
		    });
		    
		    
		        //可传入参数,回调方法foo  
				function foo(data){
				        //处理data数据
				}
				$.getJSON('http://www.a.com/user?id=123&callback=foo');//
		     */
}
