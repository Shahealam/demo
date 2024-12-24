package demoproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Varify_Register_and_login_user {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver =new ChromeDriver();
		
		try {
			
			driver.get("https://demoqa.com/register");
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("shahe");
			
			driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("alam");
			
			driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("im_alam");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Lpu@90059");
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//button[@id='register']")).click();
			
			System.out.println("Registration successfull");
			
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}finally {
			Thread.sleep(3000);
			//driver.close();
	}
	}
}
