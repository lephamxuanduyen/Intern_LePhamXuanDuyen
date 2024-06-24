package utils;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.MailPage;

import java.util.List;
import java.util.Set;


public class Action {
    public static void enter(By xpath, String context){
        DriverManagement.driver.findElement(xpath).sendKeys(context);
    }

    public static void click(By xpath){
        DriverManagement.driver.findElement(xpath).click();
    }

    public static void scrollToElement(By xpath){
        WebElement element = DriverManagement.driver.findElement(xpath);
        ((JavascriptExecutor) DriverManagement.driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollY(int y){
        ((JavascriptExecutor) DriverManagement.driver).executeScript("window.scrollBy(0, " + y + ");"); // Scroll down y px
    }

    public static String getText(By xpath){
        return DriverManagement.driver.findElement(xpath).getText();
    }

    public static void select(By xpathSelect, String valueOption){
        Select select = new Select(DriverManagement.driver.findElement(xpathSelect));
        select.selectByVisibleText(valueOption);
    }

    public static boolean isDisplay(By xpath){
            List<WebElement> tabs = DriverManagement.driver.findElements(xpath);
            return !tabs.isEmpty() && tabs.get(0).isDisplayed();
    }

    public static void switchOtherTab(MailPage mailPage, PageBase pageBase){
        Set<String> allTabs = DriverManagement.driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(mailPage.tempMailWindow) && !tab.equals(pageBase.RailwayWindow)) {
                DriverManagement.driver.switchTo().window(tab);
                break;
            }
        }
    }
}
