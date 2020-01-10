package com.sailotech.pricecompare;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartPriceForIphone {

	
	// to check same product price in flipkart
	public int getFlipkartIphonePrice(WebDriver driver) throws InterruptedException {

		ObjectRepositoryPriceCompare objectRepositoryPriceCompare =new ObjectRepositoryPriceCompare(driver);
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		
		//launch to Flipkart website
		driver.get(objectRepositoryPriceCompare.flipkartUrl);
		
		//it will close the login popup
		action.sendKeys(Keys.ESCAPE).perform();	
		objectRepositoryPriceCompare.FlipkartSearch.sendKeys("iPhone XR 64GB yellow"); //Searching mobile
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		String costInFlipkart= objectRepositoryPriceCompare.flipkartPrice.getText(); //Fetching the price of mobile
		System.out.println("iPhone XR 64GB cost in Flipkart - "+ costInFlipkart);
		
		//by doing splitting removing char charcaters
		String[] splitF = costInFlipkart.split(",|\\₹");
		String iPhonePrice = splitF[1] + "" + splitF[2]; 
		int iphoneXRCostFlipkart = Integer.parseInt(iPhonePrice);
		System.out.println("iPhone XR 64GB cost in Flipkart - "+ iphoneXRCostFlipkart);
		return iphoneXRCostFlipkart;
	}
}