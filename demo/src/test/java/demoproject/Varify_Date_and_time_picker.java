package demoproject;

import java.time.Duration;
import dev.failsafe.internal.util.Durations;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import dev.failsafe.internal.util.Durations;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Varify_Date_and_time_picker {
    WebDriver driver;
    
    @BeforeTest
	public void setup() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://demoqa.com/date-picker");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
@Test
	public void testdate_and_time() {
		try {
		WebElement element =driver.findElement(By.id("dateAndTimePickerInput"));
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		element.sendKeys(Keys.DELETE);
		
		
		String newdateandtime="November 19, 1997 4:00 AM";
		element.sendKeys(newdateandtime);
		element.sendKeys(Keys.ENTER);
		
		String b=element.getAttribute("value");
		if(b.equals(newdateandtime)) {
			System.out.println("date and time set successfully"+b);
			}else {
				System.out.println("failed to set date and time"+b);
			}
		
	}catch(Exception e)
		{	
	e.printStackTrace();	
		}
	}
	
	@AfterTest
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		
		if(driver!=null) {
			driver.quit();
	}
}}
