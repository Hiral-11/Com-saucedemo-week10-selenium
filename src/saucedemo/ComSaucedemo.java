package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */

public class ComSaucedemo {
    static String browser = "Chrome";
    static String baseUrl =  "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }else {
            System.out.println("Wrong browser name");
        }
        //Open Url
        driver.get(baseUrl);
        //Maximise the page
        driver.manage().window().maximize();
        //Implicit the wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Print the tiltle of page
        System.out.println("The title of the page is: " + driver.getTitle());
        //Print the current Url
        System.out.println("The current URL is: " + driver.getCurrentUrl());
        //Primt page source
        System.out.println("The page source of the current URL is: " + driver.getPageSource());
        //Enter the email to email field
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");
        //Enter the password to password filed
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");
        //Click on login Button
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
        //Print current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());
        //navigate to base url
        driver.navigate().back();
        //Refresh the page
        driver.navigate().refresh();
        //Close the Browser
        driver.close();
    }
}
