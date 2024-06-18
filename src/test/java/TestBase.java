import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverManagement;

public class TestBase{
    public static String validEmail = "ihqmosdc@sharklasers.com";
    protected static String mailName = "ihqmosdc";
    protected static String mailDomain = "sharklasers.com";
    public static String validPwd = "123456789";
    public static String validPid = "12345678";
    public static String emailConfirmInstruction = "thanhletraining03@gmail.com ";


    @BeforeMethod
    void setup(){
        DriverManagement.Setup();
    }

    @AfterMethod
    void clean(){
        DriverManagement.quitBrowser();
    }
}
