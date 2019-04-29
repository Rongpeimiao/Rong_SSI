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
 * @author �����
 * http ������
 */
public class HttpUtil {

	public HttpUtil() {
		// TODO Auto-generated constructor stub
	}
	
	//response����dwz������
	public static final void responseOutWithJson(String str)
	  {
	    HttpServletResponse response = ServletActionContext.getResponse();
	    String str2 = "�����ɹ�";
	    if ("300".equals(str)) {
	      str2 = "�����ɹ�";
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
	//response����ajax������
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
		//response����app��http������
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
			        JSONObject resultJSON = JSONObject.fromObject(map); //������Ҫƴװjson  
			        String jsonpCallback = request.getParameter("jsonpCallback");//�ͻ����������  
			        out.println(jsonpCallback+"("+resultJSON.toString(1,1)+")");//����jsonp��ʽ����  
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
		        JSONObject resultJSON = JSONObject.fromObject(obj); //������Ҫƴװjson  
		        String jsonpCallback = request.getParameter("jsonpCallback");//�ͻ����������  
		        out.println(jsonpCallback+"("+resultJSON.toString(1,1)+")");//����jsonp��ʽ����  
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
		        JSONArray resultJSONArray = JSONArray.fromObject(obj);  //������Ҫƴװjson  
		        String jsonpCallback = request.getParameter("jsonpCallback");//�ͻ����������  
		        out.println(jsonpCallback+"("+resultJSONArray.toString(1,1)+")");//����jsonp��ʽ����  
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
		 	 // jquery ʹ��ajax jsonp��jsonpCallback����Ĳ���Ҫ�뷽���е�һ�£�
		 	 $.ajax({  
		        type : "get",  
		        async:false,  
		        url : "homeNotice.action",  
		        dataType : "jsonp",//��������Ϊjsonp  
		        jsonp: "jsonpCallback",//��������ڽ���callback���õ�function���Ĳ���  
		        success : function(data){  
		        	alert("Result:"+data)  
		        	alert("Result:"+data.passeds)  
		        	
		        	 //for(var i=0;i<data.length;i++){   //obj Ϊlist<ҵ�������> list
					 //alert("Result:"+data[i].passeds );//JSONArray resultJSONArray = JSONArray.fromObject(obj);  //������Ҫƴװjson  
				     // }
		        },  
		        error:function(){  
		            alert('fail');  
		        }  
		    });
		    
		    
		        //�ɴ������,�ص�����foo  
				function foo(data){
				        //����data����
				}
				$.getJSON('http://www.a.com/user?id=123&callback=foo');//
		     */
}
