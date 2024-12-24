package demoproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	

	public class Check_box_varification  {
	    public static void main(String[] args) throws InterruptedException {
	        // Set the path to the WebDriver executable
	    //    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Navigate to the checkbox page
	            driver.get("https://demoqa.com/checkbox");

	            // Maximize the browser window
	            driver.manage().window().maximize();

	            // Click the toggle button to expand the tree structure
	            WebElement toggleButton = driver.findElement(By.cssSelector("button[aria-label='Toggle']"));
	            toggleButton.click();
	            
	            

	            // Select the 'Desktop' checkbox
	            WebElement desktopCheckbox = driver.findElement(By.cssSelector("label[for='tree-node-desktop']"));
	            desktopCheckbox.click();

	            // Verify if the checkbox is selected
	            WebElement desktopInput = driver.findElement(By.id("tree-node-desktop"));
	            if (desktopInput.isSelected()) {
	                System.out.println("Desktop checkbox is checked.");
	            } else {
	                System.out.println("Desktop checkbox is not checked.");
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

