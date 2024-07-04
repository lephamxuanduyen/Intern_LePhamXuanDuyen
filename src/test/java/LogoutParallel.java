import base.DataSets;
import base.PageBase;
import enums.TabName;
import io.github.bonigarcia.wdm.WebDriverManager;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.Action;

public class LogoutParallel extends TestBaseParallel {
    private LoginPage loginPage = new LoginPage();

    User validUser = new User(validEmail, validPwd);

    @Test(description = "User is redirected to Home page after logging out", dataProvider = "browserData", dataProviderClass = DataSets.class)
    void Logout(String browser) {
        loginPage.login(validUser);
        loginPage.selectTab(TabName.LOGOUT);

        Boolean isDisplay = Action.isDisplay(By.xpath(String.format(loginPage.tabMenu, "Log out")));
        Assert.assertFalse(isDisplay);
    }
}
