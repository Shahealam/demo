package demoproject;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


	public class Varify_frames {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("frame1");
		
		WebElement first_frame = driver.findElement(By.id("sampleHeading"));
		
		System.out.println("Text 0f first frame:- "+first_frame.getText());
		
		driver.switchTo().defaultContent();
		
		WebElement e1=	driver.findElement(By.xpath("//*[@id=\"framesWrapper\"]/h1"));
	
		System.out.println("Main page content:- "+e1.getText());
		

        // Switch to the second frame and print its content
        driver.switchTo().frame("frame2");
        
        WebElement frame2Text = driver.findElement(By.id("sampleHeading"));
        
        System.out.println("Content in Frame 2: " + frame2Text.getText());
		
		Thread.sleep(3000);
		driver.quit();
	

	}

}
