package com.rong.ssi.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class AjaxUtil {

	public AjaxUtil() {
		// TODO Auto-generated constructor stub
	}
	//response返回ajax请求结果
	  public static final void responseOutWithJsonAjax(String str)
	  {
	    HttpServletResponse response = ServletActionContext.getResponse();
	    String responseObject = str;
	    response = ServletActionContext.getResponse();
	    response.setCharacterEncoding("UTF-8");
	    //response.setContentType("application/json-default; charset=utf-8");//res.setContentType("text/html;charset=UTF-8"); 
	    response.setContentType("text/html; charset=utf-8");
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
	  
	  public static String listToString(List<String> list){
			 
		   if(list==null){
		      return null;
		   }
		 
		   StringBuilder result = new StringBuilder();
		   boolean first = true;
		 
		   //第一个前面不拼接","
		   for(String string :list) {
		      if(first) {
		         first=false;
		      }else{
		         result.append(",");
		      }
		      result.append(string);
		   }
		   return result.toString();
		}
	public static String listObjectToString(List<Object> list){
		 
		   if(list==null){
		      return null;
		   }
		 
		   StringBuilder result = new StringBuilder();
		   boolean first = true;
		 
		   //第一个前面不拼接","
		   for(Object ob :list) {
		      if(first) {
		         first=false;
		      }else{
		         result.append("/");
		      }
		      JSONObject objson = JSONObject.fromObject(ob);
		      result.append(objson);
		   }
		   System.out.println(result.toString());
		   /* 
	   		//1、使用JSONObject
	           JSONObject json = JSONObject.fromObject(stu);
	           //2、使用JSONArray
	           JSONArray array=JSONArray.fromObject(stu);
           */
		   return result.toString();
		}
	
	/*
	<script type="text/javascript">
		$.ajax({
		    type: "POST",
		 	url:"homeNotice.action",
			data:"",
			cache: false,
			dataType:"text",
			success: function(msg){
				// alert( "Data Saved: " + msg );
				 var arr=new Array();
				 //可以用字符或字符串分割
				 arr=msg.split('/');
				 for(var i=0;i<arr.length;i++){
					 var json=JSON.parse(arr[i]);
					 //alert( "userName=" + json["userName"] );  //获取json对象里面的值的方式 
					 alert( "userName=" + json.userName);        //获取json对象里面的值的方式 
				    
				    // $("#tablejbsxBox").html('<tr target="sid_obj" rel="1"><td>'+json.userName+'</td><td>bj0001</td><td>xxx</td><td>2011-9-6</td><td>xxx</td><td>1</td></tr>');
				  }
			   }
		});
	</script>
	*/
}
