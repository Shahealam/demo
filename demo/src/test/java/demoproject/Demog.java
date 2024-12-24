package demoproject;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demog {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
       // System.setProperty("webdriver.chrome.driver", "/home/shahid/Downloads/chromedriver-linux64/chromedriver");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        
      //  driver.get("https://demoqa.com/text-box");
        driver.get("https://demoqa.com/checkbox");
        
        
      driver.manage().window().maximize();
       Thread.sleep(3000);
       driver.findElement(By.xpath("//path[@d='M19 3H5c-1.11 0-2 .9-2 2v14c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2zm-2 10h-4v4h-2v-4H7v-2h4V7h2v4h4v2z']\n"
       		+ ""));
       
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       
       driver.findElement(By.id("userName")).sendKeys("shahe");
       driver.findElement(By.id("userEmail")).sendKeys("shahe@gmail.com");
       driver.findElement(By.id("currentAddress")).sendKeys("Delhi");
       driver.findElement(By.id("permanentAddress")).sendKeys("Gorakhpur");
       Thread.sleep(3000);
       WebElement element =driver.findElement(By.xpath("//*[@id='submit']"));
       element.click();
       Thread.sleep(3000);
   driver.quit();
       
    }
}
