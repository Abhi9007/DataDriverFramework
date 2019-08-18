package com.TCS.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.TCS.utilities.ExcelReader;
public class testBase {
/*
 * WebDriver
 * Properties
 * logs
 * Extent Report
 * DB connection
 * Excel reading
 * Mail 
 */
	public static WebDriver driver;//reference variable
	public static Properties config = new Properties();//Object
 	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testData.xlsx");
	@BeforeSuite
	public void setUp() {
		if(driver==null) {
			 try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				try {
					OR.load(fis);
					log.debug("OR Loaded!!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					config.load(fis);
					log.debug("Config Loaded!!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*
				 * Intialization of chrome driver
				 */
				if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Desktop\\New Framework2\\DataDrivenFramework\\src\\test\\resources\\executables\\chromedriver.exe");
					driver = new ChromeDriver();
					log.debug("Chrome Driver Loaded!!");
				}
				
				driver.get(config.getProperty("testSiteURL"));
				log.debug("Launched URL");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitely.wait")), TimeUnit.SECONDS);
		}
	}
	
	public boolean isDisplay(By by) {
		
		try {
			driver.findElement(by);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public void hardWait(int n) {
		try {
			Thread.sleep(1000*n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void tearDown() {
		if(driver!=null) {
		driver.quit();
		}
	}
}
