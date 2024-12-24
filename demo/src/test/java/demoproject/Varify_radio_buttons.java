package demoproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Varify_radio_buttons {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the WebDriver executable
     //   System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the radio button page
            driver.get("https://demoqa.com/radio-button");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Select the 'Yes' radio button
            WebElement yesRadioButton = driver.findElement(By.cssSelector("label[for='yesRadio']"));
            yesRadioButton.click();

            // Verify if 'Yes' radio button is selected
            WebElement yesInput = driver.findElement(By.id("yesRadio"));
            if (yesInput.isSelected()) {
                System.out.println("'Yes' radio button is selected.");
            } else {
                System.out.println("'Yes' radio button is not selected.");
            }

            // Select the 'Impressive' radio button
            WebElement impressiveRadioButton = driver.findElement(By.cssSelector("label[for='impressiveRadio']"));
            impressiveRadioButton.click();

            // Verify if 'Impressive' radio button is selected
            WebElement impressiveInput = driver.findElement(By.id("impressiveRadio"));
            if (impressiveInput.isSelected()) {
                System.out.println("'Impressive' radio button is selected.");
            } else {
                System.out.println("'Impressive' radio button is not selected.");
            }

            // Try selecting the 'No' radio button (disabled)
            WebElement noRadioButton = driver.findElement(By.id("noRadio"));
            if (!noRadioButton.isEnabled()) {
                System.out.println("'No' radio button is disabled.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
        	Thread.sleep(3000);
            driver.quit();
        }
    }
}




