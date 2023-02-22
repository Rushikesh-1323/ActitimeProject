package com.Actitime.Testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert2 {
	
	//soft assert
	
	@Test
	public void demoassertion() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String expectedtitle = "soogle";
		String actualtitle = driver.getTitle();
		
		SoftAssert s = new SoftAssert();
		s.assertEquals(expectedtitle, actualtitle);
		driver.close();
		
		s.assertAll();
	}

}
