package day4;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class PepperFry {
	
	public static void takeScreenshot(WebElement element,String eleName) throws IOException{

		File source = element.getScreenshotAs(OutputType.FILE);

		File target = new File("./snaps/" +eleName + ".png");

		FileUtils.copyFile(source, target);
	}
	
	
	
	

	public static void main(String[] args) throws InterruptedException, IOException
	{
	
	           //  TO LAUNCH GOOGLE CHROME BROWSER APPLICATION THROUGH CODE
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				
				// TO DISABLE CHROME BROWSER NOTIFICATIONS
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				
				// CREATING OBJECT FOR THE CLASS CHROME DRIVER
				
				
				ChromeDriver driver = new ChromeDriver(options);
				
				// DELETE ALL THE COOKIES IN THE WEBPAGE
				driver.manage().deleteAllCookies();
				
				// GET THE URL OF THE WEB PAGE TO BE AUTOMATED
				driver.get("https://www.pepperfry.com/");
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//MAXIMIZE THE WEBPAGE
				driver.manage().window().maximize();
				
			// CLOSE THE OFFERS WINDOW
				//driver.findElementByXPath("//div[@id='regPopUp']").click();
				
			// CLOSE THE POP UP UPTO 50% WINDOW
			     //driver.findElementByXPath("//div[@id='webklipper-publisher-widget-container-notification-close-div']").click();
			     
			 //MOUSE OVER ON FURNITURE
			     WebElement Furniture = driver.findElementByXPath("//li//a[text()='Furniture']");
			     
			// USE ACTIONS CLASS TO MOUSE OVER ON FURNITURES
			     
			     Actions builder = new Actions(driver);
			     Thread.sleep(3000);
			     builder.moveToElement(Furniture).build().perform();
			     
			 //CLICK OFFICE CHAIRS
			   driver.findElementByXPath("(//div//a[text()='Office Chairs'])[1]").click();
			   
			 // CLICK EXECUTIVE CHAIRS
			  WebElement ExecutiveChairs = driver.findElementByXPath("//img[@alt='Executive Chairs']");
			  
			  Actions builder1 = new Actions(driver);
			  Thread.sleep(3000);
			  builder1.moveToElement(ExecutiveChairs).click(ExecutiveChairs).perform();
			  
			  JavascriptExecutor jse = (JavascriptExecutor)driver;
		       jse.executeScript("window.scrollBy(0,250)", "");
			  
			  // CHANGE THE MINIMUM HEIGHT AS 50 IN UNDER DIMENSIONS
			  WebElement dimensions = driver.findElementByXPath("//input[@class='clipFilterDimensionHeightValue']");
			  
			 dimensions.clear();
			 dimensions.sendKeys("50");
			 dimensions.sendKeys(Keys.ENTER);
			 
			 Thread.sleep(3000);
			 
			 // ADD POISE EXECUTIVE CHAIR BLACK COLOUR TO ADD TO WISHLIST
			 
			 driver.findElementByXPath("(//a[@id='clip_wishlist_'])[6]").click();
			 
			 
			 

			 // MOUSE OVER ON FURNITURE
			 
			 jse.executeScript("window.scrollBy(0,-10000)");
			 
			 Actions builder5 = new Actions(driver);

				driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");

				//closing the image
				WebElement image = driver.findElementByXPath("//div[@id='webklipper-publisher-widget-container-notification-close-div']");

				builder5.moveToElement(image).click(image).perform();

				Thread.sleep(3000);


				//switching back to parent frame
				driver.switchTo().defaultContent();
			 
			 
			 driver.findElementByXPath("//div[@id='regPopUp']/a").click();

				Thread.sleep(2000);

			
			 		 
			 
			//MOUSE OVER ON FURNITURE
		     WebElement Furnitures = driver.findElementByXPath("//li//a[text()='Furniture']");
		 
		  // USE ACTIONS CLASS TO MOUSE OVER ON FURNITURES
		     
		     Actions builder2 = new Actions(driver);
		     Thread.sleep(3000);
		     builder2.moveToElement(Furnitures).build().perform();
		     
		  // CLICK OFFICE TABLES
		     driver.findElementByXPath("//a[text()='Office Tables']").click();
		     
		    // SELECT EXECUTIVE DESKS
		     
		    WebElement ExecutiveDesks = driver.findElementByXPath("//img[@alt='Executive Desks']");
		    Actions builder3 = new Actions(driver);
		    builder3.moveToElement(ExecutiveDesks).click(ExecutiveDesks).perform();
		    
		    // SELECT PRICE BETWEEN 20,000 TO 40,000
		    
		   driver.findElementByXPath("//label[@for='price20000-40000']").click();
		   Thread.sleep(3000);
		   
		   //ADD EXECUTIVE OFFICE TABLE IN BROWN COLOUR TO WISHLIST
	       driver.findElementByXPath("(//a[@class='clip-heart-icn pf-right'])[1]").click();
		   
		   //HOW TO VERIFY THE NUMBER OF ITEMS IN THE WISHLIST
	       //Take the webelement xpath and store it in a variable. 
	       // 
	       
	       String WishlistCount = driver.findElementByXPath("//div[@class='wishlist_bar']//span[@class='count_alert']").getText();
	       
	    	System.out.println("WishlistCount is:"+WishlistCount);	   
	    	
	    	if(WishlistCount.contains("2"))
	    	{
	    		System.out.println("Wishlist Items verified");
	    		
	    	}
	    	
	    	else
	    	{
	    		System.out.println("Wishlist items not verified");
	    	}
	       
	       // NAVIGATE TO WISHLIST
	    	
	    	WebElement WishlistIcon = driver.findElementByXPath("//div[@class='wishlist_bar']//a[@data-tooltip='Wishlist']");
	    	
	       Actions builder4  = new Actions(driver);
	       builder4.moveToElement(WishlistIcon).click(WishlistIcon).perform();
	       Thread.sleep(3000);
	       
	       //GET THE OFFERPRICE AND COUPON CODE FOR THE BROWN COLOUR ONLY TO CART FROM WISHLIST
	       
	       String OfferPrice = driver.findElementByXPath("(//p[@class='oprice']//span[@class='txt-green'])[1]").getText();
	       
	       String CouponCode = driver.findElementByXPath("(//p[@class='pf-border pf-border-lighter-grey-50 pf-border-style-dashed pf-center pf-padding-tiny font-14 pf-italic-txt pf-text-grey pf-margin-top use-coupon']//strong)[1]").getText();
	       
	       System.out.println(CouponCode);
	       
	       // MOVE EXECUTIVE OFFICE TABLE IN BROWN COLOUR ONLY TO CART FROM WISHLIST
	       
	       driver.findElementByXPath("(//a[@class='addtocart_icon']//i)[1]").click();
	       
	       // CHECK FOR THE AVAILABILITY OF THE PINCODE 600128
	       
	     driver.findElementByXPath("//input[@class='srvc_pin_text']").sendKeys("600128");
	       
	      // CLICK CHECK BUTTON
	       
	      driver.findElementByXPath("//a[text()='Check']").click();
	      
	      Thread.sleep(3000);
	      
	      // CLICK ON PROCEED TO PAY SECURELY FROM MY CART
	      
	      driver.findElementByXPath("//div[@class='minicart_footer']//a").click();
	      
	      //ENTER THE COUPON CODE
	      
	      driver.findElementByXPath("//input[@id='coupon_code']").sendKeys(CouponCode);
	      
	      //CLICK TO APPLY
	      
	      driver.findElementByXPath("//input[@id='cpn_check_btn']").click();
	      
	      //CAPTURE THE SCREENSHOT OF THE ITEM UNDER ORDER SUMMARY
	      
	      driver.findElementByXPath("(//div[@class='nCheckout__accrodian-header-right']//span)[1]").click();

			Thread.sleep(2000);

			WebElement orderimage = driver.findElementByXPath("//li[@role='option']//figure//img ");

			takeScreenshot(orderimage, "orderimage");

			Thread.sleep(2000);
			
			//CLOSE THE BROWSER
			driver.close();
	      
	      
	       
	      
	 
	 
	       
		   
	       
		  
	
	
	
	}

}
