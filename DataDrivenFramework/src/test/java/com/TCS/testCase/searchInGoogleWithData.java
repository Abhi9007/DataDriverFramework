package com.TCS.testCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TCS.base.testBase;

public class searchInGoogleWithData extends testBase{

	
	@Test(dataProvider="getData")
	public void searchGoogle(String searchText) {
		log.debug("Going to search!!");
		driver.findElement(By.xpath(OR.getProperty("searchBox"))).sendKeys(searchText);
		hardWait(3);
	}
	@DataProvider
	public Object[][] getData(){
		String sheetName = "searchInGoogleWithData";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for(int rowNum = 2; rowNum<=rows;rowNum++) {
			for(int colNum=0;colNum<cols; colNum++) {
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}
	
}
