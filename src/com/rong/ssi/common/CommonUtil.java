package com.rong.ssi.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * @author 容培淼
 * 常用工具类
 */
public class CommonUtil
{
	//MD5Util字符串加密
  public static final String MD5Util(String s)
  {
    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    try
    {
      byte[] btInput = s.getBytes();
      
      MessageDigest mdInst = MessageDigest.getInstance("MD5");
      
      mdInst.update(btInput);
      
      byte[] md = mdInst.digest();
      
      int j = md.length;
      char[] str = new char[j * 2];
      int k = 0;
      for (int i = 0; i < j; i++)
      {
        byte byte0 = md[i];
        str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
        str[(k++)] = hexDigits[(byte0 & 0xF)];
      }
      return new String(str);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }
  //main测试

  
  
  
  //上传文件   
  public static final boolean upload(String pathFile, File filePream, String name)
    throws Exception
  {
    try
    {
      String path = pathFile;
      InputStream is = new FileInputStream(filePream);
      File file = new File(path);
      if (!file.exists()) {
        file.mkdirs();
      }
      File toFile = new File(path, name);
      OutputStream os = new FileOutputStream(toFile);
      byte[] buffer = new byte[1024];
      int length = 0;
      while ((length = is.read(buffer)) > 0) {
        os.write(buffer, 0, length);
      }
      is.close();
      os.close();
      return true;
    }
    catch (Exception e)
    {
      Log4jUtil.Log4jUtilThrowable(new java.lang.Throwable().getStackTrace()[1].getClassName(), e);
    }
    return false;
  }
  
  
  
	//调用其他的可执行文件，例如：自己制作的exe，或是 下载 安装的软件.  
	public static void openExe() {  
	   final Runtime runtime = Runtime.getRuntime();  
	   Process process = null;  
	 
	   try {  
	       process = runtime.exec("C:\\Users\\Administrator\\Desktop\\3D肺结节\\DICOMViewer.exe");  
	 
	   } catch (final Exception e) {  
	       System.out.println("Error exec!");  
	   }  
	}  
}