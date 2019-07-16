package testsuite;

import base.BrowserSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TC_OrangeHrm extends BrowserSetUp{

    @Test(dataProvider="LoginProvider",dataProviderClass = LoginPage.class)
    public void test_DataProviders(String username,String password){

        openApplication("https://orangehrm-demo-6x.orangehrmlive.com/symfony/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin(username, password);
        



    }
}
