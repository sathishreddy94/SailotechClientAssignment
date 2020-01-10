package com.sailotech.tripadvisor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClubMahindraReviewWritings {
	
	WebDriver driver;
	ObjectRepositoryTripAdvisor objRepo;
	String tripAdvisorUrl="https://www.tripadvisor.in/";
	String textToSearch = "Club Mahindra";
	String reviewTitle = "My self experience";
	String reviewText = "We had a 3 night stay to enjoy the Prague Christmas Markets, and were very satisfied with every aspect of the hotel. The staff are very friendly, helpful, and knowledgeable regarding places to visit in Prague. The hotel is very clean throughout, and our room was spacious with everything that we needed. Breakfast was substantial, and suited all tastes. The hotel is quiet, and is situated near to numerous restaurants, and a main supermarket, and within easy walking distance from the Christmas Markets. We would highly recommend a stay at this hotel.";
	
	@BeforeClass
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C://Users//sathish.raghuram//Downloads//chromDriverlatest//chromedriver.exe");
		//Initializing Chrome Web Driver
		 driver = new ChromeDriver();
		 objRepo = new ObjectRepositoryTripAdvisor(driver);
		 // to open Trip Advisor site
		driver.get(tripAdvisorUrl);
	}
	
	@Test
	public void test() throws Exception {
		driver.manage().window().maximize();
		long timeout=5;
		driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
		
		//To search hotel 
		objRepo.homeElementSearch.click();
		objRepo.mainContentSearch.sendKeys(textToSearch);
		objRepo.selectFirstContentFromList.click();
		Thread.sleep(2000);
		
		//to click write a review
		objRepo.forReview.click();
		
		//To get current available windows
		List<String> windowHandles=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		
		//to give 5 * ratings by mouse hover
		objRepo.reviewTitle.sendKeys(reviewTitle);
		objRepo.reviewText.sendKeys(reviewText);
		objRepo.typeOfTrip.click();
		Select dropDown = new Select(objRepo.dateOfTrip);
		dropDown.selectByIndex(1);
		
		WebElement ele1 =objRepo.bubbleRating;
	      //Create object 'action' of an Actions class
	      Actions action = new Actions(driver);
	      //Mouseover on an element
	      action.moveToElement(ele1).click(ele1).build().perform();
	      action.moveByOffset(50, 0).click().build().perform();
	        
	      if(driver.getPageSource().contains("Hotel Ratings")){
	    
				WebElement serviceRating = objRepo.firstRowRatings;
				action.moveToElement(serviceRating).click(serviceRating).build().perform();
				action.moveByOffset(50, 0).click().build().perform();
				serviceRating = objRepo.secondRowRatings;
				action.moveToElement(serviceRating).click(serviceRating).build().perform();
				action.moveByOffset(50, 0).click().build().perform();
				serviceRating =objRepo.thirdRowRatings;
				action.moveToElement(serviceRating).click(serviceRating).build().perform();
				action.moveByOffset(50, 0).click().build().perform();
			}else
			{
				System.out.println("Hotel ratings not available");
			}
	        		
	    
	        

		//to click check box
		objRepo.noFraudCheck.click();
	}
}