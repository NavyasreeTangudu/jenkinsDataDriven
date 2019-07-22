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
            Log.error("Element is not attached to the page document - StaleElementReferenceException");
            Assert.fail("Element is not attached to the page document - StaleElementReferenceException");
        }
        catch (NoSuchElementException e)
        {
            Log.error("Element was not found in time - NoSuchElementException");
            Assert.fail("Element was not found in time - NoSuchElementException");
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
            if(element.isDisplayed())
            {
                WebDriverWait wait = new WebDriverWait(driver, (long) waiting);

                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.clear();
                element.sendKeys(credential);
                Log.info("Cleared the field and entered - "+credential+" in the field");
            }
            else
            {
                Log.error("Text " + credential + " to be entered after clear the field was not found");
                Assert.fail("Text " + credential + " to be entered after clear the field was not found");
            }
        }
        catch(StaleElementReferenceException e)
        {
            Log.error("Text " + credential + " to be entered is not attached to the page - StaleElementReferenceException");
            Assert.fail("Text " + credential + " to be entered is not attached to the page - StaleElementReferenceException");
        }
        catch (NoSuchElementException e)
        {
            Log.error("Element was not found - NoSuchElementException");
            Assert.fail("Element was not found - NoSuchElementException");
        }
        catch(Exception e)
        {
            Log.error("Element was not clickable" + " - " + e);
            Assert.fail("Element was not found on the web page");
        }
    }

    public void displayable(WebElement element,double waiting){
        if(element.isDisplayed())
        {
            WebDriverWait wait = new WebDriverWait(driver, (long) waiting);

            wait.until(ExpectedConditions.elementToBeClickable(element));

        }
        else{
            Log.error("The element is not displayed");
        }
    }
    public String safeGetText(WebElement element,double waiting){
        String sValue = null;
        try
        {
            if(element.isDisplayed())
            {
                WebDriverWait wait = new WebDriverWait(driver, (long) waiting);

                wait.until(ExpectedConditions.elementToBeClickable(element));
                sValue = element.getText();
            }
            else
            {
                Assert.fail("Unable to find element ");
            }

        }
        catch(StaleElementReferenceException e)
        {
            Log.error("Element is not attached to the page - StaleElementReferenceException");
            Assert.fail("Element is not attached to the page - StaleElementReferenceException");
        }
        catch (NoSuchElementException e)
        {
            Log.error("Element was not found - NoSuchElementException");
            Assert.fail("Element was not found - NoSuchElementException");
        }
        catch(Exception e)
        {
            Log.error("Element was not clickable" + " - " + e);
            Assert.fail("Element was not found on the web page");
        }
        return sValue;
    }

}
