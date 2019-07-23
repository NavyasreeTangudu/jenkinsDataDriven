package testsuite;

import base.BrowserSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Log;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;

public class TC_OrangeHrm extends BrowserSetUp{
    String Admin;
    String System_admin;
    String Linda;
    String Kevin;
    @DataProvider(name="LoginProvider")
    public static Object[][] LoginCredentials(){
        Object[][] loginCredentials = new Object[4][2];

        loginCredentials[0][0] = "admin";
        loginCredentials[0][1] = "admin123";

        loginCredentials[1][0] = "_ohrmSysAdmin_";
        loginCredentials[1][1] = "sysadmin";

        loginCredentials[2][0] = "linda";
        loginCredentials[2][1] = "linda.anderson";

        loginCredentials[3][0] = "kevin";
        loginCredentials[3][1] = "kevin.mathews";

        return loginCredentials;}

    @Test(dataProvider="LoginProvider")
    public void test_DataProviders(String username,String password) throws IOException {

        openApplication("https://orangehrm-demo-6x.orangehrmlive.com/symfony/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin(username, password);
        File file = new File("D:\\new repository2\\jenkinsDataDriven\\src\\test\\java\\utilities\\Book_LoginVerifyData.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet excelData = workbook.getSheetAt(0);
        if (username == "admin"){
            Log.info("verification for the user-"+username+" is started");
            for (int i = 1; i <= excelData.getLastRowNum(); i++) {
                Admin = excelData.getRow(i).getCell(0).getStringCellValue();
                loginPage.verifyLoginPage(Admin);

            }
            Log.info("verification for the user-"+username+" is completed");}
        else if (username == "_ohrmSysAdmin_") {
            Log.info("verification for the user-"+username+" is started");
            for (int i = 1; i <= excelData.getLastRowNum()-1; i++) {
                System_admin = excelData.getRow(i).getCell(1).getStringCellValue();
                loginPage.verifyLoginPage(System_admin);

            }Log.info("verification for the user-"+username+"s completed");}
        else if (username == "linda") {
            Log.info("verification for the user-"+username+" is started");
                for (int i = 1; i <= excelData.getLastRowNum()-3; i++) {
                    Linda = excelData.getRow(i).getCell(2).getStringCellValue();
                    loginPage.verifyLoginPage(Linda);

                }Log.info("verification for the user-"+username+" is completed");
        }else{
            Log.info("verification for the user-"+username+" is started");
            for (int i = 1; i <= excelData.getLastRowNum()-1; i++) {
                Kevin = excelData.getRow(i).getCell(3).getStringCellValue();
                loginPage.verifyLoginPage(Kevin);

            }Log.info("verification for the user-"+username+" is completed");
        }

    }}