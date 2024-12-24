package demoproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class duplicate {
	public static void main(String[]args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	try {
	driver.get("https://demoqa.com/webtables");
	
	driver.manage().window().maximize();
	
	driver.findElement(By.id("addNewRecordButton")).click();
	driver.findElement(By.id("firstName")).sendKeys("Shahe");
	driver.findElement(By.id("lastName")).sendKeys("alam");
	driver.findElement(By.id("userEmail")).sendKeys("shahe@gmail.com");
	driver.findElement(By.id("age")).sendKeys("27");
	driver.findElement(By.id("salary")).sendKeys("18000");
	driver.findElement(By.id("department")).sendKeys("it");
	driver.findElement(By.id("submit")).click();
//	Thread.sleep(3000);
	System.out.println("Record Added");
	
	///////////   search record 
	
	driver.findElement(By.id("searchBox")).sendKeys("shahe");
	WebElement element=driver.findElement(By.cssSelector(".rt-tbody"));
	if(element.getText().contains("shahe")) {
		System.out.println("Result found");
	}else {
		System.out.println("Result not found");
			
		}
	
	///Edit name 
	
	driver.findElement(By.cssSelector("span[title='Edit']")).click();
	WebElement agefield=driver.findElement(By.id("age"));
	agefield.clear();
	agefield.sendKeys("30");
	driver.findElement(By.id("submit")).click();
	
	System.out.println("Updated successfully");
	
	/////Delete Record 
	driver.findElement(By.cssSelector("span[title='Delete']")).click();
	System.out.println("Record deleted successfully");
	
	
//	List<WebElement> rows=driver.findElements(By.cssSelector(".rt-tbody"));
	//for(WebElement row:rows) {
		//System.out.println(row.getText());
	
	
	List<WebElement> rows = driver.findElements(By.cssSelector(".rt-tbody .rt-tr-group"));
	System.out.println(rows.size());
    for (WebElement row : rows) {
        System.out.println(row.getText());
        
    }
} catch (Exception e) {
    e.printStackTrace();
} finally {
    // Close the browser
    driver.quit();
         // Close the browser
    // 	Thread.sleep(3000);
       driver.quit();
     }
	}
	
	
	}
	
	
	
