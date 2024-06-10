package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SeluniumHelper {
    public static void enter(By xpath, String context){
        DriverManagement.driver.findElement(xpath).sendKeys(context);
    }

    public static void click(By xpath){
        DriverManagement.driver.findElement(xpath).click();
    }

    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor) DriverManagement.driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String getText(By xpath){
        return DriverManagement.driver.findElement(xpath).getText();
    }
}
