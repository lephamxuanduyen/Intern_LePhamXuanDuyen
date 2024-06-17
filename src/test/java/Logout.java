import models.User;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.SeleniumHelper;

public class Logout extends TestBase{
    private LoginPage loginPage = new LoginPage();

    User validUser = new User(validEmail, validPwd);

    @Test(description = "User is redirected to Home page after logging out")
    void TC6(){
        loginPage.login(validUser);
        loginPage.selectTab("Log out");

        SeleniumHelper.verifyEleNoDiplay(By.xpath(String.format(loginPage.tabMenu, "Log out")));
    }
}
