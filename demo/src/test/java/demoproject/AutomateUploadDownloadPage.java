package demoproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class AutomateUploadDownloadPage {
    public static void main(String[] args) {
        // Set up WebDriver
    //    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the Upload and Download page
            driver.get("https://demoqa.com/upload-download");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // File Upload
            WebElement uploadInput = driver.findElement(By.id("uploadFile"));
            String filePath = "/home/shahid/Downloads/sample1.txt"; // Replace with an actual file path
            uploadInput.sendKeys("/home/shahid/Downloads/sample1.txt");
            Thread.sleep(3000);
            uploadInput.click();

            // Verify uploaded file name
            WebElement uploadedFilePath = driver.findElement(By.id("uploadedFilePath"));
            if (uploadedFilePath.isDisplayed() && uploadedFilePath.getText().contains("file.txt")) {
                System.out.println("File uploaded successfully: " + uploadedFilePath.getText());
            } else {
                System.out.println("File upload failed.");
            }

            // File Download
            WebElement downloadButton = driver.findElement(By.id("downloadButton"));
            downloadButton.click();

            // Verify file download
            String downloadPath = System.getProperty("user.home") + "/Downloads/sampleFile.jpeg";
            if (waitForFileDownload(downloadPath, 10)) {
                System.out.println("File downloaded successfully: " + downloadPath);
            } else {
                System.out.println("File download failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the browser
            driver.quit();
        }
    }

    // Helper method to verify if the file is downloaded
    private static boolean waitForFileDownload(String filePath, int timeoutInSeconds) {
        int timeElapsed = 0;
        while (timeElapsed < timeoutInSeconds) {
            if (Files.exists(Paths.get(filePath))) {
                return true;
            }
            try {
                Thread.sleep(1000); // Wait for 1 second
                timeElapsed++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}

