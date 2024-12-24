package demoproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksImages {
    public static void main(String[] args) {
        // Set up the WebDriver
     //   System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        try {
            // Navigate to the website
            driver.get("https://demoqa.com/broken");
            
            // Verify all images
            List<WebElement> images = driver.findElements(By.tagName("img"));
            System.out.println("Checking images for broken links:");
            for (WebElement image : images) {
                String imgSrc = image.getAttribute("src");
                checkLink(imgSrc);
            }

            // Verify all links
            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println("\nChecking links for broken links:");
            for (WebElement link : links) {
                String href = link.getAttribute("href");
                checkLink(href);
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    private static void checkLink(String linkUrl) {
        try {
            if (linkUrl == null || linkUrl.isEmpty()) {
                System.out.println("Link is empty or null");
                return;
            }
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " is a broken link with response code: " + httpURLConnection.getResponseCode());
            } else {
                System.out.println(linkUrl + " is a valid link with response code: " + httpURLConnection.getResponseCode());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " is invalid or broken. Error: " + e.getMessage());
        }
    }
}
