package parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParameterExample {
    @Test
    @Parameters({"userName","passWord"})
    public void testParameter(String userName,String passWord) throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/symfony/web/index.php/auth/login");
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