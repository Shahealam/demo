package demoproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutomateWebTables {
    public static void main(String[] args) {
        // Set the path to the WebDriver executable
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the web tables page
            driver.get("https://demoqa.com/webtables");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Add a new record
            driver.findElement(By.id("addNewRecordButton")).click();
            driver.findElement(By.id("firstName")).sendKeys("John");
            driver.findElement(By.id("lastName")).sendKeys("Doe");
            driver.findElement(By.id("userEmail")).sendKeys("john.doe@example.com");
            driver.findElement(By.id("age")).sendKeys("35");
            driver.findElement(By.id("salary")).sendKeys("100000");
            driver.findElement(By.id("department")).sendKeys("Engineering");
            driver.findElement(By.id("submit")).click();
            System.out.println("Record added.");

            // Search for a record
            driver.findElement(By.id("searchBox")).sendKeys("John");
            WebElement searchResult = driver.findElement(By.cssSelector(".rt-tbody"));
            if (searchResult.getText().contains("John")) {
                System.out.println("Search successful: Record found.");
            } else {
                System.out.println("Search failed: Record not found.");
            }

            // Edit an existing record
            driver.findElement(By.cssSelector("span[title='Edit']")).click();
            WebElement ageField = driver.findElement(By.id("age"));
            ageField.clear();
            ageField.sendKeys("40");
            driver.findElement(By.id("submit")).click();
            System.out.println("Record updated.");

            // Delete a record
            driver.findElement(By.cssSelector("span[title='Delete']")).click();
            System.out.println("Record deleted.");

            // Extract all table data
            List<WebElement> rows = driver.findElements(By.cssSelector(".rt-tbody .rt-tr-group"));
            for (WebElement row : rows) {
                System.out.println(row.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
