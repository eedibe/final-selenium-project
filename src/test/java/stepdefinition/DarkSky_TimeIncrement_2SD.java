package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class DarkSky_TimeIncrement_2SD {

    @Given("^I am on Darksky homepage$")
     public void amIonHomepage() {
          Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - Broadway, New York, NY", "Invalid Home Page");

    }

    @Then("^I verify timeline is displayed with two hours incremented$")
     public void verifyTimeIncrementedByTwoHours() {
        // get all the time elements in string
        String timesString = SharedSD.getDriver().findElement(By.xpath("//div[@id='timeline']//div[@class='hours']")).getText();

        // seperate the times elements by new line in an array of String
        String[] timeStrArray = timesString.split("\\n");

         // convert the list of time String to a list of Time object, do not add "Now" to the list
        ArrayList<LocalTime> times = new ArrayList<>();

        DateTimeFormatter parser = DateTimeFormatter.ofPattern("h[:mm]a");

        //for(String timeStr : timeStrArray) {
        for(int i = 1; i<timeStrArray.length;i++){
            String timeStr = timeStrArray[i];
            //check if is "Now" then skip to next value
            if("Now".equals(timeStr))
                continue;
            //covernting string to localtime
            LocalTime localTime = LocalTime.parse(timeStr.toUpperCase(), parser);
            //adding time to Localtime arraylist
            times.add(localTime);
        }

        // verify that all the element in your Time list are in 2 hour distance
        LocalTime firstTime = times.get(0);
        boolean inorder = true;
        for(int i = 1; i<times.size();i++){
            firstTime = firstTime.plusHours(2);
            if(firstTime.equals(times.get(i))){
                // timeline is two hours appart

            }
            else{
                // the time is not 2 hours appart
                inorder = false;
                break;
            }
        }
        System.out.println("Time line is displayed with 2 hours increment: " + inorder);

    }
}
