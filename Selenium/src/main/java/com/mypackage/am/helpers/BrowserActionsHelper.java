package com.mypackage.am.helpers;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// STATIC IMPORT
import java.io.IOException;
import java.util.List;

import static com.mypackage.am.constants.Constants.System.DEFAULT_TIMEOUT;
import static com.mypackage.am.helpers.Initializer.driver;
import static com.mypackage.am.helpers.Util.getLocator;


public class BrowserActionsHelper {

    static public void openPageByUrl(String url){
        driver.navigate().to("https://" + url);
    }

    static public void closeBrowser(){
        if(driver != null) {
            driver.quit();
        }
    }

    private static WebElement waitClickableOfElement(By locator){
        (new WebDriverWait(driver, DEFAULT_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator);
    }


    private static List<WebElement> waitClickableOfAllElements(By locator){
        List <WebElement> elements =  (new WebDriverWait(driver, DEFAULT_TIMEOUT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        elements.forEach(element -> {
            new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
        });
        return elements;
    }


    public static void clickOnElements(String elementName, String elementType, String pageName) throws IOException {

        waitClickableOfAllElements(getLocator(Util.getLocatorFromProperties(elementName, elementType, pageName)))
                .forEach((element -> {

                    System.out.println(element.getText());
                }));
    }


    private static WebElement waitVisibilityOfElement(By locator){
        (new WebDriverWait(driver, DEFAULT_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    static public void openBrowser(){
        driver.navigate();
    }

    static public void waitForPageLoaded() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            return;
        }
        for (int i = 0; i < 50; ++i) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static void click(String elementName, String elementType, String pageName) throws IOException {

        waitClickableOfElement(getLocator(Util.getLocatorFromProperties(elementName, elementType, pageName))).click();

    }


    public static void writeToField(String text, String elementName, String elementType, String pageName) throws IOException {

        waitVisibilityOfElement(getLocator(Util.getLocatorFromProperties(elementName, elementType, pageName))).sendKeys(text);
    }

    public static void pressKey(String key, String elementName, String elementType, String pageName) throws IOException {
        waitVisibilityOfElement(getLocator(Util.getLocatorFromProperties(elementName, elementType, pageName))).sendKeys(Keys.valueOf(key.toUpperCase()));
    }

}
