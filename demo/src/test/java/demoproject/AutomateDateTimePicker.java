package demoproject;


//package demoproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateDateTimePicker {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set up ChromeDriver and initialize WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the Date Picker page
        driver.get("https://demoqa.com/date-picker");
    }

    @Test
    public void testDateTimePicker() {
        try {
            // Locate the Date and Time Picker input field
            WebElement dateTimeInput = driver.findElement(By.id("dateAndTimePickerInput"));

            // Clear the existing value
            dateTimeInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
            dateTimeInput.sendKeys(Keys.DELETE); // Delete the selected text

            // Enter a new date and time directly
            String newDateTime = "December 25, 2024 10:30 PM"; // Format: Month DD, YYYY HH:MM AM/PM
            dateTimeInput.sendKeys(newDateTime);
            dateTimeInput.sendKeys(Keys.ENTER);

            // Verify the entered date and time
            String enteredDateTime = dateTimeInput.getAttribute("value");
            if (enteredDateTime.equals(newDateTime)) {
                System.out.println("Date and Time set successfully: " + enteredDateTime);
            } else {
                System.out.println("Failed to set Date and Time. Entered: " + enteredDateTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void teardown() {
        // Close the browser
        if (driver != null) {
          //  driver.quit();
        }
    }
}

