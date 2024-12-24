package demoproject;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class VarifyBook_appoitment {

		public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		try {
		
		
		driver.get("https://www.sakraworldhospital.com/doctors/dr-anitha-b-radiologist");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Book an Appointment']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions act = new Actions(driver);
		
		WebElement Element1 =driver.findElement(By.xpath("//button[@class='btn login-btn transition' and text()='Consultation']"));
	
		Thread.sleep(3000);
		
		act.click(Element1).perform();
		
		
		driver.findElement(By.xpath("//input[@id='req_name' and @placeholder='Name']")).sendKeys("Shahe");
		driver.findElement(By.id("req_email")).sendKeys("shahe@gmail.com");
		driver.findElement(By.id("req_mobile")).sendKeys("9005922544");
		WebElement e2=driver.findElement(By.id("req_gender"));
		e2.sendKeys("Male");
		e2.click();
		WebElement e3=driver.findElement(By.id("req_datebirth"));
		e3.sendKeys("12/03/2024");
		e3.click();
		driver.findElement(By.id("radio1")).click();
		
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			Thread.sleep(3000);
			driver.close();
		}

	}

}
