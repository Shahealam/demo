package demoproject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Varify_practice_form {
	
	public static void main(String[]args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		try {
			
			driver.get("https://demoqa.com/automation-practice-form");
			driver.manage().window().maximize();
			
			driver.findElement(By.id("firstName")).sendKeys("shahe");
			driver.findElement(By.id("lastName")).sendKeys("Alam");
			driver.findElement(By.id("userEmail")).sendKeys("shahe@gmail.com");
			driver.findElement(By.xpath("//label[text()='Male']")).click();
			driver.findElement(By.id("userNumber")).sendKeys("9005922544");
			
			
			///Enter DOB
			
			
			WebElement element = driver.findElement(By.id("dateOfBirthInput"));
			element.click();
			element.sendKeys(Keys.CONTROL+"a");
			element.sendKeys("29 Nov 2024" + Keys.ENTER);
			
			//rest code
		
			WebElement element2 =driver.findElement(By.id("subjectsInput"));
			element2.sendKeys("Math");
			element2.sendKeys(Keys.ENTER);
			
		/*	
			WebElement subjectInput = driver.findElement(By.id("subjectsInput"));
            subjectInput.sendKeys("Math");
            subjectInput.sendKeys(Keys.ENTER);*/
			
			
			
		WebElement e=driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1' and @type='checkbox']"));
		
		e.sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//label[text()='Reading']")).click();
			
			
			
			WebElement element1=driver.findElement(By.id("uploadPicture"));
			element1.sendKeys("/home/shahid/Downloads/sample1.txt");
			
			
			WebElement element3= driver.findElement(By.id("currentAddress"));
			element3.sendKeys("Delhi");
			element3.sendKeys(Keys.ENTER);
			
			// Select State and City
            Actions actions = new Actions(driver);

            // Select State
            WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
          //  actions.moveToElement(stateDropdown).click().sendKeys("NCR").sendKeys(Keys.ENTER).perform();
            
            Select dropdwn= new Select(stateDropdown);
            
            dropdwn.selectByVisibleText("Haryana");

            
            
            
            // Select City
            WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));
            actions.moveToElement(cityDropdown).click().sendKeys("Delhi").sendKeys(Keys.ENTER).perform();

            
            
            
            
           
            
            
            
            // Submit the form
            WebElement submit =driver.findElement(By.xpath("//button[@id='submit'and text()='Submit']"));
            
            submit.sendKeys(Keys.ENTER);

			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		
		}finally {
			Thread.sleep(3000);
		driver.close();
		}
		
		
		
	}
	


}
