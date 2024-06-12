package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeleniumHelper {
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

    public static void select(String strXpathSelect, String valueOption){
        String strXpathOption = strXpathSelect + "/option[text()='" + valueOption + "']";
        By xpath_select = By.xpath(strXpathSelect);
        By xpath_option = By.xpath(strXpathOption);

        scrollToElement(DriverManagement.driver.findElement(xpath_select));
        click(xpath_select);
        click(xpath_option);
    }

    public static ArrayList<String> getAllValueByRow(By xpath_row){
        ArrayList<String> arr = new ArrayList<String>();
        List<WebElement> itemsOfRow = DriverManagement.driver.findElements(xpath_row);
        for (WebElement i: itemsOfRow){
            arr.add(i.getText());
        }
        return arr;
    }

    public static String getUrl(){
        return DriverManagement.driver.getCurrentUrl();
    }
}
