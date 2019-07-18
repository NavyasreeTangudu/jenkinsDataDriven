package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import java.io.IOException;

public class BrowserSetUp {
    public WebDriver driver;
   @BeforeMethod
   @Parameters({"browser"})
   public void openBrowser(String browserName){

    if (browserName.equals("chrome")) {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }
    else if (browserName.equals("firefox")){
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    else System.out.println("provide proper browserName");

}

    public  void openApplication(String url)  {

        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser(){
       driver.close();
    }

}
