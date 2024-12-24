package demoproject;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class tests11 {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
    }

    @Test
    public void firstclick() {
        WebElement element = driver.findElement(By.id("alertButton"));
        element.click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Clicked on 1st option: " + alert.getText());
        alert.accept();
    }

    @Test
    public void secondclick() {
        WebElement element = driver.findElement(By.id("timerAlertButton"));
        element.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        System.out.println("Clicked 2nd option - Waiting for 5 sec: " + alert.getText());
        alert.accept();
    }

    @Test
    public void thirdclick() {
        WebElement element = driver.findElement(By.id("confirmButton"));
        element.click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Clicked 3rd option: " + alert.getText());
        alert.accept();
    }

    @Test
    public void forthclick() {
        WebElement element = driver.findElement(By.id("promtButton"));
        element.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Sample Input");
        System.out.println("Clicked 4th option: " + alert.getText());
        alert.accept();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
