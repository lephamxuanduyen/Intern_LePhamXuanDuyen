import base.PageBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.DriverManagement;

public class TestBase{
//    public static String validEmail = "ihqmosdc@sharklasers.com";
//    protected static String mailName = "ihqmosdc";
//    protected static String mailDomain = "sharklasers.com";
    public static String validEmail = "duyen@grr.la";
    protected static String mailName = "duyen";
    protected static String mailDomain = "grr.la";
    public static String validPwd = "123456789";
    public static String validPid = "12345678";
    public static String emailConfirmInstruction = "thanhletraining03@gmail.com ";

    @BeforeTest
     protected static void Setup(){
        WebDriverManager.chromedriver().setup();
        DriverManagement.driver = new ChromeDriver();
        DriverManagement.driver.manage().window().maximize();
        PageBase.openRailway();
    }

    @AfterTest
    protected static void quitBrowser(){
        DriverManagement.driver.quit();
    }
}
