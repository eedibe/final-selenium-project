package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HomePageForDarkSky;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class DarkSky_IndividualDayTemperature_3SD extends HomePageForDarkSky {



    @Given("^That I am Darksky HomePage$")
    public void amIonHomepage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - Broadway, New York, NY", "Invalid Home Page");
    }

    @When("^I expand todays timeline$")
    public void extandDailyTimeLine() throws InterruptedException {
        //Scroll down(by pixels)
        JavascriptExecutor jsScrollBy = (JavascriptExecutor) SharedSD.getDriver();
        jsScrollBy.executeScript("scrollBy(0,500);");
        Thread.sleep(3000);
        //calling method to click on expand button
        clickOnexpandPlusButtonDarkSky();
        Thread.sleep(3000);
    }

    @Then("^ Then I verify lowest and highest temp is displayed correctly$")
     public void verifyLowestHighestTempDisplayedCorrectly(){
        //compering temperatures
        Assert.assertEquals(getLowTempDay(),getLowTempDayExtras());
        Assert.assertEquals(getHighTempDay(),getHighDayExtras());

    }



    }


