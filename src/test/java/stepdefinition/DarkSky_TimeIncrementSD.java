package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DarkSky_TimeIncrementSD {

    @Given("^I am on Darksky homepage$")
     public void amIonHomepage() {
          Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - Broadway, New York, NY", "Invalid Home Page");

    }


    @Then("^I verify timeline is displayed with two hours incremented$")
     public void verifyTimeIncrementedByTwoHours() {
        // get all the time elements in one string
        String timesString = SharedSD.getDriver().findElement(By.xpath("//div[@id='timeline']//div[@class='hours']")).getText();
       // System.out.print("String elements from expath direcetly : "+ timesString);



        // seperate the times in an array of String
        String[] timeStrArray = timesString.split("\\n");

         // convert the list of time String to a list of Time object, do not add "Now" to the list
        ArrayList<LocalTime> times = new ArrayList<>();

        DateTimeFormatter parser = DateTimeFormatter.ofPattern("h[:mm]a");

        for(String timeStr : timeStrArray) {
            if("Now".equals(timeStr))
                continue;
            LocalTime localTime = LocalTime.parse(timeStr.toUpperCase(), parser);
            times.add(localTime);
        }

        // verify that all the element in your Time list are in 2 hour distance
        LocalTime firstTime = times.get(0);
        boolean inorder = true;
        for(int i = 1; i<times.size();i++){
            firstTime = firstTime.plusHours(2);
            if(firstTime.equals(times.get(i))){
                // everything is peachy and two hours appart
            }
            else{
                // the time is not 2 hours appart
                inorder = false;
                break;
            }
        };
        System.out.println("Is the time 2 hour distance? " + inorder);

    }
}
