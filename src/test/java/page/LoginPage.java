package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void login(String userName,String passWord)

    {

        WebElement username = driver.findElement(By.id("txtUsername"));
        username.clear();
        username.sendKeys(userName);
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.clear();
        password.sendKeys(passWord);
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        driver.close();
    }

}