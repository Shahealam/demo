package demoproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class Switchto_window {
    public static void main(String[] args) {
        // Set up the ChromeDriver path
   //     System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize browser window and navigate to the URL
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demoqa.com/browser-windows");

            // Store the main window handle
            String mainWindow = driver.getWindowHandle();

            // 1. Open a new tab
            WebElement newTabButton = driver.findElement(By.id("tabButton"));
            newTabButton.click();

            // Switch to the new tab
            switchToNewWindow(driver, mainWindow);

            // Get page source or handle plain text
            System.out.println("New Tab Content:\n" + driver.getPageSource());

            // Close the new tab and switch back to the main window
            driver.close();
            driver.switchTo().window(mainWindow);

            // 2. Open a new window
            WebElement newWindowButton = driver.findElement(By.id("windowButton"));
            newWindowButton.click();

            // Switch to the new window
            switchToNewWindow(driver, mainWindow);

            // Get page source or handle plain text
            System.out.println("New Window Content:\n" + driver.getPageSource());

            // Close the new window and switch back to the main window
            driver.close();
            driver.switchTo().window(mainWindow);

            // 3. Open a new window with message
            WebElement messageWindowButton = driver.findElement(By.id("messageWindowButton"));
            messageWindowButton.click();

            // Switch to the new message window
            switchToNewWindow(driver, mainWindow);

            // Get page source or handle plain text
            System.out.println("Message Window Content:\n" + driver.getPageSource());

            // Close the message window and switch back to the main window
            driver.close();
            driver.switchTo().window(mainWindow);

        } finally {
            // Quit the browser
            driver.quit();
        }
    }

    private static void switchToNewWindow(WebDriver driver, String mainWindow) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}
