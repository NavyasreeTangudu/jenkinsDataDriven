package ExcelExample;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.LoginPage;

public class ExcelDemo {

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver;
        String userName;
        String passWord;
    File file = new File("C:\\Users\\navyasree.tangudu\\IdeaProjects\\orange2\\testData\\ExcelData.xlsx");
    FileInputStream inputStream = new FileInputStream(file);
    Workbook workbook = new XSSFWorkbook(inputStream);
    Sheet excelData = workbook.getSheetAt(0);


      for (int i = 1; i <= excelData.getLastRowNum(); i++) {
          System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
          driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.get("https://orangehrm-demo-6x.orangehrmlive.com/symfony/web/index.php/auth/login");
        Thread.sleep(3000);
        LoginPage loginPage = new LoginPage(driver);
        userName = excelData.getRow(i).getCell(0).getStringCellValue();
        passWord = excelData.getRow(i).getCell(1).getStringCellValue();
        loginPage.login(userName, passWord);
      }
        }}






