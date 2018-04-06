package com.mypackage.am.helpers;

import com.mypackage.am.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Initializer {

    public static WebDriver driver;

    public Initializer() {
        System.setProperty(Constants.System.CHROME_DRIVER  , Constants.DriverVersions.WIN_2_35.getVersion() );
        driver = new ChromeDriver();
    }

}
