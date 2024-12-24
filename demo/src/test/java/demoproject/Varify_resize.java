package demoproject;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Varify_resize {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement frame = driver.findElement(By.xpath("//*[@class='demo-frame']"));
		
		driver.switchTo().frame(frame);
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		
		Actions act = new Actions(driver);
		act.dragAndDropBy(element,210,110).perform();
		
		Thread.sleep(3000);
		driver.quit();
		
		
	}

}
