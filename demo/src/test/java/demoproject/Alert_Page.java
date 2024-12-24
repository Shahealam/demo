package demoproject;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Alert_Page {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
	}
	
	@Test
	public void firstclick()
	{		WebElement element =driver.findElement(By.id("alertButton"));
		
		element.click();
		
		
		Alert s =driver.switchTo().alert();
		
		System.out.println("click on 1 option: "+s.getText());
		s.accept();
	}
	@Test
	public void secondclick() {
		WebElement element1 =driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
		element1.click();
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		
		Alert b= driver.switchTo().alert();
		System.out.println("clicked 2 option:-Waiting for 5 sec and then clicked:-"+b.getText());
		b.accept();
	}
		
	@Test
	public void thirdclick() {
		WebElement element2=driver.findElement(By.id("confirmButton"));
		
		element2.click();
		Alert c=driver.switchTo().alert();
		System.out.println("3 option clicked:-"+c.getText());
		c.accept();
	}
	@Test
	public void forth() {
	WebElement element3 =driver.findElement(By.id("promtButton"));
	element3.click();
	Alert d=driver.switchTo().alert();
	d.sendKeys("asa");
	System.out.println("4 option clicked :-"+d.getText());
	d.accept();
	}
	
	@AfterTest
	
	public void teardown() {
	if(driver!=null) {
	driver.quit();
	
	
	
	}}

}
