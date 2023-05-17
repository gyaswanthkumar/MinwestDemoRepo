package log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logutil {
	Logger log=LogManager.getLogger(Logutil.class);
	public void info(String msg)
	{
		log.info(msg);
	}

}
