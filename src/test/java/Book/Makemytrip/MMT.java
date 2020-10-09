package Book.Makemytrip;

import java.lang.*;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.NoSuchElementException;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class MMT {
	
	static ChromeDriver driver;
	static String chromePath;
	
	@BeforeClass
	public static void init()
	{
		chromePath=System.getProperty("user.dir")+"/lib/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
  @Test
  public void Signup() throws Exception {
	  
//Sign up to Makemytrip with Email or Mobile
		driver.get("https://www.makemytrip.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/ul/li[6]/div")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("username")).sendKeys("XXXXXXXX@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/section/form/div[2]/button")).click();
		Thread.sleep(1000);
	//Enter OTP manually which received to mentioned E-mail
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[2]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("First");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("P@ssword");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[3]/button")).submit();
	//Account created successfully
		Thread.sleep(1000);
	//logout the account
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[6]/div")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[6]/div[2]/a[6]/div/p")).click();
  }
  @Test
  public void Login() throws Exception{
	  
//Login with account credentials
	  
	  	driver.get("https://www.makemytrip.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/ul/li[6]/div")).click();
		Thread.sleep(10000);
		/*
		 driver.switchTo().frame("//*[@id=\"webklipper-publisher-widget-container-notification-frame\"]");
		 driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]/i")).click();
		Thread.sleep(3000);
		*/
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("xxxxxxx@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		Thread.sleep(2000);
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("P@ssword");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[2]/button")).click();
	  	Thread.sleep(5000);
	  	driver.findElement(By.xpath("//span[text()='Hotels']")).click();
		Thread.sleep(10000);
		Thread.sleep(3000);
	  	driver.findElement(By.xpath("//input[@id=\"city\"]")).click();
		Thread.sleep(1000);
		WebElement place =driver.findElement(By.xpath("//input[@placeholder=\"Enter city/ Hotel/ Area/ Building\"]"));
		Thread.sleep(1000);
		place.sendKeys("bengaluru");
		Thread.sleep(1000);
		place.sendKeys(Keys.ARROW_DOWN);	
		Thread.sleep(1000);
		place.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"checkin\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class=\"DayPicker-Day\"][contains(@aria-label,'Nov 05 2020')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class=\"DayPicker-Day\"][contains(@aria-label,'Nov 08 2020')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id=\"hsw_search_button\"]")).click();
		Thread.sleep(5000);
		
//Searching hotel with filters
		driver.findElement(By.xpath("//*[@id=\"hlistpg_fr_star_category\"]/ul/li[2]/span[1]/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"hlistpg_fr_property_types\"]/ul/li[1]/span[1]/label")).click();
		Thread.sleep(2000);
		WebElement slider=driver.findElement(By.xpath("//*[@id=\"hlistpg_fr_price_per_night\"]/div[2]/div[2]/div/span[2]/div"));
		Thread.sleep(10000);
		Actions act=new Actions(driver);
		act.moveToElement(slider).click().dragAndDropBy(slider,-100,0).build().perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='The Park Bangalore']")).click();
		Thread.sleep(10000);
		Set<String> window=driver.getWindowHandles();
		Iterator<String> iterator=window.iterator();
		String mainwindow=iterator.next();
		String childwindow=iterator.next();
		driver.switchTo().window(childwindow);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='fcTooltip__outer']/a")).click();
		Thread.sleep(10000);
		
//Filling Personal information	
		driver.findElement(By.xpath("//*[@id=\"fName\"]")).sendKeys("First name");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"lName\"]")).sendKeys("Last name");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Pay Now']")).click();
		Thread.sleep(5000);
		
//Payment card details
		driver.findElement(By.xpath("//*[@id=\"GPAY\"]/span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"upiId\"]")).sendKeys("firstname123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id=\"btn_gen_pmt_gpay\"]")).click();
		Thread.sleep(3000);
		WebElement results = driver.findElement(By.xpath("//*[@id=\"PAYMENT_inputVpa_err\"]/span[2]"));
		Thread.sleep(5000);
		assertTrue(results.getText().equals("Invalid VPA. Please check VPA."));
		driver.switchTo().window(mainwindow);

  }
  
	@AfterClass
	public static void close()
	{
		driver.quit();
	}

}
