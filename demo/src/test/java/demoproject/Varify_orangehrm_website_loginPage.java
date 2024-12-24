package demoproject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;



public class Varify_orangehrm_website_loginPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		
		try {
			
			driver.get("https://www.orangehrm.com/en/book-a-free-demo");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//input[@id='Form_getForm_FullName' and @name='FullName']")).sendKeys("Alam");
			driver.findElement(By.xpath("//input[ @name='Contact' and @id='Form_getForm_Contact']")).sendKeys("1234567898");
			
			driver.findElement(By.xpath("(//input[ @name='Email' and @id='Form_getForm_Email'])")).sendKeys("sh@gmail.com");
			driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("abns");
			
			WebElement testDropDown = driver.findElement(By.xpath("//select[@name='Country' and @id='Form_getForm_Country']"));  
			Select dropdown = new Select(testDropDown);  
			dropdown.selectByValue("Austria");  
			
			WebElement testDropDown1 = driver.findElement(By.xpath("//select[@name='NoOfEmployees' and @id='Form_getForm_NoOfEmployees']"));  
			Select dropdown1 = new Select(testDropDown1);  
			dropdown1.selectByValue("11 - 50");
			// After filling out the form
			System.out.println("Please complete the CAPTCHA manually within 5 seconds.");

			// Pause to give the user time to solve the CAPTCHA
			Thread.sleep(5000); // Pause for 5 seconds

			
			driver.findElement(By.xpath("//input[@name='action_submitForm' and @id='Form_getForm_action_submitForm']")).click();
			System.out.println("Form_Submitted_Successfully");
			
		}
		catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				Thread.sleep(3000);
				driver.close();
			
		}

	}

}