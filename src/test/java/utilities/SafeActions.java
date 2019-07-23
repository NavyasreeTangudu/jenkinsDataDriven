package utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SafeActions {

    public WebDriver driver;
    public SafeActions(WebDriver driver){
        this.driver=driver;
    }
    public void safeClick(WebElement element, double waiting,String s)  {
        try{
            WebDriverWait wait = new WebDriverWait(driver, (long) waiting);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            Log.info(s+" is safely clicked ");
    }catch(StaleElementReferenceException e)
        {
            Log.error("Element is not attached to the page document");
            Assert.fail("Element is not attached to the page document");
        }
        catch (NoSuchElementException e)
        {
            Log.error("Element was not found in time");
            Assert.fail("Element was not found in time");
        }
        catch(Exception e)
        {
            Log.error("Element was not clickable" + " - " + e);
            Assert.fail("Element was not found on the web page");
        }
    }

    public void safeSendKeys(WebElement element,String credential,double waiting)
    {

        try
        {
            WebDriverWait wait = new WebDriverWait(driver, (long) waiting);
            wait.until(ExpectedConditions.visibilityOf(element));
            if(element.isDisplayed())
            {

                element.clear();
                element.sendKeys(credential);
                Log.info("Cleared the field and entered - "+credential+" in the field");
            }
            else
            {
                Log.error("Text " + credential + " to be entered was not found");
                Assert.fail("Text " + credential + " to be entered was not found");
            }
        }
        catch(StaleElementReferenceException e)
        {
            Log.error("Text " + credential + " to be entered is not attached to the page");
            Assert.fail("Text " + credential + " to be entered is not attached to the page");
        }
        catch (NoSuchElementException e)
        {
            Log.error("Element was not found");
            Assert.fail("Element was not found");
        }
        catch(Exception e)
        {
            Log.error("Element was not clickable" + " - " + e);
            Assert.fail("Element was not found on the web page");
        }
    }

    public void displayable(WebElement element,double waiting){

            WebDriverWait wait = new WebDriverWait(driver, (long) waiting);
            wait.until(ExpectedConditions.visibilityOf(element));
            if(element.isDisplayed())
            {
                System.out.println();
            }
            else{
                    Log.error("The element is not displayed");
        }
    }
    public String safeGetText(WebElement element,double waiting){
        String sValue = null;
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, (long) waiting);
            wait.until(ExpectedConditions.visibilityOf(element));
            if(element.isDisplayed())
            {

                sValue = element.getText();
            }
            else
            {
                Assert.fail("Unable to find element ");
            }

        }
        catch(StaleElementReferenceException e)
        {
            Log.error("Element is not attached to the page");
            Assert.fail("Element is not attached to the page");
        }
        catch (NoSuchElementException e)
        {
            Log.error("Element was not found");
            Assert.fail("Element was not found");
        }
        catch(Exception e)
        {
            Log.error("Element was not clickable" + " - " + e);
            Assert.fail("Element was not found on the web page");
        }
        return sValue;
    }

}
