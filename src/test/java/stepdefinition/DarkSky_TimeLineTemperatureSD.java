package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.webPages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DarkSky_TimeLineTemperatureSD {
    HomePage homePage = new HomePage();

    @Given("^I am on Darksky Home Page$")
    public void amIonHomePage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - Broadway, New York, NY", "Invalid Home Page");
    }
    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void verifyCurrentTemp() {
        homePage.verifyCurrentTemp();


    }


}
