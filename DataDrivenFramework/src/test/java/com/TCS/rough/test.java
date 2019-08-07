package com.TCS.rough;

import java.io.FileInputStream;
import java.util.Properties;

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
   Properties OR = new Properties();
   FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
	OR.load(fis);
	System.out.println(OR.getProperty("searchBox"));
	}

}
