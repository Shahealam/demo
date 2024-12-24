package demoproject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SelectMenu_page {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		try {
			driver.get("https://demoqa.com/select-menu");
			driver.manage().window().maximize();
			WebElement element=driver.findElement(By.id("withOptGroup"));
			element.click();
				
			
			WebElement element1=driver.findElement(By.xpath("//div[text()='Group 1, option 2']"));
			element1.click();
			
			
			WebElement e2=driver.findElement(By.id("selectOne"));
			e2.click();
			
			WebElement e3= driver.findElement(By.xpath("//div[text()='Dr.']"));
			e3.click();
			
			
			
			
			
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		Thread.sleep(3000);
		
		//driver.close();
		
		
		}
		
		
		
		

	}

}
