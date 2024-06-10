import base.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.DriverManagement;

public class TestBase{
    public static String validEmail = "lephamxuanduyen@gmail.com";
    public static String validPwd = "123456789";

    @BeforeTest
     protected static void Setup(){
        WebDriverManager.chromedriver().setup();
        DriverManagement.driver = new ChromeDriver();
        DriverManagement.driver.manage().window().maximize();
        BasePage basePage = new BasePage();
        BasePage.openRailway();
    }

    @AfterTest
    protected static void quitBrowser(){
        DriverManagement.driver.quit();
    }
}
