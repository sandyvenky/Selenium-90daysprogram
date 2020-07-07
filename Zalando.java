package day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Zalando {

	public static void main(String[] args) throws InterruptedException 
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
					driver.get("https://www.zalando.com/");
					
					// IMPLICIT WAIT FOR ALL ELEMENTS IN THE WEBPAGE
					//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
					// HANDLE THE SIMPLE ALERT 
					
					Alert alert = driver.switchTo().alert();
					System.out.println(alert.getText());
					alert.accept();
					
					//MAXIMIZE THE WEBPAGE
					driver.manage().window().maximize();
					
					// CLICK ZALANDO.UK
					driver.findElementByXPath("//a[@class='nav_link nav_link-gb']").click();
					
					Thread.sleep(3000);
					
				//CLICK ON WOMEN 
					driver.findElementByXPath("//li//a//span[text()='Women']").click();
					
					
				
			//MOUSE HOVER ON CLOTHING
					WebElement Clothing = driver.findElementByXPath("//a//span[text()='Clothing']");
					
					Actions builder = new Actions(driver);
					Thread.sleep(3000);
					builder.moveToElement(Clothing).build().perform();
					
					//CLICK ON COATS
					
					driver.findElementByXPath("//a//span[text()='Coats']").click();
					
					Thread.sleep(4000);
						
					// CLICKING THATS OKAY
					driver.findElementByXPath("//button[@id='uc-btn-accept-banner']").click();
					
					//CHOOSE MATERIAL AS COTTON 100% AND CHOOSE HEIGHT AS THIGH LENGTH
					
					driver.findElementByXPath("(//div[@class='cat_container-109XU']//button)[6]").click();
					
					driver.findElementByXPath("//span[text()='cotton (100%)']").click();
					
					driver.findElementByXPath("//div//button[text()='Save']").click();
					
					// USE ACTIONS CLASS
					
					Actions builder1 = new Actions(driver);
					Thread.sleep(3000);
					builder.click(driver.findElement(By.xpath("//span[text()='Length']"))).perform();// click LENGTH
					driver.findElementByXPath("//span[text()='thigh-length']").click(); //CLICK THIGH-LENGTH
					driver.findElementByXPath("//div//button[text()='Save']").click(); //CLICK SAVE
					
					Thread.sleep(6000);
					
					driver.navigate().to("https://www.zalando.co.uk/womens-clothing-coats/?length=thigh-length&upper_material=pure_cotton&p=2");
					
					
					// CLICK ON JUNAROSE - BY VERO MODA
					
					driver.findElementByXPath("//div[text()='JUNAROSE - by VERO MODA']").click();
					
					//SELECT SIZE AS M IN MANUFACTURE SIZES
					
					driver.findElementByXPath("//span[text()='Choose your size']").click();
					Thread.sleep(3000);
					
					driver.findElementByXPath("//span[text()='Manufacturer sizes']").click();
					
					driver.findElementByXPath("(//li[@role='option']//div)[1]").click();
					
					Thread.sleep(3000);
					
					//TO CHECK STANDARD DELIVERY IS FREE
					
					WebElement standarddelivery = driver.findElementByXPath("(//span[text()='Free'])[1]");// xpath of the text Free
					
					if(standarddelivery.getText().contains("Free"))
					{
						driver.findElementByXPath("//span[text()='Add to bag']").click();
					}
					
					Thread.sleep(3000);
					//MOUSE OVER TO BAG AND CLICK GO TO BAG
					
					WebElement bag = driver.findElementByXPath("//span[text()='Your bag']");
					Actions builder2 = new Actions(driver);
					builder.moveToElement(bag).build().perform();
					
					driver.findElementByXPath("//div[text()='Go to bag']").click();
					
					//PRINT ESTIMATED DELIVERY DATE AND DETAILS
					
					WebElement EstimatedDelivery = driver.findElementByXPath("//h2[text()='Estimated delivery']");
					
					System.out.println(EstimatedDelivery.getText());
					
					WebElement deliverydetails = driver.findElementByXPath("(//span[@class='z-2-text z-2-text-body z-2-text-black'])[1]");
					
					System.out.println(deliverydetails.getText());
					
					//CLICK GO TO CHECKOUT
					
					WebElement Checkout = driver.findElementByXPath("(//button//div[text()='Go to checkout'])[1]");
					Actions builder3 = new Actions(driver);
				    builder.click(Checkout).build().perform();
				    
				    //ENTER EMAIL ADDRESS
				    driver.findElementByXPath("//input[@id='login.email']").sendKeys("vsandhya.vsm@gmail.com");
				    
				    //CLICK LOGIN BUTTON
				    driver.findElementByXPath("(//button[@type='button'])[2]").click();
				    
				    // CAPTURE THE ERROR MESSAGE
				    WebElement ErrorMessage = driver.findElementByXPath("//span[text()='This field is required']");
				    System.err.println(ErrorMessage.getText());
					
					
					
					
					
					
					
					
					
		
					
					
					
					
					
					
					
}
}

