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


    public void verifyLoginPage(String empId,String name){
    try {
        WebElement myInfoPage = driver.findElement(By.xpath("//span[contains(text(),'My Info')]"));
        safeClick(myInfoPage, 10,"MyInfoPage");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")));
        WebElement verifyName = driver.findElement(By.id("firstName"));
        WebElement verifyId = driver.findElement(By.id("employeeId"));
        Assert.assertTrue(verifyName.getAttribute("value").equals(name));
        Assert.assertTrue(verifyId.getAttribute("value").equals(empId));
        Log.info("The login is validated for the user: "+name);
    }catch (NoSuchElementException e){
        Log.info("There is no MyInfo module for the user");
    } }


    public void userLogin(String userName, String passWord)  {
        WebElement username=driver.findElement(By.id("txtUsername"));
        displayable(username);
        safeSendKeys(username,userName);
        WebElement password=driver.findElement(By.id("txtPassword"));
        displayable(password);
        safeSendKeys(password,passWord);
        WebElement login=driver.findElement(By.cssSelector("[type='submit']"));
        safeClick(login,10,"LoginButton");

    }

}