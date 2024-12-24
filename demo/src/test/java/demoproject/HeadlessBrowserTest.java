package demoproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowserTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
     //   System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Configure ChromeOptions for headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        // Initialize the WebDriver with headless Chrome
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to a website
            driver.get("https://example.com");

            // Perform actions and assertions
            String title = driver.getTitle();
            System.out.println("Page title is: " + title);

            // Example assertion
            if (title.equals("Example Domain")) {
                System.out.println("Test Passed!");
            } else {
                System.out.println("Test Failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
