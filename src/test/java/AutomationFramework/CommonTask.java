package AutomationFramework;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class CommonTask {


    public static void accessDirectLink (WebDriver driver, String URL, WebElement element, String URLname){
        try{
            Log4Test.info("- accessing: " + URLname);
            driver.get(URL);
            Waiting.visibilityOfElement(driver,element, 50, URLname);
        } catch (NoSuchElementException e ){
            Assert.fail(Log4Test.error("Unable to load page"));
        }
    }


    public static void moveToElement(WebDriver driver, WebElement element, String elementName){
        try {
            Actions action = new Actions(driver);
            Log4Test.info("- moving to element : " + elementName);
            action.moveToElement(element).build().perform();
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found"));
        }
    }


    public static void clearElement(WebDriver driver, WebElement element, String field) {
        try {
            Log4Test.info("- clearing field : " + field);
            element.clear();
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found"));
        }
    }

    public static void sendKeys(WebDriver driver, WebElement element, String text, String field){
        try {
            Log4Test.info("- sending keys : '" + text + "' : to " + field);
            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found"));
        }
    }


    public static void getUrl(WebDriver driver, String url){
        Log4Test.info("- navigating to : " + url);
        driver.get(url);
        Waiting.urlPathTobe(driver, url);
    }


    public static void clickElement(WebDriver driver, WebElement element, String elementName){
        try {
            //Waiting for the element to be available
            Waiting.elementToBeClickable(driver, element, elementName);
            //Tap element
            moveToElement(driver, element, elementName);
            Log4Test.info("- clicking element : " + elementName);
            element.click();
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found"));
        }
    }


    public static void setTextField(WebDriver driver, WebElement element, String text, String elementName) {
        //Wait for the field to be available
        Waiting.elementToBeClickable(driver, element, elementName);
        //Enter "item" into the field
        sendKeys(driver, element, text, elementName);
        //Waiting text to be present
        Waiting.textToBePresentInElement(driver, element, text, elementName);
    }

    public static void setInputField(WebDriver driver, WebElement element, String text, String elementName) {
        //Wait for the field to be available
        Waiting.elementToBeClickable(driver, element, elementName);
        //Enter "item" into the field
        sendKeys(driver, element, text, elementName);
    }


    public static String getAttributeAsText(WebElement element, String attribute, String elementName) {
        String stringValueOfAttribute = "";
        try {
            //Get element Attribute
            Log4Test.info("- getting attribute as String for : " + elementName);
            stringValueOfAttribute = element.getAttribute(attribute);
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found : " + elementName));
        }

        return stringValueOfAttribute;
    }

    public static String getText (WebElement element, String elementName) {
        String stringValueOfAttribute = "";
        try {
            //Get element Attribute
            Log4Test.info("- getting text for: " + elementName);
            stringValueOfAttribute = element.getText();
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found : " + elementName));
        }

        return stringValueOfAttribute;
    }


    public static Boolean isElementEnabledAndDisplayed(WebElement element, String elementName){
        try {
            return isDisplayed(element, elementName) && isEnabled(element, elementName);
        } catch (NoSuchElementException e) {
            Log4Test.error("Element is not found : " + elementName);
            return false;
        }
    }

    public static Boolean isEnabled(WebElement element, String elementName){
        try {
            Log4Test.info("- verifying if " + elementName + " is enabled");
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found : " + elementName));
            return false;
        }
    }

    public static Boolean isDisplayed(WebElement element, String elementName){
        try {
            Log4Test.info("- verifying if " + elementName + " is displayed");
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found : " + elementName));
            return false;
        }
    }

    public static String getUrlPath(WebDriver driver) throws MalformedURLException {
        URL url = new URL(driver.getCurrentUrl());
        String path = url.getPath();
        Log4Test.info("- getting URL Path : " + path);
        return path;
    }

    public static String getTitle (WebDriver driver){
        Log4Test.info("- getting Tab name : " + driver.getTitle());
        return driver.getTitle();
    }

}
