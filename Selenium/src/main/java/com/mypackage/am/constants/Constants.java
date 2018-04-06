package com.mypackage.am.constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Constants {

    public static class System {

        public static final String CHROME_DRIVER = "webdriver.chrome.driver";
        public static final int DEFAULT_TIMEOUT = 120;


    }

    public static class Paths {

        public static final String PROPERTIES =  "src/main/resources/properties/";

    }

    public enum DriverVersions {
        WIN_2_33("src/main/resources/drivers/chrome/chromedriver_2.33.exe"),
        WIN_2_35("src/main/resources/drivers/chrome/chromedriver_2.35.exe"),
        LINUX_2_33("src/main/resources/drivers/chrome/chromedriver_linux_2.33"),
        UNKNOWN("");

        private String driverVersion;

        DriverVersions(String driverVersion) {
            this.driverVersion = driverVersion;
        }

        public String getVersion() {
            return this.driverVersion;
        }
    }

}



