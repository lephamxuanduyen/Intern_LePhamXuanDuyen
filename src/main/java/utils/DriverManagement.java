package utils;

import base.PageBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagement {
    public static WebDriver driver;

    public static void Setup(){
        WebDriverManager.chromedriver().setup();
        DriverManagement.driver = new ChromeDriver();
        DriverManagement.driver.manage().window().maximize();
        PageBase.openRailway();
    }

    public static void quitBrowser(){
        DriverManagement.driver.quit();
    }
}
