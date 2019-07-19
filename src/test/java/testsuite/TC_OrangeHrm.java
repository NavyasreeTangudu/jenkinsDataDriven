package testsuite;

import base.BrowserSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Log;

public class TC_OrangeHrm extends BrowserSetUp{
    @DataProvider(name="LoginProvider")
    public static Object[][] LoginCredentials(){
        Object[][] loginCredentials = new Object[4][4];

        loginCredentials[0][0] = "admin";
        loginCredentials[0][1] = "admin123";
        loginCredentials[0][2] = "1020";
        loginCredentials[0][3] = "Jacqueline";

        loginCredentials[1][0] = "_ohrmSysAdmin_";
        loginCredentials[1][1] = "sysadmin";
        loginCredentials[1][2] = "";
        loginCredentials[1][3] = "";

        loginCredentials[2][0] = "linda";
        loginCredentials[2][1] = "linda.anderson";
        loginCredentials[2][2] = "1000";
        loginCredentials[2][3] = "Linda";

        loginCredentials[3][0] = "kevin";
        loginCredentials[3][1] = "kevin.mathews";
        loginCredentials[3][2] = "1009";
        loginCredentials[3][3] = "Kevin";
        return loginCredentials;}

    @Test(dataProvider="LoginProvider")
    public void test_DataProviders(String username,String password,String name,String empId) {

        openApplication("https://orangehrm-demo-6x.orangehrmlive.com/symfony/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin(username, password);
        loginPage.verifyLoginPage(name,empId);
        
        



    }
}
