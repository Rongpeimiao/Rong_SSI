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

  
  //yyy-MM-dd 字符串类型转时间类型
  public static final String dataToString1(Date date)
  {
    String dateStr = null;
    if ((date != null) && (!"".equals(date)))
    {
      DateFormat df = new SimpleDateFormat("yyy-MM-dd");
      dateStr = df.format(date);
    }
    return dateStr;
  }
  //时间类型转yyy-MM-dd 字符串类型
  public static final Date StringToDate11(String str)
  {
    DateFormat df = new SimpleDateFormat("yyy-MM-dd");
    Date date = null;
    try
    {
      if ((str != null) && (!"".equals(str))) {
        try
        {
          date = df.parse(str);
        }
        catch (java.text.ParseException e)
        {
          e.printStackTrace();
        }
      }
    }
    catch (com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException e)
    {
      Log4jUtil.Log4jUtilThrowable(new java.lang.Throwable().getStackTrace()[1].getClassName(), e);
    }
    return date;
  }
  //yyy-MM-dd hh:mm 字符串类型转时间类型
  public static final Date StringToDate12(String str)
  {
    DateFormat df = new SimpleDateFormat("yyy-MM-dd hh:mm");
    Date  date = null;
    try
    {
      if ((str != null) && (!"".equals(str))) {
        try
        {
          date = df.parse(str);
        }
        catch (java.text.ParseException e)
        {
          e.printStackTrace();
        }
      }
    }
    catch (com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException e)
    {
      Log4jUtil.Log4jUtilThrowable(new java.lang.Throwable().getStackTrace()[1].getClassName(), e);
    }
    return date;
  }
  //yyyMMddHHmmss 字符串类型转时间类型
  public static final String dataToString2(Date date)
  {
    String dateStr = null;
    if ((date != null) && (!"".equals(date)))
    {
      DateFormat df = new SimpleDateFormat("yyyMMddHHmmss");
      dateStr = df.format(date);
    }
    return dateStr;
  }
//时间类型转yyyMMddHHmmss 字符串类型
  public static final Date StringToDate2(String str)
  {
    DateFormat df = new SimpleDateFormat("yyyMMddHHmmss");
    Date  date = null;
    try
    {
      if ((str != null) && (!"".equals(str))) {
        try
        {
          date = df.parse(str);
        }
        catch (java.text.ParseException e)
        {
          e.printStackTrace();
        }
      }
    
    }
    catch (com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException e)
    {
      Log4jUtil.Log4jUtilThrowable(new java.lang.Throwable().getStackTrace()[1].getClassName(), e);
    }
    return date;
  }
//yyyy-MM-dd HH:mm:ss 字符串类型转时间类型
  public static final String dataToString3(Date date)
  {
    String dateStr = null;
    if ((date != null) && (!"".equals(date)))
    {
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      dateStr = df.format(date);
    }
    return dateStr;
  }
//时间类型转yyyy-MM-dd HH:mm:ss 字符串类型
  public static final Date StringToDate(String str)
  {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date  date = null;
    try
    {
      if ((str != null) && (!"".equals(str))) {
        try
        {
          date = df.parse(str);
        }
        catch (java.text.ParseException e)
        {
          e.printStackTrace();
        }
      }
     
    }
    catch (com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException e)
    {
      Log4jUtil.Log4jUtilThrowable(new java.lang.Throwable().getStackTrace()[1].getClassName(), e);
    }
    return date;
  }
//yyyy-MM-dd HH:mm:ss 字符串类型转时间类型
  public static final Date StringToDate3(String str)
  {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date   date = null;
    try
    {
      if ((str != null) && (!"".equals(str))) {
        try
        {
          date = df.parse(str);
        }
        catch (java.text.ParseException e)
        {
          e.printStackTrace();
        }
      }
    
    }
    catch (com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException e)
    {
      Log4jUtil.Log4jUtilThrowable(new java.lang.Throwable().getStackTrace()[1].getClassName(), e);
    }
    return date;
  }
  //两个时间相差的天数
  public static int daysBetween(Date smdate, Date bdate)
    throws com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException, java.text.ParseException
  {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    smdate = sdf.parse(sdf.format(smdate));
    bdate = sdf.parse(sdf.format(bdate));
    Calendar cal = Calendar.getInstance();
    cal.setTime(smdate);
    long time1 = cal.getTimeInMillis();
    cal.setTime(bdate);
    long time2 = cal.getTimeInMillis();
    long between_days = (time2 - time1) / 86400000L;
    
    return Integer.parseInt(String.valueOf(between_days));
  }
  //传入时间增加num天返回结果
  public static final Date dateAddNum(Date date, int num)
  {
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(date);
    calendar.add(5, num);
    date = calendar.getTime();
    return date;
  }
  
  public static final String amountTotal(String a, String b, String c)
  {
    BigDecimal aM = new BigDecimal("0");
    BigDecimal bM = new BigDecimal("0");
    BigDecimal cM = new BigDecimal("0");
    String amountTotal;
    if ((a != null) && (!"".equals(a.toString()))) {
      aM = new BigDecimal(a);
    }
    if ((b != null) && (!"".equals(b))) {
      bM = new BigDecimal(b);
    }
    if ((c != null) && (!"".equals(c))) {
      cM = new BigDecimal(c);
    }
  
    if (bM.equals(new BigDecimal("0")))
    {
      amountTotal = aM.multiply(cM).toString();
    }
    else
    {
      if (aM.equals(new BigDecimal("0"))) {
        amountTotal = bM.multiply(cM).toString();
      } else {
        amountTotal = aM.multiply(cM).add(bM.multiply(cM)).toString();
      }
    }
    return amountTotal;
  }
  
  //Bytes编码Utf
  public static final String getBytesToUtf(String str)
  {
    String strs = null;
    try
    {
      strs = new String(str.getBytes("ISO-8859-1"), "utf-8");
    }
    catch (UnsupportedEncodingException e)
    {
      e.printStackTrace();
    }
    return strs;
  }
  
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
  
  //得到某月份的最后一天
  public static final Date getMonthLastDay(Date createDate)
  {
    Calendar cal = Calendar.getInstance();
    cal.setTime(createDate);
    
    int days = cal.getActualMaximum(5);
    
    cal.set(5, days);
    
    Date newD = cal.getTime();
    
    return newD;
  }
	 public static void main(String[] args) {
		 openExe();
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