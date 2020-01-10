package com.sailotech.pricecompare;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjectRepositoryPriceCompare {

	WebDriver driver;

	ObjectRepositoryPriceCompare(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String amazonUrl="https://www.amazon.in/";
	String flipkartUrl="https://www.flipkart.com/";
	
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement AmazonSearch;
	
	@FindBy(className="a-price-whole")
	WebElement amazonPrice;

	@FindBy(className = "LM6RPg")
	WebElement FlipkartSearch;
	
	@FindBy(xpath = "//*[@id='container']/div/div[3]/div[2]/div/div[2]/div[2]/div/div/div/a/div[2]/div[2]/div/div/div")
	WebElement flipkartPrice;

	
}
