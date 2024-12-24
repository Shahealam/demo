package demoproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Check_somethings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/links");
		
		
		List<WebElement> lists =driver.findElements(By.tagName("a"));
		
		System.out.println(lists.size());
		for(WebElement el: lists) {
			System.out.println(el.getText());
		}
		
		
	}

}
