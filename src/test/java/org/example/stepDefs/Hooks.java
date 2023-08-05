package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;

    @Before
    public static void openBrowser() {

        WebDriverManager.firefoxdriver().setup();

       driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.ayamedica.com/");
    }

    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(4000);
        if (driver != null) {
            driver.quit();

        }
    }
}