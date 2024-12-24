package demoproject;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class AutomateLinksPage {
    public static void main(String[] args) {
        // Set up WebDriver
  
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the Links page
            driver.get("https://demoqa.com/links");
            driver.manage().window().maximize();

            // Click "Home" link and verify redirection
            WebElement homeLink = driver.findElement(By.id("simpleLink"));
            homeLink.click();
            // Switch to the new tab and verify URL
            for (String tabHandle : driver.getWindowHandles()) {
                driver.switchTo().window(tabHandle);
            }
            if (driver.getCurrentUrl().equals("https://demoqa.com/")) {
                System.out.println("Home link redirection successful.");
            } else {
                System.out.println("Home link redirection failed.");
            }
            driver.close(); // Close the new tab
            driver.switchTo().window(driver.getWindowHandles().iterator().next()); // Return to main tab

            // Click on "Created" link and verify response code
            WebElement createdLink = driver.findElement(By.id("created"));
            String createdLinkUrl = createdLink.getAttribute("href");
            verifyLinkResponse(createdLinkUrl);

            // Check response for "No Content" link without clicking
            WebElement noContentLink = driver.findElement(By.id("no-content"));
            String noContentLinkUrl = noContentLink.getAttribute("href");
            verifyLinkResponse(noContentLinkUrl);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the browser
            driver.quit();
        }
    }

    // Helper method to verify HTTP response codes
    private static void verifyLinkResponse(String linkUrl) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(linkUrl);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                System.out.println("Response for " + linkUrl + ": " + response.getCode());
            }
        } catch (IOException e) {
            System.out.println("Failed to check response for " + linkUrl);
            e.printStackTrace();
        }
    }
}
