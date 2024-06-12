package base;

import org.openqa.selenium.By;
import utils.Constant;
import utils.DriverManagement;

public class PageBase {
    protected static String tabMenu = "//div[@id=\"menu\"]//li//a[span[text()='%s']]";
    public static String RailwayWindow;

    public By xpath_WelcomeUserMessage = By.xpath("//div[@id='banner']//strong");
    public By xpath_MessageProblemAccount = By.xpath("//div[@id='content']/p[contains(@class, 'message error') and following-sibling::form]");

    public static void openRailway(){
        DriverManagement.driver.get(Constant.RailwayUrl);
        RailwayWindow = DriverManagement.driver.getWindowHandle();
    }

    public static void switchToRailway(){
        DriverManagement.driver.switchTo().window(RailwayWindow);
    }

    public static void selectTab(String tabname){
        DriverManagement.driver.findElement(By.xpath(String.format(tabMenu, tabname))).click();
    }
}
