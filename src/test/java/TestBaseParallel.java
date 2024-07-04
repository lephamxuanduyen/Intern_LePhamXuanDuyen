import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverManagement;

public class TestBaseParallel {
    public static String validEmail = "duyen@grr.la";
    protected static String mailName = "duyen";
    protected static String mailDomain = "grr.la";
    public static String validPwd = "123456789";
    public static String validPid = "12345678";
    public static String emailConfirmInstruction = "thanhletraining03@gmail.com ";

    @BeforeMethod
    void setup(Object[] params) throws Exception{
        String browser = (String) params[0];
        DriverManagement.setBrowser(browser);
        DriverManagement.setTarget("local");
        DriverManagement.setup();
    }

    @AfterMethod
    void clean() {
        DriverManagement.quitBrowser();
    }
}
