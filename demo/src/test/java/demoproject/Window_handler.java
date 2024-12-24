package demoproject;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_handler {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='windowButton']")).click();
		
		//Thread.sleep(3000);
		
		Set<String>windowhandles=driver.getWindowHandles();
		System.out.println(windowhandles);
		
		Iterator<String>iterator=windowhandles.iterator();
		
		String parentwindow=iterator.next();
		System.out.println(parentwindow);

		String childwindow=iterator.next();
		System.out.println(childwindow);
		
		driver.switchTo().window(childwindow);
		driver.findElement(By.id("sampleHeading")).click();
		//driver.close();
		
		driver.switchTo().window(parentwindow);
		
		
	}

}
