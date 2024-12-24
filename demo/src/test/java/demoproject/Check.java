package demoproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method 
		//System.setProperty("webdriver.chrome.driver","path");
		WebDriver driver= new ChromeDriver();
		
		try {
			driver.get("https://demoqa.com/upload-download");
			driver.manage().window().maximize();
		WebElement element = driver.findElement(By.cssSelector("input[id='uploadFile']"));
		element.sendKeys("/home/shahid/Downloads/sample1.txt");
		System.out.println("file uploaded successfully");
		
		WebElement element1 =driver.findElement(By.id("downloadButton"));
		element1.click();
		System.out.println("file downloaded successfully");
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
		Thread.sleep(3000);
			driver.close();
		}
		

	}

	private static boolean contains(String string) {
		// TODO Auto-generated method stub
		return false;
	}

}
