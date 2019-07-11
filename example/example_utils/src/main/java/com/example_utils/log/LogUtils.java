package com.example_utils.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LogUtils {
	private Logger logger;

	public LogUtils(Class<?> clazz) {
		super();
		logger = LoggerFactory.getLogger(clazz);
	}
	
	public void info(String clazzName, String methodName, String paramName, String paramValue) {
		logger.info(String.format("[%s %s] ---------> %s = %s", clazzName, methodName, paramName, paramValue));
	}
}
