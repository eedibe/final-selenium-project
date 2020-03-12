package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import framework.webPages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DarkSky_DailyTemperatureSD {

    HomePage homePage = new HomePage();

    @Given("^That I am Darksky HomePage$")
    public void amIonHomepage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - Broadway, New York, NY", "Invalid Home Page");
    }
    @When("^I expand todays timeline$")
    public void extandDailyTimeLine(){

    }

}
