package com.rong.ssi.common;

import org.apache.log4j.Logger;

public class Log4jUtil
{
  public static final void Log4jUtilThrowable(String classStr, Object e)
  {
    Logger logger = Logger.getLogger(classStr);
    logger.info(classStr, (Throwable)e);
  }
}
