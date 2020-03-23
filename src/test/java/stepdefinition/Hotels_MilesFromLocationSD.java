package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HomePageHotels;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Hotels_MilesFromLocationSD {
    HomePageHotels homePage = new HomePageHotels();
    JavascriptExecutor jsScrollBy = (JavascriptExecutor) SharedSD.getDriver();

    @Given("^I am on default location search result screen$")
    public void defaultLocation() throws InterruptedException {
        homePage.setInputField("New York, New York, United States of America");
        Thread.sleep(2000);
        homePage.closeSign();
        Thread.sleep(2000);
        homePage.clickOnSearch();
        Thread.sleep(2000);
    }

    @Then("^I verify system displays all hotels within (.+) miles radius of airport$")
    public void distanceFromLocation(double miles) throws InterruptedException {

        jsScrollBy.executeScript("scrollBy(0,400);");
        Thread.sleep(2000);
        homePage.clickOnLandmark();
        Thread.sleep(2000);
        homePage.checkLandmarkRadioButton();
        Thread.sleep(2000);
        homePage.selectMilesRadius();
        Thread.sleep(3000);
        while (true) {
            try {
                WebElement element = SharedSD.getDriver().findElement(By.xpath("//h3[contains(text(),'Want to see more hotels?')]"));
                ((JavascriptExecutor) SharedSD.getDriver()).executeScript(
                        "arguments[0].scrollIntoView();", element);
                break;
            } catch (Exception ex) {
                jsScrollBy.executeScript("scrollBy(0,7000);");
                // Thread.sleep(2000);
            }
        }

        List<WebElement> radius = SharedSD.getDriver().findElements(By.xpath("//li[contains(text(),'miles to John F. Kennedy International Airport (JFK)')]"));
        List<WebElement> hotels = SharedSD.getDriver().findElements(By.className("property-name-link"));
        for (int i = 0; i < hotels.size(); i++) {
            String[] tokens = radius.get(i).getText().split(" ");
            double milesNum = Double.parseDouble(tokens[0].trim());
            if (milesNum <= miles) {
                System.out.println(hotels.get(i).getText() + " " + radius.get(i).getText());
            }
        }
    }

    @And("^I verify Hilton Hotel is within (.+) radius$")
    public void verifyHotelsIsWithinRadius(double miles ) throws InterruptedException {
        List<WebElement> radius = SharedSD.getDriver().findElements(By.xpath("//li[contains(text(),'miles to John F. Kennedy International Airport (JFK)')]"));
        List<WebElement> hotels = SharedSD.getDriver().findElements(By.className("property-name-link"));
      //  boolean isRadius = true;
        for (int i = 0; i < hotels.size(); i++) {
            String radiusStr= radius.get(i).getText();
            String[] tokens = radius.get(i).getText().split(" ");
            double milesNum = Double.parseDouble(tokens[0].trim());
            if ((hotels.get(i).getText().contains("Hilton") &&
                    radiusStr.contains("John F. Kennedy International Airport")) && (milesNum < miles)) {
               // isRadius = true;
                //System.out.println(isRadius);
                System.out.println("Hiliton hotel is within 10 miles radius form JFK ariort");
                break;
            }
        }

    }
}






