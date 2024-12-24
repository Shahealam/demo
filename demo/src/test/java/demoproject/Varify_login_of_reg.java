package demoproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Varify_login_of_reg {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		try {
			driver.get("https://demoqa.com/login");
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("im_alam");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Lpu@90059");
			driver.findElement(By.xpath("//button[@id='login' and @type='button']")).click();	
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			Thread.sleep(3000);
		driver.close();
		}

	}

}
