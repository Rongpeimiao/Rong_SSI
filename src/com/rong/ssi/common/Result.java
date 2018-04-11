package com.rong.ssi.common;

/**
 * @author 容培淼
 * action接受请求返回结果封装类
 */

public class Result
{
  private String path;
  private String code;
  private String message;
  private String message2;
  private String message3;
  
  public String getMessage2()
  {
    return this.message2;
  }
  
  public void setMessage2(String message2)
  {
    this.message2 = message2;
  }
  
  public String getMessage3()
  {
    return this.message3;
  }
  
  public void setMessage3(String message3)
  {
    this.message3 = message3;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public void setPath(String path)
  {
    this.path = path;
  }
  
  public void setCode(String code)
  {
    this.code = code;
  }
  
  public void setMessage(String message)
  {
    this.message = message;
  }
}
