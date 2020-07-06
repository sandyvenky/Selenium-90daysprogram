package day3;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MicrosoftAzure {
	
	
	// CREATING A METHOD FOR FILE PATH AND THE FILENAME GLOBALLY SO THAT WE CAN USE THE SAME METHOD IN THE MAIN METHOD
	
	public static void verifyFile(String filename)
	{
		//GIVING OUR SYSTEM FOLDER PATH TO THE FILE 
		File file = new File("C:\\Users\\Sandhya\\Downloads\\"+filename);
		if(file.exists())
		{
			System.out.println("File has been downloaded in the respective folder");
		}
		else
		{
			System.out.println("File has not been downloaded");
		}
		}
	
		public static void main(String[] args) throws InterruptedException
	{

	        //  TO LAUNCH GOOGLE CHROME BROWSER APPLICATION THROUGH CODE
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			
			// TO DISABLE CHROME BROWSER NOTIFICATIONS
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			// CREATING OBJECT FOR THE CLASS CHROME DRIVER
			ChromeDriver driver = new ChromeDriver(options);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			// DELETE ALL THE COOKIES IN THE WEBPAGE
			driver.manage().deleteAllCookies();
			
			// GET THE URL OF THE WEB PAGE TO BE AUTOMATED
			driver.get("https://azure.microsoft.com/en-in/");
			
			//MAXIMIZE THE WEBPAGE
			driver.manage().window().maximize();
			
			//ACTIONS CLASS TO NAVIGATE TO EXAMPLE
			
			Actions builder = new Actions(driver);
			
						
			//CLICK ON PRICING
			driver.findElementByXPath("//li//a[text()='Pricing']").click();
			Thread.sleep(3000);
			
			//CLICK ON PRICING CALCULATOR
			driver.findElementByLinkText("Pricing calculator").click();
			Thread.sleep(3000);
			
			//CLICK ON CONTAINERS
			driver.findElementByXPath("//button[text()='Containers']").click();
			
			Thread.sleep(3000);
			
			//CLICK ON CONTAINER INSTANCES
			driver.findElementByXPath("(//span[text()='Container Instances'])[3]").click();
		
							
			WebDriverWait wait = new WebDriverWait(driver,20);
												
			// CLICK ON CONTAINER INSTANCES ADDED VIEW
			WebElement disappear = driver.findElementById("new-module-loc");
			
			// USE WEBDRIVER WAITS
			
		    wait.until(ExpectedConditions.invisibilityOf(disappear));
		    
		    Thread.sleep(3000);
		    
		    disappear.click();
		    
		  
		    
		    // SELECT REGION AS SOUTH INDIA
		    
		    WebElement region = driver.findElementByName("region");
		    Select dropDown1 = new Select(region);
		    dropDown1.selectByVisibleText("South India");
		    
		    
		    //SET DURATION AS 180000 SECONDS
		    
		    Actions act = new Actions(driver);
		    Thread.sleep(3000);
		    
		    //driver.findElementByXPath("(//div//div//input[@name='seconds'])[1]").clear();
		    
		    WebElement seconds = driver.findElementByXPath("(//div//div//input[@name='seconds'])[1]");
		    
		    seconds.sendKeys(Keys.RIGHT);
		    seconds.sendKeys(Keys.BACK_SPACE);
		    
	        act.sendKeys(seconds,"180000",Keys.RIGHT).perform();
		    
	        //SELECT THE MEMORY AS 4GB
	        
	        WebElement Memory = driver.findElementByName("memory");
	        Select dropDown2 = new Select(Memory);
	        dropDown2.selectByVisibleText("4 GB");
		    
	
		  //ENABLE SHOW DEV/TEST PRICING
	        
	        driver.findElementByXPath("//div//button[@id='devtest-toggler']").click();
	        
	        
	        
	       JavascriptExecutor jse = (JavascriptExecutor)driver;
	       jse.executeScript("window.scrollBy(0,250)", "");
	        
	        // Select Indian Rupee as currency
	        
	        WebElement Currency = driver.findElementByXPath("//select[@class='select currency-dropdown']");
	        Select dropDown3 = new Select(Currency);
	        dropDown3.selectByValue("INR");
	        
	        
		  //PRINT THE ESTIMATED MONTHLY COST
	        
		    String cost = driver.findElementByXPath("(//div//span[@class='numeric'])[6]").getText();
		    System.out.println("Estimated Monthly Cost:"+cost);
		    
		    //CLICK THE EXPORT BUTTON
		    
		    driver.findElementByXPath("(//button[@type='button']//span)[8]").click();
		    
		  
		    
		    //VERIFY THE DOWNLOADED FILE IN OUR SYSTEM FOLDER
		    //CALLING THE METHOD VERIFY FILE
		    
		    verifyFile("ExportedEstimate.xlsx");
		        
		    
		    //NAVIGATE TO EXAMPLE SCENARIOS
		    
		    WebElement example = driver.findElementByXPath("//li//a[text()='Example Scenarios']");
		    
		    JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
			
			
		    builder.moveToElement(example).click(example).perform();
		    
		   
		    
		    //SELECT CI/CD FOR CONTAINERS
		    
		    driver.findElementByXPath("//button[@title='CI/CD for Containers']").click();
		   	    	    	    
		   		    //CLICK TO ESTIMATE
		    
		    js.executeScript("window.scrollBy(0,-10000)");
			 
			WebElement estimate = driver.findElementByXPath("//button[text()='Add to estimate']");
			
			builder.moveToElement(estimate).click(estimate).perform();
			
			Thread.sleep(10000);
			
			
			 js.executeScript("window.scrollBy(0,-5000)");
			 
			 WebElement money1 = driver.findElementByXPath("//select[@class='select currency-dropdown']");
			 
			 Select dropDown4 = new Select(money1);
			 
			 // Change the Currency as Indian Rupee
			 dropDown4.selectByValue("INR");
			 
			
			 
			 //18. Enable SHOW DEV/TEST PRICING
			 driver.findElementByXPath("//button[@name='devTestSelected']").click();
			 
			
			 
			 //19.EXPORT THE ESTIMATE
			 driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();
			 
			
			 
			 // VERIFY THE DOWNLOAD FILE
			 verifyFile("ExportedEstimate (1).xlsx");
			 
			 // CLOSE THE BROWSER
			 driver.close();
		    
		   
	
	
	}

}
