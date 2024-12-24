package demoproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*; 



public class Varify_Autocomplete {
	//public class Varify_Autocomplete {
	    WebDriver driver;

	//public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	    @BeforeTest
	    public void setup() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		
		driver.get("https://demoqa.com/auto-complete");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
	//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("autoCompleteMultipleContainer")));
		
		
		@Test
		public void testAutoComplete() throws InterruptedException {	
	//		driver.get("https://demoqa.com/auto-complete");
			
		WebElement element =driver.findElement(By.id("autoCompleteMultipleInput"));			
				element.sendKeys("red");
				element.sendKeys(Keys.ENTER);
			element.sendKeys("black");
				element.sendKeys(Keys.ENTER);
				
				
				WebElement element2=driver.findElement(By.id("autoCompleteSingleInput"));
				element2.sendKeys("black");
				element2.sendKeys(Keys.ENTER);
				
				
				
				
				}
		@AfterTest
			public void teardown() {	
				if(driver!=null) {
				driver.close();
				
			}
			}
				
				
				
				
				
				//driver.findElement(By.xpath("//*[@id=\"autoCompleteMultipleContainer\"]/div/div[1]"));
		
		
		
		
		
	}


