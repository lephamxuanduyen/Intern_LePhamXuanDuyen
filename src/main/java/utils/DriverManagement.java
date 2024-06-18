package utils;

import base.Config;
import base.PageBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManagement {
    public static WebDriver driver;

    public static void Setup(){
        String browser = Config.getProperty("railway.url").toLowerCase();
        switch (browser){
            case "chrome":{
                WebDriverManager.chromedriver().setup();
                DriverManagement.driver = new ChromeDriver();
            }
            case "firefox":{
                WebDriverManager.firefoxdriver().setup();
                DriverManagement.driver = new FirefoxDriver();
            }
        }
        DriverManagement.driver.manage().window().maximize();
        PageBase.openRailway();
    }

    public static void quitBrowser(){
        DriverManagement.driver.quit();
    }
}
