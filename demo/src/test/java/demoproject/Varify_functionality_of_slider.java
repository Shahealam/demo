package demoproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Varify_functionality_of_slider {
    public static void main(String[] args) {
        // Set up WebDriver
      //  System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the page
            driver.get("https://jqueryui.com/slider/#colorpicker");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Switch to the iframe containing the slider
            WebElement iframe = driver.findElement(By.className("demo-frame"));
            driver.switchTo().frame(iframe);

            // Locate the Hue slider handle
         WebElement hueHandle = driver.findElement(By.xpath("//div[@id='red']//span"));

            // Locate the Saturation slider handle
            WebElement saturationHandle = driver.findElement(By.xpath("//div[@id='green']//span"));

            // Locate the Lightness slider handle
            WebElement lightnessHandle = driver.findElement(By.xpath("//div[@id='blue']//span"));

            // Create an Actions instance
            Actions actions = new Actions(driver);

            // Move the Hue slider to 50px to the right
           actions.clickAndHold(hueHandle).moveByOffset(50, 0).release().perform();
            Thread.sleep(1000); // Wait to observe the change

            // Move the Saturation slider to 30px to the right
            actions.clickAndHold(saturationHandle).moveByOffset(30, 0).release().perform();
            Thread.sleep(1000);

            // Move the Lightness slider to 70px to the right
            actions.clickAndHold(lightnessHandle).moveByOffset(70, 0).release().perform();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
          //  driver.quit();
        }
    }
}
