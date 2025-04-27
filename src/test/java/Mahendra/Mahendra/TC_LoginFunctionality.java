package Mahendra.Mahendra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_LoginFunctionality {

	@Test
	
    public static void login() throws InterruptedException {
        System.out.println("Initializing ChromeDriver...");
        WebDriver driver = new ChromeDriver();

        System.out.println("Opening login page...");
        driver.get("https://sunilsharma30.vasyerp.com/login");

        System.out.println("Maximizing the browser window...");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        System.out.println("Waiting for elements to load...");

        System.out.println("Locating username and password fields...");
        WebElement usernameField = driver.findElement(By.id("userName"));
        WebElement passwordField = driver.findElement(By.id("password"));

        System.out.println("Entering login credentials...");
        usernameField.sendKeys("sunilsharma@vasyerp.com");
        passwordField.sendKeys("Sunil@1234");

        System.out.println("Clicking on the login button...");
        WebElement loginButton = driver.findElement(By.id("signin_submit"));
        loginButton.click();

        Thread.sleep(3000);
        System.out.println("Waiting for redirection after login...");

        String expectedUrl = "https://mahendra.vyaparerp.com/dashboard";
        String actualUrl = driver.getCurrentUrl();

        System.out.println("Validating the dashboard URL...");
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("✅ Login successful. Navigated to Dashboard.");
        } else {
            System.out.println("❌ Login failed or wrong navigation. Current URL: " + actualUrl);
        }

        System.out.println("Closing the browser...");
        driver.quit();
    }
}
