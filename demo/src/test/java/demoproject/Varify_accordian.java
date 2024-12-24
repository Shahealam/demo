package demoproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Varify_accordian {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().browserVersion("129").setup();

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://demoqa.com/accordian");

            driver.manage().window().maximize();
            WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
            WebElement element =wait.until(ExpectedConditions.elementToBeClickable(By.id("section1Heading"))); 
            element.click();
            // Verifying the content of the accordion
            WebElement content = driver.findElement(By.id("section1Content"));
            
            if (content.isDisplayed()) {
                System.out.println("Accordion expanded: " + content.getText());
            } else {
                System.out.println("Accordion did not expand.");
            }
            WebElement content2 = driver.findElement(By.id("section2Heading"));
            content2.click();
            if(content2.isDisplayed()) {
            	System.out.println("Question no 2 Expanded:"+content2.getText());
            }else {
            	System.out.println("Not expanded");
            }
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	Thread.sleep(3000);
            driver.quit();
        }
    }
}








