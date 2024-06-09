package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utils.DriverManagement;

public class BasePage {
    protected static String tabMenu = "//div[@id=\"menu\"]//li//a[span[text()='%s']]";
    private static String Railway;

    public static void openRailway(){
        DriverManagement.driver.get("http://saferailway.somee.com/");
        Railway = DriverManagement.driver.getWindowHandle();
    }

    public static void switchToRailway(){
        DriverManagement.driver.switchTo().window(Railway);
    }

    public static void selectTab(String tabname){
        DriverManagement.driver.findElement(By.xpath(String.format(tabMenu, tabname))).click();
    }

    public static void enterTxt(By xpath, String context){
        DriverManagement.driver.findElement(xpath).sendKeys(context);
    }

    public static void clickElement(By xpath){
        DriverManagement.driver.findElement(xpath).click();
    }
}
