package Mahendra.Mahendra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_LoginFunctionality {

    public static void main(String[] args) throws InterruptedException {
        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://mahendra.vyaparerp.com/login"); // Open login page

        // Maximize the browser window
        driver.manage().window().maximize();

        // Wait for elements to load
        Thread.sleep(2000);

        // Locate username and password fields
        WebElement usernameField = driver.findElement(By.id("userName"));
        WebElement passwordField = driver.findElement(By.id("password"));

        // Enter login credentials
        usernameField.sendKeys("mahendra.vasyerp@gmail.com");
        passwordField.sendKeys("123456789");

        // Click on the login button
        WebElement loginButton = driver.findElement(By.id("signin_submit"));
        loginButton.click();

        // Wait for login to complete
        Thread.sleep(3000); // Wait for redirection to dashboard

        // Validate URL after login
        String expectedUrl = "https://mahendra.vyaparerp.com/dashboard";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Login successful. Navigated to Dashboard.");
        } else {
            System.out.println("Login failed or wrong navigation. Current URL: " + actualUrl);
        }

        // Close the browser
        driver.quit();
    }
}