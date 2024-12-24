package demoproject;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import java.time.Duration;
	public class Varify_dynamic_properties {

	    public static void main(String[] args) {
	        // Set up WebDriver
	   //     System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Navigate to the Dynamic Properties page
	            driver.get("https://demoqa.com/dynamic-properties");
	            driver.manage().window().maximize();

	            // Wait for the "Will Enable 5 Seconds" button to be enabled

	            
	      
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement enableButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
	            if (enableButton.isEnabled()) {
	                System.out.println("The button is enabled after 5 seconds.");
	            }

	            // Verify the color change of the "Color Change" button
	            WebElement colorChangeButton = driver.findElement(By.id("colorChange"));
	            String initialColor = colorChangeButton.getCssValue("color");
	            System.out.println("Initial Color: " + initialColor);

	            // Wait for color to change
	            Thread.sleep(6000); // Adding a wait since the color changes dynamically
	            String newColor = colorChangeButton.getCssValue("color");
	            System.out.println("New Color: " + newColor);

	            if (!initialColor.equals(newColor)) {
	                System.out.println("The color of the button has changed.");
	            } else {
	                System.out.println("The color of the button has not changed.");
	            }

	            // Wait for the "Visible After 5 Seconds" element to appear
	            WebElement visibleAfter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
	            if (visibleAfter.isDisplayed()) {
	                System.out.println("The element is visible after 5 seconds.");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Quit the browser
	            driver.quit();
	        }
	    }
	}

	
	
	
	

