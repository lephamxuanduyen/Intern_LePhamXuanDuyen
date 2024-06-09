import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.DriverManagement;

public class TestBase{
    @BeforeTest
     protected static void Setup(){
        WebDriverManager.chromedriver().setup();
        DriverManagement.driver = new ChromeDriver();
        DriverManagement.driver.manage().window().maximize();
    }

    @AfterTest
    protected static void quitBrowser(){
        DriverManagement.driver.quit();
    }
}
