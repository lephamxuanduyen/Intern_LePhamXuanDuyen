package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utils.Constant;
import utils.DriverManagement;

public class BasePage {
    protected static String tabMenu = "//div[@id=\"menu\"]//li//a[span[text()='%s']]";
    protected static String Railway;

    public By xpath_WelcomeUserMessage = By.xpath("//div[@id='banner']//strong");
    public By xpath_MessageProblemLogin = By.xpath("//div[@id='content']/p[contains(@class, 'message error') and following-sibling::form]");

    public static void openRailway(){
        DriverManagement.driver.get(Constant.RailwayUrl);
        Railway = DriverManagement.driver.getWindowHandle();
    }

    public static void switchToRailway(){
        DriverManagement.driver.switchTo().window(Railway);
    }

    public static void selectTab(String tabname){
        DriverManagement.driver.findElement(By.xpath(String.format(tabMenu, tabname))).click();
    }
}
