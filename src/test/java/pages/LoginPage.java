package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Log;
import utilities.SafeActions;

import java.awt.*;


public class LoginPage extends SafeActions {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void verifyLoginPage(String moduleName) {
        String ModuleString = "//span[text()='" + moduleName + "']";

            WebElement module = driver.findElement(By.xpath(ModuleString));
            Assert.assertEquals(safeGetText(module,10), moduleName);
            Log.info(moduleName + " module is available");
    }
    public void userLogin(String userName, String passWord)  {
        WebElement username=driver.findElement(By.id("txtUsername"));
        displayable(username,10);
        safeSendKeys(username,userName,10);
        WebElement password=driver.findElement(By.id("txtPassword"));
        displayable(password,10);
        safeSendKeys(password,passWord,10);
        WebElement login=driver.findElement(By.cssSelector("[type='submit']"));
        safeClick(login,10,"LoginButton");

    }

}