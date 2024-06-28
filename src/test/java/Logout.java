import enums.TabName;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Action;

public class Logout extends TestBase {
    private LoginPage loginPage = new LoginPage();

    User validUser = new User(validEmail, validPwd);

    @Test(description = "User is redirected to Home page after logging out")
    void Logout() {
        loginPage.login(validUser);
        loginPage.selectTab(TabName.LOGOUT);

        Boolean isDisplay = Action.isDisplay(By.xpath(String.format(loginPage.tabMenu, "Log out")));
        Assert.assertFalse(isDisplay);
    }
}
