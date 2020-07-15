package day10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AutoPortal
{
	public static void main(String[] args) throws InterruptedException 
	{
		

		//TO LAUNCH GOOGLE CHROME BROWSER APPLICATION THROUGH CODE
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		// TO DISABLE CHROME BROWSER NOTIFICATIONS
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		// CREATING OBJECT FOR THE CLASS CHROME DRIVER
		ChromeDriver driver = new ChromeDriver(options);
		
		//MAXIMIXE THE WEB PAGE
		driver.manage().window().maximize();
		
		// IMPLICIT WAIT FOR ALL ELEMENTS IN THE WEBPAGE
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// GET THE URL OF THE WEB PAGE TO BE AUTOMATED
		driver.get("https://autoportal.com/");
		
		//SELECTING THE LOCATION
		driver.findElementByXPath("//div//div[@class='maincity-in field']").click();
				
		//SELCTING THE LOCATION AS CHENNAI
		driver.findElementByXPath("//input[@id='ac_user_city']").sendKeys("Chennai");
		
		Thread.sleep(3000);
		
		driver.findElementByXPath("//li//span[@class='ui-state-highlight']").click();
		
		//SELECT CONFIRM CITY
		
		driver.findElementByXPath("//div//span[@class='red_but']").click();
		
		Thread.sleep(3000);
		
		//SELECT BRAND
		
		/*WebElement CarBrand = driver.findElementByXPath("//select[@class='field m_b-15']");
		Select BrandDropDown = new Select(CarBrand);
		BrandDropDown.selectByVisibleText("");
		*/
		
		driver.findElementByXPath("//select//option[text()='Renault']").click();
		
		//SELECT MODEL
		driver.findElementByXPath("//optgroup//option[text()='Arkana']").click();
		
		//SEARCH CARS
		driver.findElementByXPath("//input[@class='red_but']").click();
		
		//PRINTING THE EXPECTED PRICE
		WebElement ExpectedPrice = driver.findElementByXPath("//span[@class='WebRupee']");
		
		
		
		//PRINTING MIN PRICE AND MAX PRICE
		
		System.out.println("Expected Minimum Price"+ExpectedPrice.getAttribute("data-gtm-item-price-min"));
		
		System.out.println("Expected Maximum Price"+ExpectedPrice.getAttribute("data-gtm-item-price-max"));
		
		driver.close();
		
		
		
	
		
	}

}
