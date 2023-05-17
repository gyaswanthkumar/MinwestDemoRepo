package com.minnwest.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Util{
	
	Logger logger=LogManager.getLogger(Log4j2Util.class);
	
	public void info(String msg)
	{
		logger.info(msg);
	}
	public void debug(String msg)
	{
		logger.atDebug();
	}
	
	
}
