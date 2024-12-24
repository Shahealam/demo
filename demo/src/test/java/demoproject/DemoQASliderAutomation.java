package demoproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoQASliderAutomation {
    public static void main(String[] args) {
   
        WebDriver driver = new ChromeDriver();

        try {
          
            driver.get("https://jqueryui.com/slider/#colorpicker");
            driver.manage().window().maximize();
            
            WebElement frame=driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
            driver.switchTo().frame(frame);
            Thread.sleep(4000);
            WebElement slider=driver.findElement(By.xpath("//span[contains(@class, 'ui-slider-handle')]"));
          //  WebElement slider=driver.findElement(By.cssSelector("span.ui-slider-handle"));
            
            

            
            Actions act=new Actions(driver);
            act.dragAndDropBy(slider,-100,125).perform();
            

         

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
         
          //  driver.quit();
        }
    }
}
