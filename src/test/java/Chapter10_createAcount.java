import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MailPage;
import pages.RegisterPage;
import utils.SeluniumHelper;

public class Chapter10_createAcount extends TestBase{
    private RegisterPage registerPage = new RegisterPage();
    private MailPage mailPage = new MailPage();

    private String activeEmail = "lephamxuanduyen@gmail.com";
    private String pwd = "123456789";
    private String pid = "12345678";
    private String emailConfirmInstruction = "thanhletraining03@gmail.com ";


    @Test
    void TC007(){
        registerPage.register(activeEmail, pwd, pid);

        String expectedResult = "This email address is already in use.";
        String actualResult = SeluniumHelper.getText(registerPage.xpath_MessageProblemLogin);

        Assert.assertEquals(actualResult, expectedResult,"aaa");
    }

//    @Test
//    void TC008(){
//        registerPage.registerWithNoActiveMail(pwd, pid, emailConfirmInstruction);
//        }
//    }
}
