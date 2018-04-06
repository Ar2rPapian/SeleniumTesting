package com.mypackage.am.definitions;

import com.mypackage.am.helpers.Initializer;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import org.openqa.selenium.*;

import static com.mypackage.am.helpers.Initializer.driver;

public class Hooks {

    Initializer init = new Initializer();

    public Hooks() {

    }

    @Before
    public void before(Scenario currentScenario) {
        System.out.println("\n");
    }

    @After
    public void after(Scenario currentScenario) {
        System.out.println("\n");
    }

}
