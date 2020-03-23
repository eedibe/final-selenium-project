package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.webPages.HomePageHotels;
import org.testng.Assert;


public class Hotels_SpecialDealsSD {
    /*
    1. set the default location for the special deal
    2. get the deal in string format
    3. remove the special character
    4. convert string to interger
    4. set up deal to be less than 200

     */
    HomePageHotels homePage = new HomePageHotels();

    @Given("^I am on default locations search result screen$")
    public void locationSpecialDeals() throws InterruptedException {

        homePage.setInputField("White Plains, New York, United States of America");
        Thread.sleep(2000);
        homePage.closeSign();
        Thread.sleep(2000);
        homePage.clickOnSearch();
        Thread.sleep(2000);
    }
     @Then("^I verify todays deal is less than \\$(\\d+)$")
     public void specialDeal(int price) {
            homePage.getDealofDayPrice();
            String pricestr  = homePage.getDealofDayPrice();
            //convert string to integer and remove first character which is "$"
            int dealPrice = Integer.parseInt(pricestr.substring(1,pricestr.length()));

            Boolean isValid = true;
            if(dealPrice < price){
               // System.out.println("Today's hot deal is $" + dealPrice+"!");
                isValid= true;
             }
            else
                // System.out.println(" Today's hot deal is $200 or more.");
                isValid=false;
                Assert.assertTrue(isValid, "Deal is more then $200");
    }

    }

