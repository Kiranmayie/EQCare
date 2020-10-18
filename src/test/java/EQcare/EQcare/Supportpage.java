package EQcare.EQcare;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Supportpage {
  
	  public WebDriver driver;
		
	  @BeforeTest
		public void Contactus_page() throws Exception {
			//launching Chrome Browser
			//System.setProperty("webdriver.chrome.driver", "Chromedriver.exe");
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
			driver.get("https://eqcare.com/en/contact-us");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Navigated to Contact us page"); 
		}
		
		@Test(priority=0)
		public void Click_Contact_support() throws Exception {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class=\"rounded-button text-brand-primary bg-white rounded-button--sm text-sm mb-3\"]")).click();
		driver.findElement(By.xpath("(//footer[@class=\"flex justify-center\"])[1]")).click();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Contact Us";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");
  }
		
  }
