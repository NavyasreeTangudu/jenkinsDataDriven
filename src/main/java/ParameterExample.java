import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class ParameterExample {

        String driverPath = "C:\\geckodriver.exe";
        WebDriver driver;
        @Test
        @Parameters({"author","searchKey"})
        public void testParameter() throws InterruptedException{
            String userName = null;
            String passWord;

            System.setProperty("webdriver.firefox.marionette", driverPath);
            driver= new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("https://orangehrm-demo-6x.orangehrmlive.com/symfony/web/index.php/auth/login");
            WebElement username = driver.findElement(By.id("txtUsername"));
            username.sendKeys(userName);




        }
    }

