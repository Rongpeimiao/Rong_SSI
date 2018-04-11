package com.rong.ssi.common;

import org.apache.log4j.Logger;
/**
 * @author 容培淼
 * @data  20180410
 * 日记打印Log4工具类
 * 
 */
public class Log4jUtil
{
  public static final void Log4jUtilThrowable(String classStr, Object e)
  {
    Logger logger = Logger.getLogger(classStr);
    logger.info(classStr, (Throwable)e);
  }
}
