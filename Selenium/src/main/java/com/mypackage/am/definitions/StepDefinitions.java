package com.mypackage.am.definitions;

import com.mypackage.am.helpers.BrowserActionsHelper;
import com.mypackage.am.helpers.Util;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

import static com.mypackage.am.helpers.BrowserActionsHelper.waitForPageLoaded;
import static com.mypackage.am.helpers.Util.log;


public class StepDefinitions {

    @Given("^I open browser$")
    public void iOpenBrowser() {
        BrowserActionsHelper.openBrowser();
    }

    @Given("^I navigate to \"([^\"]*)\"$")
    public void iNavigateTo(String pageName)  {
        log("Navigate", pageName);
        BrowserActionsHelper.openPageByUrl(pageName);
    }

    @And("^I wait for loading page$")
    public void iWaitForLoadingPage() {
        waitForPageLoaded();
    }


    @Then("^I close browser$")
    public void iCloseBrowser() {
        BrowserActionsHelper.closeBrowser();
    }

    @When("^I click on the \"([^\"]*)\" \"([^\"]*)\" on the \"([^\"]*)\" page$")
    public void iClickOnTheOnThePage(String elementName, String elementType, String pageName) throws IOException {
        log("Click", elementName +" "+ elementType, pageName);
        BrowserActionsHelper.click(elementName, elementType, pageName);
    }

    @Then("^I write \"([^\"]*)\" in the \"([^\"]*)\" \"([^\"]*)\" on the \"([^\"]*)\" page$")
    public void iWriteInTheOnThePage(String text, String elementName, String elementType, String pageName) throws IOException {
        log("Write " + text, elementName +" "+ elementType, pageName);
        BrowserActionsHelper.writeToField(text, elementName, elementType, pageName);
    }

    @Then("^I click on the all \"([^\"]*)\" \"([^\"]*)\" on the \"([^\"]*)\" page$")
    public void iClickOnTheAllOnThePage(String elementName, String elementType, String pageName) throws IOException {
        log("Click",elementName +" "+ elementType,pageName);
        BrowserActionsHelper.clickOnElements(elementName, elementType, pageName);
    }



    @Then("^I press \"([^\"]*)\" on the the \"([^\"]*)\" \"([^\"]*)\" on the \"([^\"]*)\" page$")
    public void iPressOnTheTheOnThePage(String key, String elementName, String elementType, String pageName) throws Throwable {
        log(("Press " + key), elementName +" "+ elementType, pageName);
        BrowserActionsHelper.pressKey(key , elementName, elementType, pageName);
    }
}

