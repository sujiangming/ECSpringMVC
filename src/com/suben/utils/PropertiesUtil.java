package com.suben.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * PropertiesUtil.java
 *
 * @desc properties 资源文件解析工具
 * @author Guoxp
 * @datatime Apr 7, 2013 3:58:45 PM
 *
 */
public class PropertiesUtil {

	private Properties props;

	public PropertiesUtil() {

	}

	public static String getProperty(String propertiesFileName, String key) {
		Properties props = new Properties();
		try {
			props.load(PropertiesUtil.class.getResourceAsStream("/configs/" + propertiesFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (String) props.get(key);
	}

	/**
	 * 获取某个属性
	 */
	public String getProperty(String key) {
		return props.getProperty(key);
	}

	/**
	 * 在控制台上打印出所有属性，调试时用。
	 */
	public void printProperties() {
		props.list(System.out);
	}

	public static void main(String[] args) {
		System.out.println(PropertiesUtil.getProperty("photoSaveUrl.properties", "savePicUrl"));
	}
}