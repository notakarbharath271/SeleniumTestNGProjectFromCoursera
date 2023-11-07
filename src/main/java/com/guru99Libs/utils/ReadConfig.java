package com.guru99Libs.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	public static Properties readProperties(String path) throws Exception{
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);		
		return prop;
		
	}

}
