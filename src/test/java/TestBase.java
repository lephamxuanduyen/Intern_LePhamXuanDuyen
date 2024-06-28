import com.beust.jcommander.Parameter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import utils.DriverManagement;

public class TestBase {
//    public static String validEmail = "ihqmosdc@sharklasers.com";
//    protected static String mailName = "ihqmosdc";
//    protected static String mailDomain = "sharklasers.com";
    public static String validEmail = "duyen@grr.la";
    protected static String mailName = "duyen";
    protected static String mailDomain = "grr.la";
    public static String validPwd = "123456789";
    public static String validPid = "12345678";
    public static String emailConfirmInstruction = "thanhletraining03@gmail.com ";

    @BeforeMethod
    @Parameter(names = {"browser"})
    void setup(@Optional("Chrome") String browser) {
        DriverManagement.setup();
    }

    @AfterMethod
    void clean() {
        DriverManagement.quitBrowser();
    }
}
