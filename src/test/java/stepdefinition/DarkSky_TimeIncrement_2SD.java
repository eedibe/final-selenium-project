package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
     public void verifyTimeIncrementedByTwoHours() {

        /**
         * From web -> ["Now" "11am" "1pm" "3pm" "5pm"]
         *
         * using java -> ["Now"]
         *      current time -> Sat Mar 14 09 07 00 AM EST
         *      convert current time using format=ha -> 9am
         *      Adding 2 hours in time -> 11am
         *      Convert time into String -> "11am"
         *      add into arrayList -> ["Now", "11am"]
         *      Adding 2 hours in time -> 1pm
         *      Convert time into String -> "1pm"
         *      add into arrayList -> ["Now", "11am", "1pm", "3pm", "5pm"]
         */
        // get all the time elements in string
        String webElementTimes = SharedSD.getDriver().findElement(By.xpath("//div[@id='timeline']//div[@class='hours']")).getText();

        // seperate the times elements by new line in an array of String
        String[] webElementArray = webElementTimes.split("\\n");

        // create arrayList String webElementTimes
        ArrayList<String> webTimesArrayList = new ArrayList<>();

        // get local time and format the time
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("ha");
        LocalTime localTime = LocalTime.now().plusHours(2);
        String localTimeString = FOMATTER.format(localTime).toLowerCase();
        //create arrayList to store local time
        ArrayList<String> localTimeArrayList= new ArrayList<>();

        //add the string array elements to arraylist //    for(String timeStr : timeStrArray) {
        for(int i = 0; i<webElementArray.length;i++){
            if("Now".equals(webElementArray[i])) {
                continue;
            }
            webTimesArrayList.add(webElementArray[i]);
        }
        System.out.print("Time displayed on darksky webstie is : "+ webTimesArrayList);
        //add local time elements to arraylist same size as webTimesArrayList
        for(int i =0; i<webTimesArrayList.size(); i++){
            localTimeArrayList.add(localTimeString);
            localTime = localTime.plusHours(2);
            localTimeString = FOMATTER.format(localTime).toLowerCase();

        }
        System.out.print("\nLocal time is: "+ localTimeArrayList);
        boolean inOrder = true;
        for(int i= 0; i<webTimesArrayList.size();i++){
            if(webTimesArrayList.equals(localTimeArrayList)){
                inOrder = true;
            }
            else {
                inOrder=false;
                break;
            }
        }

      System.out.println("\nTime line is displayed with 2 hours increment: " + inOrder);

    }

}