package utils;

import base.PageBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class DriverManagement {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static ThreadLocal<String> browser = new ThreadLocal<>();
    private static ThreadLocal<String> target = new ThreadLocal<>();

    public static void setup() throws Exception {
        String browser = getBrowser().toLowerCase();
        String target = getTarget().toLowerCase();

        switch (target) {
            case "local": {
                switch (browser) {
                    case "chrome": {
                        WebDriverManager.chromedriver().setup();
                        driver.set(new ChromeDriver());
                        break;
                    }
                    case "firefox": {
                        WebDriverManager.firefoxdriver().setup();
                        driver.set(new FirefoxDriver());
                        break;
                    }
                    default: {
                        WebDriverManager.chromedriver().setup();
                        driver.set(new ChromeDriver());
                        break;
                    }
                }
                break;
            }
            case "remote": {
                String URL_GRID = "http://localhost:4444";
                switch (browser) {
                    case "chrome":
                        ChromeOptions chromeOptions = new ChromeOptions();
                        driver.set(new RemoteWebDriver(new URL(URL_GRID), chromeOptions));
                        break;
                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        driver.set(new RemoteWebDriver(new URL(URL_GRID), firefoxOptions));
                        break;
                    default:
                        ChromeOptions defaultOptions = new ChromeOptions();
                        driver.set(new RemoteWebDriver(new URL(URL_GRID), defaultOptions));
                        break;
                }
                break;
            }
        }


        DriverManagement.driver.get().manage().window().maximize();
        PageBase.openRailway();
    }

    public static void setBrowser(String browserValue){
        browser.set(browserValue);
    }

    public static void setTarget(String targetValue){
        target.set(targetValue);
    }

    public static String getBrowser(){
        return browser.get();
    }

    public static String getTarget(){
        return target.get();
    }

    public static void quitBrowser() {
        DriverManagement.driver.get().quit();
    }

    public static WebElement waitElementToBeClickable(By xpath, int second) {
        WebDriverWait wait = new WebDriverWait(DriverManagement.driver.get(), Duration.ofSeconds(second));
        return wait.until(ExpectedConditions.elementToBeClickable(xpath));
    }
}