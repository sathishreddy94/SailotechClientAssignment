package com.sailotech.pricecompare;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonPriceForIphone {

	WebDriver driver;
	ObjectRepositoryPriceCompare objectRepositoryPriceCompare=new ObjectRepositoryPriceCompare(driver);
	
	public int getAmazonIphonePrice(WebDriver driver) throws InterruptedException {

		ObjectRepositoryPriceCompare objectRepositoryPriceCompare =new ObjectRepositoryPriceCompare(driver);
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		
		//launhc to Amazon website
		driver.get(objectRepositoryPriceCompare.amazonUrl);
		objectRepositoryPriceCompare.AmazonSearch.sendKeys("iPhone XR 64GB yellow"); //Searching mobile
		
		action.sendKeys(Keys.ENTER).perform();
		
		String costInAmazon= objectRepositoryPriceCompare.amazonPrice.getText(); //Fetching the price of mobile
		System.out.println("iPhone XR 64GB Price in Amazon - "+ costInAmazon);
		String[] splitA = costInAmazon.split(","); //Removing unnecessary , symbol
		String iPhonePrice = splitA[0] + "" + splitA[1];
		int iphoneXRCostAmazon = Integer.parseInt(iPhonePrice);
		System.out.println("iPhone XR 64GB Price in Amazon - "+ iphoneXRCostAmazon);
		return iphoneXRCostAmazon;

	}
}
