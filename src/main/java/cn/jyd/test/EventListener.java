package cn.jyd.test;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("eventListener")
public class EventListener {

	private static Logger logger = Logger.getLogger(EventListener.class);

	public void getMessage(String message, String channel) {
		logger.info(message);
	}
}
