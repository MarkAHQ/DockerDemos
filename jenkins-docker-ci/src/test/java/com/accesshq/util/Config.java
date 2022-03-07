package com.accesshq.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	
	public static final String RUN_TYPE;
	public static final String BROWSER;
	public static final String APP_URL;
	public static final String HUB_URL;
	public static final Long IMPLICIT_WAIT_SECONDS;
	
	static {
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties props = new Properties();
		try(InputStream resourceStream = loader.getResourceAsStream("app.properties")) {
		    props.load(resourceStream);
		} catch (IOException e) {
			System.err.println("Unable to load config.properties");
			e.printStackTrace();
		} 
		
		RUN_TYPE = props.getProperty("run-type");
		BROWSER = props.getProperty("browser");
		IMPLICIT_WAIT_SECONDS = Long.parseLong(props.getProperty("implicit-wait-seconds"));
		APP_URL = props.getProperty("app-url");
		HUB_URL = props.getProperty("hub-url");;
		
	}
	
}


