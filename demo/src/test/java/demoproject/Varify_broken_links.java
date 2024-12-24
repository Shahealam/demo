package demoproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


	public class Varify_broken_links {
	    public static void main(String[] args) {
	        // Set path to ChromeDriver executable
	      //  System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Navigate to the webpage
	            driver.get("https://demoqa.com/broken");

	            // Maximize browser window
	            driver.manage().window().maximize();

	            // Get all anchor tags on the page
	            List<WebElement> links = driver.findElements(By.tagName("a"));

	            // Print the total number of links
	            System.out.println("Total links on the page: " + links.size());

	            // Check each link
	            for (WebElement link : links) {
	                String url = link.getAttribute("href");

	                // Validate the URL
	                if (url == null || url.isEmpty()) {
	                    System.out.println("URL is empty or null for link: " + link.getText());
	                    continue;
	                }

	                try {
	                    // Check the link status
	                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	                    connection.setRequestMethod("HEAD");
	                    connection.connect();
	                    int responseCode = connection.getResponseCode();

	                    if (responseCode >= 400) {
	                        System.out.println("Broken link: " + url + " | Response code: " + responseCode);
	                    } else {
	                        System.out.println("Valid link: " + url + " | Response code: " + responseCode);
	                    }
	                } catch (Exception e) {
	                    System.out.println("Error checking URL: " + url + " | Exception: " + e.getMessage());
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
	    }
	}

	
	
	

