package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;


public class DarkSky_TimeIncrement_2SD {

    @Given("^I am on Darksky homepage$")
    public void amIonHomepage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - Broadway, New York, NY", "Invalid Home Page");

    }

    @Then("^I verify timeline is displayed with two hours incremented$")

    public void verifyTimeIncrementedByTwoHours()  {
        String timelinArray = SharedSD.getDriver().findElement(By.xpath("//div[@id='timeline']//div[@class='hours']")).getText();

        Date date = new Date();
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("ha");
        LocalTime now = LocalTime.now();
        String nowTime = FOMATTER.format(now);

        String[] timeArray = timelinArray.split("\n");
        ArrayList<String> time = new ArrayList<>();


        for (int i = 0; i < timeArray.length; i++) {
            if ("Now".equals(timeArray[i]))
                continue;
            time.add(timeArray[i]);
        }
        System.out.println(time);
        ArrayList<String> LocaltimeArraylist = new ArrayList<>();
        // LocaltimeArraylist.add(nowTime);
        LocalTime localTime = LocalTime.now();
        localTime = localTime.plusHours(2);
        String localTimeString = FOMATTER.format(localTime).toLowerCase();

        for (int i = 0; i < time.size(); i++) {
            LocaltimeArraylist.add(localTimeString);
            localTime = localTime.plusHours(2);
            localTimeString = FOMATTER.format(localTime).toLowerCase();
        }
//        boolean inOrder = true;
//        for(int i= 0; i<time.size();i++){
//            if(time.equals(LocaltimeArraylist)){
//                inOrder = true;
//            }
//            else {
//                inOrder=false;
//                break;
//            }
//        }
        Assert.assertEquals(time,LocaltimeArraylist);
        System.out.println("web time "+time);
        System.out.println("local time "+LocaltimeArraylist);
       // System.out.println("time increment "+inOrder);


    }
}