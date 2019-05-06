package com.rong.ssi.common;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	public DateUtil() {
		// TODO Auto-generated constructor stub
	}
	//yyy-MM-dd �ַ�������תʱ������
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
	  //ʱ������תyyy-MM-dd �ַ�������
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
	  //yyy-MM-dd hh:mm �ַ�������תʱ������
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
	  //yyyMMddHHmmss �ַ�������תʱ������
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
	//ʱ������תyyyMMddHHmmss �ַ�������
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
	//yyyy-MM-dd HH:mm:ss �ַ�������תʱ������
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
	//ʱ������תyyyy-MM-dd HH:mm:ss �ַ�������
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
	//yyyy-MM-dd HH:mm:ss �ַ�������תʱ������
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
	  //����ʱ����������
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
	  //����ʱ������num�췵�ؽ��
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
	  
	  //Bytes����Utf
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
	  
	  
	//�õ�ĳ�·ݵ����һ��
	  public static final Date getMonthLastDay(Date createDate)
	  {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(createDate);
	    
	    int days = cal.getActualMaximum(5);
	    
	    cal.set(5, days);
	    
	    Date newD = cal.getTime();
	    
	    return newD;
	  }
}
