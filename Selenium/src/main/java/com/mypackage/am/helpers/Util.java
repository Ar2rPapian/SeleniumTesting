package com.mypackage.am.helpers;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.mypackage.am.constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// STATIC IMPORTS
import java.io.*;
import java.util.Properties;

import static com.mypackage.am.constants.Constants.System.DEFAULT_TIMEOUT;
import static com.mypackage.am.helpers.Initializer.driver;

public class Util {

    public static By getLocator(String key) {
        String method = key.split(":",2)[0];
        String selector = key.split(":",2)[1];

        By locator = null;
        try {

            switch (method) {
                case "id":
                    locator = By.id(selector);
                    break;
                case "cssSelector":
                    locator = By.cssSelector(selector);
                    break;
                case "xpath":
                    locator = By.xpath(selector);
                    break;
                case "tagName":
                    locator = By.tagName(selector);
                    break;
                case "className":
                    locator = By.className(selector);
                    break;
                case "text":
                    locator = By.linkText(selector);
                    break;
                case "name":
                    locator = By.name(selector);
                    break;
                default:

            }
        }catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return locator;
    }

    public static String getLocatorFromProperties(String elementName, String elementType, String pageName) throws IOException {
        StringBuilder key  = new StringBuilder();
        Properties properties = null;
        key.append(elementName.replace(" ","").toLowerCase()).append(".")
                .append(elementType.replace(" ","").toLowerCase());
        properties = new Properties();
        File propertiesFile = new File(String.format("%s%s.properties",Constants.Paths.PROPERTIES ,
                pageName.replace(" ","_")));
        InputStream in = new FileInputStream(propertiesFile);
        properties.load(in);

        return properties.getProperty(String.valueOf(key));
    }

    public static void log(String action, String elementName, String pageName){
        System.out.println("\n");
        System.out.println(String.format("%s on the %s on the '%s' page",action, elementName ,pageName));

    }

    public static void log(String action, String pageName){
        System.out.println("\n");
        System.out.println(String.format("%s to the 'https://%s'",action,pageName));
    }
}

