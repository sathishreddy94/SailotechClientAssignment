package com.sailotech.pricecompare;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PriceCompare {

	public WebDriver driver;
	AmazonPriceForIphone amazonprice=new AmazonPriceForIphone();
	FlipkartPriceForIphone flipkartprice =new FlipkartPriceForIphone();
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//sathish.raghuram//Downloads//chromDriverlatest//chromedriver.exe"); //Selecting chrome driver from local system
		driver = new ChromeDriver();
	}
	
	@Test
	public void comparePrice() throws InterruptedException {
		
		int amazonRate = amazonprice.getAmazonIphonePrice(driver);
		int flipkartRate = flipkartprice.getFlipkartIphonePrice(driver);

		//comparing price from both the websites
		if(flipkartRate < amazonRate){
			System.out.println("iPhone XR 64GB Price is less in Flipkart when compared to Amazon price. You can shop in Flipkart");
		}else{
			System.out.println("iPhone XR 64GB Price is less in Amazon when compared to Flipkart price. You can shop in Amazon");
		}
		driver.close();
	}

}