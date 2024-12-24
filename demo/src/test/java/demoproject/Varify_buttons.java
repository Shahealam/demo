package demoproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Varify_buttons {
	
public static void main(String[]args) throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	try {
	
	driver.get("https://demoqa.com/buttons");
	
	driver.manage().window().maximize();
	
	WebElement element =driver.findElement(By.cssSelector("button[id='doubleClickBtn']"));
	
	 Actions act = new Actions(driver);
	 
	 act.doubleClick(element).perform();
	 
	 WebElement element1=driver.findElement(By.cssSelector("p[id='doubleClickMessage']"));
	 if(element1.isDisplayed())
	 {
		 System.out.println("Double click message:"+" "+ element1.getText());
	 }
	 
	 WebElement element2 = driver.findElement(By.id("rightClickBtn"));
	 
	 act.contextClick(element2).perform();
	 
	 WebElement element3=driver.findElement(By.id("doubleClickMessage"));
	 if(element3.isDisplayed()) {
		 System.out.println("Right click message:"+" "+element3.getText());
	 }
	 
	 
	 WebElement element4 = driver.findElement(By.xpath("//button[text()='Click Me']"));
	 element4.click();
	 
	 WebElement element5 = driver.findElement(By.id("dynamicClickMessage"));
	 if(element5.isDisplayed()) {
		 System.out.println("Single click message:"+" "+element5.getText());
	 }
	 //////////////////////////
	}
	catch( Exception e) {
		e.printStackTrace();
		
	}finally {
		Thread.sleep(3000);
		driver.close();
	}
	
	 
	
}
	

}
