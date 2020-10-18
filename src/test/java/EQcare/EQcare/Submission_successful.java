package EQcare.EQcare;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Submission_successful {
 
  public WebDriver driver;

	@BeforeTest
	public void Supportpage() throws Exception {
		//launching Chrome Browser
		//System.setProperty("webdriver.chrome.driver", "Chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://eqcare.com/en/contact-us");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//footer[@class=\"flex justify-center\"])[1]")).click();
		System.out.println(" Navigated to Support page");

	}

	@Test(priority=0)
	public void Submit_Contact_support() throws Exception {
		driver.findElement(By.xpath("//button[@class=\"rounded-button text-brand-primary bg-white rounded-button--sm text-sm mb-3\"]")).click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class=\"tablet:half\"])[1]/input")).sendKeys("Kiranmayie");
		driver.findElement(By.xpath("(//div[@class=\"tablet:half\"])[2]/input")).sendKeys("bethi");
		driver.findElement(By.xpath("(//div[@class=\"tablet:half\"])[3]/input")).sendKeys("00000000");
		driver.findElement(By.xpath("(//div[@class=\"tablet:half\"])[4]/input")).sendKeys("Kiranmayie@eqcare.ca");
		Select dropstate = new	Select(driver.findElement(By.xpath("(//div[@class=\"tablet:half\"])[5]/select")));
		dropstate.selectByVisibleText("Quebec");
		driver.findElement(By.xpath("(//div[@class=\"tablet:half\"])[6]/input")).sendKeys("Montreal");
		driver.findElement(By.xpath("(//div[@class=\"w-full mt-4\"])")).click();
		Thread.sleep(3000);
		WebElement field = driver.findElement(By.xpath("(//div[@class=\"w-full mt-4\"])/textarea"));
		field.clear();
		field.sendKeys("I am a QA bot");
		driver.findElement(By.xpath("//button[@class=\"rounded-button blue-button\"]")).click();
		System.out.println(" Submission successful");
		
		}
}