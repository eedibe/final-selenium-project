package stepdefinition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.webPages.HomePageForDarkSky;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;

public class DarkSky_TimeLineTemperatureinBetweenLowandHigh_1SD extends HomePageForDarkSky {

    @Given("^I am on Darksky Home Page$")
    public void amIonHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - Broadway, New York, NY", "Invalid Home Page");
    }

    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
        public void verifyCurrentTempNotGreaterOrLessDailyTimeline() {
            //getting current temperature from webpage using xpath
            String todaysCurrentTemperature = SharedSD.getDriver().findElement(By.xpath("//span[@class='summary swap']")).getText();
            String subsTodayCurrentTemperatue = todaysCurrentTemperature.substring(0,todaysCurrentTemperature.indexOf('˚'));
            int todaysCurrentTemp = Integer.parseInt(subsTodayCurrentTemperatue);
            System.out.println("Current temperatue is "+todaysCurrentTemp+"°");

             // get all elements from website by string  xpath
            String allElementsOfTempInString = SharedSD.getDriver().findElement(By.xpath("//div[@id='timeline']//div[@class='temps']")).getText();
            // seperate the temperature in an array of String
            String[] tempStrArray = allElementsOfTempInString.split("\\n");
            // create a new array of int
            ArrayList<Integer> temperature = new ArrayList<Integer>();
            //remove the  special character in each temperature element of the array
            for (int i = 0; i < tempStrArray.length; i++) {
                tempStrArray[i] = tempStrArray[i].substring(0, tempStrArray[i].indexOf('°'));
                // convert and copy the strings in string temperature array to integer temperature array
                temperature.add(Integer.parseInt(tempStrArray[i]));

            }

            //sort the array from min to max
            Collections.sort(temperature);
            // find the min in integer array
            System.out.println("Minimum temerature is "+ temperature.get(0)+"°");
            int minNum = temperature.get(0);
            //  // find the max in integer array
            System.out.println("Maximum temperature is " +temperature.get(temperature.size()-1) +"°");
            int maxNum = temperature.get(temperature.size()-1);
            if(todaysCurrentTemp>minNum && todaysCurrentTemp<maxNum){
                System.out.println("Current temperature is not greater or less then daily timeline temperature");
            }
            else{
                System.out.println("Current temperature is greater or less then dialy timeline temperature");

            }

        }

    }















