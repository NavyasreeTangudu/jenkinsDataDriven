package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginPage{
    public WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }
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
        return loginCredentials;
    }
    public void verifyLoginPage(){
        WebElement welcomeNote=driver.findElement(By.cssSelector("[id='divLogo']"));
        welcomeNote.isDisplayed();
        System.out.println("Login Page of Orange HRM is displayed");
    }

    public void userLogin(String userName, String passWord){
        WebElement username=driver.findElement(By.id("txtUsername"));
        username.clear();
        username.sendKeys(userName);
        WebElement password=driver.findElement(By.id("txtPassword"));
        username.clear();
        password.sendKeys(passWord);
        WebElement login=driver.findElement(By.cssSelector("[type='submit']"));
        login.click();
    }

}