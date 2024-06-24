package utils;

import base.Config;
import base.PageBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManagement {
    public static WebDriver driver;

    public static void Setup(){
        String browser = Config.getProperty("browser").toLowerCase();
        switch (browser){
            case "chrome":{
                WebDriverManager.chromedriver().setup();
                DriverManagement.driver = new ChromeDriver();
                break;
            }
            case "firefox":{
                WebDriverManager.firefoxdriver().setup();
                DriverManagement.driver = new FirefoxDriver();
                break;
            }
            default:{
                WebDriverManager.chromedriver().setup();
                DriverManagement.driver = new ChromeDriver();
                break;
            }
        }
        DriverManagement.driver.manage().window().maximize();
        PageBase.openRailway();
    }

    public static void quitBrowser(){
        DriverManagement.driver.quit();
    }

    public static WebElement waitElementToBeClickable(By xpath, int second){
        WebDriverWait wait = new WebDriverWait(DriverManagement.driver, Duration.ofSeconds(second));
        return wait.until(ExpectedConditions.elementToBeClickable(xpath));
    }
}
