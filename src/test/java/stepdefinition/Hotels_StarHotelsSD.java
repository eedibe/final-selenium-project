package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.BasePage;
import framework.webPages.HomePageHotels;
import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Hotels_StarHotelsSD {
    HomePageHotels homePage = new HomePageHotels();
    JavascriptExecutor jsScrollBy = (JavascriptExecutor) SharedSD.getDriver();

    @Given("^I am on the default locations search result screen$")
    public void locationSpecialDeals() throws InterruptedException {


        homePage.setInputField("Irvington, New York, United States of America");
        Thread.sleep(2000);
        homePage.closeSign();
        Thread.sleep(2000);
        homePage.clickOnSearch();
        Thread.sleep(2000);
    }

    @When("^I select property class (.*)$")
    public void selectStars(String starRate) {

        switch (starRate) {
            case "5-star":
                homePage.clickOnFiveStar();
                break;
            case "4-star":
                homePage.clickOnFourStar();
                break;
            case "3-star":
                homePage.clickOnThreeStar();
                break;
            case "2-star":
                homePage.clickOnTwoStar();
                break;
            case "1-stars":
                homePage.clickOnOneStar();
                break;
        }
    }

    @Then("^I verify system displays only (.*) hotels on search result$")
    public void hotelsListwithRating(String starRate) throws InterruptedException {

        // starRate = "5-star";

        while (true) {
            try {
                WebElement element = SharedSD.getDriver().findElement(By.xpath("//h3[contains(text(),'Want to see more hotels?')]"));
                ((JavascriptExecutor) SharedSD.getDriver()).executeScript(
                        "arguments[0].scrollIntoView();", element);
                break;
            } catch (Exception ex) {
                jsScrollBy.executeScript("scrollBy(0,4000);");
                Thread.sleep(2000);
            }
        }

        List<WebElement> hotelsStars = SharedSD.getDriver().findElements(By.xpath("//div[@id='listings']//following::li//following::div[contains(@class,'additional-details')]//span[contains(@class,'star-rating')]"));

        List<WebElement> hotelsList = SharedSD.getDriver().findElements(By.xpath("//a[@class='property-name-link']"));
        //  "//div[@id='listings']//h3[@class='p-name']"));

        for (int i = 0; i < hotelsList.size(); i++) {
            System.out.println(hotelsList.get(i).getText()+" is "+ hotelsStars.get(i).getText());
        }
        boolean isStar = true;
        if (starRate.equals(homePage.compareFiveStarRate()) || starRate.equals(homePage.compareFourStarRate()) ||
                starRate.equals(homePage.compareThreeStarRate())) {
            isStar = true;
        } else {
            isStar = false;
            Assert.assertTrue(isStar, "Invalid star rate");

        }

    }
}

