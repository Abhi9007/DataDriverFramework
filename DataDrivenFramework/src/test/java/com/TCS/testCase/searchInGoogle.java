package com.TCS.testCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TCS.base.testBase;

public class searchInGoogle extends testBase{

	
	@Test
	public void searchGoogle() {
		log.debug("Going to search!!");
		driver.findElement(By.xpath(OR.getProperty("searchBox"))).sendKeys("selenium");
		hardWait(1);
		driver.findElement(By.xpath(OR.getProperty("logo"))).click();
		hardWait(1);
		driver.findElement(By.xpath(OR.getProperty("btnSearch"))).click();
		hardWait(3);
		Assert.assertTrue(isDisplay(By.xpath(OR.getProperty("expectedText"))));
		hardWait(1);
		driver.findElement(By.xpath(OR.getProperty("expectedText"))).click();
		hardWait(10);
	}
}
