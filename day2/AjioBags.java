package day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjioBags {

	public static void main(String[] args) throws InterruptedException
	{

		String ActualCoupon = null;
		
		//  TO LAUNCH GOOGLE CHROME BROWSER APPLICATION THROUGH CODE
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		// TO DISABLE CHROME BROWSER NOTIFICATIONS
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification");
		
		// CREATING OBJECT FOR THE CLASS CHROME DRIVER
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().deleteAllCookies();
		
		// GET THE URL OF THE WEB PAGE TO BE AUTOMATED
		driver.get("https://www.ajio.com/shop/sale");
		
		// MAXIMIZE THE WEB PAGE
		driver.manage().window().maximize();
		
		//GIVE IMPLICIT WAIT FOR ALL THE WEB ELEMENTS
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//DELETE ALL COOKIES
		driver.manage().deleteAllCookies();
		
		//TO ENTER BAGS IN THE SEARCH FIELD
		driver.findElementByXPath("//div//input[@name='searchVal']").sendKeys("Bags");
		
		driver.manage().deleteAllCookies();

		//SELCT BAGS IN WOMEN HANDBAGS. //USE ACTION CLASS TO MOUSEHOVER
		
		WebElement bags = driver.findElementByXPath("(//span[text()='Women Handbags'])[1]");
		Actions builder = new Actions(driver);
		Thread.sleep(3000);
		builder.moveToElement(bags).build().perform();
		bags.click();
		
		//CLICK ON FIVE GRID
		driver.findElementByXPath("//div//div[@class='five-grid']").click();
		
		Thread.sleep(3000);
		
		driver.manage().deleteAllCookies();
		
		//SELECT SORT BY AS WHATS NEW
		
		driver.findElementByXPath("//div//select//option[4]").click();
		
		Thread.sleep(3000);
		
		//ENTER PRICE RANGE MIN AS 2500 AND MAX AS 5000
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='price']")));
		
		driver.findElementByXPath("//span[text()='price']").click();
		//MinPrice
		driver.findElementById("minPrice").sendKeys("2500");
		//MaxPrice
		driver.findElementById("maxPrice").sendKeys("5000");
		driver.findElementByXPath("(//button[@type='submit'])[2]").click();
		
		// GOES TO A NEW WINDOW WHEN CLICKING TOMMY HILFIGER
		// WINDOWS HANDLING
		// Get Unique reference for the first window
		
		//String Ajiowindow = driver.getWindowHandle();
		//driver.switchTo().window(Ajiowindow);
		//System.out.println(Ajiowindow);
		//String title = driver.getTitle();
		//System.out.println(title);
		
		driver.findElementByXPath("//div//div//div[text()='Sling Bag with Chain Strap']").click();
		
		// TO RETURN BOTH WINDOW REFERENCES AND ITS RETURN TYPE AS STRING
         Set<String> AjioAndTommyHilfiger = driver.getWindowHandles();
         
       //TO GET THE SECOND WINDOW HANDLE ALONE FROM THE REST OF SET OF STRINGS CONVERT SET TO LIST
		    List<String> listHandles = new ArrayList<String>(AjioAndTommyHilfiger);
		    
		    String Ajiowindow = listHandles.get(0);
		    driver.switchTo().window(Ajiowindow);
		    Thread.sleep(3000);
		    
		  //TO GET SINGLE ITEM FROM THE LIST
		    String TommyHilfiger = listHandles.get(1);
		    driver.switchTo().window(TommyHilfiger);
		    System.out.println(driver.getTitle());
		    
		    
		   Thread.sleep(3000);
		    
		    // PRINTING COUPON DESCRIPTION
		    String ApplyCouponDesc = driver.findElementByXPath("//div[@class = 'promo-desc']").getText();
		    
		    String CouponCode = null;
		    String DiscountPrice = null;
		    
		    if(ApplyCouponDesc.contains("2890 And Above"))
		    {
		    	System.out.println("Yay!!!!!!!! 2890 coupon available for the product");
		    	CouponCode = driver.findElementByXPath("(//div[@class = 'promo-title'])[1]").getText();
		    	System.out.println(CouponCode);
		    	DiscountPrice = driver.findElementByXPath("//div[@class = 'promo-discounted-price']/span").getText();
		    	DiscountPrice = DiscountPrice.replaceAll("[^0-9]","");
		    	System.out.println("After DiscountPrice Is:"+DiscountPrice);
		    	
		    }
		    
		   // ENTERING PINCODE
		    driver.findElementByXPath("//div[@class='edd-pincode-msg-container']").click();
		    Thread.sleep(3000);
		    driver.findElementByXPath("//div//input[@name='pincode']").sendKeys("560043");
		    
		    //CONFIRMING THE PINCODE
		    driver.findElementByXPath("(//button[@type='submit'])[2]").click();
		    
		    //CLICK OTHER INFORMATIONS
		    driver.findElementByXPath("//div[text()='Other information']/span").click();
		    
		    String CustomerCareAddress = driver.findElementByXPath("//section[@class = 'prod-desc']//ul/li[11]").getText();
		    System.out.println(CustomerCareAddress);
		    
		    //ADD TO BAG
		    
		    driver.findElementByXPath("//span[text() = 'ADD TO BAG']").click();
		    Thread.sleep(30000);
		    
		    // GO TO THE SHOPPING BAG
		    driver.findElementByXPath("//span[text() = 'GO TO BAG']").click();
		    
		    //CHECK THE ORDER TOTAL PRICE BEFORE APPLYING COUPON
		    
		    String PriceBeforeCoupon= driver.findElementByXPath("//div[@class='net-price best-price-strip']").getText();
	        System.out.println("THE ORDER TOTAL PRICE BEFORE APPLYING COUPON IS: "+PriceBeforeCoupon);
	        
	        // ENTER COUPON CODE AND CLICK APPLY
	        
	       
			driver.findElementById("couponCodeInput").sendKeys(CouponCode);
	        driver.findElementByXPath("//button[text()='Apply']").click();
	        Thread.sleep(5000);
		    
		    // VERIFY DISCOUNT PRICE MATCHES WITH ACTUAL PRICE
	        
	        driver.findElementByXPath("//button[text()='Apply']").click();
	        Thread.sleep(30000);
	        
	        String discountedPrice= driver.findElementByXPath("//div[@class='net-price best-price-strip']").getText();
	        String discountedPrice1=discountedPrice.replaceAll(",", "");
	        System.out.println("Price after discount:" +discountedPrice1);
	        if(!discountedPrice1.equals(DiscountPrice))
	        {
	        	System.out.println("Discount price not matched");
	        }
		    
        	//CLICK ON DELETE AND DELETE THE ITEM FROM BAG
	        
	        driver.findElementByClassName("delete-btn").click();
	        driver.findElementByXPath("//div[@class='delete-btn'])[2]").click();
	        
	        driver.quit();
		
		
	
	
	 
	 
		
		
		
	}

}
