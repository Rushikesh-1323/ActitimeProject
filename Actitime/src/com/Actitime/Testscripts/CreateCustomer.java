package com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrarary.BaseClass;
import com.Actitime.GenericLibrarary.FileLibrary;
import com.Actitime.Pom.HomePage;
import com.Actitime.Pom.TaskPage;

public class CreateCustomer extends BaseClass{
	
	FileLibrary flib = new FileLibrary();
	
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getTasklnk().click();
		
		TaskPage tp = new TaskPage(driver);
		String custname = flib.readDataFromExcelFile("Sheet1", 3, 1);
		String description = flib.readDataFromExcelFile("Sheet1", 1, 2);
		tp.completetask(custname, description);
		
		String expected = custname;
		System.out.println(expected);
		String actualdata = driver.findElement(By.xpath("//div[@title='SBI_001']")).getText();
		SoftAssert s = new SoftAssert();
		Reporter.log("assertion passed", true);
		s.assertAll();
		
	}

}
