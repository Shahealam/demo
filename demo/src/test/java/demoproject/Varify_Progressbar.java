		package demoproject;
		import java.time.Duration;
		
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.WebDriverWait;
		import io.github.bonigarcia.wdm.WebDriverManager;
		
		public class Varify_Progressbar {
		
		public static void main(String[] args) throws InterruptedException {
			
			
		
		WebDriverManager.chromedriver().setup();   //this will setup the chrome driver
		WebDriver driver=new ChromeDriver();
			
			
			
		driver.manage().window().maximize();//this will maximize the browser
		driver.navigate().to("https://demoqa.com/progress-bar");
		
		driver.findElement(By.xpath("//button[@id='startStopButton']")).click();
		WebElement progressbar=driver.findElement(By.xpath("//div[@role='progressbar']"));  //-------
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(100));
		
		boolean progressStatus =wait.until (ExpectedConditions.attributeToBe (progressbar, "aria-valuenow", "100")); //0t0100
		
		if (progressStatus==true) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='resetButton']"))).click(); //dynamic id change start to reset.
		
		 driver.quit();
		 
		}
		}
		}
		
		
		
		
		
		
