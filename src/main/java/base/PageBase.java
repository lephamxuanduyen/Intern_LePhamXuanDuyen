package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utils.DriverManagement;

public class PageBase {
    public static String tabMenu = "//div[@id=\"menu\"]//li//a[span[text()='%s']]";
    public static String RailwayWindow;
    public String tempMailWindow;

    public By xpath_WelcomeUserMessage = By.xpath("//div[@id='banner']//strong");
    public By xpath_MessageProblemAccount = By.xpath("//div[@id='content']/p[contains(@class, 'message error') and following-sibling::form]");

    public static void openRailway(){
        DriverManagement.driver.get(Config.getProperty("railway.url"));
        RailwayWindow = DriverManagement.driver.getWindowHandle();
    }

    public void openMailPage(){
        DriverManagement.driver.switchTo().newWindow(WindowType.TAB);
        DriverManagement.driver.get(Config.getProperty("tempmail.url"));
        tempMailWindow = DriverManagement.driver.getWindowHandle();
    }

    public static void switchToRailway(){
        DriverManagement.driver.switchTo().window(RailwayWindow);
    }

    public void switchToMailPage(){
        DriverManagement.driver.switchTo().window(tempMailWindow);
    }

    public static void selectTab(String tabname){
        DriverManagement.driver.findElement(By.xpath(String.format(tabMenu, tabname))).click();
    }
}
