package com.rong.ssi.common;

import org.apache.log4j.Logger;
/**
 * @author �����
 * @data  20180410
 * �ռǴ�ӡLog4������
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
