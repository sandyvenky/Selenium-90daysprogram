package day9;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class SuperCalculator
{
	
	public static ChromeDriver driver;
	public static JavascriptExecutor js;
	public static NgWebDriver ngWeb;
	
	

	public static void main(String[] args) throws InterruptedException
	{
	
				//TO LAUNCH GOOGLE CHROME BROWSER APPLICATION THROUGH CODE
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				
				// TO DISABLE CHROME BROWSER NOTIFICATIONS
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				
				// CREATING OBJECT FOR THE CLASS CHROME DRIVER
				ChromeDriver driver = new ChromeDriver(options);
				js = (JavascriptExecutor) driver;
				
				//NGWebdriver IS A CLASS WHICH TAKES JAVASCRIPTEXECUTOR AS INPUT WHILE INITIALIZING AND IS USED TO HANDLE WAITS IN ANGULAR JS APPLICATION
				ngWeb = new NgWebDriver(js);
				
				//MAXIMIXE THE WEB PAGE
				driver.manage().window().maximize();
				
				// IMPLICIT WAIT FOR ALL ELEMENTS IN THE WEBPAGE
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				// GET THE URL OF THE WEB PAGE TO BE AUTOMATED
				driver.get("https://juliemr.github.io/protractor-demo/");
				
				// FIRST INPUT USING BYANGULAR
				driver.findElement(ByAngular.model("first")).sendKeys("5");
				
				//OPERATOR SELECTION USING BYANGULAR
				
				WebElement operator = driver.findElement(ByAngular.model("operator"));
				operator.click();
				Select OperatorDropDown = new Select(operator);
				OperatorDropDown.selectByVisibleText("*");
				
				//SECOND INPUT USING BYANGULAR
				driver.findElement(ByAngular.model("second")).sendKeys("105");
				
				//CLICKING BUTTON USING ANGULAR
				
				driver.findElement(ByAngular.buttonText("Go!")).click();
				
				//RESULT
				
				WebElement result = driver.findElementByXPath("//h2[@class='ng-binding']");
				
				
				//With help of ngWebDriver variable we can handle angular specific waiting issues.  
				//The below code will wait for angular requests to finish.
				
				
				ngWeb.waitForAngularRequestsToFinish();
				
				//GET THE RESULT
				
				System.out.println(result.getText());
				
				
				
			
				
				
				
	
	
}
}

