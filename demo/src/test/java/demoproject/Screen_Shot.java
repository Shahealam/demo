	package demoproject;
	import java.io.File;
	import java.io.IOException;
	
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	
	import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class Screen_Shot {
	
		public static void main(String[] args) throws IOException, InterruptedException {
			
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver =new ChromeDriver();
			
			
			driver.get("https://demoqa.com/text-box");
			driver.manage().window().maximize();
			TakesScreenshot screenshot=((TakesScreenshot)driver);
			
			WebElement element = driver.findElement(By.xpath("//*[@id=\"currentAddress-wrapper\"]"));
			
			
			File src= element.getScreenshotAs(OutputType.FILE);
			File dest=new File("/home/shahid/git/repository/home/shahid/project/Demo_project/demo/src/Screenshot/Fullsrc4.png");
			FileUtils.copyFile(src, dest);
			
			driver.close();
				
	
		}
	
	}
